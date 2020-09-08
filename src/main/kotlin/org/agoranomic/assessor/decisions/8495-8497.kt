package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.ministries.OfficeJune30.*
import org.agoranomic.assessor.dsl.ministries.ministries_2020_08_02
import org.agoranomic.assessor.dsl.ministries.officeMapOf
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.addToHolder
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.lib.proposal.Ministry.Legislation
import org.agoranomic.assessor.lib.proposal.Ministry.Participation

@UseAssessment
fun assessment8495to8497() = assessment {
    quorum(5)

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
        proposal(8495) {
            title("Please stand by")
            ai("1.0")
            author(G)
            chamber(Participation)
            sponsored()

            text("""
Create a rule, "Please Stand By", with the following text:

  Normal service will resume shortly.""")
        }

        proposal(8496) {
            title("Timely reminders")
            ai("1.0")
            author(Jason)
            coauthors(Aris)
            chamber(Legislation)
            sponsored()

            text("""
Amend Rule 2168 by replacing  the text "Upon such an occurrence" with
the text "Within two days of such an occurrence"""")
        }

        proposal(8497) {
            title("Withdrawal Quick-Fix")
            ai("3.0")
            author(nix)
            democratic()
            sponsored()

            text("""
Amend R2350 "Proposals" by adding, to the last paragraph:

"When a player withdraws a pending proposal, e CAN, by announcement,
grant a Pendant to the player that pended the proposal."""")
        }
    }
}
