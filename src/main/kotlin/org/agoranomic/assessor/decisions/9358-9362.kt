package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.endorseOfficer
import org.agoranomic.assessor.dsl.votes.endorseOrElse
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment9358to9362() = assessment {
    name("9358-9362")
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
                "Collar"(1) heldBy Mischief
                "Collector"(2) heldBy Mischief
                "Distributor"(0) heldBy omd
                "Executor"(1) heldBy Mischief
                "Herald"(2) heldBy snail
                "Illuminator"(1) heldBy Cosmo
                "Land Managor"(1) heldBy Murphy
                "Notary"(2) heldBy null
                "Numerator"(1) heldBy Trigon
                "Prime Minister"(0) heldBy Kate
                "Promotor"(3) heldBy Cosmo
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy ais523
                "Spendor"(1) heldBy Murphy
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy kiako
            }
        }
    }

    proposals(v4) {
        proposal(9358) {
            title("The Pyrite Preservation Proposal v2")
            ai("1.5")
            author(Galle)
            ordinary()

            text(
                """
Amend Rule 2711 ("Outshining the Sun") by replacing the following text:
---
* All Pyrite is destroyed.
---
With the following text:
---
* All Pyrite in eir possession is destroyed.
* Half of all Pyrite in each other player's possession, rounded up, is
destroyed.
* For each player with more than 4000 Pyrite, all but 4000 Pyrite in
their possession is destroyed.
---"""
            )
        }

        proposal(9359) {
            title("Anyone can make a festival!")
            ai("3.1")
            author(msh210)
            coauthors(Cosmo)
            democratic()

            text(
                """
Amend Rule 2480 ("Festivals", power 3.1) by adding the
following sentence

{
For any integer N greater than Agora's Festivity, any player CAN flip
Agora's Festivity to N with 5 support from N-Festive players, unless
Agora's Festivity has had a value greater than or equal to N in the
past 21 days.
}

immediately after and in addition to the existing sentence

{
For any integer N greater than Agora's Festivity, an N-Festive player
CAN flip Agora's Festivity to N with 4 support from other N-Festive
players, unless Agora's Festivity has had a value greater than or
equal to N in the past 21 days.
}

(I don't see why such a person would want to do so, but if e does then
I don't see any reason to stop em.)"""
            )
        }

        proposal(9360) {
            title("Veblen Economics")
            ai("1.0")
            author(msh210)
            ordinary()

            text(
                """
Rule 2695 is amended so the paragraph

 > A player CAN pay a fee of X spendies, where X is an integer not less
 > than the current Veblen cost, to set the Veblen cost to X+1. When e
 > does so, if e does not own the Veblen, the Veblen is transferred to
 > em.

reads instead

 > A player CAN pay a fee of X spendies, where X is an integer not less
 > than the current Veblen cost, to set the Veblen cost to X+1. When e
 > does so, if e does not own the Veblen, then (a) the Veblen is
 > transferred to em, and (b) the player who thereby loses the Veblen,
 > if any, is granted half of X Spendies, rounded down."""
            )
        }

        proposal(9361) {
            title("Senseless Inflation")
            ai("1.0")
            author(msh210)
            ordinary()

            text(
                """
A player whose vote on this proposal evaluates to FOR is granted 1
Spendie at the time the proposal takes effect."""
            )
        }

        proposal(9362) {
            title("Rebalanced Operands")
            ai("1.0")
            author(Galle)
            coauthors(Murphy)
            ordinary()

            text(
                """
Create a new power 1 rule, entitled "Operators", with the following text:
---
Operator is a player switch, tracked by the Numerator, with values Sum
(default), Difference, and Product.

Once per month, a player CAN flip eir Operator by announcement.
---

Amend rule 2714 ("Spending Number Cards") by replacing the second
paragraph with the following text:
---
For any two decimal digits X and Y (which may be the same), a player CAN:

* If eir Operator is Product, pay 5 spendies, an X card, and a Y card to
grant emself a number card with a type equal to the last digit of the
product X * Y.
* If eir Operator is Sum, pay 6 spendies, an X card, and a Y card to
grant emself a number card with a type equal to the last digit of the
sum X + Y.
* If eir Operator is Difference, pay 8 spendies, an X card, and a Y card
to grant emself a number card with a type equal to the last digit of the
difference X - Y.
---"""
            )
        }
    }

    voting {
        votes(Galle) {
            FOR on 9358
            FOR on 9359
            FOR on 9360
            FOR on 9361
            FOR on 9362
        }

        votes(Salad) {
            FOR on 9358
            FOR on 9359
            PRESENT on 9360
            AGAINST on 9361
            endorseOfficer("Numerator", Trigon) on 9362
        }

        votes(pizza723) {
            FOR on 9358
            FOR on 9359
            FOR on 9360
            AGAINST on 9361
            AGAINST on 9362
        }

        votes(Forest) {
            FOR on 9358
            FOR on 9359
            FOR on 9360
            FOR on 9361
            FOR on 9362
        }

        votes(Mischief) {
            FOR on 9358
            FOR on 9359
            AGAINST on 9360
            FOR on 9361
            endorseOrElse(Trigon, AGAINST) on 9362 comment "${Trigon.name} is the Numerator"
        }

        votes(msh210) {
            FOR on all
        }

        votes(Janet) {
            AGAINST on 9358
            PRESENT on 9359
            AGAINST on 9360
            AGAINST on 9361
            AGAINST on 9362
        }

        votes(Trigon) {
            PRESENT on 9358
            FOR on 9359
            PRESENT on 9360
            // TODO resolve conditional vote on 9361: FOR in msh210 has transferred Trigon at least 1 spendy in a message containing the text "Senseless Bribery"
            AGAINST on 9362
        }

        votes(ais523) {
            FOR on 9358
            AGAINST on 9359
            FOR on 9360
            // TODO resolve conditional vote on 9361: AGAINST if affects outcome (or indeterminate), else FOR
            PRESENT on 9362
        }

        votes(Murphy) {
            FOR on 9358
            FOR on 9359
            FOR on 9360
            FOR on 9361
            endorseOfficer("Numerator", Trigon) on 9362
        }
    }
}
