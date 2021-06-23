package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.dsl.votes.powerStone

@UseAssessment
fun assessment8574to9593() = assessment {
    name("8574-8593")
    quorum(7)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            powerStone(G, 6)
        }
    }

    proposals(v4) {
        proposal(8574) {
            title("mending the quill")
            ai("1.0")
            author(Trigon)
            coauthors(Jason, Aris)
            ordinary()
            sponsored()

            text("""
[ Comment: It is not unusual for the final draft of a proposal to be
   submitted by someone other than the person who did most of the
   drafting for that proposal. These proposals have, in several
   instances, made it to the finals. Notably, during the Silver Quill
   2020 discussions, an honorable mention was given to Interesting
   Chambers, which I wrote and did revisions on but never wrote the final
   version of. This kind of stuff has happened before. It isn't too
   worrying, but it would be nice to not have to work around it. Plus,
   proposals are cheap. ]

Amend Rule 2582 by replacing:

  - Silver Quill, awardable by the Promotor to the author of a
    proposal of outstanding merit and influence on the game
    (additional information: ID Number of the proposal).

with:

  - Silver Quill, awardable by the Promotor to the author of a
    proposal of outstanding merit and influence on the game, or to
    a coauthor, although e SHOULD only do so if it is generally
    agreed that that coauthor contributed more to that proposal
    than the person who submitted it (additional information: ID
    Number of the proposal).""")
        }

        proposal(8575) {
            title("Stone Win Delay v2")
            ai("2.0")
            author(Jason)
            coauthors(Gaelan)
            ordinary()
            sponsored()

            text("""
Amend Rule 2644 to read, in whole:

{

  A player CAN, by announcement, Notice the Gauntlet, specifying a single
  player that owns 5 or more stones, provided that no person has done so
  in the past 30 days.

  When the Gauntlet is Noticed, the specified player wins the game. If the
  Gauntlet was Noticed 4 days ago, then all existing stones are
  transferred to Agora.

}


[Adds a delay to stone wins to bring it inline with VP wins. Also adds a
prevention for rapid-fire stone wins. This doesn't allow the bearer of
many stones to prevent the win, in order to maintain a balance of stone
power.]""")
        }

        proposal(8576) {
            title("\"By announcement\" loosening")
            ai("3.0")
            author(Jason)
            coauthors(Aris, Murphy)
            democratic()
            sponsored()

            text("""
Amend Rule 478 by replacing the following:

{

  Where the rules define an action that a person CAN perform "by
  announcement", that person performs that action by unambiguously and
  clearly specifying the action and announcing that e performs it.

}

with the following:

{

  Where the rules define an action that a person CAN perform "by
  announcement", that person performs that action by, in a single public
  message, specifying the action and setting forth intent to perform that
  action by sending that message, doing both clearly and unambiguously.

}


[This unambiguously makes "CFJ: X" and "Proposal: X" work, even though
neither explicitly says they are performing an action, since they both
clearly and unambiguously set forth intent to perform the associated
action. The "by sending that message" part was suggested by Aris, and
prevents "I want to CFJ X at some point" from accidentally taking an
action, even though it arguably sets forth intent to initiate a CFJ.
This also brings the standard for "by announcement" in line with
initiating a decision and casting a ballot, which both require a notice
that "sets forth intent".]""")
        }

        proposal(8577) {
            title("Festival intent eligibility")
            ai("3.0")
            author(Jason)
            democratic()
            sponsored()

            text("""
Amend Rule 2481 (Festival Restrictions) by appending the following item
to the sole list:

{

  5. Non-Festive players are not eligible to object to intents to perform
  the following actions:

      a. Enact, amend, or repeal Emergency Regulations

      b. Impeach officers

}


[These are potentially things that we may want to do during an invasion,
and the invaders should not be able to interfere with them. A broad
objection ban doesn't make sense like it does for support, since we
don't want scammers to be able to RWO using festivals.]""")
        }

        proposal(8578) {
            title("Auction limitation")
            ai("2.0")
            author(Jason)
            coauthors(Trigon)
            ordinary()
            sponsored()

            text("""
Amend Rule 2545 by appending the following to the paragraph beginning
"The rule that authorizes":

{

  The rule that authorizes the auction further authorizes the transfer or
  destruction of currency from persons who have bid voluntarily, as
  specified by the chosen auction method. The authorization to conduct the
  auction does not provide any further authorization than that explicitly
  described in this rule.

}""")
        }

        proposal(8579) {
            title("AI voting method clarification v2")
            ai("3.0")
            author(Jason)
            coauthors(Trigon)
            democratic()
            sponsored()

            text("""
If Rule 1950 contains the text 'For any Agoran decision with an adoption
index', amend Rule 1950 by replacing the text 'For any Agoran decision
with an adoption index' with 'For any Agoran decision with a non-"none"
adoption index'.

[Legislates the decision in CFJ 3746. All Agoran decisions possess an
adoption index switch, but some of them have the value "none". Now with
less ambiguous quotation marks!]""")
        }

        proposal(8580) {
            title("Strength Buying Separation v2")
            ai("3.0")
            author(Jason)
            coauthors(ais523, Trigon)
            democratic()
            sponsored()

            text("""
Amend Rule 2422 by deleting the following text:

{

  A player CAN Buy Strength by paying a fee of 1 Extra Vote. A player's
  Voting Strength on an ordinary referendum is 1 greater for every time e
  Bought Strength during that decision's voting period.

}


Enact a new Rule entitled "Buying Strength" with power 2 and text as
follows:

{

  A player CAN Buy Strength by paying a fee of 1 Extra Vote. A player's
  Voting Strength on referendum on an ordinary proposal is 1 greater for
  every time e Bought Strength during that decision's voting period.

}


[Fixes the ambiguity that ais523 pointed out, and also removes the usage
of the undefined term "ordinary referendum", replacing it with the
well-defined but clunky "referendum on an ordinary proposal".]""")
        }

        proposal(8581) {
            title("Grants on Resets")
            ai("1.0")
            author(Aris)
            ordinary()
            sponsored()

            text("""
Amend Rule 2621, "VP Wins", by replacing:

  When a player takes over the economy, e wins the game. If a player
  Took Over the Economy 4 days ago, all Cards and all Products are
  destroyed, then each active player is granted 1 card of each type.

with:

  When a player takes over the economy, e wins the game. Four days
  later, all Cards and all Products are destroyed. Then, each
  active player gains 1 card of each type and eir grant (if any).""")
        }

        proposal(8582) {
            title("The Artistry Lies in the Art")
            ai("2.0")
            author(Aris)
            ordinary()
            sponsored()

            text("""
[I used "Artistry" rather than "Art" to distinguish it from references
to the liberal arts. Later, I realized that those references use
"Arts" as in "Bachelor of Arts". So we're fine to just use Art here.]

Amend Rule 1367, "Degrees", by replacing each instance of "Artistry"
with "Art".

Change each instance of the patent title "Associate of Nomic
Artistry" to "Associate of Nomic Arts".""")
        }

        proposal(8583) {
            title("Clarify switches")
            ai("3.0")
            author(Murphy)
            democratic()
            sponsored()

            text("""
Amend Rule 2162 (Switches) section 2 by replacing "if no default is
specified" with "if no default is otherwise specified".""")
        }

        proposal(8584) {
            title("Effective deference")
            ai("3.0")
            author(Murphy)
            democratic()
            sponsored()

            text("""
[Consider these hypothetical rules:

  Rule 9001 (Power=1) There are four lights.

  Rule 9002a (Power=2) There are five lights, unless another rule says
    otherwise.

  This successfully avoids conflict with Rule 9001.

  Rule 9002b (Power=2) There are five lights. This rule defers to other
    rules saying otherwise.

  This doesn't, because Power is checked first. But it should, so let's
    check it first. Also does some general minor cleanup.]

Amend Rule 1030 (Precedence between Rules) to read:

   In a conflict between Rules, the conflict shall be resolved by
   performing the following comparisons in the sequence written in
   this rule, until the conflict is resolved.

   - If at least one of the Rules in conflict explicitly says of
     itself that it defers to another Rule (or type of Rule), and
     such provisions would resolve the conflict without
     contradictions, then they shall be used to do so.

   - In a conflict between Rules with different Power, the Rule with
     the higher Power takes precedence over the Rule with the lower
     Power.

   - If all of the Rules in conflict explicitly say that their
     precedence relations are determined by some other Rule for
     determining precedence relations, then the determinations of the
     precedence-determining Rule shall be used to do so.

   - If at least one of the Rules in conflict explicitly says of
     itself that it takes precedence over another Rule (or type of
     Rule), and such provisions would resolve the conflict without
     contradictions, then they shall be used to do so.

   - If any of the rules in conflict have ID numbers, then the Rule
     with the lowest ID number takes precedence.

   - The Rule enacted earliest takes precedence.

   Clauses in any other rule that broadly claim precedence or
   deference (e.g. over or to "all rules" of a certain class) shall
   be, prima facie, considered to be limited claims of precedence or
   deference that are applicable only when such claims are evaluated
   as described within the above sequence.

   No change to the ruleset can occur that would cause a Rule to
   directly claim precedence over this Rule as a means of determining
   precedence. This applies to changes by the enactment or amendment
   of a Rule, or of any other form. This Rule takes precedence over
   any Rule that would permit such a change to the ruleset.""")
        }

        proposal(8585) {
            title("Clarify variable voting period")
            ai("3.0")
            author(Murphy)
            democratic()
            sponsored()

            text("""
Amend Rule 107 (Initiating Agoran Decisions) by replacing this text:

  The publication of such a valid notice initiates the voting period
  for the decision. The voting period lasts for 7 days. The minimum
  voting period for a decision with at least two options is five
  days. The voting period for a decision cannot be set or changed to
  a duration longer than fourteen days. Changing the length of a
  decision's voting period is secured at power 2.

with this text:

  The publication of such a valid notice initiates the voting period
  for the decision. The default length of the voting period is 7
  days. Changing the length of a decision's voting period is secured
  at power 2, and it CANNOT be set or changed to more than 14 days,
  or less than 5 days for a decision with at least two options.""")
        }

        proposal(8586) {
            title("Clarify deputisation")
            ai("3.0")
            author(Murphy)
            democratic()
            sponsored()

            text("""
Amend Rule 2160 (Deputisation) to read:

  A player acting as emself (the deputy) CAN perform an action
  ordinarily reserved for an office-holder, as if e held the office,
  if:

  1. The rules require the holder of that office, by virtue of
    holding that office, to perform the action. (This requirement
    is fulfilled by the deputy performing the action.)

  2. It would be POSSIBLE for the deputy to perform the action,
    other than by deputisation, if e held the office.

  3. Either (i) the office is vacant; or (ii) a time limit by
    which the rules require the action to be performed has expired,
    and the deputy announced between two and fourteen days before
    the action that e intended to deputise for the office to
    perform that particular action; or (iii) such a time limit
    expired more than fourteen days ago.

  4. When performing the action, the deputy announces that e is
    doing so by deputisation or by temporary deputisation.

  When a player deputises for an elected office, e becomes the
  holder of that office, unless the action being performed would
  already install someone into that office, and/or e announces
  that e is doing so by temporary deputisation.""")
        }

        proposal(8587) {
            title("Clarify nomination period")
            ai("2.0")
            author(Murphy)
            coauthors(G)
            ordinary()
            sponsored()

            text("""
Amend Rule 2154 (Election Procedure) to read:

  A player CAN initiate an election for a specified elected office:

  a) with 2 support, if either the office is interim or the most
    recent election for that office was resolved more than 90 days
    prior, and provided that the initiator becomes a candidate in
    the same message.

  b) By announcement, if e is the ADoP and if the office is interim,
    or if e is the holder of that office.

  The above notwithstanding, an election for an office CANNOT be
  initiated if one is already in progress.

  When an election is initiated, it enters the nomination period,
  which lasts for 4 days. During the nomination period, any player
  CAN become a candidate by announcement, and any candidate CAN
  cease to be a candidate by announcement if there is at least one
  other candidate.

  After the nomination period, any player CAN still become a
  candidate by announcement until the end of the election or the
  end of the voting period, whichever comes first.

  A candidate ceases to be a candidate if e ceases to be a player
  during the election, or if holding the office would make em
  Overpowered.

  An election whose nomination period is complete is contested if it
  has two or more candidates, and uncontested otherwise.

  If at any point an uncontested election has a single candidate,
  then any player CAN by announcement declare em the winner of the
  election, thereby causing em to win the election. If at any point
  an uncontested election has no candidates, then any player CAN
  declare the election ended with no winner by announcement.

  After the nomination period ends, the ADoP CAN and, in a timely
  fashion, SHALL:

  1) If the election is contested, initiate an Agoran decision to
    select the winner of the election (the poll). For this
    decision, the Vote Collector is the ADoP, the valid options are
    the candidates for that election (including those who become
    candidates after its initiation), and the voting method is
    instant runoff. When the poll is resolved, its outcome, if a
    player, wins the election. If the outcome is not a player, the
    election ends with no winner.

  2) If the election is uncontested, end the election as described
    above.

  When a player wins an election, e is installed into the associated
  office and the election ends.

[Allowing players to become candidates after the "nomination period" is
  confusing; it's more like a "nomination-only period". This would at
  least separate becoming / ceasing to be a candidate into "during the
  nominating period", then "after the nominating period", then "also any
  time due to deregistration or Overpowering".]""")
        }

        proposal(8588) {
            title("Clarify stone retrieval")
            ai("2.0")
            author(Murphy)
            coauthors(G)
            ordinary()
            sponsored()

            text("""
Amend Rule 2483 (Economics) by replacing "players, contracts, and the
Lost and Found Department" with "players and contracts".

Amend Rule 2640 (Stones) by replacing this text:

  Ownership of stones is entirely restricted to Agora and active
  players.  If a stone is owned by the Lost and Found Department or
  in abeyance, it is immediately transferred to Agora.

with this text:

  Ownership of stones is restricted to Agora and active players. If
  a stone is or would otherwise be owned by the Lost and Found
  Department or in abeyance, it is immediately transferred to Agora.""")
        }

        proposal(8589) {
            title("Secret proposal A")
            ai("1.0")
            author(ATMunn)
            ordinary()
            sponsored()

            text("""
If ATMunn has published a document entitled "Secret document A" with the
SHA-256 hash of
2dbdf2ae3d6f6d102d512cc12dae25ec8a7aa2a332da6cc5c271f205c946fdc2 before
the enactment of this proposal, then the effects described in that
document take place.""")
        }

        proposal(8590) {
            title("Secret proposal B")
            ai("1.0")
            author(ATMunn)
            ordinary()
            sponsored()

            text("""
If ATMunn has published a document entitled "Secret document B" with the
SHA-256 hash of
bf9e005c5f78e9dda0b3ffe7bef9d78b58a11fe7f3452b8cffc02de1a78b0b20 before
the enactment of this proposal, then the effects described in that
document take place.""")
        }

        proposal(8591) {
            title("Secret proposal C")
            ai("1.0")
            author(ATMunn)
            ordinary()
            sponsored()

            text("""
If ATMunn has published a document entitled "Secret document C" with the
SHA-256 hash of
8424391fc8b8d71a6d2c2f34a835f52f74712054da8ec57be97527d3a6319ed9 before
the enactment of this proposal, then the effects described in that
document take place.""")
        }

        proposal(8592) {
            title("Secret proposal D")
            ai("1.0")
            author(ATMunn)
            ordinary()
            sponsored()

            text("""
If ATMunn has published a document entitled "Secret document D" with the
SHA-256 hash of
0b20eac0c9928db31abed9046bff053e7a29cc4e65e46fb448d5e5f47a7611e1 before
the enactment of this proposal, then the effects described in that
document take place.""")
        }
    }
}
