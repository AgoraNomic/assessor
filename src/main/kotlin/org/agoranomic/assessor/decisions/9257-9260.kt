package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment9257to9260() = assessment {
    name("9257-9260")
    quorum(6)

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
        proposal(9257) {
            title("Truly Indestructible?")
            ai("1.0")
            author(Forest)
            coauthors(kiako, Janet)
            ordinary()

            text(
                """
Amend Rule 2695 "The Veblen" by appending:
{
If the Veblen does not exist, any player CAN,
by announcement, Become All Powerful. When e
does so, e wins the game, and the Veblen is
created in eir possession. A player who wins
in this fashion SHOULD submit a proposal to
prevent the destruction from arising again.
}"""
            )
        }

        proposal(9258) {
            title("paragraph swap")
            ai("3.0")
            author(Cosmo)
            democratic()

            text(
                """
Amend Rule 2201 ("Self-Ratification") by replacing

{
Any person CAN by announcement issue a doubt (syn. claim of
error), identifying a public document published less than 180 days
ago and explaining the scope and nature of a perceived error in it
(or in a statement it attests to).
       The definition of documents as self-ratifying and the definition
of documents as self-ratifying attestations are secured at power
3.
}
with
{
The definition of documents as self-ratifying and the definition
of documents as self-ratifying attestations are secured at power
3.

Any person CAN by announcement issue a doubt (syn. claim of
error), identifying a public document published less than 180 days
ago and explaining the scope and nature of a perceived error in it
(or in a statement it attests to).
}

[The last paragraph begins with "When this happens, ...", which due to
the current order of the paragraphs makes it sound like the actions
described in it need to be done when the definitions are secured, not
when a doubt is issued.]"""
            )
        }

        proposal(9259) {
            title("A reasonable limit")
            ai("1.0")
            author(Janet)
            coauthors(ais523)
            ordinary()

            text(
                """
Amend Rule 2707 ("Pyrite") by replacing "A player CAN pay a fee of 200
Pyrite to gain 1 Spendie." with "A player CAN pay a fee of 200 Pyrite to
gain 1 Spendie, provided that e has gained fewer than 40 Spendies in
this way during this Agoran month."

[Put a hard cap at 3x normal on spendies per month to prevent
Agoriculture from completely dominating the game.]"""
            )
        }

        proposal(9260) {
            title("A reasonable tax")
            ai("1.0")
            author(Janet)
            ordinary()

            text(
                """
Enact a new Rule entitled "Land Tax" at power 1 with the following text:

{

At the beginning of each month, the following occur in order:

* Each player's Pyrite balance is reduced to one half of its current
value (rounded down).

* The Hectare balance of each player with more than 16 Hectares balance
is reduced to 16 + (X - 16)*3/4 (rounded down), where X is eir current
Hectare balance.

}

[Add something to counteract the otherwise-unchecked exponential growth.
This is written to occur automatically at the beginning of each month to
prevent timing scams.]
\"""
            )
        }
    }

    voting {
        votes(juan) {
            FOR on 9257
            PRESENT on 9258
            AGAINST on 9259
            AGAINST on 9260
        }

        votes(Cosmo) {
            FOR on 9257
            FOR on 9258
            PRESENT on 9259
            PRESENT on 9260
        }
    }
}
