@file:Suppress("MISSING_DEPENDENCY_SUPERCLASS_IN_TYPE_ARGUMENT")

package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.FOR

@UseAssessment
fun assessment9250to9253() = assessment {
    name("9250-9253")
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
        proposal(9250) {
            title("Re-fee")
            ai("3.0")
            author(Janet)
            coauthors(Kate)
            democratic()

            text(
                """
Amend Rule 2579 by, as a single amendment (failing as a whole if any
step fails):

* Replacing the paragraph beginning "To use a fee-based method" with the
following paragraph:

{

To use a fee-based method, an entity (the Actor) who is otherwise
permitted to perform the action must announce that e is performing that
action; such announcement must clearly and unambiguously set forth
intent to pay a fee for the sole purpose of using that method to perform
that action. Additionally, such announcement must either clearly and
unambiguously specify the correct set of assets for that fee or use
simplified wording (e.g. "I buy X") that makes the intended fee
reasonably clear and unambiguous (in particular, without stating an
incorrect fee).

}

* Replacing the text "If the Rules specify a recipient for the fee, and
the Actor CAN transfer that specified fee from emself to the recipient"
with the text "If the Rules specify a recipient for the relevant fee,
and the Actor CAN transfer that fee from emself to the recipient"

* Replacing "and the Actor CAN destroy the specified fee in eir
possession" with "and the Actor CAN destroy the relevant fee in eir
possession".


[More closely mirror the "by announcement" standard, remove the crime
(instead simply making the attempt ineffective), and fix a bug:
references to the "specified fee" later in the rule are now wrong, since
the fee is not always specified. This second version also adds missing
clarity requirements.]"""
            )
        }

        proposal(9251) {
            title("Regulated simultaneity")
            ai("3.0")
            author(Janet)
            democratic()

            text(
                """
Amend Rule 478 by replacing the text "Allowing actions performed by
sending a message to take place simultaneously" with the text "Allowing
regulated actions performed by sending a message to take place
simultaneously".

[Clarify an old wording ambiguity that ais523 pointed out that
potentially makes this restriction overbroad.]"""
            )
        }

        proposal(9252) {
            title("Thesis requirements")
            ai("2.0")
            author(Trigon)
            ordinary()

            text(
                """
To rule 1367 "Degrees", add a paragraph before the one beginning
"Degrees SHOULD be awarded" which reads:

===
The Herald is ENCOURAGED to enact administrative regulations including
specific guidelines on how to submit theses, a detailed description of
the peer-review process, and specific qualifications for degrees in
general and for specific degrees.
===

Comment: This comes from a discussion on Discord in which several
people, both established players and newer Agorans, expressed
discontentment with how requirements to submit a thesis for a degree are
communicated to players. Although Administrative Regulations have a
visibility problem, this is at least one way to help with that."""
            )
        }

        proposal(9253) {
            title("The Tower")
            ai("1.0")
            author(snail)
            ordinary()

            text(
                """
Enact a new Rule with a power of 1, the title "A Seed", and the following
text:

{{{
In the center of Agora, there is a tower. But it has not yet been completed.

A seed at its base begs for the nourishment it requires: pyrite.

An integer switch this seed does possess, its "magical essence", with a
default of 0 and a maximum of 100. When it reaches this maximum, the seed
will grow.

Each player can, by paying a fee of 100 pyrite, feed the tower, which
increases the seed's magical essence by 1.

And when the seed grows, as fate demands, this Rule takes effect, by
enacting a new Rule, with title "The Tower", a power of 1, and 4 paragraphs
of text provided by the greatest architects, and it should be looked upon
with AWE.

The greatest architects are those persons which have fed the tower the most
times, and also provided a paragraph. The architect in first supplies the
first paragraph, specifying its text by announcement. E NEED NOT specify
that it is the first paragraph, merely that it is a paragraph meant to be
engraved on the tower's walls. The same is true for the architect in second
and the second paragraph, the third and the third, the fourth and the
fourth.

In the event of a tie, should such a conflict arise, the tie will be broken
with the person possessing more radiance being greater, and if conflict
still, greater in pyrite, then in time since each last registered.

If 4 paragraphs cannot be determined, a grave outcome indeed, then each
paragraph that can be determined is included instead of all 4 in balance,
and the tower SHOULD be looked upon with MUCH FEAR.

It would be wise to engrave words of power on the tower, for it will be the
source of all magic in Agora. Interlopers may seek to change the engravings
after its construction, but doing so is ILL-ADVISED, and may result in dark
forces being unleashed on the perpetrators.

And when fate has come to pass, after the seed has grown, and the tower
demands to be looked on with AWE or FEAR, only then will this rule take
effect to repeal itself, and the age of magic will be upon Agora, for
BETTER or WORSE.
}}}"""
            )
        }
    }

    voting {
        votes(juan) {
            FOR on 9250
            FOR on 9251
            FOR on 9252
            FOR on 9253
        }

        votes(Automaticat) {
            FOR on 9250
            FOR on 9251
            FOR on 9252
            FOR on 9253
        }
    }
}
