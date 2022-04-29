package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.dsl.votes.powerStone
import org.agoranomic.assessor.dsl.votes.resolvedConditional
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8667to8668() = assessment {
    name("8667-8668")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(15)

        blotPenalty(Trigon, 7 / 3)
        blotPenalty(nix, 5 / 3)
        blotPenalty(cuddlybanana, 3 / 3)
        blotPenalty(Jason, 3 / 3)

        onOrdinaryProposals {
            powerStone(Jason, 3)
        }
    }

    proposals(v4) {
        proposal(8667) {
            title("welcome fix")
            ai("1.0")
            author(G)
            ordinary()
            sponsored()

            text("""
Amend Rule 2499 (Welcome Packages) by replacing:
    Any player CAN grant
with:
    Any player CAN, by announcement, grant""")
        }

        proposal(8668) {
            title("a light on darkness")
            ai("1.0")
            author(G)
            ordinary()
            sponsored()

            text("""
Repeal Rule 2617 (Defense Against the Dark Arts).""")
        }
    }

    voting {
        votes(Madrid) {
            FOR on all
        }

        votes(Jason) {
            FOR on 8667
            FOR on 8668
        }

        votes(ais523) {
            FOR on 8667
            FOR on 8668
        }

        votes(Murphy) {
            FOR on 8667
            PRESENT on 8668
        }

        votes(juan) {
            FOR on all
        }

        votes(Secretsnail9) {
            FOR on 8667
            AGAINST on 8668
        }

        votes(G) {
            FOR on 8667

            resolvedConditional(
                FOR,
                "No proposal that would amend R2617 has been submitted since the ballot was cost",
            ) on 8668
        }
    }
}
