package org.agoranomic.assessor.lib.dsl_detail

import org.agoranomic.assessor.lib.Proposal
import org.agoranomic.assessor.lib.Vote
import org.agoranomic.assessor.lib.VoteContext
import org.agoranomic.assessor.lib.VoteFunc

data class PendingVote(val voteFunc: VoteFunc, val comment: String?) {
    fun compile(proposal: Proposal, context: VoteContext): Vote? {
        val vote = voteFunc(proposal, context) ?: return null

        if (comment != null) {
            if (vote.comment != null) {
                return vote.copyWithComment(vote.comment + ": " + comment)
            }

            return vote.copyWithComment(comment)
        }

        return vote
    }
}
