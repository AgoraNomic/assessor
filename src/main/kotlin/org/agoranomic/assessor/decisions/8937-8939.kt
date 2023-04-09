package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.*
import org.agoranomic.assessor.lib.vote.VoteKind.AGAINST
import org.agoranomic.assessor.lib.vote.VoteKind.FOR

@UseAssessment
fun assessment8937to8939() = assessment {
    name("8937-8939")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            powerDream(nix, 2)
            powerDream(Janet, 2)
            powerDream(snail, 2)

            powerStone(Janet, 3)
        }

        complexityBonuses {
            maxBonus(3)

            "ADoP"(1) heldBy Murphy
            "Arbitor"(2) heldBy G
            "Assessor"(3) heldBy Janet
            "Collector"(1) heldBy nix
            "Distributor"(0) heldBy omd
            "Dream Keeper"(1) heldBy snail
            "Herald"(2) heldBy nix
            "Horsened"(1) heldBy snail
            "Mad Engineer"(1) heldBy Janet
            "Notary"(2) heldBy snail
            "Prime Minister"(0) heldBy nix
            "Promotor"(3) heldBy snail
            "Referee"(2) heldBy null
            "Registrar"(1) heldBy juan
            "Rulekeepor"(3) heldBy Janet
            "Speaker"(0) heldBy Janet
            "Stonemason"(1) heldBy Janet
            "Tailor"(1) heldBy Murphy
            "Webmastor"(1) heldBy Forest
        }
    }

    proposals(v4) {
        proposal(8937) {
            title("Reification")
            ai("1.0")
            author(Forest)
            ordinary()

            text(
                """
Enact the following rule:
{
A device is an asset defined by the rules.
Devices are tracked by the Mad Engineer's assistant.
}

Grant each player a Reified Device."""
            )
        }

        proposal(8938) {
            title("Aspen's Idea")
            ai("1.0")
            author(Forest)
            coauthors(Aspen)
            ordinary()

            text(
                """
>From Discord, Aspen hath dothly proposeth that
I yonder pass such a proposal as thus:
{
Light the rules on fire and officer's must wear
polka-dotted hats every third Tuesday.
}

Glitter: I don't gain 5 radiance when
this proposal passes.
Aspen gains an additional 4 radiance
when this proposal passes."""
            )
        }

        proposal(8939) {
            title("Simpler Charity Distribution Calculation")
            ai("2.0")
            author(nix)
            ordinary()

            text(
                """
[The current calculations are needlessly complex. These calculations are
simpler and hopefully still fair.]

Amend R2675 by replacing:

       - Charity: A Charity Stamp is a stamp of the type that the L&FD
         owns the most of (if there is a tie, the first the L&FD owned,
         and if still tied, the first alphabetically). Immediately after
         a wandering, for each Charity Dreamer, in reverse order of when
         eir Dream was last flipped (and in reverse order of registration
         if tied), one Charity Stamp is transferred from the L&FD to em.
         If the number of Stamps the L&FD owned during the last wandering
         is greater than 10, this process happens a second time. If it is
         more than 20, this process happens a third time.

with:

         - Charity: Immediately after a wandering, one stamp (chosen by
         most-to-least owned by the L&FD at time of transfer, tie-broken
         alphabetically) is transferred to each Charity Dreamer (in order
         from least-to-most stamps owned, tie-broken alphabetically) from
         the L&FD. If the number of Stamps the L&FD owned during the last
         wandering is greater than 10, this process happens a second
         time. If it is more than 20, this process happens a third time."""
            )
        }
    }

    voting {
        votes(snail) {
            FOR on 8937
            AGAINST on 8938
            FOR on 8939
        }

        votes(Janet) {
            AGAINST on 8937
            AGAINST on 8938
            endorse(nix) on 8939
        }
    }
}
