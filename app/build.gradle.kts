plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.microgatgetsnew2"
    compileSdk = 33


    defaultConfig {
        applicationId = "com.example.microgatgetsnew2"
        minSdk = 29
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation("com.google.code.gson:gson:2.8.9")
    implementation("com.squareup.okhttp3:okhttp:4.10.0")
    implementation ("androidx.fragment:fragment:1.3.6")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.8.0"))
    implementation ("com.google.android.material:material:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.annotation:annotation:1.6.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    configurations.implementation {
        exclude(group = "org.jetbrains.kotlin", module = "kotlin-stdlib-jdk7:1.6.21")
    }
}