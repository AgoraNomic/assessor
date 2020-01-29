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

data class SingleProposalVoteMap(val map: ImmutableMap<Person, Vote>) {
    constructor(map: Map<Person, Vote>) : this(map.toImmutableMap())

    val voters = map.keys
    val voteCount = voters.size

    operator fun get(person: Person) = map[person] ?: throw IllegalArgumentException("Player is not a voter")
}

data class MultiProposalVoteMap(val map: ImmutableMap<ProposalNumber, SingleProposalVoteMap>) {
    constructor(map: Map<ProposalNumber, SingleProposalVoteMap>) : this(map.toImmutableMap())

    val proposals = map.keys

    operator fun get(proposal: ProposalNumber) =
        map[proposal] ?: throw IllegalArgumentException("No votes for proposal $proposal")
}

data class LookupProposal(val func: (ProposalNumber) -> Proposal) {
    operator fun invoke(number: ProposalNumber) = func(number)
    operator fun invoke(number: Int) = this(ProposalNumber(number))
}

interface VoteContext {
    val lookupProposal: LookupProposal
    fun resolve(proposal: Proposal, voter: Person): Vote?
}

typealias ResolveFunc = (proposal: Proposal, voter: Person) -> Vote?

data class StandardVoteContext(
    val resolveFunc: ResolveFunc,
    override val lookupProposal: LookupProposal
) : VoteContext {
    override fun resolve(proposal: Proposal, voter: Person): Vote? = resolveFunc(proposal, voter)
}

typealias VoteFunc = (proposal: Proposal, context: VoteContext) -> Vote?
