[ui](../../index.md) / [winkit.android.ui](../index.md) / [PaginatedRecyclerView](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`PaginatedRecyclerView(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, attrs: `[`AttributeSet`](https://developer.android.com/reference/android/util/AttributeSet.html)`? = null, defStyleAttr: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0)`

An helpful View that implement a RecyclerView with pullToRefresh and Loadmore feature.
This recyclerView ask in a callback the pages and allow to implement the "no data" and "error" state.

```
paginatedRecycler.getPageListener = getPage@{ index: Int ->
getHttpData(index) { data -> // connection error on data == null

if (data != null) {
adapter.append(data)
paginatedRecycler.haveMore = data.size < TOTAL_SIZE
adapter.notifyDataSetChanged()
} else {
if(index == 0)
adapter.showError("Connection error on first page")
else {
paginatedRecycler.haveMore = false
Toast.makeText(this, "Connection error", Toast.LENGTH_SHORT).show()
}
}
}
}
paginatedRecycler.requestFirstPage()
```

**Attr**
ref R.styleable#PaginatedRecyclerView

