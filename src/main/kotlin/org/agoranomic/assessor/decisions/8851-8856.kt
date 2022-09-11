package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.resolvedConditional
import org.agoranomic.assessor.lib.vote.InextricableResolvingVote
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8851to8856() = assessment {
    name("8851-8856")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(15)
    }

    proposals(v4) {
        proposal(8851) {
            title("Voter Protection")
            ai("3.0")
            author(Forest)
            democratic()

            text(
                """
Set 4st's score to half its current value, rounded down.
If 4st doesn't already have the patent title "Bully",
grant em the patent title "Bully".
Destroy half of 4st's coins, rounded down.
Decrease 4st's Karma by 1.

Create the following rule, with Title "Voter Protection"
and power=3.0
{
Rules to the contrary notwithstanding, proposals cannot affect
players' assets or players' scores based on the way they have voted.
Rules to the contrary notwithstanding, rules that affect players' assets or
players' scores based on the way a player has voted cannot affect the
proposal in which that rule is enacted.
Rules to the contrary notwithstanding, proposals cannot grant patent
titles to players based on the way they have voted.
}"""
            )
        }

        proposal(8852) {
            title("Fix infractions")
            ai("2.0")
            author(Forest)
            coauthors(Jason)
            ordinary()

            text(
                """
Amend rule 2555 "Blots" by replacing the following sentence:
"Destroying blots is secured with a Power Threshold of 1.7."
with
"Creating and destroying blots is secured with a Power Threshold of 1.7""""
            )
        }

        proposal(8853) {
            title("Unfortunately")
            ai("3.0")
            author(Jason)
            democratic()

            text(
                """
Amend Rule 869 by appending the following paragraphs:
{
Banned is a secured negative boolean person switch tracked by the
Registrar. A person is unwelcome if e is Banned or if at least one part
of em is unwelcome. Rules to the contrary notwithstanding, an unwelcome
person CANNOT register or be registered, and e is immediately
deregistered if e is ever a player. Designations of unwelcomeness are
secured.

Unwelcomeness is to be used only to make a social statement that the
Agoran community no longer wishes to interact with certain persons; in
particular, it is not to be used to acquire gameplay advantage. As such,
an unwelcome person SHOULD NOT, under any circumstances, attempt to
bypass unwelcomeness, and e SHOULD carefully consider the circumstances
of eir becoming unwelcome before participating in public or discussion fora.
}"""
            )
        }

        proposal(8854) {
            title("Attainder")
            ai("3.0")
            author(Jason)
            democratic()

            text(
                """
For the purposes of this proposal, "Madrid" is the person who, at the
time of this proposal's submission, was a player and who was known as
"Madrid" to the average Agoran.

Madrid is hereby deregistered.
Madrid's instance of the Banned switch is hereby flipped to true.

[
This is a bill of attainder. Its purpose is to deregister and, if
possible, ban Madrid as a sanction for a series of incidents on the
lists and on the unofficial Discord server. This is not in response to
any single incident, but rather a pattern of behavior. This is
additionally not in response to Madrid's distaste for Spivak pronouns
itself, regardless of the timing of this submission.

Madrid's actions and views have resulted in two deregistrations (one
successful FAGE and one attempted FAGE that wasn't a FAGE due to a
technicality), hostile exchanges of words on list, and an atmosphere on
the Discord that discourages participation in discussion. No other
single player's non-gameplay actions and expressions of views have
resulting in similar responses from other players.

This proposal is phrased in such a way that, if adopted, Madrid will be
unconditionally deregisted and will be Banned if the associated proposal
"Unfortunately" has been adopted. Even if "Unfortunately" has not been
adopted, the adoption of this proposal represents the AI-3 consensus
that Madrid is not welcome. If this occurs, and "Unfortunately" failed
due to a technical reason rather than apparent rejection of the idea,
the author will pursue further proposals to officialize the ban.
]"""
            )
        }

        proposal(8855) {
            title("Extermination v1.1")
            ai("1.0")
            author(Jason)
            ordinary()

            text(
                """
Repeal each of the following rules, in ascending numerical order by ID:

* Rule 2660 (Birds)

* Rule 2661 (Permits)

* Rule 2662 (Playing with Birds)

* Rule 2663 (Bird Migration)

* Rule 2664 (One with Nature)

* Rule 2665 (The Birds)"""
            )
        }

        proposal(8856) {
            title("Backup Justice")
            ai("2.0")
            author(Forest)
            ordinary()

            text(
                """
Grant Madrid 200 blots."""
            )
        }
    }

    voting {
        votes(Secretsnail9) {
            AGAINST on 8851
            FOR on 8852
            AGAINST on 8853
            resolvedConditional(PRESENT, "Proposal 8853 has passed") on 8854
            AGAINST on 8855
            PRESENT on 8856
        }

        votes(Jason) {
            AGAINST on 8851
            FOR on 8852
            FOR on 8853
            FOR on 8854
            FOR on 8855
            endorse(G) on 8856
        }

        votes(Forest) {
            FOR on all
        }

        votes(Madrid) {
            FOR on all
        }

        votes(cuddlybanana) {
            FOR on all
        }

        votes(Gaelan) {
            AGAINST on 8851
            endorse(Jason) on 8852 comment "Jason is the Arbitor"
            FOR on 8853
            FOR on 8854

            resolvedConditional(
                InextricableResolvingVote,
                "At least 3 players have taken an action under the bird rules since the casting of the vote",
            ) on 8855

            resolvedConditional(AGAINST, "Neither proposal 8853 nor proposal 8854 has failed") on 8856
        }

        votes(juan) {
            AGAINST on 8851
            FOR on 8852
            FOR on 8853
            FOR on 8854
            AGAINST on 8855
            FOR on 8856
        }

        votes(Murphy) {
            endorse(Forest) on 8851
            FOR on 8852
            FOR on 8853
            endorse(Madrid) on 8854
            endorse(Secretsnail9) on 8855 comment "Secretsnail9 is the Avicultor"
            endorse(Madrid) on 8856
        }

        votes(ais523) {
            AGAINST on 8851
            FOR on 8852
            FOR on 8853
            // NO VOTE on 8854
            FOR on 8855
            resolvedConditional(AGAINST, "Both proposals 8853 and 8854 have passed") on 8856
        }

        votes(G) {
            AGAINST on 8851
            FOR on 8852
            FOR on 8853
            FOR on 8854
            FOR on 8855
            AGAINST on 8856
        }
    }
}