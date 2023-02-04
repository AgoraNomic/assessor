package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8885to8887() = assessment {
    name("8885-8887")
    quorum(3)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
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
                "Prime Minister"(0) heldBy Murphy
                "Promotor"(3) heldBy snail
                "Referee"(2) heldBy null
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
        proposal(8885) {
            title("Nerfed Mason's Stone buff")
            ai("2.0")
            author(Janet)
            ordinary()

            text(
                """
Amend Rule 2645 ("The Stones") by replacing the list item beginning
"Mason's Stone" with the following:

{

- Mason's Stone (Monthly, 0): If the Mason's Stone is owned by the
Stonemason, its Mossiness is continuously set to 0. If the Mason's Stone
is owned by Agora, it is transferred to the Stonemason. When wielded, the
mossiest stone owned by Agora (or, if there is a tie, a specified stone tied
for the same) is transferred to the wielder.

}

[Currently, I'm effectively locked out of owning any actually useful
stone without setting a Dream, which isn't really fair. If I attempt to
get rid of the Mason's stone, it can be forcibly transferred back to me
or will eventually be automatically transferred back to me, resetting
the 30 day time limit again. I can't pawn it off on an inactive player,
since only active players can hold stones, and if I transfer it to an
active player I reset their stone delay, likely angering them and
probably just getting it transferred back. This change would allow me to
actually participate in the part of the stone game that allows doing
things with stones.]"""
            )
        }

        proposal(8886) {
            title("Mason's Stone repeal")
            ai("2.0")
            author(Janet)
            ordinary()

            text(
                """
Amend Rule 2645 ("The Stones") by removing the list item beginning
"Mason's Stone (None, 0)".

[Only has effect if none of the buff proposals passed.]"""
            )
        }

        proposal(8887) {
            title("Schrodinger's Horse")
            ai("1.0")
            author(Murphy)
            coauthors(ais523)
            ordinary()

            text(
                """
Amend Rule 2672 (Weekly Race Action) by replacing this text:

       * get a jersey for a specified horse, also specifying a horse to
         be added to that horse's pull, by paying 1 hoof.

with this text:

       * get a jersey for a specified horse by paying 1 hoof, also
         specifying a horse which is thereby added to that horse's pull,
         by paying 1 hoof.

Amend Rule 2674 (Horse Powers) by replacing this text:

       Nacho's power: (WEEKLY POWER)  * get a jersey for a specified
       horse, also specifying a horse to be added to another specified
       horse's pull, by paying 1 hoof.

with this text:

       Nacho's power: (WEEKLY POWER)  * get a jersey for a specified
       horse, also specifying a horse which is thereby added to another
       specified horse's pull, by paying 1 hoof."""
            )
        }
    }

    voting {
        votes(snail) {
            AGAINST on 8885
            FOR on 8886
            FOR on 8887
        }

        votes(juan) {
            PRESENT on all
        }

        votes(nix) {
            AGAINST on 8885 comment "Janet is the Stonemason"
            endorse(Janet) on 8886 comment "Janet is the Stonemason"
            PRESENT on 8887
        }

        votes(Janet) {
            FOR on 8885
            FOR on 8886
            PRESENT on 8887
        }
    }
}
