package org.agoranomic.assessor.cli

import org.agoranomic.assessor.lib.resolve.AssessmentMetadata
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption

data class AssessmentPendingOutput(
    val metadata: AssessmentMetadata,
    val assessmentText: String
)

sealed class AssessmentDestination {
    abstract fun outputAssessments(assessments: AssessmentFormatOutput)
}

object StdoutDestination : AssessmentDestination() {
    override fun outputAssessments(assessments: AssessmentFormatOutput) {
        for (assessment in assessments.outputsByName.values) {
            println(assessment)
            println()
        }
    }
}

data class NamedFileDestination(val file: String) : AssessmentDestination() {
    override fun outputAssessments(assessments: AssessmentFormatOutput) {
        Files.writeString(
            Path.of(file),
            assessments.outputsByName.values.joinToString("\n"),
            StandardOpenOption.CREATE,
            StandardOpenOption.TRUNCATE_EXISTING
        )
    }
}

object UnnamedFileDestination : AssessmentDestination() {
    override fun outputAssessments(assessments: AssessmentFormatOutput) {
        for ((name, assessment) in assessments.outputsByName) {
            val path = Path.of("$name.txt")

            Files.writeString(path, assessment, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)
        }
    }
}

data class NamedDirDestination(val dir: String) : AssessmentDestination() {
    override fun outputAssessments(assessments: AssessmentFormatOutput) {
        val dirPath = Path.of(dir)!!

        Files.createDirectories(dirPath)

        for ((name, assessment) in assessments.outputsByName) {
            val filePath = dirPath.resolve("${name}.txt")

            Files.writeString(filePath, assessment, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)
        }
    }
}

private val DEFAULT_DIR_DEST = NamedDirDestination("out")

object UnnamedDirDestination : AssessmentDestination() {
    override fun outputAssessments(assessments: AssessmentFormatOutput) =
        DEFAULT_DIR_DEST.outputAssessments(assessments)
}
