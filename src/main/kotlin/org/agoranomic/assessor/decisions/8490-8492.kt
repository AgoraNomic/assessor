package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.ministries.OfficeJune30.*
import org.agoranomic.assessor.dsl.ministries.ministries_2020_08_02
import org.agoranomic.assessor.dsl.ministries.officeMapOf
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.addToHolder
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.lib.proposal.Ministry.Efficiency
import org.agoranomic.assessor.lib.vote.VoteKind.AGAINST
import org.agoranomic.assessor.lib.vote.VoteKind.FOR

@UseAssessment
fun assessment8490to8492() = assessment {
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-August/014164.html")
    quorum(7)

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
        proposal(8490) {
            title("Functional Emergency Regulations")
            ai("3.0")
            author(Jason)
            democratic()

            text("""
Amend Rule 2614 by appending the following sentence to the paragraph
beginning "The Prime Minister CAN, in an emergency message and with 3
Agoran consent": "To the extent explicitly permitted by this rule,
Emergency Regulations are always taking effect."

[Right now, Emergency Regulations CAN do some stuff, but they never
actually take effect to do it.]""")
        }

        proposal(8491) {
            title("Minor Speaker fix")
            ai("2.0")
            author(ATMunn)
            chamber(Efficiency)
            sponsored()

            text("""
Amend Rule 103 "The Speaker" by appending the following sentence to
the paragraph beginning "If the office of Speaker has been held
continuously":
  Rules to the contrary notwithstanding, the Speaker CANNOT object to
  an intent by any player to do so.

  [Explanation: Currently, if the Speaker has been Speaker for at least
  90 days, e can be replaced with support. However, the Speaker has
  the power to stop any intent, even one that is with support, by
  objecting to it. This would mean that the Speaker cannot be removed by
  this method. The office can still be reappointed by the Prime Minister
  if another player wins the game, but as is, the 90+ days method is
  relatively obsolete. The fix is to either remove the feature
  altogether or fix it, and I think it's a nice feature, so I proposed
  this fix. I've also just managed to make an explanation about 3 times
  as long as the actual proposal. Oops.]""")
        }

        proposal(8492) {
            title("Unscoped RWO")
            ai("3.0")
            author(Jason)
            democratic()
            sponsored()

            text("""
Amend Rule 2202 by replacing the paragraph beginning "A player CAN" with
the following: "A player CAN, without objection, ratify a specified
public document."""")
        }
    }

    voting {
        votes(PSS) {
            FOR on all
        }

        votes(ATMunn) {
            FOR on 8490
            FOR on 8491
            FOR on 8492
        }

        votes(Jason) {
            FOR on 8490
            AGAINST on 8491
            FOR on 8492
        }

        votes(Murphy) {
            FOR on 8490
            FOR on 8491
            FOR on 8492
        }

        votes(Trigon) {
            FOR on all
        }

        votes(Falsifian) {
            AGAINST on 8490
            AGAINST on 8491
            endorse(Jason) on 8492
        }

        votes(Gaelan) {
            endorse(Jason) on 8490
            endorse(ATMunn) on 8491
            endorse(Jason) on 8492
        }
    }
}
