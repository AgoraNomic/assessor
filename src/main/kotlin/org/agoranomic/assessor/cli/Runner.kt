package org.agoranomic.assessor.cli

import org.agoranomic.assessor.lib.findAssessments
import org.agoranomic.assessor.lib.resolve

private val DEFAULT_DESTINATION = StdoutDestination
private val DEFAULT_FORMATTER = HumanReadableFormatter(CONFIG_LONG)

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println(helpString())
        return
    }

    val allAssessments = findAssessments()

    val cliConfig = try {
        parseCli(args)
    } catch (e: Exception) {
        println(e.message)
        return
    }

    val formatter = cliConfig.formatter ?: DEFAULT_FORMATTER
    val destination = cliConfig.destination ?: DEFAULT_DESTINATION
    val neededAssessments = cliConfig.neededAssessments

    val toAssess = try {
        neededAssessments.selectFrom(allAssessments)
    } catch (exception: InvalidAssessmentNameException) {
        val allAssessmentNames = allAssessments.map { it.name }.sorted()

        println("No such assessment \"${exception.name}\": valid options are \"all\" and $allAssessmentNames")
        return
    }

    val stringAssessments = toAssess.map { it.name to formatter.format(resolve(it)) }

    destination.outputAssessments(stringAssessments)
}
