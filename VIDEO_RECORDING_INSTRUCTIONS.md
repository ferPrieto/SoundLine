# Video Recording Instructions for AudioWaveformView Demo

## Overview
This document provides instructions for creating a video demonstration of the AudioWaveformView app showing horizontal scrolling functionality on both waveform views.

## What the Video Should Show

### 1. App Launch
- Open the AudioWaveformView Demo app (the ComposeMainActivity)
- Show the main screen with title "AudioWaveformView Demo" 
- Display both waveform cards: "Default Waveform" and "Custom Waveform"

### 2. Horizontal Scrolling Demonstration
- **Default Waveform**: Touch and drag horizontally to show scrolling
- **Custom Waveform**: Touch and drag horizontally to show scrolling
- Demonstrate smooth scrolling in both directions (left and right)
- Show that both scroll views stay synchronized

### 3. Key Features to Highlight
- **Smooth scrolling**: Demonstrate fluid touch interactions
- **Synchronized scrolling**: Show how the dual-view system works
- **Visual feedback**: Waveform animation during scroll
- **Multiple instances**: Both waveforms work independently yet similarly

## Recording Setup

### Device Requirements
- Android device with at least API 21 (Android 5.0)
- Screen recording capability (built-in Android screen recorder recommended)
- Good lighting for clear visibility

### Recommended Recording Settings
- **Resolution**: 1080p or higher
- **Frame rate**: 30 FPS minimum, 60 FPS preferred
- **Duration**: 30-60 seconds
- **Orientation**: Portrait (matches app design)

## Step-by-Step Recording Process

### 1. Preparation
```bash
# Install the latest version
./gradlew installDebug

# Verify app launches correctly
adb shell am start -n fprieto.soundline/.view.ComposeMainActivity
```

### 2. Recording Steps
1. **Start screen recording**
2. **Open the app** - Show app icon and launch
3. **Wait for loading** - Let the waveforms initialize (1-2 seconds)
4. **Demonstrate scrolling on first waveform**:
   - Touch and drag left slowly (2-3 seconds)
   - Touch and drag right slowly (2-3 seconds) 
   - Show a few quick scroll gestures
5. **Demonstrate scrolling on second waveform**:
   - Touch and drag left slowly (2-3 seconds)
   - Touch and drag right slowly (2-3 seconds)
   - Show a few quick scroll gestures
6. **Show both waveforms together**:
   - Try scrolling both in sequence to show they work independently
7. **End recording**

### 3. Post-Processing
- **Trim** video to remove any unnecessary content
- **Add titles** (optional): "AudioWaveformView - Jetpack Compose Demo"
- **Optimize file size** for web sharing
- **Convert to GIF** if needed for README display

## File Naming and Location

### Video File
- **Location**: `art/AudioWaveformView-Demo.mp4`
- **GIF Version**: `art/AudioWaveformView-Demo.gif`
- **Backup original**: `art/SoundLine.gif` (keep as reference)

### File Size Guidelines
- **MP4**: Target < 10MB for GitHub compatibility
- **GIF**: Target < 5MB for fast loading

## Recording Commands

### Using ADB for Screen Recording
```bash
# Start recording (max 180 seconds)
adb shell screenrecord /sdcard/audiowaveform-demo.mp4

# Pull the file after recording
adb pull /sdcard/audiowaveform-demo.mp4 art/AudioWaveformView-Demo.mp4

# Clean up device storage
adb shell rm /sdcard/audiowaveform-demo.mp4
```

### Convert MP4 to GIF (using FFmpeg)
```bash
# High quality GIF conversion
ffmpeg -i art/AudioWaveformView-Demo.mp4 \
  -vf "fps=15,scale=320:-1:flags=lanczos,palettegen" \
  art/palette.png

ffmpeg -i art/AudioWaveformView-Demo.mp4 -i art/palette.png \
  -filter_complex "fps=15,scale=320:-1:flags=lanczos[x];[x][1:v]paletteuse" \
  art/AudioWaveformView-Demo.gif

# Clean up temporary files
rm art/palette.png
```

## Quality Checklist

### Before Recording
- [ ] App builds and installs successfully
- [ ] Both waveforms display correctly
- [ ] Touch scrolling works smoothly
- [ ] Device has sufficient storage space
- [ ] Screen is clean and bright

### During Recording
- [ ] Stable hand/device positioning
- [ ] Clear demonstration of scrolling
- [ ] Show both waveforms
- [ ] Smooth, deliberate gestures
- [ ] No UI glitches or crashes

### After Recording
- [ ] Video plays smoothly
- [ ] Scrolling is clearly visible
- [ ] Audio sync (if included)
- [ ] Appropriate file size
- [ ] Ready for art directory

## Alternative Recording Methods

### 1. Android Studio Emulator
```bash
# Use emulator with hardware acceleration
emulator -avd YourAVD -gpu host

# Built-in screen recording in Android Studio
```

### 2. Third-party Apps
- **AZ Screen Recorder** (free, no watermark)
- **Mobizen Screen Recorder** (feature-rich)
- **DU Recorder** (simple interface)

### 3. Desktop Mirroring
- **scrcpy** for desktop mirroring and recording
- **Vysor** for wireless screen sharing

## Troubleshooting

### Common Issues
- **App crashes**: Check logs with `adb logcat`
- **Scrolling not smooth**: Ensure device has sufficient resources
- **Recording fails**: Check storage space and permissions
- **Large file size**: Adjust recording settings or compress post-recording

### Debug Commands
```bash
# Check app is running
adb shell dumpsys activity activities | grep AudioWaveform

# Monitor performance
adb shell top | grep fprieto.soundline

# Check for errors
adb logcat | grep "AudioWaveform\|SoundLine"
```

## Final Notes

- The video should showcase the **professional quality** of the AudioWaveformView library
- Demonstrate **both traditional and modern** UI approaches (the Compose implementation)
- Show **smooth performance** to highlight the optimized implementation
- Keep the video **concise but comprehensive** - users should understand the functionality quickly

Once recorded, replace the existing `art/SoundLine.gif` with the new demonstration video to keep the repository up to date with the latest Compose implementation. 
