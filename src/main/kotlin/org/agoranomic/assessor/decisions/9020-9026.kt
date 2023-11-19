package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.*
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment9020t9026() = assessment {
    name("9020-9026")
    quorum(3)

    strengths {
        default(3)
        min(0)
        max(15)

        blotPenalty(Forest, 25 / 3)

        onOrdinaryProposals {
            powerDream(Aris, 2)
            powerDream(Yachay, 2)

            complexityBonuses {
                maxBonus(3)

                "Absurdor"(0) heldBy juan
                "ADoP"(1) heldBy Murphy
                "Arbitor"(2) heldBy null
                "Assessor"(3) heldBy Janet
                "Collector"(1) heldBy snail
                "Distributor"(0) heldBy omd
                "Dream Keeper"(1) heldBy snail
                "Herald"(2) heldBy snail
                "Notary"(2) heldBy snail
                "Prime Minister"(0) heldBy null
                "Promotor"(3) heldBy snail
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy ais523
                "Stonemason"(1) heldBy Janet
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy null
            }
        }
    }

    proposals(v4) {
        proposal(9020) {
            title("Free Black Ribbons")
            ai("1.0")
            author(Forest)
            coauthors(snail, juan, kiako, Zipzap, Murphy)
            ordinary()

            text(
                """
Grant all players who voted FOR this proposal a black ribbon."""
            )
        }

        proposal(9021) {
            title("Free Points")
            ai("1.0")
            author(Forest)
            coauthors(snail, juan, kiako, Zipzap, Murphy)
            ordinary()

            text(
                """
Grant all players who vote FOR this proposal 50 points.
(You're welcome Murphy!)"""
            )
        }

        proposal(9022) {
            title("Free Pebbles")
            ai("1.0")
            author(Forest)
            coauthors(snail, juan, kiako, Zipzap, Murphy)
            ordinary()

            text(
                """
Enact a new rule entitled "Pebbles", power=1, and the following text:
{
A pebble is a stone with smoothness 0, a weekly frequency, and no effect,
and is uniquely identified by "Pebble of " and a player's name.
}
For each player that voted FOR this proposal, create a pebble in their
possession with their name."""
            )
        }

        proposal(9023) {
            title("Free Stamps")
            ai("1.0")
            author(Forest)
            coauthors(snail, juan, kiako, Zipzap, Murphy)
            ordinary()

            text(
                """
Grant each player that voted FOR this proposal 1 stamp of eir own type."""
            )
        }

//        proposal(9024) {
//            title("Investigation time limits")
//            ai("1.7")
//            author(Janet)
//            ordinary()
//
//            text(
//                """
//Amend Rule 2478 by, as a single amendment:
//
//* Replacing "Within 14 days of an infraction being committed," with
//"Within 14 days of an infraction being committed, or if the infraction
//has been noted,".
//
//* Replacing "any other player in the last 7 days" with "any other player
//in the last 14 days".
//
//[Harmonize the time limits to investigate and to note, and ensure a
//noted infraction can always be investigated beyond the time limit to do
//so (allowing deputization).]"""
//            )
//        }

        proposal(9025) {
            title("Stone Repeal")
            ai("2.0")
            author(Yachay)
            ordinary()

            text(
                """
Repeal Rules 2640, 2641, 2642, 2643, 2644, and 2645 in ascending numerical
order by ID

// Comment: This November, this rule will have existed for three years.
Tragically, I haven't seen or experienced any interesting gameplay from it.
I believe it's time to move on."""
            )
        }

        proposal(9026) {
            title("It's a bit dark in here")
            ai("1.5")
            author(Janet)
            coauthors(Kate)
            ordinary()

            text(
                """
Amend Rule 2656 by, as a single amendment:

* First, prepending the following paragraph: { The Illuminator is an
office, responsible for tracking radiance. }

* Then, replacing "tracked by the Herald" with "tracked by the Illuminator"."""
            )
        }
    }

    voting {
        votes(snail) {
            AGAINST on 9020
            AGAINST on 9021
            AGAINST on 9022
            AGAINST on 9023
//            FOR on 9024
            PRESENT on 9025
            FOR on 9026
        }

        votes(Murphy) {
            AGAINST on 9020
            AGAINST on 9021
            AGAINST on 9022
            AGAINST on 9023
//            FOR on 9024
            FOR on 9025
            endorse(snail) on 9026 comment "${snail.name} is the Herald"
        }

        votes(kiako) {
            AGAINST on 9020
            AGAINST on 9021
            AGAINST on 9022
            AGAINST on 9023
//            endorse(Janet) on 9024
            FOR on 9025
            endorse(Janet) on 9026
        }

        votes(ais523) {
            AGAINST on 9020
            AGAINST on 9021
            AGAINST on 9022
            AGAINST on 9023
//            FOR on 9024
            AGAINST on 9025
            FOR on 9026
        }

        votes(Yachay) {
            AGAINST on 9020
            AGAINST on 9021
            AGAINST on 9022
            AGAINST on 9023
//            FOR on 9024
            FOR on 9025
            FOR on 9026
        }

        votes(Kate) {
            AGAINST on 9020
            AGAINST on 9021
            AGAINST on 9022
            AGAINST on 9023
//            endorse(Janet) on 9024
            AGAINST on 9025
            FOR on 9026
        }
    }
}
