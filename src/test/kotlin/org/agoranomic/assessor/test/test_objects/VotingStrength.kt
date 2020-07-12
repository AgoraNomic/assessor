package org.agoranomic.assessor.test.test_objects

import org.agoranomic.assessor.lib.voting_strength.VotingStrength
import org.agoranomic.assessor.lib.voting_strength.VotingStrengthWithComment

fun testVotingStrength(num: TestNumber) = VotingStrength(num)
fun firstTestVotingStrength() = testFirst(::testVotingStrength)
fun secondTestVotingStrength() = testSecond(::testVotingStrength)

fun testVotingStrengthWithCommentNonNullComment(num: TestNumber) = VotingStrengthWithComment(
    testVotingStrength(subReqNum(num)),
    testString(subReqNum(num), "VotingStrength comment")
)

fun testVotingStrengthWithCommentNullComment(num: TestNumber) = VotingStrengthWithComment(
    testVotingStrength(subReqNum(num)),
    null
)

fun testVotingStrengthWithComment(num: TestNumber) = testVotingStrengthWithCommentNonNullComment(num)

fun firstTestVotingStrengthWithComment() = testFirst(::testVotingStrengthWithComment)
fun secondTestVotingStrengthWithComment() = testSecond(::testVotingStrengthWithComment)
