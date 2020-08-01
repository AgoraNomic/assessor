package org.agoranomic.assessor.dsl.detail

import io.github.random_internet_cat.util.getOrFail

/**
 * Represents a value that must be set exactly once.
 *
 * @param T the type of the value
 */
class SetOnce<T> {
    private var currentValue: T? = null
    private var isInitialized: Boolean = false
    private val name: String?

    companion object {
        fun <T> namedOf(name: String): SetOnce<T> = SetOnce<T>(name)
    }

    private constructor(name: String?) {
        this.name = name
    }

    constructor() : this(null)

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
        if (hasValue()) {
            val message =
                if (name != null)
                    "Attempt to set value of DslValue (name = $name) twice"
                else
                    "Attempt to set value of DslValue twice"

            error(message)
        }

        currentValue = value
        isInitialized = true
    }

    /**
     * Gets the value. Fails if the value has not been set.
     *
     * @throws IllegalStateException if the value has not been set.
     */
    fun get(): T {
        if (!hasValue()) {
            val message =
                if (name != null)
                    "Attempt to read unset value of DslValue (name = $name)"
                else
                    "Attempt to read unset value of DslValue"

            error(message)
        }

        // Because we know we have a value, we have an object of type T in currentValue, so the cast is unchecked,
        // but it is guaranteed to be correct.
        @Suppress("UNCHECKED_CAST")
        return currentValue as T
    }
}

/**
 * Gets the value, or [defaultValue] if the value has not been set. [defaultValue] is not nullable.
 */
fun <T> SetOnce<T>.getOrDefault(defaultValue: T): T {
    return if (hasValue()) get() else defaultValue
}

/**
 * Gets the value, or null if the value has not been set.
 */
fun <T> SetOnce<T>.getOrNull(): T? {
    return if (hasValue()) get() else null
}

/**
 * A map that contains values that may only be set exactly once per key.
 *
 * @param K the key type
 * @param V the value type
 */
class SetOnceMap<K, V> {
    private val map = mutableMapOf<K, SetOnce<V>>()

    /**
     * Sets the value for [key]. Fails if the value has already been set for [key].
     *
     * @throws IllegalStateException if the value has already been set for [key].
     */
    operator fun set(key: K, value: V) {
        val dslValue = map.computeIfAbsent(key) { SetOnce() }
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
 * Gets the value for [key], or [defaultValue] if it has not been set. [defaultValue] is not nullable.
 */
fun <K, V> SetOnceMap<K, V>.getOrDefault(key: K, defaultValue: V): V {
    return if (containsKey(key)) get(key) else defaultValue
}

/**
 * Gets the value for [key], or null if it has not been set.
 */
fun <K, V> SetOnceMap<K, V>.getOrNull(key: K): V? {
    return if (containsKey(key)) get(key) else null
}

/**
 * Represents a value that can only be set to true once, and which can never be set back to false.
 */
class SetOnceFuse
private constructor(name: String?) {
    private val impl: SetOnce<Unit> = SetOnce.namedOf(
        if (name != null)
            "internal value of fuse (name = $name)"
        else
            "internal value of fuse"
    )

    companion object {
        fun named(name: String): SetOnceFuse = SetOnceFuse(name)
    }

    constructor() : this(null)

    /**
     * Blows this fuse, i.e. sets a flag as true.
     *
     * @throws IllegalStateException if this fuse has already been blown
     */
    fun blow() {
        impl.set(Unit)
    }

    /**
     * Returns whether or not this fuse has been blown, i.e. whether [blow] has ever been called.
     */
    fun isBlown() = impl.hasValue()
}
