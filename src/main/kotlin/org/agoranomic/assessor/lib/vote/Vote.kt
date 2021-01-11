package org.agoranomic.assessor.lib.vote

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.toImmutableList
import kotlinx.collections.immutable.toImmutableMap
import org.agoranomic.assessor.lib.proposal.ProposalNumber

enum class VoteKind { PRESENT, AGAINST, FOR }

data class VoteStepDescription(
    val readable: String,
    val kind: String,
    val parameters: ImmutableMap<String, String>,
) {
    constructor(
        readable: String,
        kind: String,
        parameters: Map<String, String>,
    ) : this(
        readable = readable,
        kind = kind,
        parameters = parameters.toImmutableMap(),
    )
}

sealed class VoteStepResolution {
    data class Continue(val nextVote: ResolvingVote) : VoteStepResolution()

    sealed class Resolved : VoteStepResolution() {
        object Abstained : Resolved()
        data class Voted(val resolution: VoteKind) : Resolved()
    }
}

data class ResolvingVoteResolvedVote(
    val stepDescriptions: ImmutableList<VoteStepDescription?>,
    val resolution: VoteKind,
) {
    constructor(
        stepDescriptions: List<VoteStepDescription?>,
        resolution: VoteKind,
    ) : this(
        stepDescriptions = stepDescriptions.toImmutableList(),
        resolution = resolution,
    )
}

interface ResolvingVote {
    fun resolveStep(context: ProposalVoteContext): VoteStepResolution
    val currentStepDescription: VoteStepDescription?
}

data class ResolvedVote(val value: VoteKind) : ResolvingVote {
    override fun resolveStep(context: ProposalVoteContext): VoteStepResolution {
        return VoteStepResolution.Resolved.Voted(value)
    }

    override val currentStepDescription: VoteStepDescription?
        get() = null
}

data class CommentedResolvingVote(val comment: String, val nextVote: ResolvingVote) : ResolvingVote {
    override fun resolveStep(context: ProposalVoteContext): VoteStepResolution {
        return VoteStepResolution.Continue(nextVote)
    }

    override val currentStepDescription: VoteStepDescription
        get() = VoteStepDescription(
            readable = comment,
            kind = "commented",
            parameters = mapOf("comment" to comment),
        )
}

object InextricableResolvingVote : ResolvingVote {
    override fun resolveStep(context: ProposalVoteContext): VoteStepResolution {
        return VoteStepResolution.Continue(ResolvedVote(VoteKind.PRESENT))
    }

    override val currentStepDescription: VoteStepDescription
        get() = VoteStepDescription(
            readable = "Inextricable",
            kind = "inextricable",
            parameters = emptyMap(),
        )

}

object AbstentionResolvingVote : ResolvingVote {
    override fun resolveStep(context: ProposalVoteContext): VoteStepResolution {
        return VoteStepResolution.Resolved.Abstained
    }

    override val currentStepDescription: VoteStepDescription?
        get() = null
}

tailrec fun ResolvingVote.finalResolution(voteContext: ProposalVoteContext): VoteStepResolution.Resolved {
    return when (val resolution = resolveStep(voteContext)) {
        is VoteStepResolution.Continue -> resolution.nextVote.finalResolution(voteContext)
        is VoteStepResolution.Resolved -> resolution
    }
}

fun ResolvingVote.resolveDescriptions(voteContext: ProposalVoteContext): List<VoteStepDescription?> {
    return generateSequence(this) {
        when (val resolution = it.resolveStep(voteContext)) {
            is VoteStepResolution.Continue -> resolution.nextVote
            is VoteStepResolution.Resolved -> null
        }
    }.map { it.currentStepDescription }.toList()
}

sealed class Vote {
    abstract val comment: String?
    abstract fun copyWithComment(newComment: String?): Vote

    abstract fun simplified(): SimpleVote

    abstract fun asResolvingVote(): ResolvingVote
}

data class InextricableVote(override val comment: String?) : Vote() {
    override fun copyWithComment(newComment: String?) = copy(comment = newComment)
    override fun simplified(): SimpleVote = SimpleVote(
        VoteKind.PRESENT,
        comment = if (comment != null) "Inextricable: $comment" else "Inextricable"
    )

    override fun asResolvingVote(): ResolvingVote {
        return if (comment != null)
            CommentedResolvingVote(comment = comment, nextVote = InextricableResolvingVote)
        else
            InextricableResolvingVote
    }
}

data class SimpleVote(val kind: VoteKind, override val comment: String?) : Vote() {
    override fun copyWithComment(newComment: String?) = copy(comment = newComment)
    override fun simplified(): SimpleVote = this

    override fun asResolvingVote(): ResolvingVote {
        return ResolvedVote(kind).let {
            if (comment != null) CommentedResolvingVote(comment = comment, nextVote = it) else it
        }
    }
}

data class MultiProposalVoteMap(private val data: ImmutableMap<ProposalNumber, SimplifiedSingleProposalVoteMap>) {
    constructor(map: Map<ProposalNumber, SimplifiedSingleProposalVoteMap>) : this(map.toImmutableMap())

    val proposals get() = data.keys

    operator fun get(proposal: ProposalNumber) =
        data[proposal] ?: throw IllegalArgumentException("No votes for proposal $proposal")
}
