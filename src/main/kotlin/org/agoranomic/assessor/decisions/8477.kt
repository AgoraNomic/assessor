package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.ministries.Office_2020_06_30.*
import org.agoranomic.assessor.dsl.ministries.ministries_2020_07_26
import org.agoranomic.assessor.dsl.ministries.officeMapOf
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.addToHolder
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.lib.proposal.MinistryV1.Economy
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8477() = assessment {
    name("8477")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-July/014028.html")
    quorum(8)

    val offices = officeMapOf(
        ADoP to Murphy,
        Arbitor to G,
        Assessor to Janet,
        Coopor to RLee,
        Distributor to omd,
        Herald to PSS,
        Notary to ATMunn,
        PrimeMinister to nix,
        Promotor to Aris,
        Referee to PSS,
        Registrar to Falsifian,
        Rulekeepor to Janet,
        Speaker to Janet,
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
            author(Janet)
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

        votes(Janet) {
            FOR on 8477
        }

        votes(ATMunn) {
            FOR on 8477
        }

        votes(Falsifian) {
            AGAINST on 8477
        }

        votes(G) {
            FOR on 8477
        }

        votes(Kate) {
            FOR on 8477
        }

        votes(Murphy) {
            FOR on 8477
        }
    }
}
