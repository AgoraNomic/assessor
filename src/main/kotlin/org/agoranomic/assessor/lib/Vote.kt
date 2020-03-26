package org.agoranomic.assessor.lib

import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.toImmutableMap

enum class VoteKind { PRESENT, AGAINST, FOR }

sealed class Vote {
    abstract val comment: String?
    abstract fun copyWithComment(newComment: String?): Vote

    abstract fun simplified(): SimpleVote
}

data class InextricableVote(override val comment: String?) : Vote() {
    override fun copyWithComment(newComment: String?) = copy(comment = newComment)
    override fun simplified(): SimpleVote = SimpleVote(
        VoteKind.PRESENT,
        comment = if (comment != null) "Inextricable: $comment" else "Inextricable"
    )
}

data class SimpleVote(val kind: VoteKind, override val comment: String?) : Vote() {
    override fun copyWithComment(newComment: String?) = copy(comment = newComment)
    override fun simplified(): SimpleVote = this
}

data class SingleProposalVoteMap(private val data: ImmutableMap<Person, Vote>) {
    constructor(map: Map<Person, Vote>) : this(map.toImmutableMap())

    val voters get() = data.keys
    val voteCount get() = voters.size

    operator fun get(person: Person) = data[person] ?: throw IllegalArgumentException("Player is not a voter")

    fun simplified(): SimplifiedSingleProposalVoteMap {
        return SimplifiedSingleProposalVoteMap(data.mapValues { (_, vote) -> vote.simplified() })
    }
}

data class MultiProposalVoteMap(private val data: ImmutableMap<ProposalNumber, SingleProposalVoteMap>) {
    constructor(map: Map<ProposalNumber, SingleProposalVoteMap>) : this(map.toImmutableMap())

    val proposals get() = data.keys

    operator fun get(proposal: ProposalNumber) =
        data[proposal] ?: throw IllegalArgumentException("No votes for proposal $proposal")
}
