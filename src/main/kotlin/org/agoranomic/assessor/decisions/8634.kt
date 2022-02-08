package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.lib.vote.VoteKind.FOR
import org.agoranomic.assessor.lib.vote.VoteKind.PRESENT

@UseAssessment
fun assessment8634() = assessment {
    name("8634")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2021-December/015551.html")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(15)

        blotPenalty(Madrid, 6 / 3)
    }

    proposals(v4) {
        proposal(8634) {
            title("Laudability")
            ai("3.0")
            author(Jason)
            democratic()
            sponsored()

            text("""
Amend Rule 2438 by appending the following to the paragraph
beginning "For each type of Ribbon":
{

  Laudability is a secured person switch with non-negative integer possible
  values, defaulting to 0, tracked by the Tailor as part of eir monthly
  report. When a person owns more types of ribbons than eir Laudability,
  eir Laudability is set to the number of types of ribbons e owns.

}

Amend Rule 2480 by replacing:
{
  A player who owns at least N types of Ribbon CAN Start a Rank N
  Festival, where N is an integer greater than Agora's Festivity,
  with 4 support from players who own at least N types of Ribbon.
  Upon doing so, Agora's Festivity is flipped to N. Exception: A
  player CANNOT do so if Agora's Festivity has had a value greater
  than or equal to N within the past 21 days.

  A person who owns a number of types of Ribbon equal to or greater
  than Agora's Festivity is known as Festive. Other persons are not
  Festive.
}
with:
{

  A person whose Laudability is greater than or equal to Agora's
  Festivity is Festive. Any other person is not Festive.

  A player who would be Festive if the Festivity was N CAN Start a
  Rank N Festival, where N is an integer greater than Agora's
  Festivity, with 4 support from other players who would be Festive
  if the Festivity was N, except that a Rank N Festival CANNOT be
  started if Agora's Festivity has had a value grater than or equal
  to N in the past 21 days. Upon a Rank N Festival starting, Agora's
  Festivity is flipped to N.

}

The Laudability of each of the following persons is hereby flipped
to the number of existing types of ribbon:
  * ais523
  * Alexis
  * G.
  * Jason
  * Murphy
  * twg

[These are the people who have won by Renaissance.]""")
        }
    }

    voting {
        votes(Trigon) {
            FOR on 8634
        }

        votes(ais523) {
            PRESENT on 8634
        }

        votes(Jason) {
            FOR on 8634
        }

        votes(RLee) {
            FOR on 8634
        }

        votes(ATMunn) {
            endorse(Jason) on 8634
        }

        votes(Falsifian) {
            endorse(Jason) on 8634
        }

        votes(Murphy) {
            FOR on 8634
        }
    }
}
