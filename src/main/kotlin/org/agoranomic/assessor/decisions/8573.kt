package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment8573() = assessment {
    name("8573")
    quorum(3)

    proposals(v4) {
        proposal(8573) {
            title("The Device")
            ai("1")
            author(G)
            coauthors(Murphy)
            ordinary()

            text(
                """

[inspired by Rules 2192-2193, "The Monster", by Murphy]


Enact a Rule "The Device" with the following text:

      When the device is on:
        * click - hummmmmmm

      When the device is off:
        * whirrrrrr - THUNK


Enact a Rule "The Mad Engineer" with the following text:

      The Mad Engineer is an office; its holder is responsible for
      building and maintaining the Device.  The device is a
      singleton switch with values off (default) and on.  The Mad
      Engineer CAN flip the device to either on or off with Agoran
      Consent; any other player CAN do so with 2 Agoran Consent.

      The Mad Engineer CAN act on behalf of
      the device to take any action that the device may take, and
      SHALL act on behalf of the device to ensure that the device
      fulfills all of its duties.

      The Mad Engineer's weekly duties include the performance of the
      following tasks, in order:

      a) Randomly select exactly one rule.  If the selected rule is
         either this rule or the rule "The Device", then
         007 has been spotted near the self-destruct button; skip
         directly to proposal submission.

      b) Select one or more contiguous sentences from the selected
         rule.

      c) Select exactly one noun from the selected text, and replace
         each instance of that noun with "Device" (including
         grammatical variations, e.g. replacing "<noun>'s" with
         "Device's").

      d) Announce intent to, with Agoran Consent, cause this rule
         to amend the rule "The Device" by inserting the modified
         text as the last list item in either the "device on" or
         "device off" lists in that rule (or, if 007 has been
         spotted, to repeal both that rule and this one).
         This intent announcement counts as the Mad Engineers's weekly
         report.

      If the announcement of intent above is made with the procedure
      described above, the Mad Engineer CAN, with Agoran Consent, cause
      this rule to amend the rule "The Device" as indicated, and SHALL
      do so if the intent receives sufficient support.


G. becomes the holder of the office of Mad Engineer.

An election for Mad Engineer is initiated. 
                """
            )
        }
    }
}
