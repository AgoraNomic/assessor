package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals

@UseAssessment
fun assessment9233() = assessment {
    name("9233")
    quorum(6)

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
                "Collector"(2) heldBy Mischief
                "Distributor"(0) heldBy omd
                "Herald"(2) heldBy snail
                "Illuminator"(1) heldBy Mischief
                "Notary"(2) heldBy Mischief
                "Prime Minister"(0) heldBy Mischief
                "Promotor"(3) heldBy Cosmo
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy Kate
                "Spendor"(1) heldBy Murphy
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy kiako
            }
        }
    }

    proposals(v4) {
        proposal(9233) {
            title("Significant but not essential")
            ai("3.0")
            author(Murphy)
            democratic()

            text(
                """

Amend Rule 107 (Initiating Agoran Decisions) by appending this text
after the last list item:

       The person publishing the notice SHALL also include any additional
       information defined by the rules as significant parameters.

Amend Rule 1607 (Distribution) by replacing this text:

       A referendum is the Agoran decision to determine whether to adopt
       a proposal (its associated proposal). For this decision, the vote
       collector is the Assessor, the adoption index is initially the
       adoption index of the proposal, and the text, author, coauthors,
       and class of the proposal are essential parameters. Initiating a
       referendum is known as distribution, and removes the proposal from
       the Proposal Pool.

with this text:

       A referendum is the Agoran decision to determine whether to adopt
       a proposal (its associated proposal). For this decision, the vote
       collector is the Assessor, the adoption index is initially the
       adoption index of the proposal, the text of the proposal is an
       essential parameter, and the author, coauthors, and class of the
       proposal are significant parameters. Initiating a referendum is
       known as distribution, and removes the proposal from the Proposal
       Pool.

[Downgrades e.g. forgetting to include class from "invalidates the
  distribution until/unless ratification papers over it" to "Assessor
  may get some Blots".]"""
            )
        }
    }

    voting {
        votes(juan) {
            endorse(Janet) on 9233 comment "${Janet.name} is the Assessor"
        }

        votes(Trigon) {
            endorse(Janet) on 9233 comment "${Janet.name} is the Assessor"
        }
    }
}