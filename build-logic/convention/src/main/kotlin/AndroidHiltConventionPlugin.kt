import com.android.utils.TraceUtils.simpleId
import convention.implementation
import convention.ksp
import convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies


class AndroidHiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {

        with(target) {
            with(pluginManager) {
                apply("com.google.devtools.ksp")
                apply("com.google.dagger.hilt.android")
            }
            dependencies {
                implementation("hilt.android", target)
                ksp("hilt.compiler", target)
            }
        }
    }
}