package org.agoranomic.assessor.test.dsl.proposal

import org.agoranomic.assessor.dsl.detail.DslInit
import org.agoranomic.assessor.dsl.receivers.ProposalCommonReceiver
import org.agoranomic.assessor.dsl.receivers.ProposalCompiler
import org.agoranomic.assessor.lib.proposal.Proposal
import org.agoranomic.assessor.lib.proposal.ProposalNumber
import org.agoranomic.assessor.test.test_objects.firstTestProposalNumber

interface ProposalCompilerTestBase<R : ProposalCommonReceiver> {
    fun newCompiler(): ProposalCompiler<R>
}

fun <R : ProposalCommonReceiver> ProposalCompilerTestBase<R>.compile(
    number: ProposalNumber = firstTestProposalNumber(),
    init: DslInit<R>
): Proposal {
    return newCompiler().compile(number, init)
}
