package org.agoranomic.assessor.dsl.receivers

import io.github.random_internet_cat.util.getOrFail
import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.toImmutableMap
import org.agoranomic.assessor.dsl.*
import org.agoranomic.assessor.dsl.ministries.OfficeMap
import org.agoranomic.assessor.dsl.ministries.OfficeState
import org.agoranomic.assessor.lib.*
import org.agoranomic.assessor.lib.proposal_set.ImmutableProposalSet
import org.agoranomic.assessor.lib.proposal_set.ProposalSet
import org.agoranomic.assessor.lib.proposal_set.toImmutableProposalSet

@AssessmentDsl
interface ProposalVotingStrengthReceiver {
    infix fun Person.strength(value: VotingStrength)
    infix fun Person.strength(value: Int) = strength(VotingStrength(value))

    infix fun Person.add(value: VotingStrength)
    infix fun Person.add(value: Int) = add(VotingStrength(value))

    infix fun Person.subtract(value: VotingStrength)
    infix fun Person.subtract(value: Int) = subtract(VotingStrength(value))
}

typealias ProposalVotingStrengthReceiverInit = DslInit<ProposalVotingStrengthReceiver>

interface ProposalVotingStrengthCompiler {
    fun compile(
        globalStrengths: VotingStrengthMap,
        init: ProposalVotingStrengthReceiverInit
    ): ImmutableMap<Person, VotingStrengthWithComment>
}

@AssessmentDsl
private class DefaultProposalVotingStrengthReceiver(val globalStrengths: VotingStrengthMap) : ProposalVotingStrengthReceiver {
    val strengthMap = mutableMapOf<Person, VotingStrength>()

    override infix fun Person.strength(value: VotingStrength) {
        require(!strengthMap.containsKey(this)) { "Cannot set strength when it has already been set" }
        strengthMap[this] = value
    }

    override infix fun Person.add(value: VotingStrength) {
        if (!strengthMap.containsKey(this)) strengthMap[this] = globalStrengths[this].value
        strengthMap[this] = strengthMap.getOrFail(this) + value
    }

    override fun Person.subtract(value: VotingStrength) {
        add(-value)
    }

    fun compile(): ImmutableMap<Person, VotingStrengthWithComment> {
        return strengthMap.mapValues { (_, v) -> VotingStrengthWithComment(v) }.toImmutableMap()
    }
}

class DefaultProposalVotingStrengthCompiler : ProposalVotingStrengthCompiler {
    override fun compile(
        globalStrengths: VotingStrengthMap,
        init: ProposalVotingStrengthReceiverInit
    ): ImmutableMap<Person, VotingStrengthWithComment> {
        return DefaultProposalVotingStrengthReceiver(globalStrengths).also(init).compile()
    }
}

interface VotingStrengthCommentable {
    infix fun comment(comment: String)
}

@AssessmentDsl
interface GlobalVotingStrengthReceiver {
    val allProposals: ProposalSet

    infix fun Person.strength(votingStrength: VotingStrength): VotingStrengthCommentable
    infix fun Person.strength(votingStrength: Int) = strength(VotingStrength(votingStrength))

    infix fun Person.add(amount: VotingStrength)
    infix fun Person.add(amount: Int) = add(VotingStrength(amount))

    infix fun Person.subtract(amount: VotingStrength)
    infix fun Person.subtract(amount: Int) = subtract(VotingStrength(amount))

    fun proposal(number: ProposalNumber, block: ProposalVotingStrengthReceiverInit)

    fun default(strength: VotingStrength)
    fun default(strength: Int) = default(VotingStrength(strength))

    fun min(strength: VotingStrength)
    fun min(strength: Int) = min(VotingStrength(strength))

    fun max(strength: VotingStrength)
    fun max(strength: Int) = max(VotingStrength(strength))
}

typealias GlobalVotingStrengthReceiverInit = DslInit<GlobalVotingStrengthReceiver>

interface GlobalVotingStrengthCompiler {
    fun compile(allProposals: ProposalSet, init: GlobalVotingStrengthReceiverInit): ImmutableMap<ProposalNumber, ImmutableVotingStrengthMap>
}

