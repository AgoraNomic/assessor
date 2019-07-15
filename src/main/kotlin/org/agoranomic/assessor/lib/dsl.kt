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

data class Endorsement(val endorsee: Player, val isSilent: Boolean)

data class SinglePlayerVoteMap(val votes: Map<ProposalNumber, Vote>, val endorsements: Map<ProposalNumber, Endorsement>)

data class MultiProposalVoteMap(private val map: Map<ProposalNumber, SingleProposalVoteMap>) {
    val proposals = map.keys

    operator fun get(proposal: ProposalNumber) =
        map[proposal] ?: throw IllegalArgumentException("No votes for proposal $proposal")

    fun forEach(block: (ProposalNumber, SingleProposalVoteMap) -> Unit) {
        map.forEach(block)
    }
}

data class AssessmentData(
    val quorum: Int,
    val votingStrengths: VotingStrengthMap,
    val proposals: Set<Proposal>,
    val votes: MultiProposalVoteMap
)

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

        fun default(strength: VotingStrengthValue) {
            this.m_defaultStrength = strength
        }

        fun compile(): VotingStrengthMap {
            return VotingStrengthMap(
                m_defaultStrength ?: error("Must specify default voting strength"),
                m_customStrengths.mapValues { (_, strength) -> VotingStrength(strength.value, strength.comment) }
            )
        }
    }

    fun strengths(block: _VotingStrengthReceiver.() -> Unit) {
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
                    m_ai ?: error("Must specify AI"),
                    m_title ?: error("Must specify proposal title"),
                    m_author ?: error("Must specify author"),
                    m_coauthors ?: emptyList(),
                    m_text ?: error("Must specify proposal text")
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

    class _VotingReciever(private val m_proposals: List<ProposalNumber>) {
        private val m_directVotes = mutableMapOf<Player, Map<ProposalNumber, Vote>>()
        private val m_endorsements = mutableMapOf<Player, Map<ProposalNumber, Endorsement>>()
        private val m_totalEndorsements = mutableMapOf<Player, Player>()

        class _VotesReceiver(private val m_proposals: List<ProposalNumber>, private val player: Player) {
            private val m_map = mutableMapOf<ProposalNumber, _MutableVote>()
            private val m_endorsements = mutableMapOf<ProposalNumber, Endorsement>()

            public class _All
            public val all = _All()

            data class _MutableVote(val value: VoteKind, var comment: String? = null) {
                fun compile() = Vote(value, comment)
            }

            infix fun VoteKind.on(proposal: ProposalNumber): _MutableVote {
                checkProposal(proposal)

                val vote = _MutableVote(this)
                m_map[proposal] = vote
                return vote
            }

            infix fun VoteKind.on(all: _All): _MutableVote {
                val vote = _MutableVote(this)

                for (proposal in m_proposals) {
                    checkProposal(proposal)
                    m_map[proposal] = vote
                }

                return vote
            }

            data class _HalfEndorsement(val endorsee: Player)

            fun endorses(player: Player): _HalfEndorsement {
                return _HalfEndorsement(player)
            }

            private fun checkProposal(proposal: ProposalNumber) {
                require(m_proposals.contains(proposal)) { "No such proposal $proposal" }
                require(!m_map.containsKey(proposal)) { "Vote already specified for proposal $proposal" }
                require(!m_endorsements.containsKey(proposal)) { "Vote already specified for proposal $proposal" }
            }

            infix fun _HalfEndorsement.on(proposal: ProposalNumber) {
                checkProposal(proposal)
                m_endorsements[proposal] = Endorsement(this.endorsee, false)
            }

            infix fun _HalfEndorsement.on(all: _All) {
                for (proposal in m_proposals) {
                    this on proposal
                }
            }

            infix fun _MutableVote.comment(value: String) {
                this.comment = value
            }

            fun compile(): SinglePlayerVoteMap {
                return SinglePlayerVoteMap(m_map.mapValues {
                    (_, value) -> value.compile()
                }, m_endorsements)
            }
        }

        infix fun Player.matches(other: Player) {
            m_totalEndorsements[this] = other
        }

        fun votes(player: Player, block: _VotesReceiver.()->Unit) {
            require(!(m_directVotes.containsKey(player) || m_endorsements.containsKey(player))) { "Votes already specified for player ${player.name}" }

            val receiver = _VotesReceiver(m_proposals, player)
            receiver.block()
            val result = receiver.compile()
            m_directVotes[player] = result.votes
            m_endorsements[player] = result.endorsements
        }

        private fun resolveVote(proposal: ProposalNumber, player: Player, useEndorsementMessage: Boolean, vararg playersSeen: Player): Vote {
            val isEndorsement = playersSeen.isNotEmpty()

            fun Vote.withEndorsementComment(): Vote = if (isEndorsement && useEndorsementMessage) copy(comment = "Endorsement of ${player.name}") else this

            fun inextricableEndorsement(): Vote = Vote(VoteKind.PRESENT, "Endorsement of non-voter ${player.name}")

            val playerDirect = m_directVotes[player]
            if (playerDirect != null && playerDirect.containsKey(proposal)) return m_directVotes[player]!![proposal]!!.withEndorsementComment()

            val playerEndorsements = m_endorsements[player]
            if (playerEndorsements != null && playerEndorsements.containsKey(proposal)) return {
                val endorsee = m_endorsements[player]!![proposal]!!.endorsee
                if (playersSeen.contains(endorsee)) error("Endorsement cycle")

                resolveVote(proposal, endorsee, useEndorsementMessage, *((playersSeen.toList() + player).toTypedArray()))
            }()

            if (isEndorsement) return inextricableEndorsement()
            else throw IllegalArgumentException("No vote information for ${player.name} on proposal $proposal.")
        }

        fun compile(): Map<ProposalNumber, SingleProposalVoteMap> {
            val map = mutableMapOf<ProposalNumber, SingleProposalVoteMap>()

            for (proposal in m_proposals) {
                val proposalMap = mutableMapOf<Player, Vote>()

                for (voter in (m_directVotes.keys + m_endorsements.keys).filter { p ->
                    (m_directVotes[p]?.containsKey(proposal) ?: false) ||
                            (m_endorsements[p]?.containsKey(proposal) ?: false)
                }) {
                    proposalMap[voter] =
                        resolveVote(proposal, voter, m_endorsements[voter]?.get(proposal)?.isSilent?.not() ?: true)
                }

                for (totalEndorsement in m_totalEndorsements) {
                    val endorserVote = proposalMap[totalEndorsement.key]
                    if (endorserVote != null) error("Invalid use of alwaysEndorses: ${totalEndorsement.key.name} voted on proposal $proposal.")

                    val endorseeVote = proposalMap[totalEndorsement.value]
                    if (endorseeVote != null) proposalMap[totalEndorsement.key] = endorseeVote
                }

                map[proposal] = SingleProposalVoteMap(proposalMap)
            }

            return map
        }
    }

    fun voting(block: _VotingReciever.() -> Unit) {
        val receiver = _VotingReciever(m_proposals.map { it.number })
        receiver.block()
        m_proposalVotes.putAll(receiver.compile())
    }

    fun quorum(value: Int) {
        m_quorum = value
    }

    fun compile(): AssessmentData {
        val quorum = m_quorum ?: error("Must specify quorum")
        val votingStrengths = m_votingStrengths ?: error("Must specify voting strengths")
        val proposalVotes = m_proposalVotes

        for (proposalNumber in m_proposalVotes.keys) {
            if (m_proposals.find { it.number == proposalNumber } == null) error("Votes specified for unknown proposal " + proposalNumber)
        }

        for (proposal in m_proposals.map { it.number }) {
            if (!(m_proposalVotes.containsKey(proposal))) error("Votes not specified for proposal " + proposal)
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
