package org.agoranomic.assessor.lib

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import java.math.BigDecimal
import java.math.BigInteger

data class Person(val name: String)

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
    val coauthors: ImmutableList<Person>,
    val text: String
) {
    constructor(
        number: ProposalNumber,
        ai: ProposalAI,
        title: String,
        author: Person,
        coauthors: List<Person>,
        text: String
    ) : this(
        number,
        ai,
        title,
        author,
        coauthors.toImmutableList(),
        text
    )
}

fun Iterable<Proposal>.lookupOrFail(number: ProposalNumber): Proposal {
    return this.find { it.number == number } ?: error("No proposal with number $number")
}

fun ProposalNumber.lookupIn(list: Iterable<Proposal>) = list.lookupOrFail(this)