fun <Office : Enum<Office>> GlobalVotingStrengthReceiver.addToHolder(
    officeMap: OfficeMap<Office>,
    office: Office,
    strength: VotingStrength
) = when (val officeState = officeMap[office]) {
    is OfficeState.Vacant -> {
        /* do nothing, no holder */
    }

    is OfficeState.Held -> {
        officeState.holder add strength
    }
}

fun <Office : Enum<Office>> GlobalVotingStrengthReceiver.addToHolder(
    officeMap: OfficeMap<Office>,
    office: Office,
    strength: Int
) = addToHolder(
    officeMap = officeMap,
    office = office,
    strength = VotingStrength(strength)
)

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

    private val defaultStrength = DslValue.namedOf<VotingStrength>("default voting strength")
    private val minStrength = DslValue.namedOf<VotingStrength>("min voting strength")
    private val maxStrength = DslValue.namedOf<VotingStrength>("max voting strength")

    private val globalStrengths = mutableMapOf<Person, MutableVotingStrength>()
    private val overrideStrengthBlocks = DslValueMap<ProposalNumber, ProposalVotingStrengthReceiverInit>()

    private data class MutableVotingStrength(
        val value: VotingStrength,
        var comment: String? = null
    ) : VotingStrengthCommentable {
        override fun comment(comment: String) {
            this.comment = comment
        }

        fun compile() = VotingStrengthWithComment(value, comment)
    }

    private fun setDefaultIfAbsent(person: Person) {
        if (!globalStrengths.containsKey(person)) globalStrengths[person] = MutableVotingStrength(defaultStrength.get())
    }

    override infix fun Person.strength(votingStrength: VotingStrength): VotingStrengthCommentable {
        require(!globalStrengths.containsKey(this)) { "Voting strength specified twice for player ${this.name}" }

        val strength = MutableVotingStrength(votingStrength)
        globalStrengths[this] = strength
        return strength
    }

    override fun Person.add(amount: VotingStrength) {
        setDefaultIfAbsent(this)
        globalStrengths[this] = MutableVotingStrength(globalStrengths.getOrFail(this).value + amount)
    }

    override fun Person.subtract(amount: VotingStrength) {
        add(-amount)
    }

    override fun proposal(number: ProposalNumber, block: ProposalVotingStrengthReceiverInit) {
        require(!overrideStrengthBlocks.containsKey(number))
        overrideStrengthBlocks[number] = block
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

    fun compile(): ImmutableMap<ProposalNumber, ImmutableVotingStrengthMap> {
        val defaultStrength = defaultStrength.get()
        val minStrength = minStrength.getOrNull()
        val maxStrength = maxStrength.getOrNull()

        val globalStrengths = globalStrengths.mapValues { (_, strength) -> strength.compile() }
        val globalStrengthMap = SimpleVotingStrengthMap(defaultStrength, globalStrengths)

        return proposals.map { it.number }.associateWith { proposal ->
            val block = overrideStrengthBlocks.getOrNull(proposal)

            val baseMap =
                if (block != null) {
                    OverrideVotingStrengthMap(
                        globalStrengthMap,
                        proposalStrengthCompiler.compile(globalStrengthMap, block)
                    )
                } else {
                    globalStrengthMap
                }

            // Voting strength caps take precedence, so apply them after proposal overrides.
            // If min or max is null (i.e. not provided by the init block), then there will be no cap, and it will
            // preserve the original behavior.
            CappedVotingStrengthMap(
                base = baseMap,
                min = minStrength,
                max = maxStrength
            )
        }.toImmutableMap()
    }
}

class DefaultGlobalVotingStrengthCompiler(
    private val proposalStrengthCompiler: ProposalVotingStrengthCompiler = DefaultProposalVotingStrengthCompiler()
) : GlobalVotingStrengthCompiler {
    override fun compile(allProposals: ProposalSet, init: GlobalVotingStrengthReceiverInit): ImmutableMap<ProposalNumber, ImmutableVotingStrengthMap> {
        return DefaultGlobalVotingStrengthReceiver(proposalStrengthCompiler, allProposals).also(init).compile()
    }
}
