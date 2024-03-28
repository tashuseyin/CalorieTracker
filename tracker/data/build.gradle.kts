plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

apply(from = "$rootDir/base-module.gradle")

android {
    namespace = "com.tashuseyin.data"
}

dependencies {
    implementation(project(":core"))
    implementation(project(":tracker:domain"))

    // retrofit
    implementation(libs.retrofit)
    implementation(libs.moshi.converter)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging.interceptor)

    // room
    implementation(libs.room.ktx)
    "ksp"(libs.room.compiler)
    implementation(libs.room.runtime)
}