package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.endorseOfficer
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment9277to9279() = assessment {
    name("9277-9279")
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
        proposal(9277) {
            title("Bring Back Yellow")
            ai("3.0")
            author(Forest)
            coauthors(snail, Trigon, ais523, Janet)
            democratic()

            text(
                """
[persuasion: Instead of inserting subgames into the rules... we have
been inserting subgames directly into the rules, and creating the
"contests" rule.]
Amend Rule 2348 ("Ribbons") by appending another paragraph after the
one starting with "Orange (O):" with the text:
{
Yellow (Y): When a tournament that a player was a gamemaster of ends
with a winner, that gamemaster earns a Yellow Ribbon.
}"""
            )
        }

        proposal(9278) {
            title("Bring Back Science (fixing the oops)")
            ai("3.0")
            author(Forest)
            coauthors(snail, Trigon, ais523, Janet)
            democratic()

            text(
                """
Amend Rule 2348 ("Ribbons") by appending another paragraph after the
one starting with "Orange (O):" with the text:
{
Infrared (D): When a player earns an Indigo Ribbon, that player CAN,
once by announcement, grant any other person an Infrared Ribbon.
}"""
            )
        }

        proposal(9279) {
            title("Less confusing Speaker nomination")
            ai("2.0")
            author(ais523)
            ordinary()

            text(
                """
In rule 103, delete
{{{
If at any time the office of Speaker is
vacant, or when one or more players win Agora, then the Prime
Minister CAN once appoint a Laureled player to the office of
Speaker by announcement.
}}}
and, as a new paragraph immediately after the location from which that
text was deleted, add
{{{
The Prime Minister CAN by announcement appoint a Laureled player to the
office of Speaker if either of the following conditions apply:
a) the office of Speaker is vacant; or
b) the same person has been Speaker continuously since a player most
recently won Agora.
}}}
[The existing rule is unclear about when the win-created ability to
appoint a Speaker ends. For example, suppose a player wins twice in the
same message: under the existing rules that may create an obligation to
reinstall em as Speaker the next time a new Speaker is nominated for
non-win reasons, because only one of the two appointment permissions
was discharged at the time of eir original appointment.]"""
            )
        }
    }

    voting {
        votes(ais523) {
            AGAINST on 9277
            AGAINST on 9278
            FOR on 9279
        }

        votes(juan) {
            PRESENT on 9277
            PRESENT on 9278
            PRESENT on 9279
        }

        votes(Forest) {
            endorseOfficer("Tailor", Murphy) on 9277
            endorseOfficer("Tailor", Murphy) on 9278
            endorseOfficer("Tailor", Murphy) on 9279
        }

        votes(Mischief) {
            AGAINST on 9277
            AGAINST on 9278
            AGAINST on 9279
        }
    }
}
