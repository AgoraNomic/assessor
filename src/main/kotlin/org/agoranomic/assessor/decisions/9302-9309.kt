package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals

@UseAssessment
fun assessment9302to9309() = assessment {
    name("9302-9309")
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
                "Arbitor"(2) heldBy null
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
        proposal(9302) {
            title("No Lingering Instruments")
            ai("3.0")
            author(Mischief)
            democratic()

            text(
                """
Amend rule 106 (Adopting Proposals) by replacing the text reading "Once
a proposal finishes taking effect, its power is set to 0." with "If, at
any time, a proposal has finished taking effect, its power is set to 0."

[To see the difference, consider a proposal that took effect before the
to-be-replaced language was in place.]"""
            )
        }

        proposal(9303) {
            title("Voluntary Turnover")
            ai("2.0")
            author(Mischief)
            ordinary()

            text(
                """
Amend rule 1006 (Offices) by replacing the text reading:

       The non-interim holder of an elected office CAN, with 3 support,
       resign the office while appointing another player to become the
       holder of the office, provided that other player is one of the
       supporters.

with:

       The non-interim holder of a voluntary office CAN, with 3 support,
       resign the office while appointing another player to become the
       holder of the office, provided that other player is one of the
       supporters.

[Expand the option to sortitioned offices too.]"""
            )
        }

        proposal(9304) {
            title("Fix Welcome Packages")
            ai("1.0")
            author(Mischief)
            ordinary()

            text(
                """
Amend rule 2499 (Welcome Packages) to read:

       A player CAN, by announcement, cause a specified player to receive
       a welcome package (syn. "grant" em a welcome package).

       When a player receives a welcome package, if e has not received a
       welcome package, including under any previous definition, since e
       last registered nor in the past 30 days, then e:

       * gains 15 spendies, if e has not been granted any spendies since
         e last registered;
       * gains 16 Hectares; and
       * scores the date of eir registration.

[Let's stop the bleeding, at least. How to clean it up equitably is a
much thornier issue.]"""
            )
        }

        proposal(9305) {
            title("Fix temporary deputisation ISIDTID")
            ai("3.0")
            author(ais523)
            democratic()

            text(
                """
In rule 2160, change
{{{
3) The deputy, when performing the action, announces that e is
    doing so by deputisation or by temporary deputisation.
}}}
to
{{{
3) The deputy, when performing the action, announces that e is
    doing so by deputisation or by temporary deputisation (in the
    latter case, the deputisation is considered temporary).
}}}

[The rule allowed you to announce that you were performing temporary
deputisation but didn't specify any consequences for doing so, meaning
that AFAICT an announcement of temporary deputisation would actually
deputise permanently.]"""
            )
        }

        proposal(9306) {
            title("Ratification timing clarification")
            ai("3.2")
            author(ais523)
            democratic()

            text(
                """
In rule 1551, change
{{{
the gamestate is modified to what it would be if
}}}
to
{{{
the gamestate is modified to what it would currently be if
}}}

[A possible reading of rule 1551 is that ratification rewinds the
entire gamestate to the truth time. I think (or at least hope) that
reading loses the rule 217 tiebreak, but given how important
ratification is to keeping Agora working, and how problematic it would
be to have the gamestate randomly rewind, I would like to make this
unambiguous.]"""
            )
        }

        proposal(9307) {
            title("Cleaner punctuation")
            ai("3.0")
            author(ais523)
            democratic()

            text(
                """
In rule 2221, change "spelling, grammar," to "spelling, grammar,
punctuation,".

In rule 107, if the penultimate paragraph does not end with a full
stop, append a full stop to it.

In rule 2555, in "A person with 1 or more blots is Impure, a
person with 0 blots is Pure.", change the comma to a semicolon.

In rule 2555, if the second paragraph does not end with a full stop,
append a full stop to it.

[Allow cleaning for punctuation, which currently isn't possible. Also
contains some fixes for punctuation errors I noticed.]"""
            )
        }

        proposal(9308) {
            title("Fix passive SHOULD")
            ai("1.0")
            author(ais523)
            ordinary()

            text(
                """
In rule 2492, change
{{{
If a judge is recused from a case that was continuously open and
assigned to em for at least the past 4 days, e SHOULD NOT be
assigned as a judge until e has apologised and/or reasonably
explained eir actions.
}}}
to
{{{
If a judge is recused from a case that was continuously open and
assigned to em for at least the past 4 days, players SHOULD NOT
assign em as a judge until e has apologised and/or reasonably
explained eir actions.
}}}

[With the current wording, if the Arbitor assigns a judge too early, it
is the judge rather than the Arbitor who has violated the SHOULD, which
is not what we want. "Players" rather than "the Arbitor" because there
are some situations where players other than the Arbitor do the
assignment, e.g. if the Referee is handling a CFJ.]"""
            )
        }

        proposal(9309) {
            title("Packing list")
            ai("1.0")
            author(Murphy)
            ordinary()

            text(
                """
Amend Rule 2499 (Welcome Packages) by replacing this text:

       A player CAN, by announcement, cause a specified player to receive
       a welcome package (syn. "grant" em a welcome package).

with this text:

       A player CAN, by announcement, cause a specified player to receive
       a welcome package (syn. "grant" em a welcome package), and SHOULD
       specify the assets thus gained."""
            )
        }
    }
}
