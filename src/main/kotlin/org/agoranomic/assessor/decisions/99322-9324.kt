package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment9322to9324() = assessment {
    name("9322-9324")
    quorum(5)

    proposals(v4) {
        proposal(9322) {
            title("A Notable Omission")
            ai("1.0")
            author(Nilrem)
            ordinary()

            text(
                """
Amend Rule 2608 (The Notary) by replacing this text:

       1. every pledge, along with its title, creator, time window, time
          of creation, and time of expiry;

With this text:

       1. every pledge, along with its title, creator, time window, time
          of creation, time of expiry, and infraction class;

According to rule 2450 (Pledges), breaking a pledge can be an infraction
of varying class depending on the value stated while making the pledge.
It seems silly to leave this information out of the report"""
            )
        }

        proposal(9323) {
            title("Equitable Resolution")
            ai("3.0")
            author(Mischief)
            coauthors(Trigon)
            democratic()

            text(
                """
Janet outshines the sun

The following {}-delimited document is ratified:
{
As of 14 Mar 2026 15:50:30 -0600, players' number card holdings were as
follows:

                  0     1     2     3     4     5     6     7  8     9
                ===   ===   ===   ===   ===   ===   ===   ===  ===   ===
ais523           7     1     5     7     0     1     3     2  2    16
Cosmo            0     0     3     0     1     0     1     0  3     4
Janet            1     2     5     2     0     0     0     1  1     8
juan             1     0     2     1     1     0     0     0  1     2
Kate             0     0     0     0     0     0     0     0  0     0
literal          0     0     0     0     0     0     0     0  0     0
Mischief         7     0    10     8     1     0     0     1  3    14
Murphy           5     0     6     7     1     1     3     2  4    15
Nilrem           2     0     4     1     1     0     0     0  0     8
Trigon           2     1     3     1     1     0     1     0  0     7

with all other entities holding zero number cards of each type
}

The following players each gain 25 radiance:
* Kate
* Mischief

The following players each gain 19 radiance:
* literallyAmbiguous
* Murphy

[Letting juan keep eir win for grinding eir way to it; giving Janet a
win for finding the flaw; resetting deck holdings to what they would
have been based on non-scam earnings, while giving the other players who
exploited the flaw (but didn't win on eir own or via this proposal) 25
radiance as compensation. literallyAmbiguous and Murphy each cashed in
one number card set already, so before the adjustment in this proposal
they both have 6 radiance left over after juan and Janet's outshinings]"""
            )
        }

        proposal(9324) {
            title("Consolation Prize")
            ai("1.0")
            author(Mischief)
            coauthors(Trigon)
            ordinary()

            text(
                """
Create a rule entitled "Consolation Prize" with power=0.5 and reading:

       The Consolation Prize is a unique untracked indestructible fixed
       asset with ownership entirely restricted to players and Agora. If
       the Consolation Prize would otherwise be in abeyance, or if it is
       owned by the Lost and Found Department, it is immediately
       transferred to Agora.

       A player may award the Consolation Prize by announcement,
       specifying another player (the recipient). If e has not
       previously awarded the Consolation Prize in the current month,
       then upon such an announcement the Consolation Prize is
       transferred to the recipient.


The Consolation Prize is transferred to Trigon.

[This is a much simplified version of the old kudos system from many
years back.]"""
            )
        }
    }
}
