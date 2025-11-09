package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.FOR

@UseAssessment
fun assessment9249() = assessment {
    name("9249")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2025-October/018726.html")
    quorum(3)

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
                "Illuminator"(1) heldBy null
                "Land Managor"(1) heldBy Murphy
                "Notary"(2) heldBy null
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
        proposal(9249) {
            title("Streamlined fees")
            ai("3.0")
            author(Murphy)
            democratic()

            text(
                """
Amend Rule 2579 (Fee-based Actions) by replacing this text:

       To use a fee-based method, an entity (the Actor) who is otherwise
       permitted to perform the action must announce that e is performing
       the action; the announcement must specify the correct set of
       assets for the fee and indicate intent to pay that fee for the
       sole purpose of using that method to perform that action.

with this text:

       To use a fee-based method, an entity (the Actor) who is otherwise
       permitted to perform the action must announce that e is performing
       the action; such an announcement indicates intent to pay that fee
       for the sole purpose of using that method to perform that action,
       and e SHALL specify the correct set of assets for that fee, though
       simplified wording such as "I buy X" is sufficient if the fee paid
       is reasonably unambiguous.

[This month, there were half a dozen announcements like "I buy X" or "I
  plant X" where there was no ambiguity what was intended. This proposal
  may open up some obscure loopholes, but that still seems preferable to
  repeatedly tripping over wording that seems like it ought to work.]"""
            )
        }
    }

    voting {
        votes(Mischief) {
            endorse(Janet) on 9249 comment "${Janet.name} is the Rulekeepor"
        }

        votes(Cosmo) {
            endorse(Janet) on 9249 comment "${Janet.name} is the Rulekeepor"
        }

        votes(juan) {
            FOR on 9249
        }

        votes(Murphy) {
            FOR on 9249
        }
    }
}
