import org.agoranomic.assessor.lib.ProposalNumbers
import org.agoranomic.assessor.lib.emptyProposalNumbers
import org.agoranomic.assessor.lib.proposalNumbersOf
import test_objects.firstTestProposalNumber
import test_objects.secondTestProposalNumber
import test_util.assertEqualsAndHashCode
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class `ProposalNumbers tests` {
    @Test
    fun `emptyProposalNumbers returns empty ProposalNumbers`() {
        assertTrue(emptyProposalNumbers().isEmpty())
        assertEquals(emptyProposalNumbers(), emptyProposalNumbers())
    }

    @Test
    fun `proposalNumbersOf returns ProposalNumbers containing given numbers`() {
        val firstNumber = firstTestProposalNumber()
        val secondNumber = secondTestProposalNumber()
        val proposalNumbers = proposalNumbersOf(firstNumber, secondNumber)

        assertEquals(2, proposalNumbers.size)
        assertEquals(proposalNumbersOf(firstNumber, secondNumber), proposalNumbers)
    }

    @Test
    fun `two distinct ProposalNumbers are equal`() {
        val firstNumber = firstTestProposalNumber()
        val secondNumber = secondTestProposalNumber()

        val firstProposalNumbers = ProposalNumbers(setOf(firstNumber, secondNumber))
        val secondProposalNumbers = ProposalNumbers(setOf(firstNumber, secondNumber))

        assertEqualsAndHashCode(firstProposalNumbers, secondProposalNumbers)
    }
}
