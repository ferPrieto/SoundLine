package fprieto.soundline

import android.view.View
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import fprieto.soundline.view.ComposeMainActivity
import fprieto.soundline.SoundLineView

/**
 * UI Tests for SoundLineView component
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class SoundLineViewUITest {

    @get:Rule
    val activityRule = ActivityScenarioRule(ComposeMainActivity::class.java)

    @Test
    fun soundLineView_isDisplayed() {
        // Wait for activity to load
        Thread.sleep(1000)
        
        // Check if SoundLineView is present in the hierarchy
        activityRule.scenario.onActivity { activity ->
            val soundLineViews = findViewsOfType(activity.findViewById(android.R.id.content), SoundLineView::class.java)
            assert(soundLineViews.isNotEmpty()) { "SoundLineView should be displayed" }
        }
    }

    @Test
    fun soundLineView_hasCorrectInitialState() {
        activityRule.scenario.onActivity { activity ->
            val soundLineViews = findViewsOfType(activity.findViewById(android.R.id.content), SoundLineView::class.java)
            assert(soundLineViews.isNotEmpty()) { "SoundLineView should be found" }
            
            val soundLineView = soundLineViews.first()
            
            // Check if view is properly initialized
            assert(soundLineView.visibility == View.VISIBLE) { "SoundLineView should be visible" }
            assert(soundLineView.width > 0) { "SoundLineView should have width" }
            assert(soundLineView.height > 0) { "SoundLineView should have height" }
        }
    }

    @Test
    fun soundLineView_respondsToScrolling() {
        activityRule.scenario.onActivity { activity ->
            val soundLineViews = findViewsOfType(activity.findViewById(android.R.id.content), SoundLineView::class.java)
            assert(soundLineViews.isNotEmpty()) { "SoundLineView should be found" }
            
            val soundLineView = soundLineViews.first()
            
            // Test programmatic scroll positioning
            val initialPosition = soundLineView.getScrollPosition()
            
            // Set a new scroll position
            soundLineView.setScrollPosition(100)
            
            // Allow some time for the scroll to take effect
            Thread.sleep(100)
            
            val newPosition = soundLineView.getScrollPosition()
            
            // Verify scroll position changed
            assert(newPosition != initialPosition) { "Scroll position should change" }
        }
    }

    @Test
    fun soundLineView_multipleInstancesWork() {
        activityRule.scenario.onActivity { activity ->
            val soundLineViews = findViewsOfType(activity.findViewById(android.R.id.content), SoundLineView::class.java)
            
            // We expect to have multiple SoundLineViews in our Compose activity
            assert(soundLineViews.size >= 1) { "Should have at least one SoundLineView" }
            
            // Test each SoundLineView independently
            soundLineViews.forEach { soundLineView ->
                assert(soundLineView.visibility == View.VISIBLE) { "Each SoundLineView should be visible" }
                assert(soundLineView.width > 0) { "Each SoundLineView should have width" }
                assert(soundLineView.height > 0) { "Each SoundLineView should have height" }
            }
        }
    }

    @Test
    fun soundLineView_customDrawablesWork() {
        activityRule.scenario.onActivity { activity ->
            val context = InstrumentationRegistry.getInstrumentation().targetContext
            val soundLineViews = findViewsOfType(activity.findViewById(android.R.id.content), SoundLineView::class.java)
            assert(soundLineViews.isNotEmpty()) { "SoundLineView should be found" }
            
            val soundLineView = soundLineViews.first()
            
            // Test setting custom drawables
            val drawable1 = context.getDrawable(R.drawable.custom_first_default_0)
            val drawable2 = context.getDrawable(R.drawable.custom_second_default_0)
            
            // This should not crash
            soundLineView.setWaveDrawables(drawable1, drawable2)
            soundLineView.refreshWaveDrawables()
            
            // Allow time for refresh
            Thread.sleep(100)
            
            // The view should still be functional
            assert(soundLineView.visibility == View.VISIBLE) { "SoundLineView should remain visible after drawable change" }
        }
    }

    /**
     * Custom matcher to find views of a specific type in the view hierarchy
     */
    private fun <T : View> findViewsOfType(rootView: View, viewClass: Class<T>): List<T> {
        val views = mutableListOf<T>()
        
        fun searchViews(view: View) {
            if (viewClass.isInstance(view)) {
                @Suppress("UNCHECKED_CAST")
                views.add(view as T)
            }
            if (view is android.view.ViewGroup) {
                for (i in 0 until view.childCount) {
                    searchViews(view.getChildAt(i))
                }
            }
        }
        
        searchViews(rootView)
        return views
    }

    /**
     * Custom matcher for SoundLineView
     */
    private fun isSoundLineView(): Matcher<View> {
        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("is SoundLineView")
            }

            override fun matchesSafely(item: View): Boolean {
                return item is SoundLineView
            }
        }
    }
} 
