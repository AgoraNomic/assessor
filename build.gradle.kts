plugins {
    kotlin("jvm") version "1.8.10"
    kotlin("plugin.serialization") version "1.8.10"
    application
}

group = "org.agoranomic"
version = "1.0-SNAPSHOT"

kotlin {
    jvmToolchain(17)
}

repositories {
    mavenCentral()
}

dependencies {
    fun kotlinx(module: String, version: String? = null): Any =
        "org.jetbrains.kotlinx:kotlinx-$module${version?.let { ":$version" } ?: ""}"

    implementation(kotlin("reflect"))
    implementation(kotlinx("collections-immutable", "0.3.5"))
    implementation(kotlinx("serialization-json", "1.4.1"))
    implementation("commons-cli:commons-cli:1.4")
    implementation("io.github.classgraph:classgraph:4.8.154")
    implementation("org.randomcat:kotlin-utils:2.0.1")
    implementation("org.snakeyaml:snakeyaml-engine:2.6")

    // Dependencies for statistics
    implementation("org.jetbrains.lets-plot:lets-plot-batik:3.2.0")
    implementation("org.jetbrains.lets-plot:lets-plot-kotlin-jvm:4.4.1")

    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit5"))
    testImplementation(group = "org.junit.jupiter", name = "junit-jupiter", version = "5.9.2")
}

tasks.test {
    useJUnitPlatform()

    testLogging {
        events("passed", "skipped", "failed")
    }
}

application {
    applicationName = "assessor"
    mainClass.set("org.agoranomic.assessor.cli.RunnerKt")
}
