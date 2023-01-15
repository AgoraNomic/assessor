package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment8878to8884() = assessment {
    name("8878-8884")
    quorum(3)

    strengths {
        default(3)
        min(0)
        max(15)

        // Note: R2632's attempted strength changes are ineffective at power 1.
    }

    proposals(v4) {
        proposal(8878) {
            title("Clearer Dream Text")
            ai("2.0")
            author(nix)
            ordinary()

            text(
                """
[This is a minor change to everything. Instead of saying "a player with
the X Dream", this version defines "X Dreamer" to mean that, and then
uses that in each description for brevity/clarity. Also tweaked Power's
wording.]

Amend R2675 (Dream of Wandering) to read in full:

       The Dream Keeper is an office; its holder is responsible for
       keeping track of the dreams of all active players.

       Dream is a secured active player switch, tracked by the Dream
       Keeper in eir weekly report, with possible values any Dream,
       defaulting to Wandering. An "X Dreamer" is a player with eir Dream
       switch set to X.

       An active player CAN "envision" eir own Dream, specifying any
       valid value for eir Dream, by announcement. When the rules state
       that the wandering occurs, every active player's Dream is set to
       the value e most recently envisioned. If a player did not envision
       a dream since the last wandering, it is not flipped.

       A wandering occurs at the beginning of each week.

       The following is an exhaustive list of all Dreams and the rules
       relevant to each dream:

       - Wandering: This dream has no effect.

       - Charity: The Charity Item is the item type that the L&FD owns
         the most of (if there is a tie, the first the L&FD owned, and if
         still tied, the first alphabetically). Immediately after a
         wandering, for each Charity Dreamer, in reverse order of when
         eir Dream was last flipped (and in reverse order of registration
         if tied), one item of the Charity type is transferred from the
         L&FD to em.

       - Justice: Immediately after a wandering, 1 blot is expunged from
         each Justice Dreamer. If a Justice Dreamer had no blots
         immediately after a wandering, e CAN onceexpunge one blot, by
         announcement, from a specified player before the next wandering.

       - Sharing: Immediately after a wandering, each Sharing Dreamer has
         eir points increased by X / Y, rounded down, where X is half the
         number of active players, rounded up, and Y is the number of
         Sharing Dreamers.

       - Wealth: Immediately after a wandering, X stamps of eir own type
         are granted to each Wealth Dreamer. When less than 8 Stamps of
         eir type exist, X is 2. When 8 to 15 Stamps of eir type exist, X
         is 1. When 16 ore more Stamps of eir type exist, X is 0.

       - Machinery: A Machinery Dreamer CAN Flip the Device with Agoran
         Consent. A Machinery Dreamer CAN take a specified action on
         behalf of the the device with 1 support.

       - Gardens: Once per week, a Gardens Dreamer CAN, by announcement,
         transfer the mossiest stone (if there is a tie, then a specified
         stone tied for mossiest) Agora owns to emself. E SHOULD specify
         the stone when doing so.

       - Power: Each Power Dreamer has eir voting strength increased by 2
         for referenda on ordinary proposals.

       - Revolution: A revolution is happening if the majority of active
         players are Revolution Dreamers. Immediately after a wandering,
         if a revolution is not happening, then all Revolution Dreamers
         have eir score decreased by 1 to a minimum of 0. Immediately
         after a wandering, if a revolution is happening, then all
         players have eir score set to 100-X, where X was eir score when
         the wandering occured, and all player's Dreams are set to
         Wandering."""
            )
        }

        proposal(8879) {
            title("Mason's Stone buff")
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
is owned by Agora, it is transferred to the Stonemason. When wielded, a
specified stone owned by Agora that is not the single mossiest stone
owned by Agora is transferred to the wielder.

}"""
            )
        }

        proposal(8880) {
            title("Complex, but clear")
            ai("1.0")
            author(Janet)
            ordinary()

            text(
                """
Amend Rule 2632 by replacing "The ADoP CAN, with 2 Agoran consent, flip
the complexity of an office." with "The ADoP CAN, with 2 Agoran consent,
flip the complexity of an office to a specified possible value."."""
            )
        }

        proposal(8881) {
            title("Effective complexity")
            ai("2.0")
            author(Janet)
            ordinary()

            text(
                """
Set the power of Rule 2632 ("Complexity") to 2.0.

Amend Rule 2632 ("Complexity") by replacing "Complexity is an office
switch" with "Complexity is a secured office switch"."""
            )
        }

        proposal(8882) {
            title("Referee referral reporting")
            ai("2.0")
            author(Janet)
            ordinary()

            text(
                """
Amend Rule 2246 ("Submitting a CFJ to the Referee") by replacing the
second paragraph with the following:

{

When a CFJ is submitted to the Referee, the Referee receives all
obligations and powers, other than obligations to report, for that case
that the Arbitor would otherwise receive due to being Arbitor. This rule
takes precedence over Rules that would otherwise assign duties and
powers regarding to a judicial case to the Arbitor.

}


[Excludes reporting duties from being transferred to the Referee during
referral, which has caused some weirdness in the past (this also heavily
suggests that numbering should be done by the Arbitor, but that isn't
formalized). Also, cleans up the precedence language.]"""
            )
        }

        proposal(8883) {
            title("Increased weathering v2")
            ai("2.0")
            author(Janet)
            ordinary()

            text(
                """
Amend Rule 2640 ("Stones") by replacing "When a stone is transfered"
with "When a stone is transferred from Agora to a player or from a
player to Agora".


[

Disallows resetting mossiness by transferring from one player to another.

v2: Still reset Mossiness on transfers to Agora so that it's last in the
queue to be claimed.

]"""
            )
        }

        proposal(8884) {
            title("A Bit Warmed Up")
            ai("1.0")
            author(snail)
            ordinary()

            text(
                """
Amend Rule 2670 (Horse Victory) by replacing

* The score of the player that has the most dollaries is increased
        by 15.  In the event of a tie, instead, no score change occurs.

with

* The score of the player that has the most dollaries is increased
        by 30.  In the event of an N-way tie, instead, each tied
        player's score is increased by 30/N points, rounded down."""
            )
        }
    }

    voting {
    }
}
