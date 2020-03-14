package org.agoranomic.assessor.lib.util

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

fun <T> Collection<T>.allAreDistinct(): Boolean {
    val alreadySeen = mutableSetOf<T>()

    for (item in this) {
        if (alreadySeen.contains(item)) return false
        alreadySeen += item
    }

    return true
}

fun <T> Collection<T>.requireAllAreDistinct() {
    require(allAreDistinct()) {
        "All elements were required to be distinct, but found duplicate elements: ${repeatingElements()}"
    }
}

fun <T, K> Collection<T>.allAreDistinctBy(selector: (T) -> K) = map(selector).allAreDistinct()

fun <T, K> Collection<T>.requireAllAreDistinctBy(selector: (T) -> K) = map(selector).requireAllAreDistinct()

fun <K, V> Map<K, V>.getOrFail(key: K): V {
    if (containsKey(key)) {
        // Because the map contains the key, we know it has an object of type V as value, so the cast is unchecked, but
        // it is always correct.
        @Suppress("UNCHECKED_CAST")
        return get(key) as V
    }

    error("Missing expected key in map: $key")
}
