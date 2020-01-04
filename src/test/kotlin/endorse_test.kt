import test_objects.*
import org.agoranomic.assessor.lib.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class `makeEndorsementFor tests` {
    @Test
    fun `returns InextricableVote for null endorseeVote`() {
        val endorsee = firstTestPlayer("Endorsee")
        val endorsement = makeEndorsementFor(endorsee = endorsee, endorseeVote = null)

        assertTrue(endorsement is InextricableVote)
        assertEquals(endorsement.comment, "Endorsement of non-voter ${endorsee.name}")
    }

    companion object {
        @JvmStatic
        private fun testingVotes(): List<Vote> {
            return ALL_VOTE_KIND_LIST
        }
    }

    @ParameterizedTest
    @MethodSource("testingVotes")
    fun `returns simplification-equivalent vote for non-null endorseeVote`(vote: Vote) {
        val endorsee = firstTestPlayer("Endorsee")
        val endorsement = makeEndorsementFor(endorsee = endorsee, endorseeVote = vote)

        assertEquals(endorsement, vote.copyWithComment("Endorsement of ${endorsee.name}"))
    }
}

class `endorse tests` {
    companion object {
        @JvmStatic
        private fun testingVotes(): List<Vote> {
            return ALL_VOTE_KIND_LIST
        }
    }

    private fun doTestEndorse(endorsement: HalfFunctionVote, proposal: Proposal, expectedEndorsee: Player, endorseeVote: Vote) {
        var called = false

        val resolved = endorsement.func(proposal) { resolveProp, resolvePlayer ->
            // Resolve should only be called with known proposal and endorsee
            assertEquals(resolveProp, proposal)
            assertEquals(resolvePlayer, expectedEndorsee)

            called = true

            endorseeVote
        }

        // Assert that resolve is called
        assertTrue(called)

        // Assert that resolved vote matches manually-generated endorsement vote
        assertEquals(resolved, makeEndorsementFor(endorsee = expectedEndorsee, endorseeVote = endorseeVote))
    }

    @ParameterizedTest
    @MethodSource("testingVotes")
    fun `endorse(Player) test`(endorseeVote: Vote) {
        val endorsee = firstTestPlayer("Endorsee")
        doTestEndorse(
            endorsement = endorse(endorsee),
            proposal = firstTestProposal(),
            expectedEndorsee = endorsee,
            endorseeVote = endorseeVote
        )
    }

    @ParameterizedTest
    @MethodSource("testingVotes")
    fun `endorse(author) test`(authorVote: Vote) {
        val proposal = firstTestProposal()
        val proposalAuthor = proposal.author

        doTestEndorse(
            endorsement = endorse(author),
            proposal = proposal,
            expectedEndorsee = proposalAuthor,
            endorseeVote = authorVote
        )
    }
}
