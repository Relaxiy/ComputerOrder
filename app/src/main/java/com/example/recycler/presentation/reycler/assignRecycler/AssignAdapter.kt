package com.example.recycler.presentation.reycler.assignRecycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler.domain.models.Assign

class AssignAdapter(private val initRecycler: (assign: Assign) -> Unit) :
    RecyclerView.Adapter<AssignItemViewHolder>() {

    private var items: List<Assign> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssignItemViewHolder {
        return AssignItemViewHolder.newInstance(parent, initRecycler)
    }

    override fun onBindViewHolder(holder: AssignItemViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun setItems(data: List<Assign>) {
        items = data
        notifyDataSetChanged()
    }
}