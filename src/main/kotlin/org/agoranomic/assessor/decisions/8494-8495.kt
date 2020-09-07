package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.ministries.OfficeJune30.*
import org.agoranomic.assessor.dsl.ministries.ministries_2020_08_02
import org.agoranomic.assessor.dsl.ministries.officeMapOf
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.lib.proposal.Ministry.Legislation
import org.agoranomic.assessor.dsl.votes.addToHolder
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.lib.vote.VoteKind.FOR

@UseAssessment
fun assessment8494to8495() = assessment {
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
        Promotor to Aris,
        Referee to PSS,
        Registrar to Falsifian,
        Rulekeepor to Jason,
        Speaker to ATMunn,
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

        proposal(8495) {
            title("nopenopenope")
            ai("3.0")
            author(Gaelan)
            democratic()
            sponsored()

            text("Repeal rule 2633.")
        }
    }

    voting {
        votes(Shelvacu) {
            FOR on all
        }

        votes(Murphy) {
            FOR on all
        }

        votes(Jason) {
            FOR on 8494
            FOR on 8495
        }
    }
}
