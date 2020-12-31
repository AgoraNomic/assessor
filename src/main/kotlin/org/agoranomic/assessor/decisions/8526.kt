package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.lib.proposal.MinistryV2.Economy

@UseAssessment
fun assessment8526() = assessment {
    name("8526")
    quorum(6)

    proposals(v3) {
        proposal(8526) {
            title("Debarreling")
            ai("1.0")
            author(G)
            chamber(Economy)
            sponsored()

            text("""
Repeal Rule 2627 (The General Store).

Repeal Rule 2628 (Bargains on the Barrel).""")
        }
    }
}
