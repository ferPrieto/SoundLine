package fprieto.soundline


interface ScrollViewListener {
    fun onScrollChanged(
        scrollView: ObservableScrollView,
        x: Int,
        y: Int,
        oldX: Int,
        oldY: Int,
        isFling: Boolean
    )

    fun onScrollTouched(isTouched: Boolean, isFling: Boolean)

    fun onScrollStopped(oldX: Int)

    fun onScrollReset()

    fun onScrollEnd()
}
