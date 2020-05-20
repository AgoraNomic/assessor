package org.agoranomic.assessor.lib

import java.math.BigInteger

typealias RawQuorum = BigInteger

inline class Quorum(val raw: RawQuorum) {
    constructor(raw: Int) : this(raw.toBigInteger())

    override fun toString(): String = raw.toString()
}

operator fun Quorum.compareTo(other: Quorum) = (this.raw).compareTo(other.raw)

typealias RawProposalQuorum = Quorum

inline class ProposalQuorum(val raw: RawProposalQuorum) {
    constructor(raw: Int) : this(Quorum(raw))

    override fun toString(): String = raw.toString()
}

typealias RawAssessmentQuorum = Quorum

inline class AssessmentQuorum(val raw: RawAssessmentQuorum) {
    constructor(raw: Int) : this(Quorum(raw))

    override fun toString(): String = raw.toString()
}

