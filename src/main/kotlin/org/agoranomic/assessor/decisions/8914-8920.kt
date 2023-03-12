package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.*
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8914to8920() = assessment {
    name("8914-8920")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            powerDream(Forest, 2)
            powerDream(G, 2)

            powerStone(snail, 3)

            complexityBonuses {
                maxBonus(3)

                "ADoP"(1) heldBy Murphy
                "Arbitor"(2) heldBy G
                "Assessor"(3) heldBy Janet
                "Collector"(1) heldBy nix
                "Distributor"(0) heldBy omd
                "Dream Keeper"(1) heldBy snail
                "Herald"(2) heldBy nix
                "Horsened"(1) heldBy snail
                "Mad Engineer"(1) heldBy Janet
                "Notary"(2) heldBy snail
                "Prime Minister"(0) heldBy nix
                "Promotor"(3) heldBy snail
                "Referee"(2) heldBy Forest
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy snail
                "Stonemason"(1) heldBy Janet
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy Forest
            }
        }
    }

    proposals(v4) {
        proposal(8914) {
            title("Can't Trust Em To Do Eir Own Work")
            ai("1.5")
            author(nix)
            ordinary()

            text(
                """
[I shouldn't have to do someone else's work for em to win.]

Amend R2656 by replacing:

       Upon a correct announcement from a player that e has a score of
       100 or more points, e wins the game.

with:

A player with 100 or more points CAN declare a High Score by
announcement and specifying exactly how many points e has. If a
player incorrectly does so, e loses 5 points. Upon a correct
declaration of High Score, that player wins the game."""
            )
        }

        proposal(8915) {
            title("Reenactment V2")
            ai("1.0")
            author(Forest)
            coauthors(G, Janet)
            ordinary()

            text(
                """
Enact a rule with power=1.0 and the text:
{
The rulekeepor CAN and MUST re-enact one of the following,
in a timely manner by announcement, chosen randomly by em, at power=1.0:
1. Rule 2193/0
2. Rule 2615
3. Rule 2571
4. Rule 1993
5. Rule 2309
6. Rule 108

Once e does so, repeal this rule.
}"""
            )
        }

        proposal(8916) {
            title("Ongoing obligation")
            ai("1.0")
            author(Forest)
            coauthors(Janet)
            ordinary()

            text(
                """
The player 4st MUST submit a copy of this proposal."""
            )
        }

        proposal(8917) {
            title("No")
            ai("3.0")
            author(Janet)
            democratic()

            text(
                """
Amend Rule 2646 by replacing the text "Activity is a player switch" with
"Activity is a secured player switch"."""
            )
        }

        proposal(8918) {
            title("Ritual Paper Dance V2")
            ai("1.0")
            author(Forest)
            coauthors(nix, G, Murphy)
            ordinary()

            text(
                """
Enact a rule with power=1.0 entitled "Ritual Paper Dance" and the text:
{
Firstly: Each of these is a ritual act:
- Performing a cabinet order
- Assigning a judgement
- Awarding ribbons
- Once per week per report type, publishing a report
- Once per week per player, nominating for office
- Once per week per player, voting

Secondly: Once for each ritual act, any player, including the player
who performed the ritual act, CAN, by announcement, declare the ritual
number. A ritual number is a number that starts at 0, and can be at
most 1 greater than any other declared ritual number. Declared ritual
numbers are self-ratifying.

Thirdly: Once, each time a unique positive multiple of 41 is declared,
in the same message the declarer CAN, by announcement, have qualifying
players lift The First Speaker in a powerful dance around the fountain,
while also announcing that those players' gain 1 radiance, in such a
way that is unambiguous and clear, so that in fact, those players' do
gain 1 radiance. This does not increase their radiance by 2, nor does
it increase it by 3 or 4. 5 is right out.

Fourthly: Players are qualifying under this rule if:
- they are active
- do not have the highest radiance
- are not tied for the highest radiance
}

(Glitter) Also snail and Janet gain 1 radiance.
(something about co-authorship should be taken seriously but these
players still helped!)"""
            )
        }

        proposal(8919) {
            title("Radiance v1.1")
            ai("3.0")
            author(nix)
            coauthors(G, Forest, snail)
            ordinary()

            text(
                """
[This proposal reskins points/score as "radiance" and also changes the
scoring conditions to be cashed by players. IE, insteead of the assessor
granting points for proposals, each player must claim them. Also
introduce gains/grants language to get rid of clunkier things, and adds
some requirements to specify your radiance when winning, and where you
gained the radiance from when you do.]

Retitle R2656 to "Radiance".

Amend R2656 to read in full:

       A player's Radiance is an integer player switch defaulting to 0,
       tracked by the Herald. When a player is "granted" or "gains" a
       specified amount of radiance, eir radiance is increased by that
       amount.

       Upon a correct announcement from a player that eir radiance is 100
       or more (correctly specifying the amount), e wins the game. Then,
       eir radiance is set to 0, and all other players' radiance are set
       to half their current value rounded down.

       At the start of every quarter, all radiance switches are set to
       half their current value rounded down.

For each player, set eir radiance switch to be equal to the value eir
score switch was at immediately before this proposal was adopted.

Retitle R2657 to "Gaining Radiance".

Amend R2657 to read, in full:

       Each time a player fulfills a radiance condition, e CAN once by
       announcement (specifying any indicated info) gain the associated
       radiance.

       Below is a list of radiance conditions:

         * Being the author of a proposal that takes effect: 5 (must
           specify proposal number)

         * Being a coauthor of a proposal that takes effect: 1 (must
           specify proposal number)

         * Having an Agoran Birthday: X, where X is the number of active
           players during eir birthday.

         * Judging a CFJ that e was assigned to without violating a time
           limit to do so, unless at the time of judgement the case was
           open due to self-filing a motion to reconsider it: 2 (must
           specify CFJ number)

Amend R2659 by replacing "increase eir own score by (X^2)-X points" with
"gain (X^2)-X radiance" and replacing "increase eir own score by (X-1)*2
points" with "gain (X-1)*2 radiance".

In R2670 replacing:

         The score of the player that has the most dollaries is increased
         by 30.  In the event of an N-way tie, instead, each tied
         player's score is increased by 30/N points, rounded down.

with:

         The player that has the most dollaries gains 30 radiance. In the
         event of an N-way tie, instead, each tied player gains 30/N
         radiance, rounded down.

In R2675 replace every instance of "score" with "radiance".

Amend R2645 by replacing:

       - Score Stone (Weekly, 3): When wielded, a specified player's
         (defaulting to the wielder if not specified) Score is increased
         by 3.

with:

       - Radiance Stone (Weekly, 3): When wielded, a specified player
         (defaulting to the wielder if not specified) gains 3 radiance.

and replacing:

         When this stone is wielded, the wielder specifies an eligible
         player and gains 8 points.

with:

         When this stone is wielded, the wielder specifies an eligible
         player and gains 8 radiance."""
            )
        }

        proposal(8920) {
            title("Adopted change re-application")
            ai("3.0")
            author(Janet)
            democratic()

            text(
                """
Amend Rule 2486 ("The Royal Parade") by replacing "Jason" with "Janet".

[P8904: typoed rule number.]


If Rule 2643 ("Collecting Stones") does not contain the text "A stone is
immune if and only if", amend it by prepending the following paragraphs:

{

A stone is immune if and only if it is defined as such by the rules of
power not less than 2.

A stone is immune if it is owned by Agora. A stone is immune if it has
been granted immunity since the last collection notice. The granting of
immunity is secured.

}

[P8906: potential "paragraph"/"paragraphs" ambiguity.]


Amend Rule 2643  ("Collecting Stones") by replacing the final paragraph
with the following:

{

When a Collection Notice is published, for each player, half (rounded
up) of eir non-immune stones with slipperiness not less than the Escape
Minimum are transferred to Agora, rules to the contrary notwithstanding.
A Collection Notice includes selections of which eligible stones escape
(which shall prevail in determining which stones are transferred). The
mossiness of each stone that is not transferred is incremented by 1.

}

[P9807: merge conflict.]


Decrease the score of the author of this proposal by 5 points.

[These were all my mistakes; I don't deserve points for fixing them.]"""
            )
        }
    }

    voting {
        votes(snail) {
            AGAINST on 8914
            AGAINST on 8915
            AGAINST on 8916
            FOR on 8917
            PRESENT on 8918
            PRESENT on 8919
            FOR on 8920
        }

        votes(Forest) {
            endorse(juan) on 8914
            endorse(G) on 8915
            FOR on 8916
            endorse(Murphy) on 8917
            endorse(snail) on 8918
            endorse(Janet) on 8919
            AGAINST on 8920
        }

        votes(juan) {
            FOR on 8914
            AGAINST on 8915
            FOR on 8916
            FOR on 8917
            FOR on 8918
            FOR on 8919
            FOR on 8920
        }
    }
}
