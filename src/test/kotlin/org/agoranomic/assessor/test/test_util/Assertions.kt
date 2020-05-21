package org.agoranomic.assessor.test.test_util

import kotlin.test.assertEquals

fun <T> assertEqualsAndHashCode(first: T, second: T) {
    assertEquals(first, second)
    assertEquals(second, first)
    assertEquals(first.hashCode(), second.hashCode())
}
