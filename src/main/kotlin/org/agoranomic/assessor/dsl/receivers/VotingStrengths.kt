package org.agoranomic.assessor.dsl.receivers

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.toImmutableMap
import org.agoranomic.assessor.dsl.AssessmentDSL
import org.agoranomic.assessor.lib.*

@AssessmentDSL
class ProposalStrengthReceiver(val globalStrengths: ImmutableMap<Person, VotingStrength>) {
    constructor(globalStrengths: Map<Person, VotingStrength>) : this(globalStrengths.toImmutableMap())

    val strengthMap = mutableMapOf<Person, VotingStrength>()

    infix fun Person.strength(value: Int) {
        require(!strengthMap.containsKey(this)) { "Cannot set strength when it has already been set" }
        strengthMap[this] = VotingStrength(value)
    }

    infix fun Person.add(value: VotingStrength) {
        if (!strengthMap.containsKey(this)) strengthMap[this] = globalStrengths.getOrFail(this)
        strengthMap[this] = strengthMap.getOrFail(this) + value
    }

    infix fun Person.add(value: Int) = this add VotingStrength(value)

    fun compile(): Map<Person, VotingStrengthWithComment> {
        return strengthMap.mapValues { (_, v) -> VotingStrengthWithComment(v) }
    }
}

@AssessmentDSL
class _VotingStrengthReceiver(val proposals: ImmutableList<Proposal>) {
    private var defaultStrength: VotingStrength? = null
    private var globalStrengths = mutableMapOf<Person, _MutableVotingStrength>()
    private var overrideStrengthBlocks = mutableMapOf<ProposalNumber, ProposalStrengthReceiver.() -> Unit>()

    data class _MutableVotingStrength(val value: VotingStrength, var comment: String? = null) {
        fun compile() = VotingStrengthWithComment(value, comment)
    }

    infix fun Person.strength(votingStrength: VotingStrength): _MutableVotingStrength {
        val strength = _MutableVotingStrength(votingStrength)
        globalStrengths[this] = strength
        return strength
    }

    infix fun Person.strength(votingStrength: RawVotingStrength) = this.strength(VotingStrength(votingStrength))
    infix fun Person.strength(votingStrength: Int) = this.strength(VotingStrength(votingStrength))

    infix fun _MutableVotingStrength.comment(value: String) {
        this.comment = value
    }

    fun proposal(number: ProposalNumber, block: ProposalStrengthReceiver.() -> Unit) {
        require(!overrideStrengthBlocks.containsKey(number))
        overrideStrengthBlocks[number] = block
    }

    fun proposal(number: Int, block: ProposalStrengthReceiver.() -> Unit) = proposal(ProposalNumber(number), block)

    fun default(strength: VotingStrength) {
        this.defaultStrength = strength
    }

    fun default(strength: RawVotingStrength) = default(VotingStrength(strength))
    fun default(strength: Int) = default(VotingStrength(strength))

    fun compile(): Map<ProposalNumber, VotingStrengthMap> {
        val defaultStrength = defaultStrength ?: error("Must specify default voting strength")
        val globalStrengths = globalStrengths.mapValues { (_, strength) -> strength.compile() }
        val globalStrengthMap = SimpleVotingStrengthMap(defaultStrength, globalStrengths)

        return proposals.map { it.number }.associateWith { proposal ->
            val proposalStrengthReceiver = ProposalStrengthReceiver(globalStrengths.mapValues { (_, v) -> v.value })
            val block = overrideStrengthBlocks[proposal]

            if (block != null) {
                proposalStrengthReceiver.block()
                OverrideVotingStrengthMap(globalStrengthMap, proposalStrengthReceiver.compile())
            } else {
                globalStrengthMap
            }
        }
    }
}
