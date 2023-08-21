package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.ministries.Office_2020_06_30.*
import org.agoranomic.assessor.dsl.ministries.ministries_2020_08_02
import org.agoranomic.assessor.dsl.ministries.officeMapOf
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.addToHolder
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.endorseOrElse
import org.agoranomic.assessor.lib.proposal.MinistryV1.Economy
import org.agoranomic.assessor.lib.proposal.MinistryV1.Participation
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8504to8506() = assessment {
    name("8504-8506")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-October/014298.html")
    quorum(5)

    val offices = officeMapOf(
        ADoP to Murphy,
        Arbitor to G,
        Assessor to Janet,
        Coopor to Janet,
        Distributor to omd,
        Herald to PSS,
        Notary to ATMunn,
        PrimeMinister to ATMunn,
        Promotor to Aspen,
        Referee to PSS,
        Registrar to Falsifian,
        Rulekeepor to Janet,
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
        proposal(8504) {
            title("easier bargains")
            ai("1.0")
            author(G)
            chamber(Economy)
            sponsored()

            text("""
Amend Rule 2627 (The General Store) by replacing:
      a list of 6 or more rules-defined card types
with:
      a list of 4 or more rules-defined card types with at least
      two of the types being different

[Commentary: make bargains easier, but ensure they're not identical
(double-rewards) for base trades.]""")
        }

        proposal(8505) {
            title("Card clarifications")
            ai("1.0")
            author(Janet)
            chamber(Economy)
            sponsored()

            text("""
Amend Rule 2624 as follows:

  - Replace "The type of card with the fewest existing instances" with
    "The single type of card with the fewest existing instances (if any)"

  - Replace all instances of "the card's associated ministry" with "a
    ministry associated with the card".

[Right now the text assumes that each type of card has only a single
associated ministry, but this is not true because of the recent change
for the Ministry of Economy. There's also ambiguity with what happens if
multiple types of card are tied for fewest instances.]""")
        }

        proposal(8506) {
            title("Happy Belated Birthday v2")
            ai("1.0")
            author(ATMunn)
            coauthors(G)
            chamber(Participation)
            sponsored()

            text("""
Amend Rule 2585, "Birthday Gifts", by adding the following paragraph
before the sentence "Players are ENCOURAGED to announce their Agoran
Birthdays.":

   During the 7 days following the end of a player's Agoran Birthday, if
   nobody granted em any coins via this rule, any player CAN once grant
   em 2 coins by announcement, wishing em a Happy Belated Birthday.

If this proposal was resolved later than September 28, 2020, then ATMunn
is granted 2 coins for every vote on this proposal that evaluated to
FOR.""")
        }
    }

    voting {
        votes(Falsifian) {
            FOR on 8504
            FOR on 8505
            AGAINST on 8506
        }

        votes(Kate) {
            endorse(Falsifian) on all
        }

        votes(Janet) {
            FOR on 8504
            FOR on 8505
            endorse(Falsifian) on 8506
        }

        votes(BaronVV) {
            endorse(Janet) on all
        }

        votes(nix) {
            PRESENT on 8504
            FOR on 8505
            PRESENT on 8506
        }

        votes(Aspen) {
            endorseOrElse(G, FOR) on 8504
            endorseOrElse(Janet, FOR) on 8505
            AGAINST on 8506
        }

        votes(Telna) {
            endorse(Aspen) on all
        }

        votes(ATMunn) {
            (8504..8506).forEach { FOR on it }
        }
    }
}
