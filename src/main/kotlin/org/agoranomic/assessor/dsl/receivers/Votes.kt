package org.agoranomic.assessor.dsl.receivers

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.toImmutableList
import kotlinx.collections.immutable.toImmutableMap
import org.agoranomic.assessor.dsl.AssessmentDsl
import org.agoranomic.assessor.dsl.detail.DslInit
import org.agoranomic.assessor.dsl.detail.SetOnceMap
import org.agoranomic.assessor.dsl.votes.AuthorMarker
import org.agoranomic.assessor.lib.proposal.ProposalNumber
import org.agoranomic.assessor.lib.proposal.proposal_set.ProposalSet
import org.agoranomic.assessor.lib.vote.*

interface VoteCommentable {
    infix fun comment(comment: String)
}

@AssessmentDsl
interface PersonVotesReceiver {
    object AllMarker
    object OthersMarker

    val all: AllMarker get() = AllMarker
    val others: OthersMarker get() = OthersMarker
    val author: AuthorMarker get() = AuthorMarker

    infix fun FunctionVote.on(proposal: ProposalNumber): VoteCommentable
    infix fun FunctionVote.on(number: Int) = on(ProposalNumber(number))

    infix fun FunctionVote.on(all: AllMarker)
    infix fun FunctionVote.on(others: OthersMarker)

    infix fun VoteKind.on(proposal: ProposalNumber): VoteCommentable
    infix fun VoteKind.on(proposal: Int) = on(ProposalNumber(proposal))

    infix fun VoteKind.on(all: AllMarker)
    infix fun VoteKind.on(others: OthersMarker)

    fun function(func: VoteFunc): FunctionVote
}

typealias PersonVotesReceiverInit = DslInit<PersonVotesReceiver>

interface PersonVotesCompiler {
    fun compile(allProposals: ProposalSet, init: PersonVotesReceiverInit): ImmutableMap<ProposalNumber, PendingVote>
}

@AssessmentDsl
private class DefaultPersonVotesReceiver(private val proposals: ImmutableList<ProposalNumber>) : PersonVotesReceiver {
    constructor(proposals: List<ProposalNumber>) : this(proposals.toImmutableList())

    private val voteMap = SetOnceMap<ProposalNumber, MutableVote>()

    private data class MutableVote(val vote: VoteFunc, var comment: String? = null) : VoteCommentable {
        override fun comment(comment: String) {
            this.comment = comment
        }

        fun compile() = PendingVote(vote, comment)
    }

    private fun addVote(proposal: ProposalNumber, vote: MutableVote): VoteCommentable {
        require(proposals.contains(proposal)) { "No such proposal $proposal" }

        voteMap[proposal] = vote
        return vote
    }

    private fun addVote(proposal: ProposalNumber, vote: FunctionVote) = addVote(proposal, MutableVote(vote.func))

    override infix fun FunctionVote.on(proposal: ProposalNumber) = addVote(proposal, MutableVote(this.func))

    override infix fun FunctionVote.on(all: PersonVotesReceiver.AllMarker) {
        proposals.forEach { addVote(it, this) }
    }

    override infix fun FunctionVote.on(others: PersonVotesReceiver.OthersMarker) {
        for (proposal in proposals.map { it }) {
            if (!voteMap.containsKey(proposal)) addVote(proposal, this)
        }
    }

    override fun function(func: VoteFunc) = FunctionVote(func)

    private fun simpleVoteFunction(vote: VoteKind) = function { _, _ -> SimpleVote(vote, comment = null) }

    override infix fun VoteKind.on(proposal: ProposalNumber) = simpleVoteFunction(this) on proposal

    override infix fun VoteKind.on(all: PersonVotesReceiver.AllMarker) = simpleVoteFunction(this) on all
    override infix fun VoteKind.on(others: PersonVotesReceiver.OthersMarker) = simpleVoteFunction(this) on others

    fun compile(): ImmutableMap<ProposalNumber, PendingVote> {
        return voteMap.compile().mapValues { (_, v) -> v.compile() }.toImmutableMap()
    }
}

class DefaultPersonVotesCompiler : PersonVotesCompiler {
    override fun compile(
        allProposals: ProposalSet,
        init: PersonVotesReceiverInit
    ): ImmutableMap<ProposalNumber, PendingVote> {
        return DefaultPersonVotesReceiver(allProposals.numbers().toList()).also(init).compile()
    }
}
