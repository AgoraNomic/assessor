package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals

@UseAssessment
fun assessment9197to9201() = assessment {
    name("9197-9201")
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
                "Speaker"(0) heldBy ais523
                "Spendor"(1) heldBy null
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy null
            }
        }
    }

    proposals(v4) {
        proposal(9197) {
            title("The Game is Afoot")
            ai("1.5")
            author(Mischief)
            coauthors(ais523, Kate)
            ordinary()

            text(
                """
[Maybe this could be a way to spur some more gameplay.

The underlying idea:
Spendies -> candles (contest subgames) -> radiance

Players can still buy radiance directly, they still get a universal
basic income in spendies, etc.

Candles are a shelf-stable form of radiance but can only be held by
contests. 1 spendie grants 1 candle; 1 candle grants 1 radiance.

Under this model, Bang! could be reconstituted as a contest if folks
wished.]


Create a rule entitled "Contests" with power 1.5 reading:

       Contestation is a secured negative boolean contract switch
       tracked by the Notary. A contract whose contestation switch is
       true is a contest.

       A player CAN flip a specified contract's contestation to true
       without 2 objections.

       A player CAN flip a specified contract's contestation to false
       with Agoran consent.


Create a rule entitled "Candles" with power 1.5 reading:

       Candles are fixed fungible assets tracked by the Illuminator.

       Contests are the only entities permitted to own candles, and any
       candles held by any other entity are immediately destroyed.

       A player CAN pay a fee of 1 spendie to grant 1 candle to a
       contest.

       As explicitly and unambiguously permitted by a contest's body, a
       party to that contest CAN bestow a prize by an announcement
       clearly identifying the recipient player, the amount of radiance
       to award (N), and the relevant contest. Upon doing so, if the
       specified contest possesses at least N candles the following
       happen in order: N of its candles are destroyed, then the
       specified player gains N radiance."""
            )
        }

        proposal(9198) {
            title(null)
            ai("1.0")
            author(Forest)
            ordinary()

            text(
                """
Replace all instances of "Absurdor" with "Door"."""
            )
        }

        proposal(9199) {
            title("Rare Stamps, Differently")
            ai("1.0")
            author(Mischief)
            ordinary()

            text(
                """
[This is a different approach than I took with the June proposal. Rare
stamps just seem like too good of a concept to not do *something* with
them. For what it's worth, as of the submission of this proposal no
player is eligible to claim the title (several folks are tied).]

Create a rule entitled "Stamp Scamp" reading:

       A rare stamp is a stamp that is the only one of its type that
       exists.

       Upon a correct announcement that a specified player owns more
       rare stamps than any other player, the following happen in order:

         1) that player is awarded the patent title Stamp Scamp if e
         does not already hold it

         2) the patent title Stamp Scamp is revoked from any other
         person holding it

       Once per quarter a player holding the Stamp Scamp patent title
       CAN, by announcement, cause another specified player to gain one
       stamp of that specified player's type."""
            )
        }

        proposal(9200) {
            title("Rebalancing")
            ai("1.0")
            author(Mischief)
            coauthors(ais523)
            ordinary()

            text(
                """
Amend rule 2659 (Stamps) by replacing:

       Any player CAN, once per week, pay X Stamps, where each specified
       Stamp is a different type, to gain (X^2)-X radiance.

with:

       Any player CAN, once per week, pay X stamps, where each specified
       stamp is a different type, to gain (X-1)*3 radiance."""
            )
        }

        proposal(9201) {
            title("Vox Populi > Vox Fortunae")
            ai("1.5")
            author(snail)
            coauthors(Mischief)
            ordinary()

            text(
                """
[Spendies drive a number of game mechanics, and radiance drives wins.

This proposal explicitly terminates any ongoing sortition for either
office; R2691 probably does that too, but this is extra assurance.]


Any ongoing sortition for the office of Illuminator or the office of
Spendor immediately ends with no selection; any duty to select an option
with respect to such a sortition is discharged.

Amend rule 2656 (Radiance) by replacing "a sortitioned" with "an"

Amend rule 2690 (Spendies) by replacing "a sortitioned" with "an""""
            )
        }
    }
}
