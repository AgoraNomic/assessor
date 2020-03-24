package org.agoranomic.assessor.lib.util

import kotlin.reflect.KClass

/**
 * Returns an [Array] containing the enum constants of [E].
 *
 * @param E the enum for which to retrieve the constants
 * @param enumClass the reified [Class] of [E]
 */
fun <E : Enum<E>> enumValuesOf(enumClass: KClass<E>): Array<E> {
    val result = enumClass.java.enumConstants ?: null

    check(result != null)
    check(result.none { it == null })

    return result
}

/**
 * Returns `true` if this collection contains all enum constants of [E], and false otherwise.
 *
 * @param E the enum type
 * @param enumClass the reified [Class] of [E]
 */
fun <E : Enum<E>> Collection<E>.isExhaustive(enumClass: KClass<E>): Boolean {
    val enumConstants = enumValuesOf(enumClass).asList()

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
    val enumConstants = enumValuesOf(enumClass)

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
