package org.agoranomic.assessor.lib.voting_strength

import java.math.BigInteger

typealias RawVotingStrength = BigInteger

@JvmInline
value class VotingStrength(val raw: RawVotingStrength) : Comparable<VotingStrength> {
    companion object {
        fun zero() = VotingStrength(0)
    }

    constructor(raw: Int) : this(raw.toBigInteger())

    override fun toString(): String = raw.toString()

    val absoluteValue get() = VotingStrengthDifference(raw)

    override fun compareTo(other: VotingStrength): Int {
        return (this.raw).compareTo(other.raw)
    }
}

@JvmInline
value class VotingStrengthDifference(val raw: RawVotingStrength) : Comparable<VotingStrengthDifference> {
    companion object {
        fun zero() = VotingStrengthDifference(0)
    }

    constructor(raw: Int) : this(raw.toBigInteger())

    override fun toString(): String = raw.toString()

    override fun compareTo(other: VotingStrengthDifference): Int {
        return (this.raw).compareTo(other.raw)
    }
}

operator fun VotingStrength.plus(other: VotingStrengthDifference) = VotingStrength((this.raw).plus(other.raw))
operator fun VotingStrengthDifference.plus(other: VotingStrength) = (other).plus(this)

operator fun VotingStrength.minus(other: VotingStrength) = VotingStrengthDifference((this.raw).minus(other.raw))
operator fun VotingStrength.minus(other: VotingStrengthDifference) = VotingStrength((this.raw).minus(other.raw))

operator fun VotingStrengthDifference.plus(other: VotingStrengthDifference) =
    VotingStrengthDifference((this.raw).plus(other.raw))

operator fun VotingStrengthDifference.minus(other: VotingStrengthDifference) =
    VotingStrengthDifference((this.raw).minus(other.raw))

operator fun VotingStrengthDifference.unaryMinus() = VotingStrengthDifference(this.raw.unaryMinus())

operator fun VotingStrengthDifference.times(other: RawVotingStrength) =
    VotingStrengthDifference((this.raw).times(other))

operator fun VotingStrengthDifference.times(other: Int) = this.times(other.toBigInteger())

operator fun RawVotingStrength.times(other: VotingStrengthDifference) = other.times(this)
operator fun Int.times(other: VotingStrengthDifference) = other.times(this)
