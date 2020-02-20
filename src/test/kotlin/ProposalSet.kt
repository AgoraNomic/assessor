import org.agoranomic.assessor.lib.ProposalDataMismatchException
import org.agoranomic.assessor.lib.ProposalNumber
import org.agoranomic.assessor.lib.proposal_set.*
import test_objects.*
import kotlin.test.*

class `ProposalSet tests` {
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

        fun assertEqualAndHashCode(first: ProposalSet, second: ProposalSet) {
            assertTrue(first == second)
            assertTrue(first.hashCode() == second.hashCode())
        }

        // Different order is intentional
        assertEqualAndHashCode(
            proposalSetOf(firstProp, secondProp, thirdProp),
            proposalSetOf(thirdProp, secondProp, firstProp)
        )

        assertEqualAndHashCode(
            mutableProposalSetOf(firstProp, secondProp, thirdProp),
            mutableProposalSetOf(thirdProp, secondProp, firstProp)
        )

        assertEqualAndHashCode(
            proposalSetOf(firstProp, secondProp, thirdProp),
            mutableProposalSetOf(thirdProp, secondProp, firstProp)
        )

        assertEqualAndHashCode(
            mutableProposalSetOf(firstProp, secondProp, thirdProp),
            proposalSetOf(thirdProp, secondProp, firstProp)
        )
    }

    @Test
    fun `two different proposalSetOf calls are not equal`() {
        val firstProp = firstTestProposal()
        val secondProp = secondTestProposal()
        val thirdProp = thirdTestProposal()

        assertFalse(
            proposalSetOf(firstProp, secondProp) == proposalSetOf(secondProp, thirdProp)
        )

        assertFalse(
            proposalSetOf(firstProp, secondProp) == mutableProposalSetOf(secondProp, thirdProp)
        )

        assertFalse(
            mutableProposalSetOf(firstProp, secondProp) == proposalSetOf(secondProp, thirdProp)
        )

        assertFalse(
            mutableProposalSetOf(firstProp, secondProp) == mutableProposalSetOf(secondProp, thirdProp)
        )
    }

    @Test
    fun `getOpt returns null when no proposal`() {
        val containedProp = firstTestProposal()
        val proposalSet = proposalSetOf(containedProp)

        val otherProp = secondTestProposal()
        assertNull(proposalSet.getOpt(otherProp.number))
    }

    @Test
    fun `getOpt returns proposal when contained`() {
        val containedProp = firstTestProposal()
        val proposalSet = proposalSetOf(containedProp)

        assertEquals(containedProp, proposalSet.getOpt(containedProp.number))
    }

    @Test
    fun `get fails when no proposal`() {
        val containedProp = firstTestProposal()
        val proposalSet = proposalSetOf(containedProp)

        val otherProposal = secondTestProposal()

        assertFailsWith<NoSuchProposalException> {
            proposalSet[otherProposal.number]
        }
    }

    @Test
    fun `get returns proposal when contained`() {
        val containedProp = firstTestProposal()
        val proposalSet = proposalSetOf(containedProp)

        assertEquals(containedProp, proposalSet[containedProp.number])
    }

    @Test
    fun `contains(ProposalNumber) returns false when no proposal`() {
        val containedProp = firstTestProposal()
        val proposalSet = proposalSetOf(containedProp)

        val otherProposal = secondTestProposal()

        assertFalse(proposalSet.contains(otherProposal.number))
    }

    @Test
    fun `contains(ProposalNumber) returns true when contained`() {
        val containedProp = firstTestProposal()
        val proposalSet = proposalSetOf(containedProp)

        assertTrue(proposalSet.contains(containedProp.number))
    }
}
