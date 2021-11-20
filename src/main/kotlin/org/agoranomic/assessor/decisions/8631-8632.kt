package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8631to8632() = assessment {
    name("8631-8632")
    quorum(8)

    strengths {
        default(3)
        min(0)
        max(15)

        blotPenalty(Madrid, 6 / 3)
    }

    proposals(v4) {
        proposal(8631) {
            title("another device defect")
            ai("1.0")
            author(G)
            ordinary()

            text("""
Amend Rule 2655 by replacing:
  responsible for building and maintaining the Device.
with:
  responsible for building, tracking, and maintaining the Device.

and by deleting:
  This intent announcement counts as the Mad Engineers's
  weekly report.

[with the reporting duty for the device status added, by default a weekly
switch value report, we no longer need this intent to count as a report to
get the weekly report reward.  The intent is still part of "weekly duties"
but not the report.]""")
        }

        proposal(8632) {
            title("Forgiveness is a process")
            ai("1.0")
            author(G)
            coauthors(nix)
            ordinary()

            text("""
The patent title Fugitive is hereby revoked from every person who
holds it.

Henceforth, the Herald SHOULD NOT list people as being "fugitives" in eir
reporting.  [covers any "unofficial" listees who didn't have patent titles].

[note: this may be slightly more controversial than last time, given that
we've uncovered some of those listed actually hold patent titles, and we
generally don't revoke those in order to preserve history. For full
disclosure, who actually holds that title could be reconstructed in a
fairly straightforward manner (I think I found the requisite proposal
records), if the consensus is to keep the patent title holders in the
Scroll].""")
        }
    }

    voting {
        votes(Jason) {
            FOR on 8631
            FOR on 8632
        }

        votes(Falsifian) {
            FOR on 8631
            PRESENT on 8632
        }

        votes(RLee) {
            FOR on 8631
            AGAINST on 8632
        }
    }
}
