package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.ministries.Office_2020_12_31.*
import org.agoranomic.assessor.dsl.ministries.ministries_2020_12_31
import org.agoranomic.assessor.dsl.ministries.officeMapOf
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.addToHolder
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.lib.proposal.MinistryV2.Compliance
import org.agoranomic.assessor.lib.vote.VoteKind.AGAINST
import org.agoranomic.assessor.lib.vote.VoteKind.FOR

@UseAssessment
fun assessment8527to8529() = assessment {
    name("8527-8529")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2021-January/014545.html")
    quorum(5)

    val offices = officeMapOf(
        ADoP to Murphy,
        Arbitor to G,
        Assessor to Jason,
        Distributor to omd,
        Herald to nix,
        Ministor to nix,
        Notary to ATMunn,
        PrimeMinister to ATMunn,
        Promotor to Aspen,
        Referee to JTAC,
        Registrar to Falsifian,
        Rulekeepor to Jason,
        Speaker to G,
        Stonemason to Jason,
        Tailor to null,
        Treasuror to Trigon,
        Webmastor to nix,
    )

    strengths {
        min(0)
        max(15)
        default(3)

        blotPenalty(RLee, 9 / 3)
        blotPenalty(Gaelan, 3 / 3)

        addToHolder(offices, Speaker, 1)
        ministries_2020_12_31(offices, allProposals)
    }

    proposals(v3) {
        proposal(8527) {
            title("Specified Crime not Rule")
            ai("1.7")
            author(PSS)
            coauthors(nix, Aspen)
            chamber(Compliance)
            sponsored()

            text("""
Amend Rule 2478, "Vigilante Justice" by replacing the first paragraph
with the following:
  A player CAN by announcement Point eir Finger at a player (the
  perp); the announcement is INEFFECTIVE if it does not explicitly
  name the perp, cite a specific rule or named crime, and specify an
  alleged violation of that rule or commission of that crime by that
  person.

[ This will allow someone to use the name of a crime without specifying
which rule defines it. This also addresses some concerns raised by nix
regarding unnecessary or archaic provisions.]""")
        }

        proposal(8528) {
            title("Gaining Assets")
            ai("3.0")
            author(Aspen)
            coauthors(Gaelan)
            democratic()
            sponsored()

            text("""
[There are reasonable complaints that the word "earn" is confusing,
because it conveys the idea of becoming entitled to an asset, rather than
the idea of coming into possession of an asset. It also clashes with the
terminology we use for ribbons. This proposal fixes the problems
by changing the word to "gain", to match "loose".]

Amend Rule 2577, "Asset Actions", by replacing:

  For an entity to earn an asset is for that asset to be created in
  that entity's possession.

with:

  For an entity to gain (historical syn. earn) an asset is for that asset to be
  created in that entity's possession.


Amend Rule 2499, "Welcome Packages", by replacing "earns" with "gains".
Amend Rule 2559, "Paydays", by replacing "earns" with "gains".
Amend Rule 2620, "Cards & Sets", by replacing "earn" with "gain".
Amend Rule 2623, "Popular Proposal Proposer Privilege", by replacing "earn"
with "gain".
Amend Rule 2627, "The General Store", by replacing "earns" with
"gains" and replacing "earn" with "gain".
Amend Rule 2631, "Charities", by replacing "earns" with "gains".
Amend Rule 2645, "The Stones", by replacing each instance of
"earns" with "gains".""")
        }

        proposal(8529) {
            title("Not-so-subtle nudge")
            ai("3.0")
            author(Gaelan)
            democratic()
            sponsored()

            text("""
Repeal rule 2633, "Rulebending."""")
        }
    }

    voting {
        votes(Jason) {
            FOR on 8527
            FOR on 8528
            AGAINST on 8529
        }

        votes(Aspen) {
            FOR on 8527
            FOR on 8528
        }

        votes(nix) {
            FOR on 8527
            FOR on 8528
            FOR on 8529 comment legacyConditionalComment("voting ended on the 10th, an even number")
            // TODO: resolve conditional vote on 8529: FOR if day of month when voting ends is even, else AGAINST
        }

        votes(Gaelan) {
            FOR on 8527
            FOR on 8528
        }

        votes(Trigon) {
            FOR on 8527
            FOR on 8528
        }

        votes(JTAC) {
            FOR on 8527
            FOR on 8528
        }

        votes(lucidiot) {
            FOR on 8527
            FOR on 8528
        }

        votes(Falsifian) {
            FOR on 8527
            FOR on 8528
        }

        votes(ATMunn) {
            FOR on 8527
            FOR on 8528
        }

        votes(Murphy) {
            FOR on 8527
            FOR on 8528
        }

        votes(G) {
            FOR on 8527
            FOR on 8528
            AGAINST on 8529
        }
    }
}
