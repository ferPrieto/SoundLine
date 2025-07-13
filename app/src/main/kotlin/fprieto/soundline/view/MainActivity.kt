package fprieto.soundline.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fprieto.soundline.AudioWaveformView
import fprieto.soundline.R

class ComposeMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AudioWaveformAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AudioWaveformScreen()
                }
            }
        }
    }
}

@Composable
fun AudioWaveformScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Title
        Text(
            text = "AudioWaveformView Demo",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        
        // Instruction text
        Text(
            text = stringResource(R.string.swipe_left_right),
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
            modifier = Modifier.padding(bottom = 32.dp)
        )
        
        // AudioWaveformView with default drawables
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Default Waveform",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                
                AudioWaveformView(
                    modifier = Modifier.fillMaxWidth(),
                    height = 120.dp,
                    autoInit = true
                )
            }
        }
        
        // AudioWaveformView with custom drawables
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Custom Waveform",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                
                AudioWaveformView(
                    modifier = Modifier.fillMaxWidth(),
                    height = 120.dp,
                    waveFirstSrc = R.drawable.custom_first_default_0,
                    waveSecondSrc = R.drawable.custom_second_default_0,
                    autoInit = true
                )
            }
        }
    }
}

@Composable
fun AudioWaveformAppTheme(content: @Composable () -> Unit) {
    val colorScheme = lightColorScheme(
        primary = Color(0xFF6200EE),
        secondary = Color(0xFF03DAC6),
        background = Color(0xFFF5F5F5),
        surface = Color.White,
        onPrimary = Color.White,
        onSecondary = Color.Black,
        onBackground = Color.Black,
        onSurface = Color.Black
    )
    
    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}

@Preview(showBackground = true)
@Composable
fun AudioWaveformScreenPreview() {
    AudioWaveformAppTheme {
        AudioWaveformScreen()
    }
} 
