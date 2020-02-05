package org.agoranomic.assessor.lib

import io.github.classgraph.ClassGraph
import kotlin.reflect.KFunction
import kotlin.reflect.jvm.jvmName
import kotlin.reflect.jvm.kotlinFunction

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class UseAssessment

fun findAssessments(): List<AssessmentData> {
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
