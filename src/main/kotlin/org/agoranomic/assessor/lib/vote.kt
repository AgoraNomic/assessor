package org.agoranomic.assessor.lib

enum class VoteKind { PRESENT, AGAINST, FOR }

sealed class Vote {
    abstract val comment: String?

    abstract fun copyWithComment(newComment: String?): Vote
}

data class InextricableVote(override val comment: String?) : Vote() {
    override fun copyWithComment(newComment: String?) = copy(comment = newComment)
}

data class SimpleVote(val kind: VoteKind, override val comment: String?) : Vote() {
    override fun copyWithComment(newComment: String?) = copy(comment = newComment)
}

data class SingleProposalVoteMap(val map: Map<Player, Vote>) {
    val voters = map.keys
    val voteCount = voters.size

    operator fun get(player: Player) = map[player] ?: throw IllegalArgumentException("Player is not a voter")

    fun forEach(block: (Player, Vote) -> Unit) {
        map.forEach(block)
    }

    fun filterVoteKind(value: VoteKind): Set<Player> {
        return map.filter { (_, v) -> v is SimpleVote }.filterValues { (it as SimpleVote).kind == value }.keys
    }
}

data class MultiProposalVoteMap(val map: Map<ProposalNumber, SingleProposalVoteMap>) {
    val proposals = map.keys

    operator fun get(proposal: ProposalNumber) =
        map[proposal] ?: throw IllegalArgumentException("No votes for proposal $proposal")
}

typealias ResolveFunc = (Proposal, Player) -> Vote?
typealias VoteFunc = (Proposal, ResolveFunc) -> Vote
