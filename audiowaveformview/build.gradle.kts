plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    `maven-publish`
}

android {
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
        compose = true
    }
    
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()
    }
    
    namespace = "com.github.fprieto.audiowaveformview"
    
    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(libs.kotlin.stdlib)
    
    // AndroidX Core Dependencies  
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.core)
    
    // Compose BOM for version alignment
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.foundation)
    implementation(libs.compose.material3)
    implementation(libs.compose.activity)
    
    // Compose Debug Tools
    debugImplementation(libs.compose.ui.tooling)
    debugImplementation(libs.compose.ui.test.manifest)
}

// Force resolution of compatible AndroidX versions
configurations.configureEach {
    resolutionStrategy {
        force("androidx.core:core:${libs.versions.androidxCore.get()}")
        force("androidx.core:core-ktx:${libs.versions.androidxCore.get()}")
        force("androidx.appcompat:appcompat:${libs.versions.androidxAppcompat.get()}")
        force("androidx.activity:activity-compose:${libs.versions.activityCompose.get()}")
    }
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("maven") {
                from(components["release"])
                
                groupId = "com.github.fprieto"
                artifactId = "audiowaveformview"
                version = "1.0.0"
                
                pom {
                    name.set("AudioWaveformView")
                    description.set("A custom Android view that displays audio waveforms with scrollable timeline interface similar to SoundCloud")
                    url.set("https://github.com/fprieto/SoundLine")
                    
                    licenses {
                        license {
                            name.set("The Apache License, Version 2.0")
                            url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                        }
                    }
                    
                    developers {
                        developer {
                            id.set("fprieto")
                            name.set("Fernando Prieto")
                            email.set("f.prieto.moyano@gmail.com")
                        }
                    }
                    
                    scm {
                        connection.set("scm:git:github.com/fprieto/SoundLine.git")
                        developerConnection.set("scm:git:ssh://github.com/fprieto/SoundLine.git")
                        url.set("https://github.com/fprieto/SoundLine/tree/master")
                    }
                }
            }
        }
        
        repositories {
            maven {
                name = "GitHubPackages"
                url = uri("https://maven.pkg.github.com/fprieto/SoundLine")
                credentials {
                    username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                    password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
                }
            }
        }
    }
} 