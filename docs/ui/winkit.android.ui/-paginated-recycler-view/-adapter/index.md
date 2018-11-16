[ui](../../../index.md) / [winkit.android.ui](../../index.md) / [PaginatedRecyclerView](../index.md) / [Adapter](./index.md)

# Adapter

`abstract class Adapter<VH : ViewHolder> : Adapter<ViewHolder>`

Adapter abstraction to provide data to [PaginatedRecyclerView](../index.md)

``` kotlin
//Missing function name in @sample
```

### Parameters

`emptyLayout` - The empty layout resource

`errorLayout` -

The error layout resource



Example without define custom empty or error layouts

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Adapter(emptyLayout: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = R.layout.view_paginated_recycler_empty, errorLayout: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = R.layout.view_paginated_recycler_error)`<br>Adapter abstraction to provide data to [PaginatedRecyclerView](../index.md) |

### Properties

| Name | Summary |
|---|---|
| [emptyLayout](empty-layout.md) | `val emptyLayout: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The empty layout resource |
| [errorLayout](error-layout.md) | `val errorLayout: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The error layout resource |
| [recyclerView](recycler-view.md) | `var recyclerView: `[`PaginatedRecyclerView`](../index.md)`?` |

### Functions

| Name | Summary |
|---|---|
| [bindEmptyView](bind-empty-view.md) | `open fun bindEmptyView(title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, subtitle: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, image: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, view: `[`View`](https://developer.android.com/reference/android/view/View.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Executed before show the empty data message. Override in case of custom layouts or binding implementation. |
| [bindErrorView](bind-error-view.md) | `open fun bindErrorView(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, image: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, view: `[`View`](https://developer.android.com/reference/android/view/View.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Executed before show the empty data message. Override in case of custom layouts or binding implementation. |
| [clean](clean.md) | `abstract fun clean(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Perform the data clean |
| [getItemCount](get-item-count.md) | `fun getItemCount(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [getItemViewType](get-item-view-type.md) | `fun getItemViewType(position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [getRowViewType](get-row-view-type.md) | `open fun getRowViewType(position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Replace [RecyclerView.Adapter.getItemViewType](#) |
| [getRowsCount](get-rows-count.md) | `abstract fun getRowsCount(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Replace [RecyclerView.Adapter.getItemCount](#) |
| [onBindRowViewHolder](on-bind-row-view-holder.md) | `abstract fun onBindRowViewHolder(holder: `[`VH`](index.md#VH)`, position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Replace [RecyclerView.Adapter.onBindViewHolder](#) |
| [onBindViewHolder](on-bind-view-holder.md) | `fun onBindViewHolder(holder: ViewHolder, position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCreateRowViewHolder](on-create-row-view-holder.md) | `abstract fun onCreateRowViewHolder(parent: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`, type: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`VH`](index.md#VH)<br>Replace [RecyclerView.Adapter.onCreateViewHolder](#) |
| [onCreateViewHolder](on-create-view-holder.md) | `fun onCreateViewHolder(parent: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`, p1: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): ViewHolder` |
| [showError](show-error.md) | `fun showError(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Clean the data and showing the "error" recyclerView with the selected message. |
