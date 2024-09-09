plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
    id("io.gitlab.arturbosch.detekt")
}

android {
    namespace = "com.darssolutions.examplemvvm"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.darssolutions.examplemvvm"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        ksp {
            arg("room.schemaLocation", "$projectDir/schemas")
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
        compose = true
    }
}

dependencies {

    val composeBomVersion = "2024.09.00"
    val coreKtxVersion = "1.13.1"
    val appCompatVersion = "1.7.0"
    val materialVersion = "1.12.0"
    val constraintLayoutVersion = "2.1.4"
    val lifecycleVersion = "2.8.5"
    val fragmentKtxVersion = "1.8.3"
    val navigationVersion = "2.8.0"
    val activityKtxVersion = "1.9.2"
    val retrofitVersion = "2.11.0"
    val coroutinesVersion = "1.8.1"
    val hiltVersion = "2.52"
    val roomVersion = "2.6.1"
    val junitVersion = "4.13.2"
    val mockkVersion = "1.13.12"
    val coroutinesTestVersion = "1.8.1"
    val coreTestingVersion = "2.2.0"
    val junitExtVersion = "1.2.1"
    val espressoCoreVersion = "3.6.1"
    val fragmentTestingVersion = "1.8.3"

    // Compose
    val composeBom = platform("androidx.compose:compose-bom:$composeBomVersion")
    implementation(composeBom)
    androidTestImplementation(composeBom)

    // Material Design
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material:material-icons-core")

    // Preview Support
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")

    // UI Tooling
    debugImplementation("androidx.compose.ui:ui-tooling")

    implementation("androidx.core:core-ktx:$coreKtxVersion")
    implementation("androidx.appcompat:appcompat:$appCompatVersion")
    implementation("com.google.android.material:material:$materialVersion")
    implementation("androidx.constraintlayout:constraintlayout:$constraintLayoutVersion")

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.5")

    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")
    implementation("androidx.compose.runtime:runtime-livedata:1.7.0")

    // Fragment
    implementation("androidx.fragment:fragment-ktx:$fragmentKtxVersion")

    // Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:$navigationVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navigationVersion")

    // Activity
    implementation("androidx.activity:activity-ktx:$activityKtxVersion")
    implementation("androidx.activity:activity-compose:1.9.2")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")

    // Dagger Hilt
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    ksp("com.google.dagger:hilt-compiler:$hiltVersion")

    // Room
    implementation("androidx.room:room-runtime:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")
    ksp("androidx.room:room-compiler:$roomVersion")

    testImplementation("junit:junit:$junitVersion")
    testImplementation("io.mockk:mockk:$mockkVersion")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesTestVersion")
    testImplementation("androidx.arch.core:core-testing:$coreTestingVersion")

    androidTestImplementation("androidx.test.ext:junit:$junitExtVersion")
    androidTestImplementation("androidx.test.espresso:espresso-core:$espressoCoreVersion")
    androidTestImplementation("androidx.fragment:fragment-testing:$fragmentTestingVersion")
}
