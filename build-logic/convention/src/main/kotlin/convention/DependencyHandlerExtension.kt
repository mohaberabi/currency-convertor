package convention


import org.gradle.api.Project
import org.gradle.kotlin.dsl.DependencyHandlerScope


internal fun DependencyHandlerScope.implementation(
    lib: Any,
) = "implementation"(lib)

internal fun DependencyHandlerScope.implementation(
    lib: String,
    project: Project,
) = "implementation"(project.libs.findLibrary(lib).get())

internal fun DependencyHandlerScope.debugImplementation(
    lib: String,
    project: Project,
) = "debugImplementation"(project.libs.findLibrary(lib).get())


internal fun DependencyHandlerScope.processor(
    lib: String,
    processor: String,
    project: Project,
) = "$processor"(project.libs.findLibrary(lib).get())

internal fun DependencyHandlerScope.ksp(
    lib: String,
    project: Project,
) = processor(
    processor = "ksp",
    lib = lib,
    project = project,
)
