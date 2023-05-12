package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment8960to8964() = assessment {
    name("8960-8964")
    quorum(5)

    proposals(v4) {
        proposal(8960) {
            title("Ritual disambiguation")
            ai("1.0")
            author(ais523)
            ordinary()

            text(
                """
In rule 2680, amend
{{{
      When a positive integral multiple of 41 is anointed as a ritual
      number for the first time, the person who does so CAN, by
      announcement, Raise the First Speaker in a powerful dance around
      the Town Fountain. Doing so causes each player qualifying under
      this Rule to gain 1 radiance.
}}}
to
{{{
      For each positive integral multiple of 41, when that number is
      anointed as a ritual number for the first time, the person who
      does so CAN, by announcement, Raise the First Speaker in a
      powerful dance around the Town Fountain. Doing so causes each
      player qualifying under this Rule to gain 1 radiance.
}}}"""
            )
        }

        proposal(8961) {
            title("now you don't see it")
            ai("1.0")
            author(G)
            ordinary()

            text(
                """
Re-enact Rule 2056 (Invisibilitating) with the following text:

      Invisibilitating is a Class 1 infraction.


[
Rule 2056 history (confirmed by checking archives):

Enacted (Power=1) by Proposal 4513 "Invisibilitating" (Steve), 10 July 2003.
Repealed by Proposal 4759 "Olive Repeals" (Manu, Sherlock), 15 May 2005.
]"""
            )
        }

        proposal(8962) {
            title("Please behave, Prime Minister")
            ai("1.0")
            author(Yachay)
            ordinary()

            text(
                """
Remove the last sentence of rule 2463."""
            )
        }

        proposal(8963) {
            title("hats")
            ai("1.0")
            author(Forest)
            ordinary()

            text(
                """
Enact a new rule with the text
"hats are an untracked player switch that can have any value ever.""""
            )
        }

        proposal(8964) {
            title("Minty Stone")
            ai("2.0")
            author(snail)
            ordinary()

            text(
                """
Amend Rule 2645 (The Stones) by replacing

{{
      - Jockey Stone (monthly, 3): When wielded, a specified Running
        horse's Race Position is increased by 1.
}}
with
{{
      - Minty Stone (weekly, 4): When wielded, a specified Player gains a
stamp of eir own type.
}}"""
            )
        }
    }
}
