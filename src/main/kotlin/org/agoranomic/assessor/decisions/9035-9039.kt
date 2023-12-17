package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.dsl.votes.powerDream
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment9035to9039() = assessment {
    name("9035-9039")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2023-December/017507.html")
    quorum(6)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            powerDream(Aris, 2)
            powerDream(Yachay, 2)

            complexityBonuses {
                maxBonus(3)

                "Absurdor"(0) heldBy juan
                "ADoP"(1) heldBy Murphy
                "Arbitor"(2) heldBy Kate
                "Assessor"(3) heldBy Janet
                "Collector"(1) heldBy snail
                "Distributor"(0) heldBy omd
                "Dream Keeper"(1) heldBy snail
                "Geologist"(1) heldBy Forest
                "Herald"(2) heldBy snail
                "Illuminator"(1) heldBy snail
                "Notary"(2) heldBy snail
                "Prime Minister"(0) heldBy Janet
                "Promotor"(3) heldBy snail
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy snail
                "Stonemason"(1) heldBy Janet
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy null
            }
        }
    }

    proposals(v4) {
        proposal(9035) {
            title("Unbreaking Motions")
            ai("2.0")
            author(snail)
            coauthors(Forest)
            ordinary()

            text(
                """
Change the power of Rule 2463 ("Motion of No Confidence") to 2.
[Offices are secured, so you can't actually remove the PM in this way
currently.]"""
            )
        }

        proposal(9036) {
            title("AI security revisited")
            ai("3.0")
            author(Janet)
            coauthors(ais523)
            democratic()

            text(
                """
Amend R1607 by replacing "A referendum is the Agoran decision to
determine whether to adopt a proposal." with "A referendum is the Agoran
decision to determine whether to adopt a proposal (its associated
proposal)."

[Define this undefined term.]


Amend Rule 1950 by, as a single amendment:

{

Deleting "If a referendum has an adoption index less than the adoption
index of its associated proposal, the referendum's adoption index is
immediately set to that of the associated proposal".

Then, inserting the following paragraph after the first paragraph:

{

The adoption index of a referendum CANNOT be set or changed to "none" or
to a value less than that of its associated proposal. If a referendum
ever has an adoption index of "none" or an adoption index less than that
of its associated proposal, it is immediately set to the adoption index
of the associated proposal.

}

}

[Prevent a low-powered rule from attempting to continuously set the
value of an AI, causing it to perhaps become indeterminate.]"""
            )
        }

        proposal(9037) {
            title("Uncrossed arms")
            ai("2.0")
            author(Murphy)
            ordinary()

            text(
                """
Amend Rule 2642 (Gathering Stones) by replacing this text:

       At the beginning of each week, the stone specified by the player
       with the highest Modified Rockiness that reached for a stone in
       the previous week is transferred to em. In a tie, the stone
       specified by the tied player who reached first is transferred to
       em. When a player receives a stone in this way, eir Base Rockiness
       is set to 0.

with this text:

       At the beginning of each week, each stone owned by Agora is
       transferred to the player (if any) with the highest Modified
       Rockiness that reached for that stone in the previous week,
       with ties broken in favor of the tied player who reached for
       that stone first. When a player receives a stone in this way,
       eir Base Rockiness is set to 0."""
            )
        }

        proposal(9038) {
            title("Ratify the Ruleset Week")
            ai("1.0")
            author(Murphy)
            ordinary()

            text(
                """
Create a rule titled "Ratify the Ruleset Week" with this text:

       The Agoran week each year containing the Ides of March is Ratify
       the Ruleset Week. During Ratify the Ruleset Week, the Rulekeepor
       SHALL submit a proposal to ratify a purported ruleset published
       since the last time the ruleset was ratified."""
            )
        }

        proposal(9039) {
            title("Well, worth a shot")
            ai("1.0")
            author(juan)
            ordinary()

            text(
                """
Create a rule with title “We win”, power 1, and text:
{
Immediatly after the creation of this rule, the players
4st, juan, zipzap, Goren, crystalizedmire, cuddlybanana,
Anneke-Constantine and kiako win the game and this rule
is repealed, in that order.
}

Grant players 4st, juan, zipzap, Goren, crystalizedmire,
cuddlybanana, Anneke-Constantine and kiako Black Ribbons."""
            )
        }
    }

    voting {
        votes(snail) {
            FOR on 9035
            endorse(Janet) on 9036
            FOR on 9037
            FOR on 9038
            AGAINST on 9039
        }

        votes(Janet) {
            AGAINST on 9035
            FOR on 9036
            AGAINST on 9037
            PRESENT on 9038
            AGAINST on 9039
        }

        votes(juan) {
            endorse(Forest) on 9035
            endorse(Janet) on 9036 comment "${Janet.name} is the Rulekeepor"
            PRESENT on 9037
            endorse(Janet) on 9038 comment "${Janet.name} is the Rulekeepor"
            FOR on 9039
        }

        votes(Gaelan) {
            FOR on 9035
            FOR on 9036
            PRESENT on 9037
            PRESENT on 9038
            AGAINST on 9039
        }

        votes(Forest) {
            FOR on 9035
            AGAINST on 9036
            FOR on 9037
            FOR on 9038
            FOR on 9039
        }

        votes(Yachay) {
            FOR on 9035
            PRESENT on 9036
            FOR on 9037
            AGAINST on 9038
            AGAINST on 9039
        }

        votes(nix) {
            endorse(Aris) on 9035
            FOR on 9037
            FOR on 9038
            AGAINST on 9039
        }

        votes(kiako) {
            FOR on 9035
            FOR on 9036
            PRESENT on 9037
            endorse(Janet) on 9038 comment "${Janet.name} is the Rulekeepor"
            AGAINST on 9039
        }

        votes(Kate) {
            FOR on 9035
            endorse(Janet) on 9036
            FOR on 9037
            FOR on 9038
            AGAINST on 9039
        }
    }
}
