package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8596to8601() = assessment {
    name("8596-8601")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2021-August/015251.html")
    quorum(6)

    strengths {
        default(3)
        min(0)
        max(15)
    }

    proposals(v4) {
//        proposal(8596) {
//            title("decimation times 9")
//            ai("1.0")
//            author(RLee)
//            ordinary()
//            sponsored()
//
//            text("""
//Create a power 1 rule called "temporary inflation reduction" with the text
//"At the end of the month this rule was adopted, each entity's coin balance
//is divided by 10, rounded to the nearest whole number. This rule then
//automatically repeals itself."""")
//        }

        proposal(8597) {
            title(null)
            ai("1.0")
            author(RLee)
            ordinary()
            sponsored()

            text("""
[this proposal does nothing]""")
        }

        proposal(8598) {
            title(null)
            ai("1.0")
            author(G)
            ordinary()
            sponsored()

            text("""
I create a proposal with this sentence as its text, and make it pending.""")
        }

        proposal(8599) {
            title("The Device (mark 2)")
            ai("1.0")
            author(G)
            coauthors(Murphy)
            ordinary()
            sponsored()

            text("""
[inspired by Rules 2192-2193, "The Monster", by Murphy]


Enact a Rule "The Device" with the following text:

  When the device is on:
    * click - hummmmmmm

  When the device is off:
    * whirrrrrr - THUNK


Enact a Rule "The Mad Engineer" with the following text:

  The Mad Engineer is an office; its holder is responsible for
  building and maintaining the Device.  The device is a
  singleton switch with values off (default) and on.  The Mad
  Engineer CAN flip the device to either on or off with Agoran
  Consent; any other player CAN do so with 2 Agoran Consent.

  The Mad Engineer CAN act on behalf of
  the device to take any action that the device may take, and
  SHALL act on behalf of the device to ensure that the device
  fulfills all of its duties.

  The Mad Engineer's weekly duties include the performance of the
  following tasks, in order:

  a) Randomly select exactly one rule.  If the selected rule is
     either this rule or the rule "The Device", then
     007 has been spotted near the self-destruct button; skip
     directly to proposal submission.

  b) Select one or more contiguous sentences from the selected
     rule.

  c) Select exactly one noun from the selected text, and replace
     each instance of that noun with "Device" (including
     grammatical variations, e.g. replacing "<noun>'s" with
     "Device's").

  d) Announce intent to, with Agoran Consent, cause this rule
     to amend the rule "The Device" by inserting the modified
     text as the last list item in either the "device on" or
     "device off" lists in that rule (or, if 007 has been
     spotted, to repeal both that rule and this one).
     This intent announcement counts as the Mad Engineers's weekly
     report.

  If the announcement of intent above is made with the procedure
  described above, the Mad Engineer CAN, with Agoran Consent, cause
  this rule to amend the rule "The Device" as indicated, and SHALL
  do so if the intent receives sufficient support.


G. becomes the holder of the office of Mad Engineer.

An election for Mad Engineer is initiated.""")
        }

        proposal(8600) {
            title("fix win lockouts")
            ai("2.0")
            author(G)
            ordinary()
            sponsored()

            text("""
Amend Rule 2644 (The Gauntlet) to read in full:

  A player CAN, by announcement, Notice the Gauntlet, specifying a
  single player that owns 5 or more stones, provided that no person
  has won the game by doing so in the past 30 days.

  When the Gauntlet is Noticed, the specified player wins the game.
  If a player won the game in this manner 4 days ago, then all
  existing stones are transferred to Agora.


Amend Rule 2621 (VP Wins) to read in full:

  If a player has at least 20 more Victory Points than any other
  player, e CAN Take Over the Economy by announcement, provided no
  person has won the game by doing so in the past 30 days.

  When a player takes over the economy, e wins the game. Four days
  after such a win occurs, all Cards and all Products are destroyed.
  Then, each active player gains 1 card of each type and eir grant (if
  any).


Amend Rule 2553 (Win by Paradox) to read in full:

  If a CFJ about the effectiveness, possibility, or legality of a
  change in the gamestate has been assigned a judgment of PARADOXICAL
  continuously for at least 7 days, then that case's initiator, CAN,
  by announcement, Transcend Logic, provided that e has not already
  won the game with respect to that CFJ. When a person transcends
  logic, e wins the game.

  A player who wins in this fashion SHOULD submit a proposal to
  prevent the paradox from arising again.


If R. Lee has not won the game via the Noticing the Gauntlet, e hereby
does so.  This proposal respectfully suggests that H. Herald SHOULD record
it as a gauntlet win [but as the actual method is via this proposal, it
does not trigger another reset].

[have checked all the other winning conditions - they seem fine].""")
        }

        proposal(8601) {
            title("Adjust late recusal")
            ai("1.0")
            author(Murphy)
            coauthors(Telna)
            ordinary()
            sponsored()

            text("""
Amend Rule 2492 (Recusal) by replacing this text:

  If a judge is recused from a case 4+ days after being assigned to
  it, e SHOULD NOT be assigned as a judge until e has apologised and
  or reasonably explained eir actions.

with this text:

  If a judge is recused from a case that was continuously open and
  assigned to em for at least the past 4 days, e SHOULD NOT be
  assigned as a judge until e has apologised and/or reasonably
  explained eir actions.

[Not that it affects CFJ 3922, but this would prevent the rule from
targeting situations like:
   * Aug 22, player is assigned to a case
   * Aug 23, player judges the case
   * Aug 27, other players move to reconsider the case
   * Aug 28, player recuses emself: only 1 day after e was last assigned,
       but 6 days after e was originally assigned]""")
        }
    }

    voting {
        votes(ais523) {
            // AGAINST on 8596
            AGAINST on 8597
            PRESENT on 8598
            FOR on 8599
            endorse(G) on 8600
            FOR on 8601
        }

        votes(Aspen) {
            // AGAINST on 8596
            FOR on 8597
            FOR on 8598
            FOR on 8599
            endorse(Janet) on 8600
            FOR on 8601
        }

        votes(Janet) {
            // AGAINST on 8596
            AGAINST on 8597
            AGAINST on 8598
            FOR on 8599
            FOR on 8600
            endorse(Telna) on 8601
        }

        votes(Trigon) {
            // AGAINST on 8596
            FOR on 8597
            FOR on 8598
            FOR on 8599
            FOR on 8600
            FOR on 8601
        }

        votes(G) {
            // AGAINST on 8596
            FOR on 8597
            FOR on 8598
            FOR on 8599
            FOR on 8600
            FOR on 8601
        }

        votes(RLee) {
            // AGAINST on 8596
            FOR on 8597
            FOR on 8598
            FOR on 8599
            FOR on 8600
            FOR on 8601
        }

        votes(Madrid) {
            FOR on all
        }

        votes(Telna) {
            AGAINST on 8597
            FOR on 8598
            FOR on 8599
            FOR on 8600
            FOR on 8601
        }
    }
}
