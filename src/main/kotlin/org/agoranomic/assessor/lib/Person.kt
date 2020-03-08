package org.agoranomic.assessor.lib

import kotlinx.collections.immutable.ImmutableSet
import kotlinx.collections.immutable.toImmutableSet

data class Person(val name: String)

data class Persons(val data: ImmutableSet<Person>) : Collection<Person> by data {
    constructor(data: Set<Person>) : this(data.toImmutableSet())

    companion object {
        fun empty() = Persons(emptySet())

        fun checkingDistinct(collection: Collection<Person>): Persons {
            collection.requireAllAreDistinct()
            return Persons(collection.toSet())
        }
    }
}
