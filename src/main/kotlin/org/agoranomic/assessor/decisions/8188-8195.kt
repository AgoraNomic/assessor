package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.match
import org.agoranomic.assessor.dsl.votes.pmBonus
import org.agoranomic.assessor.lib.vote.VoteKind.AGAINST
import org.agoranomic.assessor.lib.vote.VoteKind.FOR

@UseAssessment
fun `assessment 8188 to 8195`() = assessment {
    name("8188-8195")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2019-July/013007.html")
    quorum(7)

    strengths {
        default(3)
        min(0)
        max(5)

        pmBonus(G)
    }

    proposals {
        using(proposals8188to8195())
    }

    voting {
        votes(G) {
            FOR on 8188
            FOR on 8189
            FOR on 8190
            AGAINST on 8191
            FOR on 8192
            FOR on 8195
        }

        votes(Telnaior) {
            match(G) on all
        }

        votes(Jason) {
            FOR on 8188
            FOR on 8189
            FOR on 8190
            FOR on 8191
            FOR on 8192
            FOR on 8195
        }

        votes(Falsifian) {
            FOR on 8188
            FOR on 8189
            FOR on 8190
            FOR on 8191
            FOR on 8192
            FOR on 8195
        }
    }
}
