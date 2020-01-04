package test_objects

import org.agoranomic.assessor.lib.Player

fun testPlayer(num: TestNumber, type: String = "Player") = Player(testString(subReqNum(num), type))

fun firstTestPlayer(type: String = "Player") = testPlayer(TEST_ZERO, type)
fun secondTestPlayer(type: String = "Player") = testPlayer(TEST_ONE, type)
