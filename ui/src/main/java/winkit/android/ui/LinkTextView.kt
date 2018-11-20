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

class LinkTextView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    :TextView (context, attrs, defStyleAttr)  {

    var onLinkClick: ((url: String) -> Unit)? = null
    var linkUnderline = true
    var linkColor = 0

    init {
        val ta = getContext().obtainStyledAttributes(attrs, R.styleable.LinkTextView)
        if (ta != null) {
            linkUnderline = ta.getBoolean(R.styleable.LinkTextView_link_underline, linkUnderline)
            linkColor = ta.getColor(R.styleable.LinkTextView_link_color, linkColor)
            ta.recycle()
        }
    }

    override fun setText(text: CharSequence?, type: BufferType?) {
        super.setText(text, type)
        if(text != null) {
            val strBuilder = SpannableStringBuilder(text)
            val urls = strBuilder.getSpans(0, text.length, URLSpan::class.java)
            for (span in urls)
                makeLinkClickable(strBuilder, span)

            setText(strBuilder)
            movementMethod = LinkMovementMethod.getInstance()
        }
    }

    private fun makeLinkClickable(strBuilder: SpannableStringBuilder, span: URLSpan) {
        val start = strBuilder.getSpanStart(span)
        val end = strBuilder.getSpanEnd(span)
        val flags = strBuilder.getSpanFlags(span)
        val clickable = object : ClickableSpan() {
            override fun onClick(view: View) {
                onLinkClick?.invoke(span.url)
            }

            override fun updateDrawState(ds: TextPaint) {
                if(linkColor != 0) {
                    ds.color = linkColor
                }
                ds.isUnderlineText = linkUnderline
            }

        }
        strBuilder.setSpan(clickable, start, end, flags)
        strBuilder.removeSpan(span)
    }
}