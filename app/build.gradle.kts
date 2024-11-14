plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    namespace = "com.example.cofflyz"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.cofflyz"
        minSdk = 29
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.activity)
    implementation ("androidx.navigation:navigation-fragment-ktx:2.5.3")
    implementation ("androidx.navigation:navigation-ui-ktx:2.5.3")
    implementation ("com.google.android.material:material:1.6.1")
    implementation ("androidx.recyclerview:recyclerview:1.2.1")

    implementation ("androidx.navigation:navigation-fragment-ktx:2.5.3") // Ganti dengan versi terbaru
    implementation ("androidx.navigation:navigation-ui-ktx:2.5.3") // Ganti dengan versi terbaru
    implementation ("com.google.android.material:material:1.6.0")
    implementation("com.tbuonomo:dotsindicator:5.0")
    implementation ("com.google.firebase:firebase-auth:21.0.8")


    implementation (libs.androidx.viewpager2)
    implementation (libs.material.v140)
    implementation(libs.androidx.annotation)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


}