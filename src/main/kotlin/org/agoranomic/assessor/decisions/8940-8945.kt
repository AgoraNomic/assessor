package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.dsl.votes.powerDream
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8940to8945() = assessment {
    name("8940-8945")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            powerDream(Forest, 2)
            powerDream(G, 2)
            powerDream(Aspen, 2)
            powerDream(Janet, 2)

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
                "Mad Engineer"(1) heldBy null
                "Notary"(2) heldBy snail
                "Prime Minister"(0) heldBy nix
                "Promotor"(3) heldBy snail
                "Referee"(2) heldBy Forest
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy Janet
                "Stonemason"(1) heldBy Janet
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy Forest
            }
        }
    }

    proposals(v4) {
        proposal(8940) {
            title("¯\\_(ツ)_/¯")
            ai("1.0")
            author(Forest)
            ordinary()

            text(
                """
Uh oh, gotta submit something!
Gotta get those proposal points CA-CHING!
(Never let the proposal pool be bare,
lest me be no worse than a simple chair.)

Amend "Welcome Packages" (Rule 2499) by appending
{
- 20 dollaries
}
to the list of assets.

(I remember joining in the middle of a race and decided not to
play for this race, which... is still the current race.
I also would like everyone to consider repealing racing in general,
as I don't see many players taking weekly race actions other
than ais523 and snail...
but that is a separate story.)"""
            )
        }

        proposal(8941) {
            title("Ascetics")
            ai("1.0")
            author(Yachay)
            ordinary()

            text(
                """
Enact the following rule:

{

Asceticism is a negative boolean person switch tracked by the Herald. A
player with an Asceticism of true is an Ascetic.


A player CAN by announcement flip their Asceticism to a specified valid
value if e has not done so in the previous 30 days.


If an Ascetic's radiance is greater than from what eir radiance was when e
most recently became an Ascetic, it is immediately set to that value.


Once per week, an Ascetic CAN Meditate by announcement. When e does so, e
gains 2 stamp of eir own type if e most recently became an Ascetic more
than 30 days ago; otherwise, e gains 1 stamp of eir own type.

}"""
            )
        }

        proposal(8942) {
            title("Cleaning")
            ai("3.0")
            author(Forest)
            democratic()

            text(
                """
Amend Rule 2573 ("Impeachment") by replacing "otherwise shown emself
unworthy the trust of Agora."
with "otherwise shown emself unworthy of the trust of Agora."

Amend "Mother, May I?" (Rule 2152)
by replacing { "SHOULD } with { SHOULD }"""
            )
        }

        proposal(8943) {
            title("Ritual rewrite")
            ai("1.0")
            author(Janet)
            coauthors(G)
            ordinary()

            text(
                """
Amend Rule 2680 to read, in whole:
{

Each of the following is a ritual act:
- Issuing a Cabinet Order.
- Assigning a judgement to a CFJ.
- Publishing the first report of a given Rules-defined type in an Agoran
week, provided such publishing fulfilled a Rules-defined duty to publish.
- For each person, eir becoming a candidate in an election for the first
time in an Agoran week.
- For each person, eir submitting a ballot on an Agoran decision for the
first time in an Agoran week.

When a ritual act is performed, any player CAN, within 7 days, by
announcement anoint a ritual number, specifying the ritual act and the
new ritual number. The anointed ritual number must be 0 or not more than
1 greater than the greatest previously anointed ritual number.

When a positive integral multiple of 41 is anointed as a ritual number
for the first time, the person who does so CAN, by announcement, Raise
the First Speaker in a powerful dance around the Town Fountain. Doing so
causes each player qualifying under this Rule to gain 1 radiance.

A player is qualifying under this Rule if and only if e is active, does
not have the highest radiance of any player, and is not tied for the
highest radiance among players.

}"""
            )
        }

        proposal(8944) {
            title("Effecting change")
            ai("2.0")
            author(Janet)
            coauthors(ais523)
            ordinary()

            text(
                """
Amend Rule 1006 by replacing the final paragraph with the following:

{

Immediately after a proposal finishes taking effect, if one or more
offices exist that did not exist prior to the proposal taking effect,
each such office, if it is vacant, becomes held by the author of the
proposal.

}

Amend Rule 2657 by replacing each instance of "proposal that takes
effect" with "proposal that takes effect, at the instant it finishes
taking effect" and by replacing "Having an Agoran Birthday: X, where X
is the number of active players during eir birthday". with "Having an
Agoran Birthday, at the instant it begins: X, where X is the number of
active players at the instant the condition was fulfilled.""""
            )
        }

        proposal(8945) {
            title("Going up")
            ai("2.0")
            author(snail)
            ordinary()

            text(
                """
Amend Rule 2645 (The Stones) by appending the following list item:
{
      - Escalation Stone (quarterly, 2): When wielded, a specified Rule
with a Power of 1.9 or less has its power increased by 0.1.
}

[There are currently no quarterly stones, so how about this?]"""
            )
        }
    }

    voting {
        votes(snail) {
            AGAINST on 8940
            AGAINST on 8941
            endorse(Janet) on 8942
            FOR on 8943
            FOR on 8944
            FOR on 8945
        }

        votes(G) {
            AGAINST on 8940
            AGAINST on 8941
            FOR on 8942
            FOR on 8943
            FOR on 8944
            AGAINST on 8945
        }

        votes(Forest) {
            endorse(Yachay) on 8940
            endorse(G) on 8941
            endorse(nix) on 8942
            AGAINST on 8943
            AGAINST on 8944
            FOR on 8945
        }

        votes(Janet) {
            AGAINST on 8940
            endorse(G) on 8941
            PRESENT on 8942
            FOR on 8943
            FOR on 8944
            AGAINST on 8945
        }

        votes(juan) {
            AGAINST on 8940
            AGAINST on 8941
            FOR on 8942
            FOR on 8943
            endorse(nix) on 8944 comment "nix is the Herald"
            PRESENT on 8945
        }
    }
}
