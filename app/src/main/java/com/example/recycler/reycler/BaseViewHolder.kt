package com.example.recycler.reycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler.models.GeneralItem

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun bindItem(generalItem: GeneralItem)

}