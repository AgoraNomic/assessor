package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment9195to9196() = assessment {
    name("9195-9196")
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
                "Archivist"(1) heldBy Gaelan
                "Assessor"(3) heldBy Janet
                "Collector"(2) heldBy Mischief
                "Distributor"(0) heldBy omd
                "Geologist"(1) heldBy Forest
                "Herald"(2) heldBy Forest
                "Illuminator"(1) heldBy Mischief
                "Notary"(2) heldBy Forest
                "Prime Minister"(0) heldBy Mischief
                "Promotor"(3) heldBy snail
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy kiako
                "Spendor"(1) heldBy null
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy null
            }
        }
    }

    proposals(v4) {
        proposal(9195) {
            title("Commitment Issues")
            ai("1.0")
            author(Mischief)
            coauthors(Kate, Janet)
            ordinary()

            text(
                """
[This is a useful but under-utilized mechanism; hopefully these tweaks
make it easier to build on.]

Amend rule 2681 (Acting on Commitment) by replacing:

       Where the rules define an action that a person CAN perform "by
       commitment" to a particular kind of document, that person performs
       that action by performing it by announcement while, in the same
       message, also publishing a what is purportedly a Fingerprint for a
       document of that kind.

with:

       A person CAN make a commitment to a particular kind of document
       by publishing a statement that purports to be a Fingerprint for a
       document of that kind. If the statement is in fact such a
       Fingerprint, the person CAN then reveal the commitment by
       publishing the Plaintext corresponding to that Fingerprint and
       clearly indicating which Fingerprint the Plaintext relates to.

       A person making a commitment SHOULD specify the method used to
       produce the Fingerprint from the Plaintext."""
            )
        }

        proposal(9196) {
            title("Use it or lose it")
            ai("1.0")
            author(Murphy)
            coauthors(Alexis)
            ordinary()

            text(
                """
Amend Rule 2690 (Spendies) by appending this text to the paragraph
containing "Spendies are tracked by the Spendor":

       If the Spendor's report is overdue, then other players SHOULD
       deputise to publish it."""
            )
        }
    }

    voting {
        votes(snail) {
            PRESENT on 9195
            PRESENT on 9196
        }

        votes(juan) {
            FOR on 9195
            PRESENT on 9196
        }

        votes(Janet) {
            FOR on 9195
            AGAINST on 9196
        }

        votes(Mischief) {
            FOR on 9195
            FOR on 9196
        }
    }
}
