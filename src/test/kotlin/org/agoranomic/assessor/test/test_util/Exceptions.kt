package org.agoranomic.assessor.test.test_util

import kotlin.test.assertTrue

fun assertSucceeds(block: () -> Unit) {
    assertTrue(
        runCatching(block).isSuccess,
        "Expected block to succeed, but it instead failed with an exception.",
    )
}
