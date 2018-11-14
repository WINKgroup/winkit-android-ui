package winkit.android.ui

import android.content.Context
import android.support.annotation.DrawableRes
import android.support.annotation.LayoutRes
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log


class PaginatedRecyclerView
    @JvmOverloads constructor( context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
        :FrameLayout (context, attrs, defStyleAttr) {

    var emptyTitle: String? = null
        set(value) {
            field = value
            adapter?.notifyEmpty()
        }

    var emptySubtitle: String? = null
        set(value) {
            field = value
            adapter?.notifyEmpty()
        }

    @DrawableRes var emptyIcon: Int = 0
        set(value) {
            field = value
            adapter?.notifyEmpty()
        }

    @DrawableRes var errorIcon: Int = 0
        set(value) {
            field = value
            adapter?.notifyError()
        }


    var refreshing: Boolean = false
        set(value) { swipeRefresh.isRefreshing = value }


    private val recyclerView: RecyclerView
    private val swipeRefresh: SwipeRefreshLayout

    private var visibleItemCount: Int = 0
    private var totalItemCount: Int = 0
    private var pastVisiblesItems: Int = 0
    private var isLoadingMore: Boolean = false
    var haveMore: Boolean = true
        set(value) {
            if( field == value) return
            field = value
            if(!field) adapter?.notifyItemRemoved(adapter!!.itemCount)
            else adapter?.notifyItemInserted(adapter!!.itemCount)
        }

    var adapter: Adapter<*>?
        set(value) {
            value?.view = this
            recyclerView.adapter = value
        }
        get() = recyclerView.adapter as Adapter<*>

    internal val SINGLE_LAYOUT_MANAGER = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

    var layoutManager: RecyclerView.LayoutManager? = SINGLE_LAYOUT_MANAGER
        set(value) {
            field = value
            internalLayoutManager = value }

    internal var internalLayoutManager: RecyclerView.LayoutManager? = null
        set(value) {
            if(value != field) {
                field = value
                recyclerView.layoutManager = value?.let { configureLoadMoreSpan(it) }
            }
        }


    var getPageListener: ((index: Int) -> Unit)? = null

    init {
        val root = LayoutInflater.from(context).inflate(R.layout.view_paginated_recycler, this)
        recyclerView = root.findViewById(R.id.recycler_view)
        swipeRefresh = root.findViewById(R.id.swipe_refresh_layout)

        swipeRefresh.setOnRefreshListener { requestFirstPage() }

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy < 0) return
                visibleItemCount = layoutManager?.childCount ?:0
                totalItemCount = layoutManager?.itemCount ?:0

                if (layoutManager is StaggeredGridLayoutManager) {
                    val firstVisibleItems = (layoutManager as StaggeredGridLayoutManager).findFirstVisibleItemPositions(null)
                    if (firstVisibleItems != null && firstVisibleItems.isNotEmpty())
                        pastVisiblesItems = firstVisibleItems[0]

                } else if (layoutManager is GridLayoutManager) {
                    val firstVisible = (layoutManager as GridLayoutManager).findFirstVisibleItemPosition()
                    if (firstVisible != RecyclerView.NO_POSITION)
                        pastVisiblesItems = firstVisible
                } else if (layoutManager is LinearLayoutManager) {
                    val firstVisible = (layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
                    if (firstVisible != RecyclerView.NO_POSITION)
                        pastVisiblesItems = firstVisible
                }

                val lastType = adapter?.getItemViewType(adapter!!.itemCount - 1)
                if (
                    !isLoadingMore &&
                    haveMore &&
                    !swipeRefresh.isRefreshing &&
                    visibleItemCount + pastVisiblesItems == totalItemCount &&
                    lastType == Adapter.TYPE_LOAD_MORE
                ) {
                    val index = adapter?.getRowsCount() ?: 0
                    Log.d("SCROLL_INFINITY", "load index $index")
                    isLoadingMore = true
                    getPageListener?.invoke(index)
                }
            }
        })
    }

    fun requestFirstPage () {
        if(refreshing) return
        refreshing = true
        adapter?.clean()
        getPageListener?.invoke(0)
    }

    abstract class Adapter<VH: RecyclerView.ViewHolder> (
            @LayoutRes val emptyLayout: Int = R.layout.view_paginated_recycler_empty,
            @LayoutRes val errorLayout: Int = R.layout.view_paginated_recycler_error
    ): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


        companion object {
            internal val TYPE_EMPTY: Int = -1
            internal val TYPE_ERROR: Int = -2
            internal val TYPE_LOAD_MORE: Int = -3
        }


        internal var view: PaginatedRecyclerView? = null
            set(value) {
                field = value
                registerAdapterDataObserver(object: RecyclerView.AdapterDataObserver(){
                    override fun onChanged() {
                        val type = getItemViewType(0)
                        field?.internalLayoutManager = if(type == TYPE_EMPTY || type == TYPE_ERROR)
                            field?.SINGLE_LAYOUT_MANAGER else field?.layoutManager
                        field?.isLoadingMore = false
                        field?.refreshing = false
                    }
                })
            }

        private var showingError: Boolean = false
        private var errorMessage: String? = null

        fun showError (message: String) {
            showingError = true
            errorMessage = message
            clean()
            notifyDataSetChanged()
        }

        final override fun getItemCount(): Int = Math.max(getRowsCount() + if(view?.haveMore == true) 1 else 0, 1)

        final override fun getItemViewType(position: Int): Int {
            val rowsCount = getRowsCount()
            if(rowsCount == 0 && position == 0) {
                view?.internalLayoutManager = view?.SINGLE_LAYOUT_MANAGER
                return if (showingError) TYPE_ERROR else TYPE_EMPTY
            }
            view?.internalLayoutManager = view?.layoutManager
            return if(position == rowsCount) TYPE_LOAD_MORE else getRowViewType(position)
        }

        final override fun onCreateViewHolder(parent: ViewGroup, p1: Int): RecyclerView.ViewHolder =
            when(p1) {
                TYPE_EMPTY -> EmptyViewHolder(parent, emptyLayout)
                TYPE_ERROR -> ErrorViewHolder(parent, errorLayout)
                TYPE_LOAD_MORE -> LoadMoreViewHolder(parent)
                else -> onCreateRowViewHolder(parent, p1)
            }

        @Suppress("UNCHECKED_CAST")
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            when (holder) {
                is EmptyViewHolder -> bindEmptyView(view?.emptyTitle, view?.emptySubtitle, view?.emptyIcon?:0, holder.itemView)
                is ErrorViewHolder -> {
                    bindErrorView(errorMessage, view?.errorIcon?:0, holder.itemView)
                    showingError = false
                }
                is LoadMoreViewHolder -> view?.layoutManager?.let { holder.configOrientation(it) }
                else -> {
                    if(holder as? VH != null) {
                        onBindRowViewHolder(holder, position)
                    }
                }
            }
        }

        internal fun notifyEmpty () = notifyType(TYPE_EMPTY)
        internal fun notifyError () = notifyType(TYPE_ERROR)
        private fun notifyType (type: Int) {
            if(getItemViewType(0) == type)
                notifyItemInserted(0)
        }

        open fun bindEmptyView(title: String?, subtitle: String?, @DrawableRes image: Int, view: View) {
            val titleView = view.findViewById<TextView>(R.id.empty_title)
            if (titleView != null) {
                titleView.text = title
                titleView.visibility = if(title != null) View.VISIBLE else View.GONE
            }

            val subtitleView = view.findViewById<TextView>(R.id.empty_subtitle)
            if (subtitleView != null) {
                subtitleView.text = subtitle
                subtitleView.visibility = if(subtitle != null) View.VISIBLE else View.GONE
            }

            val iconView = view.findViewById<ImageView>(R.id.empty_icon)
            if (iconView != null) {
                if (image != 0) iconView.setImageResource(image)
                else  iconView.setImageDrawable(null)
                iconView.visibility = if(image != 0) View.VISIBLE else View.GONE
            }
        }

        open fun bindErrorView(title: String?, @DrawableRes image: Int, view: View) {
            val titleView = view.findViewById<TextView>(R.id.error_title)
            if (titleView != null) {
                titleView.text = title
                titleView.visibility = if(title != null) View.VISIBLE else View.GONE
            }

            val iconView = view.findViewById<ImageView>(R.id.error_icon)
            if (iconView != null) {
                if (image != 0) iconView.setImageResource(image)
                else  iconView.setImageDrawable(null)
                iconView.visibility = if(image != 0) View.VISIBLE else View.GONE
            }

            view.findViewById<View>(R.id.error_retry_button).setOnClickListener { this.view?.requestFirstPage()}
        }

        open fun getRowViewType(position: Int): Int = 0

        abstract fun getRowsCount(): Int
        abstract fun clean()
        abstract fun onCreateRowViewHolder (parent: ViewGroup, type: Int): VH
        abstract fun onBindRowViewHolder (holder: VH, position: Int)

        private open class InternalHolder(parent: ViewGroup, layout: Int): RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(layout, parent, false))

        private class EmptyViewHolder(parent: ViewGroup, layout: Int): InternalHolder(parent, layout)
        private class ErrorViewHolder(parent: ViewGroup, layout: Int): InternalHolder(parent, layout)
        private class LoadMoreViewHolder(parent: ViewGroup): InternalHolder(parent, R.layout.view_paginated_loadmore) {
            val contaier: View
            init {
                val layoutParams = itemView.layoutParams as? StaggeredGridLayoutManager.LayoutParams
                layoutParams?.isFullSpan = true
                contaier = itemView.findViewById<ViewGroup>(R.id.loadmore_container)
            }

            fun configOrientation (layoutManager: RecyclerView.LayoutManager) {
                fun configOrientation (isHorizontal: Boolean){
                    contaier.layoutParams.height = if(!isHorizontal) ViewGroup.LayoutParams.WRAP_CONTENT else ViewGroup.LayoutParams.MATCH_PARENT
                    contaier.layoutParams.width = if(isHorizontal) ViewGroup.LayoutParams.WRAP_CONTENT else ViewGroup.LayoutParams.MATCH_PARENT
                }

                when (layoutManager) {
                    is GridLayoutManager -> configOrientation(layoutManager.orientation == GridLayoutManager.HORIZONTAL )
                    is StaggeredGridLayoutManager -> configOrientation(layoutManager.orientation == StaggeredGridLayoutManager.HORIZONTAL )
                    is LinearLayoutManager -> configOrientation(layoutManager.orientation == LinearLayoutManager.HORIZONTAL )
                }
            }
        }
    }

    private fun configureLoadMoreSpan (manager: RecyclerView.LayoutManager): RecyclerView.LayoutManager {
        if(manager is GridLayoutManager) {
            val old = manager.spanSizeLookup
            manager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return if (adapter?.getItemViewType(position) == Adapter.TYPE_LOAD_MORE)
                        manager.spanCount else old?.getSpanSize(position)?:1
                }
            }
        }
        return manager
    }
}