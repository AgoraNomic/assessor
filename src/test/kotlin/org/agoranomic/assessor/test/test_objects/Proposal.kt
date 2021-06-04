package org.agoranomic.assessor.test.test_objects

import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.Persons
import org.agoranomic.assessor.lib.proposal.*
import org.randomcat.util.div
import org.randomcat.util.rem
import java.math.BigDecimal

fun testProposalNumber(num: TestNumber): ProposalNumber = ProposalNumber(num)
fun firstTestProposalNumber() = testFirst(::testProposalNumber)
fun secondTestProposalNumber() = testSecond(::testProposalNumber)

fun testAI(num: TestNumber): BigDecimal = ((num % 100) / 10).toBigDecimal()
fun firstTestAI() = testFirst(::testAI)
fun secondTestProposalAI() = testSecond(::testAI)

fun testProposalTitle(num: TestNumber): String = testString(subReqNum(num), type = "Proposal Title")
fun firstTestProposalTitle() = testFirst(::testProposalTitle)
fun secondTestProposalTitle() = testSecond(::testProposalTitle)

fun testProposalAuthor(num: TestNumber): Person = testPerson(subReqNum(num), type = "Proposal Author")
fun firstTestProposalAuthor() = testFirst(::testProposalAuthor)
fun secondTestProposalAuthor() = testSecond(::testProposalAuthor)

fun testProposalCoauthor(num: TestNumber): Person = testPerson(subReqNum(num), type = "Proposal Coauthor")
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
        override fun makeWith(num: TestNumber): ProposalClassAndChamberV1 {
            return ProposalClassAndChamberV1.Classless
        }
    },
    Democratic {
        override fun makeWith(num: TestNumber): ProposalClassAndChamberV1 {
            return ProposalClassAndChamberV1.DemocraticClass
        }
    },
    Ordinary {
        override fun makeWith(num: TestNumber): ProposalClassAndChamberV1 {
            return ProposalClassAndChamberV1.OrdinaryClass(testValueOf<MinistryV1>(num))
        }
    },
    ;

    abstract fun makeWith(num: TestNumber): ProposalClassAndChamberV1
}

fun testProposalChamber(num: TestNumber): ProposalClassAndChamberV1 {
    return testValueOf<ProposalClassAndChamberResult>(num).makeWith(num)
}

fun firstTestProposalChamber() = testFirst(::testProposalChamber)
fun secondTestProposalChamber() = testSecond(::testProposalChamber)

fun testProposalCommonData(num: TestNumber) = ProposalCommonData(
    number = testProposalNumber(subReqNum(num)),
    proposalAI = ProposalAI(testAI(subReqNum(num))),
    decisionAI = DecisionAI(testAI(subReqNum(num))),
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
