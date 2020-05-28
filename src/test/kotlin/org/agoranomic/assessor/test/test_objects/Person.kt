package org.agoranomic.assessor.test.test_objects

import org.agoranomic.assessor.lib.Person

fun testPerson(num: TestNumber, type: String = "Person") = Person(testString(subReqNum(num), type))

fun testPerson(num: Int) = testPerson(testNumber(num))
fun testPerson(num: Int, type: String) = testPerson(testNumber(num), type)

fun firstTestPerson(type: String = "Person") = testFirst { testPerson(it, type) }
fun secondTestPerson(type: String = "Person") = testSecond { testPerson(it, type) }
