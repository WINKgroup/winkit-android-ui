package winkit.android.ui.example

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.reflect.KClass

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = Adapter()

        val menu = listOf(
                Section("PaginatedRecyclerView"),
                Activity("PaginatedRecyclerView with custom error and empty layout", PaginatedRecyclerViewActivityExample::class),
                Activity("PaginatedRecyclerView with default error and empty layout", PaginatedRecyclerViewActivityExample::class)
        )

    }

    class Adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        val ROW = 0
        val SECTION = 1
        val HEADER = 2

        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getItemCount(): Int {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }


    }

    open class Item (val title: String)
    class Activity (title: String, val actClass: KClass<*>): Item(title)
    class Section(title: String): Item(title)
}
