package winkit.android.ui.example

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.SpannableString
import android.text.style.ClickableSpan
import android.text.style.URLSpan
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_link_text_view_example.*

class LinkTextViewExampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_link_text_view_example)

        tvLinked.setHtml("<a href= www.google.com >www.google.com</a> ")

        tvLinked.setText("hehy man")

    }
}

