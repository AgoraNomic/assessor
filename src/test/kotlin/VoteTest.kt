import org.agoranomic.assessor.lib.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import test_objects.*
import java.math.BigInteger
import kotlin.test.*

class `VotingStrength tests`() {
    @Test
    fun `VotingStrength zero() works`() {
        assertEquals(VotingStrength.zero().raw, BigInteger.ZERO)
    }

    @Test
    fun `VotingStrength math works`() {
        val first = VotingStrength(3)
        val second = VotingStrength(4)

        assertEquals(first + second, VotingStrength(7))
        assertEquals(second - first, VotingStrength(1))
        assertEquals(first * 2, VotingStrength(6))
        assertEquals(2 * first, first * 2)
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

class `SimpleVotingStrengthMap tests`() {
    @Test
    fun `returns provided value for special player`() {
        val specialPlayer = firstTestPlayer()

        val default = firstTestVotingStrength()
        val override = firstTestVotingStrengthWithComment()

        val map = SimpleVotingStrengthMap(default, mapOf(specialPlayer to override))

        assertEquals(map[specialPlayer], override)
    }

    @Test
    fun `returns default value for non-special player`() {
        val special = firstTestPlayer()
        val nonspecial = secondTestPlayer()

        val default = firstTestVotingStrength()
        val override = firstTestVotingStrengthWithComment()

        val map = SimpleVotingStrengthMap(default, mapOf(special to override))

        assertEquals(map[nonspecial], VotingStrengthWithComment(default, comment = null))
    }

    @Test
    fun `specialPlayers empty for empty map`() {
        val emptyMap = SimpleVotingStrengthMap(firstTestVotingStrength(), emptyMap())
        assertEquals(emptyMap.specialPeople, emptySet<Person>())
    }

    @Test
    fun `specialPlayers correct for non-empty map`() {
        val firstPlayer = firstTestPlayer()
        val secondPlayer = secondTestPlayer()

        val map = SimpleVotingStrengthMap(
            firstTestVotingStrength(),
            mapOf(
                firstPlayer to firstTestVotingStrengthWithComment(),
                secondPlayer to secondTestVotingStrengthWithComment()
            )
        )

        assertEquals(map.specialPeople.toSet(), setOf(firstPlayer, secondPlayer))
    }
}

class `SingleProposalVoteMap tests`() {
    @Test
    fun `get returns specified vote for valid player`() {
        val player = firstTestPlayer()
        val vote = firstTestVote()
        val map = SingleProposalVoteMap(mapOf(player to vote))

        assertEquals(map[player], vote)
    }

    @Test
    fun `get throws for invalid player`() {
        val knownPlayer = firstTestPlayer()
        val vote = firstTestVote()
        val map = SingleProposalVoteMap(mapOf(knownPlayer to vote))

        val unknownPlayer = secondTestPlayer()

        assertFailsWith<IllegalArgumentException> { map[unknownPlayer] }
    }

    @Test
    fun `voters and voteCount are correct`() {
        val playerA = firstTestPlayer()
        val playerB = secondTestPlayer()

        val vote = firstTestVote()

        val map = SingleProposalVoteMap(mapOf(playerA to vote, playerB to vote))

        assertEquals(map.voters.toSet(), setOf(playerA, playerB))
        assertEquals(map.voteCount, 2)
    }
}

class `MultiProposalVoteMap tests`() {
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

        val multiProposalMap = MultiProposalVoteMap(mapOf(proposalA to singleProposalMap, proposalB to singleProposalMap))

        assertEquals(multiProposalMap.proposals.toSet(), setOf(proposalA, proposalB))
    }
}

class `Vote tests` {
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
