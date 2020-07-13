package org.agoranomic.assessor.dsl.receivers

import org.agoranomic.assessor.dsl.AssessmentDsl
import org.agoranomic.assessor.dsl.detail.DslInit
import org.agoranomic.assessor.lib.proposal.Proposal
import org.agoranomic.assessor.lib.proposal.ProposalNumber
import org.agoranomic.assessor.lib.proposal.proposal_set.*

@AssessmentDsl
interface ProposalsReceiverCommon {
    fun using(proposal: Proposal)

    fun using(proposals: Iterable<Proposal>) {
        for (proposal in proposals) using(proposal)
    }
}

@AssessmentDsl
interface ProposalsReceiver<ProposalReceiver> : ProposalsReceiverCommon {
    fun proposal(number: ProposalNumber, block: DslInit<ProposalReceiver>)
    fun proposal(number: Int, block: DslInit<ProposalReceiver>) = proposal(ProposalNumber(number), block)
}

interface ProposalsCompiler<ProposalReceiver> {
    fun compile(init: DslInit<ProposalsReceiver<ProposalReceiver>>): ImmutableProposalSet
}

typealias ProposalsReceiverV0 = ProposalsReceiver<ProposalReceiverV0>
typealias ProposalsReceiverV0Init = DslInit<ProposalsReceiverV0>
typealias ProposalsCompilerV0 = ProposalsCompiler<ProposalReceiverV0>

typealias ProposalsReceiverV1 = ProposalsReceiver<ProposalReceiverV1>
typealias ProposalsReceiverV1Init = DslInit<ProposalsReceiverV1>
typealias ProposalsCompilerV1 = ProposalsCompiler<ProposalReceiverV1>

@AssessmentDsl
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

@AssessmentDsl
private class DefaultProposalsReceiverV0(
    private val proposalCompiler: ProposalCompilerV0,
    private val commonImpl: ProposalsReceiverImplCommon = ProposalsReceiverImplCommon()
) : ProposalsReceiverV0, ProposalsReceiverCommon by commonImpl {
    override fun proposal(number: ProposalNumber, block: ProposalReceiverV0Init) {
        using(proposalCompiler.compile(number, block))
    }

    fun compile() = commonImpl.compile()
}

class DefaultProposalsCompilerV0(
    private val proposalCompiler: ProposalCompilerV0 = DefaultProposalCompilerV0()
) : ProposalsCompilerV0 {
    override fun compile(init: DslInit<ProposalsReceiver<ProposalReceiverV0>>): ImmutableProposalSet {
        return DefaultProposalsReceiverV0(proposalCompiler).also(init).compile().toImmutableProposalSet()
    }
}

@AssessmentDsl
private class DefaultProposalsReceiverV1(
    private val proposalCompiler: ProposalCompilerV1,
    private val commonImpl: ProposalsReceiverImplCommon = ProposalsReceiverImplCommon()
) : ProposalsReceiverV1, ProposalsReceiverCommon by commonImpl {
    override fun proposal(number: ProposalNumber, block: ProposalReceiverV1Init) {
        using(proposalCompiler.compile(number, block))
    }

    fun compile() = commonImpl.compile()
}

class DefaultProposalsCompilerV1(
    private val proposalCompiler: ProposalCompilerV1 = DefaultProposalCompilerV1()
) : ProposalsCompilerV1 {
    override fun compile(init: DslInit<ProposalsReceiver<ProposalReceiverV1>>): ImmutableProposalSet {
        return DefaultProposalsReceiverV1(proposalCompiler).also(init).compile().toImmutableProposalSet()
    }
}
