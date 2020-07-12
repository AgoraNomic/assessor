package org.agoranomic.assessor.lib.vote

import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.proposal.Proposal
import org.agoranomic.assessor.lib.proposal.ProposalNumber

data class LookupProposal(private val func: (ProposalNumber) -> Proposal) {
    operator fun invoke(number: ProposalNumber) = func(number)
    operator fun invoke(number: Int) = this(ProposalNumber(number))
}

interface VoteContext {
    val lookupProposal: LookupProposal
    fun resolve(proposal: Proposal, voter: Person): Vote?
}

typealias ResolveFunc = (proposal: Proposal, voter: Person) -> Vote?

data class StandardVoteContext(
    val resolveFunc: ResolveFunc,
    override val lookupProposal: LookupProposal
) : VoteContext {
    override fun resolve(proposal: Proposal, voter: Person): Vote? = resolveFunc(proposal, voter)
}

typealias VoteFunc = (proposal: Proposal, context: VoteContext) -> Vote?
