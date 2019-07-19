package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.lib.AssessmentData
import org.agoranomic.assessor.lib.VoteKind.*
import org.agoranomic.assessor.lib.assessment

fun `assessment 8202 to 8214`(): AssessmentData {
    return assessment {
        name("8202-8214")
        quorum(7)

        // TODO update for time of assessment
        strengths {
            default(3)

            G strength 4 comment PM
            Corona strength 1 comment BLOTS
            twg strength 2 comment BLOTS
        }

        proposals {
            proposal(8202) {
                title("Police Power")
                ai(1.7)
                author(JasonCobb)

                text(
                    """
In Rule 2557, replace the first paragraph with:

  When the rules authorize an investigator to impose the Cold Hand
  of Justice for a violation, e CAN do so by levying a fine of B on
  the perp by announcement, within the following guidelines:

and add a new list item at the start of the list (that is, right after
the first paragraph), with the text:

  - B is at least 1 and at most twice the base value of the
    violation.

Retitle Rule 2557 to "Sentencing Guidelines".

[Comment: Rule 2557 is currently titled "Removing Blots". When I tried
to understand why, I noticed that the 2018-04-07 SLR lists two Rule
2557s, one of which actually is about removing blots, and the other of
which is titled "Sentencing Guidelines". The next SLR I could find is
published much later, 2018-10-14, and has R2557 in or close to its
current form. I don't know exactly what happened there.]"""
                )
            }

            proposal(8203) {
                title("Fixing Summary Judgement")
                ai(2.0)
                author(JasonCobb)

                text(
                    """
Amend Rule 2531 ("Referee Accountability") as follows:

  After list item (1) insert the following phrase: "Any attempt to
  levy a fine pursuant to the imposition of the Cold Hand of Justice
  is INEFFECTIVE if:"

  Renumber list items (2) - (8) to be items (1) - (7) in the new list."""
                )
            }

            proposal(8204) {
                title("SMH @ Herald")
                ai(1.0)
                author(RLee)

                text(
                    """
1. Halve (rounding towards 0) the Karma of every Unregistered person.

2. Set the Karma of Agora such that the sum of all Karma switch
instance values in the game is equal to 0."""
                )
            }

            proposal(8205) {
                title("Timing proposal w/ no effect")
                ai(1.7)
                author(RLee)

                text(
                    """
R. Lee pledges to timely transfer half of the money e gains from  the
adoption of this proposal to the last person to vote FOR this proposal."""
                )
            }

            proposal(8206) {
                title("Rule 2472 Simplification")
                ai(2.0)
                author(JasonCobb)

                text(
                    """
[Comment: use "with Notice" instead of writing it out.]

Replace the last paragraph of Rule 2472 ("Office Incompatibilities")
with the following paragraph:

  If a player is Overpowered, any player CAN, with Notice, Demand
  Resignation from em. When this occurs, each office that the
  Overpowered player holds becomes vacant."""
                )
            }

            proposal(8207) {
                title("no power is all powerful")
                ai(1.0)
                author(G)

                text(
                    """
Create the following Rule, "Supreme Power", Power=4:

  G. CAN make arbitrary changes to the gamestate by announcement."""
                )
            }

            proposal(8208) {
                title("Regulated actions reform (v2)")
                ai(3.0)
                author(JasonCobb)
                coauthors(Aris, omd, G, Falsifian)

                text(
                    """
[Comment: see proto thread for changes and rationales.]


Amend Rule 2493 ("Regulations") as follows:

  Append the following text to the first paragraph: "Regulations are
  binding."


Amend Rule 1742 ("Contracts") as follows:

  Append the following sentence to the first paragraph: "Contracts are
  binding."


Amend Rule 2125 ("Regulated Actions") to read:

  An entity is binding if and only if the Rules designate it as such.
  The Rules as a whole is an entity that is binding; this entity is
  known as the ruleset.

  An action is regulated by a binding entity if: (1) the entity
  directly and explicitly defines, limits, allows, enables, permits,
  forbids, or requires its performance; (2) the entity describes the
  circumstances under which the action would succeed or fail; or (3)
  the action would, as part of its effect, modify information for
  which the entity requires some player to be a "recordkeepor".

  When a binding entity explicitly defines an action, describes the
  possibility of performing an action, or describes the methods by
  which an action can be performed, it creates an action that is
  distinct from all other actions; the binding entity is said to "own"
  this created action. A binding entity CAN only state that it
  requires or forbids an action that it does not own; it CANNOT modify
  any other properties of the action.

  An action that is owned by a binding entity CAN only be performed as
  described by the entity, and only using the methods explicitly
  specified in the entity for performing the given action.
  Interpretations that result in the entity directly proscribing
  actions that are not regulated by it are invalid.


Retitle Rule 2125 to "Binding Entities".

Set the power of Rule 2125 to 3.1."""
                )
            }

            proposal(8209) {
                title("AFK Reform Act v1.1")
                ai(2.0)
                author(DMargaux)
                coauthors(G, JasonCobb)

                text(
                    """
Amend rule 2532 as follows:

Add this sentence:

  "A player CAN by announcement pay 10 coins to Agora to flip to emself
  another player's master switch without objection from that other player
  or that other player's master (if any), provided the intent to flip that
  switch was announced at least 7 days before the switch is flipped."

Immediately following this sentence:

  "A zombie's master CAN flip that zombie's master switch to Agora
  by announcement.""""
                )
            }

            proposal(8210) {
                title("Single-party Contracts")
                ai(2.5)
                author(JasonCobb)

                text(
                    """
Amend Rule 1742 ("Contracts") by replacing the text "Any group of two or
more" with the text "Any group of one or more"."""
                )
            }

            proposal(8211) {
                title("Law School")
                ai(3.0)
                author(G)

                text(
                    """
In R1367, Insert the following line between the line starting
"- Associate" and the line starting "- Bachelor":
    - Juris Doctor of Nomic                  (J.N.)

In R1367, Insert the following line between the line starting
"- Doctor of Nomic History" and the line starting
"- Doctor of Nomic Science":
    - Doctor of Nomic Law                (D.N.Law.)

If Falsifian has not been awarded a degree, Award Falsifian the degree
of J.N."""
                )
            }

            proposal(8212) {
                title("Rule Recreation Reversal")
                ai(3.0)
                author(JasonCobb)

                text(
                    """
Repeal Rule 2517."""
                )
            }

            proposal(8213) {
                title("Space Fixes")
                ai(1.0)
                author(nch)

                text(
                    """
Amend rule 2591 "Spaceships" by changing:

  * Armour (an integer switch limited to values less than or equal to
    10).

to:

  * Armour (an integer switch limited to values less than or equal to
    10, defaulting to 10).

and by appending the following to the end of the rule:

  If a player does not have a spaceship in eir possession e CAN, by
  announcement, create a spaceship in eir possession.

Flip every spaceships' Armour switch to 10."""
                )
            }

            proposal(8214) {
                title("Space Isn't Linear")
                ai(1.0)
                author(nch)

                text(
                    """
Amend rule 2588 "Sectors" by appending, after the final sentence, the
following:

  If a sector exists with an ID equivalent to the current month of
  the year, and a sector exists with an ID equivalent to the current day
  of the month then those sectors are adjacent."""
                )
            }
        }

        voting {
            votes(Aris) {
                FOR on 8202
                PRESENT on 8203
                // TODO resolve conditional vote on 8204: AGAINST IF VETO ELSE FOR
                AGAINST on 8205
                FOR on 8206
                AGAINST on 8207
                AGAINST on 8208
                AGAINST on 8209
                FOR on 8210
                FOR on 8211
                FOR on 8212
                // TODO resolve conditional vote on 8213: AGAINST IF VETO ELSE FOR
                // TODO resolve conditional vote on 8214: AGAINST IF VETO ELSE FOR
            }

            votes(nch) {
                FOR on 8202
                AGAINST on 8203
                PRESENT on 8204
                // TODO resolve conditional vote on 8205: FOR unless anybody votes FOR after nch otherwise AGAINST
                FOR on 8206
                // TODO resolve conditional vote on 8207: FOR if G. pledges to give nch a black ribbon else AGAINST
                PRESENT on 8208
                FOR on 8209
                AGAINST on 8210
                FOR on 8211
                FOR on 8212
                FOR on 8213
                FOR on 8214
            }

            votes(JasonCobb) {
                FOR on 8202
                FOR on 8203
                // TODO resolve conditional vote on 8204: AGAINST IF VETO ELSE FOR
                AGAINST on 8205
                FOR on 8206
                AGAINST on 8207
                FOR on 8208
                AGAINST on 8209
                FOR on 8210
                FOR on 8211
                FOR on 8212
                // TODO resolve conditional vote on 8213: AGAINST IF VETO ELSE FOR
                // TODO resolve conditional vote on 8214: AGAINST IF VETO ELSE FOR
            }

            votes(Trigon) {
                FOR on 8202
                PRESENT on 8203
                // TODO resolve conditional vote on 8204: AGAINST IF VETO ELSE FOR
                PRESENT on 8205
                FOR on 8206
                // TODO resolve conditional vote on 8207: FOR if G. transfers 766 Coins to Trigon by time of resolution, else AGAINST
                FOR on 8208
                AGAINST on 8209
                FOR on 8210
                FOR on 8211
                PRESENT on 8212
                // TODO resolve conditional vote on 8213: AGAINST IF VETO ELSE FOR
                // TODO resolve conditional vote on 8214: AGAINST IF VETO ELSE FOR
            }

            votes(DMargaux) {
                // TODO resolve conditional vote on 8202: AGAINST IF VETO ELSE FOR
                // TODO resolve conditional vote on 8203: AGAINST IF VETO ELSE FOR
                // TODO resolve conditional vote on 8204: AGAINST IF VETO ELSE FOR
                // TODO resolve conditional vote on 8205: AGAINST IF VETO ELSE FOR
                AGAINST on 8206
                // NO VOTE on 8207
                PRESENT on 8208
                // TODO resolve conditional vote on 8209: AGAINST IF VETO ELSE FOR
                // TODO resolve conditional vote on 8210: AGAINST IF VETO ELSE FOR
                // TODO resolve conditional vote on 8211: AGAINST IF VETO ELSE FOR
                PRESENT on 8212
                // TODO resolve conditional vote on 8213: AGAINST IF VETO ELSE FOR
                // TODO resolve conditional vote on 8214: AGAINST IF VETO ELSE FOR
            }

            votes(RLee) {
                FOR on 8202
                FOR on 8203
                FOR on 8204
                FOR on 8205
                PRESENT on 8206
                PRESENT on 8207
                AGAINST on 8208
                FOR on 8209
                AGAINST on 8210
                FOR on 8211
                FOR on 8212
                FOR on 8213
                FOR on 8214
            }

            votes(Halian) {
                endorses(RLee) on all
            }

            votes(L) {
                endorses(DMargaux) on all
            }

            votes(Murphy) {
                FOR on 8202
                FOR on 8203
                FOR on 8204
                AGAINST on 8205
                FOR on 8206
                AGAINST on 8207
                FOR on 8208
                AGAINST on 8209
                FOR on 8210
                PRESENT on 8211
                AGAINST on 8212
                FOR on 8213
                FOR on 8214
            }

            votes(twg) {
                endorses(JasonCobb) on 8202
                endorses(JasonCobb) on 8203
                // TODO resolve conditional vote on 8204: AGAINST IF VETO ELSE ENDORSE R. LEE
                // TODO resolve conditional vote on 8205: FOR IF LAST BALLOT CAST TO EVALUATE TO FOR, ELSE AGAINST; IF OTHERWISE INEXTRICABLE, AGAINST
                endorses(DMargaux) on 8206
                AGAINST on 8207
                endorses(JasonCobb) on 8208
                AGAINST on 8209
                AGAINST on 8210
                endorses(G) on 8211
                endorses(JasonCobb) on 8212
                endorses(nch) on 8213
                endorses(nch) on 8214
            }

            votes(JacobArduino) {
                endorses(twg) on all
            }

            votes(G) {
                FOR on 8202
                FOR on 8203
                FOR on 8204
                FOR on 8205 comment "Conditional resolved: \"X=X\" is true"
                FOR on 8206
                FOR on 8207
                PRESENT on 8208
                AGAINST on 8209
                AGAINST on 8210
                FOR on 8211
                FOR on 8212
                PRESENT on 8213
                FOR on 8214
            }

            Telnaior matches G
        }
    }
}