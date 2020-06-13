package org.agoranomic.assessor.test

import org.agoranomic.assessor.lib.*
import org.agoranomic.assessor.test.test_objects.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.math.BigInteger
import kotlin.test.*

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

@DisplayName("SingleProposalVoteMap test")
class SingleProposalVoteMapTest {
    @Test
    fun `get returns specified vote for valid player`() {
        val player = firstTestPerson()
        val vote = firstTestVote()
        val map = SingleProposalVoteMap(mapOf(player to vote))

        assertEquals(map[player], vote)
    }

    @Test
    fun `get throws for invalid player`() {
        val knownPlayer = firstTestPerson()
        val vote = firstTestVote()
        val map = SingleProposalVoteMap(mapOf(knownPlayer to vote))

        val unknownPlayer = secondTestPerson()

        assertFailsWith<IllegalArgumentException> { map[unknownPlayer] }
    }

    @Test
    fun `voters and voteCount are correct`() {
        val playerA = firstTestPerson()
        val playerB = secondTestPerson()

        val vote = firstTestVote()

        val map = SingleProposalVoteMap(mapOf(playerA to vote, playerB to vote))

        assertEquals(map.voters.toSet(), setOf(playerA, playerB))
        assertEquals(map.voteCount, 2)
    }
}

@DisplayName("MultiProposalVoteMap test")
class MultiProposalVoteMapTest {
    @Test
    fun `get returns correct value for valid proposal`() {
        val proposal = firstTestProposalNumber()
        val singleProposalMap = firstSingleProposalVoteMap()

        val multiProposalMap = MultiProposalVoteMap(mapOf(proposal to singleProposalMap))

        assertEquals(multiProposalMap[proposal], singleProposalMap)
    }

    @Test
    fun `get throws for invalid proposal`() {
        val validProposal = firstTestProposalNumber()
        val singleProposalMap = firstSingleProposalVoteMap()

        val invalidProposal = secondTestProposalNumber()

        val multiProposalMap = MultiProposalVoteMap(mapOf(validProposal to singleProposalMap))

        assertFailsWith<IllegalArgumentException> { multiProposalMap[invalidProposal] }
    }

    @Test
    fun `proposals is correct`() {
        val singleProposalMap = firstSingleProposalVoteMap()

        val proposalA = firstTestProposalNumber()
        val proposalB = secondTestProposalNumber()

        val multiProposalMap =
            MultiProposalVoteMap(mapOf(proposalA to singleProposalMap, proposalB to singleProposalMap))

        assertEquals(multiProposalMap.proposals.toSet(), setOf(proposalA, proposalB))
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
