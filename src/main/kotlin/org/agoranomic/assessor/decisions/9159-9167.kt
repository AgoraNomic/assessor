package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment9159to9167() = assessment {
    name("9159-9167")
    quorum(6)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            complexityBonuses {
                maxBonus(3)

                "Absurdor"(1) heldBy juan
                "ADoP"(1) heldBy Murphy
                "Arbitor"(2) heldBy Kate
                "Archivist"(1) heldBy Gaelan
                "Assessor"(3) heldBy Janet
                "Collector"(2) heldBy Mischief
                "Distributor"(0) heldBy omd
                "Geologist"(1) heldBy Forest
                "Herald"(2) heldBy Forest
                "Illuminator"(1) heldBy Quadrantal
                "Notary"(2) heldBy Forest
                "Prime Minister"(0) heldBy null
                "Promotor"(3) heldBy snail
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Simplifior"(1) heldBy juniper
                "Speaker"(0) heldBy ais523
                "Spendor"(1) heldBy nix
                "Stonemason"(1) heldBy null
                "Tailor"(1) heldBy Murphy
                "Tracker of Hats"(1) heldBy Mischief
                "Webmastor"(1) heldBy Quadrantal
            }
        }
    }

    proposals(v4) {
        proposal(9159) {
            title("Simplification, ironically")
            ai("1.0")
            author(Janet)
            ordinary()

            text(
                """
Amend Rule 1681 ("The Logical Rulesets") by deleting the text from "The
Readable Logical Ruleset (RLR)" (inclusive) to the end of the rule.

Repeal Rule 2693 ("The Simplifior").


[We have yet to see a report from this office and nobody has pointed
this out or expressed interest in deputising, suggesting that the report
is infeasible and/or not useful.]"""
            )
        }

        proposal(9160) {
            title("A reasonable limit")
            ai("1.0")
            author(snail)
            ordinary()

            text(
                """
Enact a new rule with title "Proposal Limits" and the following text:

{

A person SHALL NOT submit a proposal while e has already submitted five or
more proposals currently in the proposal pool that week; doing so is the
Class N Infraction of Preposterous Propositioning, where N is the number of
times e has committed the infraction this week.

}

[Deterrence for excess proposals, which is currently easily abusable.]"""
            )
        }

        proposal(9161) {
            title("Fix office reports")
            ai("1.0")
            author(ais523)
            ordinary()

            text(
                """
In rule 2143, replace:
{{{
For each person:

1. If any task is defined by the rules as part of that person's
   weekly duties, then e SHALL perform it at least once each week.
   If any information is defined by the rules as part of that
   person's weekly report, then e SHALL maintain all such
   information, and the publication of all such information is
   part of eir weekly duties.

2. If any task is defined by the rules as part of that person's
   monthly duties, then e SHALL perform it at least once each
   month. If any information is defined by the rules as part of
   that person's monthly report, then e SHALL maintain all such
   information, and the publication of all such information is
   part of eir monthly duties.
}}}
with
{{{
For each person:

1. If any task is defined by the rules as part of that person's
   weekly duties, then e SHALL perform it at least once each week.

2. If any task is defined by the rules as part of that person's
   monthly duties, then e SHALL perform it at least once each month.

For each office, if any information is defined by the rules as part of
that office's weekly or monthly report, then its officeholder SHALL
maintain all such information, and eir weekly or monthly duties
respectively include publishing a document or series of documents,
labelled as that office's report (or as that office's weekly or monthly
report as appropriate), that includes all such information.
}}}

[The intent behind this proposal is to make it possible to
unambiguously identify whether an office has missed a report, by
requiring the report to be labelled as one, and thus makes it possible
to deputise based on a missed report.]"""
            )
        }

        proposal(9162) {
            title("Shameless Bribery 2A")
            ai("1.0")
            author(Mischief)
            ordinary()

            text(
                """
All players who cast valid unconditional ballots FOR the referendum
adopting this proposal earn a Black Ribbon"""
            )
        }

        proposal(9163) {
            title("Shameless Bribery 2B")
            ai("1.0")
            author(Mischief)
            ordinary()

            text(
                """
All players who cast valid unconditional ballots FOR the referendum
adopting this proposal earn a Black Ribbon"""
            )
        }

        proposal(9164) {
            title("Shameless Bribery 2C")
            ai("1.0")
            author(Mischief)
            ordinary()

            text(
                """
All players who cast valid unconditional ballots FOR the referendum
adopting this proposal earn a Black Ribbon"""
            )
        }

        proposal(9165) {
            title("Remove the Sabotage Stone")
            ai("1.0")
            author(Mischief)
            ordinary()

            text(
                """
[It has an obvious -- but annoying to everybody -- workaround.]

The owner of the Sabotage Stone gains a number of Spendies equal to its
current Stone Cost.

Amend rule 2645 (The Stones) by deleting:

       - Sabotage Stone (weekly): When wielded, the adoption index of a
         specified AI-majority Agoran decision is increased by 1."""
            )
        }

        proposal(9166) {
            title("Untracked hats")
            ai("1.0")
            author(Janet)
            ordinary()

            text(
                """
Amend Rule 2594 ("Hats") by replacing "Hats are a secured player switch"
with "Hats are a secured untracked player switch" and by replacing the
paragraph beginning "A player CAN change eir hat" with the following
paragraph:

{

A player CAN change eir hat to a valid value by public designation.

}

[Don't require reporting on hats in any event, and don't require
explicit "notification" to any person (in any event, it's unclear what
it means to "notify" oneself).]"""
            )
        }

        proposal(9167) {
            title("The Bounty Board")
            ai("1.0")
            author(snail)
            ordinary()

            text(
                """
Enact a new Rule with title "Bounties" and the following text:
{
Bounty Amount is an untracked player switch. Its possible values are all
integers from 0 to 10 inclusive, where 0 is the default.

Twice each month, each player CAN, by announcement, put a bounty on a
specified player. Doing so increases the specified player's Bounty Amount
by 1.

Immediately after an alive player is eliminated, the shooter gains a number
of spendies equal to the target's Bounty Amount, and then the target's
bounty amount is flipped to 0.

The shooter SHOULD publish the target's Bounty Amount at the time of the
elimination when e eliminates a target with a non-zero Bounty Amount.
}"""
            )
        }
    }

    voting {
        votes(snail) {
            AGAINST on 9159
            FOR on 9160
            FOR on 9161
            AGAINST on 9162
            AGAINST on 9163
            AGAINST on 9164
            AGAINST on 9165
            FOR on 9166
            FOR on 9167
        }

        votes(Kate) {
            FOR on 9159
            FOR on 9160
            FOR on 9161
            AGAINST on 9162
            AGAINST on 9163
            AGAINST on 9164
            AGAINST on 9165
            AGAINST on 9166
            PRESENT on 9167
        }
    }
}
