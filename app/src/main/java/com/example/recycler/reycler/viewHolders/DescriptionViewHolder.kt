package com.example.recycler.reycler.viewHolders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.recycler.R
import com.example.recycler.models.Assign
import com.example.recycler.models.Description
import com.example.recycler.models.GeneralItem
import com.example.recycler.reycler.BaseViewHolder

class DescriptionViewHolder(itemView: View) : BaseViewHolder(itemView) {

    companion object{
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