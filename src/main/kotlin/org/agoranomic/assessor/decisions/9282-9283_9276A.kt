package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment9282to9283_9276A() = assessment {
    name("9282-9283, 9276A")
    quorum(3)

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
}
