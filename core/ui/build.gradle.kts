plugins {
    alias(libs.plugins.konvertor.compose.android.library)
}
android {
    namespace = libs.versions.appDomain.get() + ".core.ui"
}


dependencies {
    val designModule = ":core:designsystem"
    implementation(project(designModule))
}