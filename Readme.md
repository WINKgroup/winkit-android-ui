<p align="center"><img width="40%" src="img/logo.png"/></p>

# Winkit Ui

<img src="https://img.shields.io/badge/winkit-ui-green.svg?logo=android&longCache=true&style=popout"> <img src="https://img.shields.io/badge/kotlin-1.2.71-blue.svg?logo=kotlin&longCache=true&style=popout">

An android ui library that provide useful classes to speed up the implementation.

Complete documentation [Here](https://winkgroup.github.io/winkit-android-ui/ui/winkit.android.ui/).

### Install

No release made (work in progress).

## Views

### PaginatedRecyclerView [docs](https://winkgroup.github.io/winkit-android-ui/ui/winkit.android.ui/-paginated-recycler-view/) 
An helpful View that implement a RecyclerView with pullToRefresh and Loadmore feature. This recyclerView ask in a callback the pages and allow to implement the “no data” and “error” state.

<p align="center">
	<img width="30%" src="img/PaginatedRecyclerView_3.png"/>
	<img width="30%" src="img/PaginatedRecyclerView_2.png"/>
	<img width="30%" src="img/PaginatedRecyclerView_1.png"/>
</p>

Xml declaration:

```xml
<winkit.android.ui.PaginatedRecyclerView
    android:id="@+id/paginatedRecycler"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:empty_title="Empty data"
    app:empty_subtitle="Subtitle"
    app:empty_icon="@mipmap/ic_launcher"
    app:error_icon="@mipmap/ic_launcher"/>
```

Kotlin implemention:

```kotlin
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
                adapter.showError("Errore di connessione")
            else {
                paginatedRecycler.haveMore = false
                Toast.makeText(this, "Errore di connessione", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
paginatedRecycler.requestFirstPage()
```
