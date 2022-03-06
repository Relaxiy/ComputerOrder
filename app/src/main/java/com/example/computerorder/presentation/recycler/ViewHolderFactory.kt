package com.example.computerorder.presentation.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.computerorder.R
import com.example.computerorder.presentation.recycler.viewHolders.GraphicCardViewHolder
import com.example.computerorder.presentation.recycler.viewHolders.MonitorViewHolder
import com.example.computerorder.presentation.recycler.viewHolders.OperationSystemViewHolder

object ViewHolderFactory {
    fun create(view: View, viewType: Int, saveText: (item: Any) -> Unit): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.fragment_change_operation_system -> OperationSystemViewHolder(view, saveText)
            R.layout.fragment_change_graphic_card -> GraphicCardViewHolder(view, saveText)
            R.layout.fragment_change_monitor -> MonitorViewHolder(view, saveText)
            else -> throw Exception("Wrong view type")
        }
    }
}