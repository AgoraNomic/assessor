package org.agoranomic.assessor.test

import org.agoranomic.assessor.dsl.votes.author
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.makeEndorsementFor
import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.proposal.Proposal
import org.agoranomic.assessor.lib.vote.*
import org.agoranomic.assessor.test.test_objects.ALL_VOTE_KIND_LIST
import org.agoranomic.assessor.test.test_objects.alwaysFailingLookupProposalFunc
import org.agoranomic.assessor.test.test_objects.firstTestPerson
import org.agoranomic.assessor.test.test_objects.firstTestProposal
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@DisplayName("makeEndorsementFor test")
class MakeEndorsementForTest {
    @Test
    fun `returns InextricableVote for null endorseeVote`() {
        val endorsee = firstTestPerson("Endorsee")
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
        val endorsee = firstTestPerson("Endorsee")
        val endorsement = makeEndorsementFor(endorsee = endorsee, endorseeVote = vote)

        assertEquals(endorsement, vote.copyWithComment("Endorsement of ${endorsee.name}"))
    }
}

@DisplayName("endorse test")
class EndorseTest {
    companion object {
        @JvmStatic
        private fun testingVotes(): List<Vote> {
            return ALL_VOTE_KIND_LIST
        }
    }

    private fun doTestEndorse(
        endorsement: FunctionVote,
        proposal: Proposal,
        expectedEndorsee: Person,
        endorseeVote: Vote
    ) {
        var called = false

        val resolveFunc: ResolveFunc = { resolveProp, resolvePlayer ->
            // Resolve should only be called with known proposal and endorsee
            assertEquals(resolveProp, proposal)
            assertEquals(resolvePlayer, expectedEndorsee)

            called = true

            endorseeVote
        }

        val resolved =
            endorsement.func(
                proposal,
                StandardVoteContext(resolveFunc = resolveFunc, lookupProposalFunc = alwaysFailingLookupProposalFunc)
            )

        // Assert that resolve is called
        assertTrue(called)

        // Assert that resolved vote matches manually-generated endorsement vote
        assertEquals(resolved, makeEndorsementFor(endorsee = expectedEndorsee, endorseeVote = endorseeVote))
    }

    @ParameterizedTest
    @MethodSource("testingVotes")
    fun `endorse(Player) test`(endorseeVote: Vote) {
        val endorsee = firstTestPerson("Endorsee")
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
