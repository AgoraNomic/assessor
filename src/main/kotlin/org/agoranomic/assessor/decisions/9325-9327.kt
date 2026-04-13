package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.endorseOfficer
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment9325to9327() = assessment {
    name("9325-9327")
    quorum(4)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            complexityBonuses {
                maxBonus(3)

                "Absurdor"(1) heldBy juan
                "ADoP"(2) heldBy Murphy
                "Arbitor"(2) heldBy null
                "Archivist"(1) heldBy kiako
                "Assessor"(3) heldBy Janet
                "Collar"(1) heldBy Mischief
                "Collector"(2) heldBy Mischief
                "Distributor"(0) heldBy omd
                "Executor"(1) heldBy Mischief
                "Herald"(2) heldBy snail
                "Illuminator"(1) heldBy Cosmo
                "Land Managor"(1) heldBy Murphy
                "Notary"(2) heldBy Nilrem
                "Numerator"(1) heldBy Trigon
                "Prime Minister"(0) heldBy ais523
                "Promotor"(3) heldBy Cosmo
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy Mischief
                "Spendor"(1) heldBy Murphy
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy kiako
            }
        }
    }


    proposals(v4) {
        proposal(9325) {
            title("Campaign Promises")
            ai("2.0")
            author(Galle)
            ordinary()

            text(
                """
Amend the first paragraph of Rule 2630, "The Administrative State", to
read as follows:
---
Each officer CAN, with 1.5 Agoran consent, enact, amend, or repeal eir
own office's Administrative Regulations. Administrative Regulations have
the following properties:
---

Enact a new power 2 rule, entitled "Platforms", with the following text:
---
A candidate in an election CAN, with notice, designate a public document
as eir Platform for that election. A Platform SHOULD specify changes to
the Administrative Regulations for the office being elected.

When a candidate is elected to an office, if e has a Platform for that
election, any changes to that office's Administrative Regulations
specified by eir most recent Platform take effect.
---"""
            )
        }

        proposal(9326) {
            title("Money doesn't grow on trees")
            ai("1.0")
            author(Murphy)
            ordinary()

            text(
                """
Amend Rule 2710 (Genetic Modification) by appending this text to the
paragraph containing "create a new type of Crop":

       The Land Managor CAN by announcement rename a type of Crop,
       specifying its new name, but SHOULD NOT do so unless its current
       name is reasonably likely to cause confusion and delay.

and appending this text to the paragraph containing "remove a type of
out-of-season Crop":

       This fee is reduced to 1 Pyrite if the type's Sell Price is
       less than its Seed Cost."""
            )
        }

        proposal(9327) {
            title(null)
            ai("2.0")
            author(Nilrem)
            ordinary()

            text(
                """
Amend Rule 2608 (The Notary) by replacing this text:

       1. every pledge, along with its title, creator, time window, time
          of creation, and time of expiry;

With this text:

       1. every pledge, along with its title, creator, time window, time
          of creation, time of expiry, and infraction class;

According to rule 2450 (Pledges), breaking a pledge can be an infraction
of varying class depending on the value stated while making the pledge.
It seems silly to leave this information out of the report"""
            )
        }
    }

    voting {
        votes(Galle) {
            FOR on 9325
            FOR on 9326
            FOR on 9327
        }

        votes(Janet) {
            AGAINST on 9325
            PRESENT on 9326
            PRESENT on 9327
        }

        votes(Nilrem) {
            PRESENT on 9325
            AGAINST on 9326
            FOR on 9327
        }

        votes(Forest) {
            // No votes.
            // See https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-business/2026-April/055411.html
        }

        votes(Mischief) {
            endorseOfficer("Rulekeepor", Janet) on 9325
            endorseOfficer("Land Managor", Murphy) on 9326
            endorseOfficer("Notary", Nilrem) on 9327
        }

        votes(Murphy) {
            AGAINST on 9325
            FOR on 9326
            endorseOfficer("Notary", Nilrem) on 9327
        }
    }
}
