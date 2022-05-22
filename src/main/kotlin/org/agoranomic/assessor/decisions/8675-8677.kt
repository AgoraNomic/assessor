package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8675to8677() = assessment {
    name("8675-8677")
    quorum(4)

    strengths {
        default(3)
        min(0)
        max(15)

        blotPenalty(cuddlybanana, 3 / 3)
    }

    proposals(v4) {
        proposal(8675) {
            title("Let's make it clear")
            ai("1.0")
            author(Secretsnail9)
            ordinary()
            sponsored()

            text("""
Amend Rule 2621 (VP Wins) by replacing "If a player has at least 20 more
Winsomes than any other player" with "If a player has at least 20 more
Winsomes than all other players".""")
        }

        proposal(8676) {
            title("Let's make it entirely clear")
            ai("1.0")
            author(Secretsnail9)
            ordinary()
            sponsored()

            text("""
Amend Rule 2621 (VP Wins) by replacing "If a player has at least 20 more
Winsomes than any other player" with "If a player has at least 20 more
Winsomes than each other player".""")
        }

        proposal(8677) {
            title("Endgame")
            ai("1.0")
            author(G)
            ordinary()
            sponsored()

            text("""
Create the following power=1 rule, titled Buyout:

     Any player who has not taken over the economy in the last 30
     days CAN pay a fee of N Winsomes to create 500 times N coins
     in eir possession, provided e does so unconditionally and
     without disclaimers, acting as emself, in a message body
     containing no other actions or other action attempts, and explicitly
     specifies N in the message (i.e. without indirect references such
     as "all").

     One week after this rule first takes effect, the winds die down.

     Immediately after Rule 2658 (The Winds Die Down) is repealed,
     this rule is repealed.""")
        }
    }

    voting {
        votes(ais523) {
            AGAINST on 8675
            FOR on 8676
            AGAINST on 8677
        }

        votes(juan) {
            AGAINST on 8675
            FOR on 8676
            FOR on 8677
        }

        votes(Jason) {
            AGAINST on 8675
            PRESENT on 8676
            endorse(ais523) on 8677
        }
    }
}
