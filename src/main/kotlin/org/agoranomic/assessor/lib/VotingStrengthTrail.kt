package org.agoranomic.assessor.lib

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.toImmutableList
import kotlinx.collections.immutable.toImmutableMap

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

data class VotingStrengthTrailForPersons(
    val default: VotingStrength,
    private val override: ImmutableMap<Person, VotingStrengthTrail>
) {
    companion object {
        fun emptyWithDefault(default: VotingStrength) = VotingStrengthTrailForPersons(default, mapOf())
    }

    constructor(
        default: VotingStrength,
        data: Map<Person, VotingStrengthTrail>
    ) : this(
        default,
        data.toImmutableMap()
    )

    private fun defaultTrail() = VotingStrengthTrail(default, emptyList())

    val overriddenPersons
        get() = override.keys

    fun trailForPerson(person: Person): VotingStrengthTrail {
        return override.getOrElse(person) { defaultTrail() }
    }

    fun finalStrengthForPerson(person: Person): VotingStrength = trailForPerson(person).final

    fun withAppendedToAll(modification: VotingStrengthModification) = VotingStrengthTrailForPersons(
        default,
        override.mapValues { (_, trail) -> trail.withAppended(modification) }
    )

    fun withAppendedToAll(modifications: Iterable<VotingStrengthModification>) = VotingStrengthTrailForPersons(
        default,
        override.mapValues { (_, trail) -> trail.withAppended(modifications) }
    )

    fun overridesMap(): Map<Person, VotingStrengthTrail> = override
    fun overrideStrengthsMap() = overridesMap().mapValues { (_, trail) -> trail.final }
}
