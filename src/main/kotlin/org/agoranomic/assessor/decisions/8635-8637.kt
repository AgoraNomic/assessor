package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8635to8637() = assessment {
    name("8635-8637")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2022-February/015651.html")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(15)

        blotPenalty(Madrid, 7 / 3)
        blotPenalty(Trigon, 4 / 3)
        blotPenalty(nix, 4 / 3)
    }

    proposals(v4) {
        proposal(8635) {
            title("Outside assistance")
            ai("4.0")
            author(Murphy)
            democratic()
            sponsored()

            text("""
Amend Rule 1698 (Agora Is A Nomic) by replacing "players" with
"persons".

[Explicitly avoids the interpretation suggested on CFJ 8591 that
  the "players making arbitrary changes" clause requires a current
  player, even if registration remains unblocked.]""")
        }

        proposal(8636) {
            title("Points")
            ai("1.5")
            author(G)
            ordinary()
            sponsored()

            text("""
Create the following power=1.5 rule, Points:

  A player's Score, indicated in Points, is an integer player switch
  defaulting to 0, tracked by the Herald.

  Upon a correct announcement from a player that one or more players
  have a score of 100+ points, all players meeting this condition
  win the game.  If a least one player wins the game via such an
  announcement, all players' scores are set to their default.""")
        }

        proposal(8637) {
            title("Basic Scoring v0.2")
            ai("1.0")
            author(G)
            coauthors(Janet)
            ordinary()
            sponsored()

            text("""
Create the following rule, "Scoring":

  Each time a player fulfills a scoring condition, the officer
  associated with the condition CAN once by announcement, and SHALL
  in an officially timely fashion, add to that player's score the
  associated amount of points.

  Below is a list of scoring conditions and their associated points
  and officers.

    * Being the author of a sponsored proposal that takes effect:
      1 + the power of the proposal when it takes effect (Assessor).

    * Being the coauthor of a sponsored proposal that takes effect:
      1 (Assessor).

    * Having submitted an unconditional ballot AGAINST a referendum on
      a sponsored proposal, provided that the ballot is valid at
      the time the referendum is assessed, and provided that the outcome
      of that assessment is ADOPTED:  points equal to the voting
      player's voting strength on the referendum (Assessor).

[note: using "1 + the power of the proposal when it takes effect" instead
of "the AI of the proposal" because the AI is unlimited while power
iscapped at 4 by R106].

[v0.2 - specified "add" instead of "change".
      - change in referendum wording suggested by Jason.
]""")
        }
    }

    voting {
        votes(ais523) {
            AGAINST on 8635
            PRESENT on 8636
            PRESENT on 8637 comment legacyConditionalComment("Proposal 8636 has been enacted")
        }

        votes(cuddlybanana) {
            FOR on all
        }

        votes(Janet) {
            endorse(ais523) on 8635
            FOR on 8636
            PRESENT on 8637
        }

        votes(Falsifian) {
            AGAINST on 8635
            PRESENT on 8636
            PRESENT on 8637
        }

        votes(Murphy) {
            FOR on 8635
            FOR on 8636
            FOR on 8637
        }

        votes(Madrid) {
            FOR on all
        }

        votes(G) {
            AGAINST on 8635
            FOR on 8636
            FOR on 8637
        }

        votes(Aspen) {
            AGAINST on 8635
            FOR on 8636
            AGAINST on 8637
        }
    }
}
