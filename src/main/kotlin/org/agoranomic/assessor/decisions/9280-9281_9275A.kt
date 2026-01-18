package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals

@UseAssessment
fun assessment9280to9281_9275A() = assessment {
    name("9280-9281, 9275A")
    quorum(3)

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
                "Collar"(1) heldBy Mischief
                "Collector"(2) heldBy Mischief
                "Distributor"(0) heldBy omd
                "Herald"(2) heldBy snail
                "Illuminator"(1) heldBy null
                "Land Managor"(1) heldBy Murphy
                "Notary"(2) heldBy null
                "Numerator"(1) heldBy Trigon
                "Prime Minister"(0) heldBy null
                "Promotor"(3) heldBy Cosmo
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy kiako
                "Spendor"(1) heldBy Murphy
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy kiako
            }
        }
    }

    proposals(v4) {
        proposal(9275) {
            title("Determinate determinacy")
            ai("3.0")
            author(Janet)
            democratic()

            text(
                """
Amend Rule 2518 ("Determinacy") by replacing the text "If a value CANNOT
be reasonably determined" with the text "If a value cannot be reasonably
determined".

[We almost certainly mean "cannot" here in the natural language sense:
determining something (in this sense) is not a regulated action; it
requires thought and potentially a judicial process.]"""
            )
        }

        proposal(9280) {
            title("Rounded integer switches")
            ai("3.0")
            author(Murphy)
            coauthors(Forest)
            democratic()

            text(
                """
Amend Rule 2162 (Switches) by replacing this text:

       If an instance of a switch would otherwise fail to have a possible
       value, it comes to have its default value.

with this text:

       If an instance of a switch would otherwise fail to have a possible
       value, and no other method defined by this rule or its backing
       document would assign it a possible value, then it comes to have
       its default value.

and by inserting this paragraph after the
paragraph starting with "A boolean switch":

       A rounded switch is a switch defined as such by its backing
       document. Each type of rounded switch has a granularity (a real
       number, equal to 1 unless otherwise specified by its backing
       document). If an instance of a rounded switch would otherwise
       have a real but impossible value (V), then it comes to have a
       value of the multiple of its granularity closest to V (breaking
       ties toward zero, unless its backing document says otherwise)."""
            )
        }

        proposal(9281) {
            title("Switchgrass")
            ai("1.0")
            author(Murphy)
            coauthors(Forest)
            ordinary()

            text(
                """
Amend Rule 2708 (Crops) to read:

       Creating and destroying types of Crop is secured.

       Growing Season, Seed Cost, Growth Duration, and Sell Price are
       Crop type switches, tracked by the Land Managor, with these
       values:

         * Growing Season - all Crop Seasons
         * Seed Cost - integers from 50 to 200 inclusive, rounded
         * Growth Duration - integers from 3 to 24 inclusive, rounded
         * Sell Price - integers from 100 to 400, rounded

       Rules to the contrary notwithstanding, a Crop type CANNOT be
       planted while its Seed Cost is null, and CANNOT be harvested while
       its Growth Duration or Sell Price is null.

       When rounding Seed Cost or Growth Duration, ties are broken toward
       the larger value.

       An in-season Crop is one whose Growth Season is in progress. All
       others are out-of-season.

Set each Crop type's Growth Season equal to its Crop Season immediately
before this proposal took effect.

Amend Rule 2710 (Genetic Modification) to read:

       Once per Crop Season, a player CAN pay a fee of 500 Pyrite to
       create a new type of Crop, specifying its name. The Land Managor
       CAN once by announcement, and SHALL in a timely fashion, set its
       Growth Season, Seed Cost, Growth Duration, and Sell Price to
       randomly selected valid values.

       Once per Crop Season, a player CAN pay a fee of 750 Pyrite to
       alter a type of out-of-season Crop's Seed Cost, Growth Duration,
       or Sell Price by up to 25% in either direction.

       Once per Crop Season, a player CAN pay a fee of 1000 Pyrite to
       remove a type of out-of-season Crop.

       Once per Crop Season, the Land Managor CAN and SHALL by
       announcement randomly select a type of Crop that was in-season
       during the previous season, select a random attribute (Seed Cost
       or Sell Price), and set that attribute to a randomly selected
       valid value. If there is no such type to select, then e SHALL
       instead announce that fact."""
            )
        }
    }

    voting {
    }
}
