package org.agoranomic.assessor.dsl.ministries

import org.agoranomic.assessor.dsl.receivers.GlobalVotingStrengthReceiver
import org.agoranomic.assessor.dsl.receivers.ProposalVotingStrengthReceiver
import org.agoranomic.assessor.lib.*
import org.agoranomic.assessor.lib.proposal_set.ProposalSet
import org.agoranomic.assessor.lib.util.requireExhaustive
import kotlin.reflect.KClass

private fun <Office : Enum<Office>, Ministry> officeMinistriesToPersonMinistries(
    officeClass: KClass<Office>,
    officeMap: Map<Office, Person?>,
    officeMinistries: Map<Office, List<Ministry>>
): Map<Person, List<Ministry>> {
    officeMap.keys.requireExhaustive(officeClass)

    val personMinistries = mutableMapOf<Person, MutableList<Ministry>>()

    for ((office, person) in officeMap) {
        if (person != null) {
            val personMap = personMinistries.computeIfAbsent(person) { mutableListOf() }
            personMap += officeMinistries[office] ?: emptyList()
        }
    }

    return personMinistries
}

private fun <Office : Enum<Office>> ProposalVotingStrengthReceiver.updateVotingStrengthsForProposal(
    officeClass: KClass<Office>,
    officeHolders: Map<Office, Person?>,
    officeMinistries: Map<Office, List<Ministry>>,
    ministryBonus: VotingStrength,
    proposalChamber: ProposalChamber
) {
    val personMinistries = officeMinistriesToPersonMinistries(officeClass, officeHolders, officeMinistries)

    for ((currentPerson, currentPersonMinistries) in personMinistries) {
        repeat(currentPersonMinistries.count { it == proposalChamber }) { _ ->
            currentPerson add ministryBonus
        }
    }
}

private fun GlobalVotingStrengthReceiver.ministriesProposalV0() {
    /* do nothing */
}

private fun <Office : Enum<Office>> GlobalVotingStrengthReceiver.ministriesProposalV1(
    officeClass: KClass<Office>,
    officeMap: Map<Office, Person?>,
    officeMinistries: Map<Office, List<Ministry>>,
    ministryBonus: VotingStrength,
    proposal: Proposal
) {
    val versionedData = proposal.versionedData
    check(versionedData is ProposalDataV1)

    val currentProposalClassAndChamber = versionedData.classAndChamber

    // This val exists to ensure that, should another ProposalClassAndChamber be added, the compiler will error
    // here unless this is also updated.
    @Suppress("UNUSED_VARIABLE", "LocalVariableName")
    val _ensureExhaustive_ = when (currentProposalClassAndChamber) {
        is ProposalClassAndChamber.Classless -> {
            /* do nothing */
        }

        is ProposalClassAndChamber.DemocraticClass -> {
            /* do nothing */
        }

        is ProposalClassAndChamber.OrdinaryClass -> {
            proposal(proposal.number) {
                updateVotingStrengthsForProposal(
                    officeClass,
                    officeMap,
                    officeMinistries,
                    ministryBonus,
                    currentProposalClassAndChamber.chamber
                )
            }
        }
    }
}

fun <Office : Enum<Office>> GlobalVotingStrengthReceiver.ministries(
    officeClass: KClass<Office>,
    officeMap: Map<Office, Person?>,
    officeMinistries: Map<Office, List<Ministry>>,
    ministryBonus: VotingStrength,
    proposals: ProposalSet
) {
    for (currentProposal in proposals) {
        when (currentProposal.versionedData) {
            is ProposalDataV0 -> ministriesProposalV0()

            is ProposalDataV1 -> ministriesProposalV1(
                officeClass = officeClass,
                officeMap = officeMap,
                officeMinistries = officeMinistries,
                ministryBonus = ministryBonus,
                proposal = currentProposal
            )
        }
    }
}

inline fun <reified Office : Enum<Office>> GlobalVotingStrengthReceiver.ministries(
    officeMap: Map<Office, Person?>,
    officeMinistries: Map<Office, List<Ministry>>,
    ministryBonus: VotingStrength,
    proposals: ProposalSet
) = ministries(Office::class, officeMap, officeMinistries, ministryBonus, proposals)
