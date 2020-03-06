package test_util

import kotlin.test.assertTrue

fun assertSucceeds(block: () -> Unit) {
    var succeeded: Boolean

    try {
        block()
        succeeded = true
    } catch (caught: Exception) {
        succeeded = false
    }

    assertTrue(succeeded, "Expected block to succeed, but it instead failed with an exception.")
}
