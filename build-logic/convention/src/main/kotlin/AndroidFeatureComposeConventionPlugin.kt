import com.android.build.gradle.LibraryExtension
import convention.addComposeLibs
import convention.configureAndroidComposeLibrary
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidFeatureComposeConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("konvertor.android.feature.library")

            }

            extensions.configure<LibraryExtension> {
                configureAndroidComposeLibrary(this)
            }
            extensions.configure<LibraryExtension> {
                addComposeLibs(this)
            }
        }
    }
}