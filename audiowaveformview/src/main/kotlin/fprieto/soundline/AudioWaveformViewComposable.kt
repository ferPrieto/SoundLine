package fprieto.soundline

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat

/**
 * Composable wrapper for the SoundLineView
 * 
 * @param modifier The modifier to be applied to the view
 * @param height The height of the waveform view
 * @param waveFirstSrc Resource ID for the first wave drawable (optional)
 * @param waveSecondSrc Resource ID for the second wave drawable (optional)
 * @param autoInit Whether to automatically initialize the waves when the view is created
 */
@Composable
fun AudioWaveformView(
    modifier: Modifier = Modifier,
    height: Dp = 200.dp,
    waveFirstSrc: Int? = null,
    waveSecondSrc: Int? = null,
    autoInit: Boolean = true
) {
    val context = LocalContext.current
    val density = LocalDensity.current
    
    // Convert height to pixels
    val heightPx = with(density) { height.roundToPx() }
    
    // Remember the SoundLineView to avoid recreating it
    val soundLineView = remember {
        SoundLineView(context).apply {
            layoutParams = android.view.ViewGroup.LayoutParams(
                android.view.ViewGroup.LayoutParams.MATCH_PARENT,
                heightPx
            )
        }
    }
    
    // Set custom drawables if provided
    LaunchedEffect(waveFirstSrc, waveSecondSrc) {
        waveFirstSrc?.let { firstSrc ->
            val firstDrawable = ContextCompat.getDrawable(context, firstSrc)
            soundLineView.setWaveDrawables(firstDrawable, null)
        }
        
        waveSecondSrc?.let { secondSrc ->
            val secondDrawable = ContextCompat.getDrawable(context, secondSrc)
            soundLineView.setWaveDrawables(null, secondDrawable)
        }
        
        if (waveFirstSrc != null || waveSecondSrc != null) {
            soundLineView.refreshWaveDrawables()
        }
    }
    
    // Auto-initialize waves if requested
    LaunchedEffect(autoInit) {
        if (autoInit) {
            soundLineView.post {
                soundLineView.initWaves()
            }
        }
    }
    
    AndroidView(
        factory = { soundLineView },
        modifier = modifier
            .fillMaxWidth()
            .height(height),
        update = { view ->
            // Update the view if needed
            if (autoInit) {
                view.post {
                    view.initWaves()
                }
            }
        }
    )
}

/**
 * Composable wrapper with Material 3 styling
 * 
 * @param modifier The modifier to be applied to the view
 * @param height The height of the waveform view
 * @param waveFirstSrc Resource ID for the first wave drawable (optional)
 * @param waveSecondSrc Resource ID for the second wave drawable (optional)
 * @param autoInit Whether to automatically initialize the waves when the view is created
 */
@Composable
fun AudioWaveformViewMaterial3(
    modifier: Modifier = Modifier,
    height: Dp = 200.dp,
    waveFirstSrc: Int? = null,
    waveSecondSrc: Int? = null,
    autoInit: Boolean = true
) {
    AudioWaveformView(
        modifier = modifier,
        height = height,
        waveFirstSrc = waveFirstSrc,
        waveSecondSrc = waveSecondSrc,
        autoInit = autoInit
    )
} 
