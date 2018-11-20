package winkit.android.ui.example

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.paginatedrecyclerview_activity_example.*
import winkit.android.ui.PaginatedRecyclerView
import java.util.ArrayList

class PaginatedRecyclerViewActivityExample: AppCompatActivity() {
    private val adapter = Adapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.paginatedrecyclerview_activity_example)

        paginatedRecycler.adapter = adapter
        paginatedRecycler.getPageListener = getPage@{ index: Int ->
            getRandomData(index) { data ->
                Log.d("DATA!", "${data?.size}")
                if (data != null) {
                    adapter.append(data)
                    paginatedRecycler.haveMore = !data.isEmpty() && adapter.getRowsCount() < 40

                    adapter.notifyDataSetChanged()
                } else {
                    if(index == 0)
                        adapter.showError("Connection error")
                    else {
                        paginatedRecycler.haveMore = false
                        Toast.makeText(this, "Connection error", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        paginatedRecycler.requestFirstPage()

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

    class CustomLayoutAdapter: PaginatedRecyclerView.Adapter<CustomLayoutAdapter.Holder>(
            errorLayout = R.layout.custom_error_layout,
            emptyLayout = R.layout.custom_empty_layout
    ) {

        override fun onBindRowViewHolder(holder: Holder, position: Int) = holder.bind(data[position])

        val data: ArrayList<String> = ArrayList()

        override fun getRowsCount(): Int = data.size
        override fun clean() = data.clear()

        override fun onCreateRowViewHolder(parent: ViewGroup, type: Int): Holder = Holder(parent)

        fun append(toAppend: List<String>) = data.addAll(toAppend)

        class Holder(parent: ViewGroup) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)) {
            fun bind(text: String) {
                itemView.findViewById<TextView>(R.id.row_text)?.text = text
            }
        }

        override fun bindEmptyView(title: String?, subtitle: String?, image: Int, view: View) {
            // Implement custom empty recyclerView logic here

            val titleView = view.findViewById<TextView>(winkit.android.ui.R.id.empty_title)
            titleView.text = "$title $subtitle"

            val iconView = view.findViewById<ImageView>(winkit.android.ui.R.id.empty_icon)
            if (image != 0) iconView.setImageResource(image)
            else  iconView.setImageDrawable(null)
        }

        override fun bindErrorView(message: String?, image: Int, view: View) {
            // Implement custom error recyclerView logic here

            val iconView = view.findViewById<ImageView>(winkit.android.ui.R.id.error_icon)
            if (image != 0) iconView.setImageResource(image)
            else  iconView.setImageDrawable(null)
            iconView.visibility = if(image != 0) View.VISIBLE else View.GONE

            val button = view.findViewById<Button>(winkit.android.ui.R.id.error_retry_button)
            button.setOnClickListener { this.recyclerView?.requestFirstPage()}
            button.text = message
        }
    }

    private fun getRandomData (index: Int, call: (data: List<String>?) -> Unit){
        Handler().postDelayed({
            if(Math.random() > 0.7) {
                call(null)
            } else {
                val result = ArrayList<String>()
                if (Math.random() < 0.5) {
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