package org.agoranomic.assessor.dsl.votes

import org.agoranomic.assessor.decisions.legacyConditionalComment
import org.agoranomic.assessor.lib.vote.*

// Used to tag all votes that are legally conditional (including endorsements)
const val CONDITIONAL_VOTE_TAG = "conditional"

fun resolvedConditional(vote: VoteKind, description: String): ResolvingVote {
    return TaggedResolvingVote(
        tag = CONDITIONAL_VOTE_TAG,
        nextVote = CommentedResolvingVote(
            comment = legacyConditionalComment(description),
            nextVote = ResolvedVote(vote),
        ),
    )
}
