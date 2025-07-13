# AudioWaveformView

A synchronized dual-view audio waveform visualization component for Android with native Compose support.

## Overview

AudioWaveformView provides a synchronized scrolling experience with two waveform views that move in complementary directions. The component is built with Jetpack Compose for modern Android development.

## Features

- **Native Compose Implementation**: Pure Compose implementation without XML dependencies
- **Synchronized Scrolling**: Perfect offset synchronization between left and right waveforms
- **Customizable Offset**: Configure the scroll offset as a fraction of screen width
- **Material 3 Support**: Built-in Material 3 styling variants
- **Modern Architecture**: Uses Compose's declarative UI paradigm

## Usage

### Basic Implementation

```kotlin
@Composable
fun MyScreen() {
    AudioWaveformView(
        height = 120.dp
    )
}
```

### With Custom Drawables

```kotlin
@Composable
fun MyScreen() {
    AudioWaveformView(
        height = 120.dp,
        waveFirstSrc = R.drawable.my_custom_wave_1,
        waveSecondSrc = R.drawable.my_custom_wave_2
    )
}
```

### Advanced Configuration

```kotlin
@Composable
fun MyScreen() {
    AudioWaveformView(
        height = 120.dp,
        waveFirstSrc = R.drawable.my_custom_wave_1,
        waveSecondSrc = R.drawable.my_custom_wave_2,
        offsetFraction = 1f/8f, // Custom offset
        dividerWidth = 1.dp,
        dividerColor = Color.Gray
    )
}
```

### Simplified Version

```kotlin
@Composable
fun MyScreen() {
    AudioWaveformViewSimple(
        height = 120.dp
    )
}
```

### Material 3 Styled

```kotlin
@Composable
fun MyScreen() {
    AudioWaveformViewMaterial3(
        height = 120.dp
    )
}
```

## API Reference

### AudioWaveformView

| Parameter | Type | Default | Description |
|-----------|------|---------|-------------|
| `modifier` | `Modifier` | `Modifier` | The modifier to be applied to the view |
| `height` | `Dp` | `200.dp` | Height of the waveform view |
| `waveFirstSrc` | `Int?` | `null` | Resource ID for the first wave drawable |
| `waveSecondSrc` | `Int?` | `null` | Resource ID for the second wave drawable |
| `offsetFraction` | `Float` | `1f/12f` | Scroll offset as fraction of screen width |
| `dividerWidth` | `Dp` | `2.dp` | Width of the center divider |
| `dividerColor` | `Color` | `Color.Transparent` | Color of the center divider |

### AudioWaveformViewSimple

| Parameter | Type | Default | Description |
|-----------|------|---------|-------------|
| `modifier` | `Modifier` | `Modifier` | The modifier to be applied to the view |
| `height` | `Dp` | `120.dp` | Height of the waveform view |
| `waveFirstSrc` | `Int?` | `null` | Resource ID for the first wave drawable |
| `waveSecondSrc` | `Int?` | `null` | Resource ID for the second wave drawable |

## Implementation Details

### Synchronization Algorithm

The component uses a sophisticated scroll synchronization mechanism:

1. **Offset Calculation**: The left view is initialized with an offset of `screenWidth * offsetFraction`
2. **Bidirectional Sync**: Changes in either scroll view trigger updates in the other
3. **Smooth Scrolling**: Uses Compose's `LaunchedEffect` for smooth state updates
4. **Preventing Loops**: Synchronization flags prevent infinite update loops

### Performance Optimizations

- **Native Compose**: No XML inflation or View interop overhead
- **Efficient Recomposition**: Optimized state management to minimize recompositions
- **Memory Efficient**: Uses Compose's built-in memory management

## Default Drawables

The component includes default waveform drawables:
- `soundwave_first_default_0` - Default first waveform
- `soundwave_second_default_0` - Default second waveform

## Contributing

When contributing to this component:

1. Follow Material 3 design principles
2. Ensure smooth performance on all screen sizes
3. Add appropriate tests for new features
4. Maintain the native Compose approach

#  License

Copyright 2025 Fernando Prieto Moyano

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
