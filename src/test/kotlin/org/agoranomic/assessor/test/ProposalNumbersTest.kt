package org.agoranomic.assessor.test

import org.agoranomic.assessor.lib.proposal.ProposalNumber
import org.agoranomic.assessor.lib.proposal.ProposalNumbers
import org.agoranomic.assessor.lib.proposal.emptyProposalNumbers
import org.agoranomic.assessor.lib.proposal.proposalNumbersOf
import org.agoranomic.assessor.test.test_objects.firstTestProposalNumber
import org.agoranomic.assessor.test.test_objects.secondTestProposalNumber
import org.agoranomic.assessor.test.test_objects.testProposalNumber
import org.agoranomic.assessor.test.test_objects.testThird
import org.agoranomic.assessor.test.test_util.assertEqualsAndHashCode
import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@DisplayName("ProposalNumbers test")
class ProposalNumbersTest {
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

    @Test
    fun `ProposalNumbers iterator iterates all data`() {
        // We check whether its iterator goes over all of its data exactly once by having toList go over it for us.
        // Then we sort the list by the raw value and compare to the expected.
        // If it skips an element, then it won't be in the resulting list, so the assert will fail.
        // If it passes an element twice, then it will be in the resulting list twice, so the assert will fail.
        fun testWith(proposalNumbers: Set<ProposalNumber>) {
            val expectedList = proposalNumbers.toList().sorted()
            assertEquals(expectedList, ProposalNumbers(proposalNumbers).toList().sorted())
        }

        for (testSet in listOf<Set<ProposalNumber>>(
            setOf(),
            setOf(ProposalNumber(1)),
            setOf(ProposalNumber(2), ProposalNumber(3)),
            setOf(ProposalNumber(3), ProposalNumber(3), ProposalNumber(12))
        )) {
            testWith(testSet)
        }
    }

    @Test
    fun `ProposalNumbers satisfies collection interface`() {
        run {
            val proposalNumbers = emptyProposalNumbers()
            assertEquals(0, proposalNumbers.size)
            assertTrue(proposalNumbers.isEmpty())
            assertFalse(proposalNumbers.contains(firstTestProposalNumber()))
            assertFalse(proposalNumbers.containsAll(listOf(firstTestProposalNumber(), secondTestProposalNumber())))
        }

        run {
            val first = firstTestProposalNumber()
            val second = secondTestProposalNumber()
            val proposalNumbers = proposalNumbersOf(first, second)

            val third = testThird(::testProposalNumber)

            assertEquals(2, proposalNumbers.size)
            assertFalse(proposalNumbers.isEmpty())
            assertTrue(proposalNumbers.contains(first))
            assertTrue(proposalNumbers.contains(second))
            assertFalse(proposalNumbers.contains(third))
            assertTrue(proposalNumbers.containsAll(listOf(first)))
            assertTrue(proposalNumbers.containsAll(listOf(second)))
            assertTrue(proposalNumbers.containsAll(listOf(first, second)))
            assertTrue(proposalNumbers.containsAll(listOf(second, first)))
            assertFalse(proposalNumbers.containsAll(listOf(third)))
            assertFalse(proposalNumbers.containsAll(listOf(first, third)))
        }
    }
}
