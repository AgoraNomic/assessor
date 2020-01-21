package org.agoranomic.assessor.lib

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import java.math.BigDecimal
import java.math.BigInteger

data class Person(val name: String)

data class Persons(private val list: ImmutableList<Person>) : Iterable<Person> by list {
    constructor(list: List<Person>) : this(list.toImmutableList())
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
    val text: String
)

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

fun Iterable<Proposal>.lookupOrFail(number: ProposalNumber): Proposal {
    return this.find { it.number == number } ?: error("No proposal with number $number")
}

fun ProposalNumber.lookupIn(list: Iterable<Proposal>) = list.lookupOrFail(this)
