package com.example.computerorder.presentation.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class GeneralAdapter<T>(private val saveText: (item: Any) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: List<T> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return getViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(viewType, parent, false),
            viewType
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as Binder<T>).bindItem(items[position])
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int = getLayoutId(position, items[position])

    fun setItems(data: List<T>) {
        items = data
        notifyDataSetChanged()
    }

    protected abstract fun getLayoutId(position: Int, obj: T): Int

    protected open fun getViewHolder(view: View, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolderFactory.create(view, viewType, saveText)
    }

    internal interface Binder<T> {
        fun bindItem(data: T)
    }
}