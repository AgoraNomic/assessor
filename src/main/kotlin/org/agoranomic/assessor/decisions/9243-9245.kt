package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment9243to9245() = assessment {
    name("9243-9245")
    quorum(5)

    proposals(v4) {
        proposal(9243) {
            title("Agoriculture v1.1")
            ai("1")
            author(Murphy)
            coauthors(Mischief, ais523, oliver, Janet)
            ordinary()

            text(
                """
Create a rule titled "Hectares" with this text:

        Hectare is a type of fixed fungible asset, tracked by the Land
Managor.

        A player CAN pay a fee of 500 Pyrite to gain 1 Hectare.

Amend Rule 2499 (Welcome Packages) by adding this item to the list:

        * 16 Hectares.

Each player gains 16 Hectares.

Create a rule titled "Crop Seasons" with this text:

       The Crop Season is determined by the current Agoran month:

         * Spring - January, May, September
         * Summer - February, June, October
         * Autumn - March, July, November
         * Winter - April, August, December

Create a rule titled "The Land Managor" with this text:

       The Land Managor is an office.

       The Land Managor's report includes a list of types of Crops and
       their attributes, and a list of Crops planted and harvested during
       the current Crop Season.

Create a rule titled "Pyrite" with this text:

       Pyrite is a type of fixed fungible asset, tracked by the Land
Managor.

       A player CAN pay a fee of 1 Spendie to gain 100 Pyrite.

       A player CAN pay a fee of 200 Pyrite to gain 1 Spendie.

Create a rule titled "Crops" with this text:

       Creating and destroying types of Crop is secured.

       Each type of Crop has an associated Crop Season, Seed Cost, Growth
       Duration, and Sell Price. Actions involving any of these
       attributes use the attribute values for the type of Crop involved
       in that action.

       An in-season Crop is one whose Crop Season is in progress. All
       others are out-of-season.

Create a rule titled "The Growth Cycle" with this text:

       A player CAN plant an in-season Crop by paying a fee in Pyrite
       equal to its Seed Cost, provided that eir number of Hectares is
       greater than the number of Crops e planted earlier in the current
       Crop Season and has not yet harvested.

       Once per Crop that a player planted earlier in the current Crop
       Season and at least <Growth Duration> days ago, e CAN harvest it
       by announcement, gaining Pyrite equal to its Sell Price.

       At the end of each Crop Season, all unharvested Crops are lost.

Create a rule titled "Genetic Modification" with this text:

       Once per Crop Season, a player CAN pay a fee of 500 Pyrite to
       create a new type of Crop, specifying its name. The Land Managor
       CAN once by announcement, and SHALL in a timely fashion, randomly
       select its Crop Season, Seed Cost (50 to 200), Growth Duration (3
       to 24), and Sell Price (100 to 400). Rules to the contrary
       notwithstanding, it CANNOT be planted before this announcement.

       Once per Crop Season, a player CAN pay a fee of 750 Pyrite to
       alter a type of out-of-season Crop's Seed Cost, Growth Duration,
       or Sell Price by up to 25% in either direction, provided that they
       remain within the random ranges for new types of Crop.

       Once per Crop Season, a player CAN pay a fee of 1000 Pyrite to
       remove a type of out-of-season Crop.

Create the following types of Crop:

          * Pea         (CS Spring, SC 100, GD 14, SP 184)
          * Shallot     (CS Spring, SC  94, GD  9, SP 169)
          * Bell Pepper (CS Summer, SC 112, GD 12, SP 217)
          * Cabbage     (CS Summer, SC 146, GD 13, SP 273)
          * Chard       (CS Autumn, SC 200, GD 10, SP 349)
          * Spinach     (CS Autumn, SC 165, GD  7, SP 335)

If Rule 2578 (Fungibility) defines "currency", then amend the rules
titled "Hectares" and "Pyrite" (in that order) by replacing each
instance of "fungible asset" with "currency".

[Updated based on Proposals 9235-38. Also shifted Crop Seasons to align
  Spring with the start of the Gregorian year, and give everyone plenty
  of time to participate in the first Spring after adoption.]"""
            )
        }

        proposal(9244) {
            title("Concision")
            ai("3")
            author(Mischief)
            coauthors(Janet, ais523)
            democratic()

            text(
                """
[Proposals can't all be epochal rewrites like "Agoriculture"

As a reminder, even though rule 2614 is power 3.1, this proposal only
needs to be power 3 to satisfy rule 2140.]

Amend rule 2614 (Eclipse Light) by replacing:

       If there is an Emergency Regulation that has existed for at least
       a month and the Prime Minister has not Extended the Emergency in
       the past month, any player CAN, with 7 days notice, cause this
       rule to repeal all Emergency Regulations.

with:

       If there is an Emergency Regulation that has existed for at least
       a month and the Prime Minister has not Extended the Emergency in
       the past month, any player CAN, with 7 days notice, repeal all
       Emergency Regulations."""
            )
        }

        proposal(9245) {
            title("Reduce automatic sortition events")
            ai("2")
            author(Murphy)
            ordinary()

            text(
                """
Amend Rule 2691 (Sortition Procedure) by replacing this text:

       Seven days after a sortition is initiated, its lots period ends.
       The ADoP CAN by announcement, and SHALL in a timely fashion after
       a lots period ends, randomly select one of the options for that
       office. When e does so, that player becomes the officeholder for
       that office, then the sortition ends.

       If a sortition's lots period has ended, and the sortition has no
       valid options, then it immediately ends with no selection, and any
       duty to select an option with respect to it is discharged.

with this text:

       Seven days after a sortition is initiated, its lots period ends.

         * If it has two or more valid options, then the ADoP CAN by
           announcement, and SHALL in a timely fashion after its lots
           period ends, randomly select one of those options.

         * If it has exactly one valid option, then any player CAN by
           announcement select that option.

         * If it has no valid options, then any player CAN by announcement
           declare the selection ended with no selection.

       When a player is selected in a sortition as described above, e is
       installed into the associated office and the election ends."""
            )
        }
    }
}