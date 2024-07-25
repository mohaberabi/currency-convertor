import com.android.build.gradle.LibraryExtension
import convention.ConventionsConst
import convention.addComposeLibs
import convention.configureAndroidComposeLibrary
import convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

internal class AndroidLibraryComposeConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {


        with(target) {
            with(pluginManager) {
                apply(ConventionsConst.APP_ANDROID_LIB_PLUGIN)
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