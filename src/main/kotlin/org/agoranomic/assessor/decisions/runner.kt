package org.agoranomic.assessor.decisions

import io.github.classgraph.ClassGraph
import org.agoranomic.assessor.lib.AssessmentData
import org.agoranomic.assessor.lib.getOrFail
import org.agoranomic.assessor.lib.report
import org.agoranomic.assessor.lib.resolve
import java.lang.Exception
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption
import kotlin.reflect.KFunction
import kotlin.reflect.jvm.jvmName
import kotlin.reflect.jvm.kotlinFunction

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class UseAssessment

private fun StdoutDestination.output(assesments: List<Pair<String, String>>) {
    for ((name, assessment) in assesments) {
        println(assessment)
        println()
    }
}

private fun NamedFileDestination.output(assesments: List<Pair<String, String>>) {
    Files.writeString(Path.of(file), assesments.map { it.second }.joinToString("\n"), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)
}

private fun UnnamedFileDestination.output(assessments: List<Pair<String, String>>) {
    for ((name, assessment) in assessments) {
        val path = Path.of(name + ".txt")

        Files.writeString(path, assessment, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)
    }
}

private fun NamedDirDestination.output(assesments: List<Pair<String, String>>) {
    val dirPath = Path.of(dir)!!

    Files.createDirectories(dirPath)

    for ((name, assessment) in assesments) {
        val filePath = dirPath.resolve(name + ".txt")

        Files.writeString(filePath, assessment, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)
    }
}

private fun UnnamedDirDestination.output(assesments: List<Pair<String, String>>) {
    NamedDirDestination("out").output(assesments)
}

private fun OutputDestination.output(assessments: List<Pair<String, String>>) {
    return when (this) {
        is StdoutDestination -> output(assessments)
        is NamedFileDestination -> output(assessments)
        is UnnamedFileDestination -> output(assessments)
        is NamedDirDestination -> output(assessments)
        is UnnamedDirDestination -> output(assessments)
    }
}

private val DEFAULT_DESTINATION = StdoutDestination

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println(helpString())
        return
    }

    val assessments = findAnnotatedAssessmentMethods()
    val assessmentsByName = assessments.associateBy { it.name }

    val cliConfig = try {
        parseCli(args)
    } catch (e: Exception) {
        println(e.message)
        return
    }

    val config = cliConfig.reportConfig
    val destination = cliConfig.destination ?: DEFAULT_DESTINATION

    val toAssess: List<Pair<String, AssessmentData>> = run {
        when (val neededAssessments = cliConfig.neededAssessments) {
            is AllAssessments -> assessmentsByName.toList()

            is SingleAssessment -> {
                val name = neededAssessments.name

                if (assessmentsByName.containsKey(name)) {
                    return@run listOf(name to assessmentsByName.getOrFail(name))
                } else {
                    println("No such assessment \"$name\": valid options are \"all\" and ${assessmentsByName.keys}.")
                    return@main
                }
            }
        }
    }

    val stringAssessments = toAssess.map { it.first to report(resolve(it.second), config) }

    destination.output(stringAssessments)
}

private fun findAnnotatedAssessmentMethods(): List<AssessmentData> {
    val packageName = "org.agoranomic.assessor.decisions"
    val annotationName = UseAssessment::class.jvmName

    val classGraph = ClassGraph().enableAllInfo().whitelistPackages(packageName)

    val rawAssessments = mutableListOf<AssessmentData>()

    classGraph.scan().use { result ->
        result!!

        val classInfoList = result.getClassesWithMethodAnnotation(annotationName)!!

        for (classInfo in classInfoList) {
            for (methodInfo in classInfo.methodInfo) {
                if (methodInfo.hasAnnotation(annotationName)) {
                    rawAssessments += (methodInfo.loadClassAndGetMethod().kotlinFunction as KFunction<AssessmentData>).call()
                }
            }
        }
    }

    return rawAssessments
}