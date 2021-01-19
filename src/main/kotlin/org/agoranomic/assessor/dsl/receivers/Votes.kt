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

    infix fun ResolvingVote.on(proposal: ProposalNumber): VoteCommentable
    infix fun ResolvingVote.on(number: Int) = on(ProposalNumber(number))

    infix fun ResolvingVote.on(all: AllMarker)
    infix fun ResolvingVote.on(others: OthersMarker)

    infix fun VoteKind.on(proposal: ProposalNumber): VoteCommentable
    infix fun VoteKind.on(proposal: Int) = on(ProposalNumber(proposal))

    infix fun VoteKind.on(all: AllMarker)
    infix fun VoteKind.on(others: OthersMarker)

    fun function(func: VoteFunc): ResolvingVote
}

typealias PersonVotesReceiverInit = DslInit<PersonVotesReceiver>

interface PersonVotesCompiler {
    fun compile(allProposals: ProposalSet, init: PersonVotesReceiverInit): ImmutableMap<ProposalNumber, ResolvingVote>
}

@AssessmentDsl
private class DefaultPersonVotesReceiver(private val proposals: ImmutableList<ProposalNumber>) : PersonVotesReceiver {
    constructor(proposals: List<ProposalNumber>) : this(proposals.toImmutableList())

    private val voteMap = SetOnceMap<ProposalNumber, MutableVote>()

    private data class MutableVote(val vote: ResolvingVote, var comment: String? = null) : VoteCommentable {
        override fun comment(comment: String) {
            this.comment = comment
        }

        fun compile(): ResolvingVote {
            val comment = comment
            return if (comment != null) CommentedResolvingVote(comment, vote) else vote
        }
    }

    private fun addVote(proposal: ProposalNumber, vote: MutableVote): VoteCommentable {
        require(proposals.contains(proposal)) { "No such proposal $proposal" }

        voteMap[proposal] = vote
        return vote
    }

    private fun addVote(proposal: ProposalNumber, vote: ResolvingVote) = addVote(proposal, MutableVote(vote))

    override infix fun ResolvingVote.on(proposal: ProposalNumber) = addVote(proposal, MutableVote(this))

    override infix fun ResolvingVote.on(all: PersonVotesReceiver.AllMarker) {
        val adjustedVote = TaggedResolvingVote("part_of_all_vote", this)
        proposals.forEach { addVote(it, adjustedVote) }
    }

    override infix fun ResolvingVote.on(others: PersonVotesReceiver.OthersMarker) {
        for (proposal in proposals.map { it }) {
            if (!voteMap.containsKey(proposal)) addVote(proposal, this)
        }
    }

    override fun function(func: VoteFunc) = object : ResolvingVote {
        override fun resolveStep(context: ProposalVoteContext): VoteStepResolution {
            return VoteStepResolution.Continue(func(context.currentProposal, context) ?: AbstentionResolvingVote)
        }

        override val currentStepDescription: VoteStepDescription
            get() = VoteStepDescription.None
    }

    override infix fun VoteKind.on(proposal: ProposalNumber) = ResolvedVote(this) on proposal

    override infix fun VoteKind.on(all: PersonVotesReceiver.AllMarker) = ResolvedVote(this) on all
    override infix fun VoteKind.on(others: PersonVotesReceiver.OthersMarker) = ResolvedVote(this) on others

    fun compile(): ImmutableMap<ProposalNumber, ResolvingVote> {
        return voteMap.compile().mapValues { (_, v) -> v.compile() }.toImmutableMap()
    }
}

class DefaultPersonVotesCompiler : PersonVotesCompiler {
    override fun compile(
        allProposals: ProposalSet,
        init: PersonVotesReceiverInit,
    ): ImmutableMap<ProposalNumber, ResolvingVote> {
        return DefaultPersonVotesReceiver(allProposals.numbers().toList()).also(init).compile()
    }
}
