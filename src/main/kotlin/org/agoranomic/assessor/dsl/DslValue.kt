package org.agoranomic.assessor.dsl

import org.agoranomic.assessor.lib.util.getOrFail

/**
 * Represents a value that must be set exactly once.
 */
class DslValue<T> {
    private var currentValue: T? = null
    private var isInitialized: Boolean = false

    /**
     * Returns `true` if the value has been set, and `false` otherwise.
     */
    fun hasValue(): Boolean = isInitialized

    /**
     * Sets the value. Fails if the value has already been set.
     *
     * @throws IllegalStateException if the value has already been set.
     */
    fun set(value: T) {
        check(!hasValue())
        currentValue = value
        isInitialized = true
    }

    /**
     * Gets the value. Fails if the value has not been set.
     *
     * @throws IllegalStateException if the value has not been set.
     */
    fun get(): T {
        check(hasValue())

        // Because we know we have a value, we have an object of type T in currentValue, so the cast is unchecked,
        // but it is guaranteed to be correct.
        @Suppress("UNCHECKED_CAST")
        return currentValue as T
    }
}

/**
 * Gets the value, or a default if the value has not been set. The default is nullable. Does not fail.
 */
@JvmName("getOrDefaultNullable")
fun <T> DslValue<T>.getOrDefault(default: T?): T? {
    return if (hasValue()) get() else default
}

/**
 * Gets the value, or a default if the value has not been set. The default is not nullable. Does not fail.
 */
fun <T> DslValue<T>.getOrDefault(default: T): T {
    return if (hasValue()) get() else default
}

/**
 * Gets the value, or null if the value has not been set. Does not fail.
 */
fun <T> DslValue<T>.getOrNull(): T? = getOrDefault(null)

/**
 * A map that contains values that may only be set exactly once per key.
 */
class DslValueMap<K, V> {
    private val map = mutableMapOf<K, DslValue<V>>()

    /**
     * Sets the value for [key]. Fails if the value has already been set for [key].
     *
     * @throws IllegalStateException if the value has already been set for [key].
     */
    operator fun set(key: K, value: V) {
        val dslValue = map.computeIfAbsent(key) { DslValue() }
        dslValue.set(value)
    }

    /**
     * Gets the value for [key]. Fails if the value has not already been set for [key].
     *
     * @throws IllegalStateException if the value has not already been set for [key].
     */
    operator fun get(key: K): V {
        val dslValue = map.getOrFail(key)
        return dslValue.get()
    }

    /**
     * Returns whether or not a value has been set for [key].
     */
    fun containsKey(key: K): Boolean = map.containsKey(key)

    /**
     * Compiles all set keys and values into a [Map].
     */
    fun compile(): Map<K, V> {
        return map.mapValues { (_, v) -> v.get() }
    }
}

/**
 * Gets the value for [key], or [default] if it has not been set. The default is nullable. Does not fail.
 */
@JvmName("getOrDefaultNullable")
fun <K, V> DslValueMap<K, V>.getOrDefault(key: K, default: V?): V? {
    return if (containsKey(key)) get(key) else default
}

/**
 * Gets the value for [key], or [default] if it has not been set. The default is not nullable. Does not fail.
 */
fun <K, V> DslValueMap<K, V>.getOrDefault(key: K, default: V): V {
    return if (containsKey(key)) get(key) else default
}

/**
 * Gets the value for [key], or null if it has not been set. Does not fail.
 */
fun <K, V> DslValueMap<K, V>.getOrNull(key: K) = getOrDefault(key, null)
