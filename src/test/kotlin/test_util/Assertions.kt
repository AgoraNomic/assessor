package test_util

import kotlin.test.assertEquals

fun <T> assertEqualsAndHashCode(first: T, second: T) {
    assertEquals(first, second)
    assertEquals(first.hashCode(), second.hashCode())
}
