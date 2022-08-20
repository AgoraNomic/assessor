package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8829to8836() = assessment {
    name("8829-8836")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(15)
    }

    proposals(v4) {
        proposal(8829) {
            title("Look upon our works")
            ai("1.0")
            author(Gaelan)
            coauthors(Trigon)
            ordinary()

            text(
                """
Award each active player who did not vote FOR this proposal the patent
title
Marvy."""
            )
        }

        proposal(8830) {
            title("Justice & Forgiveness 2.1")
            ai("2.0")
            author(nix)
            coauthors(Jason, G, Murphy, Secretsnail9)
            ordinary()

            text(
                """
Retitle R2478, "Vigilante Justice" to "Justice".

Amend R2478, "Justice", to read, in full:

       An Infraction is a violation of a rule. The person who committed
       an infraction is its infracter.

       The Investigator for an infraction is the Referee unless e is the
       infracter. Otherwise, it is the Arbitor.

       The Class of an infraction is 2 unless a rule specifies a
       different Class for it.

       The Base of an infraction is N, where N is the number of
       previously-investigated, unforgiven infractions that have been
       committed by the same person in the last 30 days. The previous
       notwithstanding, if the base of an infraction would be greater
       than its class, the infraction's base is equal to its class.

       Within 14 days of an infraction being committed, the Investigator
       CAN investigate the infraction by announcement, specifying a
       number of blots between the Base and the Class of the infraction,
       inclusive. When e does so, that many blots are created in the
       possession of the infracter.

       The previous notwithstanding, an Investigator CANNOT investigate
       an infraction that has already been investigated or forgiven. The
       Investigator of a noted, unforgiven infraction SHALL investigate
       the infraction in a timely manner after it has been noted; failure
       to do so is the Class N crime of Favoritism, where N is equal to
       the Class of the noted infraction.

       A player CAN, by announcement, "note" an unforgiven infraction
       committed by any other player in the last 7 days, specifying the
       incident and the rule it violates (or name of the Infraction if it
       has one).

       The Referee's weekly report contains a list of noted and
       investigated Infractions committed in the previous week.

Enact a new P=1.7 rule titled "Forgiveness" with the following text:

       All infractions that have not been forgiven are unforgiven.

       Any player CAN, with Agoran Consent, "forgive" an unforgiven
       infraction that occured in the last 30 days. When an infraction is
       forgiven, if the infraction was investigated, a number of blots in
       the possession of the infracter equal to the number of blots
       specified by the investigation are destroyed or, if e has less
       blots than specified, all eir blots are destroyed. The previous
       notwithstanding, a player cannot forgive or support an intent to
       forgive eir own infraction.

Reenact R2531, "Defendant's Rights", with the following text:

       An infraction is automatically forgiven if:

         (1) the alleged infracter can't be established by a
             preponderance of the evidence to have committed the
             infraction

         (2) at the time the alleged infraction occured, it was not an
             infraction;

         (3) the infraction was for failure to take an action that the
             infracter, through no fault of eir own, COULD NOT have
             performed;

         (4) the infraction is for conduct that the infracter, through no
             fault of eir own, was obliged to undertake by a rule of
             equal or greater power to the one e violated; or

         (5) the infracter could not have avoided the infraction when
             exercising the highest reasonably possible standard of care;"""
            )
        }

        proposal(8831) {
            title("Solidification")
            ai("2.0")
            author(nix)
            ordinary()

            text(
                """
Amend R2483 to read in full:

       Coins are the official currency of Agora and are tracked by the
       Treasuror. They can be owned by players, and the Lost and Found
       Department.

Amend R2576 to read in full:

       Each asset has exactly one owner.

       If ownership of an asset is restricted to a class of entities,
       then that asset CANNOT be gained by or transferred to an entity
       outside that class. By default, ownership of an asset is
       restricted to Agora and players, but an asset's backing document
       may modify this.

       An asset "in abeyance" is one whose owner is nonexistent,
       indeterminate, or invalid. If an asset would otherwise be in
       abeyance, then it is owned by the Lost and Found Department (if
       possible) or destroyed (otherwise), subject to modification by its
       backing document (provided that the modification either destroys
       it or prevents it from being in abeyance). Rules to the contrary
       notwithstanding, the Lost and Found Department can own assets of
       every type. Assets owned by the Lost and Found Department can be
       transferred or destroyed by any player without objection.

Repeal R2631"""
            )
        }

        proposal(8832) {
            title("Coin Cleaning v2")
            ai("2.0")
            author(nix)
            coauthors(Secretsnail9, Jason, G)
            ordinary()

            text(
                """
Amend R2483, "Economics" by adding the following paragraph:

        Any player CAN, with Agoran Consent, "distribute" coins in the
        Lost and Found Department. When e does so, X/N coins, rounded
        down, are transferred from the Lost & Found Department to each
        active player, where X is the number of coins in the Lost & Found
        Department and N is the number of active players. E SHOULD
        announce how many coins each player receives when e does so.

For each coin balance, set that coin balance to one-tenth, rounded down,
of that coin balance's current value.

Set the Buoyancy Target and Total Buoyancy to one-tenth, rounded down.
their current respective values."""
            )
        }

        proposal(8833) {
            title("Etiquette")
            ai("1.0")
            author(nix)
            ordinary()

            text(
                """
Enact a new rule titled "Etiquette" at P=0.5 with the following text:

       Officers SHOULD:

         - publish dates in YYYY-MM-DD or DD Mon YY format in reports,
           whichever is more fitting to the situation;

         - communicate a schedule of when regularly timed duties will
           usually be done;

         - maintain an online version of eir report(s) in a
           browser-native format (such as html); AND

         - maintain a repository of eir report(s) in a public place.

       Players SHOULD:

         - signal the official name of the primary action and/or the
           relevant officer that tracks said actions in the title of a
           public message; AND

         - be kind.

Amend R2143, "Official Reports and Duties", by removing:

       Officers SHOULD maintain a publicly visible copy of their reports
       on the World Wide Web, and they SHOULD publish the address of this
       copy along with their published reports."""
            )
        }

        proposal(8834) {
            title("Karma Revival (fixed)")
            ai("1.0")
            author(nix)
            coauthors(Jason, G)
            ordinary()

            text(
                """
Reenact R2510, "Such is Karma", at P=1 with the following text:

         Karma is an Agora and player integer switch tracked by the Herald
         in eir Weekly Report.

         A player CAN publish a Notice of Honour. For a Notice of Honour
         to be valid, it must:

         1. Be clear that it is a Notice of Honour, and be the first valid
            Notice of Honour that player has published in the current
            week;

         2. Specify any other active player or Agora to gain karma, and
            provide a reason for specifying that player; and

         3. Specify any active player or Agora to lose karma, and provide
            a reason for specifying that player.

         4. Not result in Agora's karma moving farther away from 0.

         When a valid Notice of Honour is published, the entity specified
         to gain karma has eir karma increased by one, and the entity
         specified to lose karma has eir karma decreased by one.

         - The player with the highest karma (if any) is the Paragon.

         - The player with the lowest karma (if any) is the Renegade.

         At the beginning of each quarter, every player's Karma is set to
         half of its current value, rounded towards 0. Agora's Karma is
         then set to zero minus the sum of all player karma values."""
            )
        }

        proposal(8835) {
            title("Payday Increase")
            ai("2.0")
            author(Secretsnail9)
            ordinary()

            text(
                """
Amend Rule 2559 (Paydays) by replacing "10 boatloads of coins" with "15
boatloads of coins"."""
            )
        }

        proposal(8836) {
            title("Horse Fixes")
            ai("1.0")
            author(Secretsnail9)
            ordinary()

            text(
                """
Amend the rule with title "Motivating Horses" by replacing "When the race
begins anew" with "When the race starts anew".

[To match with all the other instances.]

Set the horses' pulls to the following:

HORSE           PULLS
------------------------
Alexia          Nacho
Baxter          Fargo
Cannon          Alexia
Destructor      Baxter
Fargo           Alexia, Destructor
Nacho           Baxter, Cannon
Rubert          Alexia, Cannon
Sugar           Baxter, Destructor


[These pulls should be set immediately, but won't be set when the rule is
enacted because the race won't begin anew when that happens.]"""
            )
        }
    }

    voting {
        votes(Secretsnail9) {
            PRESENT on 8829
            FOR on 8830
            AGAINST on 8831
            FOR on 8832
            FOR on 8833
            PRESENT on 8834
            FOR on 8835
            FOR on 8836
        }

        votes(Forest) {
            // NO VOTE on 8829
            PRESENT on 8830
            FOR on 8831
            PRESENT on 8832
            PRESENT on 8833
            FOR on 8834
            AGAINST on 8835
            AGAINST on 8836
        }

        votes(nix) {
            FOR on 8829
            FOR on 8830
            FOR on 8831
            FOR on 8832
            FOR on 8833
            FOR on 8834
            AGAINST on 8835
            endorse(Secretsnail9) on 8836
        }

        votes(Murphy) {
            PRESENT on 8829
            FOR on 8830
            PRESENT on 8831
            PRESENT on 8832
            PRESENT on 8833
            FOR on 8834
            PRESENT on 8835
            FOR on 8836
        }

        votes(juan) {
            AGAINST on 8829
            PRESENT on 8830
            PRESENT on 8831
            FOR on 8832
            FOR on 8833
            FOR on 8834
            PRESENT on 8835
            PRESENT on 8836
        }

        votes(Madrid) {
            FOR on all
        }

        votes(Jason) {
            PRESENT on 8829
            FOR on 8830
            FOR on 8831
            FOR on 8832
            FOR on 8833
            FOR on 8834
            AGAINST on 8835
            PRESENT on 8836
        }

        votes(RLee) {
            PRESENT on 8829
            FOR on 8830
            FOR on 8831
            PRESENT on 8832
            AGAINST on 8833
            FOR on 8834
        }
    }
}