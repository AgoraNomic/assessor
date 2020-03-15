package org.agoranomic.assessor.dsl.ministries

import org.agoranomic.assessor.dsl.receivers.ProposalVotingStrengthReceiver
import org.agoranomic.assessor.dsl.receivers.GlobalVotingStrengthReceiver
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

fun <Office : Enum<Office>> GlobalVotingStrengthReceiver.ministries(
    officeClass: KClass<Office>,
    officeMap: Map<Office, Person?>,
    officeMinistries: Map<Office, List<Ministry>>,
    ministryBonus: VotingStrength,
    proposals: ProposalSet
) {
    for (currentProposal in proposals) {
        val currentProposalClassAndChamber = currentProposal.classAndChamber

        // This val exists to ensure that, should another ProposalClassAndChamber be added, the compiler will error
        // here unless this is also updated.
        @Suppress("UNUSED_VARIABLE", "LocalVariableName")
        val _ensureExhaustive_ = when (currentProposalClassAndChamber) {
            is ProposalClassAndChamber.Classless -> {}
            is ProposalClassAndChamber.DemocraticClass -> {}

            is ProposalClassAndChamber.OrdinaryClass -> {
                proposal(currentProposal.number) {
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
}

inline fun <reified Office : Enum<Office>> GlobalVotingStrengthReceiver.ministries(
    officeMap: Map<Office, Person?>,
    officeMinistries: Map<Office, List<Ministry>>,
    ministryBonus: VotingStrength,
    proposals: ProposalSet
) = ministries(Office::class, officeMap, officeMinistries, ministryBonus, proposals)
