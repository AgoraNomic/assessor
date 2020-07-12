package org.agoranomic.assessor.lib.vote

/**
 * A function vote without a comment. This is "half" of a vote because the other half is the comment of the vote.
 * @param func the [VoteFunc] for the function vote
 */
data class HalfFunctionVote(val func: VoteFunc)

/**
 * Returns a [HalfFunctionVote] containing [vote].
 */
fun functionVote(vote: VoteFunc) = HalfFunctionVote(vote)
