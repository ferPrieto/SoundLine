package prieto.fernando.soundline

import android.content.Context
import android.graphics.Point
import android.util.AttributeSet
import android.view.View
import android.view.WindowManager
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.soundline_view.view.wave_left as waveViewLeft
import kotlinx.android.synthetic.main.soundline_view.view.wave_right as waveViewRight


class SoundLineView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private var isFling = false
    private var isScrollViewTouched = false
    private var screenWidth: Int = 0

    private lateinit var scrollViewLeft: ObservableScrollView
    private lateinit var scrollViewRight: ObservableScrollView

    private val scrollViewListener = object : ScrollViewListener {
        override fun onScrollChanged(
            scrollView: ObservableScrollView,
            x: Int,
            y: Int,
            oldx: Int,
            oldy: Int,
            fling: Boolean
        ) {
            isFling = fling
            if (scrollView === scrollViewLeft) {
                scrollViewRight.scrollTo(x, y)
            } else if (scrollView === scrollViewRight) {
                scrollViewLeft.scrollTo(x, y)
            }
        }

        override fun onScrollTouched(isTouched: Boolean, fling: Boolean) {
            isFling = fling
            isScrollViewTouched = isTouched
        }

        override fun onScrollStopped(oldX: Int) {
            //resume player on oldX position
        }

        override fun onScrollReset() {}

        override fun onScrollEnd() {
            // set your player to End
        }
    }

    init {
        View.inflate(context, R.layout.soundline_view, this)
        scrollViewLeft = findViewById(R.id.scroll_left)
        scrollViewRight = findViewById(R.id.scroll_right)
        screenWidth = getScreenWidth()
        setWavePadding()
        setScrollViewListeners()
    }

    private fun setWavePadding() {
        waveViewLeft.setPadding(screenWidth / 2 + 2, 0, 0, 0)
        waveViewRight.setPadding(0, 0, screenWidth / 2 + 2, 0)
    }

    fun initWaves() {
        scrollViewLeft.setWaveWidth(waveViewLeft.width - screenWidth / 2)
        scrollViewRight.setWaveWidth(waveViewRight.width - screenWidth / 2)
        scrollViewRight.smoothScrollTo(0, 0)
    }

    private fun getScreenWidth(): Int {
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        val screenSize = Point()
        display.getRealSize(screenSize)

        return screenSize.x
    }

    private fun setScrollViewListeners() {
        scrollViewLeft.setScrollViewListener(scrollViewListener)
        scrollViewRight.setScrollViewListener(scrollViewListener)
    }
}