package org.agoranomic.assessor.test.test_objects

import org.agoranomic.assessor.lib.vote.SingleProposalVoteMap

fun testSingleProposalVoteMap(num: TestNumber) =
    SingleProposalVoteMap(testMap(num) { testPerson(subReqNum(it)) to testVote(subReqNum(it)) })

fun firstSingleProposalVoteMap() = testFirst(::testSingleProposalVoteMap)
