import org.agoranomic.assessor.lib.ProposalNumbers
import org.agoranomic.assessor.lib.emptyProposalNumbers
import org.agoranomic.assessor.lib.proposalNumbersOf
import test_objects.firstTestProposalNumber
import test_objects.secondTestProposalNumber
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class `ProposalNumbers tests` {
    @Test
    fun `emptyProposalNumbers returns empty ProposalNumbers`() {
        assertTrue(emptyProposalNumbers().isEmpty())
        assertEquals(emptySet(), emptyProposalNumbers().toSet())
    }

    @Test
    fun `proposalNumbersOf returns ProposalNumbers containing given numbers`() {
        val firstNumber = firstTestProposalNumber()
        val secondNumber = secondTestProposalNumber()
        val proposalNumbers = proposalNumbersOf(firstNumber, secondNumber)

        assertEquals(2, proposalNumbers.size)
        assertEquals(setOf(firstNumber, secondNumber), proposalNumbers.toSet())
    }

    @Test
    fun `two distinct ProposalNumbers are equal`() {
        val firstNumber = firstTestProposalNumber()
        val secondNumber = secondTestProposalNumber()

        fun <T> assertEqualAndHashCode(first: T, second: T) {
            assertTrue(first == second)
            assertTrue(first.hashCode() == second.hashCode())
        }

        val firstProposalNumbers = ProposalNumbers(setOf(firstNumber, secondNumber))
        val secondProposalNumbers = ProposalNumbers(setOf(firstNumber, secondNumber))

        assertEqualAndHashCode(firstProposalNumbers, secondProposalNumbers)
    }
}
