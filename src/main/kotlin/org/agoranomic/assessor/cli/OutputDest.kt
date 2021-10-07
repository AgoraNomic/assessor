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
        is AssessmentOutputData.Nested -> {
            subData.values.joinToString("\n") { it.toNestedString() }
        }

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
        for (assessment in assessments.outputs.subData.values) {
            println(assessment.toNestedString())
            println()
        }
    }
}

data class NamedFileDestination(val file: String) : AssessmentDestination() {
    override fun outputAssessments(assessments: AssessmentFormatOutput) {
        Files.writeString(
            Path.of(file),
            assessments.outputs.toNestedString(),
            StandardOpenOption.CREATE,
            StandardOpenOption.TRUNCATE_EXISTING
        )
    }
}

private fun writeOutputNestedDataNoSubDir(
    parentPath: Path,
    outputData: AssessmentOutputData.Nested,
) {
    for ((subName, subAssessmentData) in outputData.subData) {
        writeOutputData(
            parentPath = parentPath,
            name = subName,
            outputData = subAssessmentData,
        )
    }
}

private fun writeOutputData(
    parentPath: Path,
    name: String,
    outputData: AssessmentOutputData,
) {
    return when (outputData) {
        is AssessmentOutputData.Nested -> {
            val subDir = parentPath.resolve(name)
            writeOutputNestedDataNoSubDir(subDir, outputData)
        }

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

        writeOutputNestedDataNoSubDir(
            parentPath = basePath,
            outputData = assessments.outputs,
        )
    }
}

data class NamedDirDestination(val dir: String) : AssessmentDestination() {
    override fun outputAssessments(assessments: AssessmentFormatOutput) {
        val dirPath = Path.of(dir)!!.toAbsolutePath()

        Files.createDirectories(dirPath)

        writeOutputNestedDataNoSubDir(
            parentPath = dirPath,
            outputData = assessments.outputs,
        )
    }
}

private val DEFAULT_DIR_DEST = NamedDirDestination("out")

object UnnamedDirDestination : AssessmentDestination() {
    override fun outputAssessments(assessments: AssessmentFormatOutput) =
        DEFAULT_DIR_DEST.outputAssessments(assessments)
}
