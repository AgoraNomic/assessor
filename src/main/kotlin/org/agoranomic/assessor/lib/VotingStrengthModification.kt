package org.agoranomic.assessor.lib

import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.toImmutableMap

data class VotingStrengthModificationDescription(
    val readable: String,
    val kind: String,
    val parameters: ImmutableMap<String, String>
) {
    companion object {
        fun empty() = VotingStrengthModificationDescription(
            readable = "No change.",
            kind = "unchanged",
            parameters = emptyMap()
        )
    }

    constructor(
        readable: String,
        kind: String,
        parameters: Map<String, String>
    ) : this(
        readable,
        kind,
        parameters.toImmutableMap()
    )
}

interface VotingStrengthModification {
    val description: VotingStrengthModificationDescription
    fun transform(old: VotingStrength): VotingStrength
}

class AdditiveVotingStrengthModification(
    private val addend: VotingStrengthDifference,
    override val description: VotingStrengthModificationDescription
) : VotingStrengthModification {
    override fun transform(old: VotingStrength): VotingStrength {
        return old + addend
    }
}

class ClampVotingStrengthModification(
    private val minValue: VotingStrength?,
    private val maxValue: VotingStrength?
) : VotingStrengthModification {
    init {
        if (minValue != null && maxValue != null) require(minValue <= maxValue)
    }

    override val description: VotingStrengthModificationDescription
        get() = createDescription()

    private fun createDescription(): VotingStrengthModificationDescription {
        if (minValue == null && maxValue == null) return VotingStrengthModificationDescription.empty()

        val readable = when {
            minValue != null && maxValue != null -> "Clamped between $minValue and $maxValue."
            minValue != null -> "Capped at minimum of $minValue."
            maxValue != null -> "Capped at maximum of $maxValue."
            else -> throw IllegalStateException()
        }

        return VotingStrengthModificationDescription(
            readable = readable,
            kind = "clamp",
            parameters = mapOf(
                "min" to (minValue?.toString() ?: "none"),
                "max" to (maxValue?.toString() ?: "none")
            )
        )
    }

    override fun transform(old: VotingStrength): VotingStrength {
        if (minValue != null && old < minValue) return minValue
        if (maxValue != null && old > maxValue) return maxValue
        return old
    }
}
