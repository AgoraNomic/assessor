package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.AGAINST
import org.agoranomic.assessor.lib.vote.VoteKind.FOR

@UseAssessment
fun assessment9254to9256() = assessment {
    name("9254-9256")
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
        proposal(9254) {
            title("Administrative Publication Act")
            ai("3.0")
            author(Janet)
            coauthors(kiako)
            democratic()

            text(
                """
Amend Rule 2651 ("The Election Cycle") by, as a single amendment
(failing as a whole if any step fails):

* Replacing "the ADoP CAN and SHALL publish a Notice of Election" with
"the ADoP CAN by announcement and SHALL issue a Notice of Election".

* Replacing "Such a notice initiates" with "Doing so initiates".

* Replacing "if there are fewer than 2 term-limited offices, the ADoP
MUST instead list all of them" with "or, if there are fewer than 2 such
offices, all of them".

[The last part is a drive-by fix.]


Amend Rule 2555 ("Blots") by replacing "Once a quarter, the Referee CAN
(and SHALL during its first Eastman week) publish a Notice of Clemency"
with "Once per quarter, the Referee CAN by announcement (and SHALL
during its first Eastman week) issue a Notice of Clemency".

Amend Rule 2656 ("Radiance") by replacing "Once a quarter, the
Illuminator CAN (and SHALL during its first Eastman week) publish a
Notice of Diminution" with "Once per quarter, the Illuminator CAN by
announcement (and SHALL during its first Eastman week) issue a Notice of
Diminution".

[I have always been annoyed by using "CAN publish" as an attempt to
authorize an action. To "publish" is already defined, and we have a
perfectly method for actions taken by sending a message: "by
announcement". I would argue "This is a Notice of X." continues to work
under this standard, since one no longer has to explicitly announce that
e performs a "by announcement" action in order to take it, and saying
that clearly sets forth intent to take the action of "issuing" the Notice.]


If, immediately prior to this proposal taking effect (and under the
ruleset then in effect), the ADoP had published a Notice of Election in
the current quarter, any duty for em to issue a Notice of Election in
the current quarter is discharged.

If, immediately prior to this proposal taking effect (and under the
ruleset then in effect), the Referee had published a Notice of
Clemency in the current quarter, any duty for em to issue a Notice of
Clemency in the current quarter is discharged.

If, immediately prior to this proposal taking effect (and under the
ruleset then in effect), the Illuminator had published a Notice of
Diminution in the current quarter, any duty for em to issue a Notice of
Diminution in the current quarter is discharged.

[Clarify that this proposal does not impose any additional duties in the
current quarter.]


Amend Rule 869 ("How to Join and Leave Agora") by replacing the text "by
publishing a message that indicates reasonably clearly" with "by sending
a public message that indicates reasonably clearly".

[The "message" part of this requirement is already included in the
definition of "publish".]


Amend Rule 2463 ("Motion of No Confidence") to read as follows:

{

Any player CAN, with Agoran consent, cause the office of Prime Minister
to become vacant, provided that the message in which e does so contains
the string "MOTION OF NO CONFIDENCE" in its subject line. Motions of no
confidence SHOULD be used whenever Agorans want to shake things up,
rather than as a personal judgement of the Prime Minister.

}

[Remove the double method ("with Agoran consent" and "by publishing
[...]") by phrasing it as a condition instead. Also, fix a typo
("missing "be" after "SHOULD").]"""
            )
        }

        proposal(9255) {
            title("It's personal")
            ai("3.0")
            author(Janet)
            democratic()

            text(
                """
Amend Rule 2556 ("Penalties") by replacing the text "voting strength of
a player" with the text "voting strength of a person".

[Fix a bug discovered during Agoran't that lets a person dodge a
Blot-based voting strength penalty by deregistering.]"""
            )
        }

        proposal(9256) {
            title("No more apathetic apathy")
            ai("1.0")
            author(Murphy)
            ordinary()

            text(
                """
Amend Rule 2465 (Victory by Apathy) by appending this text:

       Announcing intent to Declare Apathy is the Class 5 Infraction of
       Goldbricking, but this infraction is automatically forgiven if its
       sponsor successfully Declares Apathy on the basis of that intent,
       and SHOULD be forgiven if its sponsor demonstrates that e
       reasonably expected to be able to do so (e.g. by exploiting a bug
       in the rules governing tabled actions, or privately bribing
       players not specified to win, but not simply by announcing intent
       and hoping that no other players checked e-mail for a few days)."""
            )
        }
    }

    voting {
        votes(juan) {
            FOR on 9254
            FOR on 9255
            AGAINST on 9256
        }

        votes(Cosmo) {
            FOR on 9254
            FOR on 9255
            AGAINST on 9256
        }

        votes(Janet) {
            FOR on 9254
            FOR on 9255
            AGAINST on 9256
        }

        votes(Automaticat) {
            FOR on 9254
            FOR on 9255
            AGAINST on 9256
        }

        votes(Trigon) {
            FOR on 9254
            FOR on 9255
            AGAINST on 9256
        }
    }
}
