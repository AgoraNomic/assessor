package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.ministries.Office_2020_06_30.*
import org.agoranomic.assessor.dsl.ministries.ministries_2020_08_02
import org.agoranomic.assessor.dsl.ministries.officeMapOf
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.addToHolder
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.lib.proposal.MinistryV1.Justice
import org.agoranomic.assessor.lib.proposal.MinistryV1.Legislation
import org.agoranomic.assessor.lib.vote.VoteKind.FOR
import org.agoranomic.assessor.lib.vote.VoteKind.PRESENT

@UseAssessment
fun assessment8500to8503() = assessment {
    name("8500-8503")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-September/014240.html")
    quorum(5)

    val offices = officeMapOf(
        ADoP to Murphy,
        Arbitor to G,
        Assessor to Jason,
        Coopor to RLee,
        Distributor to omd,
        Herald to PSS,
        Notary to ATMunn,
        PrimeMinister to nix,
        Promotor to Aspen,
        Referee to PSS,
        Registrar to Falsifian,
        Rulekeepor to Jason,
        Speaker to grok,
        Tailor to PSS,
        Treasuror to Trigon,
        Webmastor to nix,
    )

    strengths {
        default(3)
        min(0)
        max(15)

        blotPenalty(Gaelan, 4 / 3)
        blotPenalty(RLee, 81 / 3)

        addToHolder(offices, Speaker, 1)
        ministries_2020_08_02(offices, allProposals)
    }

    proposals(v2) {
        proposal(8500) {
            title("Clarify asset ownership some more")
            ai("3.0")
            author(Murphy)
            coauthors(G)
            democratic()

            text("""
Amend Rule 2576 (Ownership) by replacing this text:

  If an asset's owner would otherwise be nonexistent, indeterminate,
  or invalid, then it is owned by the Lost and Found Department (if
  possible) or destroyed (otherwise), subject to modification by its
  backing document.

with this text:

  An asset "in abeyance" is one whose owner is nonexistent,
  indeterminate, or invalid. If an asset would otherwise be in
  abeyance, then it is owned by the Lost and Found Department (if
  possible) or destroyed (otherwise), subject to modification by its
  backing document (provided that the modification either destroys
  it or prevents it from being in abeyance).""")
        }

        proposal(8501) {
            title("Statutes are Instruments")
            ai("3.0")
            author(Jason)
            coauthors(Gaelan)
            democratic()

            text("""
Amend Rule 2612 by replacing the sentence beginning "The statutes of
Agora form a body of law" with the following: "The statutes of Agora
form a body of law with unlimited scope, where each statute is a single
instrument in that body of law."""")
        }

        proposal(8502) {
            title("Timely reminders")
            ai("1.0")
            author(Jason)
            coauthors(Aspen)
            chamber(Legislation)
            sponsored()

            text("""
Amend Rule 2168 by replacing  the text "Upon such an occurrence" with
the text "Within four days of such an occurrence"""")
        }

        proposal(8503) {
            title("Assorted Obligatory Patches")
            ai("2.2")
            author(Aspen)
            coauthors(G, nix, Jason)
            chamber(Justice)
            sponsored()

            text("""
Chamber: Justice


[Breaking pledges is currently not ILLEGAL. Pledges can arguably
be created without consent. Rule 2450 does not actually delegate
selection of crime class to the pledge at present, and simply fails to
specify its class if the pledge does.

Current text:
Rule 2450/9 (Power=1.7)
Pledges

  If a Player makes a clear public pledge (syn. Oath) to perform (or
  refrain from performing) certain actions, then breaking the pledge
  within the pledge's time window is the Class N crime of
  Oathbreaking, where N is 2 unless the pledge explicitly states
  otherwise. It is also Oathbreaking for a player to let a pledge
  expire without taking an action e pledged to do in that pledge.
  The time window of a pledge is 60 days, unless the pledge
  explicitly states otherwise. A pledge ceases to exist at the end
  of its time window.

  If breaking the pledge harms specific other parties, the Referee
  SHOULD solicit the opinion of those parties in determining an
  appropriate fine.

  The Notary CAN destroy a pledge Without Objection, but SHOULD NOT
  do so unless the pledge no longer serves any significant purpose.
]

Amend Rule 2450, "Pledges", by changing it to read in full:

  If a consenting Player makes a clear public pledge (syn. Oath) to perform
  (or refrain from performing) certain actions, then breaking the pledge
  is ILLEGAL; doing so is the Class N crime of Oathbreaking, where N is the
  value explicitly stated by the pledge, or 2 if the pledge does not explicitly
  state a value. Allowing a pledge to expire without carrying out an action
  one pledged to do in it constitutes breaking the pledge.

  The time window of a pledge is W days, where W is the value explicitly
  stated by the pledge, or 60 if the pledge does not explicitly state a
  value. A pledge ceases to exist at the end of its time window.

  If breaking the pledge harms specific other parties, the Referee
  SHOULD solicit the opinion of those parties in determining an
  appropriate fine.

  The Notary CAN destroy a pledge Without Objection, but SHOULD NOT
  do so unless the pledge no longer serves any significant purpose.


[Promises can arguably be created without consent. Currently the rule purports
to authorize non-player persons to create promises, which is pretty pointless
and doesn't really work because non-players can't own promises. In addition,
currently one must grant oneself a promise and then transfer it; this is an
unnecessary extra step.]

Amend Rule 2618, "Promises", by replacing:

  A person CAN, by announcement, grant emself a promise, specifying its text
  and becoming its creator.

with:

  A consenting player CAN, by announcement, grant a specified entity a promise,
  specifying its text and becoming its creator.

[Currently it is arguably the reports and the tabular data that is in violation
of the rule.]
Amend Rule 2143, "Official Reports and Duties", by replacing:

  Reports SHALL be published in plain text. Tabular data must line
  up properly when viewed in a monospaced font. Publishing a report
  that deviates from these restrictions is the Class 2 Crime of
  Making My Eyes Bleed.

with:

  An officer SHALL publish eir report in plain text, with tabular data lining
  up properly when viewed in a monospaced font. Publishing a report
  that deviates from these restrictions is the Class 2 Crime of
  Making My Eyes Bleed.""")
        }
    }

    voting {
        votes(Aspen) {
            FOR on 8500
            PRESENT on 8501
            FOR on 8502
            FOR on 8503
        }

        votes(Telna) {
            endorse(Aspen) on all
        }

        votes(Murphy) {
            FOR on 8500
            FOR on 8501
            FOR on 8502
            FOR on 8503
        }

        votes(Jason) {
            FOR on 8500
            FOR on 8501
            FOR on 8502
            FOR on 8503
        }

        votes(BaronVV) {
            endorse(Jason) on all
        }

        votes(ATMunn) {
            endorse(G) on 8500
            PRESENT on 8501
            FOR on 8502
            FOR on 8503
        }

        votes(Falsifian) {
            endorse(Murphy) on 8500
            endorse(Jason) on 8501
            endorse(Jason) on 8502
            PRESENT on 8503
        }
    }
}
