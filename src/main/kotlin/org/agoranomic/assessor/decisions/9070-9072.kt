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
import org.agoranomic.assessor.lib.vote.commented
import org.agoranomic.assessor.lib.vote.finalResolution
import org.agoranomic.assessor.lib.vote.voteIfVoted

@UseAssessment
fun assessment9070to9072() = assessment {
    name("9070-9072")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            powerDream(Aris, 2)
            powerDream(Yachay, 2)
            powerDream(Jimmy, 2)

            complexityBonuses {
                maxBonus(3)

                "Absurdor"(0) heldBy juan
                "ADoP"(1) heldBy Murphy
                "Arbitor"(2) heldBy nix
                "Assessor"(3) heldBy Janet
                "Collector"(2) heldBy snail
                "Distributor"(0) heldBy omd
                "Dream Keeper"(1) heldBy snail
                "Geologist"(1) heldBy null
                "Herald"(2) heldBy snail
                "Illuminator"(1) heldBy snail
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
        proposal(9070) {
            title("Criminalize Egregious Miscommunication")
            ai("1.0")
            author(Yachay)
            ordinary()

            text(
                """
Create a new rule, at Power 1, with the name "Egregious Miscommunication"
with this content:

"A person shall not egregiously miscommunicate. Actions that qualify for
this include and are not limited to:
- Using obscure languages, alphabets, etc for the apparent main purpose of
hindering some text's interpretation.""""
            )
        }

        proposal(9071) {
            title("Loud Stone")
            ai("2.0")
            author(snail)
            ordinary()

            text(
                """
Amend Rule 2645 (The Stones) by appending the following paragraph:
{
- Loud Stone (monthly, 4): When wielded, a specified player's Dream is set
to a specified Dream, and then e is Beguiled; Beguiling is secured. A
player's Dream CANNOT be flipped if e was Beguiled in the last 7 days,
rules to the contrary notwithstanding.
}"""
            )
        }

        proposal(9072) {
            title("Vacations v4")
            ai("3.0")
            author(snail)
            coauthors(nix, Janet, Forest, Yachay, G, juan, Murphy, ais523)
            democratic()

            text(
                """
[This proposal adds Vacations and Delegation, which encourage officers
to take time off and give the responsibility to someone else for a
while. Not only is this intended to reduce burnout for officers, but it
is also intended to be an opportunity for other players to learn an
office without fully committing to it. snail's note: this version allows a
delegate to resign by announcement. This should work fine: anyone can then
become the delegate with Agoran Consent, or by the officer making an intent
to give another player delegate (perhaps their second choice).]

Amend R2438 by replacing "Cyan (C): When a person deputises for an
office" with "Cyan (C): When a person deputises for an office or is the
delegate for an office while its holder is on vacation."

Enact a new Power=3 rule titled "Vacations & Delegation" with the
following text:

    Delegate is an Office switch with possible values of "None" and
    any active player, and default value of "None". Delegates are
    tracked by the ADoP in eir weekly report.

    A player CAN flip the Delegate switch of a specified office to
    emself with Agoran Consent. If the Delegate switch of an office is
    set to "None", the holder of that office CAN flip the Delegate
    switch of that office to a specified player with support from that
    specified player.

    An officer CAN and SHOULD take a Vacation from a specified office e
    has continuously held for over 6 months with 7 day notice, if e has
    not done so in the last year. When an officer qualifies for a
    Vacation, the ADoP SHOULD encourage em to take one, at least once a
    quarter.

    An officer is On Vacation from a specified office if e has taken a
    Vacation from that office in the last 30 days. The list of officers
    currently on vacation is part of the ADoP's report.

    While the holder of an office is On Vacation, the Delegate of that
    office CAN perform an action ordinarily reserved for the office-holder
    as if e held the office, if it would be POSSIBLE for the Delegate to
    perform the action, other than by this method, if e held the office.

    Rules to the contrary notwithstanding, while an officer is On
    Vacation that officer NEED NOT comply with any duties of that
    office, and the Delegate, if any, SHALL comply with all duties of
    the office as if e held the office.

    The Delegate of an office CANNOT resign it. E CAN, by announcement,
flip the Delegate
    switch of that office to "None"."""
            )
        }
    }

    voting {
        votes(snail) {
            AGAINST on 9070
            FOR on 9071
            FOR on 9072
        }

        votes(Murphy) {
            PRESENT on 9070

            function { ctx ->
                if (
                    listOf(FOR, AGAINST).contains(
                        ctx.resolve(ctx.currentProposal, snail)?.finalResolution(ctx)?.voteIfVoted,
                    )
                ) {
                    endorse(snail).commented("${snail.name} is the Dream Keeper and voted FOR or AGAINST")
                } else {
                    endorse(Janet).commented("${Janet.name} is the Assessor, and Dream Keeper ${snail.name} did not vote FOR or AGAINST")
                }
            } on 9071

            FOR on 9072
        }

        votes(kiako) {
            AGAINST on 9070
            AGAINST on 9071
            endorse(ais523) on 9072
        }

        votes(Ben) {
            AGAINST on 9070
            FOR on 9071
            FOR on 9072
        }

        votes(Gaelan) {
            AGAINST on 9070
            endorse(snail) on 9071
            endorse(snail) on 9072
        }
    }
}
