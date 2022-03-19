package com.example.recycler.presentation.reycler.viewHolders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.recycler.R
import com.example.recycler.domain.models.GeneralItem
import com.example.recycler.domain.models.Task
import com.example.recycler.presentation.reycler.BaseViewHolder

class TaskViewHolder(itemView: View) : BaseViewHolder(itemView) {

    companion object {
        const val VIEW_TYPE = 6
        fun newInstance(parent: ViewGroup) = TaskViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(
                R.layout.task_item,
                parent,
                false
            )
        )
    }

    private val taskInput by lazy {
        itemView.findViewById<TextView>(R.id.input_title)
    }

    override fun bindItem(generalItem: GeneralItem) {
        (generalItem as Task).apply {
            taskInput.text = task
        }
    }
}