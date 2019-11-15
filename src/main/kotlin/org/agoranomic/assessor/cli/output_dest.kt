package org.agoranomic.assessor.cli

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption

sealed class AssessmentDestination {
    abstract fun outputAssessments(assessments: List<Pair<String, String>>)
}

object StdoutDestination : AssessmentDestination() {
    override fun outputAssessments(assessments: List<Pair<String, String>>) {
        for ((name, assessment) in assessments) {
            println(assessment)
            println()
        }
    }
}

data class NamedFileDestination(val file: String) : AssessmentDestination() {
    override fun outputAssessments(assessments: List<Pair<String, String>>) {
        Files.writeString(
            Path.of(file),
            assessments.map { it.second }.joinToString("\n"),
            StandardOpenOption.CREATE,
            StandardOpenOption.TRUNCATE_EXISTING
        )
    }
}

object UnnamedFileDestination : AssessmentDestination() {
    override fun outputAssessments(assessments: List<Pair<String, String>>) {
        for ((name, assessment) in assessments) {
            val path = Path.of("$name.txt")

            Files.writeString(path, assessment, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)
        }
    }
}

data class NamedDirDestination(val dir: String) : AssessmentDestination() {
    override fun outputAssessments(assessments: List<Pair<String, String>>) {
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
    override fun outputAssessments(assessments: List<Pair<String, String>>) = DEFAULT_DIR_DEST.outputAssessments(assessments)
}
