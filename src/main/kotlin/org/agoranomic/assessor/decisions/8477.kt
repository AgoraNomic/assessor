package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.ministries.OfficeJune30.*
import org.agoranomic.assessor.dsl.ministries.ministries_2020_07_26
import org.agoranomic.assessor.dsl.ministries.officeMapOf
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.addToHolder
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.lib.proposal.Ministry.Economy
import org.agoranomic.assessor.lib.vote.VoteKind.FOR
import org.agoranomic.assessor.lib.vote.VoteKind.PRESENT

@UseAssessment
fun `assessment 8477`() = assessment {
    name("8477")
    quorum(8)

    val offices = officeMapOf(
        ADoP to Murphy,
        Arbitor to G,
        Assessor to Jason,
        Coopor to RLee,
        Distributor to omd,
        Herald to PSS,
        Notary to ATMunn,
        PrimeMinister to nix,
        Promotor to Aris,
        Referee to PSS,
        Registrar to Falsifian,
        Rulekeepor to Jason,
        Speaker to Jason,
        Tailor to PSS,
        Treasuror to Trigon,
        Webmastor to nix
    )

    strengths {
        default(3)
        min(0)
        max(15)

        blotPenalty(Gaelan, 4 / 3)
        blotPenalty(RLee, 80 / 3)

        addToHolder(offices, Speaker, 1)
        ministries_2020_07_26(offices, allProposals)
    }

    proposals(v2) {
        proposal(8477) {
            title("More officer cards")
            ai("1.0")
            author(Jason)
            chamber(Economy)
            sponsored()

            text(
                """
Amend Rule 2624 (Card Administration) by replacing the final paragraph
(including the list) with the following:

{

  The officeholder of an office CAN by announcement grant another player a
  specified type of card, specifying that office, under the following
  conditions:

  * e has not done so in reference to that office in the current Agoran month,

  * that office's interests includes the card's associated ministry,

  * the player receiving the card does not hold an office with the card's
  associated ministry in its interests, and

  * the player receiving the card is not a zombie.

}"""
            )
        }
    }

    voting {
        votes(omd) {
            PRESENT on 8477
        }

        votes(PSS) {
            FOR on 8477
        }

        votes(nix) {
            FOR on 8477
        }
    }
}
