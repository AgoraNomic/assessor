package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8683to8695() = assessment {
    name("8683-8695")
    quorum(4)

    strengths {
        default(3)
        min(0)
        max(15)
    }

    proposals(v4) {
        proposal(8683) {
            title("Weekly privileges")
            ai("3.0")
            author(Murphy)
            coauthors(ais523)
            ordinary()
            sponsored()

            text("""
[Loosely based on the old Ergs system, basically a currency that was
reset weekly. Repeals or otherwise cleans up some loose ends overlooked
by R2658. Change from proto: Keeps proposal distribution limited.]

Create a rule titled "Proposal Sponsorship" with this text:

      Sponsorship is an untracked proposal switch with values
      unsponsored (default), sponsored, and disinterested.

      The Promotor CAN, with 2+X support, flip a proposal in the
      Proposal Pool from unsponsored to disinterested. For this, X is
      equal to the number of times e has done so in the past 7 days.

      Any player CAN, without objection, flip a proposal in the Proposal
      Pool from unsponsored to disinterested.

Create a rule titled "Weekly Privileges" with Power 2 and this text:

      Each player CAN do one of the following by announcement, provided
      that e has not already done any of them during the same week.

        * Cause a specified person (or emself if no one is specified) to
          Stuff the Ballot Box. A player's Voting Strength on a
          referendum on an ordinary proposal is 1 greater for each time
          e Stuffed the Ballot Box during that decision's voting period.

        * Expunge a blot from a specified person (or emself if no one is
          specified).

        * Cause a specified proposal to become sponsored.

        * Gain an Iridium Star. Iridium Stars are a fixed currency with
          ownership restricted to players. If a player has at least 10
          more Iridium Stars than each other player, and no person has
          won the game this way in the past 30 days, then e CAN Buy the
          Town by announcement. When a player Buys the Town, e wins the
          game, then all Iridium Stars are destroyed.

The winds die down, as defined by Rule 2658 (The Winds Die Down).

[
R2658 then repeals, in this order:
* 2620 (Cards and Sets)
* 2623 (Popular Proposal Proposer Privilege)
* 2629 (Victory Auctions)
* 2624 (Card Administration)
* 2622 (Pending Proposals)
* 2651 (Proposal Recycling)
* 2653 (Buying Strength)
* All clauses delimited ~>like this<~, in rule number order
* itself
]

Repeal these rules, in this order:
* 2621 (VP Wins)
* 2636 (The Ministor)
* 2638 (Player Focuses)

Amend Rule 1607 (Distribution) by replacing this text:

      The Promotor CAN distribute a proposal which is in the Proposal
      Pool at any time.

with this text:

      The Promotor CAN distribute a proposal which is in the Proposal
      Pool at any time, but SHALL NOT do so if it is unsponsored.

[replacing the ~> <~ clause removed by R2658]

Amend Rule 2645 (The Stones) by removing the definition of the
Concentration Stone.

Amend Rule 2654 (The Device) by removing each bullet point containing
"Ministry Focus".

Amend Rule 2665 (The Birds) by replacing the definitions of the Owl,
Pigeon, Penguin, and Jay with the following:

      - Owl: A specified person (or emself if no one is specified)
        Stuffs the Ballot Box, as defined by other rules.

      - Pigeon: A specified person (or emself if no one is specified)
        has one blot expunged.

      - Penguin: The playmate gains an Iridium Star.

      - Jay: A specified proposal becomes sponsored.""")
        }

        proposal(8684) {
            title("Score Gameplay Expansion")
            ai("2.0")
            author(nix)
            ordinary()

            text("""
[This proposal imagines score as a sort of contribution competition.
Every quarter scores decay and awards are given to the leaders. If a
player can gain 100 score, e wins. Score is awarded for participating
in the core mechanics of Agora.]

Set all scores to half their current value rounded up.

Amend 2656 by adding the following paragraphs to the end:

      The Herald CAN once each, by announcement, grant 15, 10, and 5
      boatloads of coins to the players who had the most, second most,
      and third most points (respectively) at the end of the previous
      quarter. E SHALL do so in a timely manner after the beginning
      of the quarter.

      At the start of every quarter, all Scores are set to half their
      current value rounded down.

Amend 2657 by replacing:

      Below is a list of scoring conditions and their associated points
      and officers.

        * Being the author of a sponsored proposal that takes effect:
          1 + the power of the proposal when it takes effect (Assessor).

        * Being the coauthor of a sponsored proposal that takes effect:
          1 (Assessor).

with:

      Below is a list of scoring conditions and their associated points
      and officers.

        * Being the author of a proposal that takes effect: 5
          (Assessor).

        * Being a coauthor of a proposal that takes effect: 1
          (Assessor).

        * Casting an unconditional AGAINST vote on a resolved proposal
          that takes effect, or casting an unconditional FOR vote on a
          resolved proposal that does not take effect: 1 (Assessor)

        * Having an Agoran Birthday: 15 (Herald).

        * Receiving any patent title: 10 (Herald).

        * Receiving a ribbon: 5 (Tailor).""")
        }

        proposal(8685) {
            title("auto-birthday")
            ai("1.0")
            author(G)
            ordinary()
            sponsored()

            text("""
Amend Rule 2585 (Birthday Gifts) by replacing:

      During a player's Agoran Birthday and the 7 days following, each
      other player CAN once grant em X boatloads of coins by
      announcement, where X is 3 if it is actually the day of the
      player's birthday, and 2 otherwise.

with:

      During a player's Agoran Birthday and the 7 days following, each
      other player CAN once acknowledge that person's birthday by
      announcement.  Doing so grants the birthday player 3 boatloads of
      coins if it is actually the day of the player's birthday, and 2
      otherwise.

[Makes the coins automatic without having to know if it's 3 or 2.
"Acknowledge" is the phrase used for Magenta ribbons].""")
        }

        proposal(8686) {
            title("Put a sock in it")
            ai("3.0")
            author(Murphy)
            ordinary()

            text("""
The following rules are repealed in order: R2620 "Cards & Sets",
R2623 "Popular Proposal Proposer Privilege", R2629 "Victory
Auctions", R2624 "Card Administration", R2622 "Pending
Proposals", R2651 "Proposal Recycling", and R2653 "Buying
Strength".

All rules including the text "~>" and "<~" are amended in
ascending numerical order by removing all text between and
including each "~>" and the first following "<~".

Rule 2658 (The Winds Die Down) is repealed.

[Some or all of this may have already occurred, see CFJs 3965
 through 3967. Possibly only rules numbered higher than 2658
 still contain ~> <~ delimited text.]""")
        }

        proposal(8687) {
            title("Might as well")
            ai("1.0")
            author(Secretsnail9)
            ordinary()

            text("""
Enact a new rule with title "snail wins" and text:""")
        }

        proposal(8688) {
            title("Totally Normal Rule")
            ai("1.0")
            author(Secretsnail9)
            coauthors(Madrid)
            ordinary()

            text("""
Enact a new rule with title "Totally normal Rule" and the text:

Cualquier jugador puede ganar el juego pagando una tarifa de 100000 monedas.""")
        }

        proposal(8689) {
            title("Exceptional")
            ai("1.0")
            author(Secretsnail9)
            ordinary()

            text("""
All players that do not have a black ribbon earn a black ribbon.
All players that do have a black ribbon have their scores increased by 10.""")
        }

        proposal(8690) {
            title("Actual Bird Fix")
            ai("1.0")
            author(Secretsnail9)
            ordinary()

            text("""
Amend Rule 2664 (One with Nature) by replacing "player that owns 10 or more
birds" with "player that owns at least 90% of all birds".""")
        }

        proposal(8691) {
            title("Budgie")
            ai("1.0")
            author(Secretsnail9)
            ordinary()

            text("""
Amend Rule 2665 (The Birds) by appending this paragraph to the list of
birds:

       - Budgie: The playmate succumbs.""")
        }

        proposal(8692) {
            title("Canary and Crow")
            ai("1.0")
            author(Secretsnail9)
            ordinary()

            text("""
Amend Rule 2665 (The Birds) by appending these paragraphs to the list of
birds:

       - Canary: The score of a specified player is decreased by 2.

       - Crow: The score of a specified player (defaulting to the playmate
if not specified) is increased by 2.""")
        }

        proposal(8693) {
            title("I just win in this one")
            ai("1.0")
            author(Secretsnail9)
            ordinary()

            text("""
Enact a new rule with title "Very fair rule" and the text:

The player secretsnail CAN win the game by announcement.""")
        }

        proposal(8694) {
            title("Destruction")
            ai("1.0")
            author(Secretsnail9)
            ordinary()

            text("""
Each and every single coin is destroyed.""")
        }

        proposal(8695) {
            title("Creation")
            ai("1.0")
            author(Secretsnail9)
            ordinary()

            text("""
Each player gains 50000 coins.""")
        }
    }

    voting {
        votes(Secretsnail9) {
            // TODO: resolve conditional vote on 8683: FOR if at least 4 unconditional 4 votes, else AGAINST
            AGAINST on 8684
            FOR on 8685
            FOR on 8686
            FOR on 8687
            FOR on 8688
            FOR on 8689
            FOR on 8690
            FOR on 8691
            FOR on 8692
            FOR on 8693
            AGAINST on 8694
            FOR on 8695
        }

        votes(juan) {
            FOR on 8683
            FOR on 8684
            FOR on 8685
            FOR on 8686
            AGAINST on 8687
            AGAINST on 8688
            FOR on 8689
            FOR on 8690
            PRESENT on 8691
            FOR on 8692
            AGAINST on 8693
            FOR on 8694
            AGAINST on 8695
        }

        votes(Jason) {
            AGAINST on 8683
            FOR on 8684
            FOR on 8685
            endorse(G) on 8686
            AGAINST on 8687
            AGAINST on 8688
            AGAINST on 8689
            AGAINST on 8690
            AGAINST on 8691
            AGAINST on 8692
            AGAINST on 8693
            AGAINST on 8694
            AGAINST on 8695
        }

        votes(Forest) {
            FOR on 8683
            FOR on 8684
            FOR on 8685
            AGAINST on 8686
            FOR on 8687
            FOR on 8688
            FOR on 8689
            FOR on 8690
            FOR on 8691
            FOR on 8692
            AGAINST on 8693
            FOR on 8694
            AGAINST on 8695
        }

        votes(nix) {
            endorse(ais523) on 8683
            FOR on 8684
            PRESENT on 8685
            endorse(Jason) on 8686
            FOR on 8687
            AGAINST on 8688
            AGAINST on 8689
            PRESENT on 8690
            PRESENT on 8691
            PRESENT on 8692
            AGAINST on 8693
            // TODO: resolve conditional vote on 8694: "I withdraw this vote and change it to: FOR if I have less coins than half of all players at the end of the voting period and Jason things that's a reasonable thing to determine; otherwise AGAINST"
            FOR on 8695
        }

        votes(Madrid) {
            FOR on all
        }

        votes(G) {
            AGAINST on 8683
            PRESENT on 8684
            FOR on 8685
            PRESENT on 8686
            FOR on 8687
            AGAINST on 8688
            AGAINST on 8689
            FOR on 8690
            FOR on 8691
            FOR on 8692
            AGAINST on 8693
            FOR on 8694
            AGAINST on 8695
        }
    }
}