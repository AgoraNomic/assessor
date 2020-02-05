package test_objects

import org.agoranomic.assessor.lib.*

fun testProposalNumber(num: TestNumber): ProposalNumber = ProposalNumber(num)
fun testProposalAI(num: TestNumber): ProposalAI = ProposalAI(((num % 100) / 10).toBigDecimal())
fun testProposalTitle(num: TestNumber): String = testString(subReqNum(num), type = "Proposal Title")
fun testProposalAuthor(num: TestNumber): Person = testPlayer(subReqNum(num), type = "Proposal Author")
fun testProposalCoauthor(num: TestNumber): Person = testPlayer(subReqNum(num), type = "Proposal Coauthor")
fun testProposalCoauthors(num: TestNumber) = testList(subReqNum(num)) { testProposalCoauthor(it) }
fun testProposalText(num: TestNumber): String = testString(subReqNum(num), type = "Proposal Text")

fun testProposal(num: TestNumber): Proposal = Proposal(
    testProposalNumber(subReqNum(num)),
    testProposalAI(subReqNum(num)),
    testProposalTitle(subReqNum(num)),
    testProposalAuthor(subReqNum(num)),
    testProposalCoauthors(subReqNum(num)),
    testProposalText(subReqNum(num))
)

fun firstTestProposalNumber() = testProposalNumber(TEST_ZERO)
fun secondTestProposalNumber() = testProposalNumber(TEST_ONE)

fun firstTestProposal() = testProposal(TEST_ZERO)
fun secondTestProposal() = testProposal(TEST_ONE)
fun thirdTestProposal() = testProposal(TEST_TWO)
