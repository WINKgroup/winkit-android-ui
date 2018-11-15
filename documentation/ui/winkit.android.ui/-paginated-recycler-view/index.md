---
title: PaginatedRecyclerView - ui
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../../index.html">ui</a> / <a href="../index.html">winkit.android.ui</a> / <a href="./index.html">PaginatedRecyclerView</a></div>

# PaginatedRecyclerView

<div class="signature"><code><span class="keyword">class </span><span class="identifier">PaginatedRecyclerView</span>&nbsp;<span class="symbol">:</span>&nbsp;<a href="https://developer.android.com/reference/android/widget/FrameLayout.html"><span class="identifier">FrameLayout</span></a></code></div>

An helpful View that implement a RecyclerView with pullToRefresh and Loadmore feature.
This view ask in a callback the pages and allow to implement the "no data" and "error" state.

**Attr**
ref R.styleable#PaginatedRecyclerView

### Types

<table class="api-docs-table">
<tbody>
<tr>
<td markdown="1">

<a href="-adapter/index.html">Adapter</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">abstract</span> <span class="keyword">class </span><span class="identifier">Adapter</span><span class="symbol">&lt;</span><span class="identifier">VH</span>&nbsp;<span class="symbol">:</span>&nbsp;<span class="identifier">ViewHolder</span><span class="symbol">&gt;</span>&nbsp;<span class="symbol">:</span>&nbsp;<span class="identifier">Adapter</span><span class="symbol">&lt;</span><span class="identifier">ViewHolder</span><span class="symbol">&gt;</span></code></div>

</td>
</tr>
</tbody>
</table>

### Constructors

<table class="api-docs-table">
<tbody>
<tr>
<td markdown="1">

<a href="-init-.html">&lt;init&gt;</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="identifier">PaginatedRecyclerView</span><span class="symbol">(</span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="winkit.android.ui.PaginatedRecyclerView$<init>(android.content.Context, android.util.AttributeSet, kotlin.Int)/context">context</span><span class="symbol">:</span>&nbsp;<a href="https://developer.android.com/reference/android/content/Context.html"><span class="identifier">Context</span></a><span class="symbol">, </span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="winkit.android.ui.PaginatedRecyclerView$<init>(android.content.Context, android.util.AttributeSet, kotlin.Int)/attrs">attrs</span><span class="symbol">:</span>&nbsp;<a href="https://developer.android.com/reference/android/util/AttributeSet.html"><span class="identifier">AttributeSet</span></a><span class="symbol">?</span>&nbsp;<span class="symbol">=</span>&nbsp;null<span class="symbol">, </span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="winkit.android.ui.PaginatedRecyclerView$<init>(android.content.Context, android.util.AttributeSet, kotlin.Int)/defStyleAttr">defStyleAttr</span><span class="symbol">:</span>&nbsp;<a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html"><span class="identifier">Int</span></a>&nbsp;<span class="symbol">=</span>&nbsp;0<span class="symbol">)</span></code></div>

An helpful View that implement a RecyclerView with pullToRefresh and Loadmore feature.
This view ask in a callback the pages and allow to implement the "no data" and "error" state.


</td>
</tr>
</tbody>
</table>

### Properties

<table class="api-docs-table">
<tbody>
<tr>
<td markdown="1">

<a href="adapter.html">adapter</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">var </span><span class="identifier">adapter</span><span class="symbol">: </span><a href="-adapter/index.html"><span class="identifier">Adapter</span></a><span class="symbol">&lt;</span><span class="identifier">*</span><span class="symbol">&gt;</span><span class="symbol">?</span></code></div>

Adapter instance to bind


</td>
</tr>
<tr>
<td markdown="1">

<a href="empty-icon.html">emptyIcon</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">var </span><span class="identifier">emptyIcon</span><span class="symbol">: </span><a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html"><span class="identifier">Int</span></a></code></div>

The icon drawable resource to show in "no data" case.


</td>
</tr>
<tr>
<td markdown="1">

<a href="empty-subtitle.html">emptySubtitle</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">var </span><span class="identifier">emptySubtitle</span><span class="symbol">: </span><a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html"><span class="identifier">String</span></a><span class="symbol">?</span></code></div>

The subtitle to show in "no data" case.


</td>
</tr>
<tr>
<td markdown="1">

<a href="empty-title.html">emptyTitle</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">var </span><span class="identifier">emptyTitle</span><span class="symbol">: </span><a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html"><span class="identifier">String</span></a><span class="symbol">?</span></code></div>

The title to show in "no data" case.


</td>
</tr>
<tr>
<td markdown="1">

<a href="error-icon.html">errorIcon</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">var </span><span class="identifier">errorIcon</span><span class="symbol">: </span><a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html"><span class="identifier">Int</span></a></code></div>

The icon drawable resource to show in "error" case.


</td>
</tr>
<tr>
<td markdown="1">

<a href="get-page-listener.html">getPageListener</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">var </span><span class="identifier">getPageListener</span><span class="symbol">: </span><span class="symbol">(</span><span class="parameterName">index</span><span class="symbol">:</span>&nbsp;<a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html"><span class="identifier">Int</span></a><span class="symbol">)</span>&nbsp;<span class="symbol">-&gt;</span>&nbsp;<a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html"><span class="identifier">Unit</span></a></code></div>

Callback to notify the user loadMore of pullToRefresh action


</td>
</tr>
<tr>
<td markdown="1">

<a href="have-more.html">haveMore</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">var </span><span class="identifier">haveMore</span><span class="symbol">: </span><a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html"><span class="identifier">Boolean</span></a></code></div>

LoadMore availability


</td>
</tr>
<tr>
<td markdown="1">

<a href="layout-manager.html">layoutManager</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">var </span><span class="identifier">layoutManager</span><span class="symbol">: </span><span class="identifier">LayoutManager</span><span class="symbol">?</span></code></div>

The wrapped recyclerView's layout manager


</td>
</tr>
<tr>
<td markdown="1">

<a href="refreshing.html">refreshing</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">var </span><span class="identifier">refreshing</span><span class="symbol">: </span><a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html"><span class="identifier">Boolean</span></a></code></div>

SwipeRefresh view progress visibility


</td>
</tr>
</tbody>
</table>

### Functions

<table class="api-docs-table">
<tbody>
<tr>
<td markdown="1">

<a href="request-first-page.html">requestFirstPage</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">requestFirstPage</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html"><span class="identifier">Unit</span></a></code></div>

Clean the data and request the first page (like the user pullToRefresh action), <a href="get-page-listener.html">getPageListener</a> will be called with index 0.


</td>
</tr>
</tbody>
</table>
