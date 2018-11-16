[ui](../../../index.md) / [winkit.android.ui](../../index.md) / [PaginatedRecyclerView](../index.md) / [Adapter](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`Adapter(@LayoutRes emptyLayout: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = R.layout.view_paginated_recycler_empty, @LayoutRes errorLayout: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = R.layout.view_paginated_recycler_error)`

Adapter abstraction to provide data to [PaginatedRecyclerView](../index.md)

Example without define custom empty or error layouts

```
class MyCustomAdapter: PaginatedRecyclerView.Adapter<Adapter.Holder>() {

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
```

Example without defining custom empty or error layouts

```
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
```

### Parameters

`emptyLayout` - The empty layout resource

`errorLayout` - The error layout resource