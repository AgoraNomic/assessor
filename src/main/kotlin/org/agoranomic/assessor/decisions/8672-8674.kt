package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8672to8674() = assessment {
    name("8672-8674")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(15)

        blotPenalty(nix, 5 / 3)
        blotPenalty(cuddlybanana, 3 / 3)
        blotPenalty(Jason, 3 / 3)
    }

    proposals(v4) {
        proposal(8672) {
            title("Inclusivity")
            ai("3.0")
            author(Murphy)
            sponsored()
            democratic()

            text("""
Amend Rule 217 (Interpreting the Rules) by adding this paragraph before
the first paragraph containing "controversy" (if any, otherwise at the
end):

      A requirement that something be "reasonable" or "reasonably
      <adjective>", or pertaining to the availability or clarity of
      information, implies "to players in general", unless otherwise
      specified.""")
        }

        proposal(8673) {
            title("Mine!")
            ai("1.0")
            author(Murphy)
            sponsored()
            ordinary()

            text("""
Amend Rule 2665 (The Birds) by appending this paragraph to the list of
birds:

      - Bowerbird: A specified stone that is owned by a player is
        transferred to the playmate.""")
        }

        proposal(8674) {
            title("Proper Postage v2")
            ai("1.0")
            author(nix)
            sponsored()
            ordinary()

            text("""
Amend R2499, Welcome Packages, by replacing:

        * 10 boatloads of coins~>, AND<~
      ~>* 1 of each type of card defined in the rules.<~

with:

      ~>* 1 of each type of card defined in the rules,<~
        * 10 boatloads of coins, AND
        * 1 Stamp of eir own type""")
        }
    }

    voting {
        votes(juan) {
            AGAINST on 8672
            AGAINST on 8673
            AGAINST on 8674
        }

        votes(Jason) {
            FOR on 8672
            AGAINST on 8673
            FOR on 8674
        }

        votes(ais523) {
            PRESENT on all
        }

        votes(G) {
            AGAINST on 8672
            FOR on 8673
            FOR on 8674
        }
    }
}
