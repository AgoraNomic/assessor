package org.agoranomic.assessor.dsl.receivers

import org.agoranomic.assessor.dsl.AssessmentDsl
import org.agoranomic.assessor.dsl.detail.DslInit
import org.agoranomic.assessor.dsl.detail.SetOnce
import org.agoranomic.assessor.dsl.detail.SetOnceFuse
import org.agoranomic.assessor.dsl.detail.getOrDefault
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

interface ProposalClassAndChamberReceiver {
    fun classless()
    fun democratic()
    fun chamber(chamber: ProposalChamber)
}

@AssessmentDsl
interface ProposalReceiverV1 : ProposalCommonReceiver, ProposalClassAndChamberReceiver

typealias ProposalReceiverV1Init = DslInit<ProposalReceiverV1>
typealias ProposalCompilerV1 = ProposalCompiler<ProposalReceiverV1>

@AssessmentDsl
interface ProposalReceiverV2 : ProposalCommonReceiver, ProposalClassAndChamberReceiver {
    /**
     * Marks this proposal as sponsored. If this function is not called, the proposal is unsponsored.
     *
     * @throws IllegalStateException if this function is called more than once
     */
    fun sponsored()
}

typealias ProposalReceiverV2Init = DslInit<ProposalReceiverV2>
typealias ProposalCompilerV2 = ProposalCompiler<ProposalReceiverV2>

@AssessmentDsl
private class ProposalCommonReceiverImpl(private val number: ProposalNumber) : ProposalCommonReceiver {
    private val titleValue = SetOnce.namedOf<String>("title of proposal $number")
    private val textValue = SetOnce.namedOf<String>("text of proposal $number")
    private val aiValue = SetOnce.namedOf<ProposalAI>("AI of proposal $number")
    private val authorValue = SetOnce.namedOf<Person>("author of proposal $number")
    private val coauthorsValue = SetOnce.namedOf<Persons>("coauthors of proposal $number")

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

private class ProposalClassAndChamberReceiverImpl(val number: ProposalNumber) : ProposalClassAndChamberReceiver {
    private val classAndChamberValue =
        SetOnce.namedOf<ProposalClassAndChamber>("class and chamber of proposal $number")

    override fun classless() {
        classAndChamberValue.set(ProposalClassAndChamber.Classless)
    }

    override fun democratic() {
        classAndChamberValue.set(ProposalClassAndChamber.DemocraticClass)
    }

    override fun chamber(chamber: ProposalChamber) {
        classAndChamberValue.set(ProposalClassAndChamber.OrdinaryClass(chamber = chamber))
    }

    fun compile(): ProposalClassAndChamber {
        return classAndChamberValue.get()
    }
}

@AssessmentDsl
private class DefaultProposalReceiverV1(
    number: ProposalNumber,
    val commonImpl: ProposalCommonReceiverImpl = ProposalCommonReceiverImpl(number),
    val classAndChamberImpl: ProposalClassAndChamberReceiverImpl = ProposalClassAndChamberReceiverImpl(number)
) : ProposalReceiverV1, ProposalCommonReceiver by commonImpl, ProposalClassAndChamberReceiver by classAndChamberImpl {
    fun compile(): Proposal {
        return Proposal(
            commonImpl.compile(),
            ProposalDataV1(classAndChamberImpl.compile())
        )
    }
}

class DefaultProposalCompilerV1 : ProposalCompilerV1 {
    override fun compile(number: ProposalNumber, init: ProposalReceiverV1Init): Proposal {
        return DefaultProposalReceiverV1(number).also(init).compile()
    }
}

@AssessmentDsl
private class DefaultProposalReceiverV2(
    number: ProposalNumber,
    val commonImpl: ProposalCommonReceiverImpl = ProposalCommonReceiverImpl(number),
    val classAndChamberImpl: ProposalClassAndChamberReceiverImpl = ProposalClassAndChamberReceiverImpl(number)
) : ProposalReceiverV2, ProposalCommonReceiver by commonImpl, ProposalClassAndChamberReceiver by classAndChamberImpl {
    private val sponsoredFuse = SetOnceFuse.named("sponsored")

    override fun sponsored() {
        sponsoredFuse.blow()
    }

    fun compile(): Proposal {
        return Proposal(
            commonData = commonImpl.compile(),
            versionedData = ProposalDataV2(
                classAndChamber = classAndChamberImpl.compile(),
                sponsored = sponsoredFuse.isBlown()
            )
        )
    }
}

class DefaultProposalCompilerV2 : ProposalCompilerV2 {
    override fun compile(number: ProposalNumber, init: DslInit<ProposalReceiverV2>): Proposal {
        return DefaultProposalReceiverV2(number).also(init).compile()
    }
}
