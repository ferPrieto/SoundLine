# AudioWaveformView

[![Maven Central](https://img.shields.io/maven-central/v/com.github.fprieto/audiowaveformview.svg)](https://search.maven.org/artifact/com.github.fprieto/audiowaveformview)
[![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=21)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

A custom Android view that displays audio waveforms with a scrollable timeline interface, similar to SoundCloud's track visualization.

## Features

- 🎵 **Dual Waveform Display**: Shows both completed and remaining portions of audio
- 📱 **Smooth Scrolling**: Synchronized horizontal scrolling between waveform views
- 🎨 **Customizable**: Configurable waveform images and colors
- 🔄 **Interactive**: Touch and fling gestures for smooth navigation
- 📐 **Responsive**: Adapts to different screen sizes and orientations

## Screenshots

![AudioWaveformView Demo](../art/SoundLine.gif)

## Installation

Add this to your module's `build.gradle` file:

```gradle
dependencies {
    implementation 'com.github.fprieto:audiowaveformview:1.0.0'
}
```

## Usage

### Basic Implementation

Add the view to your XML layout:

```xml
<prieto.fernando.soundline.SoundLineView
    android:id="@+id/sound_line_view"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:wave_first_src="@drawable/your_completed_waveform"
    app:wave_second_src="@drawable/your_remaining_waveform" />
```

Initialize in your Activity/Fragment:

```kotlin
val soundLineView = findViewById<SoundLineView>(R.id.sound_line_view)
soundLineView.initWaves()
```

### Custom Attributes

| Attribute | Description | Default |
|-----------|-------------|---------|
| `app:wave_first_src` | Drawable resource for the completed waveform | `soundwave_first_default_0` |
| `app:wave_second_src` | Drawable resource for the remaining waveform | `soundwave_second_default_0` |

### Available Waveform Resources

The library includes several built-in waveform images:

**Completed waveforms:**
- `soundwave_first_default_0` (short)
- `soundwave_first_default_1` (medium)  
- `soundwave_first_default_2` (long)

**Remaining waveforms:**
- `soundwave_second_default_0` (short)
- `soundwave_second_default_1` (medium)
- `soundwave_second_default_2` (long)

### Example with Custom Waveforms

```xml
<prieto.fernando.soundline.SoundLineView
    android:id="@+id/sound_line_view"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:wave_first_src="@drawable/my_custom_active_wave"
    app:wave_second_src="@drawable/my_custom_inactive_wave" />
```

## How It Works

The AudioWaveformView uses two synchronized `HorizontalScrollView` components:

1. **Left View**: Shows the "completed" portion of the audio waveform
2. **Right View**: Shows the "remaining" portion of the audio waveform

When the user scrolls either view, both views are synchronized to maintain the timeline effect.

## Requirements

- **Minimum SDK**: API 21 (Android 5.0)
- **Target SDK**: API 34 (Android 14)
- **Kotlin**: Compatible with Kotlin projects

## Sample App

Check out the sample app in this repository to see AudioWaveformView in action.

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

```
Copyright 2024 Fernando Prieto

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
``` 