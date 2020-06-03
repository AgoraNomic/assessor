package org.agoranomic.assessor.dsl.ministries

import io.github.random_internet_cat.util.*
import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.toImmutableMap
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.lib.HalfFunctionVote
import org.agoranomic.assessor.lib.InextricableVote
import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.functionVote
import kotlin.reflect.KClass

/**
 * An entry in a [OfficeMap].
 */
interface OfficeMapEntry<Office : Enum<Office>> {
    val office: Office
    val state: OfficeState
}

/**
 * Enable destructuring of [OfficeMapEntry]. The first part is the office.
 */
operator fun <Office : Enum<Office>> OfficeMapEntry<Office>.component1(): Office = office

/**
 * Enable destructuring of [OfficeMapEntry]. The second part is the state of the office.
 */
operator fun <Office : Enum<Office>> OfficeMapEntry<Office>.component2(): OfficeState = state

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
interface OfficeMap<Office : Enum<Office>> : Iterable<OfficeMapEntry<Office>> {
    /**
     * Returns the [OfficeState] associated with [office].
     */
    operator fun get(office: Office): OfficeState
}

val <Office : Enum<Office>> OfficeMap<Office>.entries: Set<OfficeMapEntry<Office>>
    get() = this.toSet()

fun <Office : Enum<Office>> OfficeMap<Office>.pairs(): Set<Pair<Office, OfficeState>> =
    entries.map { (office, state) -> Pair(office, state) }.toSet()

fun <Office : Enum<Office>> OfficeMap<Office>.toMap(): Map<Office, OfficeState> = pairs().toMap()

/**
 * A default, immutable implementation of [OfficeMap].  As an invariant, its internal [data] map always contains
 * data for each enumerator of [Office].
 */
private class OfficeMapImpl<Office : Enum<Office>> private constructor(private val data: ExhaustiveEnumMap<Office, OfficeState>) : OfficeMap<Office> {
    companion object {
        fun <Office : Enum<Office>> from(
            officeClass: KClass<Office>,
            map: Map<Office, OfficeState>
        ): OfficeMap<Office> {
            map.keys.requireExhaustive(officeClass)
            return OfficeMapImpl(map.toExhaustiveEnumMap(officeClass))
        }

        inline fun <reified Office : Enum<Office>> from(map: Map<Office, OfficeState>) =
            from(Office::class, map)

        private fun OfficeMap<*>.selectEquality(): Set<*> = this.toSet()
    }

    private data class EntryImpl<Office : Enum<Office>>(
        override val office: Office,
        override val state: OfficeState
    ) : OfficeMapEntry<Office>

    override fun get(office: Office): OfficeState {
        return data[office]
    }

    override fun iterator(): Iterator<OfficeMapEntry<Office>> {
        return data.map { (k, v) -> EntryImpl(k, v) }.iterator()
    }

    override fun equals(other: Any?): Boolean {
        if (other !is OfficeMap<*>) return false

        return this.selectEquality() == other.selectEquality()
    }

    override fun hashCode(): Int {
        return this.selectEquality().hashCode()
    }
}

/**
 * A helper for creating a [OfficeMap] from pairs of offices to office states.
 *
 * @param officeClass the reified class of [Office]
 *
 * @throws [IllegalArgumentException] if all enumerators of [Office] do not appear exactly once as the first value in
 * a pair
 */
fun <Office : Enum<Office>> Iterable<Pair<Office, OfficeState>>.toOfficeMap(officeClass: KClass<Office>): OfficeMap<Office> {
    val thisList = this.toList()

    thisList.requireAllAreDistinctBy { it.first }
    thisList.map { it.first }.requireExhaustive(officeClass)

    val uncheckedOfficeMap = thisList.toMap().toExhaustiveEnumMap(officeClass)

    return OfficeMapImpl.from(officeClass, uncheckedOfficeMap)
}

/**
 * A helper for creating a [OfficeMap] from pairs of offices to office states.
 *
 * @throws [IllegalArgumentException] if all enumerators of [Office] do not appear exactly once as the first value in
 * a pair
 */
@JvmName("pairsToOfficeMap")
inline fun <reified Office : Enum<Office>> Iterable<Pair<Office, OfficeState>>.toOfficeMap() =
    this.toOfficeMap(Office::class)

/**
 * A helper for creating a [OfficeMap] from a map of offices to office states.
 *
 * @throws [IllegalArgumentException] if all enumerators of [Office] do not appear exactly once as the first value in
 * a pair
 */
@JvmName("mapToOfficeMap")
inline fun <reified Office : Enum<Office>> Map<Office, OfficeState>.toOfficeMap() =
    map { (k, v) -> k to v }.toOfficeMap()

/**
 * A helper for creating a [OfficeMap] from pairs of offices to (nullable) persons.
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
): OfficeMap<Office> {
    val pairsList = pairs.asList()

    pairsList.requireAllAreDistinctBy { it.first }
    pairsList.map { it.first }.requireExhaustive(officeClass)

    val officeStatePairs = pairsList.map { (office, person) ->
        Pair(
            office,
            when (person) {
                null -> OfficeState.vacant()
                else -> OfficeState.heldBy(person)
            }
        )
    }

    return officeStatePairs.toOfficeMap(officeClass)
}

/**
 * A helper for creating a [OfficeMap] from pairs of offices to (nullable) persons.
 *
 * For each pair, if the [Person] (the second value) is non-null, it is interpreted as the holder of the office.
 * Otherwise, the office is interpreted as being vacant.
 *
 * @throws [IllegalArgumentException] if all enumerators of [Office] do not appear exactly once as the first value in
 * a pair
 */
inline fun <reified Office : Enum<Office>> officeMapOf(vararg pairs: Pair<Office, Person?>) =
    officeMapOf(Office::class, *pairs)

fun <Office : Enum<Office>> endorseOfficer(officeMap: OfficeMap<Office>, office: Office): HalfFunctionVote {
    return when (val officeState = officeMap[office]) {
        is OfficeState.Vacant -> {
            functionVote { _, _ ->
                InextricableVote(
                    "Endorsement of vacant office: ${office.name}"
                )
            }
        }

        is OfficeState.Held -> {
            endorse(officeState.holder)
        }
    }
}
