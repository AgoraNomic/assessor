package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.match
import org.agoranomic.assessor.dsl.votes.pmBonus
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun `assessment 8235A to 8242A`() = assessment {
    name("8235A-8242A")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2019-September/013157.html")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(5)

        pmBonus(G)
    }

    proposals {
        using(proposals8235to8242())
    }

    voting {
        votes(Jason) {
            FOR on 8235
            FOR on 8236
            AGAINST on 8237
            endorse(Aris) on 8238
            FOR on 8239
            FOR on 8240
            FOR on 8241
            PRESENT on 8242
        }

        votes(Bernie) {
            endorse(Jason) on all
        }

        votes(Trigon) {
            FOR on 8235
            FOR on 8236
            AGAINST on 8237
            FOR on 8238
            FOR on 8239
            FOR on 8240
            FOR on 8241
            FOR on 8242
        }

        votes(Murphy) {
            PRESENT on 8235
            PRESENT on 8236
            AGAINST on 8237
            FOR on 8238
            PRESENT on 8239
            FOR on 8240
            FOR on 8241
            FOR on 8242
        }

        votes(Gaelan) {
            endorse(Murphy) on all
        }

        votes(twg) {
            endorse(Murphy) on all
        }

        votes(JacobArduino) {
            endorse(twg) on all
        }

        votes(Falsifian) {
            PRESENT on 8235
            PRESENT on 8236
            AGAINST on 8237
            AGAINST on 8238
            PRESENT on 8239
            endorse(Jason) on 8240
            endorse(Jason) on 8241
            FOR on 8242
        }

        votes(ATMunn) {
            endorse(Falsifian) on all
        }

        votes(Aris) {
            FOR on 8235
            FOR on 8236
            AGAINST on 8237
            AGAINST on 8238
            AGAINST on 8239
            FOR on 8240
            FOR on 8241
            FOR on 8242
        }

        votes(G) {
            PRESENT on 8235
            PRESENT on 8236
            AGAINST on 8237
            AGAINST on 8238
            AGAINST on 8239
            endorse(Aris) on 8240
            PRESENT on 8241
            AGAINST on 8242
        }

        votes(Rance) {
            match(G) on all
        }

        votes(o) {
            endorse(Trigon) on all
        }
    }
}
