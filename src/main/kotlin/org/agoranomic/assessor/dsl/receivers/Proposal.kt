package org.agoranomic.assessor.dsl.receivers

import org.agoranomic.assessor.dsl.AssessmentDsl
import org.agoranomic.assessor.dsl.DslInit
import org.agoranomic.assessor.dsl.DslValue
import org.agoranomic.assessor.dsl.getOrDefault
import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.Persons
import org.agoranomic.assessor.lib.emptyPersons
import org.agoranomic.assessor.lib.personsOf
import org.agoranomic.assessor.lib.proposal.*
import java.math.BigDecimal

@AssessmentDsl
interface ProposalCommonReceiver {
    fun title(str: String)
    fun text(str: String)
    fun author(value: Person)
    fun coauthors(persons: Persons)

    fun adoption_index(value: ProposalAI)
}

fun ProposalCommonReceiver.coauthors(vararg people: Person) = coauthors(personsOf(*people))

fun ProposalCommonReceiver.adoption_index(value: BigDecimal) = adoption_index(ProposalAI(value))
fun ProposalCommonReceiver.adoption_index(value: String) = adoption_index(BigDecimal(value))
fun ProposalCommonReceiver.adoption_index(value: Int) = adoption_index(value.toBigDecimal())

fun ProposalCommonReceiver.ai(value: ProposalAI) = adoption_index(value)
fun ProposalCommonReceiver.ai(value: BigDecimal) = adoption_index(value)
fun ProposalCommonReceiver.ai(value: String) = adoption_index(value)
fun ProposalCommonReceiver.ai(value: Int) = adoption_index(value)

interface ProposalCompiler<Receiver : ProposalCommonReceiver> {
    fun compile(number: ProposalNumber, init: DslInit<Receiver>): Proposal
}

@AssessmentDsl
interface ProposalReceiverV0 : ProposalCommonReceiver

typealias ProposalReceiverV0Init = DslInit<ProposalReceiverV0>
typealias ProposalCompilerV0 = ProposalCompiler<ProposalReceiverV0>

@AssessmentDsl
interface ProposalReceiverV1 : ProposalCommonReceiver {
    fun classless()
    fun democratic()
    fun chamber(chamber: ProposalChamber)
}

typealias ProposalReceiverV1Init = DslInit<ProposalReceiverV1>
typealias ProposalCompilerV1 = ProposalCompiler<ProposalReceiverV1>

@AssessmentDsl
private class ProposalCommonReceiverImpl(private val number: ProposalNumber) : ProposalCommonReceiver {
    private val titleValue = DslValue.namedOf<String>("title of proposal $number")
    private val textValue = DslValue.namedOf<String>("text of proposal $number")
    private val aiValue = DslValue.namedOf<ProposalAI>("AI of proposal $number")
    private val authorValue = DslValue.namedOf<Person>("author of proposal $number")
    private val coauthorsValue = DslValue.namedOf<Persons>("coauthors of proposal $number")

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

    fun compile(): ProposalCommonData {
        val ai = aiValue.get()
        val title = titleValue.get()
        val author = authorValue.get()
        val coauthors = coauthorsValue.getOrDefault(emptyPersons())
        val text = textValue.get()

        return ProposalCommonData(
            number,
            ai,
            title,
            author,
            coauthors,
            text.trim()
        )
    }
}

@AssessmentDsl
private class DefaultProposalReceiverV0(
    number: ProposalNumber,
    val commonImpl: ProposalCommonReceiverImpl = ProposalCommonReceiverImpl(number)
) : ProposalReceiverV0, ProposalCommonReceiver by commonImpl {
    fun compile(): Proposal {
        return Proposal(
            commonImpl.compile(),
            ProposalDataV0
        )
    }
}

class DefaultProposalCompilerV0 : ProposalCompilerV0 {
    override fun compile(number: ProposalNumber, init: ProposalReceiverV0Init): Proposal {
        return DefaultProposalReceiverV0(number).also(init).compile()
    }
}

@AssessmentDsl
private class DefaultProposalReceiverV1(
    number: ProposalNumber,
    val commonImpl: ProposalCommonReceiverImpl = ProposalCommonReceiverImpl(number)
) : ProposalReceiverV1, ProposalCommonReceiver by commonImpl {
    private val classAndChamberValue =
        DslValue.namedOf<ProposalClassAndChamber>("class and chamber of proposal $number")

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
        val classAndChamber = classAndChamberValue.get()

        return Proposal(
            commonImpl.compile(),
            ProposalDataV1(classAndChamber)
        )
    }
}

class DefaultProposalCompilerV1 : ProposalCompilerV1 {
    override fun compile(number: ProposalNumber, init: ProposalReceiverV1Init): Proposal {
        return DefaultProposalReceiverV1(number).also(init).compile()
    }
}
