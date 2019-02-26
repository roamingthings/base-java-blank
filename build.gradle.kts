import org.gradle.api.JavaVersion.VERSION_1_8

extra["assertjVersion"] = "3.12.0"
extra["junitVersion"] = "5.4.0"
extra["mockitoVersion"] = "2.24.5"

buildscript {
    repositories {
        mavenCentral()
    }
}

plugins {
    java
}

group = "de.roamingthings"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    val junitVersion: String by extra
    val mockitoVersion: String by extra
    val assertjVersion: String by extra

    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    testRuntimeOnly("org.junit.vintage:junit-vintage-engine:$junitVersion")

    testCompile("org.assertj:assertj-core:$assertjVersion")
    testCompile("org.mockito:mockito-core:$mockitoVersion")
    testCompile("org.mockito:mockito-junit-jupiter:$mockitoVersion")
}

configure<JavaPluginConvention> {
    sourceCompatibility = VERSION_1_8
}
