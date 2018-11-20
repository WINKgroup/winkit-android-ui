package winkit.android.ui

import android.view.View
import android.view.ViewTreeObserver


/**
 * Calculate the view sizes adding the a [ViewTreeObserver.OnGlobalLayoutListener] and removing it
 * after the first occurrence.
 *
 * @param callback A function that receive the view's width and height
 */
fun View.measure(callback: (width: Int, height: Int) -> Unit) {
    viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
        override fun onGlobalLayout() {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN)
                viewTreeObserver.removeOnGlobalLayoutListener(this)
            else
                viewTreeObserver.removeGlobalOnLayoutListener(this)
            callback(width, height)
        }
    })
}

/**
 * Call the [callback] if the view is already measured passing the view's sizes, otherwise call the [measure] method.
 *
 * @param callback A function that receive the view's width and height
 */
fun View.measureIfNeeded(callback: (width: Int, height: Int) -> Unit) {
    if (height > 0 || width > 0) {
        callback(width, height)
    } else measure(callback)
}