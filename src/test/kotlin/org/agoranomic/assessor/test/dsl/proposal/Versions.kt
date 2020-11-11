package org.agoranomic.assessor.test.dsl.proposal

import org.agoranomic.assessor.dsl.receivers.ProposalReceiverV0
import org.agoranomic.assessor.dsl.receivers.ProposalReceiverV1
import org.agoranomic.assessor.lib.proposal.ProposalDataV0
import org.agoranomic.assessor.test.test_objects.firstTestProposalNumber
import kotlin.test.Test
import kotlin.test.assertTrue

interface ProposalCompilerV0Test : ProposalCommonCompilerTest<ProposalReceiverV0> {
    private fun fullProposal() = compile(firstTestProposalNumber()) {
        setupOnlyCommon()
        setupExceptCommon()
    }

    override fun ProposalReceiverV0.setupExceptCommon() {
        // Nothing else to do, since V0 dsl is the same as the common
    }

    @Test
    fun `versionedData is version 0`() {
        val proposal = fullProposal()
        assertTrue(proposal.versionedData is ProposalDataV0)
    }
}

interface ProposalCompilerV1Test :
    ProposalCommonCompilerTest<ProposalReceiverV1>,
    ProposalClassAndChamberV1CompilerTest<ProposalReceiverV1> {
    private fun ProposalReceiverV1.doSetup(
        setupCommon: Boolean = true,
        setupClassAndChamber: Boolean = true,
    ) {
        if (setupCommon) setupOnlyCommon()
        if (setupClassAndChamber) setupOnlyClassAndChamber()
    }

    override fun ProposalReceiverV1.setupExceptCommon() {
        doSetup(setupCommon = false)
    }

    override fun ProposalReceiverV1.setupExceptClassAndChamber() {
        doSetup(setupClassAndChamber = false)
    }
}
