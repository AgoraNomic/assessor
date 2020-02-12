package org.agoranomic.assessor.dsl.receivers

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import org.agoranomic.assessor.dsl.AssessmentDSL
import org.agoranomic.assessor.dsl.DslValueMap
import org.agoranomic.assessor.lib.*

interface VoteCommentable {
    infix fun comment(comment: String)
}

@AssessmentDSL
interface VotesReceiver {
    object All
    val all: All get() = All

    object Others
    val others: Others get() = Others

    infix fun HalfFunctionVote.on(proposal: ProposalNumber): VoteCommentable
    infix fun HalfFunctionVote.on(number: Int) = on(ProposalNumber(number))

    infix fun HalfFunctionVote.on(all: All)
    infix fun HalfFunctionVote.on(others: Others)

    infix fun VoteKind.on(proposal: ProposalNumber): VoteCommentable
    infix fun VoteKind.on(proposal: Int) = on(ProposalNumber(proposal))

    infix fun VoteKind.on(all: All)
    infix fun VoteKind.on(others: Others)

    fun function(func: VoteFunc): HalfFunctionVote
}

@AssessmentDSL
class VotesReceiverImpl(private val proposals: ImmutableList<ProposalNumber>) : VotesReceiver {
    constructor(proposals: List<ProposalNumber>) : this(proposals.toImmutableList())

    private val votes = DslValueMap<ProposalNumber, MutableVote>()

    private data class MutableVote(val vote: VoteFunc, var comment: String? = null) : VoteCommentable {
        override fun comment(comment: String) {
            this.comment = comment
        }

        fun compile() = PendingVote(vote, comment)
    }

    private fun addVote(proposal: ProposalNumber, vote: MutableVote): VoteCommentable {
        require(proposals.contains(proposal)) { "No such proposal $proposal" }

        votes[proposal] = vote
        return vote
    }

    private fun addVote(proposal: ProposalNumber, vote: HalfFunctionVote) = addVote(proposal, MutableVote(vote.func))

    override infix fun HalfFunctionVote.on(proposal: ProposalNumber) = addVote(proposal, MutableVote(this.func))

    override infix fun HalfFunctionVote.on(all: VotesReceiver.All) {
        proposals.forEach { addVote(it, this) }
    }

    override infix fun HalfFunctionVote.on(others: VotesReceiver.Others) {
        for (proposal in proposals.map { it }) {
            if (!votes.containsKey(proposal)) addVote(proposal, this)
        }
    }

    override fun function(func: VoteFunc) = functionVote(func)

    private fun simpleVoteFunction(vote: VoteKind) = functionVote { _, _ -> SimpleVote(vote, comment = null) }

    override infix fun VoteKind.on(proposal: ProposalNumber) = simpleVoteFunction(this) on proposal

    override infix fun VoteKind.on(all: VotesReceiver.All) = simpleVoteFunction(this) on all
    override infix fun VoteKind.on(others: VotesReceiver.Others) = simpleVoteFunction(this) on others

    fun compile(): Map<ProposalNumber, PendingVote> {
        return votes.compile().mapValues { (k, v) -> v.compile() }
    }
}
