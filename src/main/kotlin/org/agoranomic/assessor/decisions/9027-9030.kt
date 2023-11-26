package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.dsl.votes.powerDream
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment9027to9030() = assessment {
    name("9027-9030")
    quorum(3)

    strengths {
        default(3)
        min(0)
        max(15)

        blotPenalty(Forest, 3 / 3)

        onOrdinaryProposals {
            powerDream(Aris, 2)
            powerDream(Yachay, 2)

            complexityBonuses {
                maxBonus(3)

                "Absurdor"(0) heldBy juan
                "ADoP"(1) heldBy Murphy
                "Arbitor"(2) heldBy null
                "Assessor"(3) heldBy Janet
                "Collector"(1) heldBy snail
                "Distributor"(0) heldBy omd
                "Dream Keeper"(1) heldBy snail
                "Herald"(2) heldBy snail
                "Illuminator"(1) heldBy null
                "Notary"(2) heldBy snail
                "Prime Minister"(0) heldBy Janet
                "Promotor"(3) heldBy snail
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy ais523
                "Stonemason"(1) heldBy Janet
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy null
            }
        }
    }

    proposals(v4) {
        proposal(9027) {
            title("De-Escalating the Hole")
            ai("3.0")
            author(Kate)
            coauthors(snail)
            democratic()

            text(
                """
Amend Rule 869 by replacing the following text:

      An Unregistered person CAN (unless explicitly forbidden or
      prevented by the rules) register

with:

      An Unregistered person CAN (unless explicitly forbidden or
      prevented by Rules of power 3 or greater) register"""
            )
        }

        proposal(9028) {
            title("Fairness in Crime Act")
            ai("2.0")
            author(Janet)
            ordinary()

            text(
                """
Amend Rule 2478 ("Justice") by, as a single amendment:

{

Replacing "Within 14 days of an infraction being committed," with
"Within 14 days of an infraction being committed, or if the infraction
has been noted in the past 60 days,".

Then, replacing "any other player in the last 7 days" with "any other
player in the last 14 days".

}

[Harmonize the time limits to investigate and to note, and ensure a
noted infraction can always be investigated beyond the time limit to do
so (allowing deputization).]


Amend Rule 2531 ("Defendant's Rights") by, as a single amendment:

{

Appending a semicolon to the list item numbered (1), if it does not
already end in a semicolon.

Then, deleting the trailing " or" from the list item numbered (4).

Then, appending " or" to the list item numbered (5).

Then, appending the following to the first list: { (6) any available
non-null punishment would be blatantly and obviously unsuited to the
conduct which constitutes the infraction or to the person who committed
the infraction. }

Then, appending the following to the rule:

{

Rules to the contrary notwithstanding, any attempt to investigate an
infraction which would result in the creation of blots is INEFFECTIVE if:

(1) it does not include the specific reason for the fine; or

(2) it would result in a punishment that is blatantly and obviously
unsuited to the conduct which constitutes the infraction or to the
person who committed the infraction.

}

}

[Restore the old "blatantly and obviously unsuited" standard to protect
defendants.]"""
            )
        }

        proposal(9029) {
            title("Sharing takes Care")
            ai("2.0")
            author(snail)
            coauthors(Zipzap)
            ordinary()

            text(
                """
//comment: Changes "points" to "Radiance"

Amend Rule 2675 (Dream of Wandering) to read, in full:

{

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

      - Charity: Immediately after a wandering, one stamp (chosen by
        most-to-least owned by the L&FD at time of transfer, tie-broken
        alphabetically) is transferred to each Charity Dreamer (in order
        from least-to-most stamps owned, tie-broken alphabetically) from
        the L&FD. If the number of Stamps the L&FD owned during the last
        wandering is greater than 10, this process happens a second
        time. If it is more than 20, this process happens a third time.

      - Justice: Immediately after a wandering, 1 blot is expunged from
        each Justice Dreamer. If a Justice Dreamer had no blots
        immediately after a wandering, e CAN once expunge one blot, by
        announcement, from a specified player before the next wandering.

      - Sharing: Immediately after a wandering, each Sharing Dreamer has
        eir Radiance increased by X / Y, rounded down, where X is half the
        number of active players, rounded up, and Y is the number of
        Sharing Dreamers.

      - Wealth: Immediately after a wandering, X stamps of eir own type
        are granted to each Wealth Dreamer. When less than 8 Stamps of
        eir type exist, X is 2. When 8 to 15 Stamps of eir type exist, X
        is 1. When 16 ore more Stamps of eir type exist, X is 0.

      - Gardens: Immediately after a wandering, the Base Rockiness of
        each Gardens Dreamer is increased by 1.

      - Power: Each Power Dreamer has eir voting strength increased by 2
        for referenda on ordinary proposals.

      - Revolution: A revolution is happening if the majority of active
        players are Revolution Dreamers. Immediately after a wandering,
        if a revolution is not happening, then all Revolution Dreamers
        have eir radiance decreased by 1 to a minimum of 0. Immediately
        after a wandering, if a revolution is happening, then all
        players have eir radiance set to 100-X, where X was eir radiance
        when the wandering occurred, and all player's Dreams are set to
        Wandering.

}"""
            )
        }

        proposal(9030) {
            title("(n/a)")
            ai("1.0")
            author(Forest)
            ordinary()

            text(
                """
The Geologist is the office that tracks crystals.
Each crystal is a liquid asset.
Each crystal has three secured natural integer switches,
one of which is the size, the second is its identity,
and the third is the instability.
The default size of a crystal is 1.
The default instability of a crystal is 0.
Each Quarter, the size is increased by 3 of all crystals with
identifiers that don't match any rule number in the current ruleset.

Once for each rule a proposal amends or repeals:
- If a crystal with an identity equal to the number of that rule
  exists, combine that proposal with that crystal.
- Otherwise, grant the author of the proposal a crystal with the
  identity equal to the number of that rule, and size equal
  to the power of that proposal, rounded up to the nearest integer.

Whenever a proposal and a crystal combine:
- Increase the size of the crystal by the power of the proposal,
  rounded up to the nearest integer.
- If the proposal's author doesn't own the crystal,
  increase the instability of the crystal by 3.
- If the instability is larger than the size of the
  crystal, transfer the crystal to the author of the proposal, and
  reduce the instability of the crystal to its size.

A player CAN, by announcement, Shatter the System, and attempting to
specify all crystallized players, provided that no player has won the
game by doing so in the past 30 days. An player is crystallized if
it owns crystals with a total size greater than or equal to the
number of rules in the current ruleset.

When the System is Shattered, all crystallized players win the game.
If a player won the game in this manner 4 or more days ago, any
player CAN repeal this rule by announcement."""
            )
        }
    }

    voting {
        votes(snail) {
            FOR on 9027
            FOR on 9028
            FOR on 9029
            AGAINST on 9030
        }

        votes(nix) {
            FOR on 9027
            PRESENT on 9028
            PRESENT on 9029
        }

        votes(Janet) {
            FOR on 9027
            FOR on 9028
            AGAINST on 9029
            AGAINST on 9030
        }

        votes(Forest) {
            FOR on 9027
            FOR on 9028
            FOR on 9029
        }
    }
}
