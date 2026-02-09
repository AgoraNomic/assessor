package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.endorseOfficer
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.AGAINST
import org.agoranomic.assessor.lib.vote.VoteKind.FOR

@UseAssessment
fun assessment9287() = assessment {
    name("9287")
    quorum(4)

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
                "Collar"(1) heldBy Mischief
                "Collector"(2) heldBy Mischief
                "Distributor"(0) heldBy omd
                "Herald"(2) heldBy snail
                "Illuminator"(1) heldBy Cosmo
                "Land Managor"(1) heldBy Murphy
                "Notary"(2) heldBy null
                "Numerator"(1) heldBy Trigon
                "Prime Minister"(0) heldBy null
                "Promotor"(3) heldBy Cosmo
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy kiako
                "Spendor"(1) heldBy Murphy
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy kiako
            }
        }
    }

    proposals(v4) {
        proposal(9287) {
            title("Overexertion")
            ai("1.0")
            author(Murphy)
            ordinary()

            text(
                """
Amend Rule 2683 (The Boulder) by replacing this text:

       Each player CAN, once a week, by announcement, push the boulder.
       When a player pushes the Boulder, its Height is increased by 1.
       At the beginning of each week, if the boulder was pushed in the
       previous week at least as many times as the Boulder's Slope, then
       the Boulder's Slope is increased by 1; otherwise, the Boulder's
       Height is set to 0, and the Boulder's Slope is set to 1. The
       Absurdor SHOULD list the largest Height and Slope of the Boulder
       ever reached in eir report.

with this text:

       When the Boulder Falls, all its switches are set to their
       default values.

       Each player CAN push the boulder by announcement. When a player
       pushes the Boulder, its Height is increased by 1. At the beginning
       of each week, if the boulder was pushed in the previous week at
       least as many times as the Boulder's Slope, then the Boulder's
       Slope is increased by 1; otherwise, the Boulder Falls. The
       Absurdor SHOULD list the largest Height and Slope of the Boulder
       ever reached in eir report.

       The Boulder's Instability is an untracked singleton integer
       switch defaulting to 0. When a player pushes the Boulder and
       has already done so earlier that week, the Boulder's
       Instability is increased by 1. At the beginning of each week,
       the Boulder's Instability is set to 0.

       If the Boulder's Instability was greater than 0 at the end of
       the previous week, then the Absurdor SHALL select and announce
       that many random integers from 1 to 10 (inclusive). If any of
       them are 1, or if e fails to do so, then the Boulder Falls.

[Make it possible, though unreliable, for a smaller set of players to
  push the Boulder up a steeper Slope.]"""
            )
        }
    }

    voting {
        votes(juan) {
            FOR on 9287
        }

        votes(Cosmo) {
            FOR on 9287
        }

        votes(Murphy) {
            endorseOfficer("Absurdor", juan) on 9287
        }

        votes(Janet) {
            AGAINST on 9287
        }

        votes(ais523) {
            AGAINST on 9287
        }
    }
}
