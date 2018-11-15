---
title: PaginatedRecyclerView.Adapter - ui
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../../../index.html">ui</a> / <a href="../../index.html">winkit.android.ui</a> / <a href="../index.html">PaginatedRecyclerView</a> / <a href="./index.html">Adapter</a></div>

# Adapter

<div class="signature"><code><span class="keyword">abstract</span> <span class="keyword">class </span><span class="identifier">Adapter</span><span class="symbol">&lt;</span><span class="identifier">VH</span>&nbsp;<span class="symbol">:</span>&nbsp;<span class="identifier">ViewHolder</span><span class="symbol">&gt;</span>&nbsp;<span class="symbol">:</span>&nbsp;<span class="identifier">Adapter</span><span class="symbol">&lt;</span><span class="identifier">ViewHolder</span><span class="symbol">&gt;</span></code></div>

### Constructors

<table class="api-docs-table">
<tbody>
<tr>
<td markdown="1">

<a href="-init-.html">&lt;init&gt;</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="identifier">Adapter</span><span class="symbol">(</span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="winkit.android.ui.PaginatedRecyclerView.Adapter$<init>(kotlin.Int, kotlin.Int)/emptyLayout">emptyLayout</span><span class="symbol">:</span>&nbsp;<a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html"><span class="identifier">Int</span></a>&nbsp;<span class="symbol">=</span>&nbsp;R.layout.view_paginated_recycler_empty<span class="symbol">, </span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="winkit.android.ui.PaginatedRecyclerView.Adapter$<init>(kotlin.Int, kotlin.Int)/errorLayout">errorLayout</span><span class="symbol">:</span>&nbsp;<a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html"><span class="identifier">Int</span></a>&nbsp;<span class="symbol">=</span>&nbsp;R.layout.view_paginated_recycler_error<span class="symbol">)</span></code></div>

</td>
</tr>
</tbody>
</table>

### Properties

<table class="api-docs-table">
<tbody>
<tr>
<td markdown="1">

<a href="empty-layout.html">emptyLayout</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">val </span><span class="identifier">emptyLayout</span><span class="symbol">: </span><a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html"><span class="identifier">Int</span></a></code></div>

</td>
</tr>
<tr>
<td markdown="1">

<a href="error-layout.html">errorLayout</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">val </span><span class="identifier">errorLayout</span><span class="symbol">: </span><a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html"><span class="identifier">Int</span></a></code></div>

</td>
</tr>
</tbody>
</table>

### Functions

<table class="api-docs-table">
<tbody>
<tr>
<td markdown="1">

<a href="bind-empty-view.html">bindEmptyView</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">open</span> <span class="keyword">fun </span><span class="identifier">bindEmptyView</span><span class="symbol">(</span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="winkit.android.ui.PaginatedRecyclerView.Adapter$bindEmptyView(kotlin.String, kotlin.String, kotlin.Int, android.view.View)/title">title</span><span class="symbol">:</span>&nbsp;<a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html"><span class="identifier">String</span></a><span class="symbol">?</span><span class="symbol">, </span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="winkit.android.ui.PaginatedRecyclerView.Adapter$bindEmptyView(kotlin.String, kotlin.String, kotlin.Int, android.view.View)/subtitle">subtitle</span><span class="symbol">:</span>&nbsp;<a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html"><span class="identifier">String</span></a><span class="symbol">?</span><span class="symbol">, </span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="winkit.android.ui.PaginatedRecyclerView.Adapter$bindEmptyView(kotlin.String, kotlin.String, kotlin.Int, android.view.View)/image">image</span><span class="symbol">:</span>&nbsp;<a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html"><span class="identifier">Int</span></a><span class="symbol">, </span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="winkit.android.ui.PaginatedRecyclerView.Adapter$bindEmptyView(kotlin.String, kotlin.String, kotlin.Int, android.view.View)/view">view</span><span class="symbol">:</span>&nbsp;<a href="https://developer.android.com/reference/android/view/View.html"><span class="identifier">View</span></a><br/><span class="symbol">)</span><span class="symbol">: </span><a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html"><span class="identifier">Unit</span></a></code></div>

</td>
</tr>
<tr>
<td markdown="1">

<a href="bind-error-view.html">bindErrorView</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">open</span> <span class="keyword">fun </span><span class="identifier">bindErrorView</span><span class="symbol">(</span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="winkit.android.ui.PaginatedRecyclerView.Adapter$bindErrorView(kotlin.String, kotlin.Int, android.view.View)/title">title</span><span class="symbol">:</span>&nbsp;<a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html"><span class="identifier">String</span></a><span class="symbol">?</span><span class="symbol">, </span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="winkit.android.ui.PaginatedRecyclerView.Adapter$bindErrorView(kotlin.String, kotlin.Int, android.view.View)/image">image</span><span class="symbol">:</span>&nbsp;<a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html"><span class="identifier">Int</span></a><span class="symbol">, </span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="winkit.android.ui.PaginatedRecyclerView.Adapter$bindErrorView(kotlin.String, kotlin.Int, android.view.View)/view">view</span><span class="symbol">:</span>&nbsp;<a href="https://developer.android.com/reference/android/view/View.html"><span class="identifier">View</span></a><br/><span class="symbol">)</span><span class="symbol">: </span><a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html"><span class="identifier">Unit</span></a></code></div>

</td>
</tr>
<tr>
<td markdown="1">

<a href="clean.html">clean</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">abstract</span> <span class="keyword">fun </span><span class="identifier">clean</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html"><span class="identifier">Unit</span></a></code></div>

</td>
</tr>
<tr>
<td markdown="1">

