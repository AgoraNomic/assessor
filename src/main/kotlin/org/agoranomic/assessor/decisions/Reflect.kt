package org.agoranomic.assessor.decisions

import io.github.classgraph.ClassGraph
import org.agoranomic.assessor.lib.resolve.AssessmentData
import kotlin.reflect.KFunction
import kotlin.reflect.jvm.jvmName
import kotlin.reflect.jvm.kotlinFunction

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class UseAssessment

fun findAssessments(): List<AssessmentData> {
    val packageName = "org.agoranomic.assessor.decisions"
    val annotationName = UseAssessment::class.jvmName

    val classGraph = ClassGraph().enableAllInfo().acceptPackages(packageName)

    return classGraph.scan().use { result ->
        result.getClassesWithMethodAnnotation(annotationName).flatMap { classInfo ->
            classInfo.methodInfo
                .asSequence()
                .filter { it.hasAnnotation(annotationName) }
                .map { it.loadClassAndGetMethod().kotlinFunction }
                .map { it as KFunction }
                .map { it.call() }
                .map { it as AssessmentData }
        }
    }
}
