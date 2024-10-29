import org.gradle.kotlin.dsl.test
import org.gradle.kotlin.dsl.testImplementation
import org.gradle.kotlin.dsl.testRuntimeOnly

plugins {
    kotlin("jvm") version "2.0.21"
    kotlin("plugin.serialization") version "2.0.21"
}

group = "edu.trincoll"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
    testImplementation(platform("org.junit:junit-bom:5.11.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}