<a href="get-item-count.html">getItemCount</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">getItemCount</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html"><span class="identifier">Int</span></a></code></div>

</td>
</tr>
<tr>
<td markdown="1">

<a href="get-item-view-type.html">getItemViewType</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">getItemViewType</span><span class="symbol">(</span><span class="parameterName" id="winkit.android.ui.PaginatedRecyclerView.Adapter$getItemViewType(kotlin.Int)/position">position</span><span class="symbol">:</span>&nbsp;<a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html"><span class="identifier">Int</span></a><span class="symbol">)</span><span class="symbol">: </span><a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html"><span class="identifier">Int</span></a></code></div>

</td>
</tr>
<tr>
<td markdown="1">

<a href="get-row-view-type.html">getRowViewType</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">open</span> <span class="keyword">fun </span><span class="identifier">getRowViewType</span><span class="symbol">(</span><span class="parameterName" id="winkit.android.ui.PaginatedRecyclerView.Adapter$getRowViewType(kotlin.Int)/position">position</span><span class="symbol">:</span>&nbsp;<a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html"><span class="identifier">Int</span></a><span class="symbol">)</span><span class="symbol">: </span><a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html"><span class="identifier">Int</span></a></code></div>

</td>
</tr>
<tr>
<td markdown="1">

<a href="get-rows-count.html">getRowsCount</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">abstract</span> <span class="keyword">fun </span><span class="identifier">getRowsCount</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html"><span class="identifier">Int</span></a></code></div>

</td>
</tr>
<tr>
<td markdown="1">

<a href="on-bind-row-view-holder.html">onBindRowViewHolder</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">abstract</span> <span class="keyword">fun </span><span class="identifier">onBindRowViewHolder</span><span class="symbol">(</span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="winkit.android.ui.PaginatedRecyclerView.Adapter$onBindRowViewHolder(winkit.android.ui.PaginatedRecyclerView.Adapter.VH, kotlin.Int)/holder">holder</span><span class="symbol">:</span>&nbsp;<a href="index.html#VH"><span class="identifier">VH</span></a><span class="symbol">, </span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="winkit.android.ui.PaginatedRecyclerView.Adapter$onBindRowViewHolder(winkit.android.ui.PaginatedRecyclerView.Adapter.VH, kotlin.Int)/position">position</span><span class="symbol">:</span>&nbsp;<a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html"><span class="identifier">Int</span></a><br/><span class="symbol">)</span><span class="symbol">: </span><a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html"><span class="identifier">Unit</span></a></code></div>

</td>
</tr>
<tr>
<td markdown="1">

<a href="on-bind-view-holder.html">onBindViewHolder</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">open</span> <span class="keyword">fun </span><span class="identifier">onBindViewHolder</span><span class="symbol">(</span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="winkit.android.ui.PaginatedRecyclerView.Adapter$onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder, kotlin.Int)/holder">holder</span><span class="symbol">:</span>&nbsp;<span class="identifier">ViewHolder</span><span class="symbol">, </span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="winkit.android.ui.PaginatedRecyclerView.Adapter$onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder, kotlin.Int)/position">position</span><span class="symbol">:</span>&nbsp;<a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html"><span class="identifier">Int</span></a><br/><span class="symbol">)</span><span class="symbol">: </span><a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html"><span class="identifier">Unit</span></a></code></div>

</td>
</tr>
<tr>
<td markdown="1">

<a href="on-create-row-view-holder.html">onCreateRowViewHolder</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">abstract</span> <span class="keyword">fun </span><span class="identifier">onCreateRowViewHolder</span><span class="symbol">(</span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="winkit.android.ui.PaginatedRecyclerView.Adapter$onCreateRowViewHolder(android.view.ViewGroup, kotlin.Int)/parent">parent</span><span class="symbol">:</span>&nbsp;<a href="https://developer.android.com/reference/android/view/ViewGroup.html"><span class="identifier">ViewGroup</span></a><span class="symbol">, </span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="winkit.android.ui.PaginatedRecyclerView.Adapter$onCreateRowViewHolder(android.view.ViewGroup, kotlin.Int)/type">type</span><span class="symbol">:</span>&nbsp;<a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html"><span class="identifier">Int</span></a><br/><span class="symbol">)</span><span class="symbol">: </span><a href="index.html#VH"><span class="identifier">VH</span></a></code></div>

</td>
</tr>
<tr>
<td markdown="1">

<a href="on-create-view-holder.html">onCreateViewHolder</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">onCreateViewHolder</span><span class="symbol">(</span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="winkit.android.ui.PaginatedRecyclerView.Adapter$onCreateViewHolder(android.view.ViewGroup, kotlin.Int)/parent">parent</span><span class="symbol">:</span>&nbsp;<a href="https://developer.android.com/reference/android/view/ViewGroup.html"><span class="identifier">ViewGroup</span></a><span class="symbol">, </span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="winkit.android.ui.PaginatedRecyclerView.Adapter$onCreateViewHolder(android.view.ViewGroup, kotlin.Int)/p1">p1</span><span class="symbol">:</span>&nbsp;<a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html"><span class="identifier">Int</span></a><br/><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">ViewHolder</span></code></div>

</td>
</tr>
<tr>
<td markdown="1">

<a href="show-error.html">showError</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">showError</span><span class="symbol">(</span><span class="parameterName" id="winkit.android.ui.PaginatedRecyclerView.Adapter$showError(kotlin.String)/message">message</span><span class="symbol">:</span>&nbsp;<a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html"><span class="identifier">String</span></a><span class="symbol">)</span><span class="symbol">: </span><a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html"><span class="identifier">Unit</span></a></code></div>

</td>
</tr>
</tbody>
</table>
