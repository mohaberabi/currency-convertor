import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = libs.versions.appDomain.get() + ".build-logic"
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}
tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}
dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)
}

gradlePlugin {
    plugins {
        AppPlugins.values().forEach {
            register(it.label) {
                id = it.id
                implementationClass = it.impl
            }
        }

    }
}
enum class AppPlugins(
    val label: String,
    val id: String,
    val impl: String,
) {
    AndroidLibrary(
        label = "androidLibraryConventionPlugin",
        id = "konvertor.android.library",
        impl = "AndroidLibraryConventionPlugin"
    ),
    JvmLibrary(
        label = "jvmLibraryConventionPlugin",
        id = "konvertor.jvm.library",
        impl = "JvmLibraryConventionPlugin",
    ),
    HiltAndroid(
        label = "hiltAndroidConventionPlugin",
        id = "konvertor.hilt.android",
        impl = "AndroidHiltConventionPlugin",
    ),
    ComposeLibrary(
        label = "androidLibraryComposeConventionPlugin",
        id = "konvertor.compose.android.library",
        impl = "AndroidLibraryComposeConventionPlugin",
    ),
    FeatureLibrary(
        label = "androidFeatureConventionPlugin",
        id = "konvertor.android.feature.library",
        impl = "AndroidFeatureConventionPlugin",
    ),
    FeatureComposeLibrary(
        label = "androidFeatureCompose",
        id = "konvertor.android.feature.compose",
        impl = "AndroidFeatureComposeConventionPlugin",
    ),
    AndroidApplication(
        label = "androidApplicationConventionPlugin",
        id = "konvertor.android.application",
        impl = "AndroidApplicationConventionPlugin",
    ),
    AndroidComposeApplication(
        label = "androidComposeApplicationConventionPlugin",
        id = "konvertor.android.application.compose",
        impl = "AndroidComposeApplicationConventionPlugin",
    ),
    AndroidRoom(
        label = "androidRoomConventionPlugin",
        id = "konvertor.android.room",
        impl = "AndroidRoomConventionPlugin",
    ),

}
