package org.agoranomic.assessor.lib.vote

import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.proposal.Proposal
import org.agoranomic.assessor.lib.proposal.ProposalNumber
import org.agoranomic.assessor.lib.proposal.proposal_set.ProposalSet
import org.agoranomic.assessor.lib.proposal.proposal_set.get

interface VoteContext {
    fun lookupProposal(number: ProposalNumber): Proposal
    fun resolve(proposal: Proposal, voter: Person): ResolvingVote?
}

interface ProposalVoteContext : VoteContext {
    val currentProposalNumber: ProposalNumber
    val currentProposal get() = lookupProposal(currentProposalNumber)
}

fun VoteContext.lookupProposal(number: Int) = lookupProposal(ProposalNumber(number))

fun VoteContext.forProposal(proposalNumber: ProposalNumber): ProposalVoteContext {
    check(runCatching { lookupProposal(proposalNumber) }.isSuccess) { "Could not find proposal $proposalNumber" }

    val orig = this

    return object : ProposalVoteContext, VoteContext by orig {
        override val currentProposalNumber: ProposalNumber
            get() = proposalNumber
    }
}

fun VoteContext.forProposal(proposal: Proposal): ProposalVoteContext {
    check(lookupProposal(proposal.number) == proposal)
    return forProposal(proposal.number)
}

typealias LookupProposalFunc = (ProposalNumber) -> Proposal

val ProposalSet.lookupFunc: LookupProposalFunc
    get() = { number -> this[number] }

typealias ResolveFunc = (proposal: Proposal, voter: Person) -> ResolvingVote?

data class StandardVoteContext(
    val resolveFunc: ResolveFunc,
    val lookupProposalFunc: LookupProposalFunc,
) : VoteContext {
    override fun lookupProposal(number: ProposalNumber): Proposal = lookupProposalFunc(number)
    override fun resolve(proposal: Proposal, voter: Person): ResolvingVote? = resolveFunc(proposal, voter)
}
