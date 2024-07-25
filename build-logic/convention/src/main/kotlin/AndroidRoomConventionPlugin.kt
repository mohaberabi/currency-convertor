import androidx.room.gradle.RoomExtension
import com.android.build.gradle.LibraryExtension
import com.google.devtools.ksp.gradle.KspExtension
import convention.implementation
import convention.ksp
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidRoomConventionPlugin : Plugin<Project> {


    override fun apply(target: Project) {


        with(target) {

            with(pluginManager) {
                apply("androidx.room")
                apply("com.google.devtools.ksp")
            }

            extensions.configure<KspExtension> {
                arg("room.generateKotlin", "true")
            }
            extensions.configure<RoomExtension> {
                schemaDirectory("${projectDir}/schemas")
            }
            dependencies {
                ksp("room.compiler", target)
                implementation("room.ktx", target)
                implementation("room.runtime", target)
            }
        }
    }
}