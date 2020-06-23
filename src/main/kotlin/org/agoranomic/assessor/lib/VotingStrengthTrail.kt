package org.agoranomic.assessor.lib

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

data class VotingStrengthTrail(
    val initial: VotingStrength,
    val modifications: ImmutableList<VotingStrengthModification>
) {
    constructor(
        start: VotingStrength,
        modifications: List<VotingStrengthModification>
    ) : this(
        start,
        modifications.toImmutableList()
    )

    val modificationDescriptions
        get() = modifications.map { it.description }

    val final
        get() = modifications.fold(initial) { acc, modification -> modification.transform(acc) }

    fun withAppended(modification: VotingStrengthModification): VotingStrengthTrail {
        return VotingStrengthTrail(initial, modifications + modification)
    }

    fun withAppended(newModifications: Iterable<VotingStrengthModification>): VotingStrengthTrail {
        return VotingStrengthTrail(initial, modifications + newModifications)
    }
}
