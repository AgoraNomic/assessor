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

private fun ProposalVotingStrengthReceiver.singleMinistry(
    officeID: OfficeID,
    ministry: Ministry,
    person: Person,
    bonus: VotingStrengthDifference
) {
    person add bonus describedAs (VotingStrengthModificationDescription(
        readable = "Bonus of $bonus for ${officeID.readableName}'s interest in ${ministry.readableName}",
        kind = "ministry_bonus",
        parameters = mapOf(
            "office" to officeID.programmaticName,
            "interest" to ministry.readableName,
            "amount" to bonus.toString()
        )
    ))
}

private fun ProposalVotingStrengthReceiver.updateVotingStrengthsForProposal(
    officeMap: Map<OfficeID, Person>,
    officeMinistries: Map<OfficeID, List<Ministry>>,
    ministryBonus: VotingStrengthDifference,
    proposalChamber: ProposalChamber
) {
    for ((office, holder) in officeMap) {
        for (ministry in officeMinistries.getOrElse(office) { emptyList() }) {
            if (ministry == proposalChamber) {
                singleMinistry(
                    office,
                    ministry,
                    holder,
                    ministryBonus
                )
            }
        }
    }
}

private fun GlobalVotingStrengthReceiver.ministriesProposalV0() {
    /* do nothing */
}

private fun GlobalVotingStrengthReceiver.ministriesProposalV1(
    officeMap: Map<OfficeID, Person>,
    officeMinistries: Map<OfficeID, List<Ministry>>,
    ministryBonus: VotingStrengthDifference,
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
                    officeMap,
                    officeMinistries,
                    ministryBonus,
                    chamber
                )
            }
        }
    })
}

fun <Office> GlobalVotingStrengthReceiver.ministries(
    officeMap: OfficeMap<Office>,
    officeMinistries: Map<Office, List<Ministry>>,
    ministryBonus: VotingStrengthDifference,
    proposals: ProposalSet
) where Office : Enum<Office>, Office : OfficeID {
    for (currentProposal in proposals) {
        currentProposal.accept(object : ProposalVisitor {
            override fun visitV0(commonData: ProposalCommonData, versionedData: ProposalDataV0) {
                ministriesProposalV0()
            }

            override fun visitV1(commonData: ProposalCommonData, versionedData: ProposalDataV1) {
                val rawOfficeMap =
                    officeMap
                        .toMap()
                        .mapKeys { (office: OfficeID, _) -> office as OfficeID } // Compiler demands cast
                        .filterValues { it.isHeld() }
                        .mapValues { (_, state) -> (state as OfficeState.Held).holder }

                ministriesProposalV1(
                    officeMap = rawOfficeMap,
                    officeMinistries = officeMinistries.mapKeys { (office: OfficeID, _) -> office },
                    ministryBonus = ministryBonus,
                    commonData = commonData,
                    versionedData = versionedData
                )
            }
        })
    }
}