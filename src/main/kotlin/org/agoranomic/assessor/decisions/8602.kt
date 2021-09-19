package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8602() = assessment {
    name("8602")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2021-September/015289.html")
    quorum(6)

    strengths {
        default(3)
        min(0)
        max(15)
    }

    proposals(v4) {
        proposal(8602) {
            title("ROCKS ROCKS ROCKS")
            ai("2.0")
            author(RLee)
            ordinary()
            sponsored()

            text("""
Amend rule 2642, 'Distributing Stones' by replacing its second paragraph
with 'The Stonemason SHALL if possible initiate such an auction monthly and
only once a month, in a timely fashion after a collection notice has been
issued. The Stonemason SHALL auction exactly 2 stones in a month if
possible'

Retitle rule 2644 'The Gauntlet' to 'Zen Gardening' [cosmetic change to
remove the annoying movie reference that I discussed once on discord]

Amend rule 2644 by replacing any instances of the word 'Gauntlet' with
'Rock Garden' [sorry for the bad way of putting this, but this rule might
get amended soon so I have to do it for safety]

Amend rule 2644 by replacing '5 or more' with '8 or more' [If there are 10
stones you should need more to win obviously'

Amend rule 2645 'The Stones' by adding the following text on the end.
"-  Recursion Stone (Monthly, 80%): The recursion stone can be wielded once
per
month as if it had the power of any other stone of your choice.

- Hot Potato Stone (Weekly, 100%): You must transfer this stone to a player
of your choice
who has never owned this stone since the last time agora has owned it. Then
the original wielder gains 8 boatloads of coins.
SPECIAL RULE: Other rules notwithstanding, this stone never escapes as long
as at least three players have owned it in the last Agoran month

Blank Stone (Monthly, 5%): This stone has no effect.

Alchemy Stone (weekly, 70%): Destroy four cards you own. If four cards were
destroyed this way, gain 7 products of your choice"""")
        }
    }

    voting {
        votes(Murphy) {
            PRESENT on 8602
        }

        votes(Jason) {
            PRESENT on 8602
        }

        votes(G) {
            AGAINST on 8602
        }

        votes(RLee) {
            FOR on 8602
        }

        votes(ais523) {
            AGAINST on 8602
        }

        votes(ATMunn) {
            PRESENT on 8602
        }

        votes(Falsifian) {
            AGAINST on 8602
        }
    }
}
