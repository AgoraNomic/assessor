package org.agoranomic.assessor.lib

fun <K, V> Map<K?, V>.filterKeysNotNull(): Map<K, V> {
    return filterKeys { it != null }.mapKeys { (k, _) -> k!! }
}
