package org.agoranomic.assessor.cli

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption
import kotlin.io.path.writeBytes
import kotlin.io.path.writeText

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

private fun writeOuputData(
    parentPath: Path,
    name: String,
    outputData: AssessmentOutputData,
) {
    return when (outputData) {
        is AssessmentOutputData.Text -> {
            parentPath.resolve("$name.txt").writeText(
                text = outputData.data,
                options = arrayOf(
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING,
                ),
            )
        }

        is AssessmentOutputData.Bytes -> {
            parentPath.resolve(name + "." + outputData.extension).writeBytes(
                array = outputData.bytes(),
                options = arrayOf(
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING,
                ),
            )
        }
    }
}

object UnnamedFileDestination : AssessmentDestination() {
    override fun outputAssessments(assessments: AssessmentFormatOutput) {
        val basePath = Path.of(".").toAbsolutePath()

        for ((name, assessment) in assessments.outputsByName) {
            writeOuputData(
                parentPath = basePath,
                name = name,
                outputData = assessment,
            )
        }
    }
}

data class NamedDirDestination(val dir: String) : AssessmentDestination() {
    override fun outputAssessments(assessments: AssessmentFormatOutput) {
        val dirPath = Path.of(dir)!!.toAbsolutePath()

        Files.createDirectories(dirPath)

        for ((name, assessment) in assessments.outputsByName) {
            writeOuputData(
                parentPath = dirPath,
                name = name,
                outputData = assessment,
            )
        }
    }
}

private val DEFAULT_DIR_DEST = NamedDirDestination("out")

object UnnamedDirDestination : AssessmentDestination() {
    override fun outputAssessments(assessments: AssessmentFormatOutput) =
        DEFAULT_DIR_DEST.outputAssessments(assessments)
}
