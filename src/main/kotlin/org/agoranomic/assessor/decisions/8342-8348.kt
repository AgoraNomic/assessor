package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.ministries.OfficeInitial.*
import org.agoranomic.assessor.dsl.ministries.endorseOfficer
import org.agoranomic.assessor.dsl.ministries.ministries_2020_02_13
import org.agoranomic.assessor.dsl.ministries.officeMapOf
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.addToHolder
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.match
import org.agoranomic.assessor.lib.proposal.MinistryV1.Justice
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8342to8348() = assessment {
    name("8342-8348")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-March/013518.html")
    quorum(7)

    val offices = officeMapOf(
        ADoP to Murphy,
        Arbitor to G,
        Assessor to Janet,
        Comptrollor to Murphy,
        Distributor to omd,
        Herald to Alexis,
        Notary to Gaelan,
        PrimeMinister to Aris,
        Promotor to Aris,
        Referee to Kate,
        Registrar to Falsifian,
        Rulekeepor to Janet,
        Speaker to Kate,
        Tailor to Kate,
        Treasuror to Kate
    )

    strengths {
        default(3)
        min(0)
        max(15)

        addToHolder(offices, Speaker, 1)
        ministries_2020_02_13(offices, allProposals)
    }

    proposals(v1) {
        proposal(8342) {
            title("Calls with Memoranda")
            ai("2.0")
            author(Gaelan)
            coauthors(Aris, G, Alexis)
            chamber(Justice)

            text(
                """
Create a new Power-2 rule titled “Administrative Opinions”: {
  An officer may publish an Administrative Opinion for a judicial case,
  specifying a valid judgement for that case. Officers SHOULD only assign
  Administrative Opinions to cases with which eir office is primarily concerned.
  The Arbitor SHOULD record Administrative Opinions along with case judgements.
  An officer who has published an Administrative Opinion for an unassigned case
  may, without objection, Administratively Close a case, causing em to become
  the judge for the case and eir Administrative Opinion to become the judgment
  for the case. The Arbitor SHOULD NOT assign a judge to a case while
  proceedings to Administratively Close it are ongoing.
}"""
            )
        }

        proposal(8343) {
            title("Judicial Jocularity Act")
            ai("1.7")
            author(Kate)
            chamber(Justice)

            text(
                """
Amend Rule 591, "Delivering Judgement", by replacing each occurrence of
"DISMISS" with "¯\_(ツ)_/¯".

[Very few CFJs get judged DISMISS at the moment; I figure the generation
 of mirth outweighs the slight inconvenience of having to copy-and-paste
 it from the ruleset occasionally.]"""
            )
        }

        proposal(8344) {
            title("Unsubstantive interpretation")
            ai("3.0")
            author(Alexis)
            democratic()

            text(
                """
Amend Rule 2140 (Power Controls Mutability) by replacing
  'A "substantive" aspect of an instrument is any aspect that affects the
  instrument's operation.'

with

  'A "substantive" aspect of an instrument is any aspect that affects the
  instrument's operation, but does not include its interpretation."
}
[Interpretations between entities of different power are controlled by R217.]"""
            )
        }

        proposal(8345) {
            title("Self-punishment")
            ai("2.0")
            author(Janet)
            chamber(Justice)

            text(
                """
Amend Rule 2555 (Blots) by inserting the following paragraph after the
paragraph beginning "Levying fines and destroying blots":

  A person CAN, by announcement, create a specified number of blots in
  eir possession.

Amend Rule 2535 (Zombies) by inserting the following list item before
the item that says "deregister.":

  - create blots;

[This is intended to allow contracts to provide enforcement mechanisms
other than R1742's general "SHALL act in accordance with that contract".
For example, a contract could grant an Enforcer the ability to act on
behalf of other parties to create blots in the possession of the other
party. This could also, potentially, reduce work on the Referee.

The zombie provision is intended to prevent zombie owners from screwing
over their zombies.]"""
            )
        }

        proposal(8346) {
            title("De-secure Black Ribbons v2")
            ai("3.0")
            author(Janet)
            coauthors(ais523)
            democratic()

            text(
                """
Amend Rule 2438 (Ribbons) by replacing the text "This rule does not
specify any methods of obtaining Black Ribbons." with the text "An
Instrument CAN, as part of its effect, cause a person to earn a Black
Ribbon. When this occurs, this Rule awards that person a Black Ribbon."."""
            )
        }

        proposal(8347) {
            title("R2141 power increase v2")
            ai("3.0")
            author(Janet)
            democratic()

            text(
                """
Set Rule 2141's power to 3.1

[Rationale: Rule 2141 (Role and Attributes of Rules) defines
(unsurprisingly) what rules are and what they can do. This is
sufficiently important that it should take precedence over other power-3
rules. This doesn't protect it from power-3 instruments (since nothing
can), but it does help it from accidentally losing a precedence battle,
especially with its relatively high ID number.]"""
            )
        }

        proposal(8348) {
            title("Summaries Matter")
            ai("3.1")
            author(Gaelan)
            democratic()

            text(
                """
Amend rule 1551 (“Ratification") by replacing the paragraph: {
  An internally inconsistent document generally cannot be ratified;
  however, if such a document can be divided into a summary section
  and a main section, where the only purpose of the summary section
  is to summarize information in the main section, and the main
  section is internally consistent, ratification of the document
  proceeds as if it contained only the main section.
} with: {
  An internally inconsistent document CANNOT be ratified.
}

[Rationale: Summaries, by their very nature, exist to save us the
trouble reading the rest of the document. If we have to read the
whole document to make sure it won’t accidentally ratify the wrong
thing, that defeats the purpose of having a summary in the first place.]"""
            )
        }
    }

    voting {
        votes(Madrid) {
            FOR on all
        }

        votes(G) {
            AGAINST on 8342
            AGAINST on 8343
            PRESENT on 8344
            FOR on 8345
            FOR on 8346
            FOR on 8347
            AGAINST on 8348
        }

        votes(o) {
            match(G) on all
        }

        votes(sukil) {
            FOR on 8342
            AGAINST on 8343
            PRESENT on 8344
            FOR on 8345
            FOR on 8346
            FOR on 8347
            FOR on 8348
        }

        votes(Janet) {
            AGAINST on 8342
            endorseOfficer(offices, Arbitor) on 8343
            PRESENT on 8344
            FOR on 8345
            FOR on 8346
            FOR on 8347
            FOR on 8348
        }

        votes(Rance) {
            endorse(Janet) on all
        }

        votes(Kate) {
            PRESENT on 8342 comment legacyConditionalComment("Gaelan did not vote AGAINST")
            FOR on 8343
            PRESENT on 8344 comment legacyConditionalComment("Alexis did not vote AGAINST")
            endorse(Janet) on 8345
            endorse(Janet) on 8346
            endorse(Janet) on 8347
            PRESENT on 8348 comment legacyConditionalComment("Gaelan did not vote AGAINST")
        }

        votes(Bernie) {
            endorse(Kate) on all
        }

        votes(Falsifian) {
            endorse(G) on 8342
            AGAINST on 8343
            AGAINST on 8344
            endorse(Janet) on 8345
            endorse(Janet) on 8346
            endorse(Janet) on 8347
            PRESENT on 8348 comment legacyConditionalComment("Gaelan did not vote AGAINST")
        }

        votes(Gaelan) {
            FOR on 8342
            AGAINST on 8343
            AGAINST on 8344
            FOR on 8345
            AGAINST on 8346
            FOR on 8347
            FOR on 8348
        }

        votes(Alexis) {
            endorseOfficer(offices, Arbitor) on 8342
            AGAINST on 8343
            FOR on 8344
            AGAINST on 8345
            FOR on 8346
            FOR on 8347 comment "G. and Jason both voted FOR, while Murphy did not vote, so the majority is FOR"
            endorseOfficer(offices, Treasuror) on 8348
        }

        votes(Warrigal) {
            PRESENT on 8342
            AGAINST on 8343
            PRESENT on 8344
            FOR on 8345
            FOR on 8346
            PRESENT on 8347
            FOR on 8348
        }
    }
}
