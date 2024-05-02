package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment9096to9101() = assessment {
    name("9096-9101")
    quorum(7)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            complexityBonuses {
                maxBonus(3)

                "Absurdor"(0) heldBy juan
                "ADoP"(1) heldBy Murphy
                "Arbitor"(2) heldBy nix
                "Arbitor"(1) heldBy Gaelan
                "Assessor"(3) heldBy Janet
                "Collector"(2) heldBy null
                "Distributor"(0) heldBy omd
                "Geologist"(1) heldBy null
                "Herald"(2) heldBy snail
                "Illuminator"(1) heldBy null
                "Notary"(2) heldBy snail
                "Prime Minister"(0) heldBy Jimmy
                "Promotor"(3) heldBy snail
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy snail
                "Stonemason"(1) heldBy Janet
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy null
            }
        }
    }

    proposals(v4) {
        proposal(9096) {
            title("Stone cleanups v3")
            ai("2.0")
            author(Janet)
            ordinary()

            text(
                """
Amend Rule 2451 ("Executive Orders") by deleting the list item
(including the bullet point) that contains "Growth". Amend Rule 2645
("The Stones") by, as a single amendment:

* Deleting the list item (including the bullet point) that contains
"Anti-Equatorial Stone", the list item (including the bullet point) that
contains "Loud Stone", and the list item (including the bullet point)
that contains "Protection Stone".

* Replacing each instance of the text "non-immune stone" with "stone".

* In the list item containing "Hot Potato Stone", deleting from " If
this stone is not owned by Agora" (inclusive) to the end of the list item.

[Growth and the Anti-Equatorial Stone depend on mossiness, which no
longer exists. The Loud Stone depends on Dreams, which no longer exist.
The Protection Stone depends on immunity, which no longer Next, Also,
clean up references to immunity. Finally, the Hot Potato Stone no longer
needs to restrict transference, as stones are now fixed.]"""
            )
        }

        proposal(9097) {
            title("Festival strength restrictions")
            ai("3.0")
            author(Janet)
            democratic()

            text(
                """
Amend Rule 2481 ("Festival Restrictions") by replacing "Each Festive
player has the maximum possible voting strength. All other players have
the minimum possible voting strength." with "Each Festive player has the
maximum possible voting strength. Each person who is not a Festive
player has the minimum possible voting strength. Rules to the contrary
notwithstanding, no modifications to voting strength (other than
defining the maximum and minimum) are applied by any other Rule.".

[Clarify that setting strength to the maximum/minimum cannot then be
altered with Blots or bonuses, since it's currently unclear whether the
method of calculation in R2422 applies. Additionally, don't allow
non-Festive players to escape the penalty by deregistering.]"""
            )
        }

        proposal(9098) {
            title("Welcome Spendies")
            ai("1.0")
            author(snail)
            ordinary()

            text(
                """
Amend Rule 2499 (Welcome Packages) by replacing

{
* One stamp of eir own type.
}

with

{
* One stamp of eir own type.
* 10 spendies, if e has not been granted any spendies since e last
registered.
}"""
            )
        }

        proposal(9099) {
            title("Quantum Superstone")
            ai("2.0")
            author(snail)
            ordinary()

            text(
                """
Amend Rule 2645 (The Stones) by appending the following:

{
      - Quantum Superstone (quarterly, 5): When wielded, Agora is Fluxed;
Fluxing is secured. If Agora has been Fluxed in the past 7 days,
immediately after a stone is wielded, that stone and the Quantum Superstone
switch owners.
}"""
            )
        }

        proposal(9100) {
            title("Spending Stone")
            ai("2.0")
            author(snail)
            ordinary()

            text(
                """
Amend Rule 2645 (The Stones) by appending the following:

{
      - Spending Stone (weekly, 3): When wielded, the wielder is granted X
spendies, where X is the number of other stones wielded before it in the
same message.
}"""
            )
        }

        proposal(9101) {
            title("Unstable Stone")
            ai("2.0")
            author(snail)
            ordinary()

            text(
                """
Amend Rule 2645 (The Stones) by appending the following:

{
      - Unstable Stone (weekly, 3): When wielded, a specified crystal's
instability is increased by 3.
}"""
            )
        }
    }

    voting {
        votes(snail) {
            FOR on 9096
            endorse(Janet) on 9097
            FOR on 9098
            FOR on 9099
            FOR on 9100
            FOR on 9101
        }

        votes(Janet) {
            FOR on 9096
            FOR on 9097
            FOR on 9098
            AGAINST on 9099
            AGAINST on 9100
            AGAINST on 9101
        }

        votes(Murphy) {
            endorse(Janet) on 9096 comment "${Janet.name} is the Stonemason"
            FOR on 9097
            FOR on 9098
            endorse(Janet) on 9099 comment "${Janet.name} is the Stonemason"
            endorse(Janet) on 9100 comment "${Janet.name} is the Stonemason"
            endorse(Janet) on 9101 comment "${Janet.name} is the Stonemason"
        }

        votes(Jaff) {
            FOR on 9096
            FOR on 9097
            FOR on 9098
            AGAINST on 9099
            PRESENT on 9100
            PRESENT on 9101
        }

        votes(wunst) {
            FOR on 9096
            FOR on 9097
            FOR on 9098
            FOR on 9099
            AGAINST on 9100
            FOR on 9101
        }
    }
}
