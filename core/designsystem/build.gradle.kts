plugins {
    alias(libs.plugins.konvertor.compose.android.library)

}


android {
    namespace = libs.versions.appDomain.get() + ".core.designsystem"
}