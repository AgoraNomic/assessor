package org.agoranomic.assessor.lib

import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.toImmutableMap

typealias VotingStrengthValue = Int

data class VotingStrength(val value: VotingStrengthValue, val comment: String? = null)

class VotingStrengthMap(
    val defaultStrength: VotingStrengthValue,
    private val strengthMap: ImmutableMap<Player, VotingStrength>
) {
    constructor(
        defaultStrength: VotingStrengthValue,
        strengthMap: Map<Player, VotingStrength>
    ) : this(
        defaultStrength,
        strengthMap.toImmutableMap()
    )

    val specialPlayers = strengthMap.keys

    operator fun get(player: Player) = strengthMap[player] ?: VotingStrength(
        defaultStrength
    )
}
