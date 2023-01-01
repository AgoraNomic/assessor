package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8873to8877() = assessment {
    name("8873-8877")
    quorum(3)

    strengths {
        default(3)
        min(0)
        max(15)

        // Note: R2632's attempted strength changes are ineffective at power 1.
    }

    proposals(v4) {
        proposal(8873) {
            title("Back from the void")
            ai("1.0")
            author(snail)
            ordinary()

            text(
                """
Grant Marb 1 Marb stamp.

[E lost the stamp in eir welcome package.]"""
            )
        }

        proposal(8874) {
            title("The Big Horse Fix")
            ai("1.0")
            author(snail)
            ordinary()

            text(
                """
[== This first section is mostly small fixes.==]

Amend Rule 2668 (Horses) by replacing "Dollaries (singular: dollary) are a
fixed currency. Hooves (singular: hoof) are a fixed currency." with
"Dollaries (singular: dollary) are a fixed currency. Hooves (singular:
hoof) are a fixed currency. Any Dollaries or Hooves in abeyance or not
owned by a player are immediately destroyed."

[Clears hooves and dollaries from the L&FD, where they are currently
unauctionable.]

Amend Rule 2672 (Weekly Race Action) by replacing "bet 1, 2, or 3 dollaries
on a specified horse by paying a fee of 1, 2, or 3 dollaries respectively."
with "bet 1, 2, or 3 dollaries on a specified Running horse by paying a fee
of 1, 2, or 3 dollaries respectively."

[It would be silly to bet on horses that have already finished in the race!]

Amend Rule 2673 (Motivating Horses) by replacing {

Each horse has an associated non-repeating set of horses, their "pulls",
tracked by the Horsened.

}

with {

Pulls (syn. pull) is a Horse switch, tracked by the Horsened. It has
possible values of any set of horses.

}

[Make pulls a switch instead of the nonsense from before.]

Amend Rule 2674 (Horse Powers) by replacing {

Fargo's power: (WEEKLY POWER)  * get a helmet for and bet 2
      dollaries on a specified horse, by paying 1 hoof.

}

with {

Fargo's power: (WEEKLY POWER)  * get a helmet for and then bet 2
      dollaries on a specified horse, by paying 1 hoof.

}

and by replacing {

Sugar's power: (WEEKLY POWER)  * get a helmet for and increase the
      Race Position of a specified horse by 1, by paying 1 hoof.

}

with {

Sugar's power: (WEEKLY POWER)  * get a helmet for and then increase the
      Race Position of a specified horse by 1, by paying 1 hoof.
}

[This should make it so you can't use these powers on horses you already
got a helmet for.]


[==These next changes have a larger mechanical impact.==]

Amend Rule 2672 (Weekly Race Action) by replacing

{
* gain 4 dollaries by announcement.
}

with

{
* gain 5 dollaries by paying 3 hooves.

* gain 1 hoof by announcement.
}

[This makes dollaries more scarce, and hooves a more important resource to
manage.]

Amend Rule 2499 (Welcome packages) by replacing

{
  * 1 Stamp of eir own type
}

with

{
  * 1 Stamp of eir own type
  * the number of hooves the player(s) with the most hooves has
}

[New players aren't behind in the hooves this way.]

Amend Rule 2670 (Horse Victory) by replacing

{
      * the player that owns the horse with a Race Place of first gains
        50 dollaries.

      * the player that owns the horse with a Race Place of second gains
        30 dollaries.

      * the player that owns the horse with a Race Place of third gains
        15 dollaries.
}

with

{
      * the player that owns the horse with a Race Place of first gains
        30 dollaries.

      * the player that owns the horse with a Race Place of second gains
        20 dollaries.

      * the player that owns the horse with a Race Place of third gains
        15 dollaries.
}

[This should balance horse ownership a bit more, and is especially needed
if dollary generation is being decreased.]"""
            )
        }

        proposal(8875) {
            title("All Warmed Up")
            ai("1.0")
            author(snail)
            ordinary()

            text(
                """
Amend Rule 2670 (Horse Victory) by replacing

* The score of the player that has the most dollaries is increased
        by 15.  In the event of a tie, instead, no score change occurs.

with

* The score of the player that has the most dollaries is increased
        by 50.  In the event of an N-way tie, instead, each tied
        player's score is increased by 50/N points, rounded down."""
            )
        }

        proposal(8876) {
            title("Stamp'a'Wrong")
            ai("1.0")
            author(snail)
            ordinary()

            text(
                """
    [This is fixing a mishap where my stamps got mistaken out of
    existence. See the discussion in quote.]

    Create in juan's possession:

    * 1 juan stamp
    * 1 Madrid stamp
    * 1 Murphy stamp"""
            )
        }

        proposal(8877) {
            title("Fake fixes")
            ai("1.0")
            author(Janet)
            coauthors(Murphy)
            ordinary()

            text(
                """
Amend Rule 2471 ("No Faking") to read, in whole:

{

A person SHALL NOT make a public statement that is a lie.

A public statement is falsy if any of the following was true at the time of
publication:
* The statement was not true and the author knew or should have known
that it was not true.
* The author believed the statement to be not true.

A public statement is a lie if it is falsy and any of the following is true:
* The author made the statement with intent to mislead.
* The author, in the same message, declared the statement to be made
"under penalty of No Faking" (or similar).

For the purposes of this rule, an attempt to perform an action by
publishing certain text constitutes an implicit statement that the
action was EFFECTIVE.

Merely quoting a statement or attempt does not constitute making it for
the purposes of this rule. Any disclaimer, conditional clause, or other
qualifier attached to a statement or attempt constitutes part of the
statement or attempt for the purposes of this rule; the truth or falsity
of the whole is what is significant.

The above notwithstanding, a formal announcement of intent is never a lie.

}"""
            )
        }
    }

    voting {
        votes(snail) {
            FOR on 8873
            FOR on 8874
            FOR on 8875
            FOR on 8876
            PRESENT on 8877
        }

        votes(Janet) {
            endorse(nix) on 8873
            PRESENT on 8874
            AGAINST on 8875
            endorse(nix) on 8876
            FOR on 8877
        }

        votes(nix) {
            FOR on 8873
            endorse(ais523) on 8874
            AGAINST on 8875
            FOR on 8876
            PRESENT on 8877
        }

        votes(juan) {
            endorse(nix) on 8873 comment "nix is the Collector"
            PRESENT on 8874
            PRESENT on 8875
            FOR on 8876
            FOR on 8877
        }
    }
}
