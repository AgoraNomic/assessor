package org.agoranomic.assessor.lib.dsl_detail

import org.agoranomic.assessor.lib.*
import java.math.BigDecimal

@AssessmentDSL
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
        require(m_title == null) { "Title specified twice" }
        m_title = str
    }

    fun text(str: String) {
        require(m_text == null) { "Text specified twice" }
        m_text = str
    }

    fun author(value: Player) {
        require(m_author == null) { "Author specified twice" }
        m_author = value
    }

    fun coauthors(vararg players: Player) {
        require(m_coauthors == null) { "Coauthors specified twice" }
        m_coauthors = players.toList()
    }

    fun adoption_index(value: ProposalAI) {
        require(m_ai == null) { "Adoption index specified twice" }
        m_ai = value
    }

    fun adoption_index(value: Double) =
        adoption_index(BigDecimal(((value * 10) + 0.5).toInt()).setScale(1) / BigDecimal.TEN)

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