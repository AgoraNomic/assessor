package org.agoranomic.assessor.lib

import java.math.BigDecimal
import java.math.BigInteger

typealias RawProposalNumber = BigInteger

inline class ProposalNumber(val raw: RawProposalNumber) : Comparable<ProposalNumber> {
    constructor(raw: Int) : this(raw.toBigInteger())
    constructor(raw: Long) : this(raw.toBigInteger())

    override fun compareTo(other: ProposalNumber): Int {
        return (this.raw).compareTo(other.raw)
    }
}

typealias RawProposalAI = BigDecimal

inline class ProposalAI(val raw: RawProposalAI)

data class Proposal(
    val number: ProposalNumber,
    val ai: ProposalAI,
    val title: String,
    val author: Person,
    val coauthors: Persons,
    val text: String,
    val classAndChamber: ProposalClassAndChamber
)

enum class Ministry(val readableName: String) {
    Justice("Justice"),
    Efficiency("Efficiency"),
    Legislation("Legislation"),
    Participation("Participation"),
    Economy("Economy"),
    ;
}

typealias ProposalChamber = Ministry

sealed class ProposalClassAndChamber {
    object Classless : ProposalClassAndChamber()
    object DemocraticClass : ProposalClassAndChamber()
    data class OrdinaryClass(val chamber: ProposalChamber) : ProposalClassAndChamber()
}

/**
 * Indicates that two proposals with the same [number][Proposal.number] but otherwise different data were encountered
 * in a place where that is prohibited.
 * @param next the new proposal with the number, but different data from [original]
 * @param original the first proposal to be encountered with the number
 */
data class ProposalDataMismatchException(
    val next: Proposal,
    val original: Proposal
) : Exception("Proposals with same number but different data found: $next and $original") {
    init {
        require(next.number == original.number)
    }
}

fun checkMismatch(original: Proposal, next: Proposal) {
    require(original.number == next.number)

    if (original != next) {
        throw ProposalDataMismatchException(next = next, original = original)
    }
}
