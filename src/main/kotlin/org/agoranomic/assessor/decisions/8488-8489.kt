package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.ministries.Office_2020_06_30.*
import org.agoranomic.assessor.dsl.ministries.endorseOfficer
import org.agoranomic.assessor.dsl.ministries.ministries_2020_08_02
import org.agoranomic.assessor.dsl.ministries.officeMapOf
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.addToHolder
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.lib.proposal.MinistryV1.Economy
import org.agoranomic.assessor.lib.vote.VoteKind.FOR
import org.agoranomic.assessor.lib.vote.VoteKind.PRESENT

@UseAssessment
fun assessment8488to8489() = assessment {
    name("8488-8489")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-August/014146.html")
    quorum(7)

    val offices = officeMapOf(
        ADoP to Murphy,
        Arbitor to G,
        Assessor to Janet,
        Coopor to RLee,
        Distributor to omd,
        Herald to PSS,
        Notary to ATMunn,
        PrimeMinister to nix,
        Promotor to Aspen,
        Referee to PSS,
        Registrar to Falsifian,
        Rulekeepor to Janet,
        Speaker to ATMunn,
        Tailor to PSS,
        Treasuror to Trigon,
        Webmastor to nix,
    )

    strengths {
        default(3)
        min(0)
        max(15)

        blotPenalty(Gaelan, 4 / 3)
        blotPenalty(RLee, 81 / 3)

        addToHolder(offices, Speaker, 1)
        ministries_2020_08_02(offices, allProposals)
    }

    proposals(v2) {
        proposal(8488) {
            title("Empty the escalator v1")
            ai("3.0")
            author(Falsifian)
            coauthors(Janet, omd)
            democratic()
            sponsored()

            text(
                """
Amend Rule 2577 by adding the sentence "Attempts to destroy no assets
are successful." before the sentence that begins "An indestructible asset".

Amend Rule 2577 by adding the sentence "Attempts to transfer no assets
are successful." before the sentence that begins "A fixed asset".

Amend Rule 2579 by deleting the paragraph that ends with "0 or empty fee"."""
            )
        }

        proposal(8489) {
            title("Interesting economics")
            ai("1.0")
            author(Janet)
            chamber(Economy)
            sponsored()

            text(
                """
Amend Rule 2624 by appending the following sentence to the first
paragraph: "The type of card with the fewest existing instances is
associated with the Ministry of Economy.""""
            )
        }
    }

    voting {
        votes(Janet) {
            PRESENT on 8488
            FOR on 8489
        }

        votes(Trigon) {
            FOR on 8488
            FOR on 8489
        }

        votes(Falsifian) {
            FOR on 8488
            endorseOfficer(offices, Assessor) on 8489
        }

        votes(ATMunn) {
            FOR on 8488
            FOR on 8489
        }

        votes(Murphy) {
            FOR on 8488
            FOR on 8489
        }
    }
}
