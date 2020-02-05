package org.agoranomic.assessor.lib

data class HalfFunctionVote(val func: VoteFunc)

fun functionVote(vote: VoteFunc) = HalfFunctionVote(vote)
