package org.agoranomic.assessor.dsl.receivers

import org.agoranomic.assessor.dsl.AssessmentDSL
import org.agoranomic.assessor.lib.Proposal
import org.agoranomic.assessor.lib.ProposalNumber
import org.agoranomic.assessor.lib.proposal_set.ProposalSet
import org.agoranomic.assessor.lib.proposal_set.emptyMutableProposalSet
import org.agoranomic.assessor.lib.proposal_set.plusAssign
import org.agoranomic.assessor.lib.proposal_set.toProposalSet

@AssessmentDSL
interface ProposalsReceiver {
    fun proposal(number: ProposalNumber, block: ProposalReceiver.() -> Unit)
    fun proposal(number: Int, block: ProposalReceiver.() -> Unit) = proposal(ProposalNumber(number), block)

    fun using(proposal: Proposal)

    fun using(proposals: Iterable<Proposal>) {
        for (proposal in proposals) using(proposal)
    }
}

@AssessmentDSL
class ProposalsReceiverImpl : ProposalsReceiver {
    private val proposals = emptyMutableProposalSet()

    private fun requireUnusuedNumber(number: ProposalNumber) {
        require(!proposals.contains(number)) { "Use of duplicate proposal number: $number." }
    }

    override fun proposal(number: ProposalNumber, block: ProposalReceiver.() -> Unit) {
        requireUnusuedNumber(number)

        val receiver = ProposalReceiverImpl(number)
        receiver.block()
        using(receiver.compile())
    }

    override fun using(proposal: Proposal) {
        proposals += proposal
    }

    override fun using(proposals: Iterable<Proposal>) {
        proposals.forEach(::using)
    }

    fun compile(): ProposalSet = proposals.toProposalSet()
}
