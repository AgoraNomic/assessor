package org.agoranomic.assessor.lib

data class CappedVotingStrengthMap(
    private val base: VotingStrengthMap,
    private val min: VotingStrength?,
    private val max: VotingStrength?
) : VotingStrengthMap {
    init {
        if (min != null && max != null) require(min < max)
        require(base.defaultStrength.isValid())
    }

    private fun VotingStrength.isBelowMin() = min != null && this < min
    private fun VotingStrength.isAboveMax() = max != null && this > max

    private fun VotingStrength.isValid() = !(isBelowMin() || isAboveMax())

    override val defaultStrength
        get() = base.defaultStrength

    override val specialPeople
        get() = base.specialPeople

    override fun getOrNull(person: Person): VotingStrengthWithComment? {
        val baseValue = base.getOrNull(person) ?: return null

        // TODO have better comments
        if (min != null && baseValue.value < min) return VotingStrengthWithComment(min, null)
        if (max != null && baseValue.value > max) return VotingStrengthWithComment(max, null)

        return baseValue
    }
}
