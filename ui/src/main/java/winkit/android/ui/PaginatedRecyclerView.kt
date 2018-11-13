package winkit.android.ui

import android.content.Context
import android.support.annotation.DrawableRes
import android.support.annotation.LayoutRes
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView

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
                recyclerView.layoutManager = value
            }
        }


    var getPageListener: ((index: Int) -> Boolean?)? = null

    init {
        val root = LayoutInflater.from(context).inflate(R.layout.view_paginated_recycler, this)
        recyclerView = root.findViewById(R.id.recycler_view)
        swipeRefresh = root.findViewById(R.id.swipe_refresh_layout)

        swipeRefresh.setOnRefreshListener {
            adapter?.clean()
            getPageListener?.invoke(0) ?: false
        }
    }

    abstract class Adapter<VH: RecyclerView.ViewHolder> (
            @LayoutRes val emptyLayout: Int = R.layout.view_paginated_recycler_empty,
            @LayoutRes val errorLayout: Int = R.layout.view_paginated_recycler_error
    ): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        internal var view: PaginatedRecyclerView? = null
            set(value) {
                field = value
                registerAdapterDataObserver(object: RecyclerView.AdapterDataObserver(){
                    override fun onChanged() {
                        val type = getItemViewType(0)
                        field?.internalLayoutManager = if(type == TYPE_EMPTY || type == TYPE_ERROR)
                            field?.SINGLE_LAYOUT_MANAGER else field?.layoutManager
                    }
                })
            }

        private val TYPE_EMPTY: Int = -1
        private val TYPE_ERROR: Int = -2

        private var showingError: Boolean = false
        private var errorMessage: String? = null

        fun showError (message: String) {
            showingError = true
            errorMessage = message
            clean()
            notifyDataSetChanged()
        }

        final override fun getItemCount(): Int = Math.max(1, getRowsCount())

        final override fun getItemViewType(position: Int): Int {
            val rowsCount = getRowsCount()
            if(rowsCount == 0 && position == 0) {
                view?.internalLayoutManager = view?.SINGLE_LAYOUT_MANAGER
                val type = if (showingError) TYPE_ERROR else TYPE_EMPTY
                showingError = false
                return type
            }
            view?.internalLayoutManager = view?.layoutManager
            return getRowViewType(position)
        }

        final override fun onCreateViewHolder(parent: ViewGroup, p1: Int): RecyclerView.ViewHolder =
            when(p1) {
                TYPE_EMPTY -> EmptyViewHolder(parent, emptyLayout)
                TYPE_ERROR -> ErrorViewHolder(parent, errorLayout)
                else -> onCreateRowViewHolder(parent, p1)
            }

        @Suppress("UNCHECKED_CAST")
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            when (holder) {
                is EmptyViewHolder -> {
                    bindEmptyView(view?.emptyTitle, view?.emptySubtitle, view?.emptyIcon?:0, holder.itemView)

                }
                is ErrorViewHolder -> {
                    bindErrorView(errorMessage, view?.errorIcon?:0, holder.itemView)
                }
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
                notifyItemChanged(0)
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
        }

        open fun getRowViewType(position: Int): Int = 0

        abstract fun getRowsCount(): Int
        abstract fun clean()
        abstract fun onCreateRowViewHolder (parent: ViewGroup, type: Int): VH
        abstract fun onBindRowViewHolder (holder: VH, position: Int)

        private class EmptyViewHolder(parent: ViewGroup, layout: Int): RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(layout, parent, false))
        private class ErrorViewHolder(parent: ViewGroup, layout: Int): RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(layout, parent, false))

    }
}