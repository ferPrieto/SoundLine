# TimelineView

A synchronized dual-view timeline visualization component for Android with native Compose support.

## Overview

TimelineView provides a synchronized scrolling experience with two content views that move in complementary directions. The component is built with Jetpack Compose for modern Android development and is perfect for timeline-based applications like audio/video editing, progress visualization, and data browsing.

## Installation

### 1. Add this dependency in `build.gradle` (app-level)

Kotlin: 

```kotlin
implementation("com.github.ferPrieto:timelineview:LATEST_VERSION_NUMBER")
```

Groovy:

```groovy
implementation 'com.github.ferPrieto:timelineview:LATEST_VERSION_NUMBER'
```

If you are using a Gradle version catalog through a `libs.versions.toml` file:

1. Add `timelineview = "LATEST_VERSION_NUMBER"` in the `[versions]` section.
2. Add `timelineview = { group = "com.github.ferPrieto", name = "timelineview", version.ref = "timelineview" }` in the `[libraries]` section
3. Add `implementation(libs.timelineview)` in the app-level `build.gradle` file

### 2. Include Jitpack repository

You must include `jitpack.io` in your `settings.gradle` file because it's a public dependency

Kotlin:

```kotlin
dependencyResolutionManagement {
   ...
    repositories {
      ...
      maven("https://jitpack.io")
    }
}
```

Groovy:

```groovy
dependencyResolutionManagement {
   ...
    repositories {
      ...
      maven { url "https://jitpack.io" }
    }
}
```



## Features

- **Native Compose Implementation**: Pure Compose implementation without XML dependencies
- **Synchronized Scrolling**: Perfect offset synchronization between past and future content
- **Customizable Offset**: Configure the scroll offset as a fraction of screen width
- **Material 3 Support**: Built-in Material 3 styling variants
- **Modern Architecture**: Uses Compose's declarative UI paradigm
- **Flexible Content**: Support for any drawable resources as timeline content

## Usage

### Basic Implementation

```kotlin
@Composable
fun MyScreen() {
    TimelineView(
        height = 120.dp
    )
}
```

### With Custom Content

```kotlin
@Composable
fun MyScreen() {
    TimelineView(
        height = 120.dp,
        pastContent = R.drawable.my_past_content,
        futureContent = R.drawable.my_future_content
    )
}
```

### Advanced Configuration

```kotlin
@Composable
fun MyScreen() {
    TimelineView(
        height = 120.dp,
        pastContent = R.drawable.my_past_content,
        futureContent = R.drawable.my_future_content,
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
    TimelineViewSimple(
        height = 120.dp
    )
}
```

### Material 3 Styled

```kotlin
@Composable
fun MyScreen() {
    TimelineViewMaterial3(
        height = 120.dp
    )
}
```

## API Reference

### TimelineView

| Parameter | Type | Default | Description |
|-----------|------|---------|-------------|
| `modifier` | `Modifier` | `Modifier` | The modifier to be applied to the view |
| `height` | `Dp` | `200.dp` | Height of the timeline view |
| `pastContent` | `Int?` | `null` | Resource ID for the past content drawable |
| `futureContent` | `Int?` | `null` | Resource ID for the future content drawable |
| `offsetFraction` | `Float` | `1f/12f` | Scroll offset as fraction of screen width |
| `dividerWidth` | `Dp` | `2.dp` | Width of the center divider |
| `dividerColor` | `Color` | `Color.Transparent` | Color of the center divider |

### TimelineViewSimple

| Parameter | Type | Default | Description |
|-----------|------|---------|-------------|
| `modifier` | `Modifier` | `Modifier` | The modifier to be applied to the view |
| `height` | `Dp` | `120.dp` | Height of the timeline view |
| `pastContent` | `Int?` | `null` | Resource ID for the past content drawable |
| `futureContent` | `Int?` | `null` | Resource ID for the future content drawable |

## Use Cases

### Audio/Video Editing
Perfect for media editing applications where you need to show the played portion vs remaining content.

### Progress Visualization
Great for showing progress in long-running tasks, data processing, or multi-step workflows.

### Data Timeline
Ideal for data visualization where you need to show historical vs future data points.

### Reading Progress
Excellent for e-readers, articles, or documentation where you want to show reading progress.

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

## Default Content

The component includes default timeline content drawables:
- `soundwave_first_default_0` - Default past content (waveform visualization)
- `soundwave_second_default_0` - Default future content (waveform visualization)

## Contributing

When contributing to this component:

1. Follow Material 3 design principles
2. Ensure smooth performance on all screen sizes
3. Add appropriate tests for new features
4. Maintain the native Compose approach
5. Consider various use cases beyond audio waveforms

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
