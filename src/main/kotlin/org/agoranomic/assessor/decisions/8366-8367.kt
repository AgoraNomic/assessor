package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.ministries.OfficeInitial.*
import org.agoranomic.assessor.dsl.ministries.ministries_2020_04_02
import org.agoranomic.assessor.dsl.ministries.officeMapOf
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.addToHolder
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.lib.vote.VoteKind.FOR

@UseAssessment
fun assesssment8366to8367() = assessment {
    name("8366-8367")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-April/013590.html")
    quorum(7)

    val offices = officeMapOf(
        ADoP to Murphy,
        Arbitor to G,
        Assessor to Jason,
        Comptrollor to null,
        Distributor to omd,
        Herald to Alexis,
        Notary to Gaelan,
        PrimeMinister to Aspen,
        Promotor to Aspen,
        Referee to PSS,
        Registrar to Falsifian,
        Rulekeepor to Jason,
        Speaker to twg,
        Tailor to twg,
        Treasuror to twg
    )

    strengths {
        default(3)
        min(0)
        max(15)

        addToHolder(offices, Speaker, 1)
        blotPenalty(Murphy, 1) // 4 Blots
        blotPenalty(twg, 2) // 6 Blots

        ministries_2020_04_02(offices, allProposals)
    }

    proposals(v1) {
        proposal(8366) {
            title("Asset Determinacy")
            ai("3.0")
            author(Aspen)
            coauthors(twg)
            democratic()

            text(
                """
Amend Rule 2576, "Ownership", by changing the text
  "If an asset would otherwise lack an owner, it is owned by the Lost
   and Found Department"
to read
   "If an asset would otherwise lack an owner, or if its ownership
    would otherwise be indeterminate, it is owned by the Lost and Found
    Department.

If there is a rule titled "A Coin Award", repeal it."""
            )
        }

        proposal(8367) {
            title("Slow burn")
            ai("3.0")
            author(Murphy)
            coauthors(Falsifian)
            democratic()

            text(
                """
Amend Rule 1789 (Cantus Cygneus) by replacing "Registrar's Report" with
"Registrar's monthly report"."""
            )
        }
    }

    voting {
        votes(RLee) {
            FOR on all
        }

        votes(Alexis) {
            endorse(RLee) on all
        }

        votes(PSS) {
            FOR on 8367
            FOR on 8366
        }

        votes(Warrigal) {
            FOR on 8366
            FOR on 8367
        }

        votes(Trigon) {
            FOR on 8366
            FOR on 8367
        }

        votes(Jason) {
            FOR on 8366
            FOR on 8367
        }

        votes(Rance) {
            endorse(Jason) on all
        }

        votes(Falsifian) {
            endorse(Aspen) on 8366
            FOR on 8367
        }
    }
}
