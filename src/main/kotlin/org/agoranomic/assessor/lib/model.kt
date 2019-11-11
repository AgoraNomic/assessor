package org.agoranomic.assessor.lib

import java.math.BigDecimal

data class Player(val name: String)

typealias ProposalNumber = Int
typealias ProposalAI = BigDecimal

data class Proposal(
    val number: ProposalNumber,
    val ai: ProposalAI,
    val title: String,
    val author: Player,
    val coauthors: List<Player>,
    val text: String
)

fun Iterable<Proposal>.lookupOrFail(number: ProposalNumber): Proposal {
    return this.find { it.number == number } ?: error("No proposal with number $number")
}

fun ProposalNumber.lookupIn(list: Iterable<Proposal>) = list.lookupOrFail(this)
