package org.agoranomic.assessor.dsl.ministries

import org.agoranomic.assessor.dsl.receivers.GlobalVotingStrengthReceiver
import org.agoranomic.assessor.dsl.receivers.ProposalVotingStrengthReceiver
import org.agoranomic.assessor.lib.*
import org.agoranomic.assessor.lib.proposal_set.ProposalSet

private fun <Office : Enum<Office>, Ministry> officeMinistriesToPersonMinistries(
    officeMap: OfficeMap<Office>,
    officeMinistries: Map<Office, List<Ministry>>
): Map<Person, List<Ministry>> {
    val personMinistries = mutableMapOf<Person, MutableList<Ministry>>()

    for ((office, officeState) in officeMap) {
        if (officeState is OfficeState.Held) {
            val personMap = personMinistries.computeIfAbsent(officeState.holder) { mutableListOf() }
            personMap += officeMinistries[office] ?: emptyList()
        }
    }

    return personMinistries
}

private fun ProposalVotingStrengthReceiver.updateVotingStrengthsForProposal(
    personMinistries: Map<Person, List<Ministry>>,
    ministryBonus: VotingStrength,
    proposalChamber: ProposalChamber
) {
    for ((currentPerson, currentPersonMinistries) in personMinistries) {
        repeat(currentPersonMinistries.count { it == proposalChamber }) { _ ->
            currentPerson add ministryBonus
        }
    }
}

private fun GlobalVotingStrengthReceiver.ministriesProposalV0() {
    /* do nothing */
}

private fun GlobalVotingStrengthReceiver.ministriesProposalV1(
    personMinistries: Map<Person, List<Ministry>>,
    ministryBonus: VotingStrength,
    commonData: ProposalCommonData,
    versionedData: ProposalDataV1
) {
    val proposalNumber = commonData.number
    val currentProposalClassAndChamber = versionedData.classAndChamber

    currentProposalClassAndChamber.accept(object : ProposalClassAndChamberVisitor {
        override fun visitClassless() {
            // do nothing
        }

        override fun visitDemocratic() {
            // do nothing
        }

        override fun visitOrdinary(chamber: ProposalChamber) {
            proposal(proposalNumber) {
                updateVotingStrengthsForProposal(
                    personMinistries,
                    ministryBonus,
                    chamber
                )
            }
        }
    })
}

fun <Office : Enum<Office>> GlobalVotingStrengthReceiver.ministries(
    officeMap: OfficeMap<Office>,
    officeMinistries: Map<Office, List<Ministry>>,
    ministryBonus: VotingStrength,
    proposals: ProposalSet
) {
    for (currentProposal in proposals) {
        currentProposal.accept(object : ProposalVisitor {
            override fun visitV0(commonData: ProposalCommonData, versionedData: ProposalDataV0) {
                ministriesProposalV0()
            }

            override fun visitV1(commonData: ProposalCommonData, versionedData: ProposalDataV1) {
                ministriesProposalV1(
                    personMinistries = officeMinistriesToPersonMinistries(
                        officeMap = officeMap,
                        officeMinistries = officeMinistries
                    ),
                    ministryBonus = ministryBonus,
                    commonData = commonData,
                    versionedData = versionedData
                )
            }
        })
    }
}
