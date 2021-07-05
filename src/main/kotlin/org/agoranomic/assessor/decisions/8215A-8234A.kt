package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.pmBonus
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8215Ato8234A() = assessment {
    name("8215A-8234A")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2019-September/013133.html")
    quorum(4)

    strengths {
        default(3)
        min(0)
        max(5)

        pmBonus(G)
        blotPenalty(Corona, 2)
    }

    proposals {
        using(proposals8215to8234())
    }

    voting {
        votes(Falsifian) {
            endorse(G) on 8215
            AGAINST on 8216
            endorse(G) on 8217
            endorse(Jason) on 8218
            PRESENT on 8221
            endorse(Jason) on 8222
            AGAINST on 8223
            PRESENT on 8224
            AGAINST on 8227
            endorse(G) on 8228
            PRESENT on 8229
            FOR on 8230 comment NO_VETO
            AGAINST on 8231
            endorse(Murphy) on 8232
            AGAINST on 8233
            FOR on 8234 comment NO_VETO
        }

        votes(Aspen) {
            FOR on 8215
            AGAINST on 8216
            endorse(G) on 8217
            AGAINST on 8218
            FOR on 8221
            endorse(Jason) on 8222
            AGAINST on 8223
            AGAINST on 8224
            AGAINST on 8227
            FOR on 8228
            FOR on 8229
            FOR on 8230 comment NO_VETO
            PRESENT on 8231 comment NO_VETO
            PRESENT on 8232
            AGAINST on 8233
            FOR on 8234 comment NO_VETO
        }

        votes(Jason) {
            FOR on 8215
            AGAINST on 8216
            PRESENT on 8217
            AGAINST on 8218
            FOR on 8221
            FOR on 8222
            AGAINST on 8223
            AGAINST on 8224
            endorse(Falsifian) on 8227
            FOR on 8228
            FOR on 8229
            FOR on 8230 comment NO_VETO
            AGAINST on 8231
            FOR on 8232
            AGAINST on 8233
            FOR on 8234
        }

        votes(twg) {
            endorse(G) on 8215
            AGAINST on 8216
            endorse(G) on 8217
            endorse(Jason) on 8218
            PRESENT on 8221
            endorse(Jason) on 8222
            AGAINST on 8223
            AGAINST on 8224
            AGAINST on 8227
            PRESENT on 8228
            PRESENT on 8229
            endorse(Murphy) on 8230
            endorse(Murphy) on 8231
            FOR on 8232
            AGAINST on 8233
            endorse(G) on 8234
        }

        votes(JacobArduino) {
            endorse(twg) on all
        }

        votes(Trigon) {
            FOR on 8215
            PRESENT on 8216
            PRESENT on 8217
            FOR on 8218
            FOR on 8221
            PRESENT on 8222
            FOR on 8223
            PRESENT on 8224
            FOR on 8227
            FOR on 8228
            FOR on 8229 comment NO_VETO
            AGAINST on 8230
            AGAINST on 8231
            FOR on 8232
            AGAINST on 8233
            FOR on 8234 comment NO_VETO
        }

        votes(G) {
            FOR on 8215
            AGAINST on 8216
            FOR on 8217
            endorse(Aspen) on 8218
            FOR on 8221
            FOR on 8222
            AGAINST on 8223
            AGAINST on 8224
            AGAINST on 8227
            FOR on 8228
            FOR on 8229
            FOR on 8230
            PRESENT on 8231
            AGAINST on 8232
            PRESENT on 8233
            FOR on 8234
        }
    }
}
