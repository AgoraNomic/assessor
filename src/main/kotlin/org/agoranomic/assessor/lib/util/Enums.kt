package org.agoranomic.assessor.lib.util

import kotlin.reflect.KClass

/**
 * Returns `true` if this collection contains all enum constants of [E], and false otherwise.
 *
 * @param E the enum type
 * @param enumClass the reified [Class] of [E]
 */
fun <E : Enum<E>> Collection<E>.isExhaustive(enumClass: KClass<E>): Boolean {
    val enumConstants = enumClass.java.enumConstants?.toList()?.requireNoNulls()
    check(enumConstants != null)

    val collection = this
    return collection.containsAll(enumConstants)
}

/**
 * Returns `true` if this collection contains all enum constants of [E], and false otherwise.
 *
 * @param E the enum type
 */
inline fun <reified E : Enum<E>> Collection<E>.isExhaustive(): Boolean = isExhaustive(E::class)

/**
 * Throws [IllegalArgumentException] if this [Collection] does not contain all enum constants of [E].
 *
 * @param E the enum type
 * @param enumClass the reified [Class] of [E]
 */
fun <E : Enum<E>> Collection<E>.requireExhaustive(enumClass: KClass<E>) {
    val enumConstants = enumClass.java.enumConstants?.toList()?.requireNoNulls()
    check(enumConstants != null)

    for (value in enumConstants) {
        require(this.contains(value)) { "Collection was required to be exhaustive, but did not contain $value" }
    }
}

/**
 * Throws [IllegalArgumentException] if this [Collection] does not contain all enum constants of [E].
 *
 * @param E the enum type
 */
inline fun <reified E : Enum<E>> Collection<E>.requireExhaustive() = requireExhaustive(E::class)
