package org.agoranomic.assessor.dsl.receivers

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import org.agoranomic.assessor.dsl.AssessmentDSL
import org.agoranomic.assessor.dsl.DslValue
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
    private val title = DslValue<String>()
    private val text = DslValue<String>()
    private val ai = DslValue<ProposalAI>()
    private val author = DslValue<Person>()
    private var coauthors = DslValue<Persons>()

    override fun title(str: String) {
        title.set(str)
    }

    override fun text(str: String) {
        text.set(str)
    }

    override fun author(value: Person) {
        author.set(value)
    }

    override fun coauthors(vararg people: Person) {
        coauthors.set(Persons(people.toList()))
    }

    override fun adoption_index(value: ProposalAI) {
        ai.set(value)
    }

    override fun adoption_index(value: Double) =
        adoption_index(BigDecimal(((value * 10) + 0.5).toInt()).setScale(1) / BigDecimal.TEN)

    fun compile(): Proposal {
        val ai = ai.get()
        val title = title.get()
        val author = author.get()
        val coauthors = coauthors.getOrElse(Persons(emptyList()))
        val text = text.get()

        return Proposal(
            number,
            ai,
            title,
            author,
            coauthors,
            text.trim()
        )
    }
}
