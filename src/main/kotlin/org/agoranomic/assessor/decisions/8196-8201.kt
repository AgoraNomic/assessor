package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.match
import org.agoranomic.assessor.dsl.votes.pmBonus
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8196to8201() = assessment {
    name("8196-8201")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2019-July/013009.html")
    quorum(7)

    strengths {
        default(3)
        min(0)
        max(5)

        pmBonus(G)

        blotPenalty(Corona, 2)
        blotPenalty(Kate, 2)
        blotPenalty(PSS, 1)
    }

    proposals(v0) {
        proposal(8196) {
            title("Perfecting pledges (v1.2)")
            author(Janet)
            coauthors(Falsifian)
            ai("1.7")
            text(
                """
[Comment: This clarifies the wording to explicitly use both the time
window and penalty specified in the Oath. This also specifies that
pledges can only be violated once.]

Amend the first paragraph of Rule 2450 ("Pledges") to read:

  If a Player makes a clear public pledge (syn. Oath) to perform (or
  refrain from performing) certain actions, then breaking the pledge
  within the pledge's time window is the Class N crime of
  Oathbreaking. If the pledge specifically states that the pledge is
  under penalty of a Class A crime, where A is an integer not less
  than 1, then N is A; otherwise, N is 2. If the pledge specifically
  states that it operates only for a certain time window, and if that
  time window is prospective and not retrospective, then it operates
  only for that time window; otherwise, the pledge operates for 60
  days. It is impossible to commit the crime of Oathbreaking multiple
  times for a single pledge; breaking a single pledge multiple times
  constitutes a single crime.
                """
            )
        }

        // Decision on 8197 was never initiated
//            proposal(8197) {
//                title("no power is all powerful")
//                ai("1") // Proposal AI is none, decisions AI is 1
//                author(G)
//                text(
//                    """
//Create the following Rule, "Supreme Power", Power=4:
//  G. CAN make arbitrary changes to the gamestate by announcement.
//"""
//                )
//            }

        proposal(8198) {
            title("Be gone, foul demon!")
            ai("1")
            author(Janet)
            text("""Repeal Rule 2596 ("The Ritual").""")
        }

        proposal(8199) {
            title("Fixing instant runoff")
            ai("3")
            author(Janet)
            text(
                """ 
 Amend item 3 of the only list of Rule 2528 ("Voting Methods") to read:

  3. For an instant runoff decision, non-empty ordered lists for which
  each element is a valid option.
                """
            )
        }

        proposal(8200) {
            title("Sane AI Defaulting")
            ai("3")
            author(Aspen)
            text(
                """
Amend Rule 1950 (Decisions with Adoption Indices) by replacing:
  Adoption index is an untracked switch possessed by Agoran
  decisions and proposals, whose value is either "none" (default) or
  an integral multiple of 0.1 from 1.0 to 9.9.
with:
  Adoption index (AI) is an untracked switch possessed by Agoran
  decisions and proposals.  For decisions, the possible values are
  "none" (default) or integral multiples of 0.1 from 1.0 to 9.9.
  For proposals, the possible values are integral multiples of 0.1
  from 1.0 to 9.9 (default 1.0).
                """
            )
        }

        proposal(8201) {
            title("Just Make Them Write It Out")
            ai("3")
            author(Aspen)
            text(
                """
[It's terribly confusing for everyone to leave out a proposal title. Leaving
out AI only works if it's 1.0 anyway, and confuses me every time I see it.
I usually spend like a solid minute checking that I haven't missed something
as Promotor and that the proposal is effective at that power as a player.
Just making these fields mandatory would save everyone so much trouble and
be only marginally more work for authors.]

Amend Rule 2350, "Proposals", by changing the first paragraph, including
the following list, to read in full:

  A proposal is an entity consisting of a body of text and
  other attributes. A player CAN create a proposal by announcement,
  specifying its text, an associated title, and a valid adoption index, and
  optionally specifying a list of co-authors (who must be persons other
  than the author). 
                """
            )
        }
    }

    voting {
        votes(RLee) {
            AGAINST on 8196
            AGAINST on 8198
            AGAINST on 8199
            AGAINST on 8200
            FOR on 8201
        }

        votes(Janet) {
            AGAINST on 8196
            FOR on 8198
            AGAINST on 8199
            FOR on 8200
            FOR on 8201
        }

        votes(Murphy) {
            PRESENT on 8196
            FOR on 8198
            AGAINST on 8199
            PRESENT on 8200
            PRESENT on 8201
        }

        votes(Aspen) {
            PRESENT on 8196
            FOR on 8198
            FOR on 8199
            FOR on 8200
            FOR on 8201
        }

        votes(G) {
            AGAINST on 8196
            AGAINST on 8198
            AGAINST on 8199
            FOR on 8200
            PRESENT on 8201
        }

        votes(Kate) {
            endorse(Janet) on 8196
            endorse(Janet) on 8198
            endorse(Janet) on 8199
            endorse(G) on 8200
            endorse(Aspen) on 8201
        }

        votes(Falsifian) {
            AGAINST on 8196
            FOR on 8198
            AGAINST on 8199
            FOR on 8200 comment NO_VETO
            FOR on 8201 comment NO_VETO
        }

        votes(Walker) {
            AGAINST on 8196
            FOR on 8198
            AGAINST on 8199
            FOR on 8200
            AGAINST on 8201
        }

        votes(Trigon) {
            PRESENT on 8196
            FOR on 8198
            PRESENT on 8199
            FOR on 8200
            AGAINST on 8201
        }

        votes(Telna) {
            match(G) on all
        }
        votes(Tarhulindur) {
            match(RLee) on all
        }
    }
}
