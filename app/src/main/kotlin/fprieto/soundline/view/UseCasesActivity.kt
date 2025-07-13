package fprieto.soundline.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fprieto.soundline.AudioWaveformView
import fprieto.soundline.R

class UseCasesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AudioWaveformAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UseCasesScreen()
                }
            }
        }
    }
}

data class UseCase(
    val title: String,
    val description: String,
    val icon: String,
    val drawableRes: Int,
    val invertedDrawableRes: Int,
    val features: List<String>
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UseCasesScreen() {
    val context = LocalContext.current
    val useCases = remember {
        listOf(
            UseCase(
                title = "🔊 Podcast Chapters",
                description = "Segmented waveforms with timestamped chapter markers",
                icon = "🔊",
                drawableRes = R.drawable.waveform_podcast_chapters,
                invertedDrawableRes = R.drawable.waveform_podcast_chapters_inverted,
                features = listOf("Chapter markers", "Segment navigation", "Time labels")
            ),
            UseCase(
                title = "🎙️ Voice Messages",
                description = "Compact waveform for messaging apps with pause/loud highlights",
                icon = "🎙️",
                drawableRes = R.drawable.waveform_voice_message,
                invertedDrawableRes = R.drawable.waveform_voice_message_inverted,
                features = listOf("Compact design", "Pause detection", "Loud section highlights")
            ),
            UseCase(
                title = "🎶 Music Creation",
                description = "Layered waveforms for DJ beat matching and music production",
                icon = "🎶",
                drawableRes = R.drawable.waveform_music_creation,
                invertedDrawableRes = R.drawable.waveform_music_creation_inverted,
                features = listOf("Dual tracks", "Beat alignment", "BPM visualization")
            ),
            UseCase(
                title = "🎞️ Video Timeline",
                description = "Audio waveform underneath video timeline for editing",
                icon = "🎞️",
                drawableRes = R.drawable.waveform_video_timeline,
                invertedDrawableRes = R.drawable.waveform_video_timeline_inverted,
                features = listOf("Video thumbnails", "Audio sync", "Transition effects")
            ),
            UseCase(
                title = "📖 Audiobooks",
                description = "Synchronized audio playback with text highlighting",
                icon = "📖",
                drawableRes = R.drawable.waveform_audiobooks,
                invertedDrawableRes = R.drawable.waveform_audiobooks_inverted,
                features = listOf("Text sync", "Chapter markers", "Bookmark support")
            ),
            UseCase(
                title = "🧘 Meditation",
                description = "Calming waveforms with energy-based color shifting",
                icon = "🧘",
                drawableRes = R.drawable.waveform_meditation,
                invertedDrawableRes = R.drawable.waveform_meditation_inverted,
                features = listOf("Soft edges", "Energy visualization", "Loop selection")
            ),
            UseCase(
                title = "📈 Data Sonification",
                description = "Scientific data visualization mapped to audio waveforms",
                icon = "📈",
                drawableRes = R.drawable.waveform_data_sonification,
                invertedDrawableRes = R.drawable.waveform_data_sonification_inverted,
                features = listOf("Grid overlay", "Trend analysis", "Anomaly detection")
            ),
            UseCase(
                title = "💬 Interactive Stories",
                description = "Audio dramas with character-based waveform colors",
                icon = "💬",
                drawableRes = R.drawable.waveform_interactive_storytelling,
                invertedDrawableRes = R.drawable.waveform_interactive_storytelling_inverted,
                features = listOf("Character colors", "Story branching", "Choice points")
            ),
            UseCase(
                title = "🎮 Game Soundtrack",
                description = "Game audio browser with event-specific waveforms",
                icon = "🎮",
                drawableRes = R.drawable.waveform_game_soundtrack,
                invertedDrawableRes = R.drawable.waveform_game_soundtrack_inverted,
                features = listOf("Event categories", "Volume balancing", "Sound preview")
            )
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { 
                    Text(
                        text = "Use Cases",
                        fontWeight = FontWeight.Bold
                    ) 
                },
                navigationIcon = {
                    IconButton(
                        onClick = { 
                            (context as? ComponentActivity)?.finish()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    text = "AudioWaveformView Use Cases",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Explore different waveform visualizations for various applications",
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }

            items(useCases) { useCase ->
                UseCaseCard(useCase = useCase)
            }
        }
    }
}

@Composable
fun UseCaseCard(useCase: UseCase) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Title and description
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = useCase.title,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = useCase.description,
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }

            // Waveform visualization
            AudioWaveformView(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                height = 80.dp,
                waveFirstSrc = useCase.drawableRes,
                waveSecondSrc = useCase.invertedDrawableRes,
                autoInit = true
            )

            // Features
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Key Features:",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                useCase.features.forEach { feature ->
                    Text(
                        text = "• $feature",
                        fontSize = 13.sp,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
    }
} 

