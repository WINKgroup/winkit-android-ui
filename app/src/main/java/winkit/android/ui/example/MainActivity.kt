package winkit.android.ui.example

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import winkit.android.ui.PaginatedRecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {

    val adapter: MainActivity.Adapter = MainActivity.Adapter()
    var currentCall: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        paginatedRecycler.layoutManager = LinearLayoutManager(this)

        paginatedRecycler.adapter = adapter
        paginatedRecycler.emptyTitle = "Nessun Risultato"
        paginatedRecycler.emptySubtitle = "Sottotitolo nessun contenuto"
        paginatedRecycler.emptyIcon = R.drawable.abc_btn_radio_material
        paginatedRecycler.errorIcon = R.drawable.notification_icon_background

        paginatedRecycler.getPageListener = getPage@{ index: Int ->
            getRandomData(index) { data ->
                if (data != null) {
                    adapter.append(data)
                    paginatedRecycler.haveMore = !data.isEmpty() && adapter.getRowsCount() < 40

                    adapter.notifyDataSetChanged()
                } else {
                    if(index == 0)
                        adapter.showError("Errore di connessione")
                    else Toast.makeText(this, "Errore di connessione", Toast.LENGTH_SHORT).show()
                }
            }
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
            if(Math.random() > 0.7) {
                call(null)
            } else {
                val result = ArrayList<String>()
                if (Math.random() < 0.6 || index > 0) {
                    for (i in 1..15) {
                        val id = i + index
                        result.add("Row Item $id")
                    }
                }
                call(result)
            }
        }, 1000)

    }
}
