package com.example.recycler.reycler.viewHolders

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.recycler.R
import com.example.recycler.models.Assign
import com.example.recycler.models.Date
import com.example.recycler.models.GeneralItem
import com.example.recycler.reycler.BaseViewHolder

class DateViewHolder(itemView: View) : BaseViewHolder(itemView) {

    companion object {
        const val VIEW_TYPE = 3
        fun newInstance(parent: ViewGroup) = DateViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(
                R.layout.date_item,
                parent,
                false
            )
        )
    }

    private val dayInput by lazy {
        itemView.findViewById<TextView>(R.id.input_day)
    }

    private val timeInput by lazy {
        itemView.findViewById<TextView>(R.id.input_time)
    }

    override fun bindItem(generalItem: GeneralItem) {
        (generalItem as Date).apply {
            dayInput.text = day
            timeInput.text = hours
        }
    }
}