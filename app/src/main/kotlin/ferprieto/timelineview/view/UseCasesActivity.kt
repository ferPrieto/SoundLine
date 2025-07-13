package ferprieto.timelineview.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ferprieto.timelineview.TimelineView
import ferprieto.timelineview.R

class UseCasesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TimelineViewAppTheme {
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UseCasesScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Custom header with back button
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.primaryContainer,
            shadowElevation = 4.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { 
                        // Handle back navigation
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
                Text(
                    text = "TimelineView Use Cases",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
        
        // Use cases content
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(timelineUseCases) { useCase ->
                UseCaseCard(useCase = useCase)
            }
        }
    }
}

@Composable
fun UseCaseCard(useCase: TimelineUseCase) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // Title
            Text(
                text = useCase.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            
            // Description
            Text(
                text = useCase.description,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                modifier = Modifier.padding(bottom = 16.dp)
            )
            
            // TimelineView example
            TimelineView(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                height = 80.dp,
                pastContent = useCase.drawableRes,
                futureContent = useCase.invertedDrawableRes
            )
        }
    }
}

data class TimelineUseCase(
    val title: String,
    val description: String,
    val drawableRes: Int,
    val invertedDrawableRes: Int
)

val timelineUseCases = listOf(
    TimelineUseCase(
        title = "Audio Waveform Timeline",
        description = "Perfect for audio editing apps, podcasts, and music players. Shows the played portion vs remaining content.",
        drawableRes = com.github.ferprieto.timelineview.R.drawable.soundwave_first_default_0,
        invertedDrawableRes = com.github.ferprieto.timelineview.R.drawable.soundwave_second_default_0
    ),
    TimelineUseCase(
        title = "Video Timeline Editor",
        description = "Ideal for video editing interfaces where you need to show past and future frames in a timeline.",
        drawableRes = R.drawable.custom_first_default_0,
        invertedDrawableRes = R.drawable.custom_second_default_0
    ),
    TimelineUseCase(
        title = "Progress Visualization",
        description = "Great for showing progress in long-running tasks, data processing, or multi-step workflows.",
        drawableRes = com.github.ferprieto.timelineview.R.drawable.soundwave_first_default_1,
        invertedDrawableRes = com.github.ferprieto.timelineview.R.drawable.soundwave_second_default_1
    ),
    TimelineUseCase(
        title = "Data Timeline",
        description = "Perfect for data visualization where you need to show historical vs future data points.",
        drawableRes = R.drawable.custom_first_default_1,
        invertedDrawableRes = R.drawable.custom_second_default_1
    ),
    TimelineUseCase(
        title = "Reading Progress",
        description = "Excellent for e-readers, articles, or documentation where you want to show reading progress.",
        drawableRes = com.github.ferprieto.timelineview.R.drawable.soundwave_first_default_2,
        invertedDrawableRes = com.github.ferprieto.timelineview.R.drawable.soundwave_second_default_2
    )
)

// TimelineViewAppTheme is defined in MainActivity.kt 

