package org.agoranomic.assessor.lib.report

import org.agoranomic.assessor.lib.resolve.ProposalResolutionMap
import org.agoranomic.assessor.lib.voting_strength.VotingStrengthStep

private fun lineWithDelimiter(header: String, delimiter: Char): String {
    return header + "\n" + (delimiter.toString()).repeat(header.length) + "\n"
}

fun strengthAuditReport(resolutionMap: ProposalResolutionMap): String {
    return buildString {
        for (proposal in resolutionMap.proposals) {
            append(lineWithDelimiter("STRENGTHS FOR PROPOSAL ${proposal.number}", '='))
            appendLine()

            val strengthTrails = resolutionMap.votingStrengthsFor(proposal.number)

            for (specialPerson in strengthTrails.overriddenPersons) {
                val strengthTrail = strengthTrails.trailForPerson(specialPerson)

                append(lineWithDelimiter("Strengths for person ${specialPerson.name}", '-'))

                val steps = strengthTrail.steps()

                val noRepeatSteps =
                    listOf(steps.first()) +
                            steps
                                .zipWithNext()
                                .filter { it.first.value != it.second.value }
                                .map { it.second }

                val rows = noRepeatSteps.map { step ->
                    step.value.toString() to when (step) {
                        is VotingStrengthStep.Initial -> step.description?.readable ?: "Initial"
                        is VotingStrengthStep.Modification -> step.modification.description.readable
                    }
                }

                check(rows.isNotEmpty())

                val strengthColumnMaxLength =
                    rows.map { it.first.length }.maxOrNull() ?: error("Expected at least one entry")

                append(rows.joinToString("") { it.first.padStart(strengthColumnMaxLength) + " | " + it.second + "\n" })
                appendLine()
            }
        }
    }
}
