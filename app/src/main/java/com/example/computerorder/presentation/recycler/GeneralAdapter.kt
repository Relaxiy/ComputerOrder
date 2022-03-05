package com.example.computerorder.presentation.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.computerorder.R

open class GeneralAdapter<T> : RecyclerView.Adapter<GeneralViewHolder<T>>() {
    private var items: List<T> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GeneralViewHolder<T> {
        return GeneralViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_bottom_fragment,
                    parent,
                    false
                )
        )
    }

    override fun onBindViewHolder(holder: GeneralViewHolder<T>, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int = items.size

    open fun setItems(data: List<T>) {
        items = data
        notifyDataSetChanged()
    }
}