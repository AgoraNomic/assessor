package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.extraVotes
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.*

private const val ASSETLESS_FEE_SPECIFICATION_WORKED = false

@UseAssessment
fun assessment8561to8572() = assessment {
    name("8561-8572")
    quorum(3)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            if (ASSETLESS_FEE_SPECIFICATION_WORKED) {
                extraVotes(Aris, 12)
                extraVotes(Trigon, 11)
            }

            extraVotes(G, 5)
            extraVotes(Aris, 10)
        }
    }

    proposals(v4) {
        proposal(8561) {
            title("Election Cycle")
            ai("2.0")
            author(G)
            coauthors(nix)
            ordinary()
            sponsored()

            text("""
Create a power=2 rule, "The Election Cycle", with the following text:

  A holder of an elected office who did not become its holder by
  winning an election, and has not won an election for that office
  since, is an interim holder. An elected office that is either
  vacant or has an interim holder is an interim office.

  An office is term-limited if the most recent election for that
  office was resolved more than the length of that office's term
  prior. The term for the office of Prime Minister is 90 days. The
  term for all other elected offices is 180 days.

  A player CAN initiate an election for a specified elected office:

  a) with 2 support, if either the office is interim or term-
     limited, and provided that the initiator becomes a candidate
     in the same message.

  b) By announcement, if e is the ADoP (or, if the office is the
     ADoP, if e is the Assessor) and the office is interim, or if
     e is the holder of that office.

  Once per quarter, the ADoP CAN and SHALL publish a Notice of
  Election specifying between 2-4 term-limited offices (if there
  fewer than 2 term-limited offices, the ADoP MUST instead list
  all of them).  Such a notice initiates elections for the
  specified offices.  The ADoP SHOULD prioritize offices that
  have gone longest since their last elections.

  The above notwithstanding, an election for an office CANNOT be
  initiated if one is already in progress.


[Delete this section added to the previous rule - better gathers
election procedure rules in one place].

Amend Rule 1006 (Offices) by removing:
  A holder of an elected office who did not become its holder by
  winning an election, and has not won an election for that office
  since, is an interim holder. An elected office that is either
  vacant or has an interim holder is an interim office.


[For the below rule, remove text placed in the new rule above,
and add the Assessor as the vote collector for ADoP elections].

Amend Rule 2154 (Election Procedure) to read in full:

  When an election is initiated, it enters the nomination period,
  which lasts for 4 days. After an election is initiated and until
  nominations close, any player CAN become a candidate by
  announcement. A candidate ceases to be a candidate if e ceases to
  be a player during the election or if holding the office would
  make em Overpowered. During the nomination period, a candidate CAN
  cease to be a candidate by announcement if there is at least one
  other candidate.

  An election whose nomination period is complete is contested if it
  has two or more candidates, and uncontested otherwise. Nominations
  close at the end of the poll's voting period or when the election
  is ended, whichever comes first.

  After the nomination period ends, the ADoP (or, if the office is
  the ADoP, the Assessor) CAN and, in a timely fashion, SHALL:

  1) If the election is contested, initiate an Agoran decision to
     select the winner of the election (the poll). For this
     decision, the Vote Collector is the ADoP (or, if the office
     is the ADoP, the Assessor), the valid options are
     the candidates for that election (including those who become
     candidates after its initiation), and the voting method is
     instant runoff. When the poll is resolved, its outcome, if a
     player, wins the election. If the outcome is not a player, the
     election ends with no winner.

  2) If POSSIBLE per the following paragraph, end the election
     immediately.

  If at any point an uncontested election has a single candidate,
  then any player CAN by announcement declare em the winner of the
  election, thereby causing em to win the election. If at any point
  an uncontested election has no candidates, then any player CAN
  declare the election ended with no winner by announcement.

  When a player wins an election, e is installed into the associated
  office and the election ends.""")
        }

        proposal(8562) {
            title("Officializing Discord")
            ai("3.0")
            author(ATMunn)
            coauthors(Aris)
            democratic()
            sponsored()

            text("""
The Publicity switch of the Discord server having the ID of
724077429412331560 and being accessible from the permanent invite link
of https://discord.gg/tz2u6m7 is hereby flipped to Discussion.""")
        }

        proposal(8563) {
            title("Determinacy is a Good Thing")
            ai("1.7")
            author(Aris)
            democratic()
            sponsored()

            text("""
[Note that Gaelan's win should have been processed by the time
this is adopted, unless there's an appeal.]

Amend Rule 591, "Delivering Judgements", by removing the text:

  * PARADOXICAL, appropriate if the statement is logically
    undecidable as a result of a paradox or or other irresovable
    logical situation. PARADOXICAL is not appropriate if IRRELEVANT
    is appropriate, nor is it appropriate if the undecidability
    arises from the case itself or in reference to it.

and:

  DISMISS is not appropriate if PARADOXICAL is appropriate.

Repeal Rule 2553, "Win by Paradox".""")
        }

        proposal(8564) {
            title("Sponsorship is not Co-authorship")
            ai("1.0")
            author(Aris)
            ordinary()
            sponsored()

            text("""
[It's always felt weird to me that pending a proposal now
makes you a co-author. That's not what co-authorship
means, IMO. Also, it goes against my mental invariant
that proposals are immutable after creation.]

Amend rule 2622, "Pending Proposals", by deleting the text:

  If the player did not create the proposal and is not
  listed in the list of co-authors of the proposal,
  e is added to the list of co-authors.

[For context, here's the current text of the paragraph:

  Any player CAN pay 1 Pendant to flip the Pended switch of a
  specified proposal to True. If the player did not create the
  proposal and is not listed in the list of co-authors of the
  proposal, e is added to the list of co-authors. When e does so,
  the proposal becomes sponsored.]""")
        }

        proposal(8565) {
            title("Popularity Contest")
            ai("1.0")
            author(Aris)
            ordinary()
            sponsored()

            text("""
Enact a new power 1.0 Rule entitled "Popularity Contest",
with the following text:

  Immediately after the adoption of this rule, Aris wins the
  game. Then, for each person who voted unconditionally FOR the
  referendum on the proposal that enacted this rule, this
  rule causes that person to earn a Black Ribbon.

  Aris CAN cause this rule to make a specified player
  earn a Black Ribbon by announcement. Aris can
  cause this rule to award a specified player
  a specified patent title containing the
  string "Popular" by announcement.

  If it has been at least one month since this rule
  was adopted, any person CAN End the Contest
  by announcement, causing this rule to repeal itself.""")
        }

        proposal(8566) {
            title("Anti-AI escalation")
            ai("3.0")
            author(Jason)
            democratic()
            sponsored()

            text("""
Amend rule 1950 by appending the following to the first paragraph: " If
a referendum has an adoption index less than the adoption index of its
associated proposal, the referendum's adoption index is immediately set
to that of the associated proposal".

[Prevents a potential 2->3 power escalation where a Power 2 dictatorship
can set the AI of the referendum on an AI 3 proposal to 1, then force it
through at AI 1.]""")
        }

        proposal(8567) {
            title("AI voting method clarification")
            ai("3.0")
            author(Jason)
            democratic()
            sponsored()

            text("""
Amend Rule 1950 by replacing "For any Agoran decision with an adoption
index" with "For any Agoran decision with a non-"none" adoption index".

[Legislates the decision in CFJ 3746. All Agoran decisions possess an
adoption index switch, but some of them have the value "none".]""")
        }

        proposal(8568) {
            title("Supporter/Objector clarification")
            ai("3.0")
            author(Jason)
            democratic()
            sponsored()

            text("""
Amend Rule 2124 by replacing the following:

{

  The above notwithstanding, if an action is to be performed without
  N objections or with N Agoran consent, and an objection to an
  intent to perform it has been withdrawn within the past 24 hours,
  then Agora is not Satisfied with that intent.

  The above notwithstanding, Agora is not satisfied with an intent
  if the Speaker has objected to it in the last 48 hours.

  A person CANNOT support or object to an announcement of intent
  before the intent is announced, or after e has withdrawn the same
  type of response.

}

with the following:

{

  The above notwithstanding, if an action is to be performed without N
  objections or with N Agoran consent, and an entity has ceased to be an
  Objector to that intent within the past 24 hours, then Agora is not
  Satisfied with that intent.

  The above notwithstanding, Agora is not Satisfied with an intent if the
  Speaker has become an Objector to it in the last 48 hours.

  An entity is not considered a Supporter or Objector to an intent solely
  due to a purported support or objection made before the intent was
  announced. An entity is not considered a Supporter to an intent if e has
  previously ceased to be a Supporter, and e is not considered an Objector
  to an intent if e has previously ceased to be an Objector.

}

[In each paragraph, use Objector/Supportor status instead of evaluating
whether objections were withdrawn. For instance, it has been previously
pointed out (in private conversation) that the Speaker could potentially
completely block an intent by objecting multiple times. Additionally, in
the third paragraph, extend the restrictions to entities instead of just
persons (since the definition of Supporter/Objector applies to entities,
rather than persons).]""")
        }

        proposal(8569) {
            title("Fixing Festivals")
            ai("3.0")
            author(Jason)
            coauthors(Aris, Murphy)
            democratic()
            sponsored()

            text("""
Amend Rule 2124 by replacing the following text:

{

  The entities eligible to support or object to an intent to perform
  an action are, by default, all players, subject to modification by
  the document authorizing the dependent action.

}

with the following text:

{

  A document that authorizes a dependent action, by default, implicitly
  asserts that all players are eligible to support or object to an intent
  to perform that action; if the document is a rule, conflicts about
  eligibility (including conflicts with such an implicit assertion) are
  resolved using the normal procedures.

}


Set the power of Rule 2480 (Festivals) to 3.1.

Set the power of Rule 2481 (Festival Restrictions) to 3.1.


Amend Rule 2481 (Festival Restrictions) by replacing "Non-Festive
players are never considered Supporters of a dependent action" with
"Rules to the contrary notwithstanding, non-Festive players are not
eligible to support a dependent action".


[Currently, eligibility to object/support to a dependent action is
defined wholly by the rule defining the action. This breaks the festival
rule that non-festive players are not considered supporters. This
proposal changes the definition of eligibility so that it uses the
normal precedence rules, then raises the power of Festivals so that it
applies to the highest-power dependent action (emergency regulation
changes).]""")
        }

        proposal(8570) {
            title("Emergency Regulation Clarification")
            ai("3.1")
            author(Jason)
            democratic()
            sponsored()

            text("""
Amend Rule 2614 by replacing "Award Patent Titles not mentioned in any
Rule and Badges" with "Award Patent Titles that are either Badges or are
not mentioned in any Rule".

[Just a minor wording tweak, this has always looked weird to me.]""")
        }

        proposal(8571) {
            title("Gauntlet announcement patch")
            ai("2.0")
            author(Jason)
            ordinary()
            sponsored()

            text("""
Amend Rule 2644 (The Gauntlet) to read, in whole:

{

  A player CAN, by announcement, Notice the Gauntlet, specifying a single
  player that owns 5 or more stones. When e does, the specified player
  Wields the Gauntlet.

  When a player Wields the Gauntlet, e wins the game, then all existing
  stones are transferred to Agora.

}

[This removes the possibility of accidentally causing someone to Wield
the Gauntlet by changing the "correct announcement" to a specific
action. For instance, I am concerned that a Stonemason's weekly report
might be considered such an announcement.]""")
        }

        proposal(8572) {
            title("Thou shalt not disobey Trigon")
            ai("2.0")
            author(Jason)
            coauthors(Trigon)
            ordinary()
            sponsored()

            text("""
Amend Rule 2545 by appending the following to the paragraph beginning
"When the rules authorize": "Persons who voluntarily participate in an
auction (including the auctioneer) SHALL NOT violate requirements that
auction's method that are clearly intended to be punishable as rules
violations; doing so is the Class N Crime of Auction
Manipulation, where N is the class specified in the auction method (or 2
otherwise)."""")
        }
    }

    voting {
        votes(Aris) {
            PRESENT on 8561
            PRESENT on 8562
            FOR on 8563
            FOR on 8564
            FOR on 8565
            FOR on 8566
            endorse(Jason) on 8567
            FOR on 8568
            AGAINST on 8569
            FOR on 8570
            FOR on 8571
            FOR on 8572
        }

        votes(Jason) {
            FOR on 8561
            FOR on 8562
            AGAINST on 8563
            PRESENT on 8564
            FOR on 8565
            FOR on 8566
            AGAINST on 8567
            AGAINST on 8568
            FOR on 8569
            FOR on 8570
            FOR on 8571
            FOR on 8572
        }

        votes(Trigon) {
            PRESENT on 8561
            FOR on 8562
            AGAINST on 8563
            PRESENT on 8564
            FOR on 8565
            endorse(Jason) on 8566
            endorse(Jason) on 8567
            FOR on 8568
            endorse(Jason) on 8569
            FOR on 8570
            FOR on 8571
            FOR on 8572
        }

        votes(CuddleBeam) {
            FOR on all
        }

        votes(G) {
            FOR on 8561
            FOR on 8562
            AGAINST on 8563

            for (proposal in 8564..8572) {
                PRESENT on proposal
            }
        }

        votes(cuddlybanana) {
            FOR on all
        }

        votes(Falsifian) {
            endorse(G) on 8561
            AGAINST on 8562
            AGAINST on 8563
            FOR on 8564
            AGAINST on 8565
            endorse(Jason) on 8566
            endorse(Jason) on 8567
            AGAINST on 8568
            endorse(Jason) on 8569
            endorse(Jason) on 8570
            endorse(Jason) on 8571
            endorse(Jason) on 8572
        }

        votes(ATMunn) {
            FOR on 8561
            FOR on 8562
            AGAINST on 8563
            FOR on 8564
            AGAINST on 8565
            endorse(Jason) on 8566
            FOR on 8567
            FOR on 8568
            endorse(Jason) on 8569
            FOR on 8570
            PRESENT on 8571
            FOR on 8572
        }
    }
}
