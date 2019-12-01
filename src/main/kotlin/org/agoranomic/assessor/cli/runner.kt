package org.agoranomic.assessor.cli

import org.agoranomic.assessor.lib.AssessmentData
import org.agoranomic.assessor.lib.findAssessments
import org.agoranomic.assessor.lib.getOrFail
import org.agoranomic.assessor.lib.resolve

private val DEFAULT_DESTINATION = StdoutDestination
private val DEFAULT_FORMATTER = HumanReadableFormatter(CONFIG_LONG)

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println(helpString())
        return
    }

    val assessments = findAssessments()
    val assessmentsByName = assessments.associateBy { it.name }

    val cliConfig = try {
        parseCli(args)
    } catch (e: Exception) {
        println(e.message)
        return
    }

    val formatter = cliConfig.formatter ?: DEFAULT_FORMATTER
    val destination = cliConfig.destination ?: DEFAULT_DESTINATION

    val toAssess: List<Pair<String, AssessmentData>> = run {
        when (val neededAssessments = cliConfig.neededAssessments) {
            is AllAssessments -> assessmentsByName.toList()

            is SingleAssessment -> {
                val name = neededAssessments.name

                if (assessmentsByName.containsKey(name)) {
                    return@run listOf(name to assessmentsByName.getOrFail(name))
                } else {
                    println("No such assessment \"$name\": valid options are \"all\" and ${assessmentsByName.keys}.")
                    return@main
                }
            }
        }
    }

    val stringAssessments = toAssess.map { it.first to formatter.format(resolve(it.second)) }

    destination.outputAssessments(stringAssessments)
}
