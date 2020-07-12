package org.agoranomic.assessor.lib.vote

/**
 * A "vote" consisting of a function that resolves to a vote.
 * @param func the [VoteFunc] for the function vote
 */
data class FunctionVote(val func: VoteFunc)
