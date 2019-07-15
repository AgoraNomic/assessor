package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.lib.AssessmentData
import org.agoranomic.assessor.lib.report
import org.agoranomic.assessor.lib.resolve
import java.nio.file.Files
import java.nio.file.Path

private val assessments = mapOf("8188-8195" to `assessment 8188 to 8195`(), "8196-8201" to `assessment 8196 to 8201`())
private const val EVALUATE_ALL = "all"

fun printValidOptions() {
    println("Valid Options:")
    println("\t- $EVALUATE_ALL")
    for ((name, _) in assessments) {
        println("\t- $name")
    }
}

fun createOutDir(): Path {
    val outDir = Path.of("out")!!
    if(!Files.exists(outDir)) Files.createDirectory(outDir)
    return outDir
}

fun writeAssessment(name: String, value: AssessmentData) {
    val outDir = createOutDir()
    val outFile = outDir.resolve(name)

    Files.writeString(outFile, report(resolve(value)))
}

fun main(args: Array<String>) {
    if (args.size != 1) {
        printValidOptions()
        return
    }

    val arg = args[0]

    if (arg == EVALUATE_ALL) {
        for ((name, value) in assessments) {
            writeAssessment(name, value)
        }

        return
    }

    val assessment = assessments[arg]
    if (assessment == null) printValidOptions()
    else writeAssessment(arg, assessment)
}