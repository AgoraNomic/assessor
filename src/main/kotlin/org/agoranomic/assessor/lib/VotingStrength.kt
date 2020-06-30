package org.agoranomic.assessor.lib

import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.ImmutableSet
import kotlinx.collections.immutable.toImmutableMap
import kotlinx.collections.immutable.toImmutableSet
import java.math.BigInteger

typealias RawVotingStrength = BigInteger

inline class VotingStrength(val raw: RawVotingStrength) {
    companion object {
        fun zero() = VotingStrength(0)
    }

    constructor(raw: Int) : this(raw.toBigInteger())

    override fun toString(): String = raw.toString()

    val absoluteValue get() = VotingStrengthDifference(raw)
}

inline class VotingStrengthDifference(val raw: RawVotingStrength) {
    companion object {
        fun zero() = VotingStrengthDifference(0)
    }

    constructor(raw: Int) : this(raw.toBigInteger())

    override fun toString(): String = raw.toString()
}

operator fun VotingStrength.plus(other: VotingStrengthDifference) = VotingStrength((this.raw).plus(other.raw))
operator fun VotingStrengthDifference.plus(other: VotingStrength) = (other).plus(this)

operator fun VotingStrength.minus(other: VotingStrength) = VotingStrengthDifference((this.raw).minus(other.raw))
operator fun VotingStrength.minus(other: VotingStrengthDifference) = VotingStrength((this.raw).minus(other.raw))

operator fun VotingStrengthDifference.plus(other: VotingStrengthDifference) =
    VotingStrengthDifference((this.raw).plus(other.raw))

operator fun VotingStrengthDifference.minus(other: VotingStrengthDifference) =
    VotingStrengthDifference((this.raw).minus(other.raw))

data class VotingStrengthWithComment(val value: VotingStrength, val comment: String? = null)

operator fun VotingStrength.compareTo(other: VotingStrength) = (this.raw).compareTo(other.raw)
operator fun VotingStrengthDifference.compareTo(other: VotingStrengthDifference) = (this.raw).compareTo(other.raw)

operator fun VotingStrengthDifference.unaryMinus() = VotingStrengthDifference(this.raw.unaryMinus())

operator fun VotingStrengthDifference.times(other: RawVotingStrength) = VotingStrengthDifference((this.raw).times(other))
operator fun VotingStrengthDifference.times(other: Int) = this.times(other.toBigInteger())

operator fun RawVotingStrength.times(other: VotingStrengthDifference) = other.times(this)
operator fun Int.times(other: VotingStrengthDifference) = other.times(this)

/**
 * A mapping from [Person]s to [VotingStrengthWithComment]s.
 *
 * Two [VotingStrengthMap]s `first` and `second` are equal iff:
 * - `first.defaultStrength == second.defaultStrength`
 * - `first.specialPeople == second.specialPeople`
 * - For each person in [specialPeople], `first.getOrNull(person) == second.getOrNull(person)`
 */
interface VotingStrengthMap {
    /**
     * The strength to be used for [Person]s who are not in [specialPeople].
     */
    val defaultStrength: VotingStrength

    /**
     * The [Person]s who are have been given an overridden voting strength (as opposed to being left with the default).
     * This voting strength may happen to be equivalent to [defaultStrength], as long as it has been indicated in some
     * way to be different from the default.
     */
    val specialPeople: ImmutableSet<Person>

    /**
     * If [person] is in [specialPeople], returns the (possibly-commented, non-null) voting strength of [person].
     * Otherwise, returns `null`.
     */
    fun getOrNull(person: Person): VotingStrengthWithComment?

    /**
     * If [person] is in [specialPeople], returns `getOrNull(person)`, otherwise returns
     * `VotingStrengthWithComment(defaultStrength)`.
     */
    operator fun get(person: Person): VotingStrengthWithComment =
        getOrNull(person) ?: VotingStrengthWithComment(defaultStrength)
}

/**
 * A [VotingStrengthMap] that is immutable by contract.
 */
interface ImmutableVotingStrengthMap : VotingStrengthMap

abstract class AbstractVotingStrengthMap : VotingStrengthMap {
    companion object {
        private fun VotingStrengthMap.toMap() = specialPeople.associateWith { getOrNull(it)!! }

        // Equality contract includes defaultStrength, specialPeople, and the actual values.
        // The returned Pair includes all three - the defaultStrength (obviously), the specialPeople (in the keys of
        // the map), and the actual values (in the values of the map).
        private fun VotingStrengthMap.selectEquality() = Pair(defaultStrength, toMap())
    }

    final override fun equals(other: Any?): Boolean {
        if (other !is VotingStrengthMap) return false

        return this.selectEquality() == other.selectEquality()
    }

    final override fun hashCode(): Int {
        return this.selectEquality().hashCode()
    }

    override fun toString(): String {
        return "VotingStrengthMap[defaultStrength=$defaultStrength, specialStrengths=${toMap()}]"
    }
}

class SimpleVotingStrengthMap(
    override val defaultStrength: VotingStrength,
    private val strengthMap: ImmutableMap<Person, VotingStrengthWithComment>
) : AbstractVotingStrengthMap(), ImmutableVotingStrengthMap {
    constructor(
        defaultStrength: VotingStrength,
        strengthMap: Map<Person, VotingStrengthWithComment>
    ) : this(
        defaultStrength,
        strengthMap.toImmutableMap()
    )

    override val specialPeople: ImmutableSet<Person> get() = strengthMap.keys

    override fun getOrNull(person: Person) = strengthMap[person]
}

class OverrideVotingStrengthMap(
    val overriden: ImmutableVotingStrengthMap,
    private val overrideMap: ImmutableMap<Person, VotingStrengthWithComment>
) : ImmutableVotingStrengthMap {
    constructor(
        overriden: ImmutableVotingStrengthMap,
        overrideMap: Map<Person, VotingStrengthWithComment>
    ) : this(
        overriden,
        overrideMap.toImmutableMap()
    )

    override val defaultStrength: VotingStrength get() = overriden.defaultStrength
    override val specialPeople: ImmutableSet<Person> get() = (overriden.specialPeople + overrideMap.keys).toImmutableSet()

    override fun getOrNull(person: Person): VotingStrengthWithComment? = overrideMap[person] ?: overriden.getOrNull(person)
}