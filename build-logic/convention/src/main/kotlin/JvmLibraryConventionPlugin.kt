import convention.configureKotlinJvm
import org.gradle.api.Plugin
import org.gradle.api.Project


private const val jvmPlugin = "org.jetbrains.kotlin.jvm"

class JvmLibraryConventionPlugin : Plugin<Project> {


    override fun apply(target: Project) {


        with(target) {
            with(pluginManager) {
                apply(jvmPlugin)
            }
            configureKotlinJvm()
        }
    }
}