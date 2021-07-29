package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8595() = assessment {
    name("8595")
    quorum(4)

    strengths {
        default(3)
        min(0)
        max(15)
    }

    proposals(v3) {
        proposal(8595) {
            title("It's a gray, gray world.")
            ai("3.0")
            author(RLee)
            coauthors(Jason)
            democratic()
            sponsored()

            text("""
Amend rule 2438, "Ribbons", by deleting the last list item.
[Comment: Awarding coins can be done at power 1, piggybacking off of the
Ribbon rule. No reason to have Glitter here at power 3]

Amend rule 2602, "Glitter" to read, in full:

  "Each type of Ribbon has a corresponding type of Glitter
  with the same name. A player qualifies for a type of Glitter
  when e qualifies for the same type of Ribbon while already
  owning such a Ribbon. If a player has not been awarded
  that type of Ribbon or e corresponding type of Glitter
  since e last earned or came to qualify for that type of
  Ribbon, and has not been so awarded five or more times
  within the past 24 hours, any player CAN award em that
  type of Glitter by announcement. When a player gains
  a type of Glitter, the Tailor SHALL in an officially
  timely fashion and CAN once by announcement award em
  N/2 boatloads of coins rounded up, where N is the number
  of players that did not own the corresponding type of
  Ribbon at the time of the award. The amount payable for
  each type of Glitter is tracked in the Tailor's weekly
  report.

[comment: Nonplayer persons can currently get Glitter, they don't need to
be able to though because it does nothing. N+1 becomes N/2 because Glitter
is currently the most powerful way to get coins, by far. ]""")
        }
    }

    voting {
        votes(Falsifian) {
            endorse(RLee) on 8595
        }

        votes(ais523) {
            PRESENT on 8595
        }

        votes(Trigon) {
            endorse(RLee) on 8595
        }

        votes(Jason) {
            PRESENT on 8595
        }

        votes(RLee) {
            FOR on 8595
        }

        votes(G) {
            AGAINST on 8595
        }
    }
}
