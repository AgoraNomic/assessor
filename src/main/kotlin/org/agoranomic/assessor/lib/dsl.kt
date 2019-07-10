package org.agoranomic.assessor.lib

import java.math.BigDecimal

typealias VotingStrengthValue = Int

data class VotingStrength(val value: VotingStrengthValue, val comment: String? = null)

enum class VoteKind { PRESENT, AGAINST, FOR }
data class Vote(val kind: VoteKind, val comment: String?)

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
        return map.filterValues { it.kind == value }.keys
    }
}

data class MultiProposalVoteMap(private val map: Map<ProposalNumber, SingleProposalVoteMap>) {
    val proposals = map.keys

    operator fun get(proposal: ProposalNumber) =
        map[proposal] ?: throw IllegalArgumentException("No votes for proposal $proposal")

    fun forEach(block: (ProposalNumber, SingleProposalVoteMap) -> Unit) {
        map.forEach(block)
    }
}

data class AssessmentData(val quorum: Int, val votingStrengths: VotingStrengthMap, val proposals: Set<Proposal>, val votes: MultiProposalVoteMap)

class _AssessmentReceiver {

    private var m_votingStrengths: VotingStrengthMap? = null
    private val m_proposals = mutableListOf<Proposal>()
    private var m_proposalVotes = mutableMapOf<ProposalNumber, SingleProposalVoteMap>()
    private var m_quorum: Int? = null

    class _VotingStrengthReceiver {
        private var m_defaultStrength: VotingStrengthValue? = null
        private var m_customStrengths = mutableMapOf<Player, _MutableVotingStrength>()

        data class _MutableVotingStrength(val value: VotingStrengthValue, var comment: String? = null)

        infix fun Player.strength(votingStrength: VotingStrengthValue): _MutableVotingStrength {
            val strength =
                _MutableVotingStrength(
                    votingStrength
                )
            m_customStrengths[this] = strength
            return strength
        }

        infix fun _MutableVotingStrength.comment(value: String) {
            this.comment = value
        }

        fun defaultStrength(strength: VotingStrengthValue) {
            this.m_defaultStrength = strength
        }

        fun compile(): VotingStrengthMap {
            return VotingStrengthMap(
                m_defaultStrength ?: throw IllegalStateException("Must specify default voting strength"),
                m_customStrengths.mapValues { (_, strength) ->
                    VotingStrength(
                        strength.value,
                        strength.comment
                    )
                }
            )
        }
    }

    fun votingStrength(block: _VotingStrengthReceiver.() -> Unit) {
        val receiver = _VotingStrengthReceiver()
        receiver.block()
        m_votingStrengths = receiver.compile()
    }

    class _ProposalsReceiver {
        private val m_proposals = mutableListOf<Proposal>()

        class _ProposalReceiver {
            private val m_number: ProposalNumber
            private var m_title: String? = null
            private var m_text: String? = null
            private var m_votes: SingleProposalVoteMap? = null
            private var m_ai: ProposalAI? = null
            private var m_author: Player? = null
            private var m_coauthors: List<Player>? = null

            constructor(number: ProposalNumber) {
                this.m_number = number
            }

            fun title(str: String) {
                m_title = str
            }

            fun text(str: String) {
                m_text = str
            }

            fun author(value: Player) {
                m_author = value
            }

            fun coauthors(vararg players: Player) {
                m_coauthors = players.toList()
            }

            fun adoption_index(value: ProposalAI) {
                m_ai = value
            }

            fun adoption_index(value: Double) =
                adoption_index(BigDecimal((value * 10).toInt()).setScale(1) / BigDecimal.TEN)

            fun adoption_index(value: Int) = adoption_index(value.toDouble())

            fun ai(value: ProposalAI) = adoption_index(value)
            fun ai(value: Double) = adoption_index(value)
            fun ai(value: Int) = adoption_index(value)

            fun compile(): Proposal {
                return Proposal(
                    m_number,
                    m_ai ?: throw IllegalStateException("Must specify AI"),
                    m_title ?: throw IllegalStateException("Must specify proposal title"),
                    m_author ?: throw IllegalStateException("Must specify author"),
                    m_coauthors ?: emptyList(),
                    m_text ?: throw IllegalStateException("Must specify proposal text")
                )
            }
        }

        fun proposal(number: ProposalNumber, block: _ProposalReceiver.() -> Unit) {
            val receiver = _ProposalReceiver(number)
            receiver.block()
            using(receiver.compile())
        }

        fun using(proposal: Proposal) {
            m_proposals += proposal
        }

        fun using(proposals: Collection<Proposal>) {
            proposals.forEach(::using)
        }

        fun compile(): List<Proposal> = m_proposals
    }

    fun proposals(block: _ProposalsReceiver.() -> Unit) {
        val receiver = _ProposalsReceiver()
        receiver.block()
        m_proposals += receiver.compile()
    }

    class _VotingReciever {
        private val m_votes = mutableMapOf<ProposalNumber, SingleProposalVoteMap>()

        class _VotesReceiver(private val proposal: ProposalNumber) {
            private val m_map = mutableMapOf<Player, _MutableVote>()

            data class _MutableVote(val value: VoteKind, var comment: String? = null)

            infix fun Player.votes(value: VoteKind): _MutableVote {
                val vote =
                    _MutableVote(value)
                m_map[this] = vote
                return vote
            }

            infix fun _MutableVote.comment(value: String) {
                this.comment = value
            }

            fun compile(): SingleProposalVoteMap {
                return SingleProposalVoteMap(m_map.mapValues { (_, vote) ->
                    Vote(
                        vote.value,
                        vote.comment
                    )
                })
            }
        }

        fun votes(proposal: ProposalNumber, block: _VotesReceiver.() -> Unit) {
            val receiver = _VotesReceiver(proposal)
            receiver.block()
            m_votes[proposal] = receiver.compile()
        }

        fun compile(): Map<ProposalNumber, SingleProposalVoteMap> {
            return m_votes
        }
    }

    fun voting(block: _VotingReciever.() -> Unit) {
        val receiver = _VotingReciever()
        receiver.block()
        m_proposalVotes.putAll(receiver.compile())
    }

    fun quorum(value: Int) {
        m_quorum = value
    }

    fun compile(): AssessmentData {
        val quorum = m_quorum ?: throw IllegalStateException("Must specify quorum")
        val votingStrengths = m_votingStrengths ?: throw IllegalStateException("Must specify voting strengths")
        val proposalVotes = m_proposalVotes ?: throw IllegalStateException("Must specify votes")

        for (proposalNumber in m_proposalVotes.keys) {
            if (m_proposals.find { it.number == proposalNumber } == null) throw IllegalStateException("Votes specified for unknown proposal " + proposalNumber)
        }

        for (proposal in m_proposals.map { it.number }) {
            if (!(m_proposalVotes.containsKey(proposal))) throw IllegalStateException("Votes not specified for proposal " + proposal)
        }

        return AssessmentData(
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
