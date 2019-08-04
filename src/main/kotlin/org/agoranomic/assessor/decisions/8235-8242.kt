package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.lib.AssessmentData
import org.agoranomic.assessor.lib.VoteKind.FOR
import org.agoranomic.assessor.lib.assessment

fun `assessment 8235 to 8242`(): AssessmentData {
    return assessment {
        name("8235-8242")

        quorum(9)

        strengths {
            default(3)
            G strength 4 comment PM
            Corona strength 1 comment BLOTS
            twg strength 2 comment BLOTS
        }

        proposals {
            proposal(8235) {
                title("Unified fine creation syntax")
                ai(3.0)
                author(JasonCobb)

                text("""
Amend Rule 2555 ("Blots") by replacing the text "To Levy a Fine" with
the text "To levy a fine".


Amend Rule 2451 ("Executive Orders") by replacing the sentence

  The Prime Minister levies a 2 Blot fine on a specified player.

with the sentence

  The Prime Minister levies a fine of 2 on a specified player.


Amend Rule 2479 ("Official Justice") by replacing the text "levying a
fine of up to 2 blots on em" with the text "levying a fine of (a value
not exceeding 2) on em".""")
            }

            proposal(8236) {
                title("Definition de-capitalization")
                ai(3.0)
                author(JasonCobb)
                coauthors(Aris)

                text("""
Amend Rule 1728 to read, in whole:

  The following methods of taking actions are known as "dependent
  actions":

  1. without N objections, where N is a positive integer no greater
  than 8 ("without objection" is shorthand for this method with N = 1);

  2. with N support, where N is a positive integer ("with support" is
  shorthand for this method with N = 1);

  3. with N Agoran consent, where N is an integer multiple of 0.1 with
  a minimum of 1 ("With Agoran consent" is shorthand for this method
  with N = 1);

  4. with notice; or

  5. with T notice, where T is a time period.

  N is 1 unless otherwise specified.


Amend Rule 2595 as follows:

  In the first sub-bullet under item 2 of the only list, replace the
  text "with T Notice" with the text "with T notice".

  In the second sub-bullet under item 2 of the only list, replace the
  text "Without N Objections, With N Support, or With N Agoran
  Consent" with the text "without N objections, with N support, or
  with N Agoran Consent".

  In the first sub-bullet under item 3 of the only list, replace the
  text "With N Support" with the text "with N support".

  In the second sub-bullet under item 3 of the only list, replace the
  text "Without N Objections, With N Agoran Consent, or With Notice"
  with the text "without N objections, with N Agoran consent, or with
  notice".

  In the third sub-bullet under item 3 of the only list, replace the
  text "With T Notice" with the text "with T notice".

  In the final paragraph, replace the text "with N Agoran Consent"
  with the text "with N Agoran consent".

Amend the only list in Rule 2124 ("Agoran Satisfaction") to read:

  1. The action is to be performed Without N objections, and there are
  at least N Objectors to that intent.

  2. The action is to be performed With N support, and there are fewer
  than than N Supporters of that intent.

  3. The action is to be performed with N Agoran consent, and the
  number of Supporters of the intent is less than or equal to N times
  the number of Objectors to the intent.""")
            }

            proposal(8237) {
                title("Repairing Defeated Spaceships v3")
                ai(3.0)
                author(JasonCobb)
                coauthors(twg, JasonCobb)

                text("""
Amend Rule 2595 by replacing the text "Any player CAN, by
announcement, spend a coin to increase the Armour of a Pilotable
Spaceship e owns by 1." with the text "Any player CAN pay a fee of 1
coin to increase the Armour of a Pilotable Spaceship in eir possession
by 1 or pay a fee of 3 coins to increase the Armour of a Defeated
Spaceship by 1."

[Comment: Right now, Defeated Spaceships are effectively dead forever.
If a player goes all out and kills the other person's Spaceship, they
are effectively banished from the subgame forever. To solve this, a
slight penalty is added for repairing a Defeated spaceship. The number
of coins remains small because it is just a subgame.]

Amend Rule 2591 by replacing the text "Spaceships are a class of fixed
asset" with "Spaceships are a class of fixed indestructible asset".

[Change from the original: "pay... 1 coin increase" -> "pay... 1 coin to
increase"]""")
            }

            proposal(8238) {
                title("Cancelling Proposals (arr. for violin)")
                ai(3.0)
                author(JacobArduino)
                coauthors(twg, G)

                text("""
[ This has bugged me for a while (no pun intended): if a broken proposal makes
   it to its voting period, even if the error is then discovered, it tends not
   to percolate through to everyone doing the voting, and the proposal gets
   adopted anyway. I've been trying to get around this by just endorsing the
   proposal's author, on the basis that e's the most likely to notice if there
   is a problem and can then change eir vote to AGAINST, but that has its own
   problems. I feel this is a fairly neat solution with enough safeguards to
   stop it being abused. ]

[ This second version removes reliance on the Assessor to support the action,
  and adds protection against the Speaker's delay (which would function here
  as a veto). ]

Enact a new rule, "Cancelling Erroneous Proposals", Power=3.0, with the
following text:

  During the voting period of an Agoran decision determining whether or not
  to adopt a proposal, its author CAN with support cancel the decision.

  It is RECOMMENDED that this ability only be used if the proposal contains
  a textual error preventing it from having the effect its author intended.

  The Speaker is not eligible to object to an announcement of intent to
  perform an action permitted by this rule.

Amend Rule 955, "Determining the Will of Agora", by adding the following list
item to the unnumbered list in between the two previously existing items:

  - If the decision has been cancelled, as permitted by rules of power 3 or
    greater, the outcome is instead CANCELLED.""")
            }

            proposal(8239) {
                title("The Editor (v2.0.1)")
                ai(1.0)
                author(JasonCobb)
                coauthors(G, Aris, Trigon)

                text("""
[Comment: Creates a new role, the Editor, who is the same person as the
Rulekeepor and which is responsible for promulgating regulations
(Editorial Guidelines) about non-substantive elements of the Ruleset.
Currently, guidelines are not written down anywhere official, which
probably contributes to the inconsistency arising in the first place.]

Enact a new Rule with power 1, title "The Editor", and text as follows:

  The Editor is the same person, if any, as the Rulekeepor.

  The Editor CAN, with Agoran consent, enact regulations, collectively
  called "Editorial Guidelines". The Editor CAN, with Agoran consent,
  repeal and amend Editorial Guidelines. The Editor is the Promulgator
  for all Editorial Guidelines.

  Editorial Guidelines SHOULD pertain only to matters that affect
  non-substantive aspects of the Rules, e.g. capitalization or
  spelling. Editorial Guidelines CANNOT place any enforceable
  requirements upon any player and CANNOT cause any changes to the
  gamestate. Whether or not the text of a textual entity conforms to
  the Editorial Guidelines SHOULD NOT affect the interpretation of
  that entity.

  When writing proposals and enacting or amending regulations, players
  SHOULD follow all reasonable directives that are set out in the
  Editorial Guidelines.

  Causing an Editorial Guideline to be inconsistent with any other
  Editorial Guideline is the Class 1 Crime of Editorial Hypocrisy.""")
            }

            proposal(8240) {
                title("Regulation clarification")
                ai(3.0)
                author(JasonCobb)

                text("""
[Comment: Currently, R2493 reads as if any person who happens to be
Promulgator can enact/amend/repeal _any_ regulation (without otherwise
specified rules) with 2 Agoran Consent. While not the most serious bug,
it's probably not what was intended.]

Amend Rule 2493 ("Regulations") as follows:

  Replace the sentence beginning "By default" with the sentence
    By default, a person CAN, with 2 Agoran consent, enact, amend,
    or repeal a regulation for which e is the Promulgator.""")
            }

            proposal(8241) {
                title("Secured switches (v2.0)")
                ai(3.0)
                author(Falsifian)

                text("""
[Comment: define what it means for switches to be "secured", then use
that definition. This works with default power thresholds since it isn't
R2162 that designates the changes as secured, the Rule that defines the
switch is defined as designating the changes as secured.]

Amend Rule 2162 by appending the following sentence to the paragraph
beginning "At any given time":

  A Rule that designates a switch as "secured" (at a given power
  level) designates changes to the properties of that type of switch
  as secured (at that power level) and designates changes to the value
  of each instance of the switch as secured (at that power level).

Amend Rule 1950 as follows:

  Delete the text "Adoption index is secured with a power threshold of
  2.".

  Replace the text

    Adoption index (AI) is an untracked switch possessed by Agoran
    decisions and proposals.

  with the text

    Adoption index (AI) is an untracked switch possessed by Agoran
    decisions and proposals, secured at power 2.

Amend Rule 2480 as follows:

  Delete the text "Changes to Festivity are secured.".

  Replace the text "Festivity is a singleton switch" with the text
  "Festivity is a secured singleton switch".

Amend Rule 869 as follows:

  Delete the text "Changes to citizenship are secured.".

  Replace the text "Citizenship is a person switch" with the text
  "Citizenship is a secured person switch".

Amend Rule 478 as follows:

  Delete the text "Changes to publicity are secured.".

  Replace the text "Publicity is a forum switch" with the text
  "Publicity is a secured forum switch.".""")
            }

            proposal(8242) {
                title("Let the dead rest")
                ai(3.0)
                author(Falsifian)

                text("""
If Hālian is a zombie, then deregister em.
[Comment: eir resale value was 0 before R. Lee deregistered, so e was
due to be deregistered.]

Append the following sentence to the end of the first paragraph of
Rule 2532 (Zombies):

  When a zombie's master ceases to be a player, the value of the zombie's
  master switch is set to Agora.""")
            }

        }

        voting {
            votes(JasonCobb) {
                FOR on 8235
                FOR on 8236
                FOR on 8237
                FOR on 8238
                FOR on 8239
                FOR on 8240
                FOR on 8241
                FOR on 8242
            }

            votes(twg) {
                FOR on all
            }

            votes(JacobArduino) {
                endorses(twg) on all
            }
        }
    }
}