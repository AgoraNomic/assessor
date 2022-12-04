package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.pmBonus
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8235to8242() = assessment {
    name("8235-8242")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2019-August/013106.html")
    quorum(9)

    strengths {
        default(3)
        min(0)
        max(5)

        pmBonus(G)
        blotPenalty(Corona, 2)
        blotPenalty(twg, 1)
    }

    proposals {
        using(proposals8235to8242())
    }

    voting {
        votes(Janet) {
            FOR on 8235
            FOR on 8236
            FOR on 8237
            FOR on 8238
            FOR on 8239
            FOR on 8240
            FOR on 8241
            FOR on 8242
        }

        votes(twg) {
            FOR on all
        }

        votes(JacobArduino) {
            endorse(twg) on all
        }

        votes(Falsifian) {
            PRESENT on 8235
            PRESENT on 8236
            AGAINST on 8237
            endorse(twg) on 8238
            PRESENT on 8239
            endorse(Janet) on 8240
            endorse(Janet) on 8241
            FOR on 8242
        }

        votes(omd) {
            FOR on 8235
            FOR on 8236
            PRESENT on 8237
            FOR on 8238
            FOR on 8239
            FOR on 8240
            // NO VOTE on 8241
            FOR on 8242
        }

        votes(G) {
            PRESENT on all
        }

        votes(Telna) {
            PRESENT on all
        }

        votes(Murphy) {
            PRESENT on 8235
            AGAINST on 8236
            PRESENT on 8237
            FOR on 8238
            AGAINST on 8239
            PRESENT on 8240
            PRESENT on 8241
            PRESENT on 8242
        }
    }
}
