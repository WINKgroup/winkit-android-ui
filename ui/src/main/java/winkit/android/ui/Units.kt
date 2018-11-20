package winkit.android.ui

import android.content.Context
import android.util.DisplayMetrics
import android.graphics.Point
import android.view.WindowManager   

/**
 * This object provide utilities functions to get screen sizes or dp and px conversions.
 */
object Units {

    /**
     * This method converts dp unit to equivalent pixels, depending on device density.
     *
     * @param context Context to get resources and device specific display metrics
     * @param dp A value in dp (density independent pixels) unit. Which we need to convert into pixels
     * @return An int value to represent px equivalent to dp depending on device density
     */
    fun dpToPx(context: Context, dp: Int): Int =
            dp * (context.resources.displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT)

    /**
     * This method converts device specific pixels to density independent pixels.
     *
     * @param context Context to get resources and device specific display metrics
     * @param px A value in px (pixels) unit. Which we need to convert into db
     * @return An int value to represent dp equivalent to px value
     */
    fun pxToDp(context: Context, px: Int): Int =
            px / (context.resources.displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT)

    /**
     * This method return the pixel screen sizes
     *
     * @param context Context to get the window Service
     * @return A point value to represent the pixel screen dimensions
     */
    fun pxScreenSizes (context: Context): Point {
        val display = (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay
        val size = Point()
        display.getSize(size)
        return size
    }

    /**
     * This method return the density independent screen sizes
     *
     * @param context Context to get the window Service
     * @return A point value to represent the pixel density independent dimensions
     */
    fun dpScreenSizes (context: Context): Point {
        val size = pxScreenSizes(context)
        return Point(pxToDp(context, size.x), pxToDp(context, size.y))
    }
}