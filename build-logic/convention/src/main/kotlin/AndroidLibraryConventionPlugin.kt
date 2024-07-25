import com.android.build.gradle.LibraryExtension
import convention.ConventionsConst
import convention.configureKotlin
import convention.implementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies


class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {

        with(target) {
            with(pluginManager) {
                apply(ConventionsConst.ANDROID_LIB_PLUGIN)
                apply(ConventionsConst.JETBRAINS_ANDROID)
            }


            extensions.configure<LibraryExtension> {
                configureKotlin(this)
            }

            dependencies {
                implementation("kotlinx.coroutines", target)
            }
        }

    }

}