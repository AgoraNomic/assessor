package org.agoranomic.assessor.cli

import org.agoranomic.assessor.lib.resolve.AssessmentMetadata
import java.nio.file.Files
import java.nio.file.OpenOption
import java.nio.file.Path
import java.nio.file.StandardOpenOption
import kotlin.io.path.writeBytes
import kotlin.io.path.writeText

data class AssessmentPendingOutput(
    val metadata: AssessmentMetadata,
    val assessmentText: String,
)

sealed class AssessmentDestination {
    abstract fun outputAssessments(assessments: AssessmentFormatOutput)
}

private fun AssessmentOutputData.toNestedString(): String {
    return when (this) {
        is AssessmentOutputData.Text -> {
            data
        }

        is AssessmentOutputData.Bytes -> {
            "Bytes: ${bytes().contentToString()}"
        }
    }
}

object StdoutDestination : AssessmentDestination() {
    override fun outputAssessments(assessments: AssessmentFormatOutput) {
        for (assessment in assessments.outputsByName.values) {
            println(assessment.toNestedString())
            println()
        }
    }
}

data class NamedFileDestination(val file: String) : AssessmentDestination() {
    override fun outputAssessments(assessments: AssessmentFormatOutput) {
        Files.writeString(
            Path.of(file),
            assessments.outputsByName.values.joinToString("\n") { it.toNestedString() },
            StandardOpenOption.CREATE,
            StandardOpenOption.TRUNCATE_EXISTING
        )
    }
}

private fun Path.writeOuputData(
    outputData: AssessmentOutputData,
    vararg options: OpenOption,
) {
    return when (outputData) {
        is AssessmentOutputData.Text -> {
            writeText(
                text = outputData.data,
                options = options,
            )
        }

        is AssessmentOutputData.Bytes -> {
            writeBytes(
                array = outputData.bytes(),
                options = options,
            )
        }
    }
}

object UnnamedFileDestination : AssessmentDestination() {
    override fun outputAssessments(assessments: AssessmentFormatOutput) {
        for ((name, assessment) in assessments.outputsByName) {
            val path = Path.of("$name.txt")

            path.writeOuputData(assessment, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)
        }
    }
}

data class NamedDirDestination(val dir: String) : AssessmentDestination() {
    override fun outputAssessments(assessments: AssessmentFormatOutput) {
        val dirPath = Path.of(dir)!!

        Files.createDirectories(dirPath)

        for ((name, assessment) in assessments.outputsByName) {
            val filePath = dirPath.resolve("${name}.txt")

            filePath.writeOuputData(assessment, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)
        }
    }
}

private val DEFAULT_DIR_DEST = NamedDirDestination("out")

object UnnamedDirDestination : AssessmentDestination() {
    override fun outputAssessments(assessments: AssessmentFormatOutput) =
        DEFAULT_DIR_DEST.outputAssessments(assessments)
}
