package fprieto.soundline

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.github.fprieto.audiowaveformview.R

/**
 * Modern Compose-native AudioWaveformView
 * Uses the new ComposeSoundLineView implementation without XML dependencies
 * 
 * @param modifier The modifier to be applied to the view
 * @param height The height of the waveform view
 * @param waveFirstSrc Resource ID for the first wave drawable (optional)
 * @param waveSecondSrc Resource ID for the second wave drawable (optional)
 * @param offsetFraction Scroll offset as fraction of screen width (default: 1/12)
 * @param dividerWidth Width of the center divider
 * @param dividerColor Color of the center divider
 */
@Composable
fun AudioWaveformView(
    modifier: Modifier = Modifier,
    height: Dp = 200.dp,
    waveFirstSrc: Int? = null,
    waveSecondSrc: Int? = null,
    offsetFraction: Float = 1f/12f,
    dividerWidth: Dp = 2.dp,
    dividerColor: Color = Color.Transparent
) {
    ComposeSoundLineViewAdvanced(
        modifier = modifier.fillMaxWidth(),
        height = height,
        waveFirstSrc = waveFirstSrc ?: R.drawable.soundwave_first_default_0,
        waveSecondSrc = waveSecondSrc ?: R.drawable.soundwave_second_default_0,
        offsetFraction = offsetFraction,
        dividerWidth = dividerWidth,
        dividerColor = dividerColor
    )
}

/**
 * Simplified AudioWaveformView with basic configuration
 * Perfect for most use cases
 */
@Composable
fun AudioWaveformViewSimple(
    modifier: Modifier = Modifier,
    height: Dp = 120.dp,
    waveFirstSrc: Int? = null,
    waveSecondSrc: Int? = null
) {
    ComposeSoundLineView(
        modifier = modifier.fillMaxWidth(),
        height = height,
        waveFirstSrc = waveFirstSrc ?: R.drawable.soundwave_first_default_0,
        waveSecondSrc = waveSecondSrc ?: R.drawable.soundwave_second_default_0
    )
}

/**
 * Material 3 styled AudioWaveformView
 * Uses the modern Compose implementation with Material 3 design principles
 * 
 * @param modifier The modifier to be applied to the view
 * @param height The height of the waveform view
 * @param waveFirstSrc Resource ID for the first wave drawable (optional)
 * @param waveSecondSrc Resource ID for the second wave drawable (optional)
 * @param offsetFraction Scroll offset as fraction of screen width
 */
@Composable
fun AudioWaveformViewMaterial3(
    modifier: Modifier = Modifier,
    height: Dp = 200.dp,
    waveFirstSrc: Int? = null,
    waveSecondSrc: Int? = null,
    offsetFraction: Float = 1f/12f
) {
    AudioWaveformView(
        modifier = modifier,
        height = height,
        waveFirstSrc = waveFirstSrc,
        waveSecondSrc = waveSecondSrc,
        offsetFraction = offsetFraction,
        dividerWidth = 1.dp,
        dividerColor = Color.Transparent
    )
} 
