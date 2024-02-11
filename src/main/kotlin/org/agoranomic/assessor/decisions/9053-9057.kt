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
fun assessment9053to9057() = assessment {
    name("9053-9057")
    quorum(3)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            powerDream(Aris, 2)
            powerDream(Yachay, 2)
            powerDream(Goren, 2)
            powerDream(Jimmy, 2)

            complexityBonuses {
                maxBonus(3)

                "Absurdor"(0) heldBy juan
                "ADoP"(1) heldBy Murphy
                "Arbitor"(2) heldBy Kate
                "Assessor"(3) heldBy Janet
                "Collector"(1) heldBy snail
                "Distributor"(0) heldBy omd
                "Dream Keeper"(1) heldBy snail
                "Geologist"(1) heldBy Forest
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
        proposal(9053) {
            title("(none)")
            ai("1.0")
            author(Jimmy)
            ordinary()

            text(
                """
Enact a new rule with a title of "TAXES" and the following text: Taxes
are anything that forcefully reduces a players radiance. A player SHALL NOT
submit any proposals to enact taxes."""
            )
        }

        proposal(9054) {
            title("Agoran Christmas")
            ai("1.0")
            author(Forest)
            coauthors(Jimmy)
            ordinary()

            text(
                """
Enact the following rule ("Agoran Christmas"):
{
Agoran Christmas is an anti-holiday existing every February 29th.
In the month leading to Agoran Christmas, Krampus is an office, responsible
for tracking the naughty list monthly. If the naughty list is ever not
tracked, it is empty.

Whenever a player votes AGAINST a proposal to repeal a rule, they are put
onto the naughty list.
Every week, Krampus CAN announce that e is collecting taxes, specifying all
the players on the naughty list, and all players not on the naughty list.
By doing so, the naughty players have their radiance reduced by 10, and the
radiance of the other players are increased by the amount the naughty
player's lost, divided evenly between them, rounded down.
}
PUT EVERY PLAYER WHO VOTES AGAINST THIS RULE ONTO THE NAUGHTY LIST!"""
            )
        }

        proposal(9055) {
            title("Radiance Day")
            ai("1.0")
            author(Maloney)
            ordinary()

            text(
                """
Enact the following:
February 29 is a Holiday known as Radiance Day.

At 00:00 UTC on Radiance Day, all players are awarded 10 Radiance."""
            )
        }

        proposal(9056) {
            title("Vacations")
            ai("3.0")
            author(nix)
            coauthors(Janet, Forest, Yachay, G, juan, Murphy)
            democratic()

            text(
                """
[This proposal adds Vacations and Delegation, which encourage officers
to take time off and give the responsibility to someone else for a
while. Not only is this intended to reduce burnout for officers, but it
is also intended to be an opportunity for other players to learn an
office without fully committing to it.]

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
    switch of that office to a specified player with notice.

    An officer CAN and SHOULD take a Vacation from a specified office e
    has continuously held for over 6 months with 7 day notice, if e has
    not done so in the last year. When an officer qualifies for a
    Vacation, the ADoP SHOULD encourage em to take one, at least once a
    quarter.

    An officer is On Vacation from a specified office if e has taken a
    Vacation from that office in the last 30 days. The list of officers
    currently on vacation is part of the ADoP's report.

    While the holder of an office is On Vacation, the Delegate of that
    office can act as if e is the holder of the Office.

    Rules to the contrary notwithstanding, while an officer is On
    Vacation that officer NEED NOT comply with any duties of that
    office, and the Delegate, if any, SHALL comply with all duties of
    the office as if e held the office."""
            )
        }

        proposal(9057) {
            title("Vacations v2")
            ai("3.0")
            author(snail)
            coauthors(nix, Janet, Forest, Yachay, G, juan, Murphy)
            democratic()

            text(
                """
[This proposal adds Vacations and Delegation, which encourage officers
to take time off and give the responsibility to someone else for a
while. Not only is this intended to reduce burnout for officers, but it
is also intended to be an opportunity for other players to learn an
office without fully committing to it.
Snail's note: edited to reduce the ability to abuse the system, delegates
are now opt-in only, so players can't be forced to be a delegate. Also
further specified the deputization-like acting as an officer a delegate
does.]

Amend R2438 by replacing "Cyan (C): When a person deputises for an
office" with "Cyan (C): When a person deputises for an office or is the
delegate for an office while its holder is on vacation."

Enact a new Power=3 rule titled "Vacations & Delegation" with the
following text:

{
    Delegate is an Office switch with possible values of "None" and
    any Delegatable player, and default value of "None". Delegates are
    tracked by the ADoP in eir weekly report. Delegatable is a negative
    boolean player switch tracked by the ADoP. A player CAN flip their
    Delegatable switch to True or False by announcement.

    A player CAN flip the Delegate switch of a specified office to
    emself with Agoran Consent. If the Delegate switch of an office is
    set to "None", the holder of that office CAN flip the Delegate
    switch of that office to a specified player with notice.

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
}"""
            )
        }
    }

    voting {
        votes(snail) {
            FOR on 9053
            AGAINST on 9054
            FOR on 9055
            AGAINST on 9056
            FOR on 9057
        }

        votes(nix) {
            PRESENT on 9053
            AGAINST on 9054
            PRESENT on 9055
            FOR on 9056
            AGAINST on 9057
        }

        votes(Janet) {
            AGAINST on 9053
            AGAINST on 9054
            AGAINST on 9055
            endorse(nix) on 9056
            endorse(nix) on 9057
        }

        votes(Forest) {
            FOR on all
        }

        votes(kiako) {
            AGAINST on 9053
            AGAINST on 9054
            PRESENT on 9055
            // TODO: resolve conditional on 9056 AGAINST if 9057 to be adopted, else FOR
            FOR on 9057
        }

        votes(Mercury) {
            PRESENT on 9053
            AGAINST on 9054
            FOR on 9055
            AGAINST on 9056
            FOR on 9057
        }
    }
}
