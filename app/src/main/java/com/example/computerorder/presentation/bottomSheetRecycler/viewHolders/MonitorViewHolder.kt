package com.example.computerorder.presentation.bottomSheetRecycler.viewHolders

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.computerorder.R
import com.example.computerorder.domain.models.Monitor
import com.example.computerorder.presentation.bottomSheetRecycler.GeneralAdapter

class MonitorViewHolder(
    itemView: View,
    private val saveText: (item: Any) -> Unit
) : RecyclerView.ViewHolder(itemView), GeneralAdapter.Binder<Monitor> {

    private val bottomTextView by lazy {
        itemView.findViewById<TextView>(R.id.bottom_text_view)
    }

    private val item by lazy {
        itemView.findViewById<ConstraintLayout>(R.id.root_model)
    }

    override fun bindItem(data: Monitor) {
        bottomTextView.text = data.monitorTitle

        item.setOnClickListener {
            saveText(data)
        }
    }
}