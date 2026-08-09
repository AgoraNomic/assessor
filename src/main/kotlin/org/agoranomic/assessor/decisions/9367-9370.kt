package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment9367to9370() = assessment {
    name("9367-9370")
    quorum(7)

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
}
