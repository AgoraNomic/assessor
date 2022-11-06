package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8861to8862() = assessment {
    name("8861-8862")
    quorum(3)

    strengths {
        default(3)
        min(0)
        max(15)
    }

    proposals(v4) {
        proposal(8861) {
            title("Finally Removing Arbitrary Limits")
            ai("3.0")
            author(nix)
            democratic()

            text(
                """
Amend R1728, "Tabled Actions", by replacing:

       The parameters N and T, if omitted, default to 1 and 4 days,
       respectively (e.g. "without objection" means N=1). If a rule
       defines N as less than 1 or greater than 8, it is instead treated
       as 1 or 8, respectively.

with:

       The parameters N and T, if omitted, default to 1 and 4 days,
       respectively (e.g. "without objection" means N=1). If a rule
       defines N as less than 1, it is instead treated as 1."""
            )
        }

        proposal(8862) {
            title("Slippery Stones")
            ai("2.0")
            author(nix)
            ordinary()

            text(
                """
Amend R2640, "Stones", by replacing:


     The escape risk of the stone, which must be a percentage between 0%
     and 100% inclusive;

with:

     The smoothness of the stone, which is a non-negative integer;

and appending to the end the following paragraphs:

     Mossiness is a Stone switch with values of non-negative integers and a
     default of 0 tracked by the Stonemason. When a stone is transfered,
     its Mossiness is set to 0. The mossiest stone(s) in a set of stone
     is (are) the stone(s) with the highest Mossiness value.

     The Slipperiness of a stone is that stone's smoothness plus its
     mossiness.

Amend R2641, "Wielding Stones", by replacing:

     If a stone has a frequency, then it is IMPOSSIBLE to wield that stone
     if it has been previously wielded in the same Agoran time interval as
     indicated by its frequency (e.g. if its frequency is daily, if it has
     been wielded in the same Agoran day).

with:

     A stone with a frequency that has been wielded in the corresponding
     Agoran time interval is Hot for the remainder of the time period
     (e.g. if the frequency is daily, it is hot for the remainder of the
     Agoran day it was wielded during).

     While a stone is hot, it is IMPOSSIBLE to wield it or to transfer it
     by any method besides Collection, other rules notwithstanding.

Amend R2642, "Distributing Stones", to be titled "Gathering Stones" and
to read in full:

     A player who has not possessed a stone in the last 30 days CAN, by
     announcement, transfer the mossiest stone (if there is a tie, then a
     specified stone tied for mossiest) Agora owns to emself. SHOULD
     specify the stone when doing so.

Amend R2643, "Collecting Stones", to read in full:

     Once per month, the Stonemason CAN publish a Collection Notice by
     announcement, specifying all necessary information and choices. The
     Stonemason SHALL publish such a notice in a timely fashion after the
     beginning of each Agoran month.

     A Collection Notice includes a random numbers between 1 and 6; this is
     the Escape Minimum.

     When a Collection Notice is published, for each player eir
     non-immune stone with the highest slipperiness equal to or above the
     Escape Minimum is transferred to Agora. If there is a tie, the Stone
     Mason selects which one escapes. If e has no such stones, none of
     eir stones are transferred to Agora. The mossiness of all stones
     that are not transferred is incremented by 1.

Amend R2645, The Stones to read in full:

     The following stones are defined, one per paragraph, with the
     following format: Stone Name (Frequency, Smoothness): Scroll.

     - Power Stone (weekly, 2): A specified player (defaulting to the
       wielder if not specified) hereby Buys Strength 3 times.

     - Wealth Stone (weekly, 3): A specified player (defaulting to
       the wielder if not specified) hereby gains 5 boatloads of coins.

     - Soul Stone (weekly, 3): The Soul Stone is hereby transferred
       to the owner of a different specified non-immune stone, then
       that stone is transferred to the wielder.

     - Sabotage Stone (weekly, 4): The adoption index of a specified
       AI-majority Agoran decision is hereby increased by 1.

     - Jockey Stone (monthly, 3): A specified Running horse's Race
       Position is increased by 1.

     - Protection Stone (monthly, 4): A specified stone is granted
       immunity.

     - Recursion Stone (Monthly, 4): The recursion stone can be
       wielded once per month as if it had the power of any other stone of
       your choice.

     - Hot Potato Stone (Weekly, 5):  When this stone is wielded,
       the wielder gains 8 boatloads of coins if the wielder, in the
       same message as the wielding, transfers this stone to a player
       who has not owned this stone since Agora last owned it. If this
       stone is not owned by Agora, it cannot otherwise be transferred,
       other rules notwithstanding. This stone is immune if 3 or more
       players have wielded it since the most recent collection notice.

     - Blank Stone (Monthly, 0): This stone has no effect.

     - Tasty Stone (Monthly, 4): A specified bird that is owned by a
       player is transferred to the wielder.

     - Mason's Stone (None, 0): If the Mason's Stone is owned by the
       Stonemason, its Mossiness is continuously set to 0. If the Mason's
       Stone is owned by Agora, it is transferred to the Stonemason.

     - Anti-Equatorial Stone (Monthly, 5): The mossiest stone is
       transferred to the wielder. When this happens, the Anti-Equatorial
       Stone's mossiness is incremented by 1."""
            )
        }
    }

    voting {
        votes(snail) {
            FOR on 8861
            FOR on 8862
        }

        votes(nix) {
            FOR on 8861
            FOR on 8862
        }

        votes(ziproot) {
            PRESENT on 8861
            AGAINST on 8862
        }

        votes(Jason) {
            FOR on 8861
            PRESENT on 8862
        }
    }
}