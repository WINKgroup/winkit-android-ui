package winkit.android.ui.example

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import winkit.android.ui.PaginatedRecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {

    val adapter: MainActivity.Adapter = MainActivity.Adapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        paginatedRecycler.layoutManager = GridLayoutManager(this, 2)

        paginatedRecycler.adapter = adapter
        paginatedRecycler.emptyTitle = "Nessun Risultato"
        paginatedRecycler.emptySubtitle = "Sottotitolo nessun contenuto"
        paginatedRecycler.emptyIcon = R.drawable.abc_btn_radio_material
        paginatedRecycler.errorIcon = R.drawable.notification_icon_background

        paginatedRecycler.getPageListener = getPage@{ index: Int ->
            getRandomData(index) { data ->

                paginatedRecycler.refreshing = false
                if (data != null) {
                    adapter.append(data)
                    adapter.notifyDataSetChanged()
                } else {
                    adapter.showError("Errore di connessione")
                }
            }
            return@getPage false
        }

    }

    class Adapter: PaginatedRecyclerView.Adapter<Adapter.Holder>() {

        override fun onBindRowViewHolder(holder: Holder, position: Int) = holder.bind(data[position])

        val data: ArrayList<String> = ArrayList()

        override fun getRowsCount(): Int = data.size
        override fun clean() = data.clear()

        override fun onCreateRowViewHolder(parent: ViewGroup, type: Int): Holder = Holder(parent)

        fun append (toAppend: List<String>) = data.addAll(toAppend)

        class Holder(parent: ViewGroup): RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)) {
            fun bind (text: String){
                itemView.findViewById<TextView>(R.id.row_text)?.text = text
            }
        }
    }

    private fun getRandomData (index: Int, call: (data: List<String>?) -> Unit){
        Handler().postDelayed({
            if(Math.random() > 0.8) {
                call(null)
            } else {
                val result = ArrayList<String>()
                if (Math.random() < 0.8) {
                    for (i in 0..29) {
                        val id = i + index
                        result.add("Row Item $id")
                    }
                }
                call(result)
            }
        }, 1000)

    }
}