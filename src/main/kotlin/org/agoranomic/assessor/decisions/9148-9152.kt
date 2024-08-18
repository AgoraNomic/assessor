package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment9148to9152() = assessment {
    name("9148-9152")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2024-August/017956.html")
    quorum(3)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            complexityBonuses {
                maxBonus(3)

                "Absurdor"(1) heldBy juan
                "ADoP"(1) heldBy Murphy
                "Arbitor"(2) heldBy Kate
                "Archivist"(1) heldBy Gaelan
                "Assessor"(3) heldBy Janet
                "Collector"(2) heldBy Mischief
                "Distributor"(0) heldBy omd
                "Geologist"(1) heldBy Forest
                "Herald"(2) heldBy Forest
                "Illuminator"(1) heldBy Quadrantal
                "Notary"(2) heldBy Forest
                "Prime Minister"(0) heldBy null
                "Promotor"(3) heldBy snail
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Simplifior"(1) heldBy juniper
                "Speaker"(0) heldBy ais523
                "Spendor"(1) heldBy nix
                "Stonemason"(1) heldBy juniper
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy Quadrantal
            }
        }
    }

    proposals(v4) {
        proposal(9148) {
            title("Corpse Looting")
            ai("1.0")
            author(Forest)
            ordinary()

            text(
                """
Append the following to Rule 2695 ("The Veblen"):
{
When a shooter fires a round that eliminates a player who owns the Veblen,
the shooter CAN, by announcement, loot the corpse. The Veblen is thereby
transferred to the shooter.
}"""
            )
        }

        proposal(9149) {
            title("Silly Bangs")
            ai("1.0")
            author(Forest)
            ordinary()

            text(
                """
Amend Rule 2696 ("Bang Actions") by replacing:
{
if the shooter is alive and has two bangs
}
with
{
if the shooter is alive and has at least two bangs
}

[it's not really exploitable, but rather just annoying: having your reveal
fail bc you had more than 2 bangs for any reason, since you can simply
transfer bangs away from you freely.]"""
            )
        }

        proposal(9150) {
            title("*sigh*")
            ai("1.0")
            author(Janet)
            ordinary()

            text(
                """
Amend the Rule entitled "The Veblen" to read, in whole:

{

The Veblen is a unique indestructible fixed asset tracked by the
Abusrdor, with ownership entirely restricted to players and Agora. If
the Veblen would otherwise be in abeyance, or if it is owned by the Lost
and Found Department, it is immediately transferred to Agora.

The Veblen cost is a secured singleton positive integer switch tracked
by the Absurdor and with default value one.

A player who does not own the Veblen CAN pay a fee of X spendies to
purchase the Veblen, where X is an integer not less than the current
Veblen cost. When e does so, the Veblen is transferred to em, then the
Veblen cost is set to X+1.

The owner of the Veblen SHOULD conspicuously show off eir ownership of
it from time to time.

}


The Veblen is hereby transferred to the entity that owned the Veblen
immediately before this proposal began taking effect (if e does not
already own it).

The Veblen cost is hereby flipped to what the Veblen Cost was
immediately before this proposal began taking effect (if it does not
already have that value).

[Normalize tracking language. Normalize transfer language. Fix
"ownership of the Veblen", if such a thing exists. Prohibit
self-purchases.]"""
            )
        }

        proposal(9151) {
            title("Baa")
            ai("2.0")
            author(Mischief)
            ordinary()

            text(
                """
[Creates a stone that follows other stones around]

Amend rule 2645 (The Stones) by adding, at the end, to the list of stones:

       - Sheep Stone (monthly): This stone has no effect. Whenever
         the Sheep Stone is not immune and another stone is transferred
         from owner X to owner Y, where X is the current owner of the
         Sheep Stone, then the Sheep Stone is immediately transferred
         to owner Y as well. When this occurs, the stone cost of the
         Sheep Stone is set to its default value."""
            )
        }

        proposal(9152) {
            title("Ugh")
            ai("2.0")
            author(Mischief)
            ordinary()

            text(
                """
[Creates a stone that's effectively worth -1 in the count.]

Amend rule 2645 (The Stones) by adding, at the end, to the list of stones:

       - Tacky Stone (monthly): Wielding the Tacky Stone reminds
         everyone how much of an eyesore it is. If the Tacky Stone is
         not immune, any player CAN pay a fee of X Spendies to transfer
         the Tacky Stone to a specified entity that the rules permit to
         own stones, where X is the current Stone Cost of the Tacky
         Stone. When this occurs, the stone cost of the Tacky Stone is
         set to its default value.

Amend rule 2644 (Zen Gardening) by replacing "that owns 8 or more
stones" with "with an impressive rock collection" and inserting as the
first paragraph of the rule the following text (including an embedded list):

       A player has an impressive rock collection if e:
         1) owns 10 or more stones; or
         2) owns 8 or more stones and does not own the Tacky Stone."""
            )
        }
    }

    voting {
        votes(Murphy) {
            endorse(juan) on 9148 comment "${juan.name} is the Absurdor"
            PRESENT on 9149
            FOR on 9150
            endorse(juniper) on 9151 comment "${juniper.name} is the Stonemason"
            endorse(juniper) on 9152 comment "${juniper.name} is the Stonemason"
        }

        votes(lare290) {
            FOR on 9148
            FOR on 9149
            FOR on 9150
            FOR on 9151
            FOR on 9152
        }

        votes(Janet) {
            AGAINST on 9148
            PRESENT on 9149
            FOR on 9150
            AGAINST on 9151
            FOR on 9152
        }

        votes(snail) {
            AGAINST on 9148
            PRESENT on 9149
            FOR on 9150
            AGAINST on 9151
            FOR on 9152
        }

        votes(Mischief) {
            PRESENT on 9148
            FOR on 9149
            AGAINST on 9150
            PRESENT on 9151
            FOR on 9152
        }
    }
}
