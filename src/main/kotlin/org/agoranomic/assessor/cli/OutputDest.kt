package org.agoranomic.assessor.cli

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption

data class AssessmentPendingOutput(
    val name: String,
    val assessmentText: String
)

sealed class AssessmentDestination {
    abstract fun outputAssessments(assessments: List<AssessmentPendingOutput>)
}

object StdoutDestination : AssessmentDestination() {
    override fun outputAssessments(assessments: List<AssessmentPendingOutput>) {
        for ((_, assessment) in assessments) {
            println(assessment)
            println()
        }
    }
}

data class NamedFileDestination(val file: String) : AssessmentDestination() {
    override fun outputAssessments(assessments: List<AssessmentPendingOutput>) {
        Files.writeString(
            Path.of(file),
            assessments.map { it.assessmentText }.joinToString("\n"),
            StandardOpenOption.CREATE,
            StandardOpenOption.TRUNCATE_EXISTING
        )
    }
}

object UnnamedFileDestination : AssessmentDestination() {
    override fun outputAssessments(assessments: List<AssessmentPendingOutput>) {
        for ((name, assessment) in assessments) {
            val path = Path.of("$name.txt")

            Files.writeString(path, assessment, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)
        }
    }
}

data class NamedDirDestination(val dir: String) : AssessmentDestination() {
    override fun outputAssessments(assessments: List<AssessmentPendingOutput>) {
        val dirPath = Path.of(dir)!!

        Files.createDirectories(dirPath)

        for ((name, assessment) in assessments) {
            val filePath = dirPath.resolve("$name.txt")

            Files.writeString(filePath, assessment, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)
        }
    }
}

private val DEFAULT_DIR_DEST = NamedDirDestination("out")

object UnnamedDirDestination : AssessmentDestination() {
    override fun outputAssessments(assessments: List<AssessmentPendingOutput>) = DEFAULT_DIR_DEST.outputAssessments(assessments)
}
