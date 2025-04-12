plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.myapplication"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdk = 24
        targetSdk = 35
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
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }

    composeOptions {
        // Use a compatible Compose Compiler Extension Version.
        kotlinCompilerExtensionVersion = "1.5.0"
    }
}

dependencies {

    // Import the Compose BOM to manage all Compose dependency versions
    implementation(platform("androidx.compose:compose-bom:2023.05.01"))

    // Core Compose dependencies (versions managed by the BOM)
    implementation("androidx.compose.ui:ui")

    // Use the legacy Material library (NOT Material3) to get BottomSheetScaffold APIs
    implementation("androidx.compose.material:material")

    // Compose Navigation (optional, for screen navigation)
    implementation("androidx.navigation:navigation-compose:2.6.0")

    // Tooling libraries for preview and debugging
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation(libs.androidx.material3.android)
    implementation(libs.androidx.camera.core)
    debugImplementation("androidx.compose.ui:ui-tooling")

    // Activity Compose integration
    implementation("androidx.activity:activity-compose:1.7.2")
}