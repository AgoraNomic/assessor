package org.agoranomic.assessor.lib.dsl_detail

import org.agoranomic.assessor.lib.Proposal
import org.agoranomic.assessor.lib.ResolveFunc
import org.agoranomic.assessor.lib.Vote
import org.agoranomic.assessor.lib.VoteFunc

data class PendingVote(val voteFunc: VoteFunc, val comment: String?) {
    fun compile(proposal: Proposal, resolve: ResolveFunc): Vote {
        val vote = voteFunc(proposal, resolve)

        if (comment != null) {
            if (vote.comment != null) {
                return vote.copyWithComment(vote.comment + ": " + comment)
            }

            return vote.copyWithComment(comment)
        }

        return vote
    }
}
