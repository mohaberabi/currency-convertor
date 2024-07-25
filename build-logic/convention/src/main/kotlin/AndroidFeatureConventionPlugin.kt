import convention.ConventionsConst
import convention.implementation
import convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies


class AndroidFeatureConventionPlugin : Plugin<Project> {


    override fun apply(target: Project) {

        with(target) {
            with(pluginManager) {
                apply(ConventionsConst.APP_ANDROID_LIB_PLUGIN)
                apply("konvertor.hilt.android")
            }
            dependencies {
                val ui = ":core:ui"
                val design = ":core:designsystem"
                val model = ":core:model"
                val data = ":core:data"


                implementation(project(ui))
                implementation(project(design))
                implementation(project(model))
                implementation(project(data))


            }
        }
    }

}