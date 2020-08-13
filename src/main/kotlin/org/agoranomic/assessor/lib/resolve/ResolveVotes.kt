package org.agoranomic.assessor.lib.resolve

import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.proposal.ProposalNumber
import org.agoranomic.assessor.lib.proposal.proposal_set.ProposalSet
import org.agoranomic.assessor.lib.vote.*

private fun resolveSingleVote(
    allVotes: MultiPersonPendingVoteMap,
    lookupProposalFunc: LookupProposalFunc,
    proposalNumber: ProposalNumber,
    voter: Person,
    alreadySeen: List<Pair<ProposalNumber, Person>> = emptyList()
): Vote? {
    if (alreadySeen.contains(Pair(proposalNumber, voter))) return InextricableVote(comment = null)

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

    val voteContext = StandardVoteContext(resolveFunc = nextResolve, lookupProposalFunc = lookupProposalFunc)

    return proposalVote.compile(proposal, voteContext)
}

private fun resolveVotes(
    votes: MultiPersonPendingVoteMap,
    lookupProposalFunc: LookupProposalFunc
): MultiProposalVoteMap {
    return MultiProposalVoteMap(votes.proposalsWithVotes().associateWith { proposalNumber ->
        val voters = votes.voters

        SingleProposalVoteMap(
            voters
                .associateWith { voter ->
                    resolveSingleVote(
                        allVotes = votes,
                        lookupProposalFunc = lookupProposalFunc,
                        proposalNumber = proposalNumber,
                        voter = voter
                    )
                }
                .filterValues { it != null }
                .mapValues { (_, value) -> value!! }
        )
    })
}

fun resolveVotes(votes: MultiPersonPendingVoteMap, proposals: ProposalSet) = resolveVotes(votes, proposals.lookupFunc)
