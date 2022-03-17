package com.example.recycler.reycler.assignRecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler.R
import com.example.recycler.models.Assign

class AssignItemViewHolder(
    itemView: View,
    private val initRecycler: (assign: Assign) -> Unit
) :
    RecyclerView.ViewHolder(itemView) {

    companion object {
        fun newInstance(
            parent: ViewGroup,
            initRecycler: (assign: Assign) -> Unit
        ) = AssignItemViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(
                R.layout.assign_item,
                parent,
                false
            ),
            initRecycler
        )
    }

    private val assignInput by lazy {
        itemView.findViewById<ImageView>(R.id.assign_image)
    }

    fun bindItem(assign: Assign) {
        assignInput.setImageResource(assign.image)
        assignInput.setOnClickListener {
            initRecycler(assign)
        }
    }
}