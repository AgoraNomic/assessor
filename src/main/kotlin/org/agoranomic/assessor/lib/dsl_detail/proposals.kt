package org.agoranomic.assessor.lib.dsl_detail

import kotlinx.collections.immutable.toImmutableList
import org.agoranomic.assessor.lib.AssessmentDSL
import org.agoranomic.assessor.lib.Proposal
import org.agoranomic.assessor.lib.ProposalNumber
import org.agoranomic.assessor.lib.RawProposalNumber

@AssessmentDSL
class _ProposalsReceiver {
    private val proposals = mutableListOf<Proposal>()

    fun proposal(number: ProposalNumber, block: _ProposalReceiver.() -> Unit) {
        val receiver = _ProposalReceiver(number)
        receiver.block()
        using(receiver.compile())
    }

    fun proposal(number: RawProposalNumber, block: _ProposalReceiver.() -> Unit) = proposal(
        ProposalNumber(number),
        block
    )

    fun proposal(number: Int, block: _ProposalReceiver.() -> Unit) = proposal(number.toBigInteger(), block)

    fun using(proposal: Proposal) {
        proposals += proposal
    }

    fun using(proposals: Collection<Proposal>) {
        proposals.forEach(::using)
    }

    fun compile(): List<Proposal> = proposals.toImmutableList()
}
