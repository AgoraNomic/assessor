package org.agoranomic.assessor.lib.dsl_detail

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import org.agoranomic.assessor.lib.*

@AssessmentDSL
class _VotesReceiver(private val proposals: ImmutableList<ProposalNumber>) {
    constructor(proposals: List<ProposalNumber>) : this(proposals.toImmutableList())

    private val votes = mutableMapOf<ProposalNumber, _MutableVote>()

    object _All
    val all = _All

    object _Others
    val others = _Others

    data class _MutableVote(val vote: VoteFunc, var comment: String? = null) {
        fun compile() = PendingVote(vote, comment)
    }

    private fun addVote(proposal: ProposalNumber, vote: _MutableVote): _MutableVote {
        require(proposals.contains(proposal)) { "No such proposal $proposal" }
        require(!votes.containsKey(proposal)) { "Vote already specified for proposal $proposal" }

        votes[proposal] = vote
        return vote
    }

    private fun addVote(proposal: ProposalNumber, vote: HalfFunctionVote) = addVote(proposal, _MutableVote(vote.func))

    infix fun HalfFunctionVote.on(proposal: ProposalNumber) = addVote(proposal, _MutableVote(this.func))
    infix fun HalfFunctionVote.on(number: RawProposalNumber) = this on ProposalNumber(number)
    infix fun HalfFunctionVote.on(number: Int) = this on number.toBigInteger()

    infix fun HalfFunctionVote.on(all: _All) {
        proposals.forEach { addVote(it, this) }
    }

    infix fun HalfFunctionVote.on(others: _Others) {
        for (proposal in proposals.map { it }) {
            if (!votes.containsKey(proposal)) addVote(proposal, this)
        }
    }

    fun function(func: VoteFunc) = functionVote(func)

    private fun simpleVoteFunction(vote: VoteKind) = functionVote { _, _ -> SimpleVote(vote, comment = null) }

    infix fun VoteKind.on(proposal: ProposalNumber) = simpleVoteFunction(this) on proposal
    infix fun VoteKind.on(proposal: RawProposalNumber) = this on ProposalNumber(proposal)
    infix fun VoteKind.on(proposal: Int) = this on proposal.toBigInteger()
    infix fun VoteKind.on(all: _All) = simpleVoteFunction(this) on all
    infix fun VoteKind.on(others: _Others) = simpleVoteFunction(this) on others

    infix fun _MutableVote.comment(value: String) {
        this.comment = value
    }

    fun compile(): Map<ProposalNumber, PendingVote> {
        return votes.mapValues { (k, v) -> v.compile() }
    }
}
