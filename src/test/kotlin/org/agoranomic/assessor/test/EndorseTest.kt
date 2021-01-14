package org.agoranomic.assessor.test

import org.agoranomic.assessor.dsl.votes.AuthorMarker
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.proposal.Proposal
import org.agoranomic.assessor.lib.vote.*
import org.agoranomic.assessor.test.test_objects.firstTestPerson
import org.agoranomic.assessor.test.test_objects.firstTestProposal
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@DisplayName("endorse test")
class EndorseTest {
    companion object {
        @JvmStatic
        private fun testingVotes(): List<ResolvingVote> {
            return listOf(ResolvedVote(VoteKind.FOR), ResolvedVote(VoteKind.AGAINST), InextricableResolvingVote)
        }
    }

    private fun doTestEndorse(
        endorsement: ResolvingVote,
        proposal: Proposal,
        expectedEndorsee: Person,
        endorseeVote: ResolvingVote,
    ) {
        var called = false

        val resolveFunc: ResolveFunc = { resolveProp, resolvePlayer ->
            // Resolve should only be called with known proposal and endorsee
            assertEquals(resolveProp, proposal)
            assertEquals(resolvePlayer, expectedEndorsee)

            called = true

            endorseeVote
        }

        val voteContext = StandardVoteContext(
            resolveFunc = resolveFunc,
            lookupProposalFunc = { proposalNumber ->
                assertEquals(proposal.number, proposalNumber)
                proposal
            }
        ).forProposal(proposal)

        val endorsementResolution = endorsement.finalResolution(voteContext)
        val baseResolution = endorseeVote.finalResolution(voteContext)

        assertEquals(baseResolution, endorsementResolution)

        check(endorsementResolution is VoteStepResolution.Resolved.Voted) { "can't handle this test case yet" }

        val endorsementDescriptions = endorsement.resolveDescriptions(voteContext).filterNotNull()

        assertEquals(
            VoteStepDescription(
                readable = "Endorsement of ${expectedEndorsee.name}",
                kind = "endorsement",
                parameters = mapOf(
                    "endorsee" to expectedEndorsee.name,
                    "inextricable" to "false",
                ),
            ),
            endorsementDescriptions.single(),
        )

        // Assert that resolve is called
        assertTrue(called)
    }

    @ParameterizedTest
    @MethodSource("testingVotes")
    fun `endorse(Player) test`(endorseeVote: ResolvingVote) {
        val endorsee = firstTestPerson("Endorsee")
        doTestEndorse(
            endorsement = endorse(endorsee),
            proposal = firstTestProposal(),
            expectedEndorsee = endorsee,
            endorseeVote = endorseeVote,
        )
    }

    @ParameterizedTest
    @MethodSource("testingVotes")
    fun `endorse(author) test`(authorVote: ResolvingVote) {
        val proposal = firstTestProposal()
        val proposalAuthor = proposal.author

        doTestEndorse(
            endorsement = endorse(AuthorMarker),
            proposal = proposal,
            expectedEndorsee = proposalAuthor,
            endorseeVote = authorVote,
        )
    }
}
