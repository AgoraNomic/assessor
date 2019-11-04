package org.agoranomic.assessor.lib

data class HalfFunctionVote(val func: VoteFunc)

fun function(vote: VoteFunc) = HalfFunctionVote(vote)
