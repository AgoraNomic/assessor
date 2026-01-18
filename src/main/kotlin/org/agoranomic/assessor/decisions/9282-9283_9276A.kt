package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.FOR

@UseAssessment
fun assessment9282to9283_9276A() = assessment {
    name("9282-9283, 9276A")
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
        proposal(9276) {
            title("CFJ Number Card Fix")
            ai("1.0")
            author(ais523)
            coauthors(Janet)
            ordinary()

            text(
                """
If exactly one rule contains the text
{{{
Whenever a player scores a number as described in this rule, the
Numerator CAN once, and SHALL in a timely manner, grant its author
}}}
then amend that rule by replacing that text with
{{{
Whenever a player scores a number as described in this rule, the
Numerator CAN once, and SHALL in a timely manner, grant that player
}}}
[This is a fix-forward for text in a rule proposed in a proposal that
has not yet been adopted, written so as to not care about what number
the rule eventually ends up being given.]"""
            )
        }

        proposal(9282) {
            title("Initiation specification")
            ai("3.0")
            author(Janet)
            coauthors(ais523)
            democratic()

            text(
                """
Amend Rule 107 by:

* Replacing "The publication of such a valid notice initiates the voting
period for the decision." with "The initiation of an Agoran decision
also initiates the voting period for that decision.".

* Replacing the text ", and that such a decision was initiated" with the
text ", that such a decision was initiated, and that that decision's
voting period was initiated".


[Per ais523's judgement in CFJ 4118. We don't need to state the
requirement to "publish[] a valid notice" twice for initiating Agoran
decisions, and we should always ratify that the voting period was
initiated anyway.]"""
            )
        }

        proposal(9283) {
            title("Welcome Package Tweak")
            ai("1.0")
            author(Mischief)
            ordinary()

            text(
                """
Amend rule 2499 (Welcome Packages) by replacing:

       * One stamp of eir own type.
       * 10 spendies, if e has not been granted any spendies since e last
         registered.

with:

       * 15 spendies, if e has not been granted any spendies since e last
         registered.

[A frequent pattern is: a new person joins, gets a welcome package, does
essentially nothing further, then is deregistered. This results in a
proliferation of stamp types. The revised package allows a new player
the ability to purchase multiple stamps of eir own type, if e wants to
and does so.

Also, the welcome package as it stands now grants even players with too
many stamps to use the normal rule 2659 mechanism (6 spendies for X
stamps) yet another stamp of eir type.]"""
            )
        }
    }

    voting {
        votes(Cosmo) {
            FOR on all
        }
    }
}
