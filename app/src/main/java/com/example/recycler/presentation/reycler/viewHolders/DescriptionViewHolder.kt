package com.example.recycler.presentation.reycler.viewHolders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.recycler.R
import com.example.recycler.domain.models.Description
import com.example.recycler.domain.models.GeneralItem
import com.example.recycler.presentation.reycler.BaseViewHolder

class DescriptionViewHolder(itemView: View) : BaseViewHolder(itemView) {

    companion object {
        const val VIEW_TYPE = 4
        fun newInstance(parent: ViewGroup) = DescriptionViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(
                R.layout.description_item,
                parent,
                false
            )
        )
    }

    private val descriptionInput by lazy {
        itemView.findViewById<TextView>(R.id.input_description)
    }

    override fun bindItem(generalItem: GeneralItem) {
        (generalItem as Description).apply {
            descriptionInput.text = description
        }
    }
}