plugins {


    alias(libs.plugins.konvertor.android.feature.compose)

}


android {


    namespace = libs.versions.appDomain.get() + ".feature.convertor"
}

dependencies {
    implementation(project(":core:data"))
    implementation(project(":core:common"))

}