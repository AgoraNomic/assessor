package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8700to8716() = assessment {
    name("8700-8716")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(15)
    }

    proposals(v4) {
        proposal(8700) {
            title("Well, it's not doing anything.")
            ai("2.0")
            author(Forest)
            ordinary()

            text("""
Repeal Rule 2606/3 "Proposal Classes"""")
        }

        proposal(8701) {
            title("Welp, that doesn't do anything")
            ai("2.0")
            author(Forest)
            ordinary()

            text("""
Amend rule 2645 "The Stones" by replacing the text
"A specified player (defaulting to the
wielder if not specified) hereby Buys Strength 3 times."
with "Nothing happens."
Amend rule 2645 "The Stones" by replacing the text
"A specified player
 (defaulting to the wielder if not specified) gains the Grant
 associated with eir Focus."
with "Nothing happens."""")
        }

        proposal(8702) {
            title("Writing on the Blank Stone")
            ai("2.1")
            author(Forest)
            ordinary()

            text("""
Enact a new rule with the title "Oh we can write on it!" and power=2.1:
Any player, other than the owner of the Blank Stone,
CAN with 2 Agoran consent,
provide an escape chance (hereby C) and a single paragraph of scroll text
(hereby T).
Upon doing so, amend rule 2645 "The Stones" by
replacing the entire entry for Blank Stone with
"- Blank Stone (monthly,C%): T",
where C and T in this string are the provided escape chance, and scroll
text, respectively.""")
        }

        proposal(8703) {
            title("Ticking Stone")
            ai("2.0")
            author(Forest)
            ordinary()

            text("""
Amend the rule "The Stones" by adding another paragraph:
"- Ticking Stone (Monthly, 70%): Upon wielding, the wielder CAN and SHALL
Flip the Device On or Off.
   Upon wielding, the wielder can act on behalf of the device to take any
   action the device may take by announcement in the same message."
Then, create the Ticking Stone under the ownership of Agora.""")
        }

        proposal(8704) {
            title("Tasty Stone")
            ai("2.0")
            author(Forest)
            ordinary()

            text("""
Amend the rule "The Stones" by adding another paragraph:
"- Tasty Stone (Monthly, 70%): A specified bird that is owned by a player is
        transferred to the wielder."
Then, create the Tasty Stone under the ownership of Agora.""")
        }

        proposal(8705) {
            title("Fixing Unfortunate Timing")
            ai("1.0")
            author(Secretsnail9)
            ordinary()

            text("""
Add 9 to secretsnail's score.
Add 7 to Jason's score.
Add 7 to nix's score.
Add 7 to G.'s score.
Add 2 to Murphy's score.
Add 1 to ais523's score.
Add 1 to Aspen's score.

[This should rectify the double-halving of points. The values equal *half*
(rounded up) of the points lost to the *first* halving, which is
appropriate instead of the full value because of the halving that will
happen at the end of the quarter, before this would pass. I also subtracted
5 from the value I would receive to negate the points from this proposal
passing.]""")
        }

        proposal(8706) {
            title("Let them have points")
            ai("1.5")
            author(Secretsnail9)
            ordinary()

            text("""
Amend Rule 2656 "Points" by replacing

      "wins the game via such an
      announcement, all players' scores are set to their default."

with

      "wins the game via such an announcement, the scores of the winning
players are set to their default, and then all other players' scores are
set to half their current value rounded down."""")
        }

        proposal(8707) {
            title("No, we really mean it")
            ai("3.0")
            author(Jason)
            ordinary()

            text("""
Amend Rule 1728 (Tabled Actions) by replacing the paragraph beginning "A
person CAN act" with the following:

{

A person, acting as emself, CAN by announcement table an intent (syn.
"intend") to perform a tabled action, clearly, conspicuously,
explicitly, and without obfuscation specifying the action, the method
(including non-default parameter values), and, optionally, conditions.
The clarity requirement in this paragraph is to be interpreted so as to
impose the highest possible communication standard on intents.

}


[Add "clearly" and "explicitly" to the tabled action clarity
requirement, and make it explicit in the rule that the requirement is
not to be weakened by judges.]""")
        }

        proposal(8708) {
            title("Has Beens")
            ai("3.0")
            author(nix)
            coauthors(Secretsnail9, G, Madrid, Forest, Jason)
            ordinary()

            text("""
Amend R103 by replacing:

       If the office of Speaker has been held continuously by the same
       person for 90+ days, then any player CAN appoint another player to
       the office with support.

with:

       If the office of Speaker has been held continuously by the same
       person for the past 90+ days, then any player CAN appoint another
       player to the office with support.

Amend 2438 by replacing:

       White (W): A player qualifies for a White Ribbon if e has never
       previously owned a White Ribbon (including under previous
       rulesets). A player who has been registered for at least 30 days
       and has never acted on eir own behalf to cause another person to
       gain a White Ribbon (including under a previous ruleset) CAN act
       on eir own behalf to award a White Ribbon to another person by
       announcement.

with:

       White (W): A player qualifies for a White Ribbon if e has never
       previously owned a White Ribbon (including under previous
       rulesets). A player who has been registered for the past 30+ days
       or 180+ cumulative days and has never acted on eir own behalf to
       cause another person to gain a White Ribbon (including under a
       previous ruleset) CAN act on eir own behalf to award a White
       Ribbon to another person by announcement.

G. is the speaker.""")
        }

        proposal(8709) {
            title("Promises Any vs Each")
            ai("2.2")
            author(Secretsnail9)
            ordinary()

            text("""
Amend Rule 2618 (Promises) by replacing "provided that any conditions for
cashing it specified by its text are unambiguously met" with "provided that
each condition for cashing it specified by its text is unambiguously met"

[prevents a reading of only some of the cashing conditions needing to be
met
since that would be "any" conditions]""")
        }

        proposal(8710) {
            title("Tabled action clarification")
            ai("3.0")
            author(Jason)
            coauthors(Secretsnail9)
            ordinary()

            text("""
Amend Rule 1728 ("Tabled Actions") by replacing "An action is a Tabled
Action if it is performed with one of the following methods" with "An
action is a Tabled Action if the Rules purport to authorize its
performance via one of the following methods".""")
        }

        proposal(8711) {
            title("Tabled action condition ambiguity")
            ai("3.0")
            author(Jason)
            ordinary()

            text("""
Amend Rule 2124 ("Performing Tabled Actions") by replacing "its
conditions, if any are met" with "its conditions, if any, are each
clearly and unambiguously met".""")
        }

        proposal(8712) {
            title("Stacking Stones v1.1")
            ai("1.0")
            author(Secretsnail9)
            ordinary()

            text("""
Enact a new rule with title "Balancing Act" and the following text:
{

"Stone Above" is a stone switch tracked by the Stonemason with possible
values
of any stone and none (default).

A stone's props are any stones that have that stone or any of that stone's
props as a their value of Stone Above.

If a stone's Stone Above is ever one of its props, its Stone Above is set
to
none.

A stone that has 3 or more props is immune.

When a stone is wielded, the wielder CAN cascade one of that stone's props
by
announcement in the same message, specifying any values needed to interpret
the
prop's effects.

When a stone is cascaded, the Rule defining that stone applies the effects
in
that stone's scroll.

A player CAN set the Stone Above of a stone they own to another stone they
own,
with 13 days notice, provided e has not set a Stone Above switch in the
past 14
days.

[Note intents expire after 14 days.]

}""")
        }

        proposal(8713) {
            title("Pebble Throwing")
            ai("1.0")
            author(Secretsnail9)
            ordinary()

            text("""
Enact a new rule with title "Take Aim" and the following text:
{

A player CAN throw a specified stone e owns at another specified stone (the
target) that has at least 1 prop, by announcement. When e does so, the
thrown
stone is transferred to Agora, eir score is increased by the number of
props
the target has, and then all of those props have their Stone Above set to
none.

}""")
        }

        proposal(8714) {
            title("Vote scoring clarification")
            ai("1.0")
            author(Jason)
            ordinary()

            text("""
Amend Rule 2657 (Scoring) by replacing the list item beginning "Casting"
with the following:

{

* Having a valid unconditional AGAINST vote on a referendum when it is
resolved to be ADOPTED, or, similarly, FOR when REJECTED: 1 (Assessor).

}


[Clarify that the referendum is resolved, rather than the proposal, that
the vote must be valid, and that the condition is evaluated at the time
of resolution.]""")
        }

        proposal(8715) {
            title("Proposal protection")
            ai("3.0")
            author(Jason)
            ordinary()

            text("""
Amend Rule 2350 ("Proposals") by appending the following paragraph:

{

Removing a proposal from the Proposal Pool, other than by distribution,
is secured. The destruction of proposals is secured.

}


[Prevents a low power rule from preventing proposals from being
distributed.]""")
        }

        proposal(8716) {
            title("Dream of Wandering")
            ai("1.0")
            author(Forest)
            coauthors(nix, Madrid, Secretsnail9, Jason)
            ordinary()

            text("""
Enact a new rule with the title "Dream of Wandering":
Mindset is a secured active player switch,
tracked by the Ministor in eir monthly report,
with possible values Dream of Wandering (the default) and any Dream.

An active player CAN Plan to Flip eir own Mindset,
specifying any valid value for eir Mindset, by announcement.
When the rules state that the wandering occurs,
every active player's Mindset is set to the value e most
recently specified by Planning to Flip. If a player did not Plan to Flip
eir Mindset switch since the last wandering, it not Flipped.

The wandering occurs at the beginning of each month.

A player becomes a New Dreamer when eir Mindset Flips.
A player becomes a Recurring Dreamer when a wandering occurs and eir
Mindset is not flipped, and e is not a New Dreamer.

The following rules apply to each active player
based on that player's Mindset:
- Dream of Victory:
  Upon a correct announcement of being the only player with eir Mindset
  Flipped to Dream of Victories, e wins the game. Upon winning the game,
  e has eir Mindset immediately Flipped to the Dream of Wandering.
  When e is a New Dreamer, e CAN, once by announcement, gain 10 points,
  then cease to be a New or Recurring Dreamer.
- Dream of Wealth:
  When e is a New or Recurring Dreamer, e CAN,
  once by announcement, grant 5 stamps of eir own type to emself,
  then cease to be a New or Recurring Dreamer.
- Dream of Justice:
  When e is a New or Recurring Dreamer, e CAN,
  once by announcement, expunge up to 4 blots from emself,
  then cease to be a New or Recurring Dreamer.
- Dream of Wandering:
  When e is a Recurring Dreamer, when e plans to Flip eir Mindset,
  it is immediately Flipped to the specified value if possible.
  E then ceases to be a Recurring Dreamer.
- Dream of Machines:
  E can Flip the Device to either on or off with Agoran Consent.
  E can act on behalf of the device to take any
  action the device may take by announcement with 1 support.
- Dream of Beasts:
  E can buy bird food by paying a fee of 3 boatloads of coins.
  E can buy a Beast Permit by paying a fee of 40 boatloads of coins.
  E can renew a Beast Permit by paying a fee of 20 boatloads of coins.
- Dream of Gardens:
  When E is a New or Recurring Dreamer, E can pay a fee of N stamps,
  specifying one stone e owns, and that stone has their escape chance
  reduced by N*5%, to a minimum of 0%,
  then E ceases to be a New or Recurring Dreamer.
  This reduction can only apply to one stone e owns.
  This reduction is removed after
  the Stonemason publishes a collection notice.
- Dream of Power: Eir Voting Strength is 2 greater.""")
        }
    }

    voting {
        votes(Murphy) {
            PRESENT on 8700
            PRESENT on 8701
            FOR on 8702
            FOR on 8703
            FOR on 8704
            FOR on 8705
            FOR on 8706
            FOR on 8707
            FOR on 8708
            FOR on 8709
            FOR on 8710
            FOR on 8711
            FOR on 8712
            FOR on 8713
            FOR on 8714
            FOR on 8715
            FOR on 8716
        }

        votes(Forest) {
            FOR on 8700
            FOR on 8701
            FOR on 8702
            FOR on 8703
            FOR on 8704
            AGAINST on 8705
            FOR on 8706
            FOR on 8707
            FOR on 8708
            AGAINST on 8709
            FOR on 8710
            AGAINST on 8711
            PRESENT on 8712
            FOR on 8713
            FOR on 8714
            AGAINST on 8715
            FOR on 8716
        }

        votes(G) {
            AGAINST on all
        }
    }
}