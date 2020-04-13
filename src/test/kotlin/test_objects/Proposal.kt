package test_objects

import org.agoranomic.assessor.lib.*
import io.github.random_internet_cat.util.div
import io.github.random_internet_cat.util.rem

fun testProposalNumber(num: TestNumber): ProposalNumber = ProposalNumber(num)
fun firstTestProposalNumber() = testFirst(::testProposalNumber)
fun secondTestProposalNumber() = testSecond(::testProposalNumber)

fun testProposalAI(num: TestNumber): ProposalAI = ProposalAI(((num % 100) / 10).toBigDecimal())
fun firstTestProposalAI() = testFirst(::testProposalAI)
fun secondTestProposalAI() = testSecond(::testProposalAI)

fun testProposalTitle(num: TestNumber): String = testString(subReqNum(num), type = "Proposal Title")
fun firstTestProposalTitle() = testFirst(::testProposalTitle)
fun secondTestProposalTitle() = testSecond(::testProposalTitle)

fun testProposalAuthor(num: TestNumber): Person = testPlayer(subReqNum(num), type = "Proposal Author")
fun firstTestProposalAuthor() = testFirst(::testProposalAuthor)
fun secondTestProposalAuthor() = testSecond(::testProposalAuthor)

fun testProposalCoauthor(num: TestNumber): Person = testPlayer(subReqNum(num), type = "Proposal Coauthor")
fun firstTestProposalCoauthor() = testFirst(::testProposalCoauthor)
fun secondTestProposalCoauthor() = testSecond(::testProposalCoauthor)

fun testProposalCoauthors(num: TestNumber) = Persons(testSet(subReqNum(num)) { testProposalCoauthor(it) })
fun firstTestProposalCoauthors() = testFirst(::testProposalCoauthors)
fun secondTestProposalCoauthors() = testSecond(::testProposalCoauthors)

fun testProposalText(num: TestNumber): String = testString(subReqNum(num), type = "Proposal Text")
fun firstTestProposalText() = testFirst(::testProposalText)
fun secondTestProposalText() = testSecond(::testProposalText)

private enum class ProposalClassAndChamberResult {
    Classless {
        override fun makeWith(num: TestNumber): ProposalClassAndChamber {
            return ProposalClassAndChamber.Classless
        }
    },
    Democratic {
        override fun makeWith(num: TestNumber): ProposalClassAndChamber {
            return ProposalClassAndChamber.DemocraticClass
        }
    },
    Ordinary {
        override fun makeWith(num: TestNumber): ProposalClassAndChamber {
            return ProposalClassAndChamber.OrdinaryClass(testValueOf<ProposalChamber>(num))
        }
    },
    ;

    abstract fun makeWith(num: TestNumber): ProposalClassAndChamber
}

fun testProposalChamber(num: TestNumber): ProposalClassAndChamber {
    return testValueOf<ProposalClassAndChamberResult>(num).makeWith(num)
}

fun firstTestProposalChamber() = testFirst(::testProposalChamber)
fun secondTestProposalChamber() = testSecond(::testProposalChamber)

fun testProposalCommonData(num: TestNumber) = ProposalCommonData(
    number = testProposalNumber(subReqNum(num)),
    ai = testProposalAI(subReqNum(num)),
    title = testProposalTitle(subReqNum(num)),
    author = testProposalAuthor(subReqNum(num)),
    coauthors = testProposalCoauthors(subReqNum(num)),
    text = testProposalText(subReqNum(num))
)

fun testProposalVersionedData(num: TestNumber) = ProposalDataV1(
    testProposalChamber(subReqNum(num))
)

fun testProposal(num: TestNumber): Proposal = Proposal(
    testProposalCommonData(subReqNum(num)),
    testProposalVersionedData(subReqNum(num))
)

fun firstTestProposal() = testFirst(::testProposal)
fun secondTestProposal() = testSecond(::testProposal)
fun thirdTestProposal() = testThird(::testProposal)
