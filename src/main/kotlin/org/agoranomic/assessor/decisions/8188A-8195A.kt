package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.*
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8188Ato8195A() = assessment {
    suffix("A")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2019-July/013040.html")
    quorum(7)

    strengths {
        default(3)
        min(0)
        max(5)

        pmBonus(G)

        blotPenalty(Corona, 2)
        blotPenalty(twg, 1)
    }

    proposals {
        using(proposals8188to8195())
    }

    voting {
        votes(Aris) {
            FOR on 8188
            FOR on 8189
            FOR on 8190
            FOR on 8191
            FOR on 8192
            FOR on 8195
        }

        votes(nix) {
            FOR on 8188
            FOR on 8189
            FOR on 8190
            FOR on 8191
            FOR on 8192
            AGAINST on 8195
        }

        votes(Jason) {
            PRESENT on 8188
            FOR on 8189
            FOR on 8190
            FOR on 8191
            FOR on 8192
            FOR on 8195
        }

        votes(Trigon) {
            FOR on 8188
            FOR on 8189
            FOR on 8190
            FOR on 8191
            FOR on 8192
            PRESENT on 8195
        }

        votes(DMargaux) {
            FOR on 8188
            FOR on 8189
            FOR on 8190
            FOR on 8191
            FOR on 8192
            FOR on 8195
        }

        votes(RLee) {
            FOR on 8188
            FOR on 8189
            FOR on 8190
            FOR on 8191
            FOR on 8192
            PRESENT on 8195
        }

        votes(Halian) {
            endorse(RLee) on all
        }

        votes(L) {
            endorse(DMargaux) on all
        }

        votes(Murphy) {
            FOR on 8188
            FOR on 8189
            FOR on 8190
            FOR on 8191
            FOR on 8192
            FOR on 8195
        }

        votes(twg) {
            endorse(author) on all
        }

        votes(JacobArduino) {
            endorse(twg) on all
        }

        votes(G) {
            FOR on 8188
            FOR on 8189
            FOR on 8190
            FOR on 8191
            FOR on 8192
            AGAINST on 8195
        }

        votes(Telnaior) {
            match(G) on all
        }

        votes(Falsifian) {
            FOR on 8188
            FOR on 8189
            FOR on 8190
            FOR on 8191
            FOR on 8192
            AGAINST on 8195
        }
    }
}
