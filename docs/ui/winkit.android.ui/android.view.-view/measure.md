[ui](../../index.md) / [winkit.android.ui](../index.md) / [android.view.View](index.md) / [measure](./measure.md)

# measure

`fun `[`View`](https://developer.android.com/reference/android/view/View.html)`.measure(callback: (width: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, height: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Calculate the view sizes adding the a [ViewTreeObserver.OnGlobalLayoutListener](https://developer.android.com/reference/android/view/ViewTreeObserver/OnGlobalLayoutListener.html) and removing it
after the first occurrence.

### Parameters

`callback` - A function that receive the view's width and height