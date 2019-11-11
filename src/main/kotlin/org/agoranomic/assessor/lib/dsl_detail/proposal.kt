package org.agoranomic.assessor.lib.dsl_detail

import org.agoranomic.assessor.lib.*
import java.math.BigDecimal

@AssessmentDSL
class _ProposalReceiver {
    private val number: ProposalNumber
    private var title: String? = null
    private var text: String? = null
    private var votes: SingleProposalVoteMap? = null
    private var ai: ProposalAI? = null
    private var author: Player? = null
    private var coauthors: List<Player>? = null

    constructor(number: ProposalNumber) {
        this.number = number
    }

    fun title(str: String) {
        require(title == null) { "Title specified twice" }
        title = str
    }

    fun text(str: String) {
        require(text == null) { "Text specified twice" }
        text = str
    }

    fun author(value: Player) {
        require(author == null) { "Author specified twice" }
        author = value
    }

    fun coauthors(vararg players: Player) {
        require(coauthors == null) { "Coauthors specified twice" }
        coauthors = players.toList()
    }

    fun adoption_index(value: ProposalAI) {
        require(ai == null) { "Adoption index specified twice" }
        ai = value
    }

    fun adoption_index(value: Double) =
        adoption_index(BigDecimal(((value * 10) + 0.5).toInt()).setScale(1) / BigDecimal.TEN)

    fun adoption_index(value: Int) = adoption_index(value.toDouble())

    fun ai(value: ProposalAI) = adoption_index(value)
    fun ai(value: Double) = adoption_index(value)
    fun ai(value: Int) = adoption_index(value)

    fun compile(): Proposal {
        return Proposal(
            number,
            ai ?: error("Must specify AI"),
            title ?: error("Must specify proposal title"),
            author ?: error("Must specify author"),
            coauthors ?: emptyList(),
            text?.trim() ?: error("Must specify proposal text")
        )
    }
}
