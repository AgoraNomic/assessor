package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.dsl.votes.powerStone
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8665to8666() = assessment {
    name("8665-8666")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(15)

        blotPenalty(Trigon, 7 / 3)
        blotPenalty(nix, 5 / 3)
        blotPenalty(cuddlybanana, 3 / 3)
        blotPenalty(Jason, 3 / 3)

        onOrdinaryProposals {
            powerStone(Jason, 3)
        }
    }

    proposals(v4) {
        proposal(8665) {
            title("Promise Expirations 1.1")
            ai("3.0")
            author(nix)
            coauthors(Jason, ais523)
            democratic()
            sponsored()

            text("""
Amend 2618 by replacing:

  The Library is an entity and CAN own promises. Any player CAN take
  a specified promise from the Library by announcement, provided e
  cashes the promise in the same message. The creator of a promise
  CAN take or revoke it from the Library by announcement, unless the
  promise's text unambiguously designates it as irrevocable. Any
  player CAN revoke a specified promise from the Library without
  objection.

with:

  The Library is an entity and CAN own promises. Any player CAN take
  a specified promise from the Library by announcement, provided e
  cashes the promise in the same message.

  The creator of a promise CAN take or revoke it from the Library by
  announcement, unless the promise's text unambiguously designates
  it as irrevocable. Any player CAN revoke a specified promise from
  the Library without objection. If a promise specifies expiration
  conditions then any player CAN by announcement destroy it while
  the expiration conditions are unambiguously met.""")
        }

        proposal(8666) {
            title("The Secretarybird")
            ai("1.0")
            author(Secretsnail9)
            coauthors(nix)
            ordinary()
            sponsored()

            text("""
Amend Rule 2665 (The Birds) by appending the list item:
{

  - Secretarybird: The playmate gains 1 stamp with the type of a
    specified active player.

}""")
        }
    }

    voting {
        votes(Murphy) {
            FOR on 8665
            FOR on 8666
        }

        votes(Jason) {
            FOR on 8665
            PRESENT on 8666
        }

        votes(ais523) {
            FOR on 8665
            FOR on 8666
        }

        votes(Secretsnail9) {
            FOR on 8665
            FOR on 8666
        }

        votes(nix) {
            endorse(Jason) on all
        }

        votes(G) {
            AGAINST on 8666
            FOR on others
        }

        votes(Aspen) {
            FOR on 8665
            endorse(G) on 8666
        }
    }
}
