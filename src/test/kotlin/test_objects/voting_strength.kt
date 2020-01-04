package test_objects

import org.agoranomic.assessor.lib.VotingStrength
import org.agoranomic.assessor.lib.VotingStrengthWithComment

fun testVotingStrength(num: TestNumber) = VotingStrength(num)
fun firstTestVotingStrength() = testVotingStrength(TEST_ZERO)
fun secondTestVotingStrength() = testVotingStrength(TEST_ONE)

fun testVotingStrengthWithCommentNonNullComment(num: TestNumber) = VotingStrengthWithComment(
    testVotingStrength(subReqNum(num)),
    testString(subReqNum(num), "VotingStrength comment")
)

fun testVotingStrengthWithCommentNullComment(num: TestNumber) = VotingStrengthWithComment(
    testVotingStrength(subReqNum(num)),
    null
)

fun testVotingStrengthWithComment(num: TestNumber) = testVotingStrengthWithCommentNonNullComment(num)

fun firstTestVotingStrengthWithComment() = testVotingStrengthWithComment(TEST_ZERO)
fun secondTestVotingStrengthWithComment() = testVotingStrengthWithComment(TEST_ONE)
