package org.agoranomic.assessor.dsl.receivers

import kotlinx.collections.immutable.toImmutableList
import org.agoranomic.assessor.dsl.AssessmentDSL
import org.agoranomic.assessor.lib.Proposal
import org.agoranomic.assessor.lib.ProposalNumber
import org.agoranomic.assessor.lib.RawProposalNumber

@AssessmentDSL
interface ProposalsReceiver {
    fun proposal(number: ProposalNumber, block: _ProposalReceiver.() -> Unit)
    fun proposal(number: Int, block: _ProposalReceiver.() -> Unit) = proposal(ProposalNumber(number), block)

    fun using(proposal: Proposal)

    fun using(proposals: Iterable<Proposal>) {
        for (proposal in proposals) using(proposal)
    }
}

@AssessmentDSL
class ProposalsReceiverImpl : ProposalsReceiver {
    private val proposals = mutableListOf<Proposal>()

    override fun proposal(number: ProposalNumber, block: _ProposalReceiver.() -> Unit) {
        val receiver = _ProposalReceiver(number)
        receiver.block()
        using(receiver.compile())
    }

    override fun using(proposal: Proposal) {
        proposals += proposal
    }

    override fun using(proposals: Iterable<Proposal>) {
        proposals.forEach(::using)
    }

    fun compile(): List<Proposal> = proposals.toImmutableList()
}
