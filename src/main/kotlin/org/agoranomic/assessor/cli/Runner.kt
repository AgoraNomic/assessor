package org.agoranomic.assessor.cli

import org.agoranomic.assessor.decisions.findAssessments

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
        val allAssessmentNames = allAssessments.map { it.metadata.name }.sorted()

        println("No such assessment \"${exception.name}\": valid options are \"all\" and $allAssessmentNames")
        return
    }

    programConfig.destination.outputAssessments(programConfig.formatter.formatBatch(toAssess))
}
