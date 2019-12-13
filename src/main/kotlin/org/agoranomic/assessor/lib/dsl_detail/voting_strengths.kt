package org.agoranomic.assessor.lib.dsl_detail

import org.agoranomic.assessor.lib.*

@AssessmentDSL
class _VotingStrengthReceiver {
    private var defaultStrength: VotingStrength? = null
    private var customStrengths = mutableMapOf<Player, _MutableVotingStrength>()

    data class _MutableVotingStrength(val value: VotingStrength, var comment: String? = null)

    infix fun Player.strength(votingStrength: VotingStrength): _MutableVotingStrength {
        val strength =
            _MutableVotingStrength(
                votingStrength
            )
        customStrengths[this] = strength
        return strength
    }

    infix fun Player.strength(votingStrength: RawVotingStrength) = this.strength(VotingStrength(votingStrength))
    infix fun Player.strength(votingStrength: Int) = this.strength(VotingStrength(votingStrength))

    infix fun _MutableVotingStrength.comment(value: String) {
        this.comment = value
    }

    fun default(strength: VotingStrength) {
        this.defaultStrength = strength
    }

    fun default(strength: RawVotingStrength) = default(VotingStrength(strength))
    fun default(strength: Int) = default(VotingStrength(strength))

    fun compile(): VotingStrengthMap {
        return VotingStrengthMap(
            defaultStrength ?: error("Must specify default voting strength"),
            customStrengths.mapValues { (_, strength) -> VotingStrengthWithComment(strength.value, strength.comment) }
        )
    }
}
