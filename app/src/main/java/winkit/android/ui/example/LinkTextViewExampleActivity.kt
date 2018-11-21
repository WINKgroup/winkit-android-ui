package winkit.android.ui.example

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_link_text_view_example.*

class LinkTextViewExampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_link_text_view_example)

        tvLinked.linkUnderline = true
        tvLinked.linkColor = getColor(R.color.abc_btn_colored_text_material)
        tvLinked.setText("https://www.google.com , amin.com , luigi.com")
    }
}

