package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment8870to8872() = assessment {
    name("8870-8872")
    quorum(4)

    proposals(v4) {
        proposal(8870) {
            title("Stone fixes")
            ai("2.0")
            author(Janet)
            coauthors(nix)
            ordinary()

            text(
                """
# Convergence of P8868

If Rule 2642 is not titled "Gathering Stones", retitle to "Gathering
Stones".

If Rule 2642 does not have the following text, amend it to read, in
whole:
{
  A player who has not possessed a stone in the last 30 days CAN, by
  announcement, transfer the mossiest stone (if there is a tie, then
  a specified stone tied for mossiest) Agora owns to emself. E
  SHOULD specify the stone when doing so.
}

# Remove the concept of "scroll"s as a document, which may or may
# not work, and replace it with more wishy-washy "description of
# properties", which includes continuous effects like voting
# strength.
#
# Also, secure wielding.

Amend Rule 2640 by replacing the text "A scroll, which is a document
specifying the effects of the stone" with the text "A description of
the stone's properties".

Amend Rule 2641 by replacing the final paragraph with the following
paragraphs:
{
  When a stone is wielded, the Rule defining that stone applies any
  effects that it defines as occurring when the stone is wielded.

  The wielding of stones is secured.
}

Amend Rule 2645 ("The Stones") to read, in whole:
{
  The following stones are defined, one per paragraph, with the
  following format: Stone Name (Frequency, Smoothness): Description.

  - Power Stone (weekly, 2): When this stone is wielded, a specified
    player (defaulting to the wielder if not specified) is Power
    Stoned; Power Stoning is secured. A player's voting strength on
    a referendum on an ordinary proposal is increased by 3 for each
    time that e was Power Stoned during the referendum's voting
    period.

  - Soul Stone (weekly, 3): When wielded, the Soul Stone is
    transferred to the owner of a different specified non-immune
    stone, then that stone is transferred to the wielder.

  - Sabotage Stone (weekly, 4): When wielded, the adoption index of
    a specified AI-majority Agoran decision is increased by 1.

  - Jockey Stone (monthly, 3): When wielded, a specified Running
    horse's Race Position is increased by 1.

  - Protection Stone (monthly, 4): When wielded, a specified stone
    is granted immunity.

  - Recursion Stone (Monthly, 4): The Recursion Stone can be wielded
    once per month as if it had the power of any other stone of your
    choice.

  - Hot Potato Stone (Weekly, 5):  When this stone is wielded, the
    wielder specifies an eligible player and gains 8 points. The
    stone is transferred to the eligible player. An eligible player
    is one who has not owned this stone since the last time Agora
    owned it. If this  stone is not owned by Agora, it cannot
    otherwise be transferred, other rules notwithstanding. This
    stone is immune if 3 or more players have wielded it since the
    most recent collection notice.

  - Blank Stone (Monthly, 0): This stone has no effect.

  - Mason's Stone (None, 0): If the Mason's Stone is owned by the
    Stonemason, its Mossiness is continuously set to 0. If the
    Mason's Stone is owned by Agora, it is transferred to the
    Stonemason.

  - Anti-Equatorial Stone (Monthly, 5): When wielded, the mossiest
    stone is transferred to the wielder. When this happens, the
    Anti-Equatorial Stone's mossiness is incremented by 1.

  - Score Stone (Weekly, 3): When wielded, a specified player's
    (defaulting to the wielder if not specified) Score is increased
    by 3.
}"""
            )
        }

        proposal(8871) {
            title("Unintuitive Rule Changes Fix")
            ai("3.0")
            author(nix)
            democratic()

            text(
                """
Amend the text of R105 ("Rule Changes") by replacing:

       5. retitle a rule.

with:

       5. retitle (syn. amend the title of) a rule."""
            )
        }

        proposal(8872) {
            title("Anti-Capitalists Dream of Stamp Collecting")
            ai("2.1")
            author(nix)
            coauthors(G, Janet, ShyOwl)
            ordinary()

            text(
                """
Set each coin balance to their values in the Nov 13th, 2022 Treasuror
report.

Set each Stamp balance to their values in the Nov 12th, 2022 Collector
report.

For each player, increase eir score by X/Y*100 (rounded up), where X is
eir coin balance and Y is the total buoyancy.

Repeal the following rules in the order they are listed: R2456 (The
Treasuror), R2483 (Economics), R2545 (Auctions),  R2634 (Buoyancy
Control), R2635 (Floating Rate Fleet), R2559 (Paydays), R2666 (L&FD
Auctions), R2649 (Vocal Voter Verification Award), R2496 (Rewards), and
R2631 (Charities).

Amend R2585 (Birthday Gifts) by replacing:

        During a player's Agoran Birthday and the 7 days following, each
        other player CAN once acknowledge that person's birthday by
        announcement.  Doing so grants the birthday player 3 boatloads of
        coins if it is actually the day of the player's birthday, and 2
        otherwise.

        Players are ENCOURAGED to announce their Agoran Birthdays.

with:

        In a timely manner after the start of a player's Agoran Birthday,
        the Herald SHALL announce it.

Amend R2499 (Welcome Packages) by removing:

        * 10 boatloads of coins, AND

Amend R2656 (Points) by replacing:

       Upon a correct announcement from a player that one or more players
       have a score of 100+ points, all players meeting this condition
       win the game.  If a least one player wins the game via such an
       announcement, the scores of the winning players are set to their
       default, and then all other players' scores are set to half their
       current value rounded down.

with:

        Upon a correct announcement from a player that e has a score of
        100 or more points, e wins the game. Then, eir score is set to 0,
        and all other players' scores are set to half their current value
        rounded down.

and removing:

        The Herald CAN once each, by announcement, grant 15, 10, and 5
        boatloads of coins to the players who had the most, second most,
        and third most points (respectively) at the end of the previous
        quarter. E SHALL do so in a timely manner after the beginning of
        the quarter.

Amend R2581 (Official Patent Titles) by removing:

        - Tycoon, awardable by the Treasuror to any player who executes a
          novel economic or contractual enterprise that has a significant
          impact on the game, especially if it involves leveraging
          synergies for win-win outcomes for the benefit of multiple
          players.

Amend R2657 (Scoring) by replacing:

          * Having an Agoran Birthday: 15 (Herald).

          * Receiving any patent title: 10 (Herald).

          * Receiving a ribbon: 5 (Tailor).

with:

          * Having an Agoran Birthday: X, where X is the number of active
            players during eir birthday (Herald).

and adding:

          * Judging a CFJ that e was assigned to without violating a time
            limit to do so, unless at the time of judgement the case was
            open due to self-filing a motion to reconsider it: 2
            (Arbitor).

Amend R2659 (Stamps) by removing "and Agora" and replacing:

         Any player CAN pay 3 boatloads of coins to grant a specified
         player 1 Stamp of the granter's own type.

         Any player CAN pay 1 Stamp of eir own type to grant emself 1
         boatload of coins.

         Any player CAN pay 1 Stamp of another person's type to grant
         emself 2 boatloads of coins.

with:

         Any player CAN, once per week, pay X Stamps, where each
         specified Stamp is a different type, to increase eir own score by
         (X^2)-X points.

         Any player CAN, once per week, pay X Stamps, where each Stamp is
         the same type, to increase eir own score by (X-1)*2 points.

Amend R2675 (Dream of Wandering) to read in full:

        The Dream Keeper is an office; its holder is responsible for
        keeping track of the dreams of all active players.

        Dream is a secured active player switch, tracked by the Dream
        Keeper in eir weekly report, with possible values any Dream,
        defaulting to Wandering.

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
          wandering, for each player with the Charity Dream, in reverse
          order of when eir Dream was last flipped (and in reverse order
          of registration if tied), one item of the Charity type is
          transferred from the L&FD to em.

        - Justice: Immediately after a wandering, 1 blot is expunged from
          each player with the Justice Dream. If a player with the Justice
          Dream had no blots immediately after a wandering, e CAN once
          expunge one blot, by announcement, from a specified player
          before the next wandering.

        - Sharing: Immediately after a wandering, each player with the
          Sharing Dream has eir points increased by X / Y, rounded down,
          where X is half the number of active players, rounded up, and Y
          is the number of players with the Sharing Dream.

        - Wealth: Immediately after a wandering, X stamps of eir own type
          are granted to each player with the Wealth Dream. When less
          than 8 Stamps of eir type exist, X is 2. When 8 to 15 Stamps of
          eir type exist, X is 1. When 16 ore more Stamps of eir type
          exist, X is 0.

        - Machinery: A player with the Machinery Dream CAN Flip the Device
          with Agoran Consent. A player with the Machinery Dream CAN take
          a specified action on behalf of the the device with 1 support.

        - Gardens: Once per week, a player with the Gardens Dream CAN, by
          announcement, transfer the mossiest stone (if there is a tie,
          then a specified stone tied for mossiest) Agora owns to emself.
          E SHOULD specify the stone when doing so.

        - Power: The voting strength of a player with the Power Dream has
          eir voting strength increased by 2 for referenda on ordinary
          proposals.

        - Revolution: A revolution is happening if the majority of Dreams
          are set to Revolution. Immediately after a wandering, if a
          revolution is not happening, then all players with the
          Revolution Dream have eir score decreased by 1 to a minimum of
          0. Immediately after a wandering, if a revolution is happening,
          then all players have eir score set to 100-X, where X was eir
          score when the wandering occured, and all player's Dreams are
          set to Wandering.

snail becomes the Dream Keeper.

Amend R2632 (Complexity) by adding the following paragraph to the end:

        For each office a player holds, eir voting strength is increase
        by the complexity of the office for referenda on ordinary
        proposals, up to a maximum increase of 3 by this method."""
            )
        }
    }
}