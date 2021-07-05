package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.match
import org.agoranomic.assessor.dsl.votes.pmBonus
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8215to8234() = assessment {
    name("8215-8234")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2019-August/013099.html")
    quorum(9)

    proposals {
        using(proposals8215to8234())
    }

    strengths {
        default(3)
        min(0)
        max(5)

        pmBonus(G)

        blotPenalty(Corona, 2)
        blotPenalty(twg, 1)
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
            AGAINST on 8229
            FOR on 8230 comment NO_VETO
            AGAINST on 8231
            endorse(Murphy) on 8232
            AGAINST on 8233
            FOR on 8234 comment NO_VETO
        }

        votes(Murphy) {
            FOR on 8215
            AGAINST on 8216
            FOR on 8217
            FOR on 8218
            PRESENT on 8221
            PRESENT on 8222
            PRESENT on 8223
            AGAINST on 8224
            FOR on 8227
            AGAINST on 8228
            AGAINST on 8229
            FOR on 8230
            FOR on 8231
            FOR on 8232
            FOR on 8233
            endorse(G /* Herald */) on 8234
        }

        votes(DMargaux) {
            endorse(G) on 8215 comment "Final non-conditional ballot"
            endorse(G) on 8216 comment "Final non-conditional ballot"
            endorse(G) on 8217 comment "Final non-conditional ballot"
            endorse(G) on 8218 comment "Final non-conditional ballot"
            endorse(G) on 8221 comment "Final non-conditional ballot"
            endorse(G) on 8222 comment "Final non-conditional ballot"
            endorse(G) on 8223 comment "Final non-conditional ballot"
            endorse(G) on 8224 comment "Final non-conditional ballot"
            endorse(Falsifian) on 8227 comment "Final non-conditional ballot"
            endorse(G) on 8228 comment "Final non-conditional ballot"
            endorse(Telna) on 8229 comment "Final non-conditional ballot"
            endorse(G) on 8230 comment "Final non-conditional ballot"
            endorse(G) on 8231 comment "Final non-conditional ballot"
            endorse(G) on 8232 comment "Final non-conditional ballot"
            endorse(G) on 8234 comment "Final non-conditional ballot"
        }

        votes(Jason) {
            FOR on 8215
            AGAINST on 8216
            PRESENT on 8217
            FOR on 8218
            FOR on 8221
            FOR on 8222
            AGAINST on 8223
            AGAINST on 8224
            endorse(G) on 8227
            FOR on 8228
            AGAINST on 8229
            AGAINST on 8230
            AGAINST on 8231
            FOR on 8232
            AGAINST on 8233
            FOR on 8234
        }

        votes(G) {
            FOR on 8215
            AGAINST on 8216
            FOR on 8217
            FOR on 8218
            FOR on 8221
            FOR on 8222
            AGAINST on 8223
            AGAINST on 8224
            AGAINST on 8227
            FOR on 8228
            FOR on 8229
            PRESENT on 8230
            PRESENT on 8231
            FOR on 8232
            AGAINST on 8233
            FOR on 8234
        }

        votes(Telna) {
            match(G) on all
        }
    }
}
