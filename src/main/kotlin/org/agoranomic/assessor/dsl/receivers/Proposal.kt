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

interface ProposalClassAndChamberReceiver<Ministry : AnyMinistry> {
    fun classless()
    fun democratic()
    fun chamber(chamber: Ministry)
}

typealias ProposalClassAndChamberV1Receiver = ProposalClassAndChamberReceiver<MinistryV1>
typealias ProposalClassAndChamberV2Receiver = ProposalClassAndChamberReceiver<MinistryV2>

@AssessmentDsl
interface ProposalReceiverV1 : ProposalCommonReceiver, ProposalClassAndChamberV1Receiver

typealias ProposalReceiverV1Init = DslInit<ProposalReceiverV1>
typealias ProposalCompilerV1 = ProposalCompiler<ProposalReceiverV1>

@AssessmentDsl
interface ProposalSponsoredReceiver {
    /**
     * Marks this proposal as sponsored. If this function is not called, the proposal is unsponsored.
     *
     * @throws IllegalStateException if this function is called more than once
     */
    fun sponsored()
}

@AssessmentDsl
interface ProposalReceiverV2 : ProposalCommonReceiver, ProposalClassAndChamberV1Receiver, ProposalSponsoredReceiver

typealias ProposalReceiverV2Init = DslInit<ProposalReceiverV2>
typealias ProposalCompilerV2 = ProposalCompiler<ProposalReceiverV2>

@AssessmentDsl
interface ProposalReceiverV3 : ProposalCommonReceiver, ProposalClassAndChamberV2Receiver, ProposalSponsoredReceiver

typealias ProposalReceiverV3Init = DslInit<ProposalReceiverV3>
typealias ProposalCompilerV3 = ProposalCompiler<ProposalReceiverV3>

interface ProposalClassV3Receiver {
    fun democratic()
    fun ordinary()
}

@AssessmentDsl
interface ProposalReceiverV4 : ProposalCommonReceiver, ProposalClassV3Receiver, ProposalSponsoredReceiver

typealias ProposalReceiverV4Init = DslInit<ProposalReceiverV4>
typealias ProposalCompilerV4 = ProposalCompiler<ProposalReceiverV4>

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

private class ProposalClassAndChamberV1ReceiverImpl(val number: ProposalNumber) : ProposalClassAndChamberV1Receiver {
    private val classAndChamberValue =
        SetOnce.namedOf<ProposalClassAndChamberV1>("class and chamber of proposal $number")

    override fun classless() {
        classAndChamberValue.set(ProposalClassAndChamberV1.Classless)
    }

    override fun democratic() {
        classAndChamberValue.set(ProposalClassAndChamberV1.DemocraticClass)
    }

    override fun chamber(chamber: MinistryV1) {
        classAndChamberValue.set(ProposalClassAndChamberV1.OrdinaryClass(chamber = chamber))
    }

    fun compile(): ProposalClassAndChamberV1 {
        return classAndChamberValue.get()
    }
}

private class ProposalClassAndChamberV2ReceiverImpl(val number: ProposalNumber) : ProposalClassAndChamberV2Receiver {
    private val classAndChamberValue =
        SetOnce.namedOf<ProposalClassAndChamberV2>("class and chamber of proposal $number")

    override fun classless() {
        classAndChamberValue.set(ProposalClassAndChamberV2.Classless)
    }

    override fun democratic() {
        classAndChamberValue.set(ProposalClassAndChamberV2.DemocraticClass)
    }

    override fun chamber(chamber: MinistryV2) {
        classAndChamberValue.set(ProposalClassAndChamberV2.OrdinaryClass(chamber = chamber))
    }

    fun compile(): ProposalClassAndChamberV2 {
        return classAndChamberValue.get()
    }
}

private class ProposalClassV3ReceiverImpl(val number: ProposalNumber) : ProposalClassV3Receiver {
    private val classAndChamberValue =
        SetOnce.namedOf<ProposalClassV3>("class of proposal $number")

    override fun democratic() {
        classAndChamberValue.set(ProposalClassV3.DEMOCRATIC)
    }

    override fun ordinary() {
        classAndChamberValue.set(ProposalClassV3.ORDINARY)
    }

    fun compile(): ProposalClassV3 {
        return classAndChamberValue.get()
    }
}

@AssessmentDsl
private class DefaultProposalReceiverV1(
    number: ProposalNumber,
    val commonImpl: ProposalCommonReceiverImpl = ProposalCommonReceiverImpl(number),
    val classAndChamberImpl: ProposalClassAndChamberV1ReceiverImpl = ProposalClassAndChamberV1ReceiverImpl(number),
) : ProposalReceiverV1, ProposalCommonReceiver by commonImpl, ProposalClassAndChamberV1Receiver by classAndChamberImpl {
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
    val classAndChamberImpl: ProposalClassAndChamberV1ReceiverImpl = ProposalClassAndChamberV1ReceiverImpl(number),
) : ProposalReceiverV2, ProposalCommonReceiver by commonImpl, ProposalClassAndChamberV1Receiver by classAndChamberImpl {
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

@AssessmentDsl
private class DefaultProposalReceiverV3(
    number: ProposalNumber,
    val commonImpl: ProposalCommonReceiverImpl = ProposalCommonReceiverImpl(number),
    val classAndChamberImpl: ProposalClassAndChamberV2ReceiverImpl = ProposalClassAndChamberV2ReceiverImpl(number),
) : ProposalReceiverV3, ProposalCommonReceiver by commonImpl, ProposalClassAndChamberV2Receiver by classAndChamberImpl {
    private val sponsoredFuse = SetOnceFuse.named("sponsored")

    override fun sponsored() {
        sponsoredFuse.blow()
    }

    fun compile(): Proposal {
        return Proposal(
            commonData = commonImpl.compile(),
            versionedData = ProposalDataV3(
                classAndChamber = classAndChamberImpl.compile(),
                sponsored = sponsoredFuse.isBlown()
            )
        )
    }
}

class DefaultProposalCompilerV3 : ProposalCompilerV3 {
    override fun compile(number: ProposalNumber, init: DslInit<ProposalReceiverV3>): Proposal {
        return DefaultProposalReceiverV3(number).also(init).compile()
    }
}

@AssessmentDsl
private class DefaultProposalReceiverV4(
    number: ProposalNumber,
    val commonImpl: ProposalCommonReceiverImpl = ProposalCommonReceiverImpl(number),
    val classImpl: ProposalClassV3ReceiverImpl = ProposalClassV3ReceiverImpl(number),
) : ProposalReceiverV4, ProposalCommonReceiver by commonImpl, ProposalClassV3Receiver by classImpl {
    private val sponsoredFuse = SetOnceFuse.named("sponsored")

    override fun sponsored() {
        sponsoredFuse.blow()
    }

    fun compile(): Proposal {
        return Proposal(
            commonData = commonImpl.compile(),
            versionedData = ProposalDataV4(
                proposalClass = classImpl.compile(),
                sponsored = sponsoredFuse.isBlown()
            )
        )
    }
}

class DefaultProposalCompilerV4 : ProposalCompilerV4 {
    override fun compile(number: ProposalNumber, init: DslInit<ProposalReceiverV4>): Proposal {
        return DefaultProposalReceiverV4(number).also(init).compile()
    }
}
