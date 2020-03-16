package org.agoranomic.assessor.lib

import kotlinx.collections.immutable.ImmutableSet
import kotlinx.collections.immutable.toImmutableSet
import org.agoranomic.assessor.lib.util.requireAllAreDistinct
import org.agoranomic.assessor.lib.util.toSetCheckingDistinct

data class Person(val name: String)

data class Persons(val data: ImmutableSet<Person>) : Collection<Person> by data {
    constructor(data: Set<Person>) : this(data.toImmutableSet())

    companion object {
        fun checkingDistinct(collection: Collection<Person>): Persons {
            collection.requireAllAreDistinct()
            return Persons(collection.toSet())
        }
    }
}

/**
 * Returns an empty [Persons].
 */
fun emptyPersons() = Persons(emptySet())

/**
 * Returns a [Persons] that contains the [Person]s in [persons]. Throws [IllegalArgumentException] if [persons] contains
 * any [Person] more than once.
 */
fun personsOf(vararg persons: Person) = Persons(persons.toList().toSetCheckingDistinct())
