package org.agoranomic.assessor.dsl.receivers

import org.agoranomic.assessor.dsl.AssessmentDSL
import org.agoranomic.assessor.dsl.DslValue
import org.agoranomic.assessor.lib.*
import java.math.BigDecimal

@AssessmentDSL
interface ProposalCommonReceiver {
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
interface ProposalReceiverV0 : ProposalCommonReceiver

@AssessmentDSL
interface ProposalReceiverV1 : ProposalCommonReceiver {
    fun classless()
    fun democratic()
    fun chamber(chamber: ProposalChamber)
}

@AssessmentDSL
class ProposalReceiverImplV1(private val number: ProposalNumber) : ProposalReceiverV1 {
    private val title = DslValue<String>()
    private val text = DslValue<String>()
    private val ai = DslValue<ProposalAI>()
    private val author = DslValue<Person>()
    private var coauthors = DslValue<Persons>()
    private val classAndChamber = DslValue<ProposalClassAndChamber>()

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

    override fun classless() {
        classAndChamber.set(ProposalClassAndChamber.Classless)
    }

    override fun democratic() {
        classAndChamber.set(ProposalClassAndChamber.DemocraticClass)
    }

    override fun chamber(chamber: ProposalChamber) {
        classAndChamber.set(ProposalClassAndChamber.OrdinaryClass(chamber = chamber))
    }

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
            text.trim(),
            classAndChamber.get()
        )
    }
}

// Old proposals are exactly the same as new proposals without a class.
@AssessmentDSL
class ProposalReceiverImplV0(
    number: ProposalNumber,
    val v1Impl: ProposalReceiverImplV1 = ProposalReceiverImplV1(number)
) : ProposalReceiverV0, ProposalCommonReceiver by v1Impl {
    init {
        v1Impl.classless()
    }

    fun compile(): Proposal = v1Impl.compile()
}
