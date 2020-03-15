package test_objects

import org.agoranomic.assessor.lib.InextricableVote
import org.agoranomic.assessor.lib.SimpleVote
import org.agoranomic.assessor.lib.Vote
import org.agoranomic.assessor.lib.VoteKind

fun testVoteKind(num: TestNumber) = testValueOf<VoteKind>(num)

fun testSimpleVoteNonNullComment(num: TestNumber) =
    SimpleVote(testVoteKind(subReqNum(num)), testString(num, "SimpleVote comment"))

fun testSimpleVoteNullComment(num: TestNumber) = SimpleVote(testVoteKind(subReqNum(num)), null)
fun testSimpleVote(num: TestNumber) = testSimpleVoteNonNullComment(num)

fun testInextricableVoteNonNullComment(num: TestNumber) =
    InextricableVote(testString(subReqNum(num), "InextricableVote comment"))

// num is maintained here for consistency with other test functions
@Suppress("UNUSED_PARAMETER")
fun testInextricableVoteNullComment(num: TestNumber) = InextricableVote(null)

fun testInextricableVote(num: TestNumber) = testInextricableVoteNonNullComment(num)

fun testVote(num: TestNumber): Vote = testSimpleVote(num)
fun firstTestVote() = testFirst(::testVote)
fun secondTestVote() = testSecond(::testVote)

private fun simpleVoteKindsWithComment(comment: String?) = VoteKind.values().map { SimpleVote(it, comment) }

val ALL_SIMPLE_VOTE_KIND_NON_NULL_COMMENT_LIST = simpleVoteKindsWithComment("I'm a comment!")
val ALL_SIMPLE_VOTE_KIND_NULL_COMMENT_LIST = simpleVoteKindsWithComment(null)
val ALL_SIMPLE_VOTE_KIND_LIST = ALL_SIMPLE_VOTE_KIND_NON_NULL_COMMENT_LIST + ALL_SIMPLE_VOTE_KIND_NULL_COMMENT_LIST

val INEXTRICABLE_VOTE_NON_NULL_COMMENT = InextricableVote(comment = "I'm a comment!")
val INEXTRICABLE_VOTE_NULL_COMMENT = InextricableVote(comment = null)
val ALL_INEXTRICABLE_VOTE_KIND_LIST = listOf(INEXTRICABLE_VOTE_NON_NULL_COMMENT, INEXTRICABLE_VOTE_NULL_COMMENT)

val ALL_VOTE_KIND_LIST = ALL_SIMPLE_VOTE_KIND_LIST + ALL_INEXTRICABLE_VOTE_KIND_LIST
