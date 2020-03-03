package org.agoranomic.assessor.decisions

import io.github.classgraph.ClassGraph
import io.github.classgraph.MethodInfo
import org.agoranomic.assessor.lib.AssessmentData
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

    return classGraph.scan().use { result ->
        val classInfos = result.getClassesWithMethodAnnotation(annotationName)!!

        classInfos.flatMap { classInfo ->
            // Cast to Iterable to ensure that we get stdlib functions instead of MethodInfoList methods
            val methodInfos = classInfo.methodInfo as Iterable<MethodInfo>

            methodInfos
                .filter { it.hasAnnotation(annotationName) }
                .map { methodInfo -> methodInfo.loadClassAndGetMethod().kotlinFunction }
                .map { it as KFunction<AssessmentData> }
                .map { it.call() }
        }
    }
}
