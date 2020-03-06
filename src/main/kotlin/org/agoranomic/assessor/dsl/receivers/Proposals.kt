package org.agoranomic.assessor.dsl.receivers

import org.agoranomic.assessor.dsl.AssessmentDSL
import org.agoranomic.assessor.lib.Proposal
import org.agoranomic.assessor.lib.ProposalNumber
import org.agoranomic.assessor.lib.proposal_set.*

@AssessmentDSL
interface ProposalsReceiverCommon {
    fun using(proposal: Proposal)

    fun using(proposals: Iterable<Proposal>) {
        for (proposal in proposals) using(proposal)
    }
}

@AssessmentDSL
interface ProposalsReceiver<ProposalReceiver> : ProposalsReceiverCommon {
    fun proposal(number: ProposalNumber, block: ProposalReceiver.() -> Unit)
    fun proposal(number: Int, block: ProposalReceiver.() -> Unit) = proposal(ProposalNumber(number), block)
}

typealias ProposalsReceiverV0 = ProposalsReceiver<ProposalReceiverV0>
typealias ProposalsReceiverV1 = ProposalsReceiver<ProposalReceiverV1>

@AssessmentDSL
class ProposalsReceiverImplCommon : ProposalsReceiverCommon {
    private val proposals = emptyMutableProposalSet()

    private fun requireUnusuedNumber(number: ProposalNumber) {
        require(!proposals.contains(number)) { "Use of duplicate proposal number: $number." }
    }

    override fun using(proposal: Proposal) {
        requireUnusuedNumber(proposal.number)
        proposals += proposal
    }

    override fun using(proposals: Iterable<Proposal>) {
        proposals.forEach(::using)
    }

    fun compile(): ProposalSet = proposals.toProposalSet()
}

@AssessmentDSL
private class ProposalsReceiverImplV0(
    private val commonImpl: ProposalsReceiverImplCommon = ProposalsReceiverImplCommon()
) : ProposalsReceiverV0, ProposalsReceiverCommon by commonImpl {
    override fun proposal(number: ProposalNumber, block: ProposalReceiverV0.() -> Unit) {
        val receiver = ProposalReceiverImplV0(number)
        receiver.block()
        using(receiver.compile())
    }

    fun compile() = commonImpl.compile()
}

fun buildProposalsV0(block: ProposalsReceiverV0.() -> Unit): ImmutableProposalSet {
    return ProposalsReceiverImplV0().also(block).compile().toImmutableProposalSet()
}

@AssessmentDSL
private class ProposalsReceiverImplV1(
    private val commonImpl: ProposalsReceiverImplCommon = ProposalsReceiverImplCommon()
) : ProposalsReceiverV1, ProposalsReceiverCommon by commonImpl {
    override fun proposal(number: ProposalNumber, block: ProposalReceiverV1.() -> Unit) {
        val receiver = ProposalReceiverImplV1(number)
        receiver.block()
        using(receiver.compile())
    }

    fun compile() = commonImpl.compile()
}

fun buildProposalsV1(block: ProposalsReceiverV1.() -> Unit): ImmutableProposalSet {
    return ProposalsReceiverImplV1().also(block).compile().toImmutableProposalSet()
}
