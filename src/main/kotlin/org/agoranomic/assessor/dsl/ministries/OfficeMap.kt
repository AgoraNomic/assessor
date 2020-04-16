package org.agoranomic.assessor.dsl.ministries

import io.github.random_internet_cat.util.getOrFail
import io.github.random_internet_cat.util.requireAllAreDistinct
import io.github.random_internet_cat.util.requireExhaustive
import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.toImmutableMap
import org.agoranomic.assessor.lib.Person
import kotlin.reflect.KClass

/**
 * An entry in a [BasicOfficeMap].
 */
interface BasicOfficeMapEntry<Office : Enum<Office>> {
    val office: Office
    val state: OfficeState
}

/**
 * Enable destructuring of [BasicOfficeMapEntries][BasicOfficeMapEntry]. The first part is the office.
 */
operator fun <Office : Enum<Office>> BasicOfficeMapEntry<Office>.component1(): Office = office

/**
 * Enable destructuring of [BasicOfficeMapEntries][BasicOfficeMapEntry]. The second part is the state of the office.
 */
operator fun <Office : Enum<Office>> BasicOfficeMapEntry<Office>.component2(): OfficeState = state

sealed class OfficeState {
    object Vacant : OfficeState()
    data class Held(val holder: Person) : OfficeState()

    companion object {
        fun vacant() = Vacant
        fun heldBy(holder: Person) = Held(holder)
    }
}

fun OfficeState.isHeld() = this is OfficeState.Held
fun OfficeState.isVacant() = this is OfficeState.Vacant

/**
 * A map from Offices to [OfficeState]s.
 */
interface BasicOfficeMap<Office : Enum<Office>> : Iterable<BasicOfficeMapEntry<Office>> {
    /**
     * Returns the [OfficeState] associated with [office].
     */
    operator fun get(office: Office): OfficeState
}

/**
 * A default, immutable implementation of [BasicOfficeMap]. As an invariant, its internal [data] map always contains
 * data for each enumerator of [Office].
 */
private class BasicOfficeMapImpl<Office : Enum<Office>> private constructor(private val data: ImmutableMap<Office, OfficeState>) : BasicOfficeMap<Office> {
    companion object {
        fun <Office : Enum<Office>> from(
            officeClass: KClass<Office>,
            map: Map<Office, OfficeState>
        ): BasicOfficeMap<Office> {
            map.keys.requireExhaustive(officeClass)
            return BasicOfficeMapImpl(map.toImmutableMap())
        }

        inline fun <reified Office : Enum<Office>> from(map: Map<Office, OfficeState>) =
            from(Office::class, map)
    }

    private class EntryImpl<Office : Enum<Office>>(
        override val office: Office,
        override val state: OfficeState
    ) : BasicOfficeMapEntry<Office>

    override fun get(office: Office): OfficeState {
        return data.getOrFail(office)
    }

    override fun iterator(): Iterator<BasicOfficeMapEntry<Office>> {
        // TODO this is ugly - potentially write/find transforming iterator without need for Sequences
        return Sequence { data.iterator() }.map { (k, v) -> EntryImpl(k, v) }.iterator()
    }
}

/**
 * A helper for creating a [BasicOfficeMap] from pairs of offices to (nullable) persons.
 *
 * For each pair, if the [Person] (the second value) is non-null, it is interpreted as the holder of the office.
 * Otherwise, the office is interpreted as being vacant.
 *
 * @param officeClass the reified class of [Office]
 *
 * @throws [IllegalArgumentException] if all enumerators of [Office] do not appear exactly once as the first value in
 * a pair
 */
fun <Office : Enum<Office>> officeMapOf(
    officeClass: KClass<Office>,
    vararg pairs: Pair<Office, Person?>
): BasicOfficeMap<Office> {
    val uncheckedOfficeMap = pairs.toMap()

    uncheckedOfficeMap.keys.requireAllAreDistinct()
    uncheckedOfficeMap.keys.requireExhaustive(officeClass)

    return BasicOfficeMapImpl.from(
        officeClass,
        uncheckedOfficeMap
            .mapValues { (_, person) ->
                when (person) {
                    null -> OfficeState.Vacant
                    else -> OfficeState.Held(person)
                }
            }
    )
}

/**
 * A helper for creating a [BasicOfficeMap] from pairs of offices to (nullable) persons.
 *
 * For each pair, if the [Person] (the second value) is non-null, it is interpreted as the holder of the office.
 * Otherwise, the office is interpreted as being vacant.
 *
 * @throws [IllegalArgumentException] if all enumerators of [Office] do not appear exactly once as the first value in
 * a pair
 */
inline fun <reified Office : Enum<Office>> officeMapOf(vararg pairs: Pair<Office, Person?>) =
    officeMapOf(Office::class, *pairs)
