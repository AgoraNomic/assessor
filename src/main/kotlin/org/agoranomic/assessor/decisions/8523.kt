package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.lib.proposal.MinistryV2.Economy

@UseAssessment
fun assessment8523() = assessment {
    name("8523")
    quorum(7)

    proposals(v3) {
        proposal(8523) {
            title("Emergency Economy Unbreaking")
            ai("2.0")
            author(Aris)
            coauthors(nix, Jason)
            chamber(Economy)
            sponsored()

            text("""
[Currently, the concentration stone plus the economy focus would
 create over 1000 coins. That represents inflation of more than 10%.
 Obviously, that wasn't what we had in mind. The plan is to delay
 termination of the auction until this is resolved, so people should
 be able to adjust their bids.]

Amend the rule entitled "The Stones" by replacing:
  - Concentration Stone (weekly, 60%)
with:
  - Concentration Stone (monthly, 60%)
""")
        }
    }
}
