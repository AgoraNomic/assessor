package org.agoranomic.assessor.lib.voting_strength

import kotlinx.collections.immutable.*
import org.agoranomic.assessor.lib.Person

sealed class VotingStrengthStep {
    abstract val value: VotingStrength

    data class Initial(
        val description: VotingStrengthModificationDescription?,
        override val value: VotingStrength,
    ) : VotingStrengthStep()

    data class Modification(
        val modification: VotingStrengthModification,
        override val value: VotingStrength,
    ) : VotingStrengthStep()
}

data class VotingStrengthTrail(
    val initial: VotingStrength,
    val initialDescription: VotingStrengthModificationDescription?,
    val modifications: ImmutableList<VotingStrengthModification>,
) {
    constructor(
        start: VotingStrength,
        initialDescription: VotingStrengthModificationDescription?,
        modifications: List<VotingStrengthModification>,
    ) : this(
        start,
        initialDescription,
        modifications.toImmutableList()
    )

    val final
        get() = modifications.fold(initial) { acc, modification -> modification.transform(acc) }

    fun steps(): List<VotingStrengthStep> {
        return modifications.scan(
            VotingStrengthStep.Initial(initialDescription, initial) as VotingStrengthStep,
        ) { acc, modification ->
            VotingStrengthStep.Modification(modification, modification.transform(acc.value))
        }
    }

    /**
     * Returns a list containing each modification along with the value at that point. This is equivalent to
     * [stepsWithValues], excluding the first entry.
     *
     * For example, if the initial strength is 3 and the modifications are (+2) and (*4), the result will be the
     * following:
     * - ((+2), 5)
     * - ((*4), 20)
     */
    fun modificationsWithValue(): List<Pair<VotingStrengthModification, VotingStrength>> {
        val steps = steps()
        check(steps.isNotEmpty())

        val modifications = steps.drop(1)
        check(modifications.all { it is VotingStrengthStep.Modification })

        return modifications.map { it as VotingStrengthStep.Modification }.map { it.modification to it.value }
    }

    fun withAppended(modification: VotingStrengthModification): VotingStrengthTrail {
        return copy(modifications = modifications.toPersistentList().add(modification))
    }

    fun withAppended(newModifications: Collection<VotingStrengthModification>): VotingStrengthTrail {
        return copy(modifications = modifications.toPersistentList().addAll(newModifications))
    }
}

data class VotingStrengthTrailForPersons(
    val default: VotingStrength,
    val defaultDescription: VotingStrengthModificationDescription?,
    private val override: ImmutableMap<Person, VotingStrengthTrail>,
) {
    companion object {
        fun emptyWithDefault(
            default: VotingStrength,
            defaultDescription: VotingStrengthModificationDescription?,
        ) = VotingStrengthTrailForPersons(
            default = default,
            defaultDescription = defaultDescription,
            data = mapOf(),
        )
    }

    constructor(
        default: VotingStrength,
        defaultDescription: VotingStrengthModificationDescription?,
        data: Map<Person, VotingStrengthTrail>,
    ) : this(
        default,
        defaultDescription,
        data.toImmutableMap()
    )

    private fun defaultTrail() = VotingStrengthTrail(default, defaultDescription, emptyList())

    val overriddenPersons
        get() = override.keys

    fun hasOverrideFor(person: Person): Boolean {
        return override.containsKey(person)
    }

    fun trailForPerson(person: Person): VotingStrengthTrail {
        return override.getOrElse(person) { defaultTrail() }
    }

    fun finalStrengthForPerson(person: Person): VotingStrength = trailForPerson(person).final

    fun withAppendedToAll(modification: VotingStrengthModification) = copy(
        override = override.mapValues { (_, trail) -> trail.withAppended(modification) }.toImmutableMap(),
    )

    fun withAppendedToAll(modifications: Collection<VotingStrengthModification>) = copy(
        override = override.mapValues { (_, trail) -> trail.withAppended(modifications) }.toImmutableMap(),
    )

    fun overridesMap(): Map<Person, VotingStrengthTrail> = override
    fun overrideStrengthsMap() = overridesMap().mapValues { (_, trail) -> trail.final }
}
