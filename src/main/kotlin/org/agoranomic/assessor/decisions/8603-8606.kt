package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.dsl.votes.powerStone
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8603to8606() = assessment {
    name("8603-8606")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            powerStone(Jason, 3)
        }
    }

    proposals(v4) {
        proposal(8603) {
            title("Buying Strength Eligibility")
            ai("2.0")
            author(Jason)
            coauthors(Bucky)
            ordinary()
            sponsored()

            text("""
Amend Rule 2653 by replacing "A player's Voting Strength on referendum"
with "A person's Voting Strength on a referendum".

[There's no reason that buying strength should stop applying on
deregistration, since a non-player can still be eligible to vote.]""")
        }

        proposal(8604) {
            title("Stony Silence")
            ai("2.0")
            author(RLee)
            coauthors(G)
            ordinary()
            sponsored()

            text("""
Amend rule 2642, 'Distributing Stones' by replacing its second paragraph
with 'The Stonemason SHALL if possible initiate such an auction monthly and
only once a month, in a timely fashion after a collection notice has been
issued. The Stonemason SHALL auction exactly 2 stones in a month if
possible'

Retitle rule 2644 'The Gauntlet' to 'Zen Gardening' [cosmetic change to
remove the annoying movie reference that I discussed once on discord]

Amend rule 2644 by replacing any instances of the word 'Gauntlet' with
'Rock Garden'

Amend rule 2644 by replacing '5 or more' with '8 or more'

Amend rule 2645 'The Stones' by adding the following text on the end.
"
- Recursion Stone (Monthly, 80%): The recursion stone can be wielded once
  per month as if it had the power of any other stone of your choice.

- Hot Potato Stone (Weekly, 100%):  When this stone is wielded, the
  wielder gains 8 boatloads of coins if the wielder, in the same message
  as the wielding, transfers this stone to a player who has not owned
  this stone since Agora last owned it. This stone cannot otherwise be
  transferred, other rules notwithstanding. This stone is immune if 3 or
  more players have wielded it since the most recent collection notice.

- Blank Stone (Monthly, 5%): This stone has no effect.

- Alchemy Stone (weekly, 70%): Destroy four cards you own. If four cards were
  destroyed this way, gain 7 products of your choice.
"""")
        }

        proposal(8605) {
            title("Covered under warranty")
            ai("1.0")
            author(G)
            coauthors(Oerjan)
            ordinary()
            sponsored()

            text("""
Amend Rule 2655 (The Mad Engineer) by replacing:
  skip directly to proposal submission.
with:
  skip directly to announcing intent, below.

and by replacing:
  with Agoran Consent, cause this rule to amend the rule "The Device"
  as indicated,
with:
  with Agoran Consent, cause this rule to amend the rule "The Device"
  as indicated (or, if 007 has been spotted, cause this rule to repeal
  both that rule and this one),""")
        }

        proposal(8606) {
            title(null)
            ai("1.0")
            author(null)
            ordinary()
            sponsored()

            text("""
I create a proposal with this sentence as its text, and make it pending.""")
        }
    }

    voting {
        votes(RLee) {
            AGAINST on 8606
            FOR on others
        }

        votes(Trigon) {
            FOR on 8603
            AGAINST on 8604
            FOR on 8605
            FOR on 8606
        }

        votes(CuddleBeam) {
            FOR on all
        }

        votes(G) {
            FOR on 8603
            PRESENT on 8604
            FOR on 8605
            FOR on 8606
        }

        votes(Murphy) {
            FOR on 8603
            PRESENT on 8604
            PRESENT on 8605
            AGAINST on 8606
        }
    }
}
