import com.android.build.gradle.internal.plugins.AppPlugin

plugins {
    alias(libs.plugins.konvertor.android.library)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.konvertor.hilt.android)

}
android {
    namespace = libs.versions.appDomain.get() + ".core.network"
}

dependencies {
    implementation(libs.retrofit)
    implementation(libs.retrofit.logger)
    implementation(libs.kotlin.serialization.json)
    implementation(libs.retrofit.kotlin.serialization)
    implementation(project(":core:model"))
}