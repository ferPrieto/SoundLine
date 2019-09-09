package prieto.fernando.soundline


interface ScrollViewListener {
    fun onScrollChanged(
        scrollView: ObservableScrollView,
        x: Int,
        y: Int,
        oldx: Int,
        oldy: Int,
        isFling: Boolean
    )

    fun onScrollTouched(isTouched: Boolean, isFling: Boolean)

    fun onScrollStopped(oldx: Int)

    fun onScrollReset()

    fun onScrollEnd()
}