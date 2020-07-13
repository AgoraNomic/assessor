package org.agoranomic.assessor.dsl.receivers

import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.toImmutableMap
import org.agoranomic.assessor.dsl.AssessmentDsl
import org.agoranomic.assessor.dsl.detail.DslInit
import org.agoranomic.assessor.dsl.detail.SetOnce
import org.agoranomic.assessor.dsl.detail.getOrNull
import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.proposal.ProposalNumber
import org.agoranomic.assessor.lib.proposal.proposal_set.ImmutableProposalSet
import org.agoranomic.assessor.lib.proposal.proposal_set.ProposalSet
import org.agoranomic.assessor.lib.proposal.proposal_set.toImmutableProposalSet
import org.agoranomic.assessor.lib.voting_strength.*

@AssessmentDsl
interface GeneralVotingStrengthReceiver {
    infix fun Person.add(value: VotingStrengthDifference): VotingStrengthDescribable
    infix fun Person.add(value: Int) = add(VotingStrengthDifference(value))

    infix fun Person.subtract(value: VotingStrengthDifference): VotingStrengthDescribable
    infix fun Person.subtract(value: Int) = subtract(VotingStrengthDifference(value))
}

@AssessmentDsl
interface ProposalVotingStrengthReceiver : GeneralVotingStrengthReceiver

typealias ProposalVotingStrengthReceiverInit = DslInit<ProposalVotingStrengthReceiver>

interface ProposalVotingStrengthCompiler {
    /**
     * Given [globalStrengths], returns the strengths for the specific proposal, which should include the trail from the
     * global as a prefix.
     */
    fun compile(
        globalStrengths: VotingStrengthTrailForPersons,
        init: ProposalVotingStrengthReceiverInit
    ): VotingStrengthTrailForPersons
}

private class VotingStrengthTrailForPersonsBuilder {
    private data class MutableStrengthAddition(
        val amount: VotingStrengthDifference,
        var description: VotingStrengthModificationDescription? = null
    ) {
        fun compile() =
            AdditiveVotingStrengthModification(
                amount,
                description
                    ?: AdditiveVotingStrengthModification.defaultDescriptionFor(
                        amount
                    )
            )
    }

    private class VotingStrengthDescribableImpl(private val data: MutableStrengthAddition) : VotingStrengthDescribable {
        override fun describedAs(description: VotingStrengthModificationDescription) {
            check(data.description == null)
            data.description = description
        }
    }

    private val newModifications = mutableMapOf<Person, MutableList<MutableStrengthAddition>>()

    fun addToPerson(person: Person, value: VotingStrengthDifference): VotingStrengthDescribable {
        val list = newModifications.computeIfAbsent(person) { mutableListOf() }

        val strengthAddition = MutableStrengthAddition(value)
        list.add(strengthAddition)

        return VotingStrengthDescribableImpl(strengthAddition)
    }

    fun compile(initialTrails: VotingStrengthTrailForPersons): VotingStrengthTrailForPersons {
        val knownPersons = initialTrails.overriddenPersons union newModifications.keys

        return VotingStrengthTrailForPersons(
            initialTrails.default,
            knownPersons.associateWith { person ->
                initialTrails
                    .trailForPerson(person)
                    .withAppended(
                        newModifications
                            .getOrElse(person) { mutableListOf() }
                            .map { modification -> modification.compile() }
                    )
            }
        )
    }
}

@AssessmentDsl
private class DefaultProposalVotingStrengthReceiver(
    private val globalStrengths: VotingStrengthTrailForPersons
) : ProposalVotingStrengthReceiver {
    private val builder = VotingStrengthTrailForPersonsBuilder()

    override infix fun Person.add(value: VotingStrengthDifference): VotingStrengthDescribable {
        return builder.addToPerson(this, value)
    }

    override fun Person.subtract(value: VotingStrengthDifference) = add(-value)

    fun compile(): VotingStrengthTrailForPersons {
        return builder.compile(globalStrengths)
    }
}

class DefaultProposalVotingStrengthCompiler : ProposalVotingStrengthCompiler {
    override fun compile(
        globalStrengths: VotingStrengthTrailForPersons,
        init: ProposalVotingStrengthReceiverInit
    ): VotingStrengthTrailForPersons {
        return DefaultProposalVotingStrengthReceiver(globalStrengths).also(init).compile()
    }
}

interface VotingStrengthDescribable {
    infix fun describedAs(description: VotingStrengthModificationDescription)
}

