package org.agoranomic.assessor.lib.dsl_detail

import org.agoranomic.assessor.lib.AssessmentDSL
import org.agoranomic.assessor.lib.Proposal
import org.agoranomic.assessor.lib.ProposalNumber

@AssessmentDSL
class _ProposalsReceiver {
    private val proposals = mutableListOf<Proposal>()

    fun proposal(number: ProposalNumber, block: _ProposalReceiver.() -> Unit) {
        val receiver = _ProposalReceiver(number)
        receiver.block()
        using(receiver.compile())
    }

    fun using(proposal: Proposal) {
        proposals += proposal
    }

    fun using(proposals: Collection<Proposal>) {
        proposals.forEach(::using)
    }

    fun compile(): List<Proposal> = proposals
}
