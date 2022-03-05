package com.example.computerorder.presentation.recycler.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.computerorder.R
import com.example.computerorder.domain.models.OperationSystem
import com.example.computerorder.presentation.recycler.GeneralAdapter
import com.example.computerorder.presentation.recycler.viewHolders.OperationSystemViewHolder

class OperationSystemAdapter(private val saveText: (item: Any) -> Unit) : GeneralAdapter<OperationSystem>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OperationSystemViewHolder {
        return OperationSystemViewHolder(
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