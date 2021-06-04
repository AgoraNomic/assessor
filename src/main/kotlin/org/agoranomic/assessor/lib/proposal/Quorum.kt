package org.agoranomic.assessor.lib.proposal

import org.agoranomic.assessor.lib.vote.SimplifiedSingleProposalVoteMap
import org.randomcat.util.compareTo
import java.math.BigInteger

typealias RawQuorum = BigInteger

@JvmInline
value class Quorum(private val raw: RawQuorum) {
    constructor(raw: Int) : this(raw.toBigInteger())

    override fun toString(): String = raw.toString()

    fun count() = raw
}

operator fun Quorum.compareTo(other: Quorum) = (this.count()).compareTo(other.count())

typealias RawProposalQuorum = Quorum

@JvmInline
value class ProposalQuorum(private val raw: RawProposalQuorum) {
    constructor(raw: Int) : this(Quorum(raw))

    override fun toString(): String = raw.toString()

    fun generic(): Quorum = raw
    fun count() = generic().count()
}

typealias RawAssessmentQuorum = Quorum

@JvmInline
value class AssessmentQuorum(private val raw: RawAssessmentQuorum) {
    constructor(raw: Int) : this(Quorum(raw))

    override fun toString(): String = raw.toString()

    fun generic(): Quorum = raw
    fun count() = generic().count()
}


fun meetsQuorum(votes: SimplifiedSingleProposalVoteMap, quorum: ProposalQuorum) = votes.voteCount >= quorum.count()
fun failsQuorum(votes: SimplifiedSingleProposalVoteMap, quorum: ProposalQuorum) = !meetsQuorum(votes, quorum)
