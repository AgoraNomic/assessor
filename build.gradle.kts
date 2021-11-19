plugins {
    kotlin("jvm") version "1.5.31"
    kotlin("plugin.serialization") version "1.5.31"
    application
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

    // Dependencies for statistics
    implementation("org.jetbrains.lets-plot:lets-plot-batik:2.2.0")
    implementation("org.jetbrains.lets-plot:lets-plot-kotlin-jvm:3.1.0")

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

application {
    applicationName = "assessor"
    mainClass.set("org.agoranomic.assessor.cli.RunnerKt")
}

tasks.compileKotlin {
    sourceCompatibility = "11"
    kotlinOptions.jvmTarget = "11"
}

tasks.compileTestKotlin {
    kotlinOptions.jvmTarget = "11"
}
