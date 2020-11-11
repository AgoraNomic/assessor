package org.agoranomic.assessor.dsl.ministries

import org.agoranomic.assessor.dsl.receivers.GlobalVotingStrengthReceiver
import org.agoranomic.assessor.dsl.receivers.ProposalVotingStrengthReceiver
import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.proposal.*
import org.agoranomic.assessor.lib.proposal.proposal_set.ProposalSet
import org.agoranomic.assessor.lib.voting_strength.VotingStrengthDifference
import org.agoranomic.assessor.lib.voting_strength.VotingStrengthModificationDescription

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

private fun <Ministry : AnyMinistry> ProposalVotingStrengthReceiver.singleMinistry(
    officeID: OfficeID,
    ministry: Ministry,
    person: Person,
    bonus: VotingStrengthDifference,
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

private fun <Ministry : AnyMinistry> ProposalVotingStrengthReceiver.updateVotingStrengthsForProposal(
    officeMap: Map<OfficeID, Person>,
    officeMinistries: Map<OfficeID, List<Ministry>>,
    ministryBonus: VotingStrengthDifference,
    proposalChamber: Ministry,
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

private fun <Ministry : AnyMinistry> GlobalVotingStrengthReceiver.ministriesChambered(
    officeMap: Map<OfficeID, Person>,
    officeMinistries: Map<OfficeID, List<Ministry>>,
    ministryBonus: VotingStrengthDifference,
    proposalNumber: ProposalNumber,
    classAndChamber: ProposalClassAndChamber<Ministry>,
) {
    classAndChamber.accept(object : ProposalClassAndChamberVisitor<Ministry> {
        override fun visitClassless() {
            // do nothing
        }

        override fun visitDemocratic() {
            // do nothing
        }

        override fun visitOrdinary(chamber: Ministry) {
            proposal(proposalNumber) {
                updateVotingStrengthsForProposal(
                    officeMap,
                    officeMinistries,
                    ministryBonus,
                    chamber,
                )
            }
        }
    })
}

private fun <Office, Ministry : AnyMinistry> GlobalVotingStrengthReceiver.ministriesGeneric(
    officeMap: OfficeMap<Office>,
    officeMinistries: Map<Office, List<Ministry>>,
    ministryBonus: VotingStrengthDifference,
    proposals: ProposalSet,
    tryCastV1: (Ministry) -> MinistryV1,
    tryCastV2: (Ministry) -> MinistryV2,
) where Office : Enum<Office>, Office : OfficeID {
    @Suppress("USELESS_CAST") // Compiler demands cast
    val rawOfficeMap =
        officeMap
            .toMap()
            .mapKeys { (office: OfficeID, _) -> office as OfficeID }
            .filterValues { it.isHeld() }
            .mapValues { (_, state) -> (state as OfficeState.Held).holder }

    @Suppress("USELESS_CAST") // Compiler demands cast
    val castOfficeMinistries =
        officeMinistries.mapKeys { (office: OfficeID, _) -> (office as OfficeID) }

    for (currentProposal in proposals) {
        currentProposal.accept(object : ProposalChamberedVisitor() {
            override fun visitUnchambered(commonData: ProposalCommonData) {
                ministriesProposalV0()
            }

            override fun visitChamberedV1(commonData: ProposalCommonData, classAndChamber: ProposalClassAndChamberV1) {
                ministriesChambered(
                    officeMap = rawOfficeMap,
                    officeMinistries = castOfficeMinistries.mapValues { (_, v) -> v.map(tryCastV1) },
                    ministryBonus = ministryBonus,
                    proposalNumber = commonData.number,
                    classAndChamber = classAndChamber,
                )
            }

            override fun visitChamberedV2(commonData: ProposalCommonData, classAndChamber: ProposalClassAndChamberV2) {
                ministriesChambered(
                    officeMap = rawOfficeMap,
                    officeMinistries = castOfficeMinistries.mapValues { (_, v) -> v.map(tryCastV2) },
                    ministryBonus = ministryBonus,
                    proposalNumber = commonData.number,
                    classAndChamber = classAndChamber,
                )
            }
        })
    }
}

fun <Office> GlobalVotingStrengthReceiver.ministriesV1(
    officeMap: OfficeMap<Office>,
    officeMinistries: Map<Office, List<MinistryV1>>,
    ministryBonus: VotingStrengthDifference,
    proposals: ProposalSet,
) where Office : Enum<Office>, Office : OfficeID {
    require(proposals.all { it.versionedData is ProposalClassAndChamberV1Data })

    ministriesGeneric(
        officeMap = officeMap,
        officeMinistries = officeMinistries,
        ministryBonus = ministryBonus,
        proposals = proposals,
        tryCastV1 = { it },
        tryCastV2 = { error("Cannot use MinistryV2 in ministriesV1") }
    )
}

fun <Office> GlobalVotingStrengthReceiver.ministriesV2(
    officeMap: OfficeMap<Office>,
    officeMinistries: Map<Office, List<MinistryV2>>,
    ministryBonus: VotingStrengthDifference,
    proposals: ProposalSet,
) where Office : Enum<Office>, Office : OfficeID {
    require(proposals.all { it.versionedData is ProposalClassAndChamberV2Data })

    ministriesGeneric(
        officeMap = officeMap,
        officeMinistries = officeMinistries,
        ministryBonus = ministryBonus,
        proposals = proposals,
        tryCastV1 = { error("Cannot use MinistryV1 in ministriesV2") },
        tryCastV2 = { it }
    )
}
