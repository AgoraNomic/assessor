package org.agoranomic.assessor.dsl.receivers

import org.agoranomic.assessor.dsl.AssessmentDsl
import org.agoranomic.assessor.dsl.DslInit
import org.agoranomic.assessor.dsl.DslValue
import org.agoranomic.assessor.dsl.getOrDefault
import org.agoranomic.assessor.lib.*
import java.math.BigDecimal

@AssessmentDsl
interface ProposalCommonReceiver {
    fun title(str: String)
    fun text(str: String)
    fun author(value: Person)
    fun coauthors(persons: Persons)

    fun adoption_index(value: ProposalAI)
    fun adoption_index(value: Double)
}

fun ProposalCommonReceiver.coauthors(vararg people: Person) = coauthors(Persons.checkingDistinct(people.toList()))

fun ProposalCommonReceiver.adoption_index(value: BigDecimal) = adoption_index(ProposalAI(value))
fun ProposalCommonReceiver.adoption_index(value: Int) = adoption_index(value.toBigDecimal())

fun ProposalCommonReceiver.ai(value: ProposalAI) = adoption_index(value)
fun ProposalCommonReceiver.ai(value: BigDecimal) = adoption_index(value)
fun ProposalCommonReceiver.ai(value: Double) = adoption_index(value)
fun ProposalCommonReceiver.ai(value: Int) = adoption_index(value)

@AssessmentDsl
interface ProposalReceiverV0 : ProposalCommonReceiver

typealias ProposalReceiverV0Init = DslInit<ProposalReceiverV0>

@AssessmentDsl
interface ProposalReceiverV1 : ProposalCommonReceiver {
    fun classless()
    fun democratic()
    fun chamber(chamber: ProposalChamber)
}

typealias ProposalReceiverV1Init = DslInit<ProposalReceiverV1>

@AssessmentDsl
private class ProposalReceiverImplV1(private val number: ProposalNumber) : ProposalReceiverV1 {
    private val titleValue = DslValue<String>()
    private val textValue = DslValue<String>()
    private val aiValue = DslValue<ProposalAI>()
    private val authorValue = DslValue<Person>()
    private var coauthorsValue = DslValue<Persons>()
    private val classAndChamberValue = DslValue<ProposalClassAndChamber>()

    override fun title(str: String) {
        titleValue.set(str)
    }

    override fun text(str: String) {
        textValue.set(str)
    }

    override fun author(value: Person) {
        authorValue.set(value)
    }

    override fun coauthors(persons: Persons) {
        coauthorsValue.set(persons)
    }

    override fun adoption_index(value: ProposalAI) {
        aiValue.set(value)
    }

    override fun adoption_index(value: Double) =
        adoption_index(BigDecimal(((value * 10) + 0.5).toInt()).setScale(1) / BigDecimal.TEN)

    override fun classless() {
        classAndChamberValue.set(ProposalClassAndChamber.Classless)
    }

    override fun democratic() {
        classAndChamberValue.set(ProposalClassAndChamber.DemocraticClass)
    }

    override fun chamber(chamber: ProposalChamber) {
        classAndChamberValue.set(ProposalClassAndChamber.OrdinaryClass(chamber = chamber))
    }

    fun compile(): Proposal {
        val ai = aiValue.get()
        val title = titleValue.get()
        val author = authorValue.get()
        val coauthors = coauthorsValue.getOrDefault(Persons.empty())
        val text = textValue.get()
        val classAndChamber = classAndChamberValue.get()

        return Proposal(
            number,
            ai,
            title,
            author,
            coauthors,
            text.trim(),
            classAndChamber
        )
    }
}

fun buildProposalV1(number: ProposalNumber, block: ProposalReceiverV1Init): Proposal {
    return ProposalReceiverImplV1(number).also(block).compile()
}

// Old proposals are exactly the same as new proposals without a class.
@AssessmentDsl
private class ProposalReceiverImplV0(
    number: ProposalNumber,
    val v1Impl: ProposalReceiverImplV1 = ProposalReceiverImplV1(number)
) : ProposalReceiverV0, ProposalCommonReceiver by v1Impl {
    init {
        v1Impl.classless()
    }

    fun compile(): Proposal = v1Impl.compile()
}

fun buildProposalV0(number: ProposalNumber, block: ProposalReceiverV0Init): Proposal {
    return ProposalReceiverImplV0(number).also(block).compile()
}
