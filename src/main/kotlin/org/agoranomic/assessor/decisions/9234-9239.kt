package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment9234to9239() = assessment {
    name("9234-9239")
    quorum(6)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            complexityBonuses {
                maxBonus(3)

                "Absurdor"(1) heldBy juan
                "ADoP"(2) heldBy Murphy
                "Arbitor"(2) heldBy Kate
                "Archivist"(1) heldBy kiako
                "Assessor"(3) heldBy Janet
                "Collector"(2) heldBy Mischief
                "Distributor"(0) heldBy omd
                "Herald"(2) heldBy snail
                "Illuminator"(1) heldBy Mischief
                "Notary"(2) heldBy Mischief
                "Prime Minister"(0) heldBy Mischief
                "Promotor"(3) heldBy Cosmo
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy Kate
                "Spendor"(1) heldBy Murphy
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy kiako
            }
        }
    }

    proposals(v4) {
        proposal(9234) {
            title("Prix Fixe")
            ai("1")
            author(Mischief)
            ordinary()

            text(
                """
[The variable cost nature of this fee means that from time to time, one
failed purchase causes subsequent purchases to fail. To simplify things,
this switches it to a flat fee since a player's Spendie holdings already
limit how many times e can do this. It is calibrated so that the three
purchases per month afforded by 20 Spendies have the same cost as today.]
Amend rule 2659 (Stamps) by replacing:

       Any player CAN pay a fee of 5 + (X) Spendies to transfer a
       specified stamp from the L&FD to emself. X is equal to the number
       of times e has already done so in the current month.

with:

       Any player CAN pay a fee of 6 Spendies to transfer a specified
       stamp from the L&FD to emself."""
            )
        }

        proposal(9235) {
            title("Agoricultural Enabling Act")
            ai("1")
            author(Murphy)
            ordinary()

            text(
                """
Amend the rule titled "The Land Managor" by replacing "Land Manager"
with "Land Managor".Amend the the rule titled "Genetic Modification" by
replacing the first
paragraph with:

       Once per Crop Season, a player CAN pay a fee of 500 Pyrite to
       create a new type of Crop, specifying its name. The Land Managor
       CAN once by announcement, and SHALL in a timely fashion, randomly
       select its Crop Season, Seed Cost (50 to 200), Growth Duration (3
       to 24), and Sell Price (100 to 400). Rules to the contrary
       notwithstanding, it CANNOT be planted before this announcement."""
            )
        }

        proposal(9236) {
            title("Landlocked")
            ai("1")
            author(Murphy)
            ordinary()

            text(
                """
Create a rule titled "Hectares" with this text:

       Hectare is a type of fixed asset, tracked by the Land Managor.

       A player CAN pay a fee of 500 Pyrite to gain 1 Hectare.

Amend Rule 2499 (Welcome Packages) by adding this item to the list:

       * 16 Hectares.

Each player gains 16 Hectares.

Amend the rule titled "The Growth Cycle" by replacing the first
paragraph with:

       A player CAN plant an in-season Crop by paying a fee in Pyrite
       equal to its Seed Cost, provided that eir number of Hectares is
       greater than the number of Crops e planted earlier in the current
       Crop Season and has not yet harvested."""
            )
        }

        proposal(9237) {
            title("Pyrite Fungibility")
            ai("1")
            author(oliver)
            coauthors(Mischief)
            ordinary()

            text(
                """
If Proposal 9230 (Agoriculture) has not been adopted, this proposal has
no effect.

Amend the rule titled "Pyrite" by replacing the text:

     Pyrite is a type of fixed asset

with:

     Pyrite is a type of fixed fungible asset

[Comment: This is presumably the intended use of Pyrite as a currency.
Also, it saves the Land Managor the work of tracking each Pyrite
individually, especially since there can be thousands of them.]"""
            )
        }

        proposal(9238) {
            title("Make currency current again")
            ai("3")
            author(Murphy)
            coauthors(Janet, Mischief)
            democratic()

            text(
                """
Amend Rule 2578 (Fungibility) by replacing this text:

       A fungible asset is one where

with this text:

       A fungible asset (syn. "currency") is an asset where

Amend Rule 2555 (Blots) by replacing "fungible asset" with "currency".

Amend Rule 2579 (Fee-based Actions) by replacing "fungible asset" with
"currency".

Amend Rule 2690 (Spendies) by replacing "fungible liquid asset" with
"currency".

[Liquid is already the default, per Rule 2577.]

Amend Rule 2700 (Candles) by replacing "Candles are fixed fungible
assets" with "Candles are a fixed currency".

Amend the rule titled "Pyrite" by replacing the first paragraph with:

       Pyrite is a type of fixed currency, tracked by the Land Managor.

Amend the rule titled "Hectares" by replacing "fixed asset" with
"fixed currency".

[Non-currency assets: Promises, only fungible if creator and text are
  also identical; Stamps, only fungible if type is also identical; the
  Veblen.]"""
            )
        }

        proposal(9239) {
            title("Gray timing")
            ai("3")
            author(Murphy)
            democratic()

            text(
                """
Amend Rule 2438 (Ribbons) by replacing this text:      Gray (A): Once
per month the Tailor CAN, by announcement, cause a
       specified player to earn a Gray Ribbon. E is ENCOURAGED to do so
       in the same message in which e publishes eir monthly report.

with this text:

       Gray (A): Once per month the Tailor CAN, by announcement, cause a
       specified player to earn a Gray Ribbon. E is ENCOURAGED to do so
       before publishing eir monthly report.

["In the same message" doesn't play well with my recordkeeping software,
  and I don't think anyone has mentioned this clause any time recently.]"""
            )
        }
    }

    voting {
        votes(Mischief) {
            FOR on 9234
            AGAINST on 9235
            AGAINST on 9236
            AGAINST on 9237
            FOR on 9238
            endorse(Murphy) on 9239 comment "${Murphy.name} is the Tailor"
        }

        votes(Cosmo) {
            FOR on 9234
            // TODO: resolve conditional vote on 9235: FOR if 9230 resolved as ADOPTED, else AGAINST.
            // TODO: resolve conditional vote on 9236: FOR if 9230 resolved as ADOPTED, else AGAINST.
            // TODO: resolve conditional vote on 9237: FOR if 9230 resolved as ADOPTED, else AGAINST.
            FOR on 9238
            endorse(Murphy) on 9239 comment "${Murphy.name} is the Tailor"
        }

        votes(Janet) {
            FOR on 9234
            AGAINST on 9235
            AGAINST on 9236
            AGAINST on 9237
            PRESENT on 9238
            FOR on 9239
        }

        votes(Murphy) {
            FOR on 9234
            // TODO: resolve conditional vote on 9235: FOR if 9230 resolved as ADOPTED, else AGAINST.
            // TODO: resolve conditional vote on 9236: FOR if 9230 resolved as ADOPTED, else AGAINST.
            // TODO: resolve conditional vote on 9237: FOR if 9230 resolved as ADOPTED, else AGAINST.
            FOR on 9238
            FOR on 9239
        }

        votes(Trigon) {
            PRESENT on 9234
            AGAINST on 9235
            AGAINST on 9236
            AGAINST on 9237
            FOR on 9238
            FOR on 9239
        }

        votes(juniper) {
            AGAINST on 9234
            AGAINST on 9235
            AGAINST on 9236
            FOR on 9237
            FOR on 9238
            FOR on 9239
        }

        votes(BuringBeef) {
            // TODO: resolve conditional vote on 9234-9239: endorse Cosmo if Cosmo has not since changed vote, else PRESENT
        }
    }
}