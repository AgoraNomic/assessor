package org.agoranomic.assessor.decisions

import kotlinx.collections.immutable.persistentListOf
import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.proposal.ProposalNumber
import org.agoranomic.assessor.lib.proposal.ProposalNumbers
import org.agoranomic.assessor.lib.resolve.AssessmentData
import org.agoranomic.assessor.lib.resolve.AssessmentMetadata
import org.agoranomic.assessor.lib.resolve.AssessmentUrl
import org.agoranomic.assessor.lib.resolve.subAssessment
import org.agoranomic.assessor.lib.vote.VoteKind.*

private fun assessment9230to9232() = assessment {
    name("9230-9232")
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
                "Arbitor"(2) heldBy Kate
                "Archivist"(1) heldBy kiako
                "Assessor"(3) heldBy Janet
                "Collector"(2) heldBy Mischief
                "Distributor"(0) heldBy omd
                "Herald"(2) heldBy snail
                "Illuminator"(1) heldBy Mischief
                "Notary"(2) heldBy Mischief
                "Prime Minister"(0) heldBy Mischief
                "Promotor"(3) heldBy null
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
        proposal(9230) {
            title("Agoriculture")
            ai("1.0")
            author(Murphy)
            coauthors(Mischief, ais523)
            ordinary()

            text(
                """
Create a rule titled "Crop Seasons" with this text:

       The Crop Season is determined by the current Agoran month:

         * Spring - March, July, November
         * Summer - April, August, December
         * Autumn - January, May, September
         * Winter - February, June, October

Create a rule titled "The Land Managor" with this text:

       The Land Managor is an office.

       The Land Manager's report includes a list of types of Crops and
       their attributes, and a list of Crops planted and harvested during
       the current Crop Season.

Create a rule titled "Pyrite" with this text:

       Pyrite is a type of fixed asset, tracked by the Land Managor.

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
       equal to its Seed Cost.

       Once per Crop that a player planted earlier in the current Crop
       Season and at least <Growth Duration> days ago, e CAN harvest it
       by announcement, gaining Pyrite equal to its Sell Price.

       At the end of each Crop Season, all unharvested Crops are lost.

Create a rule titled "Genetic Modification" with this text:

       Once per Crop Season, a player CAN pay a fee of 500 Pyrite to
       create a new type of Crop, specifying its name. The Land Managor
       SHALL, in a timely fashion after this occurs, randomly select its
       Crop Season, Seed Cost (50 to 200), Growth Duration (3 to 24), and
       Sell Price (100 to 400). Rules to the contrary notwithstanding, it
       CANNOT be planted until e performs these selections.

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
          * Spinach     (CS Autumn, SC 165, GD  7, SP 335)"""
            )
        }

        proposal(9231) {
            title("Rose-colored glasses")
            ai("1.0")
            author(Murphy)
            ordinary()

            text(
                """
If RadicalRose is not a player, then the rest of this proposal has no
effect.

Create 10 spendies in RadicalRose's possession.

For each of the following assets:

   * 1 nix stamp
   * 1 RadicalRose stamp
   * 1 RadicalRose stamp

if the Lost and Found Department owns an instance of it, then transfer
one instance of it from the Lost and Found Department to RadicalRose;
otherwise, create an instance in RadicalRose's possession.

[Restore RR's assets prior to improper deregistration, after deducting
  the contents of a Welcome Package.]"""
            )
        }

        proposal(9232) {
            title("++")
            ai("3.0")
            author(Mischief)
            democratic()

            text(
                """
Amend rule 2201 (Self-Ratification) by replacing the text:

       When a public document published less than 180 days ago is first
       continuously undoubted for one week after publication:

with:

       When a public document published less than 180 days ago is first
       continuously undoubted for two weeks after publication:"""
            )
        }
    }

    voting {
        votes(Forest) {
            FOR on 9230
            FOR on 9231
            // Attempted re-vote on 9230 fails.
        }

        votes(Mischief) {
            FOR on 9230
            FOR on 9231
            FOR on 9232
        }

        votes(Caramel) {
            FOR on 9230
            FOR on 9231
            FOR on 9232
        }

        votes(juan) {
            FOR on 9230
            FOR on 9231
            PRESENT on 9232
        }

        votes(Trigon) {
            PRESENT on 9230
            FOR on 9231
            FOR on 9232
        }

        votes(Janet) {
            AGAINST on 9230
            FOR on 9231
            PRESENT on 9232
        }

        votes(kambri) {
            FOR on 9230
            FOR on 9231
            PRESENT on 9232
        }

        votes(oliver) {
            FOR on 9230
            FOR on 9231
            FOR on 9232
        }

        votes(Murphy) {
            FOR on 9230
            FOR on 9231
            FOR on 9232
        }
    }
}

// NOTE: Proposal 9230 resolved separately due to
// https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2025-July/018548.html

private val commonAssessment = assessment9230to9232()

@UseAssessment
fun assessment9230(): AssessmentData {
    return commonAssessment.subAssessment(ProposalNumbers(setOf(ProposalNumber(9230)))).copy(
        metadata = AssessmentMetadata(
            name = "9230",
            urls = null,
        )
    )
}

@UseAssessment
fun assessment9231to9232(): AssessmentData {
    return commonAssessment.subAssessment(ProposalNumbers(setOf(ProposalNumber(9231), ProposalNumber(9232)))).copy(
        metadata = AssessmentMetadata(
            name = "9231-9232",
            urls = persistentListOf(
                AssessmentUrl("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2025-July/018555.html"),
            ),
        )
    )
}
