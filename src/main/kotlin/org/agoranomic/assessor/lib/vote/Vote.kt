package org.agoranomic.assessor.lib.vote

import kotlinx.collections.immutable.*
import org.agoranomic.assessor.lib.proposal.ProposalNumber

enum class VoteKind { PRESENT, AGAINST, FOR }

data class VoteStepMachineDescription(
    val kind: String,
    val parameters: ImmutableMap<String, String>,
) {
    constructor(
        kind: String,
        parameters: Map<String, String>,
    ) : this(
        kind = kind,
        parameters = parameters.toImmutableMap(),
    )
}

sealed class VoteStepDescription {
    object None : VoteStepDescription()

    data class MachineOnly(val data: VoteStepMachineDescription) : VoteStepDescription() {
        val kind
            get() = data.kind

        val parameters
            get() = data.parameters
    }

    data class WithReadable(val readable: String, val machine: VoteStepMachineDescription) : VoteStepDescription()

    companion object {
        fun tagOnly(kind: String) = MachineOnly(VoteStepMachineDescription(kind = kind, parameters = persistentMapOf()))
    }
}

sealed class VoteStepResolution {
    data class Continue(val nextVote: ResolvingVote) : VoteStepResolution()

    sealed class Resolved : VoteStepResolution() {
        object Abstained : Resolved()
        data class Voted(val resolution: VoteKind) : Resolved()
    }
}

val VoteStepResolution.Resolved.voteIfVoted: VoteKind?
    get() = when (this) {
        is VoteStepResolution.Resolved.Abstained -> null
        is VoteStepResolution.Resolved.Voted -> this.resolution
    }

data class ResolvingVoteResolvedVote(
    val stepDescriptions: ImmutableList<VoteStepDescription>,
    val resolution: VoteKind,
) {
    constructor(
        stepDescriptions: List<VoteStepDescription>,
        resolution: VoteKind,
    ) : this(
        stepDescriptions = stepDescriptions.toImmutableList(),
        resolution = resolution,
    )
}

interface ResolvingVote {
    fun resolveStep(context: ProposalVoteContext): VoteStepResolution
    val currentStepDescription: VoteStepDescription
}

data class ResolvedVote(val value: VoteKind) : ResolvingVote {
    override fun resolveStep(context: ProposalVoteContext): VoteStepResolution {
        return VoteStepResolution.Resolved.Voted(value)
    }

    override val currentStepDescription: VoteStepDescription
        get() = VoteStepDescription.None
}

data class CommentedResolvingVote(val comment: String, val nextVote: ResolvingVote) : ResolvingVote {
    override fun resolveStep(context: ProposalVoteContext): VoteStepResolution {
        return VoteStepResolution.Continue(nextVote)
    }

    override val currentStepDescription: VoteStepDescription
        get() = VoteStepDescription.WithReadable(
            readable = comment,
            machine = VoteStepMachineDescription(
                kind = "commented",
                parameters = mapOf("comment" to comment),
            )
        )
}

object InextricableResolvingVote : ResolvingVote {
    override fun resolveStep(context: ProposalVoteContext): VoteStepResolution {
        return VoteStepResolution.Continue(ResolvedVote(VoteKind.PRESENT))
    }

    override val currentStepDescription: VoteStepDescription
        get() = VoteStepDescription.WithReadable(
            readable = "Inextricable",
            machine = VoteStepMachineDescription(
                kind = "inextricable",
                parameters = emptyMap(),
            )
        )
}

object AbstentionResolvingVote : ResolvingVote {
    override fun resolveStep(context: ProposalVoteContext): VoteStepResolution {
        return VoteStepResolution.Resolved.Abstained
    }

    override val currentStepDescription: VoteStepDescription
        get() = VoteStepDescription.None
}

tailrec fun ResolvingVote.finalResolution(voteContext: ProposalVoteContext): VoteStepResolution.Resolved {
    return when (val resolution = resolveStep(voteContext)) {
        is VoteStepResolution.Continue -> resolution.nextVote.finalResolution(voteContext)
        is VoteStepResolution.Resolved -> resolution
    }
}

fun ResolvingVote.resolveDescriptions(voteContext: ProposalVoteContext): List<VoteStepDescription> {
    return generateSequence(this) {
        when (val resolution = it.resolveStep(voteContext)) {
            is VoteStepResolution.Continue -> resolution.nextVote
            is VoteStepResolution.Resolved -> null
        }
    }.map { it.currentStepDescription }.toList()
}

data class MultiProposalVoteMap(private val data: ImmutableMap<ProposalNumber, SimplifiedSingleProposalVoteMap>) {
    constructor(map: Map<ProposalNumber, SimplifiedSingleProposalVoteMap>) : this(map.toImmutableMap())

    val proposals get() = data.keys

    operator fun get(proposal: ProposalNumber) =
        data[proposal] ?: throw IllegalArgumentException("No votes for proposal $proposal")
}
