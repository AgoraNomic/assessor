package org.agoranomic.assessor.lib

fun <K, V> Map<K, V>.getOrFail(key: K): V {
    if (containsKey(key)) {
        return get(key) as V
    }

    error("Missing expected key in map: $key")
}