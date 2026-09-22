package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.AGAINST
import org.agoranomic.assessor.lib.vote.VoteKind.FOR

@UseAssessment
fun assessment9375to9376() = assessment {
    name("9375-9376")
    quorum(5)

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
                "Executor"(1) heldBy Mischief
                "Herald"(2) heldBy snail
                "Illuminator"(1) heldBy Cosmo
                "Land Managor"(1) heldBy Murphy
                "Notary"(2) heldBy pizza723
                "Numerator"(1) heldBy Trigon
                "Prime Minister"(0) heldBy Kate
                "Promotor"(3) heldBy Cosmo
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy Galle
                "Spendor"(1) heldBy Murphy
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy kiako
            }
        }
    }

    proposals(v4) {
        proposal(9375) {
            title("Acyclic Voting")
            ai("3.0")
            author(pizza723)
            democratic()

            text(
                """
Amend rule 2127 "Conditional Votes" by replacing the sentence

     If the conditional is clearly specified, and evaluates to
     a valid vote, it is counted as that vote; otherwise, it is counted
     as PRESENT.

with

     If the conditional is clearly specified, and evaluates to
     a valid vote that does not depend on its own evaluation, it is
counted as that vote; otherwise, it is counted
     as PRESENT."""
            )
        }

        proposal(9376) {
            title("Cancellation Insurance")
            ai("1.0")
            author(Ronic)
            ordinary()

            text(
                """
Amend Rule 2716 ("Scheduled Actions") by adding the following paragraph:

"When creating a Scheduled Action, its creator CAN pay an additional
fee of 1 Spendie to make it cancellable. The creator of a cancellable
Scheduled Action CAN cancel it by announcement before its Time. When a
Scheduled Action is cancelled, it ceases to exist. Cancelling a
Scheduled Action does not refund any Spendies paid to create it."

Rationale: This creates a paid escape hatch for mistakes and changed
circumstances without making every Scheduled Action reversible for
free."""
            )
        }
    }

    voting {
        votes(Forest) {
            AGAINST on 9375
            FOR on 9376
        }
    }
}