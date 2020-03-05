package test_objects

import org.agoranomic.assessor.lib.*

fun testProposalNumber(num: TestNumber): ProposalNumber = ProposalNumber(num)
fun testProposalAI(num: TestNumber): ProposalAI = ProposalAI(((num % 100) / 10).toBigDecimal())
fun testProposalTitle(num: TestNumber): String = testString(subReqNum(num), type = "Proposal Title")
fun testProposalAuthor(num: TestNumber): Person = testPlayer(subReqNum(num), type = "Proposal Author")
fun testProposalCoauthor(num: TestNumber): Person = testPlayer(subReqNum(num), type = "Proposal Coauthor")
fun testProposalCoauthors(num: TestNumber) = Persons(testSet(subReqNum(num)) { testProposalCoauthor(it) })
fun testProposalText(num: TestNumber): String = testString(subReqNum(num), type = "Proposal Text")

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

fun testProposal(num: TestNumber): Proposal = Proposal(
    testProposalNumber(subReqNum(num)),
    testProposalAI(subReqNum(num)),
    testProposalTitle(subReqNum(num)),
    testProposalAuthor(subReqNum(num)),
    testProposalCoauthors(subReqNum(num)),
    testProposalText(subReqNum(num)),
    testProposalChamber(subReqNum(num))
)

fun firstTestProposalNumber() = testFirst(::testProposalNumber)
fun secondTestProposalNumber() = testSecond(::testProposalNumber)

fun firstTestProposal() = testFirst(::testProposal)
fun secondTestProposal() = testSecond(::testProposal)
fun thirdTestProposal() = testThird(::testProposal)
