[ui](../../index.md) / [winkit.android.ui](../index.md) / [android.view.View](index.md) / [measureIfNeeded](./measure-if-needed.md)

# measureIfNeeded

`fun `[`View`](https://developer.android.com/reference/android/view/View.html)`.measureIfNeeded(callback: (width: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, height: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Call the [callback](measure-if-needed.md#winkit.android.ui$measureIfNeeded(android.view.View, kotlin.Function2((kotlin.Int, , kotlin.Unit)))/callback) if the view is already measured passing the view's sizes, otherwise call the [measure](measure.md) method.

### Parameters

`callback` - A function that receive the view's width and height