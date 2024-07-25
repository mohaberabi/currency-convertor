import com.android.build.api.dsl.ApplicationExtension
import com.android.build.gradle.LibraryExtension
import convention.ConventionsConst
import convention.configureKotlin
import convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure


class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {

        target.run {
            pluginManager.run {
                apply(ConventionsConst.ANDROID_APP_PLUGIN)
                apply(ConventionsConst.JETBRAINS_ANDROID)
            }
            extensions.configure<ApplicationExtension> {
                defaultConfig {
                    applicationId = libs.findVersion(ConventionsConst.APP_ID).get().toString()
                    targetSdk =
                        libs.findVersion(ConventionsConst.TARGET_SDK).get().toString().toInt()
                    versionCode =
                        libs.findVersion(ConventionsConst.VERSION_CODE).get().toString().toInt()
                    versionName = libs.findVersion(ConventionsConst.VERSION_NAME).get().toString()
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                    vectorDrawables {
                        useSupportLibrary = true
                    }
                }


            }
            extensions.configure<ApplicationExtension> {
                configureKotlin(this)
            }

        }
    }
}