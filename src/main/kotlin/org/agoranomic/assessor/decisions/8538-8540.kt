package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment8538to8540() = assessment {
    name("8538-8540")
    quorum(6)

    proposals(v3) {
        proposal(8538) {
            title("All Good Things Must Come to an End")
            ai("3.0")
            author(Aris)
            coauthors(Jason)
            democratic()

            text("""
Enact a new power 3.15 rule entitled "Burn It With Fire", with the
following text:

  All Emergency Regulations are hereby repealed, destroyed, and
  incinerated.

  If it has been 1 second since this rule was adopted, this
  rule repeals itself.""")
        }

        proposal(8539) {
            title("The Great Rollback")
            ai("3.0")
            author(Aris)
            coauthors(G)
            democratic()
            sponsored()

            text("""
[This is a proposal to repeal bodies of law, which are essentially
unused and make the ruleset far more complicated than it needs to be.]

If this proposal has already taken effect, then it has no effect. If,
but for this sentence, Rule 101 would not exist as a rule after this proposal
ceases taking effect, then the remainder of this proposal has
no effect.


Enact a new power-3.5 rule entitled "Statutory Instrumentation
Simultaneity", reading:

  Rules to the contrary notwithstanding, the proposal which enacted this
  rule CAN make multiple rule changes, which it could otherwise make
  individually, simultaneously. When it attempts to do so, if any single
  rule change it attempts is INEFFECTIVE, then so is the entire attempt.

  If the proposal which enacted this rule makes a change to the
  definition of a rule then, except for rules which are simultaneously
  and explicitly enacted or repealed with that change,
  the rules after that change are exactly the entities that were rules
  beforehand. This is a definition of the interpretation of the
  amendment to the rules and not, in and of itself, a rule change.


Apply the following rule changes simultaneously: {

  Repeal Rule 2611, "Instruments".
  Repeal Rule 2612, "Bodies of Law".
  Repeal Rule 2613, "Effects of Instruments".

  Amend Rule 1688, "Power", by, all as part of the same amendment,
    1. Replacing:
        A statute is a document with positive Power.
       with:
        An instrument is an entity with positive Power.
    2. Replacing:
        A Rule that makes a change, action, or value secured (hereafter
        the securing Rule) thereby makes it IMPOSSIBLE to perform that
        change or action, or to set or modify that value, except as
        allowed by a Statute with Power greater than or equal to the
        change's Power Threshold.
      with:
        A Rule that makes a change, action, or value secured (hereafter
        the securing Rule) thereby makes it IMPOSSIBLE to perform that
        change or action, or to set or modify that value, except as
        allowed by an instrument with Power greater than or equal to the
        change's Power Threshold.


  Amend Rule 2438, "Ribbons", by replacing "A statute" with "An instrument".


  Amend Rule 105, "Rule Changes" by, all as part of the same
  amendment:
    1. Replacing:
        Where permitted by other rules, a statute generally can, as
        part of its effect,
      with:
        When the rules provide that an instrument takes effect, it can
        generally:
    2. Replacing each instance of "statute" with "instrument".


  Amend Rule 2140, "Power Controls Mutability", by changing it to read in full:

    Rules to the contrary notwithstanding, no entity with power below
    the power of this rule can

    1. cause an entity to have power greater than its own.

    2. adjust the power of an instrument with power greater than its own.

    3. set or modify any other substantive aspect of an instrument
       with power greater than its own (that is, one that affects
       the instrument's operation).


  Amend Rule 2125, "Regulated Actions", by changing it to read in full:

    An action is regulated if: (1) the Rules limit, allow, enable, or
    permit its performance; (2) the Rules describe the circumstances under
    which the action would succeed or fail; or (3) the action would, as part
    of its effect, modify information for which some player is
    required to be a recordkeepor.

    A Regulated Action CAN only be performed as described by the
    Rules, and only using the methods explicitly specified in the
    Rules for performing the given action. The Rules SHALL NOT be
    interpreted so as to proscribe unregulated actions.


  Amend Rule 2141, "Role and Attributes of Rules", by replacing:

    A rule is an enduring statute. Every rule has a power between 0.1
    and 4.0, inclusive. Rules to the contrary notwithstanding, it is
    IMPOSSIBLE to enact a rule with power outside this range, or to
    change the power of an existing rule to a nonzero value outside
    this range. The set of all currently-existing rules is called the
    ruleset.

  with:

    A rule is a type of instrument that is always taking effect
    and has the capacity to govern the game generally. A rule's content
    takes the form of a text, and is unlimited in scope. The ruleset
    is the set of all currently-existing rules.

    Every current rule has power between 0.1 and 4.0 inclusive.


  Amend Rule 106, "Adopting Proposals", by changing it to read in full:

    When a referendum on a proposal is resolved, if the outcome is ADOPTED,
    then the proposal in question is adopted, its power is set to the minimum
    of four and its adoption index, and it takes effect. Proposals CANNOT
    otherwise be adopted or take effect, rules to the contrary notwithstanding.

    When a proposal takes effect, the proposal applies the changes that it
    specifies, except as prohibited by other rules. Clearly marked comments
    are ignored. If the proposal cannot make some changes it specifies, that
    does not preclude the other changes from taking place.

    Except insofar as the actions performed by a proposal happen one after
    another, rather than simultaneously, a proposal's effect is
    instantaneous. A proposal can neither delay nor extend its own effect.
    Once a proposal finishes taking effect, its power is set to 0.

    No entity with power below the power of this rule can prevent a proposal
    from taking effect; this does not apply to generally preventing changes to
    specified areas of the gamestate, nor to a proposal preventing itself from
    taking effect (its no-effect clause is generally interpreted as applying
    only to the rest of the proposal).

}

Repeal the rule "Statutory Instrumentation Simultaneity" enacted
earlier in this proposal.""")
        }

        proposal(8540) {
            title("Strengthening Extra Votes v2.1")
            ai("3.0")
            author(nix)
            coauthors(Aris, Jason)
            democratic()
            sponsored()

            text("""
[
This proposal does three things:

* Removes all passive Voting Strength bonuses. They rarely make a
   difference, which makes them uninteresting complexity. That also means
   I'm removing chambers, since they no longer do anything.

* Strengthens Extra Votes. Now they apply to all decisions within a
   voting period. This just makes them feel nicer to use. Also the Buying
   Strength cap is gone.

* Adds a weekly reward for having the highest strength. So there's
   incentive to consider using them even when you're not trying to force
   through/sink a proposal.

* Removes the Economy focus. Since EVs will give a cash reward, they
   fill the same niche as this focus but in a more interesting way.
   Additionally, removing one focus makes the others more competitive.
]

Amend R2422, "Voting Strength", by replacing:

  A player CAN Buy Strength by paying 1 Extra Vote and specifying a
  current Agoran decision on which e is a voter. For each time a
  player has Bought Strength on a decision, eir voting strength is 1
  greater on that decision. If the decision is on a proposal, and
  the proposal's chamber and the player's focus are the same value,
  then eir voting strength is instead 2 greater on that decision. A
  player CANNOT Buy Strength for the same decision more than 3
  times.

with:

  A player CAN Buy Strength by paying a fee of 1 Extra Vote. A
  player's Voting Strength on an ordinary referendum is 1 greater
  for every time e Bought Strength during that decision's voting
  period.

Amend R2645, "The Stones", by replacing:

  - Power Stone (weekly, 40%): A specified player hereby buys
    strength 3 times on a specified unresolved Agoran decision.

with:

  - Power Stone (weekly, 40%): A specified player hereby Buys
    Strength 3 times.

Repeal R2637, "Office Interests".

Repeal R2607, "Proposal Chambers".

Amend R1607, "Distribution", by replacing "the text, author, coauthors,
class and (if applicable) chamber" with "the text, author, coauthors,
and class".

Amend R2350, "Proposals", by removing:

  * A chamber to which the proposal shall be assigned upon its
    creation.

Amend R103, "The Speaker", by removing:

  The Speaker has voting strength one greater than e would have if
  e did not hold the office.

Amend R2624, "Card Administration, by removing:

  Ministry of Economy: 50 boatloads of coins divided by X, rounded
  up; where X is the number of players with their Ministry Focus set
  to Economy. The Ministor SHALL report this value in a timely
  manner after the beginning of the month.

Enact a new Power 1 rule titled "Vocal Voter Verification Award" with
the following text:

  The sole player, if any, who had the highest voting strength among
  all votes cast on all decisions resolved in the last 7 days CAN
  once grant emself 7 boatloads of coins by announcement, provided
  that no referenda initiated in the same message as it remain
  unresolved.""")
        }
    }
}
