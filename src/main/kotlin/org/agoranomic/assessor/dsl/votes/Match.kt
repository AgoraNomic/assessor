package org.agoranomic.assessor.dsl.votes

import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.vote.*

fun match(other: Person): ResolvingVote {
    return object : ResolvingVote {
        override fun resolveStep(context: ProposalVoteContext): VoteStepResolution {
            return VoteStepResolution.Continue(
                context.resolve(context.currentProposal, other) ?: AbstentionResolvingVote
            )
        }

        override fun currentStepDescription(context: ProposalVoteContext): VoteStepDescription =
            VoteStepDescription.None
    }
}
