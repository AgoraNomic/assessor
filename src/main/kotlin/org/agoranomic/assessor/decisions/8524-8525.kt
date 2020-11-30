package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.lib.proposal.MinistryV2.Compliance
import org.agoranomic.assessor.lib.proposal.MinistryV2.Economy

@UseAssessment
fun assessment8524to8525() = assessment {
    name("8524-8525")
    quorum(9)

    proposals(v3) {
        proposal(8524) {
            title("Agora's Stones Are Immune")
            ai("2.0")
            author(nix)
            chamber(Economy)
            sponsored()

            text("""
[Currently, you can steal from Agora with the soul stone, which seems a
bit goofy and also creates problems with auctions. Also, I cleaned up
the verbiage just a bit.]

Amend "Collecting Stones" by replacing

  A stone is immune if there has been no collection notice after it was
  most recently granted immunity (if ever), as defined by other rules.

with:

  A stone is immune if it has been granted immunity, as defined by other
  rules, since the last collection notice or if it is currently owned by
  Agora.

and by replacing:

  A collection notice includes, for every non-immune stone not belonging
  to Agora,

with:

  A collection notice includes, for every non-immune stone,""")
        }

        proposal(8525) {
            title("Expungement for R. Lee")
            ai("1.7")
            author(Aris)
            chamber(Compliance)
            sponsored()

            text("""
[As of right now, this would lower eir blots to 9, just enough to set eir
vote to 0 in the absence of other factors. I phrased it like this
both so e can begin paying it down and so that any blots e earns now
still count against em.]

Expunge 72 of R. Lee's blots.""")
        }
    }
}
