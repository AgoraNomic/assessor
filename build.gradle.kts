plugins {
    java
    id("org.jetbrains.kotlin.jvm") version "1.3.50"
}

val kotlinVersion = "1.3.50"

group = "org.agoranomic"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-collections-immutable-jvm:0.3")
    implementation("commons-cli:commons-cli:1.4")
    implementation("io.github.classgraph:classgraph:4.8.46")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.13.0")

    testImplementation("org.jetbrains.kotlin:kotlin-test:$kotlinVersion")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:$kotlinVersion")
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
