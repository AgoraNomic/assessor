package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.dsl.votes.powerStone
import org.agoranomic.assessor.lib.vote.VoteKind.AGAINST
import org.agoranomic.assessor.lib.vote.VoteKind.FOR

@UseAssessment
fun assessment8655to8656() = assessment {
    name("8655-8656")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(15)

        blotPenalty(Madrid, 7 / 3)
        blotPenalty(Trigon, 4 / 3)

        onOrdinaryProposals {
            powerStone(Jason, 3)
        }
    }

    proposals(v4) {
        proposal(8655) {
            title("Restricted Petitions")
            ai("1.0")
            author(Jason)
            coauthors(nix)
            ordinary()
            sponsored()

            text("""
Amend Rule 2143 by replacing the final paragraph with the following
paragraph:

{

  A player CAN, by announcement, petition a specified non-vacant office to
  take a specific action. The holder of that office SHALL publicly respond
  to that petition in a timely fashion.

}


[Amend away all possible ambiguity about whether petitioning vacant
offices works, and ensure that the duty moves with the office, rather
than attaching to a specific person.]""")
        }

        proposal(8656) {
            title("Mathematical de-notation")
            ai("1.0")
            author(Jason)
            ordinary()
            sponsored()

            text("""
Amend Rule 2657 by replacing "the floor of the associated amount of
points" with "the associated amount of points, rounded down".""")
        }
    }

    voting {
        votes(Jason) {
            FOR on all
        }

        votes(Murphy) {
            FOR on 8655
            FOR on 8656
        }

        votes(Secretsnail9) {
            AGAINST on 8655
            AGAINST on 8656
        }

        votes(juan) {
            FOR on all
        }

        votes(Trigon) {
            FOR on all
        }

        votes(nix) {
            // TODO: resolve conditional vote on all: "unconditional" AGAINST if any unconditional AGAINST votes, else FOR
        }
    }
}
