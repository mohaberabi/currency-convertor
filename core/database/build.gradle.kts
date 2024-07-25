plugins {

    alias(libs.plugins.konvertor.android.library)
    alias(libs.plugins.konvertor.android.room)
    alias(libs.plugins.konvertor.hilt.android)

}

android {
    namespace = libs.versions.appDomain.get() + ".core.database"
}

dependencies {

    implementation(project(":core:model"))

    implementation(project(":core:common"))
}