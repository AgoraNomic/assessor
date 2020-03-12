package org.agoranomic.assessor.dsl.ministries

import org.agoranomic.assessor.dsl.receivers.ProposalStrengthReceiver
import org.agoranomic.assessor.dsl.receivers.VotingStrengthReceiver
import org.agoranomic.assessor.lib.*
import org.agoranomic.assessor.lib.proposal_set.ProposalSet
import kotlin.reflect.KClass

private fun <Office : Enum<Office>, Ministry> compilePersonMinistries(
    officeClass: KClass<Office>,
    officeMap: Map<Office, Person?>,
    officeMinistries: Map<Office, List<Ministry>>
): Map<Person, List<Ministry>> {
    officeMap.keys.requireExhaustive(officeClass)

    val personMinistries = mutableMapOf<Person, MutableList<Ministry>>()

    fun addOffice(person: Person?, office: Office) {
        if (person == null) return

        val personMap = personMinistries.computeIfAbsent(person) { mutableListOf() }
        personMap += officeMinistries[office] ?: emptyList()
    }

    for ((office, person) in officeMap) {
        addOffice(person, office)
    }

    return personMinistries
}

private fun ProposalStrengthReceiver.proposalMinistryImpl(
    personMinistries: Map<Person, List<Ministry>>,
    ministryBonus: VotingStrength,
    chamber: ProposalChamber
) {
    for ((person, currentPersonMinistries) in personMinistries) {
        for (personMinistry in currentPersonMinistries) {
            if (chamber == personMinistry) {
                person add ministryBonus
            }
        }
    }
}

private fun <Office : Enum<Office>> ProposalStrengthReceiver.proposalMinistries(
    officeClass: KClass<Office>,
    officeMap: Map<Office, Person?>,
    officeMinistries: Map<Office, List<Ministry>>,
    ministryBonus: VotingStrength,
    chamber: ProposalChamber
) {
    val personMinistries = compilePersonMinistries(officeClass, officeMap, officeMinistries)
    proposalMinistryImpl(personMinistries, ministryBonus, chamber)
}

fun <Office : Enum<Office>> VotingStrengthReceiver.ministries(
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
                    proposalMinistries(
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

inline fun <reified Office : Enum<Office>> VotingStrengthReceiver.ministries(
    officeMap: Map<Office, Person?>,
    officeMinistries: Map<Office, List<Ministry>>,
    ministryBonus: VotingStrength,
    proposals: ProposalSet
) = ministries(Office::class, officeMap, officeMinistries, ministryBonus, proposals)
