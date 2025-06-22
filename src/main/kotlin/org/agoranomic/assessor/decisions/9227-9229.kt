package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment9227to9229() = assessment {
    name("9227-9229")
    quorum(5)

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
                "Promotor"(3) heldBy null
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
        proposal(9227) {
            title("Art Restoration Act")
            ai("3.0")
            author(Mischief)
            democratic()

            text(
                """
Amend rule 2029 (Town Fountain) by replacing "G." with "Goethe"

[That is how it was originally enacted, and it was later amended
unintentionally -- see CFJ 3902.

As a reminder, even though rule 2029 is power 4, the proposal only needs to
have an AI of 3 to satisfy rule 2140.]"""
            )
        }

        proposal(9228) {
            title("Pacifism")
            ai("1.0")
            author(Murphy)
            ordinary()

            text(
                """
Repeal Rule 2692 (Bang!).
Repeal Rule 2696 (Bang actions).
Repeal Rule 2697 (The Bounty Board).

[Vibe check.]"""
            )
        }

        proposal(9229) {
            title("Workaholics")
            ai("3.0")
            author(Murphy)
            democratic()

            text(
                """
Repeal Rule 2689 (Vacations & Delegation).

Amend Rule 2438 (Ribbons) by replacing this text:

       Cyan (C): When a person deputises for an office or is the delegate
       for an office while its holder is on vacation, and that person has
       not held or deputised for that office within the past 7 days, that
       person earns a Cyan Ribbon.

with this text:

       Cyan (C): When a person deputises for an office, and that person
       has not held or deputised for that office within the past 7 days,
       that person earns a Cyan Ribbon.

[Vibe check.]"""
            )
        }
    }

    voting {
        votes(juan) {
            FOR on 9227
            FOR on 9228
            PRESENT on 9229
        }

        votes(Mischief) {
            FOR on 9227
            PRESENT on 9228
            PRESENT on 9229
        }

        votes(Murphy) {
            FOR on 9227
            PRESENT on 9228
            PRESENT on 9229
        }

        votes(Cosmo) {
            FOR on 9227
            PRESENT on 9228
            PRESENT on 9229
        }

        votes(Janet) {
            AGAINST on 9227
            FOR on 9228
            AGAINST on 9229
        }

        votes(Kate) {
            AGAINST on 9227
            PRESENT on 9228
            AGAINST on 9229
        }
    }
}
