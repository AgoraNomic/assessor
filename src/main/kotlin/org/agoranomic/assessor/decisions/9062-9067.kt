package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.*
import org.agoranomic.assessor.lib.vote.VoteKind
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment9062to9067() = assessment {
    name("9062-9067")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            powerDream(Aris, 2)
            powerDream(Yachay, 2)
            powerDream(Jimmy, 2)

            powerStone(Janet, 3)

            complexityBonuses {
                maxBonus(3)

                "Absurdor"(0) heldBy juan
                "ADoP"(1) heldBy Murphy
                "Arbitor"(2) heldBy Kate
                "Assessor"(3) heldBy Janet
                "Collector"(2) heldBy snail
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
        proposal(9062) {
            title("Insurance Policy")
            ai("2.0")
            author(kiako)
            coauthors(ais523)
            ordinary()

            text(
                """
Amend Rule 2640 ("Stones") by removing "active" from the following:

   Ownership of stones is entirely restricted to Agora and active players.

Then, amend Rule 2642 ("Gathering Stones") by replacing "an active player"
with "a player" in the following:

   Base Rockiness is an active player switch,

and by replacing "each player" with "each active player" in the following:

   Once a week each player CAN "reach" for a specified stone owned by Agora
by announcement.

[ Comment: ais523 raised the interesting point in the Discord/IRC that
"inactive" used to be an option when a player would be away for a while,
but now spells an economic death sentence, which this aims to alleviate. ]"""
            )
        }

        proposal(9063) {
            title("Dreaming of a Return Home")
            ai("2.0")
            author(kiako)
            coauthors(ais523)
            ordinary()

            text(
                """
Amend Rule 2675 ("Dream of Wandering") by removing "active" from each of
the following:

   keeping track of the dreams of all active players.

from paragraph 1,

   Dream is * active player switch,

from paragraph 2, where * is "a secured" or "an" (respecting the outcome of
snail's clapping)

   every active player's Dream is set to the value

from paragraph 3

[ Comment: furthering the "inactive as an option" position to include
dreams. "Sharing" and "Revolution" behave a little strangely, but I believe
it will work out fine. Furthermore, it is intentional that only active
players may envision eir dream, and it is intentional that snail's clapping
is not modified to affect inactive players. ]"""
            )
        }

        proposal(9064) {
            title("Carving Canyons")
            ai("2.0")
            author(kiako)
            coauthors(snail)
            ordinary()

            text(
                """
Amend Rule 2675 ("Dream of Wandering") by adding the following dream below
"Gardens"

- Erosion: The rockiest player is the non-Erosion Dreamer with the maximum
Base Rockiness (tie-broken alphabetically). Immediately after a wandering
occurs, if the total sum of Base Rockiness of Erosion Dreamers is less than
X-Y, where X is the Base Rockiness of the rockiest player, and Y is the
number of Erosion Dreamers, then decrease the Base Rockiness of the
rockiest player by Y-1, and increase the base rockiness of each Erosion
Dreamer by 1.

[ Comment: snail receives a co-authorship as e brought to my attention the
concern with the other two proposals that a player might stockpile Base
Rockiness for eir return. This inhibits that effort, and also introduces a
stronger interaction between reaching and a player's choice of Dream. ]"""
            )
        }

        proposal(9065) {
            title("")
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

        proposal(9066) {
            title("No Taxation Without Representation")
            ai("2.0")
            author(Forest)
            ordinary()

            text(
                """
[Currently, democratic proposals can pass even if the quorum is much lower
than the number of active players. This means that democratic proposals
have the potential to not represent a representative amount of them.
Democratic proposals should not only meet a high adoption index, but should
also meet that adoption index with representation.]

Amend Rule 2606 ("Proposal Classes") by appending "The quorum of a
democratic proposal is 2/3 of the active players, rounded down.""""
            )
        }

        proposal(9067) {
            title("Vacations v3")
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
office without fully committing to it. snail's note: added a simple consent
check of having to support becoming a delegate, instead of the changes i
did before. Also still changed the deputization-like clause.]

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
    the office as if e held the office."""
            )
        }
    }

    voting {
        votes(snail) {
            FOR on 9062
            AGAINST on 9063
            FOR on 9064
            FOR on 9065
            AGAINST on 9066
            FOR on 9067
        }

        votes(kiako) {
            FOR on 9062
            FOR on 9063
            FOR on 9064
            AGAINST on 9065
            AGAINST on 9066
            FOR on 9067
        }

        votes(Janet) {
            endorse(ais523) on 9062
            endorse(ais523) on 9063
            AGAINST on 9064
            AGAINST on 9065
            AGAINST on 9066
            endorse(nix) on 9067
        }

        votes(Yachay) {
            AGAINST on 9062
            AGAINST on 9063
            FOR on 9064
            FOR on 9065
            FOR on 9066
            AGAINST on 9067
        }

        votes(ais523) {
            FOR on 9062
            FOR on 9063
            PRESENT on 9064
            AGAINST on 9065
            AGAINST on 9066
            // TODO resolve conditional vote: PRESENT if 9062 and 9063 enactable, else AGAINST
        }

        votes(Mercury) {
            FOR on 9062
            PRESENT on 9063
            PRESENT on 9064
            FOR on 9065
            FOR on 9066
            PRESENT on 9067
        }
    }
}
