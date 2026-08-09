package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.endorseOfficer
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.FOR
import org.agoranomic.assessor.lib.vote.VoteKind.PRESENT

@UseAssessment
fun assessment9367to9370() = assessment {
    name("9367-9370")
    quorum(7)

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
                "Executor"(1) heldBy Mischief
                "Herald"(2) heldBy snail
                "Illuminator"(1) heldBy Cosmo
                "Land Managor"(1) heldBy Murphy
                "Notary"(2) heldBy pizza723
                "Numerator"(1) heldBy Trigon
                "Prime Minister"(0) heldBy Kate
                "Promotor"(3) heldBy Cosmo
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy ais523
                "Spendor"(1) heldBy Murphy
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy kiako
            }
        }
    }

    proposals(v4) {
        proposal(9367) {
            title("Divestment")
            ai("3.0")
            author(Kate)
            democratic()

            text(
                """
Set the Indigo Ribbon Ownership of the author of this proposal to False.

[Many, many years ago, I acquired an Indigo Ribbon through a scam,
  without realising this was considered Poor Form, and later used it in a
  Win by Renaissance. Since then I have desperately been trying to
  account for it by achieving degrees and declining to award myself the
  ribbon, but people keep "helpfully" awarding it to me anyway to allow
  for my "forgetfulness".

  This just happened again and I do not want to go through yet another
  round of this. Can we fix it by proposal, please?]"""
            )
        }

        proposal(9368) {
            title("Greater Genetic Mutation v3")
            ai("1.0")
            author(Galle)
            ordinary()

            text(
                """
Amend Rule 2710 ("Genetic Modification") by replacing the fourth
paragraph with the following text:
---
Once per Crop Season, the Land Managor CAN and SHALL by announcement set
a randomly selected attribute (Seed Cost, Growth Duration, Opportunity,
Resilience, or Sell Price) of a randomly selected type of Crop that was
in-season during the previous season to a randomly selected valid value.
If there is no such type to select, then e SHALL instead announce that fact."""
            )
        }

        proposal(9369) {
            title("Oops")
            ai("3.0")
            author(snail)
            coauthors(Mischief)
            democratic()

            text(
                """
Amend Rule 2713 (Scoring Numbers) by replacing the text:

{

       Whenever a player scores a number as described in this rule, the
       Numerator CAN once, and SHALL in a timely fashion, grant that
       player (and, if the number was scored due to the adoption of a
       proposal, also a randomly chosen other player who voted FOR on a
       referendum to adopt that proposal) a number card for each digit in
       that number, whose type is that digit.


}

with the text:

{

       Whenever a player scores a number as described in this rule, the
       Numerator CAN once by announcement, and SHALL in a timely fashion,
grant that
       player (and, if the number was scored due to the adoption of a
       proposal, also a randomly chosen other player who voted FOR on a
       referendum to adopt that proposal) a number card for each digit in
       that number, whose type is that digit.

}

The following statement is hereby ratified:
{
Each attempt to grant a player a number card that occured prior to the
adoption of this proposal took effect as if the text "CAN once," in Rule
2713 instead read "CAN once by announcement,".
}

[This should work for each version of Rule 2713 that has existed. I'm doing
this instead of changing the past text of the rule because doing that
retroactively would have caused proposals that amended that specific text
to fail.]

[I also considered expunging the Numerator's duties to avoid shenanigans,
but that might do more harm than good, and the ratification should already
cover that issue.]"""
            )
        }

        proposal(9370) {
            title("Probably shouldn't leave this lying around")
            ai("2.0")
            author(Galle)
            ordinary()

            text(
                """
Repeal the rule entitled "Purchased Re-enactment"."""
            )
        }
    }

    voting {
        votes(Cosmo) {
            PRESENT on 9367
            FOR on 9368
            endorseOfficer("Numerator", Trigon) on 9369
            FOR on 9370
        }

        votes(pizza723) {
            PRESENT on 9367
            PRESENT on 9368
            FOR on 9369
            FOR on 9370
        }

        votes(Galle) {
            FOR on 9367
            FOR on 9368
            FOR on 9369
            FOR on 9370
        }
    }
}
