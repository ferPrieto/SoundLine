package prieto.fernando.soundline

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Point
import android.util.AttributeSet
import android.view.View
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.github.fprieto.audiowaveformview.R

class SoundLineView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private var isFling = false
    private var isScrollViewTouched = false
    private var screenWidth: Int = 0

    private lateinit var scrollViewLeft: ObservableScrollView
    private lateinit var scrollViewRight: ObservableScrollView
    private lateinit var waveViewLeft: ImageView
    private lateinit var waveViewRight: ImageView

    private val scrollViewListener = object : ScrollViewListener {
        override fun onScrollChanged(
            scrollView: ObservableScrollView,
            x: Int,
            y: Int,
            oldX: Int,
            oldY: Int,
            isFling: Boolean
        ) {
            this@SoundLineView.isFling = isFling
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

        override fun onScrollStopped(oldX: Int) {}

        override fun onScrollReset() {}

        override fun onScrollEnd() {}
    }

    init {
        View.inflate(context, R.layout.soundline_view, this)

        scrollViewLeft = findViewById(R.id.scroll_left)
        scrollViewRight = findViewById(R.id.scroll_right)
        waveViewLeft = findViewById(R.id.wave_left)
        waveViewRight = findViewById(R.id.wave_right)
        
        screenWidth = getScreenWidth()
        setWavePadding()
        setScrollViewListeners()
        attrs?.let(::setAttributeSetOrDefault) ?: run { setDefaultDrawables() }
    }

    private fun setAttributeSetOrDefault(attributeSet: AttributeSet) {
        val ta = context.obtainStyledAttributes(attributeSet, R.styleable.SoundLineView)
        setCustomDrawables(ta)
        ta.recycle()
    }

    private fun setDefaultDrawables() {
        val waveFirstDrawable =
            ContextCompat.getDrawable(context, R.drawable.soundwave_first_default_0)
        val waveSecondDrawable =
            ContextCompat.getDrawable(context, R.drawable.soundwave_second_default_0)
        waveViewLeft.setImageDrawable(waveFirstDrawable)
        waveViewRight.setImageDrawable(waveSecondDrawable)
    }

    private fun setCustomDrawables(ta: TypedArray) {
        val waveFirstDrawable =
            ta.getDrawable(R.styleable.SoundLineView_wave_first_src) ?: ContextCompat.getDrawable(
                context,
                R.drawable.soundwave_first_default_0
            )
        val waveSecondDrawable =
            ta.getDrawable(R.styleable.SoundLineView_wave_second_src) ?: ContextCompat.getDrawable(
                context,
                R.drawable.soundwave_second_default_0
            )

        waveViewLeft.setImageDrawable(waveFirstDrawable)
        waveViewRight.setImageDrawable(waveSecondDrawable)
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
