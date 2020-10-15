package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.lib.proposal.Ministry.Economy
import org.agoranomic.assessor.lib.proposal.Ministry.Participation

@UseAssessment
fun assessment8504to8506() = assessment {
    quorum(5)

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
            author(Jason)
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
}
