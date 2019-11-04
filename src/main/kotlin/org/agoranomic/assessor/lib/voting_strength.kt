package org.agoranomic.assessor.lib

typealias VotingStrengthValue = Int

data class VotingStrength(val value: VotingStrengthValue, val comment: String? = null)

class VotingStrengthMap(
    val defaultStrength: VotingStrengthValue,
    private val strengthMap: Map<Player, VotingStrength>
) {
    val specialPlayers = strengthMap.keys

    operator fun get(player: Player) = strengthMap[player] ?: VotingStrength(
        defaultStrength
    )
}
