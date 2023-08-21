package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.ministries.Office_2020_10_28.*
import org.agoranomic.assessor.dsl.ministries.ministries_2020_11_07
import org.agoranomic.assessor.dsl.ministries.officeMapOf
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.addToHolder
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.lib.proposal.MinistryV2.Economy
import org.agoranomic.assessor.lib.vote.VoteKind.FOR

@UseAssessment
fun assessment8523() = assessment {
    name("8523")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-November/014417.html")
    quorum(7)

    val offices = officeMapOf(
        ADoP to Murphy,
        Arbitor to G,
        Assessor to Janet,
        Coopor to G,
        Distributor to omd,
        Herald to PSS,
        Ministor to nix,
        Notary to ATMunn,
        PrimeMinister to ATMunn,
        Promotor to Aspen,
        Referee to PSS,
        Registrar to Falsifian,
        Rulekeepor to Janet,
        Speaker to G,
        Tailor to PSS,
        Treasuror to Trigon,
        Webmastor to nix,
    )

    strengths {
        default(3)
        min(0)
        max(15)

        blotPenalty(RLee, 81 / 3)

        addToHolder(offices, Speaker, 1)
        ministries_2020_11_07(offices, allProposals)
    }

    proposals(v3) {
        proposal(8523) {
            title("Emergency Economy Unbreaking")
            ai("2.0")
            author(Aspen)
            coauthors(nix, Janet)
            chamber(Economy)
            sponsored()

            text("""
[Currently, the concentration stone plus the economy focus would
 create over 1000 coins. That represents inflation of more than 10%.
 Obviously, that wasn't what we had in mind. The plan is to delay
 termination of the auction until this is resolved, so people should
 be able to adjust their bids.]

Amend the rule entitled "The Stones" by replacing:
  - Concentration Stone (weekly, 60%)
with:
  - Concentration Stone (monthly, 60%)
""")
        }
    }

    voting {
        votes(ShyOwl) {
            FOR on 8523
        }

        votes(ATMunn) {
            FOR on 8523
        }

        votes(lucidiot) {
            FOR on 8523
        }

        votes(Janet) {
            FOR on 8523
        }

        votes(BaronVV) {
            endorse(Janet) on 8523
        }

        votes(Falsifian) {
            FOR on 8523
        }

        votes(Kate) {
            endorse(Falsifian) on 8523
        }

        votes(Murphy) {
            FOR on 8523
        }
    }
}
