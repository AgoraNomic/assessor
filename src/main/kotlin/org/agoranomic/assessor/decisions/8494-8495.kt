package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.ministries.Office_2020_06_30.*
import org.agoranomic.assessor.dsl.ministries.ministries_2020_08_02
import org.agoranomic.assessor.dsl.ministries.officeMapOf
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.addToHolder
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.lib.proposal.MinistryV1.Legislation
import org.agoranomic.assessor.lib.vote.VoteKind.AGAINST

@UseAssessment
fun assessment8494to8495() = assessment {
    name("8494-8495")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-September/014195.html and https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-September/014196.html")
    quorum(3)

    val offices = officeMapOf(
        ADoP to Murphy,
        Arbitor to G,
        Assessor to Jason,
        Coopor to RLee,
        Distributor to omd,
        Herald to PSS,
        Notary to ATMunn,
        PrimeMinister to nix,
        Promotor to Aspen,
        Referee to PSS,
        Registrar to Falsifian,
        Rulekeepor to Jason,
        Speaker to grok,
        Tailor to PSS,
        Treasuror to Trigon,
        Webmastor to nix,
    )

    strengths {
        default(3)
        min(0)
        max(15)

        blotPenalty(Gaelan, 4 / 3)
        blotPenalty(RLee, 81 / 3)

        addToHolder(offices, Speaker, 1)
        ministries_2020_08_02(offices, allProposals)
    }

    proposals(v2) {
        proposal(8494) {
            title("nope")
            ai("1.0")
            author(Gaelan)
            chamber(Legislation)
            sponsored()

            text("Repeal rule 2633.")
        }

        proposal(8498) {
            title("nopenopenope")
            ai("3.0")
            author(Gaelan)
            democratic()
            sponsored()

            text("Repeal rule 2633.")
        }
    }

    voting {
        votes(G) {
            AGAINST on all
        }

        votes(DMargaux) {
            AGAINST on all
        }
    }
}
