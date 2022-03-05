package com.example.computerorder.presentation.recycler

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.computerorder.R

open class GeneralViewHolder<T>(
    itemView: View,
) : RecyclerView.ViewHolder(itemView) {

    private val bottomTextView by lazy {
        itemView.findViewById<TextView>(R.id.bottom_text_view)
    }

    private val item by lazy {
        itemView.findViewById<ConstraintLayout>(R.id.root_model)
    }

    open fun bindItem(data: T) {
    }
}