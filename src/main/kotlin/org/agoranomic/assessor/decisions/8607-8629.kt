package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.*
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8607to8629() = assessment {
    name("8607-8629")
    quorum(5)

    strengths {
        festival(
            minStrength = 0,
            maxStrength = 15,
            festivePlayers = setOf(
                ais523,
                Aspen,
                ATMunn,
                CuddleBeam,
                cuddlybanana,
                Falsifian,
                G,
                Gaelan,
                Jason,
                Murphy,
                nix,
                omd,
                PSS,
                Telna,
                Trigon,
            )
        )

        onOrdinaryProposals {
            powerStone(Jason, 3)
        }
    }

    proposals(v4) {
        proposal(8607) {
            title("Asset Self-Ratification Fix")
            ai("3.0")
            author(Telna)
            coauthors(ais523, Alexis)
            democratic()
            sponsored()

            text("""
In Rule 2166 "Assets", replace the text "This portion of that entity's
report is self-ratifying." with the following:

  A public document purporting to be this portion of that entity's report
  is self-ratifying.""")
        }

        proposal(8608) {
            title("Powering Up")
            ai("3.0")
            author(Telna)
            coauthors(Jason, G, RLee, Trigon, ATMunn)
            democratic()
            sponsored()

            text("""
Enact a Power-5 Rule titled "High Five" with the following text:

This Power-5 Rule (the first ever) commemorates the Agoran Spirit To
Break The Game.
Agora is no stranger to love. You know the Rules, and so do I.
This is the highest-powered Rule, no matter what. Even if it wouldn't
be, it is.
What is logic? Agora, don't hurt me.
Agora hereby apologises to the Rulekeepor for making em track this mess.""")
        }

        proposal(8609) {
            title("Axiom of Limitations")
            ai("1.0")
            author(Jason)
            ordinary()
            sponsored()

            text("""
Amend Rule 2553 by, as a single amendment, replacing "CAN, by
announcement, Transcend Logic," with "CAN, by announcement, Transcend
Logic, specifying that CFJ," and replacing "for at least 7 days" with
"for between 7 and 90 days".

[Requires that people Transcending Logic specify which case they are
claiming the win for, ensuring that the "with respect to that CFJ"
clause actually functions. Also adds a time limit to claim to prevent
shenanigans and limit the scope of any bugs.]""")
        }

        proposal(8610) {
            title("No Immediate Shenanigans")
            ai("1.7")
            author(Jason)
            ordinary()
            sponsored()

            text("""
Amend Rule 2478 by appending the following to the paragraph beginning
"Initiating a Finger pointing found to be Shenanigans is ILLEGAL": "The
investigator of a finger pointing SHALL NOT point eir finger for the
Crime of Unjustified Gesticulation with respect to that finger pointing.".

[Prohibits the Referee from ruling Shenanigans, then immediately
pointing eir finger at the first pointer in order to get ahead on the
finger pointing contest.]""")
        }

        proposal(8611) {
            title("Reasonably Responsive Reactivation")
            ai("1.0")
            author(Jason)
            coauthors(Trigon)
            ordinary()
            sponsored()

            text("""
Amend Rule 2646 (Activity) by replacing "A player CAN activate or
deactivate emself by announcement." with "A player CAN activate emself
by publishing a message that indicates reasonably clearly and reasonably
unambiguously that e intends to become active. A player CAN deactivate
emself by announcement.".

[People who are reactivating themselves are unlikely to know the exact
phrasing that is necessary to do so. This makes it easier by bringing
the standard for reactivation in line with the standard for registration.]""")
        }

        proposal(8612) {
            title("Tournament Conclusion Fixes v2")
            ai("1.0")
            author(Jason)
            coauthors(G, Oerjan)
            ordinary()
            sponsored()

            text("""
Amend Rule 2464, Tournaments, by replacing:

{

  If a winner of a tournament is determined within within 3 months of its
  initiation, that person or persons win the game, otherwise the
  tournament concludes with no winner.

}

with:

{

  Each time that one or more winners of a tournament are determined before
  it concludes, that person or those persons win the game. A tournament
  concludes when its regulations state that it concludes. Additionally, if
  it has not previously concluded, a tournament concludes 3 months after its
  initiation.

}


All ongoing tournaments hereby conclude with no (further) winner, except
for the tournament initiated on or about 2 July 2021 (if it is still
ongoing).


[Ensures that any previous ongoing tournaments that found a winner are
concluded (which the rule did not explicitly state).]""")
        }

        proposal(8613) {
            title("The Name of the Win Cards v2")
            ai("3.0")
            author(Jason)
            coauthors(Trigon)
            democratic()
            sponsored()

            text("""
In ascending numerical order, amend each enacted rule by
case-insensitively replacing, as a single amendment per Rule:

* "Victory Card" with "Win Card"

* "Victory Point" with "Winsome"

* "Extra Vote" with "Votive"


Win Card balances are hereby set to what Victory Card balances were at
the time immediately before this proposal began taking effect.

Winsome balances are hereby set to what Victory Point balances were at
the time immediately before this proposal began taking effect.

Votive balances are hereby set to what Extra Vote balances were at the
time immediately before this proposal began taking effect.

[This introduces more whimsy into the asset names and means that Voting
Card and Victory Card are no longer both VCs.]""")
        }

        proposal(8614) {
            title("Simultaneity Security")
            ai("3.0")
            author(Jason)
            democratic()
            sponsored()

            text("""
Amend Rule 478 by, as a single amendment, inserting a paragraph break
before "Any action performed by sending a message", then appending to
the (new) final paragraph: "Allowing actions performed by sending a
message to take place simultaneously must be done explicitly and is
secured at power 2."

[This prohibits simultaneity without an authorizing rule, which is less
extreme than a total ban (which G. has exposed disapproval of).]""")
        }

        proposal(8615) {
            title("Supporter/Objector clarification v2")
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
  previously ceased to be a Supporter to it, and e is not considered an
  Objector to an intent if e has previously ceased to be an Objector to it.

}

[

  In each paragraph, use Objector/Supportor status instead of evaluating
  whether objections were withdrawn. For instance, it has been previously
  pointed out (in private conversation) that the Speaker could potentially
  completely block an intent by objecting multiple times. Additionally, in
  the third paragraph, extend the restrictions to entities instead of just
  persons (since the definition of Supporter/Objector applies to entities,
  rather than persons).

  Fixes the bug in the previous version where ever withdrawing an
  objection would prevent you from ever objecting again.

]""")
        }

        proposal(8616) {
            title("Narrowing Margins")
            ai("1.0")
            author(nix)
            coauthors(Telna, Trigon)
            ordinary()
            sponsored()

            text("""
Amend R2621, VP Wins, to read in full:

  The Victory Threshold is 20-5x, where x is the number of months
  since the last time someone Took Over The Economy. If it would
  be less, the Victory Threshold is instead 1.

  If a player has at least the Victory Threshold more Victory
  Points than any other player, e CAN Take Over the Economy by
  announcement, provided no person has won the game by doing so in
  the past 30 days.

  When a player takes over the economy, e wins the game. Four days
  after such a win occurs, all Cards and all Products are
  destroyed. Then, each active player gains 1 card of each type
  and eir grant (if any).""")
        }

        proposal(8617) {
            title("Forgiveness")
            ai("1.0")
            author(nix)
            coauthors(G)
            ordinary()
            sponsored()

            text("""
Agora formally forgives all fugitives listed on the most recent scroll
of Agora.""")
        }

        proposal(8618) {
            title("Solo Acitivity")
            ai("1.0")
            author(nix)
            coauthors(Jason)
            ordinary()
            sponsored()

            text("""
Amend R2646, "Activity" by by replacing:

  A player CAN activate or deactivate emself by announcement.

with:

  A player CAN, acting as emself, activate or deactivate emself by
  announcement.""")
        }

        proposal(8619) {
            title("The Bottomless Pit")
            ai("1.0")
            author(ATMunn)
            ordinary()
            sponsored()

            text("""
Enact a new power-1 rule entitled "The Bottomless Pit":

  Any player CAN throw (syn. "yeet") a number of coins into the
  Bottomless Pit by announcement. Upon doing so, the specified number
  of coins is destroyed from eir posession.

  Though these coins may be gone for all legal purposes within this
  sacred game of Nomic, let the wise Agoran note that these coins are
  not truly gone, but have simply taken on a new form in the Infinity
  of the Pit...""")
        }

        proposal(8620) {
            title("Im cool")
            ai("1.0")
            author(RLee)
            ordinary()
            sponsored()

            text("""
Create a power one rule with the text "Anyone who voted for the adoption
of this rule CAN once by announcement redeem this rule to win the game.
Anyone who does so CAN by announcement award emself one of the following
patent titles: God, Goddess, Deity".""")
        }

        proposal(8621) {
            title("Proposal spreading")
            ai("3.0")
            author(RLee)
            democratic()
            sponsored()

            text("""
At the end of paragraph four of the rule 1607 "Distribution", append the
following sentence
"If there are ten or more pending undistributed proposals in the proposal
pool, the promotor MAY refrain from distributing the most recently added 5
proposals if e distributes each other pending proposal in that Agoran week.
E SHALL then distribute those undistributed proposals the next Agoran week.""")
        }

        proposal(8622) {
            title("Allow acting on behalf to support or object")
            ai("3.0")
            author(RLee)
            democratic()
            sponsored()

            text("""
Amend rule 2124 by replacing

  " A Supporter of an intent to perform an action is an eligible
  entity who has publicly posted (and not withdrawn) support for an
  announcement of that intent. An Objector to an intent to perform
  an action is an eligible entity who has publicly posted (and not
  withdrawn) an objection to the announcement of that intent."


with

  " A Supporter of an intent to perform an action is an eligible
  entity who has supported and has not withdrawn their support for an
  announcement of that intent. An Objector to an intent to perform
  an action is an eligible entity who has objected to and has not
  withdrawn their objection to the announcement of that intent."

and by adding as a new paragraph at the very start of the rule

  "A person CAN support or object to an intent to perform an action by
  announcement and CAN withdraw support or objection by announcement."""")
        }

        proposal(8623) {
            title("No prizeless victory auctions")
            ai("1.0")
            author(Trigon)
            ordinary()
            sponsored()

            text("""
[ COMMENT: After the reset, the poor player who still has the highest
   claim might be forced to pay for nothing; or, more realistically, the
   auction runner might just not be able to distribute lots for the
   auction. Either way, this is certainly not an ideal situation. ]

In Rule 2561 "VP Wins" replace the following:

  Four days after such a win occurs, all Cards and all Products are
  destroyed.

with:

  Four days after such a win occurs, all Cards and all Products are
  destroyed and any ongoing victory auctions end with no victors.

All victory auctions that were initiated before this proposal was
created end with no victors.""")
        }

        proposal(8624) {
            title("I'd like to thank the academy")
            ai("1.0")
            author(Trigon)
            ordinary()
            sponsored()

            text("""
[ COMMENT: This one's a lot less serious, but I like the concept.
   Initially, I felt bad that I won and Cuddlebeam didn't even get a
   consolation prize for eir cooperation in the victory.

   I just wanted to add the second half of this proposal to allow winners
   to nominate players for helping them win because we could always use
   more patent titles, but I realized that it might be fun to make it a
   ceremony. Being a Champion merits more whimsy than we afford it now.

   Neither of the lists in the rule are super solid right now, though
   their whimsical nature should be preserved in future revisions. ]

Create a new (Power=1) rule entitled "Champion's Patent Titles" with the
text:

  For each time a person is awarded the patent title of Champion, e
  CAN once post a Champion's Address within seven days of that
  awarding. A Champion's Address SHOULD, but NEED NOT include the
  following components:

  * A recap of how that victory was achieved.
  * A declaration of eir superiority over the rest of the Agoran
   Community for eir well-earned victory.
  * A sincere expression of gratitude to the Agoran Community for
   their duly-given recognition of the victory.

  Within a Champion's Address, the following patent titles CAN be
  awarded to persons in acknowledgement for the help they have given
  in securing the win, substituting the word "Champion" for the
  winning player's name:

  * Champion's Conspirator, awardable to a person who contributed
    significantly to the strategy employed to secure the win.
  * Champion's Financer, awardable to a person who contributed
    significantly economically to the Champion in order to secure
    the win.
  * Champion's Adjunct, awardable to a person who contributed
    in a minor fashion to the win.
  * Champion's Pawn, awardable to a person who unknowingly
    contributed to the Champion's win.""")
        }

        proposal(8625) {
            title("giving the gift of an amendment")
            ai("1.0")
            author(Trigon)
            ordinary()
            sponsored()

            text("""
[ COMMENT: Introduces a new term of art so that we don't have to worry
   about messing up the wording for giving a birthday gift again. ]

Amend Rule 2585 "Birthday Gifts" by replacing:

  During a player's Agoran Birthday and the 7 days following, each
  other player CAN once grant em X boatloads of coins by
  announcement, where X is 3 if it is actually the day of the
  player's birthday, and 2 otherwise.

with:

  During a player's Agoran Birthday and the 7 days following, each
  other player CAN once give that player a birthday gift, granting
  em 3 boatloads of coins if it is actually the day of the player's
  birthday, or 2 otherwise.""")
        }

        proposal(8626) {
            title("pledge(2)(2)")
            ai("3.0")
            author(Trigon)
            coauthors(Jason, ais523)
            democratic()
            sponsored()

            text("""
[ COMMENT: The gist of this idea is that players can choose for some
   part of their messages which actions should succeed and which actions
   should fail. Hopefully, this would be integrated gracefully into the
   rest of the rules, but that's a lot of SHALLs to sort through to
   decide which should be scoped actions. Comments can be found
   throughout.

   Second update: I've reworked some of the wording. There might still be
   room for breaking. Feel free to tell me to fix it. ]

Enact a new Power=3 rule entitled "Scopes" with text:

  Players CAN take actions in a specific scope. When a player does
  so, e must either clearly and unambiguously describe a list of
  allowed actions or a list of prohibited actions for that scope, or
  e must refer to a source which clearly and unambiguously defines
  such a list. E must also clearly and unambiguously specify when e
  begins acting in that scope and when e finishes acting in that
  scope.

  Actions within a scope which are prohibited or not allowed are
  blocked actions, while actions which are allowed or not prohibited
  are unblocked actions.

[ COMMENT: I'm not sure what I think of this terminology. ]

  When a player is acting within a specific scope, if an action
  which would otherwise succeed is blocked within that scope, then
  that action instead fails.

  When a player begins acting in a scope, e CAN specify which
  of the following modifiers apply, if any.

  * Indirection allowed: actions within this scope whose end results
    are solely to initiate one or more unblocked actions within this
    scope succeed as well.

  * Partial success prohibited: if one action within this scope
    would fail, then all actions within the scope fail.

  * Acting on behalf allowed: acting on behalf to perform an
    unblocked action within this scope succeeds as well.

[ COMMENT: There's got to be a way to phrase these scope modifiers
   better, right? ]

  The following scopes are defined:

[ COMMENT: These are just random suggestions , though I think they are
   useful. Feel free to suggest more. ]

  * Global scope: all actions are allowed in this scope.

[ COMMENT: This should also allow players to say something like "I act
   in the global scope, disallowing partial success, to do the following:
   {...}" instead of "If all the following succeed I do this: {...}".
   I think that it's elegant, if a bit wordy. Suggestions for better
   terminology for scopes are welcome. ]

  * Transaction scope: when acting in this scope, only transfers of
    assets are allowed.
  * Economic scope: when acting in this scope, creation,
    destruction, and transfers of assets are allowed.
  * Official scope: for a specified office, only actions mandated by
    the rules for that office succeed.

[ COMMENT: This is a rather broad specification, but it might allow us
   to write something like "When the rules say an Officer CAN do
   something, then e does so in that Office's scope", though whether we
   want to is another question. ]

[ COMMENT: So what do you think? I like the idea, but executing actions
   within a scope is wordy. As is the proposed rule. With no comments,
   it's still over 40 lines long. Suggestions to make either more
   succinct are very welcome. ]""")
        }

        proposal(8627) {
            title("INSANITY CLAUSES")
            ai("1.0")
            author(G)
            ordinary()
            sponsored()

            text("""
The clauses in the most recent document that has been published by
G. labelled as THE INSANITY CLAUSES takes effect.""")
        }

        proposal(8628) {
            title("tacking into the win")
            ai("2.0")
            author(G)
            ordinary()
            sponsored()

            text("""
Amend Rule 2638 (Player Focuses) by replacing:
  At the beginning of a month, every active player's
  Ministry Focus is set to the value e mostly recently specified by
  Planning to Flip. If a player did not Plan to Flip eir Ministry
  Focus switch in the last month, it is not flipped.
with:
  When the rules state that the winds change, every active
  player's Ministry Focus is set to the value e mostly recently
  specified by Planning to Flip. If a player did not Plan to Flip
  eir Ministry Focus switch since the last time the winds changed,
  it is not flipped.

  The winds change at the beginning of each month.


Amend Rule 2621 (VP Wins) by replacing:
  Then, each active player gains 1 card of each type and eir grant
  (if any).
with:
  Then, the winds change, following which each active player
  gains 1 card of each type and eir grant (if any).""")
        }

        proposal(8629) {
            title("Independence Day")
            ai("3.0")
            author(G)
            coauthors(
                Gaelan,
                Telna,
                nix,
                CuddleBeam,
                cuddlybanana,
                Jason,
            )
            democratic()
            sponsored()

            text("""
[Note: this proposal was not rushed, it was originally part of survivor
golf, and then substantially honed on discord.  Doesn't mean it should be
thoroughly checked! Also, please see the note at the bottom.]


Amend Rule 1728 (Dependent Action Methods) by changing its title to
"Tabled Actions" and amending its text to:

  An action is a Tabled Action if it is performed with one of the
  following methods:
  * With N Support, where N is a positive integer.
  * Without N Objections, where N is a positive integer.
  * With N Agoran Consent, where N is a positive integer multiple of
    0.1.
  * With T notice, where T is a time period.

  The parameters N and T, if omitted, default to 1 and 4 days,
  respectively (e.g. "without objection" means N=1). If a rule defines
  N as less than 1 or greater than 8, it is instead treated as 1 or 8,
  respectively.

  A person CAN act on eir own behalf, by announcement, to table an
  intent (syn. "intend") to perform a tabled action, conspicuously and
  without obfuscation specifying the action, the method (including non-
  default parameter values), and optionally, conditions.

  A person is the sponsor of such an intent if e tabled it, or if e is
  authorized to perform its action due to holding a rule-defined
  position previously held by the person who tabled it.


Amend Rule 2124 (Agoran Satisfaction) by changing its title to
"Performing Tabled Actions" and amending its text to:

  For a given tabled intent, a player CAN, unless otherwise forbidden by
  the rules or the document enabling the action, act on eir own behalf,
  by announcement, to:
  * Become a supporter ("support" it), unless e tabled or previously
    supported it;
  * Become an objector ("object to" it), unless e previously
    objected to it;
  * Cease to be a supporter or objector ("withdraw" support/objection).

  An intent is ripe if was tabled within the past 14 days, the Speaker
  hasn't objected to it in the past 48 hours, and its conditions, if
  any, are met.

  An intent is mature if it was tabled at least 4 days ago and nobody
  withdrew objections from it in the past 24 hours.

  A rule purporting to allow a person to perform a tabled action allows
  em to do so by announcement, if, considering only intents for that
  action/method combination:
  * With N Support: e is a sponsor or supporter of a ripe intent with
    at least N supporters.
  * Without N Objections: e is a sponsor of a mature ripe intent with
    less than N objectors.
  * With N Agoran Consent: e is a sponsor or supporter of a mature
    ripe intent with supporters greater than N times its objectors
    (e SHOULD list supporters and objectors).
  * With T notice: e is the sponsor of a ripe intent created at
    least T ago.


Repeal Rule 2595 (Performing a Dependent Action).


Amend Rule 2481 (Festival Restrictions) by replacing:
  1. Rules to the contrary notwithstanding, non-Festive players are
     not eligible to support a dependent action;
with:
  1. Rules to the contrary notwithstanding, non-Festive players
     CANNOT support/be a supporter for tabled action intents;


If the effects of a proposal authored by R. Lee have amended Rule 2124
in the previous 14 days, then amend Rule 2124 by deleting:
  "on eir own behalf,"

[On this final clause: this proposal is meant to keep all actual mechanics
of dep. actions unchanged.  I didn't want to take a particular position on
whether you can act-on-behalf of someone to support/object to an intent.
Unfortunately, it's unclear what the current rules allow.  By clarifying
in either direction, I'm taking a side.  But R. Lee has submitted a
proposal called "Allow acting on behalf to support or object".  The clause
above ensures that if R. Lee's proposal is adopted, the act-on-behalf
functionality stays in the rewrite as per the will of the voters.]""")
        }
    }

    voting {
        votes(Trigon) {
            FOR on 8607
            FOR on 8608
            FOR on 8609
            FOR on 8610
            FOR on 8611
            FOR on 8612
            FOR on 8613
            endorse(G) on 8614
            PRESENT on 8615
            FOR on 8616
            FOR on 8617
            FOR on 8618
            AGAINST on 8619
            AGAINST on 8620
            PRESENT on 8621
            AGAINST on 8622
            FOR on 8623
            FOR on 8624
            AGAINST on 8625
            FOR on 8626
            // NO VOTE on 8627
            FOR on 8628
            FOR on 8629
        }

        votes(ShyOwl) {
            FOR on 8607
            AGAINST on 8608
            FOR on 8609
            FOR on 8610
            FOR on 8611
            PRESENT on 8612
            FOR on 8613
            FOR on 8614
            AGAINST on 8615
            PRESENT on 8616
            FOR on 8617
            AGAINST on 8618
            AGAINST on 8619
            AGAINST on 8620
            FOR on 8621
            FOR on 8622
            FOR on 8623
            FOR on 8624
            FOR on 8625
            FOR on 8626
            PRESENT on 8627
            FOR on 8628
            FOR on 8629
        }

        votes(ATMunn) {
            FOR on 8607
            FOR on 8608
            FOR on 8609
            endorse(Jason) on 8610
            FOR on 8611
            FOR on 8612
            FOR on 8613
            FOR on 8614
            FOR on 8615
            PRESENT on 8616
            FOR on 8617
            FOR on 8618
            PRESENT on 8619
            AGAINST on 8620
            endorse(Aspen) on 8621
            PRESENT on 8622
            FOR on 8623
            FOR on 8624
            AGAINST on 8625
            PRESENT on 8626
            FOR on 8627
            FOR on 8628
            FOR on 8629
        }

        votes(G) {
            (8607..8610).forEach { FOR on it }
            AGAINST on 8611
            FOR on 8612
            (8613..8615).forEach { FOR on it }
            AGAINST on 8616
            (8617..8618).forEach { FOR on it }
            AGAINST on 8619
            AGAINST on 8620
            endorse(Aspen) on 8621 comment "Aspen is the Promotor"
            AGAINST on 8622
            FOR on 8623
            endorse(nix) on 8624 comment "nix is the Herald"
            AGAINST on 8625
            AGAINST on 8626
            FOR on 8627
            FOR on 8628
            endorse(ais523) on 8629
        }

        votes(Jason) {
            FOR on 8607
            FOR on 8608
            FOR on 8609
            FOR on 8610
            AGAINST on 8611
            FOR on 8612
            FOR on 8613
            FOR on 8614
            FOR on 8615
            AGAINST on 8616
            FOR on 8617
            FOR on 8618
            FOR on 8619
            AGAINST on 8620
            endorseOrElse(Aspen, AGAINST) on 8621
            AGAINST on 8622
            FOR on 8623
            endorse(nix) on 8624
            AGAINST on 8625
            endorse(G) on 8626
            AGAINST on 8627
            FOR on 8628
            endorse(G) on 8629
        }
    }
}
