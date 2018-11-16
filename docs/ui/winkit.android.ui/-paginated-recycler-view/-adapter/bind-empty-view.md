[ui](../../../index.md) / [winkit.android.ui](../../index.md) / [PaginatedRecyclerView](../index.md) / [Adapter](index.md) / [bindEmptyView](./bind-empty-view.md)

# bindEmptyView

`open fun bindEmptyView(title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, subtitle: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, @DrawableRes image: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, view: `[`View`](https://developer.android.com/reference/android/view/View.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Executed before show the empty data message. Override in case of custom layouts or binding implementation.

### Parameters

`title` - The [PaginatedRecyclerView.emptyTitle](../empty-title.md)

`subtitle` - The [PaginatedRecyclerView.emptySubtitle](../empty-subtitle.md)

`image` - The [PaginatedRecyclerView.emptyIcon](../empty-icon.md)

`view` - The inflated [emptyLayout](empty-layout.md) layout resource