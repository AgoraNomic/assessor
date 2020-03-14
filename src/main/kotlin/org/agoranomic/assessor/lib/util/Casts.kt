package org.agoranomic.assessor.lib.util

/**
 * Returns this object, except with a nullable type (if it wasn't already).
 */
// Inlined because this is a small utility method and function call overhead may be significant
@Suppress("NOTHING_TO_INLINE")
inline fun <T> T.asNullable(): T? = this
