package ferprieto.timelineview

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.github.ferprieto.timelineview.R

/**
 * Modern Compose-native TimelineView
 * Uses the new ComposeTimelineView implementation without XML dependencies
 * 
 * @param modifier The modifier to be applied to the view
 * @param height The height of the timeline view
 * @param pastContent Resource ID for the past content drawable (optional)
 * @param futureContent Resource ID for the future content drawable (optional)
 * @param offsetFraction Scroll offset as fraction of screen width (default: 1/12)
 * @param dividerWidth Width of the center divider
 * @param dividerColor Color of the center divider
 */
@Composable
fun TimelineView(
    modifier: Modifier = Modifier,
    height: Dp = 200.dp,
    pastContent: Int? = null,
    futureContent: Int? = null,
    offsetFraction: Float = 1f/12f,
    dividerWidth: Dp = 2.dp,
    dividerColor: Color = Color.Transparent
) {
    ComposeTimelineViewAdvanced(
        modifier = modifier.fillMaxWidth(),
        height = height,
        pastContent = pastContent ?: R.drawable.soundwave_first_default_0,
        futureContent = futureContent ?: R.drawable.soundwave_second_default_0,
        offsetFraction = offsetFraction,
        dividerWidth = dividerWidth,
        dividerColor = dividerColor
    )
}

/**
 * Simplified TimelineView with basic configuration
 * Perfect for most use cases
 */
@Composable
fun TimelineViewSimple(
    modifier: Modifier = Modifier,
    height: Dp = 120.dp,
    pastContent: Int? = null,
    futureContent: Int? = null
) {
    ComposeTimelineView(
        modifier = modifier.fillMaxWidth(),
        height = height,
        pastContent = pastContent ?: R.drawable.soundwave_first_default_0,
        futureContent = futureContent ?: R.drawable.soundwave_second_default_0
    )
}

/**
 * Material 3 styled TimelineView
 * Uses the modern Compose implementation with Material 3 design principles
 * 
 * @param modifier The modifier to be applied to the view
 * @param height The height of the timeline view
 * @param pastContent Resource ID for the past content drawable (optional)
 * @param futureContent Resource ID for the future content drawable (optional)
 * @param offsetFraction Scroll offset as fraction of screen width
 */
@Composable
fun TimelineViewMaterial3(
    modifier: Modifier = Modifier,
    height: Dp = 200.dp,
    pastContent: Int? = null,
    futureContent: Int? = null,
    offsetFraction: Float = 1f/12f
) {
    TimelineView(
        modifier = modifier,
        height = height,
        pastContent = pastContent,
        futureContent = futureContent,
        offsetFraction = offsetFraction,
        dividerWidth = 1.dp,
        dividerColor = Color.Transparent
    )
} 
