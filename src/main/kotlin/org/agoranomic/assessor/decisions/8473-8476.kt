package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.ministries.Office_2020_06_30.*
import org.agoranomic.assessor.dsl.ministries.ministries_2020_06_30
import org.agoranomic.assessor.dsl.ministries.officeMapOf
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.addToHolder
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.lib.proposal.MinistryV1.Economy
import org.agoranomic.assessor.lib.proposal.MinistryV1.Participation
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8473to8476() = assessment {
    name("8473-8476")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-July/013985.html")
    quorum(9)

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
        Speaker to G,
        Tailor to PSS,
        Treasuror to Trigon,
        Webmastor to nix
    )

    strengths {
        default(3)
        min(0)
        max(15)

        blotPenalty(RLee, 80 / 3)

        addToHolder(offices, Speaker, 1)
        ministries_2020_06_30(offices, allProposals)
    }

    proposals(v2) {
        proposal(8473) {
            title("Plain Old Bribery")
            ai("1.0")
            author(Jason)
            coauthors(G)
            chamber(Participation)
            sponsored()

            text(
                """
Every player who cast a valid non-withdrawn unconditional ballot FOR
this proposal earns a Black Ribbon.

[Note to the Tailor: the definition of Black Ribbons in R2438 means
that, immediately after this proposal is adopted, people will have the
Black Ribbons without needing to separately claim them.]"""
            )
        }

        proposal(8474) {
            title("Agora the karma bank")
            ai("1.0")
            author(G)
            coauthors(omd)
            chamber(Participation)
            sponsored()

            text(
                """
[First, a partial reset.  People with negative karma are mostly zombies
or people with fairly old sins; worth a full forgiveness/reset. People
with positive karma have generally done good things more recently - a
partial reset for them, akin to the just-passed July releveling.  Agora
is balanced one last time so we can start counting total positivity or
negativity from here on out.]

Each person with positive karma has eir karma set to half its current
value, rounded up.

Each person with negative karma has eir karma set to 0.

Agora's karma is then set such that the sum of all Karma values in the
game equals 0.


Amend Rule 2510 (Such is Karma) by deleting:

      4. Not result in Agora's karma moving farther away from 0.

and by replacing its last paragraph with:

      At the beginning of each quarter, the Karma of every person is
      halved (rounding towards 0).

[It's still an exchange of karma, but you can take freely from Agora.
Everybody's karma decays every quarter, but Agora's karma isn't reset
to zero-sum, therefore Agoran's karma is an inverse measure of our
overall positivity/negativity over time.]"""
            )
        }

        proposal(8475) {
            title("Saving Sponsorship")
            ai("1.0")
            author(Aspen)
            chamber(Participation)

            text(
                """
Each of the following proposals is hereby rendered sponsored:
- "Plain Old Bribery", by Jason
- "Agora the karma bank", by G."""
            )
        }

        proposal(8476) {
            title("Contract charities")
            ai("1.0")
            author(ATMunn)
            coauthors(G, Falsifian, PSS)
            chamber(Economy)
            sponsored()

            text(
                """
[Comment: The original version was by G., then resubmitted by Falsifian,
then again by me. :) P.S.S. also suggested a minor change, so I included
em as a coauthor as well.]

Enact the following rule, Charities:

  Donation Level is a natural switch for contracts, tracked by the
  Notary, with a default of 0 and a maximum of 25.  A contract with
  nonzero donation level is called a Charity.

  The Notary CAN flip a contract's donation level to a non-default
  value with 3 Agoran consent.  This SHOULD only be done if the
  contract's provisions ensure that its funds received from Agora
  will be used solely for the betterment of Agora.  Any player CAN
  flip a contract's donation level to 0 with Agoran consent.

  Whenever a payday occurs, half of each charity's coin holdings
  (rounded down) are destroyed, and then each charity earns a
  number of coins equal to its donation level."""
            )
        }
    }

    voting {
        votes(Jason) {
            FOR on 8473
            FOR on 8474
            FOR on 8475
            FOR on 8476
        }

        votes(Aspen) {
            FOR on 8473
            FOR on 8474
            FOR on 8475
            FOR on 8476
        }

        votes(Trigon) {
            FOR on 8473
            FOR on 8474
            FOR on 8475
            FOR on 8476
        }

        votes(ATMunn) {
            FOR on 8473
            FOR on 8474
            FOR on 8475
            FOR on 8476
        }

        votes(PSS) {
            FOR on 8473
            AGAINST on 8474
            FOR on 8475
            FOR on 8476
        }

        votes(G) {
            FOR on all
        }

        votes(twg) {
            FOR on all
        }

        votes(omd) {
            AGAINST on 8473
            FOR on 8474
            PRESENT on 8475
            PRESENT on 8476
        }

        votes(Falsifian) {
            FOR on 8473
            FOR on 8474
            FOR on 8475
            FOR on 8476
        }

        votes(RLee) {
            AGAINST on 8473
            AGAINST on 8474
            FOR on 8475
            FOR on 8476
        }

        votes(nix) {
            FOR on 8473
            AGAINST on 8474
            FOR on 8475
            PRESENT on 8476
        }

        votes(Murphy) {
            FOR on 8473
            FOR on 8474
            PRESENT on 8475
            FOR on 8476
        }
    }
}
