package org.agoranomic.assessor.dsl.votes

import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.vote.*

private data class ResolvedEndorsementResolvingVote(val endorsee: Person, val resolution: VoteKind?) : ResolvingVote {
    override fun resolveStep(context: ProposalVoteContext): VoteStepResolution {
        return if (resolution != null)
            VoteStepResolution.Resolved.Voted(resolution)
        else
            VoteStepResolution.Continue(InextricableResolvingVote)
    }

    override val currentStepDescription: VoteStepDescription?
        get() = VoteStepDescription(
            readable = if (resolution != null)
                "Endorsement of ${endorsee.name}"
            else
                "Endorsement of non-voter ${endorsee.name}",
            kind = "endorsement",
            parameters = mapOf(
                "endorsee" to endorsee.name,
                "inextricable" to if (resolution == null) "true" else "false",
            ),
        )
}

// Use this wrapper that returns another vote so that the vote's description can include information about its
// resolution. This vote does not return a description so that the next vote in the chain can handle it.
// TODO: make this unnecessary by providing the context to currentStepDescription (making it a function).
private data class EndorsementResolvingVote(val endorsee: Person) : ResolvingVote {
    override fun resolveStep(context: ProposalVoteContext): VoteStepResolution {
        return VoteStepResolution.Continue(
            ResolvedEndorsementResolvingVote(
                endorsee,
                context.resolve(context.currentProposal, endorsee)?.finalResolution(context)?.voteIfVoted,
            ),
        )
    }

    override val currentStepDescription: VoteStepDescription?
        get() = null
}

fun endorse(person: Person): ResolvingVote = EndorsementResolvingVote(person)

object AuthorMarker

private object AuthorEndorsementResolvingVote : ResolvingVote {
    override fun resolveStep(context: ProposalVoteContext): VoteStepResolution {
        return VoteStepResolution.Continue(EndorsementResolvingVote(context.currentProposal.author))
    }

    override val currentStepDescription: VoteStepDescription?
        get() = null
}

// author parameter exists for overloading, so it is kept
@Suppress("UNUSED_PARAMETER")
fun endorse(author: AuthorMarker): ResolvingVote = AuthorEndorsementResolvingVote

private data class ResolvedEndorseOrElseResolvingVote(
    val endorsee: Person,
    val resolution: VoteKind?,
    val default: VoteKind,
) : ResolvingVote {
    override fun resolveStep(context: ProposalVoteContext): VoteStepResolution {
        return if (resolution != null)
            VoteStepResolution.Continue(ResolvedEndorsementResolvingVote(endorsee, resolution))
        else
            VoteStepResolution.Resolved.Voted(default)
    }

    override val currentStepDescription: VoteStepDescription?
        get() =
            if (resolution == null)
                null
            else VoteStepDescription(
                readable = "${endorsee.name} would have been endorsed, but eir vote was inextricable",
                kind = "endorsement_default",
                parameters = mapOf(
                    "endorsee" to endorsee.name,
                    "default" to default.name,
                ),
            )
}

// Similar to EndorsementVote above
private data class EndorseOrElseResolvingVote(val endorsee: Person, val default: VoteKind) : ResolvingVote {
    override fun resolveStep(context: ProposalVoteContext): VoteStepResolution {
        return VoteStepResolution.Continue(
            ResolvedEndorseOrElseResolvingVote(
                endorsee = endorsee,
                resolution = context.resolve(context.currentProposal, endorsee)?.finalResolution(context)?.voteIfVoted,
                default = default,
            )
        )
    }

    override val currentStepDescription: VoteStepDescription?
        get() = null
}

fun endorseOrElse(endorsee: Person, default: VoteKind): ResolvingVote =
    EndorseOrElseResolvingVote(endorsee = endorsee, default = default)
