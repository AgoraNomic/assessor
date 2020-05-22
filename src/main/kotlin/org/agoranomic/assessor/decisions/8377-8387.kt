package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun `assessment 8377 to 8387`() = assessment {
    name("8377-8387")
    quorum(5)

    proposals(v1) {
        proposal(8377) {
            title("Burden + Accurate Naming")
            ai("2.0")
            author(RLee)

            text(
                """
WHEREAS an elementary aspect of legal traditions that we all share is that
no criminal defendant should bear the burden of proof, and that the Agoran
system of criminal justice fails in other basic respects the people of
Agora HEREBY RESOLVE the following
  Retitle rule 2531 to "Defendant's Rights"
  Retitle rule 2479 to "Official Injustice"
  Amend the following text in rule 2531 "(1) it attempts to levy a fine on a
  person for an action or inaction which e (more likely than not) did not
  commit" to state "(1) it attempts to levy a fine on a person when that
  person can't be established by a preponderance of the evidence to have
  committed the action or inaction for which the fine was levied""""
            )
        }

        proposal(8378) {
            title("Bug Fixing IAR Writ")
            ai("2.0")
            author(RLee)

            text(
                """
Amend the following paragraph in rule 2531 "

  If the Referee attempts to levy three or more INEFFECTIVE fines
  in a week, any player CAN, with two support, issue a writ of
  Impartial Arbitration Restoration, immediately making the
  position of Referee vacant. When a writ of Impartial Arbitration
  Restoration is issued, the ADoP SHALL initiate an election for
  the Referee in a timely fashion.

"

so that it states

  If the Referee attempts to levy three or more INEFFECTIVE fines in a week,
  any player CAN, within two Agoran weeks of that week, issue a writ of
  Impartial Arbitration Restoration with two support, immediately making the
  position of Referee vacant. When a writ of Impartial Arbitration
  Restoration is issued, an election SHOULD be initiated in a timely fashion."""
            )
        }

        proposal(8379) {
            title("Expand wins by paradox")
            ai("1.0")
            author(Murphy)

            text(
                """
Amend Rule 2553 (Win by Paradox) by replacing this text:

  If a CFJ about the legality or possibility of a game action,

with this text:

  If a CFJ about the effectiveness, possibility, or legality of a
  change in the gamestate"""
            )
        }

        proposal(8380) {
            title("Justice for R. Lee")
            ai("1.0")
            author(Murphy)

            text(
                """
Award R. Lee the Patent Title of Champion, unless e has already been
awarded it in connection with CFJ 3828."""
            )
        }

        proposal(8381) {
            title("You Tried")
            ai("1.0")
            author(Murphy)

            text(
                """
Award R. Lee the Patent Title of Money Launderer."""
            )
        }

        proposal(8382) {
            title("You Tried")
            ai("1.0")
            author(nch)

            text(
                """
Enact a rule titled "The Webmastor" with Power=1 and the following text:

  The Webmastor is an office.

  The Webmastor's monthly report includes a Directory, a Changelog, a
  Warning Log, and an Error Log. The Directory lists notable
  currently maintained public resources. The Changelog lists notable
  changes to resources. The Warning Log lists notable potential
  issues, such as inaccurate or aging resources or unintended issues
  with a public resource. The Error Log lists notable losses of
  resources - where a resource has become inaccessible, unmaintained,
  or unusable. Where 'notable' is used in this rule its meaning is up
  to the Webmastor's discretion."""
            )
        }

        proposal(8383) {
            title("Agora plays table tennis")
            ai("1.0")
            author(Trigon)

            text(
                """
Create a new rule entitled "Ping Pong" with Power=0.1 that reads:

  The first public message sent by a player each Agoran day must
  begin with the word ping (case-insensitive). The second public
  message sent by a player each Agoran day must end with the word
  pong (case-insensitive).

  If a player fails to include ping or pong as mandated by the
  previous paragraph, then, in that same Agoran day, any player CAN
  once revoke one coin from em."""
            )
        }

        proposal(8384) {
            title("Bones of Criminals")
            ai("1.0")
            author(PSS)

            text(
                """
Create a new rule entitled "Criminal Ossification" with Power 1 that reads:

  To take any action that would cause Agora to become ossified,
  notwithstanding Rule 1698, is the Class 8 Crime of Ossification."""
            )
        }

        proposal(8385) {
            title("Slaying the dragon")
            ai("1.0")
            author(Jason)

            text(
                """
For the purposes of this proposal, the Dragon Corporation is the
contracted created on or about March 1, 2020 by Warrigal.

For each coin owned by the Dragon Corporation, transfer that coin to the
Lost and Found Department.

Destroy the Dragon Corporation."""
            )
        }

        proposal(8386) {
            title("Restraining Motions")
            ai("3.0")
            author(G)

            text(
                """
Amend Rule 2496 (Rewards) by replacing:
  * Judging a CFJ that e was assigned to without violating a time
    limit to do so: 5 coins (Arbitor).
with:
  * Judging a CFJ that e was assigned to without violating a time
    limit to do so, unless at the time of judgement the case was
    open due to self-filing a motion to reconsider it: 5 coins
    (Arbitor).


Amend Rule 2438 (Ribbons) by replacing:
  Blue (B): When a person assigns a judgement to a CFJ, and has
  never violated a time limit to assign a judgement to that CFJ,
  that person earns a Blue Ribbon.
with:
  Blue (B): When a person assigns a judgement to a CFJ, and has
  never violated a time limit to assign a judgement to that CFJ,
  nor ever self-filed a motion to reconsider that CFJ, that person
  earns a Blue Ribbon."""
            )
        }

        proposal(8387) {
            title("Defense Against the Dark Arts")
            ai("1.0")
            author(Aris)
            coauthors(PSS)

            text(
                """
If a rule entitled "Criminal Ossification" exists, repeal it.

Enact a new power 1.0 rule entitled "Defense Against the Dark Arts" with the
following text:
  A proposal is forbidden if it would, upon successfully taking effect,
  cause Agora to be ossified or to cease to exist.  An action is forbidden
  if it would, upon its successful occurrence, cause Agora to be ossified or to
  cease to exist.

  Attempting a forbidden action is PROHIBITED, and is the Class-8 Crime of
  Engaging in Forbidden Arts.

  Submitting a forbidden proposal is PROHIBITED, and is the Class-4 Crime of
  Contemplating Forbidden Arts.

  Being the author of an adopted forbidden proposal is PROHIBITED, and is the
  Class-4 Crime of Suborning Forbidden Arts.

  Having a final ballot that evaluates to FOR in the Agoran decision on whether
  to adopt a forbidden proposal is PROHIBITED, and is the Class-2 Crime of
  Abetting Forbidden Arts."""
            )
        }
    }
}
