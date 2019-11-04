package org.agoranomic.assessor.lib.dsl_detail

import org.agoranomic.assessor.lib.*

@AssessmentDSL
class _VotesReceiver(private val proposals: List<Proposal>, private val player: Player) {
    private val votes = mutableMapOf<ProposalNumber, _MutableVote>()

    public object _All

    public val all = _All

    data class _MutableVote(val vote: VoteFunc, var comment: String? = null) {
        fun compile() = PendingVote(vote, comment)
    }

    private fun addVote(proposal: ProposalNumber, vote: _MutableVote): _MutableVote {
        require(proposals.map { it.number }.contains(proposal)) { "No such proposal $proposal" }
        require(!votes.containsKey(proposal)) { "Vote already specified for proposal $proposal" }

        votes[proposal] = vote
        return vote
    }

    infix fun HalfFunctionVote.on(proposal: ProposalNumber) = addVote(proposal, _MutableVote(this.func))

    infix fun HalfFunctionVote.on(all: _All) {
        proposals.forEach { addVote(it.number, _MutableVote(this.func)) }
    }

    private fun simpleVoteFunction(vote: VoteKind) = function { _, _ -> SimpleVote(vote, comment = null) }

    infix fun VoteKind.on(proposal: ProposalNumber) = simpleVoteFunction(this) on proposal
    infix fun VoteKind.on(all: _All) = simpleVoteFunction(this) on all

    infix fun _MutableVote.comment(value: String) {
        this.comment = value
    }

    fun compile(): Map<ProposalNumber, PendingVote> {
        return votes.mapValues { (k, v) -> v.compile() }
    }
}