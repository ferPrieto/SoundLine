# AudioWaveformView Use Cases

Based on the SoundLine demo, here are 9 different waveform visualizations designed for specific use cases. Each use case has its own vector drawable resource that demonstrates the visual design and interaction patterns.

## 🔊 1. Podcast Chapters

**File:** `waveform_podcast_chapters.xml`

**Use Case:** Show podcast episodes with visual chapter markers and timestamps.

**Features:**
- Chapter markers with vertical lines
- Segment navigation support
- Time labels for easy navigation
- Horizontal scrolling between chapters

**Colors:**
- Background: Orange (#FF6B35) 
- Waveform: White (#FFFFFF)
- Chapter markers: Gold (#FFD700)
- Labels: Dark gray (#333333)

---

## 🎙️ 2. Voice Messages

**File:** `waveform_voice_message.xml`

**Use Case:** Compact waveform for messaging apps (WhatsApp, Telegram style).

**Features:**
- Compact design for message bubbles
- Pause detection with lighter colors
- Loud section highlights with darker colors
- Progress indicator for current playback position

**Colors:**
- Background: Light green (#E8F5E8)
- Normal waveform: WhatsApp green (#25D366)
- Pause sections: Light green (#A8E6CF)
- Loud sections: Dark green (#1BA146)
- Progress: Red (#FF4444)

---

## 🎶 3. Music Creation / DJ Beat Matching

**File:** `waveform_music_creation.xml`

**Use Case:** Show two audio tracks for DJ mixing and beat matching.

**Features:**
- Dual track display (upper and lower)
- Beat alignment markers
- BPM visualization
- Sync indicators between tracks

**Colors:**
- Background: Dark gray (#1A1A1A)
- Track 1: Orange (#FF6B35)
- Track 2: Cyan (#00BCD4)
- Beat markers: Yellow (#FFFF00)
- Sync indicators: Green (#00FF00)

---

## 🎞️ 4. Video Timeline

**File:** `waveform_video_timeline.xml`

**Use Case:** Audio waveform underneath video timeline for editing.

**Features:**
- Video thumbnails above waveform
- Audio sync visualization
- Transition effects between clips
- Playhead indicator

**Colors:**
- Background: Black (#000000)
- Thumbnails: Various colors for different clips
- Waveform: White (#FFFFFF)
- Playhead: Red (#FF0000)
- Transitions: Cyan (#00FFFF)

---

## 📖 5. Audiobooks

**File:** `waveform_audiobooks.xml`

**Use Case:** Sync audio playback with text highlighting.

**Features:**
- Text synchronization highlights
- Chapter markers
- Bookmark indicators
- Word boundary visualization

**Colors:**
- Background: Cream (#FFF8E1)
- Normal waveform: Brown (#5D4037)
- Text sync: Orange (#FFB74D)
- Bookmarks: Pink (#FF4081)
- Progress: Orange (#FF6F00)

---

## 🧘 6. Meditation / Sleep Sounds

**File:** `waveform_meditation.xml`

**Use Case:** Calming waveforms with energy-based color shifting.

**Features:**
- Soft, rounded edges
- Energy-based color intensity
- Loop selection areas
- Breathing guide markers

**Colors:**
- Background: Light green (#E8F5E8)
- Low energy: Light green (#81C784)
- Medium energy: Green (#4CAF50)
- High energy: Dark green (#2E7D32)
- Breathing guides: Light green (#C8E6C9)

---

## 📈 7. Data Sonification

**File:** `waveform_data_sonification.xml`

**Use Case:** Scientific data visualization mapped to audio.

**Features:**
- Grid overlay for precision
- Trend analysis visualization
- Anomaly detection highlights
- Data labels and value indicators

**Colors:**
- Background: Light gray (#F5F5F5)
- Grid: Light gray (#E0E0E0)
- Data trend: Blue (#1976D2)
- Peaks: Red (#FF5722)
- Anomalies: Orange (#FF9800)

---

## 💬 8. Interactive Storytelling

**File:** `waveform_interactive_storytelling.xml`

**Use Case:** Audio dramas with character-based waveform colors.

**Features:**
- Character-specific colors
- Story branching visualization
- Choice points with arrows
- Multiple narrative paths

**Colors:**
- Background: Dark gray (#2C2C2C)
- Narrator: Gold (#FFD700)
- Hero: Green (#4CAF50)
- Villain: Red (#F44336)
- Choice branches: Purple (#9C27B0), Blue (#2196F3), Orange (#FF5722)

---

## 🎮 9. Game Soundtrack Browser

**File:** `waveform_game_soundtrack.xml`

**Use Case:** Browse game audio events with category-specific waveforms.

**Features:**
- Event categories (gunshots, footsteps, ambient, etc.)
- Volume balancing indicators
- Sound preview functionality
- Category-specific waveform patterns

**Colors:**
- Background: Dark blue (#0D1117)
- Gunshots: Red (#FF4444)
- Footsteps: Green (#00FF88)
- Ambient: Blue (#44AAFF)
- Explosions: Orange (#FF8800)
- Power-ups: Magenta (#FF44FF)

---

## Usage in Code

### Using in Compose
```kotlin
AudioWaveformView(
    modifier = Modifier.fillMaxWidth(),
    height = 80.dp,
    waveFirstSrc = R.drawable.waveform_podcast_chapters,
    waveSecondSrc = R.drawable.waveform_podcast_chapters,
    autoInit = true
)
```

### Using in Traditional Android Views
```kotlin
val soundLineView = SoundLineView(context)
soundLineView.setWaveDrawables(
    firstDrawableRes = R.drawable.waveform_voice_message,
    secondDrawableRes = R.drawable.waveform_voice_message
)
```

---

## Demo Application

The project includes a comprehensive demo in `UseCasesActivity.kt` that showcases all 9 use cases. You can access it through the "View Use Cases" button in the main activity.

Each use case card displays:
- Title and description
- Live waveform visualization
- Key features list
- Interactive demo capabilities

This provides developers with a complete reference for implementing different waveform visualizations based on their specific use case requirements. 