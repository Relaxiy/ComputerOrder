package com.example.computerorder.presentation.recycler.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.computerorder.R
import com.example.computerorder.domain.models.GraphicCard
import com.example.computerorder.presentation.recycler.GeneralAdapter
import com.example.computerorder.presentation.recycler.viewHolders.GraphicCardViewHolder

class GraphicCardAdapter(private val saveText: (item: Any) -> Unit) : GeneralAdapter<GraphicCard>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GraphicCardViewHolder {
        return GraphicCardViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_bottom_fragment,
                    parent,
                    false
                ),
            saveText
        )
    }
}