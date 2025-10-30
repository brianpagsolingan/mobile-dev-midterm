plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.midterm_brian_pagsolingan"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.midterm_brian_pagsolingan"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Room components
    implementation("androidx.room:room-runtime-android:2.8.2")
    annotationProcessor("androidx.room:room-compiler:2.8.2")

    // Lifecycle componenents
    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel:2.9.4")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata:2.9.4")
    // LifeCycles only without viewmodel or livedata
    implementation("androidx.lifecycle:lifecycle-runtime:2.9.4")

    // Saved state module for ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.9.4")

    // Annotation processor
    implementation("androidx.lifecycle:lifecycle-common-java8:2.9.4")
}