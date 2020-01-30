package org.agoranomic.assessor.dsl.receivers

import org.agoranomic.assessor.dsl.AssessmentDSL
import org.agoranomic.assessor.lib.*

@AssessmentDSL
class _VotingStrengthReceiver {
    private var defaultStrength: VotingStrength? = null
    private var customStrengths = mutableMapOf<Person, _MutableVotingStrength>()

    data class _MutableVotingStrength(val value: VotingStrength, var comment: String? = null)

    infix fun Person.strength(votingStrength: VotingStrength): _MutableVotingStrength {
        val strength =
            _MutableVotingStrength(
                votingStrength
            )
        customStrengths[this] = strength
        return strength
    }

    infix fun Person.strength(votingStrength: RawVotingStrength) = this.strength(VotingStrength(votingStrength))
    infix fun Person.strength(votingStrength: Int) = this.strength(VotingStrength(votingStrength))

    infix fun _MutableVotingStrength.comment(value: String) {
        this.comment = value
    }

    fun default(strength: VotingStrength) {
        this.defaultStrength = strength
    }

    fun default(strength: RawVotingStrength) = default(VotingStrength(strength))
    fun default(strength: Int) = default(VotingStrength(strength))

    fun compile(): VotingStrengthMap {
        return SimpleVotingStrengthMap(
            defaultStrength ?: error("Must specify default voting strength"),
            customStrengths.mapValues { (_, strength) -> VotingStrengthWithComment(strength.value, strength.comment) }
        )
    }
}
