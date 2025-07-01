import org.jetbrains.kotlin.gradle.dsl.KotlinVersion
import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.vanniktech)
	alias(libs.plugins.versions)
}

kotlin {
    jvmToolchain(17)

    compilerOptions {
        apiVersion.set(KotlinVersion.KOTLIN_2_0)
    }
    explicitApi()
}

mavenPublishing {
    coordinates("$group", name, "$version")
    // publishToMavenCentral(SonatypeHost.DEFAULT)
    // or when publishing to https://central.sonatype.com/
    publishToMavenCentral()
    signAllPublications()
}

fun isNonStable(version: String): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.uppercase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return isStable.not()
}
// https://github.com/ben-manes/gradle-versions-plugin
tasks.withType<DependencyUpdatesTask> {
    rejectVersionIf {
        isNonStable(candidate.version)
    }
}

