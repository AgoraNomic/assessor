package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment9070to9072() = assessment {
    name("9070-9072")
    quorum(5)

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
}
