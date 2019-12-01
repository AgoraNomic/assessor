package org.agoranomic.assessor.lib

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import java.math.BigDecimal

data class Player(val name: String)

typealias ProposalNumber = Int
typealias ProposalAI = BigDecimal

data class Proposal(
    val number: ProposalNumber,
    val ai: ProposalAI,
    val title: String,
    val author: Player,
    val coauthors: ImmutableList<Player>,
    val text: String
) {
    constructor(
        number: ProposalNumber,
        ai: ProposalAI,
        title: String,
        author: Player,
        coauthors: List<Player>,
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
