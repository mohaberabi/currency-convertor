package convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.provideDelegate
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


internal fun Project.configureKotlin(
    commonExtension: CommonExtension<*, *, *, *, *, *>
) {

    commonExtension.apply {

        compileSdk = 34
        defaultConfig {
            minSdk = 24

        }
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11
            isCoreLibraryDesugaringEnabled = true

        }
        configureKotlin()
        dependencies {

            "coreLibraryDesugaring"(libs.findLibrary("desugar.jdk.libs").get())
        }
    }
}

internal fun Project.configureKotlin() {
    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_11.toString()

        }
    }
}