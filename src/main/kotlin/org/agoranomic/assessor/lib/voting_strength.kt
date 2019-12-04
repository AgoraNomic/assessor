package org.agoranomic.assessor.lib

import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.toImmutableMap

typealias RawVotingStrength = Int

inline class VotingStrength(val raw: RawVotingStrength) {
    companion object {
        fun zero() = VotingStrength(0)
    }
}

operator fun VotingStrength.plus(other: VotingStrength) = VotingStrength(this.raw + other.raw)
operator fun VotingStrength.minus(other: VotingStrength) = VotingStrength(this.raw - other.raw)
operator fun VotingStrength.times(other: RawVotingStrength) = VotingStrength(this.raw * other)
operator fun VotingStrength.compareTo(other: VotingStrength) = (this.raw).compareTo(other.raw)

operator fun RawVotingStrength.times(other: VotingStrength) = VotingStrength(this * other.raw)

data class VotingStrengthWithComment(val value: VotingStrength, val comment: String? = null)

class VotingStrengthMap(
    val defaultStrength: VotingStrength,
    private val strengthMap: ImmutableMap<Player, VotingStrengthWithComment>
) {
    constructor(
        defaultStrength: VotingStrength,
        strengthMap: Map<Player, VotingStrengthWithComment>
    ) : this(
        defaultStrength,
        strengthMap.toImmutableMap()
    )

    val specialPlayers = strengthMap.keys

    operator fun get(player: Player) = strengthMap[player] ?: VotingStrengthWithComment(
        defaultStrength
    )
}
