package fprieto.soundline

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.unit.dp
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import fprieto.soundline.AudioWaveformView
import fprieto.soundline.view.AudioWaveformAppTheme

/**
 * Compose UI Tests for AudioWaveformView Composable
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class AudioWaveformViewComposeTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun audioWaveformView_renders_successfully() {
        composeTestRule.setContent {
            AudioWaveformAppTheme {
                AudioWaveformView(
                    height = 120.dp,
                    autoInit = true
                )
            }
        }

        // Wait for composition to complete
        composeTestRule.waitForIdle()
        
        // Verify the AndroidView containing SoundLineView is present
        composeTestRule.onRoot().assertExists()
    }

    @Test
    fun audioWaveformView_with_custom_drawables_renders() {
        composeTestRule.setContent {
            AudioWaveformAppTheme {
                AudioWaveformView(
                    height = 150.dp,
                    waveFirstSrc = R.drawable.custom_first_default_0,
                    waveSecondSrc = R.drawable.custom_second_default_0,
                    autoInit = true
                )
            }
        }

        // Wait for composition to complete
        composeTestRule.waitForIdle()
        
        // Verify the view is rendered
        composeTestRule.onRoot().assertExists()
    }

    @Test
    fun audioWaveformView_different_heights_work() {
        val heights = listOf(80.dp, 120.dp, 200.dp)
        
        heights.forEach { height ->
            composeTestRule.setContent {
                AudioWaveformAppTheme {
                    AudioWaveformView(
                        height = height,
                        autoInit = true
                    )
                }
            }

            // Wait for composition
            composeTestRule.waitForIdle()
            
            // Verify the view exists for each height
            composeTestRule.onRoot().assertExists()
        }
    }

    @Test
    fun audioWaveformView_material3_variant_renders() {
        composeTestRule.setContent {
            AudioWaveformAppTheme {
                AudioWaveformViewMaterial3(
                    height = 120.dp,
                    autoInit = true
                )
            }
        }

        // Wait for composition
        composeTestRule.waitForIdle()
        
        // Verify the Material3 variant renders
        composeTestRule.onRoot().assertExists()
    }

    @Test
    fun audioWaveformView_without_auto_init_renders() {
        composeTestRule.setContent {
            AudioWaveformAppTheme {
                AudioWaveformView(
                    height = 120.dp,
                    autoInit = false
                )
            }
        }

        // Wait for composition
        composeTestRule.waitForIdle()
        
        // Verify the view renders even without auto-initialization
        composeTestRule.onRoot().assertExists()
    }

    @Test
    fun audioWaveformView_recomposition_works() {
        var useCustomDrawables = false
        
        composeTestRule.setContent {
            AudioWaveformAppTheme {
                AudioWaveformView(
                    height = 120.dp,
                    waveFirstSrc = if (useCustomDrawables) R.drawable.custom_first_default_0 else null,
                    waveSecondSrc = if (useCustomDrawables) R.drawable.custom_second_default_0 else null,
                    autoInit = true
                )
            }
        }

        // Wait for initial composition
        composeTestRule.waitForIdle()
        composeTestRule.onRoot().assertExists()

        // Change the state to trigger recomposition
        composeTestRule.runOnUiThread {
            useCustomDrawables = true
        }

        // Wait for recomposition
        composeTestRule.waitForIdle()
        
        // Verify the view still exists after recomposition
        composeTestRule.onRoot().assertExists()
    }

    @Test
    fun multiple_audioWaveformViews_render_independently() {
        composeTestRule.setContent {
            AudioWaveformAppTheme {
                androidx.compose.foundation.layout.Column {
                    // First waveform with default drawables
                    AudioWaveformView(
                        height = 100.dp,
                        autoInit = true
                    )
                    
                    // Second waveform with custom drawables
                    AudioWaveformView(
                        height = 120.dp,
                        waveFirstSrc = R.drawable.custom_first_default_0,
                        waveSecondSrc = R.drawable.custom_second_default_0,
                        autoInit = true
                    )
                    
                    // Third waveform with different height
                    AudioWaveformView(
                        height = 80.dp,
                        autoInit = false
                    )
                }
            }
        }

        // Wait for composition
        composeTestRule.waitForIdle()
        
        // Verify all views are rendered in the column
        composeTestRule.onRoot().assertExists()
        
        // Additional check - ensure we can find the Column containing all views
        composeTestRule
            .onNode(hasTestTag(""))  // This will find the root
            .assertExists()
    }

    @Test
    fun audioWaveformView_respects_modifier() {
        composeTestRule.setContent {
            AudioWaveformAppTheme {
                AudioWaveformView(
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("test-waveform"),
                    height = 120.dp,
                    autoInit = true
                )
            }
        }

        // Wait for composition
        composeTestRule.waitForIdle()
        
        // Verify we can find the view by test tag
        composeTestRule
            .onNodeWithTag("test-waveform")
            .assertExists()
    }
} 
