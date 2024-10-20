package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment9186to9191() = assessment {
    name("9186-9191")
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
                "Speaker"(0) heldBy snail
                "Spendor"(1) heldBy oliver
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy Quadrantal
            }
        }
    }

    proposals(v4) {
        proposal(9186) {
            title("No more stamps for Agora")
            ai("1.0")
            author(kiako)
            ordinary()

            text(
                """
[Agora was given permission to hold stamps by P 9075, but was not reverted
when the raffle was repealed in P 9105. Since there's no economic benefit
to sending stamps to Agora, this is unnecessary complexity.]

Amend Rule 2659 ("Stamps") by replacing
{
   Stamps are a category of asset ownable by players and Agora.
}
with
{
   Stamps are a category of asset ownable by players.
}"""
            )
        }

        proposal(9187) {
            title("Gray Ribbon clarification")
            ai("3.0")
            author(kiako)
            coauthors(Janet, Kate)
            democratic()

            text(
                """
[This is the only rule where "unless e has done so earlier in the month"
is used instead of "Once per month".

This proposal has two consequences:
   - Pending a CFJ (or precedent), the Tailor may be able to award two
Gray Ribbons in the month this is adopted.
   - In a month where the Tailor changes to a new player, e will likely
be unable to award a Gray Ribbon if the prior Tailor had done so that
month, where the previous version may have allowed it.
Seeing as Gray ribbons aren't exactly a hot commodity right now, I think
the simplicity is better than the potential extra award.]

Amend Rule 2438 ("Ribbons")by replacing
{
    The Tailor CAN award a Gray Ribbon by announcement, unless e has done
so earlier in the month.
}
with
{
    Once per month the Tailor CAN award a Gray Ribbon by announcement.
}"""
            )
        }

        proposal(9188) {
            title("Double Default Trouble")
            ai("2.0")
            author(kiako)
            ordinary()

            text(
                """
[No numerical switch uses the "default to 0" fallback, except for
Crystal's identity, which is always set to a different value before it
can be used. Considering the "default to null" fallback, 5 switches
explicitly create and define a "none" instance, and two more define
similar values under different names ("unassigned" and "vacant"). It is
clear then that neither of these fallbacks take on the semantic meaning
of "a default value meant to be used".

In this case, it would make more sense to unambiguously allow Crystal
identity to default to "null", assigning that fallback the semantic
meaning of "This switch must have a default value, but it does not
matter what it is because it is never used in practice."

Janet noted that this would break mathematical operations if a numerical
switch ends up using the default, but under this new semantic meaning I
believe the outcome is what is expected: since "null + 3" is undefined,
the switch fails to be flipped, and remains "null". (Defaulting to 0, on
the other hand, would give the guise that the default should be
considered a usable instance.)]

Amend Rule 2509 ("Agoran Numbers") by removing the following paragraph:
{
     If 0 is in the specified values for a numerical switch and no
default value is otherwise specified, 0 is the default value for that
switch.
}"""
            )
        }

        proposal(9189) {
            title("Did you get a permit for that party?")
            ai("3.0")
            author(Janet)
            coauthors(Kate)
            democratic()

            text(
                """
Amend Rule 2480 ("Festivals") by replacing the final paragraph with the
following paragraph:

{

A player who would be Festive if Agora's Festivity were N CAN flip it to
N (where N is an integer greater than Agora's Festivity) with 4 support
from other players who would be Festive if Agora's Festivity were N,
unless Agora's Festivity has had a value greater than or equal to N in
the past 21 days.

}

and by appending the following sentence to the first paragraph:

{

A Festival is ongoing whenever Agora's Festivity is non-zero.

}

and by replacing each instance of "nonzero" with "non-zero".

[Removes the definition of the action of Starting a Festival, which was
mildly redundant and, more importantly, did not have its POSSIBILITY
secured. Cleans up some other language to be more precise.]


Amend Rule 2481 ("Festival Restrictions") by replacing each instance of
"nonzero" with "non-zero".

[While we're here, normalize this language.]"""
            )
        }

        proposal(9190) {
            title("If there exists a party")
            ai("3.0")
            author(Janet)
            coauthors(Kate)
            democratic()

            text(
                """
Amend Rule 2480 ("Festivals") by replacing the final two paragraphs with
the following paragraphs:

{

A Festive person is a person whose Laudability is greater than or equal
to Agora's Festivity. An N-Festive person is a person who would be
Festive, were Agora's Festivity N.

For any integer N greater than Agora's Festivity, an N-Festive player
CAN flip Agora's Festivity to N with 4 support from other N-Festive
players, unless Agora's Festivity has had a value greater than or equal
to N in the past 21 days.

}

[Adds onto the first proposal ("Did you get a permit for that party?")
by rewriting the same text in slightly more mathematical language. We
think this is clearer than the original rule, but opinions may vary. The
two proposals are written such that this should work even if the first
one doesn't pass.]"""
            )
        }

        proposal(9191) {
            title("Back to the twenties")
            ai("1.0")
            author(snail)
            ordinary()

            text(
                """
Amend Rule 2690 (Spendies) by replacing "every player is granted 15
Spendies" with "every player is granted 20 Spendies"."""
            )
        }
    }

    voting {
        votes(snail) {
            AGAINST on 9186
            FOR on 9187
            FOR on 9188
            FOR on 9189
            FOR on 9190
            FOR on 9191
        }

        votes(Mischief) {
            FOR on 9186
            FOR on 9187
            PRESENT on 9188
            PRESENT on 9189
            PRESENT on 9190
            AGAINST on 9191
        }

        votes(kiako) {
            FOR on 9186
            FOR on 9187
            FOR on 9188
            FOR on 9189
            PRESENT on 9190
            PRESENT on 9191
        }

        votes(Kate) {
            FOR on all
        }

        votes(Janet) {
            FOR on 9186
            PRESENT on 9187
            AGAINST on 9188
            FOR on 9189
            PRESENT on 9190
            AGAINST on 9191
        }

        votes(juan) {
            PRESENT on 9186
            PRESENT on 9187
            PRESENT on 9188
            PRESENT on 9189
            PRESENT on 9190
            FOR on 9191
        }

        votes(lare290) {
            FOR on 9186
            FOR on 9187
            FOR on 9188
            FOR on 9189
            FOR on 9190
            FOR on 9191
        }
    }
}
