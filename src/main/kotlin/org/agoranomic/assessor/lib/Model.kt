package org.agoranomic.assessor.lib

import kotlinx.collections.immutable.ImmutableSet
import kotlinx.collections.immutable.toImmutableSet
import java.math.BigDecimal
import java.math.BigInteger

data class Person(val name: String)

data class Persons(private val set: ImmutableSet<Person>) : Iterable<Person> by set {
    constructor(set: Set<Person>) : this(set.toImmutableSet())
}

typealias RawProposalNumber = BigInteger

inline class ProposalNumber(val raw: RawProposalNumber) {
    constructor(raw: Int) : this(raw.toBigInteger())
    constructor(raw: Long) : this(raw.toBigInteger())
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
 * Thrown when a [ProposalSet] is passed a [Proposal] when it contains a [Proposal] with the same
 * [number][Proposal.number] but with differing other data.
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

    if (original != next) throw ProposalDataMismatchException(
        next = next,
        original = original
    )
}
