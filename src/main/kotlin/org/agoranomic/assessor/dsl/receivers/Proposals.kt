package org.agoranomic.assessor.dsl.receivers

import org.agoranomic.assessor.dsl.AssessmentDsl
import org.agoranomic.assessor.dsl.detail.DslInit
import org.agoranomic.assessor.lib.proposal.Proposal
import org.agoranomic.assessor.lib.proposal.ProposalNumber
import org.agoranomic.assessor.lib.proposal.proposal_set.ImmutableProposalSet
import org.agoranomic.assessor.lib.proposal.proposal_set.addAll
import org.agoranomic.assessor.lib.proposal.proposal_set.emptyMutableProposalSet
import org.agoranomic.assessor.lib.proposal.proposal_set.toImmutableProposalSet

@AssessmentDsl
interface ProposalsReceiverCommon {
    fun using(proposals: Iterable<Proposal>)
}

fun ProposalsReceiverCommon.using(proposal: Proposal) = using(listOf(proposal))

@AssessmentDsl
interface ProposalsReceiverAddOnly : ProposalsReceiverCommon

@AssessmentDsl
interface ProposalsReceiver<ProposalReceiver> : ProposalsReceiverCommon {
    fun proposal(number: ProposalNumber, block: DslInit<ProposalReceiver>)
    fun proposal(number: Int, block: DslInit<ProposalReceiver>) = proposal(ProposalNumber(number), block)
}

interface ProposalsCompiler<ProposalReceiver> {
    fun compile(init: DslInit<ProposalsReceiver<ProposalReceiver>>): ImmutableProposalSet
}

typealias ProposalsReceiverAddOnlyInit = DslInit<ProposalsReceiverAddOnly>

interface ProposalsCompilerAddOnly {
    fun compile(init: ProposalsReceiverAddOnlyInit): ImmutableProposalSet
}

typealias ProposalsReceiverV0 = ProposalsReceiver<ProposalReceiverV0>
typealias ProposalsReceiverV0Init = DslInit<ProposalsReceiverV0>
typealias ProposalsCompilerV0 = ProposalsCompiler<ProposalReceiverV0>

typealias ProposalsReceiverV1 = ProposalsReceiver<ProposalReceiverV1>
typealias ProposalsReceiverV1Init = DslInit<ProposalsReceiverV1>
typealias ProposalsCompilerV1 = ProposalsCompiler<ProposalReceiverV1>

typealias ProposalsReceiverV2 = ProposalsReceiver<ProposalReceiverV2>
typealias ProposalsReceiverV2Init = DslInit<ProposalsReceiverV2>
typealias ProposalsCompilerV2 = ProposalsCompiler<ProposalReceiverV2>

@AssessmentDsl
private class ProposalsReceiverImplCommon : ProposalsReceiverCommon, ProposalsReceiverAddOnly {
    private val proposals = emptyMutableProposalSet()

    private fun requireUnusedNumber(number: ProposalNumber) {
        require(!proposals.contains(number)) { "Use of duplicate proposal number: $number." }
    }

    override fun using(proposals: Iterable<Proposal>) {
        proposals.forEach { requireUnusedNumber(it.number) }
        this.proposals.addAll(proposals)
    }

    fun compile(): ImmutableProposalSet = proposals.toImmutableProposalSet()
}

@AssessmentDsl
private class ProposalsReceiverImpl<ProposalReceiver : ProposalCommonReceiver>(
    private val proposalCompiler: ProposalCompiler<ProposalReceiver>,
    private val commonImpl: ProposalsReceiverImplCommon = ProposalsReceiverImplCommon()
) : ProposalsReceiver<ProposalReceiver>, ProposalsReceiverCommon by commonImpl {
    override fun proposal(number: ProposalNumber, block: DslInit<ProposalReceiver>) {
        using(proposalCompiler.compile(number, block))
    }

    fun compile() = commonImpl.compile()
}

class DefaultProposalsCompiler<ProposalReceiver : ProposalCommonReceiver>(
    private val proposalCompiler: ProposalCompiler<ProposalReceiver>
) : ProposalsCompiler<ProposalReceiver> {
    override fun compile(init: DslInit<ProposalsReceiver<ProposalReceiver>>): ImmutableProposalSet {
        return ProposalsReceiverImpl(proposalCompiler).also(init).compile()
    }
}

typealias DefaultProposalsCompilerV0 = DefaultProposalsCompiler<ProposalReceiverV0>
typealias DefaultProposalsCompilerV1 = DefaultProposalsCompiler<ProposalReceiverV1>
typealias DefaultProposalsCompilerV2 = DefaultProposalsCompiler<ProposalReceiverV2>

fun DefaultProposalsCompilerV0() = DefaultProposalsCompilerV0(DefaultProposalCompilerV0())
fun DefaultProposalsCompilerV1() = DefaultProposalsCompilerV1(DefaultProposalCompilerV1())
fun DefaultProposalsCompilerV2() = DefaultProposalsCompilerV2(DefaultProposalCompilerV2())

class DefaultProposalsCompilerAddOnly : ProposalsCompilerAddOnly {
    override fun compile(init: ProposalsReceiverAddOnlyInit): ImmutableProposalSet {
        return ProposalsReceiverImplCommon().also(init).compile()
    }
}
