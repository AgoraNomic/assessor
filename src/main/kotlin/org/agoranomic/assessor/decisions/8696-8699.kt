package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8696to8699() = assessment {
    name("8696-8699")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2022-July/016100.html")
    quorum(4)

    strengths {
        default(3)
        min(0)
        max(15)
    }

    proposals(v4) {
        proposal(8696) {
            title("I just win in this too")
            ai("1.0")
            author(Forest)
            coauthors(snail)
            ordinary()

            text("""
Enact a new rule with title "Very fair rule 2.0" and the text:

The player 4st CAN win the game by announcement.""")
        }

        proposal(8698) {
            title("Everyone is secretsnail")
            ai("1.0")
            author(Forest)
            ordinary()

            text("""
Enact a new rule with title "Fixing the very fair rule" and the text:
If a rule called "Very fair rule" is in the ruleset, then:
- Everyone has the role "The player secretsnail". Once a player wins, they
lose this role.

This rule explicitly takes precedence over the rule called "Very fair rule".
After "Very fair rule" is repealed, or after it is not in any current
proposals, repeal this rule the next day.
By Agoran Consent, a player can repeal "Very fair rule".""")
        }

        proposal(8699) {
            title("These birds got lazy")
            ai("1.0")
            author(Forest)
            ordinary()

            text("""
Amend Rule 2665 "The Birds" by:
- removing the text
  "The playmate then gains 1 Votive."
  and
  "If the playmate is Beast Permitted, e gains
   1 Winsome, 1 Blot-B-Gone, 1 Pendant, and 1 Votive."
- Replacing the text
 "Otherwise,
   the playmate gains 1 blot, 1 Pendant, and 1 Votive."
  with
  "If the playmate is not Beast Permitted,
   e gains 1 blot."
- Replacing the text
  "A specified player that is not the playmate gains a
        specified Product."
  with
  "Nothing happens."
- Replacing the text:
  "The playmate gains 2 blots and 1 Blot-B-Gone."
  with
  "The playmate gains 2 blots."
- Replacing the text
  " A specified player (defaulting to the playmate if not
        specified) gains the Grant associated with a specified Ministry."
  with
  "Nothing happens."""")
        }
    }

    voting {
        votes(juan) {
            AGAINST on 8696
            // PRESENT on 8697
            FOR on 8698
        }

        votes(Janet) {
            AGAINST on all
        }

        votes(nix) {
            AGAINST on 8696
            // PRESENT on 8697
            AGAINST on 8698
            AGAINST on 8699
        }

        votes(Forest) {
            FOR on all
        }

        votes(snail) {
            FOR on all
        }

        votes(G) {
            AGAINST on all
        }

        votes(ais523) {
            AGAINST on 8696
            // AGAINSt on 8697
            AGAINST on 8698
            PRESENT on 8699
        }

        votes(Murphy) {
            AGAINST on 8696
            // FOR on 8697
            AGAINST on 8698
            FOR on 8699
        }
    }
}