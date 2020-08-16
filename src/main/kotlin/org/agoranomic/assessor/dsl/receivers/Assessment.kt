package org.agoranomic.assessor.dsl.receivers

import org.agoranomic.assessor.dsl.AssessmentDsl
import org.agoranomic.assessor.dsl.Version0
import org.agoranomic.assessor.dsl.Version1
import org.agoranomic.assessor.dsl.Version2
import org.agoranomic.assessor.dsl.detail.DslInit
import org.agoranomic.assessor.dsl.detail.SetOnce
import org.agoranomic.assessor.dsl.detail.getOrNull
import org.agoranomic.assessor.lib.proposal.AssessmentQuorum
import org.agoranomic.assessor.lib.proposal.proposal_set.ImmutableProposalSet
import org.agoranomic.assessor.lib.resolve.AssessmentData
import org.agoranomic.assessor.lib.resolve.AssessmentMetadata
import org.agoranomic.assessor.lib.resolve.AssessmentUrl

@AssessmentDsl
interface AssessmentReceiver {
    fun strengths(block: GlobalVotingStrengthReceiverInit)
    fun voting(block: MultiPersonVotesReceiverInit)
    fun quorum(value: AssessmentQuorum)
    fun name(value: String)
    fun url(value: AssessmentUrl)

    // TODO fix this dirty hack for not adding an import to everywhere that uses this
    val v0 get() = org.agoranomic.assessor.dsl.v0
    val v1 get() = org.agoranomic.assessor.dsl.v1
    val v2 get() = org.agoranomic.assessor.dsl.v2

    fun proposals(v0: Version0, block: ProposalsReceiverV0Init)
    fun proposals(v1: Version1, block: ProposalsReceiverV1Init)
    fun proposals(v2: Version2, block: ProposalsReceiverV2Init)
}

typealias AssessmentReceiverInit = DslInit<AssessmentReceiver>

fun AssessmentReceiver.quorum(value: Int) = quorum(AssessmentQuorum(value))
fun AssessmentReceiver.url(value: String) = url(AssessmentUrl(value))

interface AssessmentCompiler {
    fun compile(init: AssessmentReceiverInit): AssessmentData
}

private class DefaultAssessmentReceiver(
    val proposalsCompilerV0: ProposalsCompilerV0 = DefaultProposalsCompilerV0(),
    val proposalsCompilerV1: ProposalsCompilerV1 = DefaultProposalsCompilerV1(),
    val proposalsCompilerV2: ProposalsCompilerV2 = DefaultProposalsCompilerV2(),
    val multiPersonVotesCompiler: MultiPersonVotesCompiler = DefaultMultiPersonVotesCompiler(),
    val globalVotingStrengthCompiler: GlobalVotingStrengthCompiler = DefaultGlobalVotingStrengthCompiler()
) : AssessmentReceiver {
    private val votingStrengthsBlockValue = SetOnce.namedOf<GlobalVotingStrengthReceiverInit>("strengths block")
    private val proposalsBlockValue = SetOnce.namedOf<() -> ImmutableProposalSet>("proposals block")
    private val proposalVotesBlockValue = SetOnce.namedOf<MultiPersonVotesReceiverInit>("voting block")
    private val quorumValue = SetOnce.namedOf<AssessmentQuorum>("assessment quorum")
    private val nameValue = SetOnce.namedOf<String>("assessment name")
    private val urlValue = SetOnce.namedOf<AssessmentUrl>("assessment url")

    override fun strengths(block: GlobalVotingStrengthReceiverInit) {
        votingStrengthsBlockValue.set(block)
    }

    override fun proposals(v0: Version0, block: ProposalsReceiverV0Init) {
        @Suppress("MoveLambdaOutsideParentheses") // Lambda is the value, so it should be in parentheses
        proposalsBlockValue.set({ proposalsCompilerV0.compile(block) })
    }

    override fun proposals(v1: Version1, block: ProposalsReceiverV1Init) {
        @Suppress("MoveLambdaOutsideParentheses") // Lambda is the value, so it should be in parentheses
        proposalsBlockValue.set({ proposalsCompilerV1.compile(block) })
    }

    override fun proposals(v2: Version2, block: ProposalsReceiverV2Init) {
        @Suppress("MoveLambdaOutsideParentheses") // Lambda is the value, so it should be in parentheses
        proposalsBlockValue.set({ proposalsCompilerV2.compile(block) })
    }

    override fun voting(block: MultiPersonVotesReceiverInit) {
        proposalVotesBlockValue.set(block)
    }

    override fun quorum(value: AssessmentQuorum) {
        quorumValue.set(value)
    }

    override fun name(value: String) {
        nameValue.set(value)
    }

    override fun url(value: AssessmentUrl) {
        urlValue.set(value)
    }

    fun compile(): AssessmentData {
        val name = nameValue.get()
        val url = urlValue.getOrNull()
        val quorum = quorumValue.get()

        val proposalsBlock = proposalsBlockValue.get()
        val proposals = proposalsBlock()

        val proposalVotesBlock = proposalVotesBlockValue.get()
        val pendingVoteMap = multiPersonVotesCompiler.compile(proposals, proposalVotesBlock)

        val votingStrengthsBlock = votingStrengthsBlockValue.get()
        val votingStrengths = globalVotingStrengthCompiler.compile(proposals, votingStrengthsBlock)

        for (proposalNumber in pendingVoteMap.proposalsWithVotes()) {
            if (proposals.find { it.number == proposalNumber } == null) error("Votes specified for unknown proposal $proposalNumber")
        }

        return AssessmentData(
            AssessmentMetadata(
                name = name,
                url = url
            ),
            quorum,
            votingStrengths,
            proposals,
            pendingVoteMap
        )
    }
}

@AssessmentDsl
class DefaultAssessmentCompiler : AssessmentCompiler {
    override fun compile(init: AssessmentReceiverInit): AssessmentData {
        return DefaultAssessmentReceiver().also(init).compile()
    }
}
