package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.endorseOfficer
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals

@UseAssessment
fun assessment9275() = assessment {
    name("9275")
    quorum(7)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            complexityBonuses {
                maxBonus(3)

                "Absurdor"(1) heldBy juan
                "ADoP"(2) heldBy Murphy
                "Arbitor"(2) heldBy Kate
                "Archivist"(1) heldBy kiako
                "Assessor"(3) heldBy Janet
                "Collar"(1) heldBy Mischief
                "Collector"(2) heldBy Mischief
                "Distributor"(0) heldBy omd
                "Herald"(2) heldBy snail
                "Illuminator"(1) heldBy null
                "Land Managor"(1) heldBy Murphy
                "Notary"(2) heldBy null
                "Numerator"(1) heldBy Trigon
                "Prime Minister"(0) heldBy null
                "Promotor"(3) heldBy Cosmo
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy kiako
                "Spendor"(1) heldBy Murphy
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy kiako
            }
        }
    }

    proposals(v4) {
        proposal(9275) {
            title("Determinate determinacy")
            ai("3.0")
            author(Janet)
            democratic()

            text(
                """
Amend Rule 2518 ("Determinacy") by replacing the text "If a value CANNOT
be reasonably determined" with the text "If a value cannot be reasonably
determined".

[We almost certainly mean "cannot" here in the natural language sense:
determining something (in this sense) is not a regulated action; it
requires thought and potentially a judicial process.]"""
            )
        }
    }

    voting {
        votes(Cosmo) {
            endorseOfficer("Rulekeepor", Janet) on 9275
        }
    }
}
