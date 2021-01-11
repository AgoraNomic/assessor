package org.agoranomic.assessor.test

import org.agoranomic.assessor.lib.vote.InextricableVote
import org.agoranomic.assessor.lib.vote.SimpleVote
import org.agoranomic.assessor.lib.vote.Vote
import org.agoranomic.assessor.lib.vote.VoteKind
import org.agoranomic.assessor.lib.voting_strength.*
import org.agoranomic.assessor.test.test_objects.ALL_VOTE_KIND_LIST
import org.agoranomic.assessor.test.test_objects.firstTestString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.math.BigInteger
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@DisplayName("VotingStrength test")
class VotingStrengthTest {
    @Test
    fun `VotingStrength zero() works`() {
        assertEquals(VotingStrength.zero().raw, BigInteger.ZERO)
    }

    @Test
    fun `VotingStrength math works`() {
        assertEquals(VotingStrength(4) + VotingStrengthDifference(3), VotingStrength(7))
        assertEquals(VotingStrength(4) - VotingStrength(3), VotingStrengthDifference(1))
        assertEquals(VotingStrengthDifference(3) * 2, VotingStrengthDifference(6))
        assertEquals(2 * VotingStrengthDifference(4), VotingStrengthDifference(8))
    }

    @Test
    fun `VotingStrength comparsion works`() {
        val first = VotingStrength(3)

        assertTrue(first == first)
        assertFalse(first < first)
        assertTrue(first <= first)
        assertFalse(first > first)
        assertTrue(first >= first)

        val second = VotingStrength(4)

        assertFalse(first == second)
        assertTrue(first < second)
        assertTrue(first <= second)
        assertFalse(first > second)
        assertFalse(first >= second)
    }
}

@DisplayName("Vote test")
class VoteTest {
    companion object {
        @JvmStatic
        private fun testingVotes(): List<Vote> {
            return ALL_VOTE_KIND_LIST
        }
    }

    @ParameterizedTest
    @MethodSource("testingVotes")
    fun `copyWithComment returns new vote with correct comment`(vote: Vote) {
        val newComment = firstTestString(type = "Proposal Comment")
        val updatedVote = vote.copyWithComment(newComment)

        assertEquals(updatedVote.comment, newComment)
    }

    @Test
    fun `SimpleVote with non-null simplifies to itself`() {
        val vote = SimpleVote(VoteKind.PRESENT, comment = "I'm a comment!")
        val simplified = vote.simplified()

        assertEquals(vote, simplified)
    }

    @Test
    fun `SimpleVote with null simplifies to itself`() {
        val vote = SimpleVote(VoteKind.PRESENT, comment = null)
        val simplified = vote.simplified()

        assertEquals(vote, simplified)
    }

    @Test
    fun `InextricableVote with non-null comment simplifies to present with adjusted comment`() {
        val vote = InextricableVote(comment = "I'm a comment!")
        val simplified = vote.simplified()

        assertEquals(simplified.kind, VoteKind.PRESENT)
        assertEquals(simplified.comment, "Inextricable: " + vote.comment)
    }

    @Test
    fun `InextricableVote with null comment simplifies to present with adjusted comment`() {
        val vote = InextricableVote(comment = null)
        val simplified = vote.simplified()

        assertEquals(simplified.kind, VoteKind.PRESENT)
        assertEquals(simplified.comment, "Inextricable")
    }
}
