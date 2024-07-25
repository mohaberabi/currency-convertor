plugins {
    alias(libs.plugins.konvertor.android.library)
    alias(libs.plugins.konvertor.hilt.android)
}


android {
    namespace = libs.versions.appDomain.get() + ".core.data"
}

dependencies {
    val modelModule = ":core:model"
    val netWorkModule = ":core:network"
    val database = ":core:database"
    val common = ":core:common"
    implementation(project(modelModule))
    implementation(project(netWorkModule))
    implementation(project(database))
    implementation(project(common))

    implementation(libs.androidx.work)
    implementation(libs.hilt.ext.work)
}