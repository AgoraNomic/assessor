package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.ministries.OfficeV0
import org.agoranomic.assessor.dsl.ministries.OfficeV0.*
import org.agoranomic.assessor.dsl.ministries.ministriesV1
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.lib.Ministry
import org.agoranomic.assessor.lib.Ministry.*
import org.agoranomic.assessor.lib.VoteKind
import org.agoranomic.assessor.lib.VoteKind.*

@UseAssessment
fun `assessment 8342 to 8348`() = assessment {
    name("8342-8348")
    quorum(7)

    val offices = mapOf(
        ADoP to Murphy,
        Arbitor to G,
        Assessor to Jason,
        Comptrollor to Murphy,
        Distributor to omd,
        Herald to Alexis,
        Notary to Gaelan,
        PrimeMinister to Aris,
        Promotor to Aris,
        Referee to twg,
        Registrar to Falsifian,
        Rulekeepor to Jason,
        Speaker to twg,
        Tailor to twg,
        Treasuror to twg
    )

    strengths {
        default(3)
        offices[Speaker]!! add 1

        ministriesV1(offices, allProposals)
    }

    proposals(v1) {
        proposal(8342) {
            title("Calls with Memoranda")
            ai(2.0)
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
            ai(1.7)
            author(twg)
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
            ai(3.0)
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
            ai(2.0)
            author(Jason)
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
            ai(3.0)
            author(Jason)
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
            ai(3.0)
            author(Jason)
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
            ai(3.1)
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
        votes(CuddleBeam) {
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

        o matches G

        votes(sukil) {
            FOR on 8342
            AGAINST on 8343
            PRESENT on 8344
            FOR on 8345
            FOR on 8346
            FOR on 8347
            FOR on 8348
        }

        votes(Jason) {
            AGAINST on 8342
            endorse(offices[Arbitor]!!) on 8343
            PRESENT on 8344
            FOR on 8345
            FOR on 8346
            FOR on 8347
            FOR on 8348
        }

        votes(Rance) {
            endorse(Jason) on all
        }

        votes(twg) {
            // TODO resolve conditional vote on 8342: AGAINST if Gaelan votes AGAINST, else PRESENT
            FOR on 8343
            // TODO resolve conditional vote on 8344: AGAINST if Alexis votes AGAINST, else PRESENT
            endorse(Jason) on 8345
            endorse(Jason) on 8346
            endorse(Jason) on 8347
            // TODO resolve conditional vote on 8348: AGAINST if Gaelan votes AGAINST, else PRESENT
        }

        votes(Bernie) {
            endorse(twg) on all
        }

        votes(Falsifian) {
            endorse(G) on 8342
            AGAINST on 8343
            endorse(Alexis) on 8344
            endorse(Jason) on 8345
            endorse(Jason) on 8346
            endorse(Jason) on 8347
            // TODO resolve conditional vote on 8348: AGAINST if Gaelan votes AGAINST, else PRESENT
        }
    }
}
