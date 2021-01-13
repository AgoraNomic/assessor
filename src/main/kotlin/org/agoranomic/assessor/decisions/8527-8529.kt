package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.lib.proposal.MinistryV2.Compliance

@UseAssessment
fun assessment8527to8529() = assessment {
    name("8527-8529")
    quorum(5)

    proposals(v3) {
        proposal(8527) {
            title("Specified Crime not Rule")
            ai("1.7")
            author(PSS)
            coauthors(nix, Aris)
            chamber(Compliance)
            sponsored()

            text("""
Amend Rule 2478, "Vigilante Justice" by replacing the first paragraph
with the following:
  A player CAN by announcement Point eir Finger at a player (the
  perp); the announcement is INEFFECTIVE if it does not explicitly
  name the perp, cite a specific rule or named crime, and specify an
  alleged violation of that rule or commission of that crime by that
  person.

[ This will allow someone to use the name of a crime without specifying
which rule defines it. This also addresses some concerns raised by nix
regarding unnecessary or archaic provisions.]""")
        }

        proposal(8528) {
            title("Gaining Assets")
            ai("3.0")
            author(Aris)
            coauthors(Gaelan)
            democratic()
            sponsored()

            text("""
[There are reasonable complaints that the word "earn" is confusing,
because it conveys the idea of becoming entitled to an asset, rather than
the idea of coming into possession of an asset. It also clashes with the
terminology we use for ribbons. This proposal fixes the problems
by changing the word to "gain", to match "loose".]

Amend Rule 2577, "Asset Actions", by replacing:

  For an entity to earn an asset is for that asset to be created in
  that entity's possession.

with:

  For an entity to gain (historical syn. earn) an asset is for that asset to be
  created in that entity's possession.


Amend Rule 2499, "Welcome Packages", by replacing "earns" with "gains".
Amend Rule 2559, "Paydays", by replacing "earns" with "gains".
Amend Rule 2620, "Cards & Sets", by replacing "earn" with "gain".
Amend Rule 2623, "Popular Proposal Proposer Privilege", by replacing "earn"
with "gain".
Amend Rule 2627, "The General Store", by replacing "earns" with
"gains" and replacing "earn" with "gain".
Amend Rule 2631, "Charities", by replacing "earns" with "gains".
Amend Rule 2645, "The Stones", by replacing each instance of
"earns" with "gains".""")
        }

        proposal(8529) {
            title("Not-so-subtle nudge")
            ai("3.0")
            author(Gaelan)
            democratic()
            sponsored()

            text("""
Repeal rule 2633, "Rulebending."""")
        }
    }
}
