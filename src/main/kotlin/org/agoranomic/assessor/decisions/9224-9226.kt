package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment9224to9226() = assessment {
    name("9224-9226")
    quorum(7)

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
                "Promotor"(3) heldBy snail
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
        proposal(9224) {
            title("Ruleset ratification")
            ai("3.0")
            author(Janet)
            democratic()

            text(
                """
Ratify the purported short logical ruleset published by Janet on or
about November 19, 2024, 00:11:39 UTC, available at [0].

[0]:
https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2024-November/018147.html


[This proposal is brought to you by Rule 2686. I apparently made some
errors in September that weren't fixed until November, but as far as I
can tell, no ruleset errors have been discovered since then.]"""
            )
        }

        proposal(9225) {
            title("Aneristic Ruleset says what")
            ai("4.0")
            author(Forest)
            democratic()

            text(
                """
Amend "Town Fountain" by replacing "Hail Eris!" with "Hail Aneris!"."""
            )
        }

        proposal(9226) {
            title("Starting of Tournaments and Amendment of Regulations Act")
            ai("3.0")
            author(Janet)
            coauthors(Kate)
            democratic()

            text(
                """
Amend Rule 2493 ("Regulations") by, as a single amendment, doing the
following (failing as a whole if any step fails):
* Replacing the first paragraph with the following:
{
A regulation is a textual entity defined as such by a Rule (its parent
rule) and existing solely because that Rule defines its existence. A
regulation has no effect other than those that the Rules explicitly give
it.
}
* Deleting the sentence beginning "By default, a person CAN".

[Mimic the language for assets with regulations. Change the positive "It
has only the effect that rule explicitly gives it" to a negative version
(to avoid any chance of power escalation), and allow rules other than a
regulation's parent rule to give it effects (e.g. R648 for the Herald's
Administrative Regulations). Remove promulgators; we already specify how
every type of regulation can be changed.]

Amend Rule 2464 ("Tournaments") by, as a single amendment, doing the
following (failing as a whole if any step fails):
* Deleting the sentence "The person who initiates a tournament is its
Gamemaster.".
* Inserting the following sentence before "Once the tournament is
concluded": "When a tournament is initiated, its governing regulations
are enacted.". [This makes clear that R2464 is the parent rule.]
* Appending the following paragraphs:
{
Unless otherwise specified by the tournament's regulations, the
gamemaster of a tournament is the person who initiated it.

A tournament's regulations can provide for the enactment, amendment, and
repeal of regulations for that tournament; if the regulations are
silent, the gamemaster CAN, with 2 Agoran consent, enact, amend, or
repeal such regulations. Any regulations so enacted are deemed to be
regulations of the same tournament.
}
* Replacing the text "freely consent to play the tournament" with
"freely consent to oversee or participate in the tournament".

Amend Rule 2495 ("The Birthday Tournament") by replacing the text
"promulgating a specified, finalized set of tournament regulations" with
the text "specifying a finalized set of governing regulations" and by
deleting the sentence beginning "These regulations may thereafter be
amended".

[

* Allow tournament regulations to provide for changes to themselves.
Regulations are commonly written as if this is permitted, even though it
is not.

* Ensure the clause that makes tournaments binding includes gamemasters.
If a person is made gamemaster of a tournament without eir consent, e
still is not required to abide by the regulations unless e "freely
consent[s]" to it.

]


Hereby, every regulation, as defined under the ruleset in effect
immediately before this proposal began taking effect, that has never
been repealed and that existed at that time exists in the same form and
is of the same type as it was at that time.

Hereby, every regulation that has never been repealed and that was
originally enacted pursuant to the initiation of a tournament is deemed
to be a regulation of that same tournament for the purposes of Rule 2464.

[Explicitly maintain existing regulations.]"""
            )
        }
    }

    voting {
        votes(snail) {
            PRESENT on 9224
            PRESENT on 9225
            FOR on 9226
        }

        votes(kiako) {
            FOR on 9224
            AGAINST on 9225
            FOR on 9226
        }
    }
}
