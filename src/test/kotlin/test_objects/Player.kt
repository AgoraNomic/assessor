package test_objects

import org.agoranomic.assessor.lib.Person

fun testPlayer(num: TestNumber, type: String = "Player") = Person(testString(subReqNum(num), type))

fun firstTestPlayer(type: String = "Player") = testFirst { testPlayer(it, type) }
fun secondTestPlayer(type: String = "Player") = testSecond { testPlayer(it, type) }
