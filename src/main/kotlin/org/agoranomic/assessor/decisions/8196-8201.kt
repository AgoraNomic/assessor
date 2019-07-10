package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.lib.AssessmentData
import org.agoranomic.assessor.lib.VoteKind.*
import org.agoranomic.assessor.lib.assessment

fun `assessment 8196 to 8201`(): AssessmentData {
    return assessment {
        quorum(7)

        votingStrength {
            defaultStrength(3)

            G strength 4 comment PM
            Corona strength 1 comment BLOTS
            twg strength 1 comment BLOTS
            PSS strength 2 comment BLOTS
        }

        proposals {
            proposal(8196) {
                title("Perfecting pledges (v1.2)")
                author(JasonCobb)
                coauthors(Falsifian)
                ai(1.7)
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
//                ai(1) // Proposal AI is none, decisions AI is 1
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
                ai(1)
                author(JasonCobb)
                text("""Repeal Rule 2596 ("The Ritual").""")
            }

            proposal(8199) {
                title("Fixing instant runoff")
                ai(3)
                author(JasonCobb)
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
                ai(3)
                author(Aris)
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
                ai(3)
                author(Aris)
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
            votes(8196) {
                RLee votes AGAINST
                JasonCobb votes AGAINST
                Murphy votes PRESENT
                Aris votes PRESENT
                G votes AGAINST
                twg endorses JasonCobb
                Falsifian votes AGAINST
                Walker votes AGAINST
                Trigon votes PRESENT
            }

            // Decision on 8197 was never initiated
//            votes(8197) {
//                RLee votes AGAINST
//                JasonCobb votes AGAINST
//                Murphy votes AGAINST
//                Aris votes AGAINST
//                G votes FOR
//                twg votes AGAINST
//                Falsifian votes AGAINST
//                Walker votes AGAINST
//                Trigon votes AGAINST
//            }

            votes(8198) {
                RLee votes AGAINST
                JasonCobb votes FOR
                Murphy votes FOR
                Aris votes FOR
                G votes AGAINST
                twg endorses JasonCobb
                Falsifian votes FOR
                Walker votes FOR
                Trigon votes FOR
            }

            votes(8199) {
                RLee votes AGAINST
                JasonCobb votes AGAINST
                Murphy votes AGAINST
                Aris votes FOR
                G votes AGAINST
                twg endorses JasonCobb
                Falsifian votes AGAINST
                Walker votes AGAINST
                Trigon votes PRESENT
            }

            votes(8200) {
                RLee votes AGAINST
                JasonCobb votes FOR
                Murphy votes PRESENT
                Aris votes FOR
                G votes FOR
                twg endorses G
                Falsifian votes FOR comment NO_VETO
                Walker votes FOR
                Trigon votes FOR
            }

            votes(8201) {
                RLee votes FOR
                JasonCobb votes FOR
                Murphy votes PRESENT
                Aris votes FOR
                G votes PRESENT
                twg endorses Aris
                Falsifian votes FOR comment NO_VETO
                Walker votes AGAINST
                Trigon votes AGAINST
            }

            Telnaior alwaysEndorses G
            Tarhulindur alwaysEndorses RLee
        }
    }
}