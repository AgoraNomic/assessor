package org.agoranomic.assessor.lib.dsl_detail

import org.agoranomic.assessor.lib.*

@AssessmentDSL
class _VotingStrengthReceiver {
    private var defaultStrength: VotingStrengthValue? = null
    private var customStrengths = mutableMapOf<Player, _MutableVotingStrength>()

    data class _MutableVotingStrength(val value: VotingStrengthValue, var comment: String? = null)

    infix fun Player.strength(votingStrength: VotingStrengthValue): _MutableVotingStrength {
        val strength =
            _MutableVotingStrength(
                votingStrength
            )
        customStrengths[this] = strength
        return strength
    }

    infix fun _MutableVotingStrength.comment(value: String) {
        this.comment = value
    }

    fun default(strength: VotingStrengthValue) {
        this.defaultStrength = strength
    }

    fun compile(): VotingStrengthMap {
        return VotingStrengthMap(
            defaultStrength ?: error("Must specify default voting strength"),
            customStrengths.mapValues { (_, strength) -> VotingStrength(strength.value, strength.comment) }
        )
    }
}