package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.lib.VoteKind.*
import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.votes.endorse

@UseAssessment
fun `assessment 8243 to 8247`() = assessment {
    name("8243-8247")
    quorum(4)

    strengths {
        default(3)
        G strength 4 comment PM
        Corona strength 1 comment BLOTS
    }

    proposals(v0) {
        proposal(8243) {
            title("Self-ratifying regulations")
            ai(3.0)
            author(Jason)

            text(
                """
Amend Rule 2493 by replacing the sentence beginning "Regulations are
tracked" with sentence "Regulations are tracked in their Promulgator's
weekly report; a public document purporting to be this portion of a
report is self-ratifying."."""
            )
        }

        proposal(8244) {
            title("Crime Cleanup")
            ai(3.0)
            author(Jason)

            text(
                """
Amend Rule 2143 by replacing the text "Class-2 crime" with the text
"Class 2 Crime".

Amend Rule 2202 by replacing the text "Class-8 Crime" with the text
"Class 8 Crime".

Amend Rule 2557 by replacing the text "Class N crime" with the text:

  "Class N Crime" (where N is a positive integer, or an expression
  that evaluates to a positive integer)

Amend Rule 2589 by replacing the text "Class-3 Crime" with the text
"Class 3 Crime".

Amend Rule 2593 by replacing the text "Class-5 Crime" with the text
"Class 5 Crime"."""
            )
        }

        proposal(8245) {
            title("Pool drain timing")
            ai(3.0)
            author(G)

            text(
                """
Amend Rule 1607 (Distribution) by replacing:
      In a given Agoran week, the Promotor SHALL, as part of eir weekly
      duties, distribute all proposals in the Proposal Pool except for
      those exempted from automatic distribution by other rules.
with:
      In a given Agoran week, the Promotor SHALL distribute each
      proposal that was in the Proposal Pool at the beginning of that
      week, except for those excepted from automatic distribution
      by other rules, or those that are otherwise removed from the
      Pool.

[This way, the "act of deputization" can be any single proposal
that was in the pool at the beginning of the week.  Further,
for proposals inserted in a week, the promotor has the option
of either distributing them that week or leaving them for the
next week, so Aris's "please don't make any changes until
I distribute" emails are less needed, and e can time stuff.]"""
            )
        }

        proposal(8246) {
            title("Tracking of Master")
            ai(2.0)
            author(Jason)

            text(
                """
Amend Rule 2532 ("Zombies") by replacing the sentence beginning "Master
is a secured player switch" with the following sentence:

  Master is a secured player switch, tracked by the Registrar, with
  possible values of any player, and Agora.


[This isn't currently made explicit at the definition of Master, but is
required by the last paragraph of Rule 2139.]"""
            )
        }

        proposal(8247) {
            title("Quorum Defailure")
            ai(1.0)
            author(JacobArduino)
            coauthors(twg)

            text(
                """
Add each proposal with an ID number between 8235 and 8242 inclusive to the
Proposal Pool."""
            )
        }
    }

    voting {
        votes(Falsifian) {
            AGAINST on 8243
            endorse(Jason) on 8244
            FOR on 8245 comment conditional("Aris did not vote AGAINST")
            endorse(Jason) on 8246
            FOR on 8247 comment NO_VETO
        }

        votes(Aris) {
            FOR on 8243
            FOR on 8244
            FOR on 8245
            FOR on 8246
            PRESENT on 8247 comment NO_VETO
        }

        votes(Jason) {
            FOR on 8243
            FOR on 8244
            endorse(G) on 8245
            FOR on 8246
            FOR on 8247
        }

        votes(twg) {
            AGAINST on 8243
            PRESENT on 8244
            endorse(Aris) on 8245
            endorse(Jason) on 8246
            FOR on 8247
        }

        votes(JacobArduino) {
            endorse(twg) on all
        }

        votes(Trigon) {
            PRESENT on 8243
            FOR on 8244
            FOR on 8245
            FOR on 8246
            FOR on 8247
        }

        votes(G) {
            AGAINST on 8243
            FOR on 8244
            endorse(Aris) on 8245
            FOR on 8246
            AGAINST on 8247
        }
    }
}
