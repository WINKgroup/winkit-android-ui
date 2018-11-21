package winkit.android.ui

import android.content.Context
import android.text.SpannableStringBuilder
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.URLSpan
import android.util.AttributeSet
import android.view.View
import android.widget.TextView

/**
 *
 * A Utility View With the ability to show the links that
 * are provided in the String
 *
 * @param context
 * @param attrs
 *
 * @constructor gets the required parameters and initializes a new @LinkTextView
 *
 */

class LinkTextView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : TextView(context, attrs, defStyleAttr) {

    /**
     *
     * @property onLinkClick clickListener Provided to link
     * @property linkUnderline : Boolean decides weather to draw a line under the link or not
     * @property linkColor : Int @colorResourceInt
     *
     */

    var onLinkClick: ((url: String) -> Unit)? = null
    var linkUnderline = true
    var linkColor = 0

    init {
        val ta = getContext().obtainStyledAttributes(attrs, R.styleable.LinkTextView)
        ta!!.apply {
            linkUnderline = getBoolean(R.styleable.LinkTextView_link_underline, linkUnderline)
            linkColor = getColor(R.styleable.LinkTextView_link_color, linkColor)
            recycle()
        }
    }

    /**
     *
     * @override setText method of the normal TextView
     * This method uses a SpannableStringBuilder to get detect the Urls in the text
     * and makes them clickable
     *
     */

    override fun setText(text: CharSequence?, type: BufferType) {
        text!!.apply {
            val strBuilder = SpannableStringBuilder(this)
            val urls = strBuilder.getSpans(0, strBuilder.length, URLSpan::class.java)
            for (span in urls)
                makeLinkClickable(strBuilder, span)

            super.setText(strBuilder, BufferType.SPANNABLE)
            movementMethod = LinkMovementMethod.getInstance()
        }
    }

    /**
     * @param strBuilder used for replacing the span with the link
     * @param span represents every link detected in the text
     *
     */
    private fun makeLinkClickable(strBuilder: SpannableStringBuilder, span: URLSpan) {

        val clickable = object : ClickableSpan() {
            override fun onClick(view: View) {
                onLinkClick?.invoke(span.url)
            }

            override fun updateDrawState(ds: TextPaint) {
                if (linkColor != 0) {
                    ds.color = linkColor
                }
                ds.isUnderlineText = linkUnderline
            }
        }

        strBuilder.apply {
            val start = getSpanStart(span)
            val end = getSpanEnd(span)
            val flags = getSpanFlags(span)

            setSpan(clickable, start, end, flags)
            removeSpan(span)
        }
    }
}