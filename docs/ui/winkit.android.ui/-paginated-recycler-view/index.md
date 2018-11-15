[ui](../../index.md) / [winkit.android.ui](../index.md) / [PaginatedRecyclerView](./index.md)

# PaginatedRecyclerView

`class PaginatedRecyclerView : `[`FrameLayout`](https://developer.android.com/reference/android/widget/FrameLayout.html)

An helpful View that implement a RecyclerView with pullToRefresh and Loadmore feature.
This view ask in a callback the pages and allow to implement the "no data" and "error" state.

**Attr**
ref R.styleable#PaginatedRecyclerView

### Types

| Name | Summary |
|---|---|
| [Adapter](-adapter/index.md) | `abstract class Adapter<VH : ViewHolder> : Adapter<ViewHolder>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `PaginatedRecyclerView(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, attrs: `[`AttributeSet`](https://developer.android.com/reference/android/util/AttributeSet.html)`? = null, defStyleAttr: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0)`<br>An helpful View that implement a RecyclerView with pullToRefresh and Loadmore feature. This view ask in a callback the pages and allow to implement the "no data" and "error" state. |

### Properties

| Name | Summary |
|---|---|
| [adapter](adapter.md) | `var adapter: `[`Adapter`](-adapter/index.md)`<*>?`<br>Adapter instance to bind |
| [emptyIcon](empty-icon.md) | `var emptyIcon: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The icon drawable resource to show in "no data" case. |
| [emptySubtitle](empty-subtitle.md) | `var emptySubtitle: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<br>The subtitle to show in "no data" case. |
| [emptyTitle](empty-title.md) | `var emptyTitle: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<br>The title to show in "no data" case. |
| [errorIcon](error-icon.md) | `var errorIcon: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The icon drawable resource to show in "error" case. |
| [getPageListener](get-page-listener.md) | `var getPageListener: (index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Callback to notify the user loadMore of pullToRefresh action |
| [haveMore](have-more.md) | `var haveMore: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>LoadMore availability |
| [layoutManager](layout-manager.md) | `var layoutManager: LayoutManager?`<br>The wrapped recyclerView's layout manager |
| [refreshing](refreshing.md) | `var refreshing: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>SwipeRefresh view progress visibility |

### Functions

| Name | Summary |
|---|---|
| [requestFirstPage](request-first-page.md) | `fun requestFirstPage(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Clean the data and request the first page (like the user pullToRefresh action), [getPageListener](get-page-listener.md) will be called with index 0. |