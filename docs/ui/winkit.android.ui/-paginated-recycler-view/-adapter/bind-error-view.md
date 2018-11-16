[ui](../../../index.md) / [winkit.android.ui](../../index.md) / [PaginatedRecyclerView](../index.md) / [Adapter](index.md) / [bindErrorView](./bind-error-view.md)

# bindErrorView

`open fun bindErrorView(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, @DrawableRes image: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, view: `[`View`](https://developer.android.com/reference/android/view/View.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Executed before show the empty data message. Override in case of custom layouts or binding implementation.

### Parameters

`message` - The [showingError](#) message param

`image` - The [PaginatedRecyclerView.errorIcon](../error-icon.md)

`view` - The inflated [errorLayout](error-layout.md) layout resource