package org.agoranomic.assessor.lib.util

/**
 * Returns a [Set] containing all elements that appear more than once in this [Iterable].
 *
 * @param T the element type of this [Iterable]
 */
fun <T> Iterable<T>.repeatingElements(): Set<T> {
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
 * Returns a [Set] containing the same elements as this [Collection], if this [Collection] contains no repeating
 * elements, otherwise throws [IllegalArgumentException].
 */
fun <T> Iterable<T>.toSetCheckingDistinct(): Set<T> {
    val alreadySeen = mutableSetOf<T>()

    for (item in this) {
        require(!alreadySeen.contains(item)) {
            "Expected all elements to be distinct, but found repeating element: $item"
        }

        alreadySeen += item
    }

    return alreadySeen
}

/**
 * Returns `true` if this [Iterable] does not contain any repeating elements, and `false` otherwise.
 *
 * @param T the element type of this [Iterable]
 */
fun <T> Iterable<T>.allAreDistinct(): Boolean {
    val alreadySeen = mutableSetOf<T>()

    for (item in this) {
        if (alreadySeen.contains(item)) return false
        alreadySeen += item
    }

    return true
}

/**
 * Throws an [IllegalArgumentException] if this [Iterable] has any elements that appear more than once.
 *
 * @param T the element type of this [Iterable]
 */
fun <T> Iterable<T>.requireAllAreDistinct() {
    // This will do the distinct checking for us, so we can just throw away the result
    toSetCheckingDistinct()
}

/**
 * Returns `true` if this [Iterable] has no elements such that results of [selector] are the same, and `false`
 * otherwise.
 *
 * @param T the element type of this [Iterable]
 * @param K the result type of [selector]
 * @param selector the function to map elements to keys
 */
fun <T, K> Iterable<T>.allAreDistinctBy(selector: (T) -> K): Boolean {
    val alreadySeen = mutableSetOf<K>()

    for (item in this) {
        val key = selector(item)
        if (alreadySeen.contains(key)) return false
        alreadySeen += key
    }

    return true
}

/**
 * Throws an [IllegalArgumentException] if this [Iterable] has two elements such that results of [selector] are the
 * same.
 *
 * @param T the element type of this [Iterable]
 * @param K the result type of [selector]
 * @param selector the function to map elements to keys
 */
fun <T, K> Iterable<T>.requireAllAreDistinctBy(selector: (T) -> K) {
    val alreadySeen = mutableSetOf<K>()

    for (item in this) {
        val key = selector(item)

        require(!alreadySeen.contains(key)) {
            "Expected all elements to be distinct, but found repeating key: $key (from element $item)"
        }

        alreadySeen += key
    }
}

/**
 * Returns `true` if all elements in this [Collection] are equal, and `false` otherwise.
 *
 * In particular, returns `true` for an empty collection.
 *
 * @param T the element type of this collection
 */
fun <T> Collection<T>.allAreEqual(): Boolean {
    if (isEmpty()) return true
    if (size == 1) return true

    val value = first()

    for (element in this) {
        if (value != element) return false
    }

    return true
}

/**
 * Throws [IllegalArgumentException] if all elements in this [Collection] are not equal.
 *
 * In particular, does not throw for an empty collection.
 *
 * @param T the element type of this collection
 */
fun <T> Collection<T>.requireAllAreEqual() {
    require(allAreEqual()) {
        "Expected all elements in collection $this to be equal"
    }
}

/**
 * If this map contains the key [key], returns the value corresponding to [key], otherwise throws
 * an [IllegalStateException].
 *
 * The value type of the receiver is non-nullable in order to avoid confusion about what to do in the case of a null
 * value, which has caused some contention in the standard library.
 *
 * @param K the key type of this [Map]
 * @param V the non-nullable value type of this [Map]
 * @param key the key for which the corresponding value is to be retrieved
 */
fun <K, V : Any> Map<K, V>.getOrFail(key: K): V {
    return getOrElse(key) { error("Missing expected key in map: $key") }
}
