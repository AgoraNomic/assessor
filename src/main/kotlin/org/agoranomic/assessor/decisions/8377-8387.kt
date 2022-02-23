package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.ministries.OfficeInitial.*
import org.agoranomic.assessor.dsl.ministries.endorseOfficer
import org.agoranomic.assessor.dsl.ministries.ministries_2020_04_02
import org.agoranomic.assessor.dsl.ministries.officeMapOf
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.addToHolder
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.match
import org.agoranomic.assessor.lib.proposal.MinistryV1.*
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8377to8387() = assessment {
    name("8377-8387")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-May/013683.html")
    quorum(5)

    val offices = officeMapOf(
        ADoP to Murphy,
        Arbitor to G,
        Assessor to Jason,
        Comptrollor to omd,
        Distributor to omd,
        Herald to PSS,
        Notary to RLee,
        PrimeMinister to Aspen,
        Promotor to Aspen,
        Referee to PSS,
        Registrar to Falsifian,
        Rulekeepor to Jason,
        Speaker to Trigon,
        Tailor to PSS,
        Treasuror to Trigon
    )

    strengths {
        default(3)
        min(0)
        max(15)

        ministries_2020_04_02(offices, allProposals)
        addToHolder(offices, Speaker, 1)
    }

    proposals(v1) {
        proposal(8377) {
            title("Burden + Accurate Naming")
            ai("2.0")
            author(RLee)
            chamber(Justice)

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
            chamber(Efficiency)

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
            chamber(Participation)

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
            chamber(Participation)

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
            chamber(Participation)

            text(
                """
Award R. Lee the Patent Title of Money Launderer."""
            )
        }

        proposal(8383) {
            title("Agora plays table tennis")
            ai("1.0")
            author(Trigon)
            chamber(Participation)

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
            chamber(Justice)

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
            chamber(Economy)

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
            democratic()

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
    }

    voting {
        votes(Aspen) {
            AGAINST on 8377
            AGAINST on 8378
            PRESENT on 8379
            AGAINST on 8380
            FOR on 8381
            // FOR on 8382
            AGAINST on 8383
            AGAINST on 8384
            AGAINST on 8385
            FOR on 8386
            // FOR on 8387
        }

        votes(PSS) {
            AGAINST on 8377
            FOR on 8378
            AGAINST on 8379
            AGAINST on 8380
            FOR on 8381
            // FOR on 8382
            AGAINST on 8383
            AGAINST on 8384
            AGAINST on 8385 comment legacyConditionalComment("Aris and Jason voted AGAINST on this proposal")
            FOR on 8386
            // FOR on 8387
        }

        votes(Trigon) {
            PRESENT on 8377
            AGAINST on 8378
            FOR on 8379
            FOR on 8380
            FOR on 8381
            // FOR on 8382
            FOR on 8383
            AGAINST on 8384
            PRESENT on 8385
            FOR on 8386
            // NO VOTE on 8387
        }

        votes(nix) {
            PRESENT on 8377
            AGAINST on 8378
            FOR on 8379
            endorseOfficer(offices, Herald) on 8380
            FOR on 8381
            // FOR on 8382
            AGAINST on 8383
            PRESENT on 8384
            AGAINST on 8385
            FOR on 8386
            // NO VOTE on 8387
        }

        votes(Jason) {
            PRESENT on 8377
            PRESENT on 8378
            FOR on 8379
            endorse(Aspen) on 8380
            FOR on 8381
            // endorse(nch) on 8382
            PRESENT on 8383
            AGAINST on 8384
            AGAINST on 8385
            FOR on 8386
            // NONEXISTENT on 8387
        }

        votes(ATMunn) {
            endorse(Jason) on all
        }

        votes(G) {
            FOR on 8377
            AGAINST on 8378
            AGAINST on 8379
            AGAINST on 8380
            FOR on 8381
            // FOR on 8382
            PRESENT on 8383
            AGAINST on 8384
            PRESENT on 8385
            FOR on 8386
            // AGAINST on 8387
        }

        votes(pikhq) {
            match(G) on all
        }

        votes(Murphy) {
            FOR on 8377
            PRESENT on 8378
            FOR on 8379
            AGAINST on 8380
            FOR on 8381
            // FOR on 8382
            AGAINST on 8383
            FOR on 8384
            PRESENT on 8385
            FOR on 8386
            // FOR on 8387
        }

        votes(RLee) {
            FOR on 8377
            AGAINST on 8378
            FOR on 8379
            AGAINST on 8380
            FOR on 8381
            // FOR on 8382
            FOR on 8383
            AGAINST on 8384
            AGAINST on 8385
            FOR on 8386
            // DENIAL OF EXISTENCE on 8387
        }

        votes(Falsifian) {
            endorse(RLee) on 8377
            AGAINST on 8378
            endorse(PSS) on 8379 comment NO_VETO
            AGAINST on 8380
            PRESENT on 8381 comment NO_VETO
            // endorse(nch) unless veto on 8382
            PRESENT on 8383 comment NO_VETO
            AGAINST on 8384
            PRESENT on 8385 comment NO_VETO
            endorse(G) on 8386
            // NO VOTE on 8387
        }

        votes(Tcbapo) {
            endorse(Falsifian) on all
        }
    }
}
