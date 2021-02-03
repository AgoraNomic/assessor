package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.ministries.Office_2020_12_31.*
import org.agoranomic.assessor.dsl.ministries.ministries_2020_12_31
import org.agoranomic.assessor.dsl.ministries.officeMapOf
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.addToHolder
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.lib.proposal.MinistryV2.Compliance
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8532to8537() = assessment {
    name("8532-8537")
    quorum(7)

    val offices = officeMapOf(
        ADoP to Murphy,
        Arbitor to G,
        Assessor to Jason,
        Distributor to omd,
        Herald to nix,
        Ministor to nix,
        Notary to ATMunn,
        PrimeMinister to ATMunn,
        Promotor to Aris,
        Referee to JTAC,
        Registrar to Falsifian,
        Rulekeepor to Jason,
        Speaker to CuddleBeam,
        Stonemason to Jason,
        Tailor to null,
        Treasuror to Trigon,
        Webmastor to nix,
    )

    strengths {
        min(0)
        max(15)
        default(3)

        blotPenalty(RLee, 7 / 3)

        addToHolder(offices, Speaker, 1)
        ministries_2020_12_31(offices, allProposals)
    }

    proposals(v3) {
        proposal(8532) {
            title("Turn Undead v2")
            ai("3.0")
            author(G)
            democratic()
            sponsored()

            text("""
[
diffs from proto:
 - Made activity switchable in both directions at will.
 - Defined two verbs.
 - Adjusted time limits as suggested.
 - Added inactivity as a cfj recusal reason.
diffs from v1:
 - Made emailing a deregistree a SHOULD, but changed the method to
   w/o three objections, with the idea that if there's question
   about the email headers or whatever, objections can pragmatically
   handle the issue.
]

Create the following Rule, Activity:

  Activity is a player switch tracked by the Registrar, with values
  Active (default) and Inactive.  To flip a player's activity to
  active (inactive) is to activate (deactivate) em.  The date on
  which each player's activity was last changed is part of the
  Registrar's weekly report.

  A player CAN activate or deactivate emself by announcement.

  Any player CAN, with notice, make a player who has not made a
  public announcement in the past 30 days inactive.

  If a player has been inactive continuously for the past 60 days,
  then any player CAN deregister em without 3 objections. The
  Registrar SHOULD attempt to deregister players who meet this
  condition. The publication of intent for such a deregistration
  SHOULD be sent to the inactive player's registered email address
  at the same time that it is published.


Every player's activity is flipped to active [unneeded I think due
to default behavior, but precautionary?]


Amend Rule 2492 (Recusal) by appending the following text to the
second paragraph:
  The Arbitor CAN recuse an inactive or deregistered judge from a
  case by announcement.

Repeal Rule 2532 (Zombies).
Repeal Rule 2574 (Zombie Life Cycle).
Repeal Rule 2639 (Zombie Phase-Out).
Repeal Rule 1885 (Zombie Auctions).

Amend Rule 2472 (Office Incompatibilities) by deleting:
  A zombie is Overpowered if e holds one or more offices.

Amend Rule 2531 (Defendant's Rights) by deleting:
  (10) it attempts to levy a fine on a zombie for an action that
       its master performed on its behalf.

Amend Rule 2621 (VP Wins) by replacing "non-zombie"  with "active".

Amend Rule 2581 (Official Patent Titles) by deleting:
  - Necromancer, awardable by the Registrar to any player who makes
    such sufficient persistent legal use of zombies that rules need
    to be amended to prevent such practices.

[Checked all the other uses of "active" and "inactive" pertaining to
players, looked like all would work fine under this version]""")
        }

        proposal(8533) {
            title("de-dictatorship")
            ai("3.0")
            author(G)
            coauthors(Jason, nix)
            democratic()
            sponsored()

            text("""
Amend Rule 2614 (Eclipse Light) by appending the following paragraph:
  Rules to the contrary notwithstanding, Emergency Regulations
  CANNOT be enacted, amended, or repealed except as described in
  this Rule.


Amend Rule 683 (Voting on Agoran Decisions) by appending the following
sentence to the final paragraph:
  Submitting and withdrawing ballots is secured.


Amend Rule 955 (Determining the Will of Agora) by replacing:

  The strength of a ballot is the voting strength of the voter who cast
  it on that Agoran decision.

with:

  The strength of a ballot is the voting strength of the voter who cast
  it on that Agoran decision, as calculated at the end of that
  decision's voting period.


Change the power of Rule 2168 (Extending the Voting Period) to 2.


[Adding security to R107 makes a jumbled couple of paragraphs
so some logical re-arranging is needed.  I think no text was deleted or
modified other than adding the security.]

Amend Rule 107 (Initiating Agoran Decisions) by replacing:
  The publication of such a valid notice initiates the voting period
  for the decision. The voting period lasts for 7 days. The minimum
  voting period for a decision with at least two options is five
  days. The vote collector for a decision with less than two options
  CAN and SHALL end the voting period by announcement, if it has not
  ended already, and provided that e resolves the decision in the
  same message.

  The voting period for a decision cannot be set or changed to a
  duration longer than fourteen days.

with:

  The publication of such a valid notice initiates the voting period
  for the decision. The voting period lasts for 7 days. The minimum
  voting period for a decision with at least two options is five
  days. The voting period for a decision cannot be set or changed to
  a duration longer than fourteen days. Changing the length of a
  decision's voting period is secured at power 2.

  The vote collector for a decision with less than two options
  CAN and SHALL end the voting period by announcement, if it has not
  ended already, and provided that e resolves the decision in the
  same message.


Repeal Rule 2633 (Rulebending).


[R2486 openly welcomes additions to the parade when events warrant it]
Amend Rule 2486 (The Royal Parade) by appending the following text:

  NEXT UP in the Parade comes the Discordian Court:  G. the Grand
  Vizier is arguing with Jason the Untitled, while nix, Court
  Anarchist, is cramming cancelled ballots into eir pockets.""")
        }

        proposal(8534) {
            title("Power Up")
            ai("3.3")
            author(Aris)
            democratic()
            sponsored()

            text("""
Change the power of Rule 1030, "Precedence between Rules", from 3.2
to 3.3.

Change the power of Rule 2141, "Role and Attributes of Rules",
from 3.1 to 3.2.

Change the power of Rule 1551, "Ratification", from 3.1 to 3.2.

Change the power of Rule 2614, "Eclipse Light", from 3.01 to 3.1.""")
        }

        proposal(8535) {
            title("We the People")
            ai("3.0")
            author(Aris)
            coauthors(Trigon, nix, G, Gaelan)
            democratic()
            sponsored()

            text("""
Amend Rule 869, "How to Join and Leave Agora", by replacing:

  Any entity that is or ever was an organism generally capable of
  freely originating and communicating independent thoughts and
  ideas is a person. Rules to the contrary notwithstanding, no other
  entities are persons.

with:

  Any entity (including a group of confederated entities) that is or
  ever was able to willingly communicate original ideas is a person.
  Rules to the contrary notwithstanding, no other entities are persons.

  Questions about personhood are to be resolved equitably,
  with regard for the good-faith of those involved and the customs of
  honorable play.

and then, immediately after:

  An Unregistered person CAN (unless explicitly forbidden or
  prevented by the rules) register by publishing a message that
  indicates reasonably clearly and reasonably unambiguously that e
  intends to become a player at that time.

inserting the new text:

  No person can be a player if e is part of another player or
  another player is part of em.

and inserting a paragraph break immediately thereafter.


Amend Rule 2499, "Welcome Packages", by replacing:

  When a player receives a Welcome Package, if e has not received
  one in the past 30 days, then e gains 10 boatloads of coins and
  one of each type of Card defined in the rules.

with:

  When a player receives a Welcome Package, e gains 10 boatloads of coins and
  one of each type of Card defined in the rules, unless e, or any person
  of whom e was a part or who was a part of em has received a welcome
  package in the last 30 days.


# CLEANUP

Ben and Claire of the BC System are hereby declared to be separate persons;
each patent title they collectively bore is revoked and granted to
each of them individually.

[Interpretive notes may be found in the message "BUS: Interpretive Notes
for We the People".]""")
        }

        proposal(8536) {
            title("Justice for All")
            ai("1.7")
            author(Aris)
            coauthors(G, Jason)
            chamber(Compliance)
            sponsored()

            text("""
[This is OP and was only used twice in the whole of last year. We could
reform it so that the Referee could only use it for just reasons,
but honestly I don't think that's a priority — this feels like
a waste of space on something that's dangerous and almost unused. If
someone wants to add something like it back later, they can figure out how
to do it in less space.]

Repeal Rule 2479, "Official Injustice".

Amend Rule 2478, "Vigilante Justice", by replacing:

  The Referee is by default the investigator for all Finger
  Pointing. If the Referee is the perp, then the Arbitor CAN
  become the investigator of that Finger Pointing by announcement.

  The Referee CANNOT Point eir Finger. The Arbitor CANNOT Point eir
  Finger at the Referee. A high crime is any crime specified as
  being class 4 or greater. The Referee CANNOT levy the Cold Hand of
  Justice to punish a high crime, notwithstanding Rule 2478.

with:

  The Referee is by default the investigator for all Finger
  Pointing. When the Referee's Finger is Pointed or the Referee
  is the perp, the Arbitor is the investigator.

  The Referee CANNOT Point eir Finger at the Arbitor, and the Arbitor
  CANNOT point eir finger at the Referee.

  A high crime is any crime specified as being class 4 or greater.
  The Referee CANNOT levy the Cold Hand of Justice to punish a high crime,
  the other provisions of this rule notwithstanding.""")
        }

        proposal(8537) {
            title("Unofficial injustice")
            ai("1.7")
            author(G)
            chamber(Compliance)
            sponsored()

            text("""
[The only functionality change is to add a method for giving
people blots for a fee.  The rule has a typo, and needs a logical
rearrangement, so putting in the whole text.]

Amend Rule 2555 (Blots) to read in full.

  Blots are an indestructible fixed currency with ownership
  restricted to persons. A person with 1 or more blots is Impure, a
  person with 0 blots is Pure. An impure unregistered person is a
  Fugitive. The Referee is an office, and the recordkeepor for
  blots.

  To levy a fine of N on a person, where N is a positive integer or
  zero, is to grant em N blots. To expunge a blot is to destroy it.
  Levying fines and destroying blots are each secured with a Power
  Threshold of 1.7.

  A person CAN, by announcement, create a specified number of blots
  in eir possession.

  Any player CAN expunge a blot from a specified person (or emself
  if no one is specified) by paying a fee of one Blot-B-Gone.

  Any player CAN levy a fine of one blot on a specified person by
  paying a fee of two Blot-B-Gones, provided the specified person
  has not already gained two blots or more in the current week.

  At the beginning of each quarter, half (rounded down) of each
  fugitive's blots are destroyed.


Repeal Rule 2479 (Official Injustice).""")
        }
    }

    voting {
        votes(Aris) {
            PRESENT on 8532
            FOR on 8533
            FOR on 8534
            FOR on 8535
            FOR on 8536
            FOR on 8537
        }

        votes(nix) {
            PRESENT on 8532
            FOR on 8533
            // TODO resolve conditional vote on 8534: FOR if G. and Jason unconditionally FOR, else PRESENT
            PRESENT on 8535
            PRESENT on 8536
            PRESENT on 8537
        }

        votes(G) {
            FOR on all
        }

        votes(Jason) {
            endorse(G) on 8532
            FOR on 8533
            FOR on 8534
            PRESENT on 8535
            FOR on 8536
            PRESENT on 8537
        }

        votes(ATMunn) {
            FOR on 8532
            FOR on 8533
            FOR on 8534
            endorse(Aris) on 8535
            FOR on 8536
            FOR on 8537
        }

        votes(Gaelan) {
            FOR on 8532
            FOR on 8533
            AGAINST on 8534
            FOR on 8535
            FOR on 8536
            FOR on 8537
        }

        votes(Trigon) {
            FOR on 8532
            FOR on 8533
            FOR on 8534
            FOR on 8535
            FOR on 8536
            PRESENT on 8537
        }

        votes(Falsifian) {
            endorse(G) on 8532
            endorse(G) on 8533
            endorse(Aris) on 8534
            endorse(Aris) on 8535
            endorse(Aris) on 8536
            endorse(G) on 8537
        }

        votes(Murphy) {
            FOR on 8532
            FOR on 8533
            PRESENT on 8534
            FOR on 8535
            PRESENT on 8536
            FOR on 8537
        }
    }
}
