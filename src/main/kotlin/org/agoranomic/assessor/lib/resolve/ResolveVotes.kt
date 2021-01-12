package org.agoranomic.assessor.lib.resolve

import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.proposal.Proposal
import org.agoranomic.assessor.lib.proposal.ProposalNumber
import org.agoranomic.assessor.lib.proposal.proposal_set.ProposalSet
import org.agoranomic.assessor.lib.vote.*

private fun resolveSingleVote(
    allVotes: MultiPersonPendingVoteMap,
    lookupProposalFunc: LookupProposalFunc,
    proposalNumber: ProposalNumber,
    voter: Person,
    alreadySeen: List<Pair<ProposalNumber, Person>> = emptyList(),
): ResolvingVote? {
    if (alreadySeen.contains(Pair(proposalNumber, voter))) return InextricableResolvingVote

    if (!allVotes.hasVotesFor(voter)) return null

    val personVotes = allVotes.votesFor(voter)
    if (!personVotes.hasVoteFor(proposalNumber)) return null

    val proposalVote = personVotes.voteFor(proposalNumber)

    val proposal = lookupProposalFunc(proposalNumber)

    val nextAlreadySeen = alreadySeen + Pair(proposalNumber, voter)

    val nextResolve: ResolveFunc = { nextProposal, nextVoter ->
        resolveSingleVote(
            allVotes = allVotes,
            lookupProposalFunc = lookupProposalFunc,
            proposalNumber = nextProposal.number,
            voter = nextVoter,
            alreadySeen = nextAlreadySeen
        )
    }

    return proposalVote
}

private fun makeVoteContext(
    allVotes: MultiPersonPendingVoteMap,
    lookupProposalFunc: LookupProposalFunc,
): VoteContext {
    return StandardVoteContext(resolveFunc = { proposal: Proposal, voter: Person ->
        resolveSingleVote(allVotes, lookupProposalFunc, proposal.number, voter, alreadySeen = emptyList())
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
                        lookupProposalFunc = lookupProposalFunc,
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
