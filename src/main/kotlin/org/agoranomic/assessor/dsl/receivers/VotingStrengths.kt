package org.agoranomic.assessor.dsl.receivers

import org.agoranomic.assessor.dsl.*
import org.agoranomic.assessor.lib.*
import org.agoranomic.assessor.lib.proposal_set.ImmutableProposalSet
import org.agoranomic.assessor.lib.proposal_set.ProposalSet
import org.agoranomic.assessor.lib.proposal_set.toImmutableProposalSet
import org.agoranomic.assessor.lib.util.getOrFail

@AssessmentDSL
interface ProposalVotingStrengthReceiver {
    infix fun Person.strength(value: VotingStrength)
    infix fun Person.strength(value: Int) = strength(VotingStrength(value))

    infix fun Person.add(value: VotingStrength)
    infix fun Person.add(value: Int) = add(VotingStrength(value))
}

typealias ProposalVotingStrengthReceiverInit = DslInit<ProposalVotingStrengthReceiver>

@AssessmentDSL
private class ProposalVotingStrengthReceiverImpl(val globalStrengths: VotingStrengthMap) : ProposalVotingStrengthReceiver {
    val strengthMap = mutableMapOf<Person, VotingStrength>()

    override infix fun Person.strength(value: VotingStrength) {
        require(!strengthMap.containsKey(this)) { "Cannot set strength when it has already been set" }
        strengthMap[this] = value
    }

    override infix fun Person.add(value: VotingStrength) {
        if (!strengthMap.containsKey(this)) strengthMap[this] = globalStrengths[this].value
        strengthMap[this] = strengthMap.getOrFail(this) + value
    }

    fun compile(): Map<Person, VotingStrengthWithComment> {
        return strengthMap.mapValues { (_, v) -> VotingStrengthWithComment(v) }
    }
}

fun buildProposalVotingStrength(globalStrengths: VotingStrengthMap, block: ProposalVotingStrengthReceiverInit): Map<Person, VotingStrengthWithComment> {
    return ProposalVotingStrengthReceiverImpl(globalStrengths).also(block).compile()
}

interface VotingStrengthCommentable {
    infix fun comment(comment: String)
}

@AssessmentDSL
interface GlobalVotingStrengthReceiver {
    val allProposals: ProposalSet

    infix fun Person.strength(votingStrength: VotingStrength): VotingStrengthCommentable
    infix fun Person.strength(votingStrength: Int) = strength(VotingStrength(votingStrength))

    infix fun Person.add(amount: VotingStrength)
    infix fun Person.add(amount: Int) = add(VotingStrength(amount))

    fun proposal(number: ProposalNumber, block: ProposalVotingStrengthReceiverInit)
    fun default(strength: VotingStrength)
    fun default(strength: Int) = default(VotingStrength(strength))
}

typealias GlobalVotingStrengthReceiverInit = DslInit<GlobalVotingStrengthReceiver>

@AssessmentDSL
private class GlobalVotingStrengthReceiverImpl(private val proposals: ImmutableProposalSet) : GlobalVotingStrengthReceiver {
    constructor(proposals: ProposalSet) : this(proposals.toImmutableProposalSet())

    override val allProposals get() = proposals

    private var defaultStrength = DslValue<VotingStrength>()
    private var globalStrengths = mutableMapOf<Person, MutableVotingStrength>()
    private var overrideStrengthBlocks = DslValueMap<ProposalNumber, ProposalVotingStrengthReceiverInit>()

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

    override fun proposal(number: ProposalNumber, block: ProposalVotingStrengthReceiverInit) {
        require(!overrideStrengthBlocks.containsKey(number))
        overrideStrengthBlocks[number] = block
    }

    override fun default(strength: VotingStrength) {
        defaultStrength.set(strength)
    }

    fun compile(): Map<ProposalNumber, VotingStrengthMap> {
        val defaultStrength = defaultStrength.get()
        val globalStrengths = globalStrengths.mapValues { (_, strength) -> strength.compile() }
        val globalStrengthMap = SimpleVotingStrengthMap(defaultStrength, globalStrengths)

        return proposals.map { it.number }.associateWith { proposal ->
            val block = overrideStrengthBlocks.getOrNull(proposal)

            if (block != null) {
                OverrideVotingStrengthMap(globalStrengthMap, buildProposalVotingStrength(globalStrengthMap, block))
            } else {
                globalStrengthMap
            }
        }
    }
}

fun buildGlobalVotingStrength(proposals: ProposalSet, block: GlobalVotingStrengthReceiverInit): Map<ProposalNumber, VotingStrengthMap> {
    return GlobalVotingStrengthReceiverImpl(proposals).also(block).compile()
}
