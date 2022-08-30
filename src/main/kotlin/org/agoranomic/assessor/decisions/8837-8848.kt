package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment8837to8848() = assessment {
    name("8837-8848")
    quorum(7)

    strengths {
        default(3)
        min(0)
        max(15)
    }

    proposals(v4) {
        proposal(8837) {
            title("Is this a hard decision?")
            ai("1.0")
            author(Forest)
            ordinary()

            text(
                """
When this proposal is adopted, each of the following occur in order,
separately, if possible:
1. All players who voted AGAINST or conditionally on this proposal have
their score set to 0
2. All players who voted AGAINST or conditionally on this proposal have
their coins set to 0
3. All players who voted AGAINST or conditionally on this proposal have all
stamps they own destroyed. 4. All players who voted AGAINST this proposal
have any stones they own are transferred to Agora.
5. All players who voted AGAINST or conditionally on this proposal have any
birds they own transferred to Agora.
6. Grant 4st 200 points.
7. Enact the following rule, title 'Voter protection' with power=1.0:
{
Rules to the contrary notwithstanding, proposals cannot affect players or
their assets based on the way they have voted.
Rules to the contrary notwithstanding, rules that affect players or their
assets based on the way a player has voted cannot affect the proposal in
which that rule is enacted.
}"""
            )
        }

        proposal(8838) {
            title("Kickstarter")
            ai("1.0")
            author(Murphy)
            ordinary()

            text(
                """
Each person who was a player when Rule 2668 (Horses) was enacted gains
10 dollaries.


[Another thing tied to "when the race starts anew", but the enactment of
these rules doesn't clearly qualify. The Registrar's report of August 14
should be sufficient to identify who gains dollaries, as there were no
registrations or deregistrations in between.]"""
            )
        }

        proposal(8839) {
            title("Not so hard decision")
            ai("3.0")
            author(Forest)
            democratic()

            text(
                """
Create the following rule if it doesn't exist, with Title "Voter
Protection" and power=3.0
{
Rules to the contrary notwithstanding, proposals cannot affect
players' assets or players' scores based on the way they have voted.
Rules to the contrary notwithstanding, rules that affect players' assets or
players' scores based on the way a player has voted cannot affect the
proposal in
which that rule is enacted.
}
If a rule with the title "Voter Protection" already exists, amend it so
that it matches the above rule, and set its power to 3."""
            )
        }

        proposal(8840) {
            title("Cleanliness security")
            ai("3.0")
            author(Jason)
            ordinary()

            text(
                """
Amend Rule 2221 by appending the following paragraph:

{

Cleaning rules is secured. Refiling rules is secured.

}


[This is maybe arguably not necessary based on the exact wording of
R2221, but better safe than sorry.]"""
            )
        }

        proposal(8841) {
            title("Spivak Standardization Act v2")
            ai("3.0")
            author(Jason)
            coauthors(Aspen, Gaelan)
            democratic()

            text(
                """
Enact a new power-3 rule entitled "Pronoun Prioritization" with the
following text:

{

The Spivak pronouns (e/em/eir) are hereby recognized as the standard
third-person singular personal pronouns in Agora. In official contexts,
players SHOULD use them when referring to non-specific persons or, in
the absence of a clear statement of another preference, when referring
to a specific other person. The use of other singular third-person
pronouns when referring to persons is DISCOURAGED in official contexts,
except upon specific request by that person.

A player CAN, with Agoran consent, cause this rule to amend a specified
other rule of power less than 4, specifying the new text of the rule,
such that the new text rewords and rephrases the existing text in order
to use Spivak pronouns in place of singular they, provided that such
amendment would not result in the meaning or interpretation of that rule
changing in any way.

}"""
            )
        }

        proposal(8842) {
            title("Losing Focus")
            ai("2.0")
            author(Pilgore)
            coauthors(nix, Jason, Madrid)
            ordinary()

            text(
                """
Repeal R2638 (Player Focuses)
Repeal R2605 (Ministries)

Amend R2645 (The Stones) to delete the bullet point which reads:
  Concentration Stone (monthly, 60%): A specified player (defaulting to the
  wielder if not specified) gains the Grant associated with eir Focus.
and replace it with:
  Jockey Stone (monthly, 60%): A specified Running horse's Race Position is
  increased by 1.

If at the time this proposal is adopted the Concentration Stone is owned
by a player, that player becomes the owner of the Jockey Stone. Otherwise,
Agora becomes the owner of the Jockey Stone."""
            )
        }

        proposal(8843) {
            title("Time B Safe")
            ai("4.0")
            author(G)
            coauthors(Jason, Murphy)
            democratic()

            text(
                """
Amend Rule 1698 (Agora Is A Nomic) by replacing:
      adopted within a four-week period.
with:
      adopted within a real-world (UTC) four-week period.

[
In discord, a Power-5 Rule was suggested: "Rules to the contrary
notwithstanding, this rule CANNOT be changed in January or February of
2023".

Up until the time a proposal to change this rule could take effect before
January 2023, Agora would not be ossified. But then you cross a time
boundary and Agora would become ossified. One *possible* interpretation of

>      If any other single change or inseparable group of changes to the
>      gamestate would cause Agora to become ossified, or would cause
>      Agora to cease to exist, it is cancelled and does not occur, rules
>      to the contrary notwithstanding.

is that the "cancelled change" would be time passing!  With the conclusion
that time had (as a legal fiction) stopped, with no way of getting it
started again. So this proposal puts an extra protection on time by making
it clear that only "real world" time is relevant. The title a reference B
nomic, an established nomic some years back that was killed when they
accidentally stopped time or at least couldn't get it started again.
]"""
            )
        }

        proposal(8844) {
            title("Fix dreams")
            ai("2.0")
            author(Forest)
            coauthors(Jason)
            ordinary()

            text(
                """
For Rule 2675 'Dream of Wandering', change its power to 2."""
            )
        }

        proposal(8845) {
            title("Onicers")
            ai("1.0")
            author(Secretsnail9)
            ordinary()

            text(
                """
Enact a new rule with title "Onicers" and the following text:
{
Every player that, for the past 14 days, has not held an office is an
onicer.

Once per month, each onicer CAN, by announcement, increase the score of a
specified officer by 1 while also decreasing the score of another specified
officer by 1. E SHOULD explain eir reasoning for doing so in the same
message.
}"""
            )
        }

        proposal(8846) {
            title("The Cheepening")
            ai("1.0")
            author(Secretsnail9)
            ordinary()

            text(
                """
Amend Rule 2661 (Permits) by replacing "A player CAN buy a beast permit by
paying a fee of 50 boatloads of coins." with "A player CAN buy a beast
permit by paying a fee of 30 boatloads of coins."

and by replacing "A player CAN renew eir beast permit by paying a fee of 25
boatloads of coins." with "A player CAN renew eir beast permit by paying a
fee of 15 boatloads of coins."


Amend Rule 2663 (Bird Migration) by replacing "A player CAN buy bird food
by paying a fee of 5 boatloads of coins." with "A player CAN buy bird food
by paying a fee of 3 boatloads of coins."


Amend Rule 2675 (Dream of Wandering) by replacing

      - Dream of Beasts: E CAN buy bird food by paying a fee of 3
        boatloads of coins. E CAN buy a Beast Permit by paying a fee of
        40 boatloads of coins.  E CAN renew a Beast Permit by paying a
        fee of 20 boatloads of coins.

with

      - Dream of Beasts: E CAN buy bird food by paying a fee of 2
        boatloads of coins. E CAN buy a Beast Permit by paying a fee of
        20 boatloads of coins.  E CAN renew a Beast Permit by paying a
        fee of 10 boatloads of coins.



[An effort to make birds more approachable. They always fly away when you
get too close.]"""
            )
        }

        proposal(8847) {
            title("Bird Powerup")
            ai("2.0")
            author(Secretsnail9)
            coauthors(Forest)
            ordinary()

            text(
                """
Change the power of Rule 2662 (Playing with Birds) to 2.

Amend Rule 2665 (The Birds) by removing the text "- Jay: The voting
strength of the playmate on a specified referendum is increased by 3."

Enact a new rule with title "The Big Birds", power 2, and the following
text:

{

The following birds are defined, one per paragraph, with the
      following format: Bird Name: Scroll.

      - Jay: The voting strength of the playmate on a specified
        ordinary referendum is increased by 3.



}
Create the Jay in the possession of the entity that owned the Jay when this
proposal started to take effect.

[Fixes the Jay and also restricts its power to ordinary proposals.]"""
            )
        }

        proposal(8848) {
            title("Goals")
            ai("1.0")
            author(Forest)
            ordinary()

            text(
                """
Enact a new rule titled "Goals" with power=1.0 and the text:
{
Goal is a player switch with possible values of any patent titles (past,
present, or future), with a default of "Champion". A player CAN, by
announcement, change eir Goal. Goals are tracked by the Goalkeepor.
}"""
            )
        }
    }

    voting {
    }
}