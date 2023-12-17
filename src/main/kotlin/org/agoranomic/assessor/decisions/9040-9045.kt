package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.*
import org.agoranomic.assessor.lib.vote.VoteKind.AGAINST
import org.agoranomic.assessor.lib.vote.VoteKind.FOR

@UseAssessment
fun assessment9040to9045() = assessment {
    name("9040-9045")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            powerDream(Aris, 2)
            powerDream(Yachay, 2)
            powerDream(Goren, 2)

            powerStone(Janet, 3)

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
        proposal(9040) {
            title("Adoption AI security")
            ai("1.0")
            author(Janet)
            coauthors(ais523)
            ordinary()

            text(
                """
Amend Rule 1607 ("Distribution") by deleting the text ", or 1.0 if the
proposal does not have one".

[A proposal always has a numeric AI, so this clause can never be
triggered. And, even if it could be triggered, this isn't the right
behavior (AI 3 would be a more sensible default, but we don't add that
here because it's impossible).]


Amend Rule 106 ("Adopting Proposals") by replacing "its power is set to
the minimum of four and its adoption index" with "its power is set to
the minimum of four, the adoption index of the proposal, and the
adoption index of the referendum".

[Defend against any case where a proposal does not have an AI but the
referendum does, or where the referendum has a lower AI than the proposal.]


[Currently, these issues combine so that if there were somehow a
proposal without an AI (which cannot exist not but has been possible in
the past, according to ais523), it would be voted on at AI 1.0 but
adopted at power 4; this fixes both: it would no longer be
distributable, and if it were to take effect it would only take effect
at power 1.]"""
            )
        }

        proposal(9041) {
            title("Repeal 107")
            ai("3.0")
            author(Forest)
            coauthors(Murphy)
            democratic()

            text(
                """
Repeal Rule 107 ("Initiating Agoran Decisions")"""
            )
        }

        proposal(9042) {
            title("Repeal 2464")
            ai("1.0")
            author(Forest)
            coauthors(Murphy)
            ordinary()

            text(
                """
Repeal Rule 2464 ("Tournaments")"""
            )
        }

        proposal(9043) {
            title("Repeal 2676")
            ai("1.7")
            author(Forest)
            coauthors(Murphy)
            ordinary()

            text(
                """
Repeal Rule 2676 ("Forgiveness")"""
            )
        }

        proposal(9044) {
            title("Repeal 2573")
            ai("2.0")
            author(Forest)
            coauthors(Murphy)
            ordinary()

            text(
                """
Repeal Rule 2573 ("Impeachment")"""
            )
        }

        proposal(9045) {
            title("Repeal 879")
            ai("3.0")
            author(Forest)
            coauthors(Murphy)
            democratic()

            text(
                """
Repeal Rule 879 ("Quorum")"""
            )
        }
    }

    voting {
        votes(Kate) {
            endorse(Janet) on 9040
            AGAINST on 9041
            AGAINST on 9042
            AGAINST on 9043
            AGAINST on 9044
            AGAINST on 9045
        }

        votes(Murphy) {
            FOR on 9040
            AGAINST on 9041
            AGAINST on 9042
            AGAINST on 9043
            AGAINST on 9044
            AGAINST on 9045
        }
    }
}
