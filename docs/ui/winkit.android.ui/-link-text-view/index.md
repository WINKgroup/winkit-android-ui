[ui](../../index.md) / [winkit.android.ui](../index.md) / [LinkTextView](./index.md)

# LinkTextView

`class LinkTextView : `[`TextView`](https://developer.android.com/reference/android/widget/TextView.html)

A Utility View With the ability to show the links that
are provided in the String

### Parameters

`context` -

`attrs` -

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `LinkTextView(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, attrs: `[`AttributeSet`](https://developer.android.com/reference/android/util/AttributeSet.html)`? = null, defStyleAttr: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0)`<br>gets the required parameters and initializes a new @LinkTextView |

### Properties

| Name | Summary |
|---|---|
| [linkColor](link-color.md) | `var linkColor: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [linkUnderline](link-underline.md) | `var linkUnderline: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [onLinkClick](on-link-click.md) | `var onLinkClick: (url: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Functions

| Name | Summary |
|---|---|
| [setHtml](set-html.md) | `fun setHtml(html: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>This is the method which provides the feature to pass links via HTML and sends them to the default setText method |
| [setText](set-text.md) | `fun setText(text: `[`CharSequence`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)`?, type: `[`BufferType`](https://developer.android.com/reference/android/widget/TextView/BufferType.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| [measure](../android.view.-view/measure.md) | `fun `[`View`](https://developer.android.com/reference/android/view/View.html)`.measure(callback: (width: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, height: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Calculate the view sizes adding the a [ViewTreeObserver.OnGlobalLayoutListener](https://developer.android.com/reference/android/view/ViewTreeObserver/OnGlobalLayoutListener.html) and removing it after the first occurrence. |
| [measureIfNeeded](../android.view.-view/measure-if-needed.md) | `fun `[`View`](https://developer.android.com/reference/android/view/View.html)`.measureIfNeeded(callback: (width: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, height: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Call the [callback](../android.view.-view/measure-if-needed.md#winkit.android.ui$measureIfNeeded(android.view.View, kotlin.Function2((kotlin.Int, , kotlin.Unit)))/callback) if the view is already measured passing the view's sizes, otherwise call the [measure](../android.view.-view/measure.md) method. |
