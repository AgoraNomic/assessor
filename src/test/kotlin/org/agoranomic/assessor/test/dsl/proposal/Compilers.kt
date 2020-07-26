package org.agoranomic.assessor.test.dsl.proposal

import org.agoranomic.assessor.dsl.receivers.*

class DefaultProposalCompilerV0Test : ProposalCompilerV0Test {
    override fun newCompiler(): ProposalCompiler<ProposalReceiverV0> {
        return DefaultProposalCompilerV0()
    }
}

class DefaultProposalCompilerV1Test : ProposalCompilerV1Test {
    override fun newCompiler(): ProposalCompiler<ProposalReceiverV1> {
        return DefaultProposalCompilerV1()
    }
}
