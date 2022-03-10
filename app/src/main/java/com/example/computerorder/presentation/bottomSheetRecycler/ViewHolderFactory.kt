package com.example.computerorder.presentation.bottomSheetRecycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.computerorder.presentation.models.TypeObj
import com.example.computerorder.presentation.bottomSheetRecycler.viewHolders.GraphicCardViewHolder
import com.example.computerorder.presentation.bottomSheetRecycler.viewHolders.MonitorViewHolder
import com.example.computerorder.presentation.bottomSheetRecycler.viewHolders.OperationSystemViewHolder

object ViewHolderFactory {
    fun create(view: View, type: TypeObj, saveText: (item: Any) -> Unit): RecyclerView.ViewHolder {
        return when (type) {
            TypeObj.OPERATION_SYSTEM -> OperationSystemViewHolder(view, saveText)
            TypeObj.GRAPHIC_CARD -> GraphicCardViewHolder(view, saveText)
            TypeObj.MONITOR -> MonitorViewHolder(view, saveText)
        }
    }
}