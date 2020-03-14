package org.agoranomic.assessor.lib.util

import kotlin.reflect.KClass

fun <E : Enum<E>> Collection<E>.isExhaustive(enumClass: KClass<E>): Boolean {
    val enumConstants = enumClass.java.enumConstants?.toList()?.requireNoNulls()
    check(enumConstants != null)

    val collection = this
    return collection.containsAll(enumConstants)
}

inline fun <reified E : Enum<E>> Collection<E>.isExhaustive(): Boolean = isExhaustive(E::class)

fun <E : Enum<E>> Collection<E>.requireExhaustive(enumClass: KClass<E>) {
    val enumConstants = enumClass.java.enumConstants?.toList()?.requireNoNulls()
    check(enumConstants != null)

    for (value in enumConstants) {
        require(this.contains(value)) { "Collection was required to be exhaustive, but did not contain $value" }
    }
}

inline fun <reified E : Enum<E>> Collection<E>.requireExhaustive() = requireExhaustive(E::class)
