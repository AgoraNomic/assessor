package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.lib.UseAssessment
import org.agoranomic.assessor.lib.VoteKind.*
import org.agoranomic.assessor.lib.assessment
import org.agoranomic.assessor.lib.endorse

@UseAssessment
fun `assessment 8266 to 8274`() = assessment {
    name("8266-8274")
    quorum(8)

    strengths {
        default(3)
        G strength 4 comment PM
    }

    proposals {
        proposal(8266) {
            title("Glitter")
            ai(1.0)
            author(nch)

            text(
                """
Enact a Power-1 rule titled "Glitter" with the following text {

  If a player has earned a ribbon in the past 7 days but already owned it e CAN
  once (until e earns another ribbon), by announcement, earn N+1 coins where
  N is the number of current players that do not own the same ribbon.

}"""
            )
        }

        proposal(8267) {
            title("Emerald Ribbons")
            ai(3.0)
            author(JasonCobb)

            text(
                """
Amend Rule 2438 ("Ribbons") by appending the following paragraph:

  Emerald (E): When a person wins an election, e earns an Emerald Ribbon.


[There's already a ribbon for deputisation, so why shouldn't there be
one for the other way to acquire an office? Also, this is an incentive
to initiate and become candidates in elections.]"""
            )
        }

        proposal(8268) {
            title("Deputisation fix")
            ai(3.0)
            author(JasonCobb)

            text(
                """
Amend Rule 2160 ("Deputisation") by replacing the text "acting on eir
own behalf" with the text "acting as emself".

[Per CFJ 2637, taking actions within a public message is not acting on
the behalf of oneself, so it may currently be impossible to deputise
without some shenanigans. "Acting as emself" appears to be the standard
way of phrasing this requirement.]"""
            )
        }

        proposal(8269) {
            title("Clean up distribution mechanisms")
            ai(3.0)
            author(omd)

            text(
                """
Amend Rule 1607 (Distribution) by replacing;

  The Promotor CAN distribute a proposal which is in the Proposal
  Pool at any time, by announcement.

with:

  The Promotor CAN distribute a proposal which is in the Proposal
  Pool at any time.

[The "by announcement" is redundant with Rule 107's 'notice publication'
method, and IIRC there was a judgement that the two rules actually provide two
separate mechanisms for distributing proposals.]"""
            )
        }

        proposal(8270) {
            title("Self-ratifying statements")
            ai(3.0)
            author(omd)

            text(
                """
[Create a mechanism for a public message to be defined as self-ratifying a
statement that's not in the message.

Currently, Rule 2034 does this in a strange implicit way, by saying that the
message "constitutes self-ratifying claims that" such-and-such.  I'd call it
dubious, but according to CFJ 3618 as recorded in a FLR annotation (I can't
find the original judgement), it does work, even if the message in question
*explicitly disclaims* the such-and-such.  Still, it's better to organize
things in a way that avoids counterfactual assumptions.

Convert two rules to use the new mechanism: Rule 2034, and Rule 107, which
previously vaguely mentioned an error being "correctly identified within one
week".  The new wording also requires clarity, as I also proposed separately
(if both proposal pass, this overwrites the wording from the other).]

Amend Rule 1551 (Ratification) by replacing:

  When a public document is ratified

with:

  When a document or statement (hereafter "document") is ratified

and by replacing:

  Ratifying a public document is secured with power threshold 3.

with:

  Ratification is secured with power threshold 3.

and by removing:

  A public document is part (possibly all) of a public message.

[moved to R2202]

Amend Rule 2202 (Ratification Without Objection) by prepending the paragraph:

  A public document is part (possibly all) of a public message.

Amend Rule 2201 (Self-Ratification) by replacing:

  A public document defined by the rules as self-ratifying is
  ratified when it is continuously undoubted for one week.

  A doubt is an explicit public challenge via one of the following
  methods, identifying a document and explaining the scope and
  nature of a perceived error in it:

with:

  When a public document is continuously undoubted for one week
  after publication:

  - If the rules define it as self-ratifying, it is ratified.

  - If the rules define it as a self-ratifying attestation to a
    given statement, the statement is ratified.

    This clause is inapplicable if the statement to be ratified
    cannot be reasonably ascertained from the ruleset and the
    contents of the message.

  A doubt is an explicit public challenge via one of the following
  methods, identifying a document and explaining the scope and
  nature of a perceived error in it (or in a statement it attests
  to):

Amend Rule 107 (Initiating Agoran Decisions) by replacing the second
sentence with:

  To be valid, the notice must clearly specify the following
  information:

and by appending the paragraph:

  A public notice purporting to initiate an Agoran decision is a
  self-ratifying attestation of the notice's validity.

Amend Rule 2034 (Vote Protection and Cutoff for Challenges) by replacing:

  A public message purporting to resolve an Agoran decision
  constitutes self-ratifying claims that
with:

  A public message purporting to resolve an Agoran decision
  is a self-ratifying attestation that"""
            )
        }

        proposal(8271) {
            title("Doctorate expectations")
            ai(3.0)
            author(G)

            text(
                """
[Puts in a time requirement for Doctorates, also fixes bug]


Change the Power of Rule 1367 (Degrees) to 2.
[I've wondered for a while why we need this at 3!]


Amend Rule 1367 (Degrees) by replacing its last paragraph with:
  A specified degree CAN be awarded by any player other than the
  awardee, with 2 Agoran consent.  It SHOULD only be awarded for the
  publication of an original thesis of scholarly worth (including
  responses to peer-review), published with explicit intent to qualify
  for a degree. Any degree with D.N. as part of its abbreviation
  SHOULD take into account the awardee's academic history and participation
  in Agora over time. The Herald SHOULD coordinate the peer-review process
  and the awarding of degrees."""
            )
        }

        proposal(8272) {
            title("The Fat Director")
            ai(2.0)
            author(Murphy)
            coauthors(Gaelan, G)

            text(
                """
Amend Rule 2193 (The Registrar) by removing this text:

  The Registrar is also responsible for tracking any switches,
  defined in a rule, that would otherwise lack an officer to track
  them, unless the switch is defined as untracked.

Amend Rule 2423 (First Among Equals) by removing this text:

  The Prime Minister is responsible for tracking any switches
  defined by the rules, not defined as untracked, and not defined
  as tracked by another officer.

Create a rule titled "The Fat Director" with Power 2 and this text:

  The Fat Director is an imposed office.

  A loose switch is a switch defined by the rules, not defined as
  untracked, and not defined as tracked by an officer other than the
  Fat Director. The Fat Director is responsible for tracking any
  loose switches.

  When a proposal creates a loose switch or causes a switch to
  become loose, the Fat Director is set to the author of that
  proposal. If the Fat Director is vacant and any loose switches
  exist, then the Registrar CAN set the Fat Director to any player
  by announcement. Any player CAN become the Fat Director by
  announcement.

[Would have called it "Fat Controllor", but that would be too close
to "Comptrollor", and I didn't want to merge it with that either.]"""
            )
        }

        proposal(8273) {
            title("Clean up your own mess, without making a bigger one")
            ai(1.0)
            author(Gaelan)
            coauthors(JasonCobb)

            text(
                """
Remove the following paragraph from Rule 2139 “The Registrar”: {
  The Registrar is also responsible for tracking any switches,
  defined in a rule, that would otherwise lack an officer to track
  them, unless the switch is defined as untracked.
}

Create a power-1 rule titled “Switch Responsibility” with the following text: {
  For each type of switch which would otherwise lack an officer to track it,
  and is not defined as untracked, there exists an imposed office named
  “Tracker of [switch name]” that is responsible for tracking that switch.
}

[1006/44 states:
    When a proposal takes effect and creates a new office, if the
    proposal does not specify otherwise, the author of that proposal
    becomes the holder of the office.

I think this works, but we might need to clarify the meaning of
“creates a new office” to be sure.]"""
            )
        }

        proposal(8274) {
            title("Interested proposals")
            ai(1.0)
            author(Murphy)
            coauthors(Oerjan)

            text(
                """
Create a rule titled "Interested Proposals" with this text:

  Interest is an untracked proposal switch with values
  "disinterested" (default) and "interested". The author of a
  proposal in the Proposal Pool CAN flip its Interest to Interested
  by paying a fee of 5 coins, or by announcement if e most recently
  registered less than 3 months ago.

Amend Rule 2496 (Rewards) by replacing this text:
  * Being the author of an adopted proposal:
with this text:
  * Being the author of an adopted interested proposal:"""
            )
        }
    }

    voting {
        votes(Aris) {
            FOR on 8266
            FOR on 8267
            FOR on 8268
            FOR on 8269
            FOR on 8270
            FOR on 8271
            AGAINST on 8272
            FOR on 8273
            AGAINST on 8274
        }

        votes(JasonCobb) {
            FOR on 8266
            FOR on 8267
            FOR on 8268
            FOR on 8269
            FOR on 8270
            FOR on 8271
            PRESENT on 8272
            PRESENT on 8273
            AGAINST on 8274
        }

        votes(CuddleBeam) {
            AGAINST on 8271
            FOR on others
        }

        votes(Bernie) {
            endorse(JasonCobb) on all
        }

        votes(Falsifian) {
            FOR on 8266 comment NO_VETO
            FOR on 8267
            FOR on 8268
            PRESENT on 8269
            PRESENT on 8270
            FOR on 8271
            AGAINST on 8272
            FOR on 8273 comment NO_VETO
            FOR on 8274 comment NO_VETO
        }

        votes(ATMunn) {
            endorse(Falsifian) on all
        }

        votes(G) {
            FOR on 8266
            FOR on 8267
            FOR on 8268
            endorse(Aris) on 8269
            FOR on 8270
            FOR on 8271
            FOR on 8272
            AGAINST on 8273
            AGAINST on 8274
        }

        Rance matches G
    }
}