@AssessmentDsl
interface GlobalVotingStrengthReceiver : GeneralVotingStrengthReceiver {
    val allProposals: ProposalSet

    fun proposal(number: ProposalNumber, block: ProposalVotingStrengthReceiverInit)

    fun default(strength: VotingStrength)
    fun default(strength: Int) = default(VotingStrength(strength))

    fun min(strength: VotingStrength)
    fun min(strength: Int) = min(VotingStrength(strength))

    fun max(strength: VotingStrength)
    fun max(strength: Int) = max(VotingStrength(strength))
}

fun GlobalVotingStrengthReceiver.proposal(number: Int, block: ProposalVotingStrengthReceiverInit) =
    proposal(ProposalNumber(number), block)

typealias GlobalVotingStrengthReceiverInit = DslInit<GlobalVotingStrengthReceiver>

interface GlobalVotingStrengthCompiler {
    fun compile(
        allProposals: ProposalSet,
        init: GlobalVotingStrengthReceiverInit
    ): ImmutableMap<ProposalNumber, VotingStrengthTrailForPersons>
}

@AssessmentDsl
private class DefaultGlobalVotingStrengthReceiver(
    private val proposalStrengthCompiler: ProposalVotingStrengthCompiler,
    private val proposals: ImmutableProposalSet
) : GlobalVotingStrengthReceiver {
    constructor(
        proposalStrengthCompiler: ProposalVotingStrengthCompiler,
        proposals: ProposalSet
    ) : this(
        proposalStrengthCompiler,
        proposals.toImmutableProposalSet()
    )

    override val allProposals get() = proposals

    private val defaultStrength = SetOnce.namedOf<VotingStrength>("default voting strength")
    private val minStrength = SetOnce.namedOf<VotingStrength>("min voting strength")
    private val maxStrength = SetOnce.namedOf<VotingStrength>("max voting strength")

    private val globalStrengthBuilder = VotingStrengthTrailForPersonsBuilder()
    private val overrideStrengthBlocks = mutableMapOf<ProposalNumber, ProposalVotingStrengthReceiverInit>()

    override fun Person.add(amount: VotingStrengthDifference): VotingStrengthDescribable {
        return globalStrengthBuilder.addToPerson(this, amount)
    }

    override fun Person.subtract(amount: VotingStrengthDifference) = add(-amount)

    override fun proposal(number: ProposalNumber, block: ProposalVotingStrengthReceiverInit) {
        // The outer {}s delimit a lambda returning the default value. The inner braces {} delimit the lambda that
        // is the default value.
        val oldBlock = overrideStrengthBlocks.getOrElse(number) { {} }

        overrideStrengthBlocks[number] = {
            oldBlock()
            block()
        }
    }

    override fun default(strength: VotingStrength) {
        defaultStrength.set(strength)
    }

    override fun min(strength: VotingStrength) {
        minStrength.set(strength)
    }

    override fun max(strength: VotingStrength) {
        maxStrength.set(strength)
    }

    fun compile(): ImmutableMap<ProposalNumber, VotingStrengthTrailForPersons> {
        val defaultStrength = defaultStrength.get()
        val minStrength = minStrength.getOrNull()
        val maxStrength = maxStrength.getOrNull()

        val globalStrengths =
            globalStrengthBuilder.compile(VotingStrengthTrailForPersons.emptyWithDefault(defaultStrength))

        return proposals
            .map { it.number }
            .associateWith { proposal ->
                val block = overrideStrengthBlocks[proposal]

                val beforeClamp =
                    if (block != null)
                        proposalStrengthCompiler.compile(globalStrengths, block)
                    else
                        globalStrengths

                val clampModification = ClampVotingStrengthModification(minStrength, maxStrength)

                beforeClamp.withAppendedToAll(clampModification)
            }
            .toImmutableMap()
    }
}

class DefaultGlobalVotingStrengthCompiler(
    private val proposalStrengthCompiler: ProposalVotingStrengthCompiler = DefaultProposalVotingStrengthCompiler()
) : GlobalVotingStrengthCompiler {
    override fun compile(
        allProposals: ProposalSet,
        init: GlobalVotingStrengthReceiverInit
    ): ImmutableMap<ProposalNumber, VotingStrengthTrailForPersons> {
        return DefaultGlobalVotingStrengthReceiver(proposalStrengthCompiler, allProposals).also(init).compile()
    }
}
