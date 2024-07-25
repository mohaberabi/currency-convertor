plugins {


    alias(libs.plugins.konvertor.android.library)

}


android {
    namespace = libs.versions.appDomain.get() + ".core.common"
}