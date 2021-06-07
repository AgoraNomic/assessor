package org.agoranomic.assessor.dsl.votes

import org.agoranomic.assessor.dsl.receivers.GlobalVotingStrengthReceiver
import org.agoranomic.assessor.dsl.receivers.ProposalVotingStrengthReceiverInit
import org.agoranomic.assessor.lib.proposal.*

private val ProposalClassAndChamberV1.isOrdinary: Boolean
    get() {
        return when (this) {
            is ProposalClassAndChamberV1.Classless -> {
                error("Unexpected classless proposal")
            }

            is ProposalClassAndChamberV1.OrdinaryClass -> true

            is ProposalClassAndChamberV1.DemocraticClass -> false
        }
    }

private val ProposalClassAndChamberV2.isOrdinary: Boolean
    get() {
        return when (this) {
            is ProposalClassAndChamberV2.Classless -> {
                error("Unexpected classless proposal")
            }

            is ProposalClassAndChamberV2.OrdinaryClass -> true

            is ProposalClassAndChamberV2.DemocraticClass -> false
        }
    }


private val Proposal.isOrdinary: Boolean
    get() {
        return accept(object : ProposalMapper<Boolean> {
            override fun visitV0(commonData: ProposalCommonData, versionedData: ProposalDataV0): Boolean {
                error("Unexpected unchambered proposal")
            }

            override fun visitV1(commonData: ProposalCommonData, versionedData: ProposalDataV1): Boolean {
                return versionedData.classAndChamber.isOrdinary
            }

            override fun visitV2(commonData: ProposalCommonData, versionedData: ProposalDataV2): Boolean {
                return versionedData.classAndChamber.isOrdinary
            }

            override fun visitV3(commonData: ProposalCommonData, versionedData: ProposalDataV3): Boolean {
                return versionedData.classAndChamber.isOrdinary
            }

            override fun visitV4(commonData: ProposalCommonData, versionedData: ProposalDataV4): Boolean {
                return when (versionedData.proposalClass) {
                    ProposalClassV3.ORDINARY -> true
                    ProposalClassV3.DEMOCRATIC -> false
                }
            }
        })
    }

fun GlobalVotingStrengthReceiver.onOrdinaryProposals(block: ProposalVotingStrengthReceiverInit) {
    allProposals.filter { it.isOrdinary }.forEach {
        proposal(it.number, block)
    }
}
