package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.*
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8946to8951() = assessment {
    name("8946-8951")
    quorum(3)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            powerDream(Forest, 2)
            powerDream(G, 2)
            powerDream(Aspen, 2)
            powerDream(Janet, 2)

            powerStone(Janet, 3)

            complexityBonuses {
                maxBonus(3)

                "ADoP"(1) heldBy Murphy
                "Arbitor"(2) heldBy G
                "Assessor"(3) heldBy Janet
                "Collector"(1) heldBy null
                "Distributor"(0) heldBy omd
                "Dream Keeper"(1) heldBy snail
                "Herald"(2) heldBy nix
                "Horsened"(1) heldBy snail
                "Mad Engineer"(1) heldBy null
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
        proposal(8946) {
            title("Horses Can Dream/Horse Virus")
            ai("2.0")
            author(Forest)
            ordinary()

            text(
                """
Amend rule 2675 ("Dream of Wandering") by adding
this paragraph to the beginning of the rule:
"Whenever this rule mentions a player or active player,
it can also mean a horse. Players may take actions on behalf of
horses e owns. Any effects that can only happen to players
instead happen to the horse's owner, such as transfer of assets,
increases in voting power, and the like.""""
            )
        }

        proposal(8947) {
            title("Stamp win removal")
            ai("1.0")
            author(Janet)
            ordinary()

            text(
                """
Amend Rule 2659 ("Stamps") by removing the paragraph beginning "Any
player CAN win by paying N Stamps".

[Players with lots of different stamps can already win by radiance.
This method is just duplicative.]"""
            )
        }

        proposal(8948) {
            title("Undo Burden")
            ai("2.0")
            author(G)
            ordinary()

            text(
                """
Amend Rule 2645 (The Stones) by appending the following paragraph:

- Undo Stone (Fortnightly, 3): When wielded while specifying an act of
stone wielding that occurred in the last 24 hours, the effects of the
specified wielding are undone, to the extent POSSIBLE. This is not
retroactive; rather wielding the undo stone causes a reverse effect
(e.g. if the specified previous wielding increased a value, that value
is decreased by the same amount). If wielding the undo stone would
lead to a paradox, it fails instead."""
            )
        }

        proposal(8949) {
            title("Might as well ask?")
            ai("3.0")
            author(Janet)
            democratic()

            text(
                """
Janet's Ultraviolet Ribbon Ownership is hereby flipped to true.

[

I won by points at
https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-business/2023-March/050699.html

Champion was awarded at
https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-business/2023-March/050704.html

After that, I just forgot to award myself the ribbon apparently? It's
too late to claim it normally now, so I'm asking for it with this
proposal. I recognize this is my own fault, so I won't be upset if this
fails.

I have pledged not to claim radiance award for this proposal, and this
proposal isn't otherwise for gameplay advantage besides having the
ribbon. (I also already have Transparent.)

]"""
            )
        }

        proposal(8950) {
            title("Major Stamp Reform")
            ai("2.0")
            author(nix)
            ordinary()

            text(
                """
[Overhaul the current stamp->radiance conversion to make it more
interesting, more in-line with the values of grindy sources of radiance,
and more distinct from the collection win:]

Amend R2659 by replacing:

       Any player CAN, once per week, pay X Stamps, where each specified
       Stamp is a different type, to gain (X^2)-X radiance.

       Any player CAN, once per week, pay X Stamps, where each Stamp is
       the same type, to gain (X-1)*2 radiance.

with:

       A stamp of a player's own type has a rarity of 1. A stamp of
       another player's type has a rarity of 2, and a stamp of a type
       that is not a current player has a rarity of 3.

       Once a week any player CAN perform one of the following actions:

         * Pay 3 specified stamps, where each stamp is of a different
           rarity to gain 12 radiance.

         * Pay 3 specified stamps, where each stamp is of rarity [1/2/3]
           to gain [5/10/20] radiance.

[This part is just a little fix for the scam snail pulled off:]

and by replacing:

       Any player CAN win by paying N Stamps

with:

       Any active player CAN win by paying N Stamps

[Stamps no longer accrue forever, and the wealth dream just gives a flat
number. Note that rounding down will always leave you with at least 1 of
each type, so you don't lose your collection but are still pressured to
spend excess:]

and by appending:

       At the beginning of each month, for each player, half (rounded
       down) of each type of stamp e owns is destroyed.


Amend R2675 by replacing:

       - Wealth: Immediately after a wandering, X stamps of eir own type
         are granted to each Wealth Dreamer. When less than 8 Stamps of
         eir type exist, X is 2. When 8 to 15 Stamps of eir type exist, X
         is 1. When 16 ore more Stamps of eir type exist, X is 0.

with:

       - Wealth: Immediately after a wandering, 2 stamps of eir own type
         are granted to each Wealth Dreamer."""
            )
        }

        proposal(8951) {
            title("Gathering Stone Power v3")
            ai("2.0")
            author(nix)
            coauthors(Forest, Janet)
            ordinary()

            text(
                """
[This proposal simplifies and overhauls stones. Players have Gathering
Power, which goes up by 1 every week (+1 more for Garden Dreamers). At
4 Gathering Power, a player can grab a stone from Agora. Stones are
overdue if they have been away from Agora for 8-X weeks, where X is
smoothness. The Stonemason collects overdue stones once a month.]

[
v2 changes:
- fix typo from 'decreased by 1' to 'decreased by 4'.
v3 changes:
- reintroduce hot (almost got rid of frequencies by accident, ty 4st)
- method to collect (oops, ty 4st)
]

[Remove mossiness and slipperiness. These aren't used in the
new system.]

Amend R2640 by removing:

       Mossiness is a Stone switch with values of non-negative integers
       and a default of 0 tracked by the Stonemason. When a stone is
       transferred from Agora to a player or from a player to Agora, its
       Mossiness is set to 0. The mossiest stone(s) in a set of stone is
       (are) the stone(s) with the highest Mossiness value.

       The Slipperiness of a stone is that stone's smoothness plus its
       mossiness.

[Allow freely transferring hot stones, since that's not particularly
exploitable in this paradigm.]

Amend R2641 by removing "or to transfer it by announcement".

[Now stones are gathered by having 4+ Gathering Power. Gathering Power
goes up weekly.]

Amend R2642 to read in full:

       Gathering Power is an active player switch, with values of
       positive integers and defaulting to 0, tracked by the Stonemason.

       At the beginning of each week, every active player's Gathering
       Power is increased by 1.

       A player with Gathering Power of 4 or more CAN, by announcement,
       transfer any stone from Agora to emself. When e does so, eir
       Gathering Power is decreased by 4.

Amend R2675 by replacing:

       - Gardens: Immediately after a wandering, the Base Rockiness of
         each Gardens Dreamer is increased by 1.

with:

       - Gardens: Immediately after a wandering, the Gathering Power of
         each Gardens Dreamer is increased by 1.

Amend R2499 by adding, after the bulleted list:

       When a player receives a Welcome Package, set eir Gathering Power
       to 4.

[Collection is now just on a timer, no more randomness.]

Amend R2643 to read in full:

       A stone that has not been owned by Agora in the last 8-X weeks,
       where X is its smoothness, is overdue.

       Once a month, the Stonemason CAN "collect" all non-immune overdue
       stones by announcement. E SHALL do so in a timely fashion after
       the start of the month. When e does so, they are transferred to
       Agora.

Enact a new, P=2 rule titled "Stone Keywords":

       A stone is "immune" if (and only if) it has been granted immunity
       since the last time the Stonemason collected stones or it is owned
       by Agora. Granting immunity is secured.

       To "drop" a stone is to transfer it to Agora.

[Finally, some stone changes. Cairn to replace Anti-Equatorial, Toggle
and Distracting to play with the new mechanics.]

Amend R2645 by removing:

       - Anti-Equatorial Stone (Monthly, 5): When wielded, the mossiest
         non-immune stone is transferred to the wielder. If more than one
         such stone is tied for mossiest, a specified one is transferred.
         When this happens, the Anti-Equatorial Stone's mossiness is
         incremented by 1.

and appending (to the end):

       - Cairn Stone (Monthly, 3): When wielded, two specified stones
         owned by the wielder are dropped, and one specified non-immune
         stone is transferred to the wielder.

       - Toggle Stone (Monthly, 6): When wielded, a specified stone is
         dropped then transferred back to its owner, and then this stone
         is dropped.

       - Distracting Stone (Weekly, 4): When wielded, reduce the
         Gathering Power of the wielder and a specified player by X,
         where X is a specified positive integer equal to or less than
         the wielder's current Gathering Power."""
            )
        }
    }

    voting {
        votes(Janet) {
            AGAINST on 8946
            FOR on 8947
            AGAINST on 8948
            PRESENT on 8949
            FOR on 8950
            AGAINST on 8951
        }

        votes(Forest) {
            FOR on 8946
            endorse(nix) on 8947
            FOR on 8948
            endorse(nix) on 8949
            endorse(ais523) on 8950
            endorse(juan) on 8951
        }

        votes(nix) {
            FOR on 8946
            AGAINST on 8947
            AGAINST on 8948
            PRESENT on 8949
            FOR on 8950
            AGAINST on 8951
        }
    }
}
