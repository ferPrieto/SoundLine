# TimelineView

A synchronized dual-view timeline visualization component for Android with native Compose support.

## Overview

TimelineView provides a synchronized scrolling experience with two content views that move in complementary directions. Originally designed for audio waveform visualization, it's now a versatile component perfect for any timeline-based application.

## Features

- **Native Compose Implementation**: Pure Compose implementation without XML dependencies
- **Synchronized Scrolling**: Perfect offset synchronization between past and future content
- **Customizable Offset**: Configure the scroll offset as a fraction of screen width
- **Material 3 Support**: Built-in Material 3 styling variants
- **Flexible Content**: Support for any drawable resources as timeline content
- **Modern Architecture**: Uses Compose's declarative UI paradigm

## Use Cases

- **Audio/Video Editing**: Show played vs remaining content
- **Progress Visualization**: Display progress in long-running tasks
- **Data Timeline**: Visualize historical vs future data points  
- **Reading Progress**: Track reading progress in documents
- **Media Players**: Timeline scrubbing for audio/video
- **Data Processing**: Show processed vs pending data

## Quick Start

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

## Demo

![TimelineView Demo](art/SoundLine.gif)

## Structure

- **`audiowaveformview/`**: Core TimelineView library module
- **`app/`**: Demo application showcasing various use cases

## Documentation

For detailed API documentation, see [audiowaveformview/README.md](audiowaveformview/README.md)

## License

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


