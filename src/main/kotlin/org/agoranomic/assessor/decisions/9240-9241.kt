package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment9240to9241() = assessment {
    name("9240-9241")
    quorum(6)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            complexityBonuses {
                maxBonus(3)

                "Absurdor"(1) heldBy juan
                "ADoP"(2) heldBy Murphy
                "Arbitor"(2) heldBy Kate
                "Archivist"(1) heldBy kiako
                "Assessor"(3) heldBy Janet
                "Collector"(2) heldBy Mischief
                "Distributor"(0) heldBy omd
                "Herald"(2) heldBy snail
                "Illuminator"(1) heldBy Mischief
                "Notary"(2) heldBy Mischief
                "Prime Minister"(0) heldBy Mischief
                "Promotor"(3) heldBy Cosmo
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy Kate
                "Spendor"(1) heldBy Murphy
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy kiako
            }
        }
    }

    proposals(v4) {
        proposal(9240) {
            title("Agoran Bingo")
            ai("1")
            author(Mischief)
            coauthors(juan)
            ordinary()

            text(
                """
[The person running a bingo game is often called the caller. Agoran spelling
would make that Callor. My eyes want to read that as "caal-lore" and since
it's the same letters, I just changed it to Collar out of whimsy.]

Create a rule entitled "Agoran Bingo" with power 1 reading:

       The Collar is an elected office responsible for administering
       Agoran Bingo.

       Bingo state is a singleton switch tracked by the Collar with
       possible values paused (default) and unpaused.

       If the bingo state is paused, the Collar CAN flip it to unpaused
       by announcement, and e SHOULD do so unless there is reasonable
       uncertainty as to the current bingo state or the validity of a
       claimed bingo, or the Collar is actively drafting, discussing, or
       trying to enact or amend eir administrative regulations. When the
       bingo state is paused, all existing bingo board selections are
       null and void, a player CANNOT select a bingo board, and a player
       CANNOT call bingo.

       If the bingo state is unpaused, a player whose bingo board
       contains at least one winning pattern of conditions -- as defined
       in the Collar's regulations -- that are all satisfied CAN call
       bingo by announcement. (For clarity, the states of any conditions
       not in the winning pattern are irrelevant.) Eir announcement:

       1) MUST specify the claimed winning pattern and the conditions it
          contains;

       2) MUST reveal any information required by the Collar's
          adminstrative regulations for the method e used to select a
          bingo board; and

       3) SHOULD include evidence demonstrating that each of the
          conditions in the winning pattern is satisfied, other than any
          conditions where such satisfaction is already clearly obvious.

       When a player successfully calls bingo, e wins the game and the
       bingo state is flipped to paused.

       If no player has successfully called bingo in the previous 3
       months, the Collar can flip the bingo state to paused without 2
       objections.


Create a rule entitled "Regulating Agoran Bingo" with power 1 reading:

       The Collar SHOULD try to enact and maintain administrative
       regulations defining:

       * one or more methods for a player to select a bingo board;

       * the conditions that can be included on a player's bingo board;
         and

       * one or more winning bingo patterns


       The methods for selecting a bingo board SHOULD be such that:

       * there is at least one method that permits a player to keep eir
         bingo board secret until e calls bingo;

       * a player cannot change eir selection once made; and

       * a player cannot choose in advance with certainty the board e
         will end up with


       Additionally, for each method of selecting a bingo board, the
       Collar's regulations SHOULD specifiy:

       * what information, if any, a player electing that method MUST
         reveal in order to successfully call bingo; and

       * what information, if any, the Collar MUST include in eir weekly
         report for each player electing that method"""
            )
        }

        proposal(9241) {
            title("Birthday Tournament Vibe Check")
            ai("1")
            author(Mischief)
            ordinary()

            text(
                """
Repeal rule 2495 (The Birthday Tournament)"""
            )
        }
    }

    voting {
        votes(Mischief) {
            FOR on 9240
            PRESENT on 9241
        }

        votes(Janet) {
            PRESENT on 9240
            AGAINST on 9241
        }

        votes(Murphy) {
            FOR on 9240
            PRESENT on 9241
        }

        votes(Trigon) {
            PRESENT on 9240
            AGAINST on 9241
        }

        votes(juan) {
            FOR on 9240
            AGAINST on 9241
        }

        votes(Cosmo) {
            FOR on 9240
            AGAINST on 9241
        }
    }
}