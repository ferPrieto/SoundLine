package prieto.fernando.soundline

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.HorizontalScrollView
import kotlin.math.abs


class ObservableScrollView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : HorizontalScrollView(context, attrs, defStyleAttr), View.OnTouchListener {
    private lateinit var internalScrollViewListener: ScrollViewListener
    private var isFling = false
    private var waveWidth: Int = 0

    init {
        setOnTouchListener(this)
    }

    fun setScrollViewListener(scrollViewListener: ScrollViewListener) {
        internalScrollViewListener = scrollViewListener
    }

    fun setWaveWidth(waveWidth: Int) {
        this.waveWidth = waveWidth
    }

    override fun onScrollChanged(x: Int, y: Int, oldX: Int, oldY: Int) {
        internalScrollViewListener?.let { scrollViewListener ->
            if (isFling) {
                when {
                    abs(x - oldX) < 2 -> onScrollStopped(x)
                    x >= waveWidth -> onScrollEnd()
                    x < 2 -> onScrollEnd()
                    abs(x - oldX) < 2 -> onScrollReset()
                }
            }

        }
        super.onScrollChanged(x, y, oldX, oldY)
        if (internalScrollViewListener != null) {
            internalScrollViewListener.onScrollChanged(this, x, y, oldX, oldY, isFling)
        }
    }

    private fun onScrollStopped(x: Int) {
        internalScrollViewListener.onScrollStopped(x)
        isFling = false
    }

    private fun onScrollEnd() {
        internalScrollViewListener.onScrollEnd()
        isFling = false
    }

    private fun onScrollReset() {
        internalScrollViewListener.onScrollReset()
        isFling = false
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        event?.let { motionEvent ->
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN -> internalScrollViewListener.onScrollTouched(true, isFling)
                MotionEvent.ACTION_UP,
                MotionEvent.ACTION_CANCEL -> internalScrollViewListener.onScrollTouched(false, isFling)
            }
        }
        return false
    }

    override fun fling(velocityX: Int) {
        super.fling(velocityX)
        isFling = true
    }
}