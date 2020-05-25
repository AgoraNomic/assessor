package org.agoranomic.assessor.test

import org.agoranomic.assessor.lib.*
import org.agoranomic.assessor.test.test_objects.testPlayer
import java.math.BigDecimal
import kotlin.test.Test
import kotlin.test.assertEquals

class AITest {
    @Test
    fun `aiStrengthsFor works correctly`() {
        val firstPerson = testPlayer(0)
        val secondPerson = testPlayer(1)
        val thirdPerson = testPlayer(2)
        val fourthPerson = testPlayer(3)

        val defaultStrength = VotingStrength(1)

        val votingStrengthMap = SimpleVotingStrengthMap(
            defaultStrength,
            mapOf(
                firstPerson to VotingStrengthWithComment(VotingStrength(2), null),
                secondPerson to VotingStrengthWithComment(VotingStrength(3), null),
                thirdPerson to VotingStrengthWithComment(VotingStrength(4), null)
            )
        )

        val votesMap = SimplifiedSingleProposalVoteMap(
            mapOf(
                firstPerson to SimpleVote(VoteKind.FOR, null),
                secondPerson to SimpleVote(VoteKind.AGAINST, null),
                thirdPerson to SimpleVote(VoteKind.PRESENT, null),
                fourthPerson to SimpleVote(VoteKind.FOR, null)
            )
        )

        val expected = AIStrengths(
            strengthFor = VotingStrength(3),
            strengthAgainst = VotingStrength(3)
        )

        assertEquals(expected, aiStrengthsFor(votesMap, votingStrengthMap))
    }

    private fun testAdopted(expected: Boolean, ai: BigDecimal, strengthFor: Int, strengthAgainst: Int) {
        assertEquals(
            expected,
            isAIAdopted(
                ProposalAI(ai),
                AIStrengths(
                    strengthFor = VotingStrength(strengthFor),
                    strengthAgainst = VotingStrength(strengthAgainst)
                )
            )
        )
    }

    private fun testAdopted(expected: Boolean, ai: Int, strengthFor: Int, strengthAgainst: Int) =
        testAdopted(
            expected = expected,
            ai = ai.toBigDecimal(),
            strengthFor = strengthFor,
            strengthAgainst = strengthAgainst
        )

    @Test
    fun `isAIAdopted returns tests for majority when AI=1`() {
        testAdopted(true, 1, 1, 0)
        testAdopted(true, 1, 4, 3)

        testAdopted(false, 1, 0, 0)
        testAdopted(false, 1, 0, 1)
        testAdopted(false, 1, 3, 3)
        testAdopted(false, 1, 3, 4)
    }

    @Test
    fun `isAIAdopted returns correct value for AI greater than 1`() {
        testAdopted(true, 2, 2, 0)
        testAdopted(true, 2, 2, 1)
        testAdopted(true, 2, 6, 2)
        testAdopted(true, 2, 6, 3)

        testAdopted(false, 2, 0, 0)
        testAdopted(false, 2, 0, 2)
        testAdopted(false, 2, 2, 2)
        testAdopted(false, 2, 3, 2)
        testAdopted(false, 2, 6, 4)
    }

    @Test
    fun `isAIAdopted behaves as majority for AI less than 1`() {
        val smallAI = "0.5".toBigDecimal()

        // The specification says that it is adopted iff F / A > 1 (or F > 0 & A = 0) AND F / A >= AI. So if AI < 1,
        // then the only thing that matters is if F / A > 1.

        testAdopted(true, smallAI, 1, 0)
        testAdopted(true, smallAI, 4, 3)

        testAdopted(false, smallAI, 0, 0)
        testAdopted(false, smallAI, 0, 1)
        testAdopted(false, smallAI, 3, 3)
        testAdopted(false, smallAI, 3, 4)
    }
}
