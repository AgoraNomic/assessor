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
}

operator fun VotingStrength.unaryMinus() = VotingStrength(-this.raw)
operator fun VotingStrength.plus(other: VotingStrength) = VotingStrength(this.raw + other.raw)
operator fun VotingStrength.minus(other: VotingStrength) = VotingStrength(this.raw - other.raw)
operator fun VotingStrength.times(other: RawVotingStrength) = VotingStrength(this.raw * other)
operator fun VotingStrength.times(other: Int) = this * other.toBigInteger()
operator fun VotingStrength.compareTo(other: VotingStrength) = (this.raw).compareTo(other.raw)

operator fun RawVotingStrength.times(other: VotingStrength) = VotingStrength(this * other.raw)
operator fun Int.times(other: VotingStrength) = this.toBigInteger() * other

data class VotingStrengthWithComment(val value: VotingStrength, val comment: String? = null)

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
     * If [person] is in [specialPeople], returns the (possibly-commented) voting strength of [person]. Otherwise,
     * returns `null`.
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

class SimpleVotingStrengthMap(
    override val defaultStrength: VotingStrength,
    private val strengthMap: ImmutableMap<Person, VotingStrengthWithComment>
) : ImmutableVotingStrengthMap {
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
