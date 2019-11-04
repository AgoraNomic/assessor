package org.agoranomic.assessor.lib

import java.math.BigDecimal

fun <K, V> Map<K, V>.getOrFail(key: K): V {
    if (containsKey(key)) {
        return get(key) as V
    }

    error("Missing expected key in map: $key")
}

operator fun BigDecimal.times(other: Int) = this * other.toBigDecimal()
operator fun Int.times(other: BigDecimal) = other * this

operator fun BigDecimal.compareTo(other: Int) = this.compareTo(other.toBigDecimal())
operator fun Int.compareTo(other: BigDecimal) = (this.toBigDecimal()).compareTo(other)
