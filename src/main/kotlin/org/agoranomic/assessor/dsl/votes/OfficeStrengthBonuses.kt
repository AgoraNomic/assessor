package org.agoranomic.assessor.dsl.votes

import org.agoranomic.assessor.dsl.ministries.OfficeID
import org.agoranomic.assessor.dsl.receivers.GeneralVotingStrengthReceiver
import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.VotingStrengthDifference
import org.agoranomic.assessor.lib.VotingStrengthModificationDescription

fun GeneralVotingStrengthReceiver.officeStrengthBonus(
    person: Person,
    officeID: OfficeID,
    amount: VotingStrengthDifference
) {
    person add amount describedAs VotingStrengthModificationDescription(
        readable = "Bonus of $amount for holding ${officeID.readableName}",
        kind = "office_bonus",
        parameters = mapOf(
            "office" to officeID.programmaticName
        )
    )
}

fun GeneralVotingStrengthReceiver.officeStrengthBonus(
    person: Person,
    officeID: OfficeID,
    amount: Int
) = officeStrengthBonus(
    person,
    officeID,
    VotingStrengthDifference(amount)
)

fun GeneralVotingStrengthReceiver.pmBonus(person: Person) {
    officeStrengthBonus(
        person,
        object : OfficeID {
            override val readableName: String
                get() = "Prime Minister"

            override val programmaticName: String
                get() = "PrimeMinister"
        },
        amount = 1
    )
}

fun GeneralVotingStrengthReceiver.speakerBonus(person: Person) {
    officeStrengthBonus(
        person,
        object : OfficeID {
            override val readableName: String
                get() = "Speaker"

            override val programmaticName: String
                get() = "Speaker"
        },
        amount = 1
    )
}
