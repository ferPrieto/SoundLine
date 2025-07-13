package fprieto.soundline

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.github.fprieto.audiowaveformview.R

/**
 * Native Compose implementation of SoundLineView
 * Replaces the XML-based implementation with a fully Compose-native approach
 */
@Composable
fun ComposeSoundLineView(
    modifier: Modifier = Modifier,
    height: Dp = 120.dp,
    waveFirstSrc: Int = R.drawable.soundwave_first_default_0,
    waveSecondSrc: Int = R.drawable.soundwave_second_default_0
) {
    val configuration = LocalConfiguration.current
    val density = LocalDensity.current
    
    // Screen width in dp
    val screenWidthDp = configuration.screenWidthDp.dp
    val halfScreenWidthDp = screenWidthDp / 2
    val offsetDp = screenWidthDp / 12 // Same offset as the original implementation
    
    // Scroll states for both sides
    val leftScrollState = rememberScrollState()
    val rightScrollState = rememberScrollState()
    
    // Synchronization flags
    var isSynchronizing by remember { mutableStateOf(false) }
    
    // Synchronize scroll positions with offset
    LaunchedEffect(leftScrollState.value) {
        if (!isSynchronizing) {
            isSynchronizing = true
            try {
                val targetPosition = (leftScrollState.value - with(density) { offsetDp.roundToPx() }).coerceAtLeast(0)
                rightScrollState.scrollTo(targetPosition)
            } finally {
                isSynchronizing = false
            }
        }
    }
    
    LaunchedEffect(rightScrollState.value) {
        if (!isSynchronizing) {
            isSynchronizing = true
            try {
                val targetPosition = rightScrollState.value + with(density) { offsetDp.roundToPx() }
                leftScrollState.scrollTo(targetPosition)
            } finally {
                isSynchronizing = false
            }
        }
    }
    
    // Initialize scroll positions
    LaunchedEffect(Unit) {
        isSynchronizing = true
        try {
            leftScrollState.scrollTo(with(density) { offsetDp.roundToPx() })
            rightScrollState.scrollTo(0)
        } finally {
            isSynchronizing = false
        }
    }
    
    Box(
        modifier = modifier.height(height)
    ) {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            // Left scroll area
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .horizontalScroll(leftScrollState)
            ) {
                Image(
                    painter = painterResource(id = waveFirstSrc),
                    contentDescription = "Left waveform",
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(start = halfScreenWidthDp + 2.dp),
                    contentScale = ContentScale.FillHeight
                )
            }
            
            // Center divider
            Box(
                modifier = Modifier
                    .width(2.dp)
                    .fillMaxHeight()
                    .background(Color.Transparent)
            )
            
            // Right scroll area  
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .horizontalScroll(rightScrollState)
            ) {
                Image(
                    painter = painterResource(id = waveSecondSrc),
                    contentDescription = "Right waveform",
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(end = halfScreenWidthDp + 2.dp),
                    contentScale = ContentScale.FillHeight
                )
            }
        }
    }
}

/**
 * Extended Compose SoundLineView with additional configuration options
 */
@Composable
fun ComposeSoundLineViewAdvanced(
    modifier: Modifier = Modifier,
    height: Dp = 120.dp,
    waveFirstSrc: Int = R.drawable.soundwave_first_default_0,
    waveSecondSrc: Int = R.drawable.soundwave_second_default_0,
    offsetFraction: Float = 1f/12f, // Configurable offset as fraction of screen width
    dividerWidth: Dp = 2.dp,
    dividerColor: Color = Color.Transparent,
    paddingExtra: Dp = 2.dp
) {
    val configuration = LocalConfiguration.current
    val density = LocalDensity.current
    
    // Screen width calculations
    val screenWidthDp = configuration.screenWidthDp.dp
    val halfScreenWidthDp = screenWidthDp / 2
    val offsetDp = screenWidthDp * offsetFraction
    
    // Scroll states
    val leftScrollState = rememberScrollState()
    val rightScrollState = rememberScrollState()
    
    // Synchronization
    var isSynchronizing by remember { mutableStateOf(false) }
    
    // Synchronize scroll positions
    LaunchedEffect(leftScrollState.value) {
        if (!isSynchronizing) {
            isSynchronizing = true
            try {
                val targetPosition = (leftScrollState.value - with(density) { offsetDp.roundToPx() }).coerceAtLeast(0)
                rightScrollState.scrollTo(targetPosition)
            } finally {
                isSynchronizing = false
            }
        }
    }
    
    LaunchedEffect(rightScrollState.value) {
        if (!isSynchronizing) {
            isSynchronizing = true
            try {
                val targetPosition = rightScrollState.value + with(density) { offsetDp.roundToPx() }
                leftScrollState.scrollTo(targetPosition)
            } finally {
                isSynchronizing = false
            }
        }
    }
    
    // Initialize positions
    LaunchedEffect(Unit) {
        isSynchronizing = true
        try {
            leftScrollState.scrollTo(with(density) { offsetDp.roundToPx() })
            rightScrollState.scrollTo(0)
        } finally {
            isSynchronizing = false
        }
    }
    
    Box(
        modifier = modifier.height(height)
    ) {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            // Left scroll area
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .horizontalScroll(leftScrollState)
            ) {
                Image(
                    painter = painterResource(id = waveFirstSrc),
                    contentDescription = "Left waveform",
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(start = halfScreenWidthDp + paddingExtra),
                    contentScale = ContentScale.FillHeight
                )
            }
            
            // Center divider
            Box(
                modifier = Modifier
                    .width(dividerWidth)
                    .fillMaxHeight()
                    .background(dividerColor)
            )
            
            // Right scroll area
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .horizontalScroll(rightScrollState)
            ) {
                Image(
                    painter = painterResource(id = waveSecondSrc),
                    contentDescription = "Right waveform",
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(end = halfScreenWidthDp + paddingExtra),
                    contentScale = ContentScale.FillHeight
                )
            }
        }
    }
} 