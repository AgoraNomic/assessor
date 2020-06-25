package org.agoranomic.assessor.lib

private fun lineWithDelimiter(header: String, delimiter: Char): String {
    return header + "\n" + (delimiter.toString()).repeat(header.length) + "\n"
}

fun strengthAuditReport(resolutionMap: ProposalResolutionMap): String {
    return buildString {
        for (proposal in resolutionMap.proposals) {
            append(lineWithDelimiter("STRENGTHS FOR PROPOSAL ${proposal.number}", '='))
            appendln()

            val strengthTrails = resolutionMap.votingStrengthsFor(proposal.number)

            for (specialPerson in strengthTrails.overriddenPersons) {
                val strengthTrail = strengthTrails.trailForPerson(specialPerson)

                append(lineWithDelimiter("Strengths for person ${specialPerson.name}", '-'))

                val steps = strengthTrail.stepsWithValues()

                val noRepeatSteps =
                    listOf(steps.first()) +
                            (steps.drop(1)).zip(steps.dropLast(1))
                                .filter { it.first.second != it.second.second }
                                .map { it.first }

                val rows = noRepeatSteps.map { (modification, strength) ->
                    strength.toString() to (modification?.description?.readable ?: "Initial")
                }

                check(rows.isNotEmpty())

                val strengthColumnMaxLength =
                    rows.map { it.first.length }.max() ?: error("Expected at least one entry")

                append(rows.joinToString("") { it.first.padStart(strengthColumnMaxLength) + " | " + it.second + "\n" })
                appendln()
            }
        }
    }
}
