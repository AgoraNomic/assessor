package org.agoranomic.assessor.lib

/**
 * A [VotingStrengthMap] that (optionally) places caps on its voting strengths. [min] and [max] may both be null, in
 * which case on lower- or upper-bound (respectively) is placed on the voting strengths.
 *
 * @throws IllegalArgumentException if `min` and `max` are both non-null, and `max >= min`
 * @throws IllegalArgumentException if `base.defaultStrength` is less than `min` or more than `max` (if either is non-null).
 */
class CappedVotingStrengthMap(
    private val base: ImmutableVotingStrengthMap,
    private val min: VotingStrength?,
    private val max: VotingStrength?
) : AbstractVotingStrengthMap(), ImmutableVotingStrengthMap {
    init {
        if (min != null && max != null) require(min < max)
        require(base.defaultStrength.isValid())
    }

    private fun VotingStrength.isBelowMin() = min != null && this < min
    private fun VotingStrength.isAboveMax() = max != null && this > max

    private fun VotingStrength.isValid() = !(isBelowMin() || isAboveMax())

    /**
     * Evaluates to `base.defaultStrenth`.
     */
    override val defaultStrength
        get() = base.defaultStrength

    /**
     * Evaluates to `base.specialPeople`.
     */
    override val specialPeople
        get() = base.specialPeople

    /**
     * Let B be the result of `base.getOrNull(person)`.
     * If B is null, returns null.
     * Otherwise, if min is not null, and B.value < min, returns a result with a strength of min.
     * Otherwise, if max is not null, and B.value > max, returns a result with a strength of min.
     * Otherwise, returns B.
     *
     * Note: in the cases where min/max is returned, the comment is not specified.
     */
    override fun getOrNull(person: Person): VotingStrengthWithComment? {
        val baseValue = base.getOrNull(person) ?: return null

        // TODO have better comments
        if (min != null && baseValue.value < min) return VotingStrengthWithComment(min, null)
        if (max != null && baseValue.value > max) return VotingStrengthWithComment(max, null)

        return baseValue
    }
}
