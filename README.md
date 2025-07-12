[![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-SoundLine-green.svg?style=flat )]( https://android-arsenal.com/details/1/8033 )
# AudioWaveformView

AudioWaveformView is an Android custom view which similarly works as the `SoundCloud` track time line.
By using two different `HorizontalScrollViews`, the effect looks pretty similar and it's possible to customize the image resource used for the waves.

<p align="center">
    <img src="art/SoundLine.gif"/>
</p>

## Getting Started

Add the **audiowaveformview** library to your project using one of the following methods:

### JitPack (Recommended)

Add the JitPack repository to your root `build.gradle` file:

```gradle
allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

Add the dependency to your app's `build.gradle` file:

```gradle
dependencies {
    implementation 'com.github.fprieto:SoundLine:latest-version'
}
```

### GitHub Packages

Add the GitHub Packages repository to your root `build.gradle` file:

```gradle
allprojects {
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://maven.pkg.github.com/fprieto/SoundLine")
            credentials {
                username = project.findProperty("gpr.user") ?: System.getenv("USERNAME")
                password = project.findProperty("gpr.key") ?: System.getenv("TOKEN")
            }
        }
    }
}
```

Add the dependency:

```gradle
dependencies {
    implementation 'com.github.fprieto.audiowaveformview:audiowaveformview:latest-version'
}
```

### Maven Local (Development)

For local development, you can publish to your local Maven repository:

```bash
./gradlew publishToMavenLocal
```

Then add the dependency:

```gradle
dependencies {
    implementation 'com.github.fprieto.audiowaveformview:audiowaveformview:1.0.0'
}
```

## Usage

In your layout add **prieto.fernando.soundline.SoundLineView** and you can specify the drawable resources ```app:wave_first_src``` and ```app:wave_second_src``` (optional).

### XML Layout

```xml
<prieto.fernando.soundline.SoundLineView
    android:id="@+id/soundLineView"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:wave_first_src="@drawable/custom_first_default_0"
    app:wave_second_src="@drawable/custom_second_default_0" />
```

### Kotlin Code

```kotlin
import prieto.fernando.soundline.SoundLineView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val soundLineView = findViewById<SoundLineView>(R.id.soundLineView)
        // Configure your SoundLineView here
    }
}
```

- By default, there are 3 different sound waves to use (with three different lengths):
*soundwave_first_default_0.png
soundwave_first_default_1.png
soundwave_first_default_2.png*

- Also 3 default sound waves for the non complete track:
*soundwave_second_default_0.png
soundwave_second_default_1.png
soundwave_second_default_2.png*

## Sample

There is a sample in the project where the sound waves are set *custom_first_default_0* and *custom_second_default_0*


#  License

Copyright 2020 Fernando Prieto Moyano

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.


