package org.agoranomic.assessor.dsl.receivers

import org.agoranomic.assessor.dsl.AssessmentDSL
import org.agoranomic.assessor.lib.*
import java.math.BigDecimal

@AssessmentDSL
interface ProposalReceiver {
    fun title(str: String)
    fun text(str: String)
    fun author(value: Person)
    fun coauthors(vararg people: Person)

    fun adoption_index(value: ProposalAI)
    fun adoption_index(value: BigDecimal) = adoption_index(ProposalAI(value))
    fun adoption_index(value: Double)
    fun adoption_index(value: Int) = adoption_index(value.toDouble())

    fun ai(value: ProposalAI) = adoption_index(value)
    fun ai(value: BigDecimal) = adoption_index(value)
    fun ai(value: Double) = adoption_index(value)
    fun ai(value: Int) = adoption_index(value)
}

@AssessmentDSL
class ProposalReceiverImpl(private val number: ProposalNumber) : ProposalReceiver {
    private var title: String? = null
    private var text: String? = null
    private var ai: ProposalAI? = null
    private var author: Person? = null
    private var coauthors: List<Person>? = null

    override fun title(str: String) {
        require(title == null) { "Title specified twice" }
        title = str
    }

    override fun text(str: String) {
        require(text == null) { "Text specified twice" }
        text = str
    }

    override fun author(value: Person) {
        require(author == null) { "Author specified twice" }
        author = value
    }

    override fun coauthors(vararg people: Person) {
        require(coauthors == null) { "Coauthors specified twice" }
        coauthors = people.toList()
    }

    override fun adoption_index(value: ProposalAI) {
        require(ai == null) { "Adoption index specified twice" }
        ai = value
    }

    override fun adoption_index(value: Double) =
        adoption_index(BigDecimal(((value * 10) + 0.5).toInt()).setScale(1) / BigDecimal.TEN)

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
