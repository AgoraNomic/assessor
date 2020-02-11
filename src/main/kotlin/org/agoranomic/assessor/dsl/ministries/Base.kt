package org.agoranomic.assessor.dsl.ministries

import org.agoranomic.assessor.dsl.AssessmentDSL
import org.agoranomic.assessor.dsl.receivers.ProposalStrengthReceiver
import org.agoranomic.assessor.dsl.receivers.VotingStrengthReceiver
import org.agoranomic.assessor.lib.*

@AssessmentDSL
class ProposalChamberReceiver<Ministry> {
    private val ministries = mutableMapOf<ProposalNumber, Ministry>()

    infix fun ProposalNumber.chamber(ministry: Ministry) {
        require(!ministries.containsKey(this)) { "Ministry specified twice for proposal ${this.raw}" }
        ministries[this] = ministry
    }

    infix fun Int.chamber(ministry: Ministry) = ProposalNumber(this) chamber ministry

    fun compile(): Map<ProposalNumber, Ministry> {
        return ministries.toMap()
    }
}

public fun <Office, Ministry> _uncheckedCompilePersonMinistries(
    officeMap: Map<Office, Person?>,
    officeMinistries: Map<Office, List<Ministry>>
): Map<Person, List<Ministry>> {
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

inline fun <reified Office : Enum<Office>, Ministry> compilePersonMinistries(
    officeMap: Map<Office, Person?>,
    officeMinistries: Map<Office, List<Ministry>>
) = run {
    officeMap.keys.requireExhaustive()
    _uncheckedCompilePersonMinistries(officeMap, officeMinistries)
}

public fun <Ministry> ProposalStrengthReceiver.proposalMinistryImpl(
    personMinistries: Map<Person, List<Ministry>>,
    ministryBonus: VotingStrength,
    chamber: Ministry?
) {
    // There are no bonuses for a proposal w/o a chamber
    if (chamber == null) return

    for ((person, currentPersonMinistries) in personMinistries) {
        for (personMinistry in currentPersonMinistries) {
            if (chamber == personMinistry) {
                person add ministryBonus
            }
        }
    }
}

public inline fun <reified Office : Enum<Office>, Ministry> ProposalStrengthReceiver.proposalMinistries(
    officeMap: Map<Office, Person?>,
    officeMinistries: Map<Office, List<Ministry>>,
    ministryBonus: VotingStrength,
    chamber: Ministry?
) {
    val personMinistries = compilePersonMinistries(officeMap, officeMinistries)
    proposalMinistryImpl(personMinistries, ministryBonus, chamber)
}

inline fun <reified Office : Enum<Office>, Ministry> VotingStrengthReceiver.ministries(
    officeMap: Map<Office, Person?>,
    officeMinistries: Map<Office, List<Ministry>>,
    ministryBonus: VotingStrength,
    chamberBlock: ProposalChamberReceiver<Ministry>.() -> Unit
) {
    val receiver = ProposalChamberReceiver<Ministry>()
    receiver.chamberBlock()
    val proposalChambers = receiver.compile()

    for ((currentProposal, currentProposalChamber) in proposalChambers) {
        proposal(currentProposal) {
            proposalMinistries(
                officeMap,
                officeMinistries,
                ministryBonus,
                currentProposalChamber
            )
        }
    }
}
