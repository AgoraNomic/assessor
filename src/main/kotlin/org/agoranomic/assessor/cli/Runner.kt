package org.agoranomic.assessor.cli

import org.agoranomic.assessor.decisions.findAssessments
import org.agoranomic.assessor.lib.resolve

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println(helpString())
        return
    }

    val allAssessments = findAssessments()

    val cliConfig = try {
        parseCli(args)
    } catch (e: CliParseException) {
        println(e.message)
        return
    }

    val programConfig = ProgramConfig.withDefaults(cliConfig)

    val toAssess = try {
        programConfig.neededAssessments.selectFrom(allAssessments)
    } catch (exception: InvalidAssessmentNameException) {
        val allAssessmentNames = allAssessments.map { it.name }.sorted()

        println("No such assessment \"${exception.name}\": valid options are \"all\" and $allAssessmentNames")
        return
    }

    val pendingAssessments = toAssess.map {
        AssessmentPendingOutput(
            name = it.name,
            assessmentText = programConfig.formatter.format(resolve(it))
        )
    }

    programConfig.destination.outputAssessments(pendingAssessments)
}
