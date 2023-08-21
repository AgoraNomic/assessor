package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.ministries.Office_2020_10_28.*
import org.agoranomic.assessor.dsl.ministries.ministries_2020_11_07
import org.agoranomic.assessor.dsl.ministries.officeMapOf
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.addToHolder
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.lib.proposal.MinistryV2.Compliance
import org.agoranomic.assessor.lib.proposal.MinistryV2.Economy
import org.agoranomic.assessor.lib.vote.VoteKind.FOR
import org.agoranomic.assessor.lib.vote.VoteKind.PRESENT

@UseAssessment
fun assessment8524to8525() = assessment {
    name("8524-8525")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-December/014439.html")
    quorum(9)

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
        // Stonemason to Jason, // unneeded because I'm lazy and it has no ministries
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
        proposal(8524) {
            title("Agora's Stones Are Immune")
            ai("2.0")
            author(nix)
            chamber(Economy)
            sponsored()

            text("""
[Currently, you can steal from Agora with the soul stone, which seems a
bit goofy and also creates problems with auctions. Also, I cleaned up
the verbiage just a bit.]

Amend "Collecting Stones" by replacing

  A stone is immune if there has been no collection notice after it was
  most recently granted immunity (if ever), as defined by other rules.

with:

  A stone is immune if it has been granted immunity, as defined by other
  rules, since the last collection notice or if it is currently owned by
  Agora.

and by replacing:

  A collection notice includes, for every non-immune stone not belonging
  to Agora,

with:

  A collection notice includes, for every non-immune stone,""")
        }

        proposal(8525) {
            title("Expungement for R. Lee")
            ai("1.7")
            author(Aspen)
            chamber(Compliance)
            sponsored()

            text("""
[As of right now, this would lower eir blots to 9, just enough to set eir
vote to 0 in the absence of other factors. I phrased it like this
both so e can begin paying it down and so that any blots e earns now
still count against em.]

Expunge 72 of R. Lee's blots.""")
        }
    }

    voting {
        votes(ATMunn) {
            FOR on all
        }

        votes(Murphy) {
            FOR on 8524
            FOR on 8525
        }

        votes(Janet) {
            FOR on 8524
            PRESENT on 8525
        }

        votes(lucidiot) {
            FOR on all
        }

        votes(Aspen) {
            PRESENT on 8524
            FOR on 8525
        }

        votes(nix) {
            FOR on 8524
            PRESENT on 8525
        }

        votes(Falsifian) {
            FOR on 8524
            FOR on 8525 comment legacyConditionalComment("R. Lee has at least 72 blots")
        }

        votes(Kate) {
            endorse(Falsifian) on all
        }

        votes(Gaelan) {
            PRESENT on 8524
            FOR on 8525
        }
    }
}
