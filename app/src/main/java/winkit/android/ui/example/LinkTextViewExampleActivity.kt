package winkit.android.ui.example

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import kotlinx.android.synthetic.main.activity_link_text_view_example.*

class LinkTextViewExampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_link_text_view_example)

        title = "LinkTextView Example"

        tvLink.setHtml(resources.getString(R.string.rome_html_link))

        tvLinkCustom.setHtml(resources.getString(R.string.rome_html_multiple_ink))
        tvLinkCustom.linkColor = ContextCompat.getColor(this, R.color.colorAccent)
        tvLinkCustom.linkUnderline = false
        tvLinkCustom.onLinkClick = {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(it)))
        }

    }
}

