package winkit.android.ui.example

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.reflect.KClass



class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Winkit Ui example app"

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = Adapter()

    }

    class Adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        val ROW = 0
        val SECTION = 1
        val HEADER = 2

        val menu = listOf(
                Section("PaginatedRecyclerView"),
                Activity(PaginatedRecyclerViewActivityExample::class, "PaginatedRecyclerView"),
                Activity(PaginatedRecyclerViewCustomActivityExample::class, "PaginatedRecyclerView with custom error and empty layout")
        )

        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder =
                when (p1) {
                    SECTION -> ViewSection(p0)
                    HEADER -> ViewHeader(p0)
                    else -> ViewRow(p0)
                }

        override fun getItemCount(): Int = menu.size + 1

        override fun getItemViewType(position: Int): Int {
            if (position == 0) return HEADER

            val item = menu[position-1]
            return when(item) {
                is Section -> SECTION
                else -> ROW
            }
        }

        override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
            if (p1 == 0) return
            val item = menu[p1 - 1]
            when(item) {
                is Section -> (p0 as? ViewSection)?.bind(item)
                is Activity -> (p0 as? ViewRow)?.bind(item)
            }
        }

        class ViewRow(parent: ViewGroup): RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_row, parent, false)) {
            private val titleText: TextView = itemView.findViewById(R.id.rowText)
            init {
                itemView.setOnClickListener {
                    if(itemView.tag != null) (itemView.tag as? Activity).let { tag ->
                        itemView.context.startActivity(Intent(itemView.context, tag!!.actClass.java ))
                    }
                }
            }

            fun bind (row: Activity) {
                itemView.tag = row
                titleText.text = row.title
            }
        }

        class ViewSection(parent: ViewGroup): RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_section, parent, false)) {
            private val titleText: TextView = itemView.findViewById(R.id.sectionText)
            fun bind (section: Section) { titleText.text = section.title }
        }

        class ViewHeader(parent: ViewGroup): RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_header, parent, false)) {
            init {
                itemView.findViewById<View>(R.id.githubButton)?.setOnClickListener {
                    val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/WINKgroup/winkit-android-ui"))
                    itemView.context.startActivity(myIntent)
                }
            }
        }

    }

    open class Item (val title: String)
    class Activity (val actClass: KClass<*>, title: String): Item(title)
    class Section(title: String): Item(title)
}
