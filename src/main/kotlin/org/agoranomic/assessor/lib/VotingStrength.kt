package org.agoranomic.assessor.lib

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
