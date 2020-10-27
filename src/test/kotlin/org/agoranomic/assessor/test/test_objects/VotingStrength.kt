package org.agoranomic.assessor.test.test_objects

import org.agoranomic.assessor.lib.voting_strength.VotingStrength

fun testVotingStrength(num: TestNumber) = VotingStrength(num)
fun firstTestVotingStrength() = testFirst(::testVotingStrength)
fun secondTestVotingStrength() = testSecond(::testVotingStrength)
