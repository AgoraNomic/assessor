package org.agoranomic.assessor.lib

import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.ImmutableSet
import kotlinx.collections.immutable.toImmutableMap
import java.math.BigInteger

typealias RawVotingStrength = BigInteger

inline class VotingStrength(val raw: RawVotingStrength) {
    companion object {
        fun zero() = VotingStrength(0)
    }

    constructor(raw: Int) : this(raw.toBigInteger())
}

operator fun VotingStrength.plus(other: VotingStrength) = VotingStrength(this.raw + other.raw)
operator fun VotingStrength.minus(other: VotingStrength) = VotingStrength(this.raw - other.raw)
operator fun VotingStrength.times(other: RawVotingStrength) = VotingStrength(this.raw * other)
operator fun VotingStrength.times(other: Int) = this * other.toBigInteger()
operator fun VotingStrength.compareTo(other: VotingStrength) = (this.raw).compareTo(other.raw)

operator fun RawVotingStrength.times(other: VotingStrength) = VotingStrength(this * other.raw)
operator fun Int.times(other: VotingStrength) = this.toBigInteger() * other

data class VotingStrengthWithComment(val value: VotingStrength, val comment: String? = null)

interface VotingStrengthMap {
    val defaultStrength: VotingStrength
    val specialPeople: ImmutableSet<Person>

    fun getOpt(person: Person): VotingStrengthWithComment?
    operator fun get(person: Person): VotingStrengthWithComment = getOpt(person) ?: VotingStrengthWithComment(defaultStrength)
}

class SimpleVotingStrengthMap(
    override val defaultStrength: VotingStrength,
    private val strengthMap: ImmutableMap<Person, VotingStrengthWithComment>
) : VotingStrengthMap {
    constructor(
        defaultStrength: VotingStrength,
        strengthMap: Map<Person, VotingStrengthWithComment>
    ) : this(
        defaultStrength,
        strengthMap.toImmutableMap()
    )

    override val specialPeople: ImmutableSet<Person> get() = strengthMap.keys

    override fun getOpt(person: Person) = strengthMap[person]
}
