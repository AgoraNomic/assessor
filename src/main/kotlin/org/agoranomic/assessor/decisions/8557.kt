package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment8557() = assessment {
    name("8557")
    quorum(3)

    proposals(v4) {
        proposal(8557) {
            title("Archimedes' Principle")
            ai("2.0")
            author(Aris)
            coauthors(Trigon, nix)
            ordinary()
            sponsored()

            text(
                """
[Changes:
  -The Treasuror sets a target for the Total Buoyancy every week;
   the most recent target takes effect at the beginning of the month
  -The Unit of Floatation is now rounded, so people can actually remember
   it (unlike the draft, I'm rounding up, to deal with cases
   where it's evenly between two integers)
  -The Treasuror no longer has a monthly report, and is instead
   just encouraged to make sure the Total Buoyancy and Unit of Floatation
   are published
]

Amend Rule 2634, "Buoyancy Control", by changing it to read in full:

  The Total Buoyancy and Buoyancy Target are singleton
  integer switches, tracked by the Treasuror in eir weekly report.

  The Treasuror CAN, by announcement, set the Buoyancy Target
  to a specified value approximately equal to the sum of all coin
  balances at a specified point within the last week,
  and SHALL do so each time e publishes eir weekly report.

  The Treasuror may exercise reasonable judgement in calculating the
  Buoyancy Target. The Buoyancy Target will be deemed set so long as
  the value chosen by the Treasuror is not obviously and grossly
  incorrect. However, the Treasuror SHALL NOT deliberately introduce
  error into the Buoyancy Target.

  At the beginning of each month, the Total Buoyancy is flipped to
  the Buoyancy Target.

Amend Rule 2635, "Floating Rate Fleet", by changing it to read in full:

  The Unit of Flotation is equal to 1/2500 times the Total Buoyancy,
  rounded up, and is tracked in the Treasuror's weekly report.
  A boatload of something is a quantity of that thing equal
  in count to the Unit of Floatation.

  The Treasuror is ENCOURAGED to arrange for the new Total Buoyancy
  and Unit of Flotation to be published as close as possible
  to the beginning of the month.


[No clue why this should be secured — granting assets isn't secured.
The reason I'm amending this is to make the payday happen
after the boatload value update; I'm open to other phrasings.]

Amend Rule 2559, "Paydays", by replacing:

  The occurrence of Paydays is secured. At the beginning of each
  month, a Payday occurs.

with:

  At the beginning of each month, after all other events that
  take place at the beginning of the month, a Payday occurs.


  Amend Rule 2559, "Paydays", by replacing:

    The occurrence of Paydays is secured. At the beginning of each
    month, a Payday occurs.

  with:

    At the beginning of each month, after all other events that
    take place at the beginning of the month, a Payday occurs."""
            )
        }
    }
}
