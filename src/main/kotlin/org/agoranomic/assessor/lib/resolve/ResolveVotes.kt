package org.agoranomic.assessor.lib.resolve

import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.proposal.Proposal
import org.agoranomic.assessor.lib.proposal.ProposalNumber
import org.agoranomic.assessor.lib.proposal.proposal_set.ProposalSet
import org.agoranomic.assessor.lib.vote.*

private fun resolveSingleVote(
    allVotes: MultiPersonPendingVoteMap,
    proposalNumber: ProposalNumber,
    voter: Person,
): ResolvingVote? {
    if (!allVotes.hasVotesFor(voter)) return null

    val personVotes = allVotes.votesFor(voter)
    if (!personVotes.hasVoteFor(proposalNumber)) return null

    return personVotes.voteFor(proposalNumber)
}

private fun makeVoteContext(
    allVotes: MultiPersonPendingVoteMap,
    lookupProposalFunc: LookupProposalFunc,
): VoteContext {
    return StandardVoteContext(resolveFunc = { proposal: Proposal, voter: Person ->
        resolveSingleVote(allVotes, proposal.number, voter)
    }, lookupProposalFunc = lookupProposalFunc)
}

private fun resolveVotes(
    votes: MultiPersonPendingVoteMap,
    lookupProposalFunc: LookupProposalFunc,
): MultiProposalVoteMap {
    val voteContext = makeVoteContext(votes, lookupProposalFunc)

    return MultiProposalVoteMap(votes.proposalsWithVotes().associateWith { proposalNumber ->
        val voters = votes.voters

        SimplifiedSingleProposalVoteMap(
            voters
                .associateWith { voter ->
                    resolveSingleVote(
                        allVotes = votes,
                        proposalNumber = proposalNumber,
                        voter = voter
                    ) ?: AbstentionResolvingVote
                }
                .mapValues { (_, value) ->
                    val proposalVoteContext = voteContext.forProposal(proposalNumber)

                    when (val voteResolution = value.finalResolution(proposalVoteContext)) {
                        is VoteStepResolution.Resolved.Abstained -> null

                        is VoteStepResolution.Resolved.Voted -> ResolvingVoteResolvedVote(
                            value.resolveDescriptions(proposalVoteContext),
                            voteResolution.resolution
                        )
                    }
                }
                .filterValues { it != null }
                .mapValues { (_, v) -> v!! }
        )
    })
}

fun resolveVotes(votes: MultiPersonPendingVoteMap, proposals: ProposalSet) = resolveVotes(votes, proposals.lookupFunc)
