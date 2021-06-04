plugins {
    java
    kotlin("jvm") version "1.5.0"
    kotlin("plugin.serialization") version "1.5.0"
}

group = "org.agoranomic"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    fun kotlinx(module: String, version: String? = null): Any =
        "org.jetbrains.kotlinx:kotlinx-$module${version?.let { ":$version" } ?: ""}"

    implementation(kotlin("reflect"))
    implementation(kotlinx("collections-immutable", "0.3.4"))
    implementation(kotlinx("serialization-json", "1.2.1"))
    implementation("commons-cli:commons-cli:1.4")
    implementation("io.github.classgraph:classgraph:4.8.46")
    implementation("org.randomcat:kotlin-utils:2.0.1")

    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit5"))
    testImplementation(group = "org.junit.jupiter", name = "junit-jupiter", version = "5.5.2")
}

tasks.test {
    useJUnitPlatform()

    testLogging {
        events("passed", "skipped", "failed")
    }
}

tasks.create<Jar>("fatJar") {
    manifest {
        attributes["Implementation-Title"] = "Agora Assessor"
        attributes["Implementation-Version"] = project.version
        attributes["Main-Class"] = "org.agoranomic.assessor.cli.RunnerKt"
    }

    archiveFileName.set("assessor.jar")

    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    with(tasks["jar"] as CopySpec)
}

tasks.compileKotlin {
    sourceCompatibility = "11"
    kotlinOptions.jvmTarget = "11"

    kotlinOptions {
        freeCompilerArgs += listOf("-Xinline-classes")
    }
}

tasks.compileTestKotlin {
    kotlinOptions.jvmTarget = "11"
}
