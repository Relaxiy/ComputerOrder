package com.example.computerorder.presentation.bottomSheetRecycler.viewHolders

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.computerorder.R
import com.example.computerorder.domain.models.OperationSystem
import com.example.computerorder.presentation.bottomSheetRecycler.GeneralAdapter

class OperationSystemViewHolder(
    itemView: View,
    private val saveText: (item: Any) -> Unit
) : RecyclerView.ViewHolder(itemView), GeneralAdapter.Binder<OperationSystem> {

    private val bottomTextView by lazy {
        itemView.findViewById<TextView>(R.id.bottom_text_view)
    }

    private val item by lazy {
        itemView.findViewById<ConstraintLayout>(R.id.root_model)
    }

    override fun bindItem(data: OperationSystem) {
        bottomTextView.text = data.operationSystemTitle

        item.setOnClickListener {
            saveText(data)
        }
    }
}