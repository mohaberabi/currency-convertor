package convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies


internal fun Project.configureAndroidComposeLibrary(
    commonExtension: CommonExtension<*, *, *, *, *, *>
) {


    commonExtension.apply {
        buildFeatures {
            compose = true
        }
        composeOptions {
            kotlinCompilerExtensionVersion =
                libs.findVersion("androidXComposeCompiler").get().toString()
        }

    }
}

internal fun Project.addComposeLibs(
    commonExtension: CommonExtension<*, *, *, *, *, *>
) {

    dependencies {
        val uiToolingPreview = "androidx.ui.tooling-preview"
        val material3 = "androidx.material3"
        val runTimeCompose = "androidx.lifecycle.runtimeCompose"
        val uiTooling = "androidx.ui.tooling"
        val bom = libs.findLibrary("androidx.compose.bom").get()
        with(this@addComposeLibs) {
            debugImplementation(uiTooling, this)
            implementation(uiToolingPreview, this)
            implementation(material3, this)
            implementation(runTimeCompose, this)
            implementation(platform(bom))

            val lifecycleRuntime = "androidx.lifecycle.runtimeCompose"
            val lifecycleViewModel = "androidx.lifecycle.viewModelCompose"
            val hiltNavigationCompose = "androidx.hilt.navigation.compose"
            implementation(lifecycleRuntime, this)
            implementation(lifecycleViewModel, this)
            implementation(hiltNavigationCompose, this)

        }


    }
}