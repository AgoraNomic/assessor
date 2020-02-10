import org.agoranomic.assessor.lib.ProposalNumber
import org.agoranomic.assessor.lib.proposal_set.*
import test_objects.*
import kotlin.test.*

class `ProposalSet tests` {
    @Test
    fun `proposalSetOf works normally`() {
        val firstProp = firstTestProposal()
        val secondProp = secondTestProposal()
        val thirdProp = thirdTestProposal()

        fun assertInvariantsHold(proposalSet: ProposalSet) {
            assertEquals(3, proposalSet.size)
            assertFalse(proposalSet.isEmpty())

            assertTrue(proposalSet.contains(firstProp.number))
            assertTrue(proposalSet.contains(secondProp.number))
            assertTrue(proposalSet.contains(secondProp.number))

            assertEquals(firstProp, proposalSet[firstProp.number])
            assertEquals(secondProp, proposalSet[secondProp.number])
            assertEquals(thirdProp, proposalSet[thirdProp.number])

            assertEquals(firstProp, proposalSet.getOpt(firstProp.number))
            assertEquals(secondProp, proposalSet.getOpt(secondProp.number))
            assertEquals(thirdProp, proposalSet.getOpt(thirdProp.number))

            assertEquals(setOf(firstProp.number, secondProp.number, thirdProp.number), proposalSet.numbers())

            val fourthProp = testProposal(testNumber(3))

            assertFalse(proposalSet.contains(fourthProp.number))
            assertEquals(null, proposalSet.getOpt(fourthProp.number))
            assertFailsWith<NoSuchProposalException> { proposalSet.get(fourthProp.number) }
        }

        assertInvariantsHold(proposalSetOf(firstProp, secondProp, thirdProp))
        assertInvariantsHold(mutableProposalSetOf(firstProp, secondProp, thirdProp))
    }

    @Test
    fun `proposalSetOf throws on duplicate numbers`() {
        val duplicateNumber = ProposalNumber(12) // Arbitrarily picked

        val firstDuplicateProposal = firstTestProposal().copy(number = duplicateNumber)
        val secondDuplicateProposal = secondTestProposal().copy(number = duplicateNumber)
        val nonduplicateProposal = thirdTestProposal()

        assertFailsWith<ProposalDataMismatchException> {
            proposalSetOf(firstDuplicateProposal, secondDuplicateProposal, nonduplicateProposal)
        }

        assertFailsWith<ProposalDataMismatchException> {
            mutableProposalSetOf(firstDuplicateProposal, secondDuplicateProposal, nonduplicateProposal)
        }
    }

    @Test
    fun `two proposalSetOf calls are equal`() {
        val firstProp = firstTestProposal()
        val secondProp = secondTestProposal()
        val thirdProp = thirdTestProposal()

        // Different order is intentional
        assertTrue(proposalSetOf(firstProp, secondProp, thirdProp) == proposalSetOf(thirdProp, secondProp, firstProp))
        assertTrue(mutableProposalSetOf(firstProp, secondProp, thirdProp) == mutableProposalSetOf(thirdProp, secondProp, firstProp))
    }
}
