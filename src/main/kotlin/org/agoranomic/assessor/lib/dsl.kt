package org.agoranomic.assessor.lib

import org.agoranomic.assessor.lib.dsl_detail.*
import java.math.BigDecimal

typealias VotingStrengthValue = Int

data class VotingStrength(val value: VotingStrengthValue, val comment: String? = null)

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

class VotingStrengthMap(
    val defaultStrength: VotingStrengthValue,
    private val strengthMap: Map<Player, VotingStrength>
) {
    val specialPlayers = strengthMap.keys

    operator fun get(player: Player) = strengthMap[player] ?: VotingStrength(
        defaultStrength
    )
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

data class Endorsement(val endorsee: Player, var comment: String?)

data class MultiProposalVoteMap(val map: Map<ProposalNumber, SingleProposalVoteMap>) {
    val proposals = map.keys

    operator fun get(proposal: ProposalNumber) =
        map[proposal] ?: throw IllegalArgumentException("No votes for proposal $proposal")
}

@DslMarker
@Target(AnnotationTarget.CLASS)
annotation class AssessmentDSL

data class AssessmentData(
    val name: String,
    val quorum: Int,
    val votingStrengths: VotingStrengthMap,
    val proposals: Set<Proposal>,
    val votes: MultiProposalVoteMap
)

typealias ResolveFunc = (Proposal, Player) -> Vote?
typealias VoteFunc = (Proposal, ResolveFunc) -> Vote

@AssessmentDSL
class _AssessmentReceiver {
    private var m_votingStrengths: VotingStrengthMap? = null
    private val m_proposals = mutableListOf<Proposal>()
    private var m_proposalVotes = mutableMapOf<ProposalNumber, SingleProposalVoteMap>()
    private var m_quorum: Int? = null
    private var m_name: String? = null

    fun strengths(block: _VotingStrengthReceiver.() -> Unit) {
        require(m_votingStrengths == null) { "Voting strengths specified twice" }

        val receiver = _VotingStrengthReceiver()
        receiver.block()
        m_votingStrengths = receiver.compile()
    }

    fun proposals(block: _ProposalsReceiver.() -> Unit) {
        val receiver = _ProposalsReceiver()
        receiver.block()
        m_proposals += receiver.compile()
    }

    @AssessmentDSL
    class _VotingReciever(private val m_proposals: List<Proposal>) {
        private val m_totalEndorsements = mutableMapOf<Player, Player>()
        private val m_votes = mutableMapOf<Player, Map<ProposalNumber, PendingVote>>()

        infix fun Player.matches(other: Player) {
            m_totalEndorsements[this] = other
        }

        fun votes(player: Player, block: _VotesReceiver.() -> Unit) {
            require(!(m_votes.containsKey(player) || m_totalEndorsements.containsKey(player))) { "Votes already specified for player ${player.name}" }

            val receiver = _VotesReceiver(m_proposals, player)
            receiver.block()
            val result = receiver.compile()

            m_votes[player] = result
        }


        private fun resolveVote(proposal: Proposal, player: Player, vararg playersSeen: Player): Vote? {
            if (playersSeen.contains(player)) return InextricableVote(comment = null)

            val newPlayersSeen = (playersSeen.toList() + player).toTypedArray()
            val nextResolve: ResolveFunc = { nextProp, nextPlayer -> resolveVote(nextProp, nextPlayer, *newPlayersSeen) }

            if (m_totalEndorsements.containsKey(player)) return nextResolve(proposal, m_totalEndorsements.getOrFail(player))

            if (m_votes.containsKey(player)) {
                val playerVotes = m_votes.getOrFail(player)

                if (playerVotes.containsKey(proposal.number)) {
                    return playerVotes.getOrFail(proposal.number).compile(proposal, nextResolve)
                }
            }

            return null
        }

        fun compile(): Map<ProposalNumber, SingleProposalVoteMap> {
            val allProposalVotes = mutableMapOf<ProposalNumber, SingleProposalVoteMap>()

            val allPlayers = (m_votes.keys + m_totalEndorsements.keys).distinct()

            for (proposal in m_proposals) {
                val proposalVotes = mutableMapOf<Player, Vote>()

                for (player in allPlayers) {
                    val vote = resolveVote(proposal, player)
                    if (vote != null) proposalVotes[player] = vote
                }

                allProposalVotes[proposal.number] = SingleProposalVoteMap(proposalVotes)
            }

            return allProposalVotes
        }
    }

    fun voting(block: _VotingReciever.() -> Unit) {
        val receiver = _VotingReciever(m_proposals)
        receiver.block()
        m_proposalVotes.putAll(receiver.compile())
    }

    fun quorum(value: Int) {
        require(m_quorum == null) { "Quorum specified twice" }

        m_quorum = value
    }

    fun name(value: String) {
        require(m_name == null) { "Name specified twice" }

        m_name = value
    }

    fun compile(): AssessmentData {
        val name = m_name ?: error("Must specify name")
        val quorum = m_quorum ?: error("Must specify quorum")
        val votingStrengths = m_votingStrengths ?: error("Must specify voting strengths")

        for (proposalNumber in m_proposalVotes.keys) {
            if (m_proposals.find { it.number == proposalNumber } == null) error("Votes specified for unknown proposal " + proposalNumber)
        }

        for (proposal in m_proposals.map { it.number }) {
            if (!(m_proposalVotes.containsKey(proposal))) error("Votes not specified for proposal " + proposal)
        }

        return AssessmentData(
            name,
            quorum,
            votingStrengths,
            m_proposals.toSet(),
            MultiProposalVoteMap(m_proposalVotes)
        )
    }
}

fun assessment(block: _AssessmentReceiver.() -> Unit): AssessmentData {
    val receiver = _AssessmentReceiver()
    receiver.block()
    return receiver.compile()
}
