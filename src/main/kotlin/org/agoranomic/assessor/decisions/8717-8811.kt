package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8717to8811() = assessment {
    name("8717-8811")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2022-July/016166.html")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(15)
    }

    proposals(v4) {
        proposal(8717) {
            title("Normalize ribbons")
            ai("3.0")
            author(Murphy)
            coauthors(snail)
            ordinary()

            text("""
Amend Rule 2438 (Ribbons) by replacing "qualifies for" with "earns" in
the methods of obtaining these types of Ribbon: Green (G), Platinum (P),
Lime (L), Transparent (T).

Award a Platinum ribbon to each player who has been Speaker since
22 June 2022 at midnight UTC and has not had a Platinum ribbon since
that time.""")
        }

        proposal(8718) {
            title("Well, we kind of mean it")
            ai("3.0")
            author(Jason)
            coauthors(ais523)
            ordinary()

            text("""
If a proposal entitled "No, we really mean it" has taken effect in the
past 30 days, this proposal has no further effect.

Amend Rule 1728 (Tabled Actions) by replacing the paragraph beginning "A
person CAN act" with the following

{

A person, acting as emself, CAN by announcement table an intent (syn.
"intend") to perform a tabled action, clearly, conspicuously,
explicitly, and without obfuscation specifying the action, the method
(including non-default parameter values), and, optionally, conditions.

}


[Resubmission of P8707 without the "highest possible communication
standard" clause.]""")
        }

        proposal(8719) {
            title("Proposal order clarification")
            ai("3.0")
            author(Jason)
            ordinary()

            text("""
Amend Rule 106 by replacing the sentence "When a proposal takes effect,
the proposal applies the changes that it specifies, except as prohibited
by other rules." with the following:

{

When a proposal takes effect, the proposal applies the changes that it
specifies in its text, except as prohibited by other rules. Unless
otherwise specified by the text, the effects are applied in the order
they appear in the text.

}


[Clarify that the only place that proposal effects can be "specified" is
in the text and explicitly state that the effects are applied in listed
order.]""")
        }

        proposal(8720) {
            title("Actually reward proposals")
            ai("1.0")
            author(Jason)
            ordinary()

            text("""
Amend Rule 2496 by replacing "Being the author of an adopted sponsored
proposal" with "Being the author of an adopted proposal".""")
        }

        proposal(8721) {
            title("Option A")
            ai("2.2")
            author(snail)
            ordinary()

            text("""
Repeal Rule 2618 (Promises).""")
        }

        proposal(8722) {
            title("Option B")
            ai("2.5")
            author(snail)
            ordinary()

            text("""
Repeal Rule 1742 (Contracts).""")
        }

        proposal(8723) {
            title("Option C")
            ai("1.7")
            author(snail)
            ordinary()

            text("""
Repeal Rule 2450 (Pledges).""")
        }

        proposal(8811) {
            title("Infractions")
            ai("2.0")
            author(nix)
            ordinary()

            text("""
[This proposal seeks to replace the current criminal system with an
Infraction system. This is meant to be a simplified system that is
adjusted based on severity.

The biggest change is that blots are automatic. A class N infraction
gets N blots as soon as it happens. The Investigator can, however, tweak
them up or down. There is some guiding language to encourage this.

Blots are removed weekly by any player that hasn't gained one this week
or last (to prevent timing silliness). This means serious infractions
will either take you a while to recover from, or require multiple
players to forgive you.]

Amend R2555 (Blots) to read, in full:

       Blots are an indestructible fixed currency with ownership
       restricted to persons. A person with 1 or more blots is Impure, a
       person with 0 blots is Pure. An impure unregistered person is a
       Fugitive. The Referee is an office, and the recordkeepor for
       blots.

       To expunge a blot is to destroy it. Destroying blots is secured
       with a Power Threshold of 1.7.

       A person CAN, by announcement, create a specified number of blots
       in eir possession.

       Any player who has not expunged a blot by this method this week
       CAN expunge 1 blot from a specified player who has not gained a
       blot this or the previous week, by announcement.

       At the beginning of each quarter, half (rounded down) of each
       fugitive's blots are destroyed.

Amend R2478 to be titled "Infractions" and to read, in full:

     An Infraction is a violation of a SHALL or SHALL NOT in a rule. The
     infracter for an infraction is the person who committed the
     infraction.

     The Investigator for an infraction is the Referee unless e is the
     infracter. Otherwise, it is the Arbitor.

     The Class of an infraction is 2 unless a rule specifies a different
     Class for it.

     When a player commits an infraction, N blots are created in eir
     possession, where N is the class of the infraction.

     A player CAN, by announcement, "note" an infraction committed by any
     other player in the last 7 days by specifying the incident and the
     rule that contains the SHALL or SHALL NOT (or name of the Infraction
     if it has one). The Investigator of an infraction CAN and SHALL once
     by announcement grant 1 boatload of coins to the player that noted
     the infraction in a timely manner after e does so.

     The Referee's weekly report contains a list of Infractions committed
     in the previous week.

     The Investigator of an infraction CAN, by announcement, "reduce" the
     infraction by specifying a reason and a number between 1 and half of
     N (inclusive and rounded up), where N is the class of the
     infraction. When e does so, N (or all if N is greater than all)
     blots in possession of the infracter are expunged. E SHOULD do so if
     e believes the infraction was inconsequential or unavoidable, or if
     e believes the infracter has fixed it or shown remorse.

     The Investigator of an infraction CAN, by announcement, "increase"
     the infraction by specifying a reason and a number between 1 and
     half of N (inclusive and rounded down), where N is the class of the
     infraction. When e does so, N blots are created in the infracter's
     possession. E SHOULD do so if e believes the infraction was harmful,
     belligerent, or intentional.

     The above notwithstanding, an infraction CANNOT be increased or
     reduced if it happened more than 14 days ago or it has already
     been increased or reduced.

Repeal rules 2557 "Sentencing Guidelines" and 2531 "Defendant's Rights".

Amend Rules 2660 (Birds), 2143 (Official Reports and Duties), 2202
(Ratification Without Objection), 2450 (Pledges), and 2545 (Auctions) in
the given order by replacing every instance of the word "crime" with
"infraction".""")
        }
    }

    voting {
        votes(Murphy) {
            FOR on 8717
            FOR on 8718
            FOR on 8719
            FOR on 8720
            AGAINST on 8721
            AGAINST on 8722
            AGAINST on 8723
            FOR on 8811
        }

        votes(Forest) {
            FOR on 8717
            FOR on 8718
            FOR on 8719
            FOR on 8720
            FOR on 8721
            AGAINST on 8722
            FOR on 8723
            FOR on 8811
        }

        votes(G) {
            AGAINST on 8717
            FOR on 8718
            FOR on 8719
            FOR on 8720
            AGAINST on 8721
            FOR on 8722
            AGAINST on 8723
            endorse(nix) on 8811
        }

        votes(juan) {
            PRESENT on 8717
            PRESENT on 8718
            PRESENT on 8719
            PRESENT on 8720
            PRESENT on 8721
            PRESENT on 8722
            PRESENT on 8723
            PRESENT on 8811
        }

        votes(nix) {
            AGAINST on 8717
            FOR on 8718
            FOR on 8719
            FOR on 8720
            AGAINST on 8721
            AGAINST on 8722
            AGAINST on 8723
            FOR on 8811
        }

        votes(Jason) {
            AGAINST on 8717
            FOR on 8718
            FOR on 8719
            FOR on 8720
            AGAINST on 8721
            AGAINST on 8722
            AGAINST on 8723
            FOR on 8811
        }

        votes(snail) {
            FOR on 8717
            AGAINST on 8718
            AGAINST on 8719
            AGAINST on 8720
            FOR on 8721
            FOR on 8722
            FOR on 8723
            AGAINST on 8811
        }

        votes(ais523) {
            AGAINST on 8717
            PRESENT on 8718
            FOR on 8719
            FOR on 8720
            AGAINST on 8721
            AGAINST on 8722
            FOR on 8723
            AGAINST on 8811
        }
    }
}