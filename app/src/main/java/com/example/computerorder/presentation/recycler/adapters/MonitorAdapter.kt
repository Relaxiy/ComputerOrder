package com.example.computerorder.presentation.recycler.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.computerorder.R
import com.example.computerorder.domain.models.Monitor
import com.example.computerorder.presentation.recycler.GeneralAdapter
import com.example.computerorder.presentation.recycler.viewHolders.MonitorViewHolder

class MonitorAdapter(private val saveText: (item: Any) -> Unit) : GeneralAdapter<Monitor>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonitorViewHolder {
        return MonitorViewHolder(
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