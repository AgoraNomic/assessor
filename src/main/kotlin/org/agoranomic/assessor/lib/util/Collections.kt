package org.agoranomic.assessor.lib.util

/**
 * Returns a [Set] containing all elements that appear more than once in this [Collection].
 *
 * @param T the element type of this [Collection]
 */
fun <T> Collection<T>.repeatingElements(): Set<T> {
    val alreadySeen = mutableSetOf<T>()
    val duplicates = mutableSetOf<T>()

    for (element in this) {
        if (alreadySeen.contains(element)) {
            duplicates += element
        } else {
            alreadySeen += element
        }
    }

    return duplicates
}

/**
 * Returns `true` if this collection does not contain any repeating elements, and `false` otherwise.
 *
 * @param T the element type of this [Collection]
 */
fun <T> Collection<T>.allAreDistinct(): Boolean {
    val alreadySeen = mutableSetOf<T>()

    for (item in this) {
        if (alreadySeen.contains(item)) return false
        alreadySeen += item
    }

    return true
}

/**
 * Throws an [IllegalArgumentException] if this [Collection] has any elements that appear more than once.
 *
 * @param T the element type of this [Collection]
 */
fun <T> Collection<T>.requireAllAreDistinct() {
    require(allAreDistinct()) {
        "All elements were required to be distinct, but found duplicate elements: ${repeatingElements()}"
    }
}

/**
 * Returns `true` if this [Collection] has no elements such that results of [selector] are the same, and `false`
 * otherwise.
 *
 * @param T the element type of this [Collection]
 * @param K the result type of [selector]
 * @param selector the function to map elements to keys
 */
fun <T, K> Collection<T>.allAreDistinctBy(selector: (T) -> K) = map(selector).allAreDistinct()

/**
 * Throws an [IllegalArgumentException] if this [Collection] has two elements such that results of [selector] are the
 * same.
 *
 * @param T the element type of this [Collection]
 * @param K the result type of [selector]
 * @param selector the function to map elements to keys
 */
fun <T, K> Collection<T>.requireAllAreDistinctBy(selector: (T) -> K) = map(selector).requireAllAreDistinct()

/**
 * If this map contains the key [key], returns the value corresponding to [key], otherwise throws
 * an [IllegalStateException].
 *
 * @param K the key type of this [Map]
 * @param V the value type of this [Map]
 * @param key the key for which the corresponding value is to be retrieved
 */
fun <K, V> Map<K, V>.getOrFail(key: K): V {
    if (containsKey(key)) {
        // Because the map contains the key, we know it has an object of type V as value, so the cast is unchecked, but
        // it is always correct.
        @Suppress("UNCHECKED_CAST")
        return get(key) as V
    }

    error("Missing expected key in map: $key")
}
