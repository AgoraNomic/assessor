package test_objects

import org.agoranomic.assessor.lib.SingleProposalVoteMap

fun testSingleProposalVoteMap(num: TestNumber) = SingleProposalVoteMap(testMap(num) { testPlayer(subReqNum(it)) to testVote(subReqNum(it)) })
fun firstSingleProposalVoteMap() = testFirst(::testSingleProposalVoteMap)
