package org.agoranomic.assessor.lib

import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.toImmutableMap

enum class VoteKind { PRESENT, AGAINST, FOR }

sealed class Vote {
    abstract val comment: String?
    abstract fun copyWithComment(newComment: String?): Vote

    abstract fun simplify(): SimpleVote
}

data class InextricableVote(override val comment: String?) : Vote() {
    override fun copyWithComment(newComment: String?) = copy(comment = newComment)
    override fun simplify(): SimpleVote = SimpleVote(VoteKind.PRESENT, comment = "Inextricable: $comment")
}

data class SimpleVote(val kind: VoteKind, override val comment: String?) : Vote() {
    override fun copyWithComment(newComment: String?) = copy(comment = newComment)
    override fun simplify(): SimpleVote = this
}

data class SingleProposalVoteMap(val map: ImmutableMap<Player, Vote>) {
    constructor(map: Map<Player, Vote>) : this(map.toImmutableMap())

    val voters = map.keys
    val voteCount = voters.size

    operator fun get(player: Player) = map[player] ?: throw IllegalArgumentException("Player is not a voter")
}

data class MultiProposalVoteMap(val map: Map<ProposalNumber, SingleProposalVoteMap>) {
    val proposals = map.keys

    operator fun get(proposal: ProposalNumber) =
        map[proposal] ?: throw IllegalArgumentException("No votes for proposal $proposal")
}

typealias ResolveFunc = (Proposal, Player) -> Vote?
typealias VoteFunc = (Proposal, ResolveFunc) -> Vote?
