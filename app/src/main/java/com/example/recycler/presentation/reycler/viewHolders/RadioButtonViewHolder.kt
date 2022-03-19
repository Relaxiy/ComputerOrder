package com.example.recycler.presentation.reycler.viewHolders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import com.example.recycler.R
import com.example.recycler.domain.models.GeneralItem
import com.example.recycler.domain.models.TodoItem
import com.example.recycler.presentation.reycler.BaseViewHolder
import com.google.android.material.snackbar.Snackbar

class RadioButtonViewHolder(
    itemView: View,
) : BaseViewHolder(itemView) {

    companion object {
        const val VIEW_TYPE = 5
        fun newInstance(parent: ViewGroup) = RadioButtonViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(
                R.layout.todo_item,
                parent,
                false
            )
        )
    }

    private val radioButtonFirst by lazy {
        itemView.findViewById<RadioButton>(R.id.radio_button_first)
    }

    private val radioButtonSecond by lazy {
        itemView.findViewById<RadioButton>(R.id.radio_button_second)
    }

    override fun bindItem(generalItem: GeneralItem) {
        (generalItem as TodoItem).apply {
            radioButtonFirst.text = radioButtonFirstText
            radioButtonSecond.text = radioButtonSecondText
        }
        radioButtonFirst.setOnClickListener {
            Toast.makeText(itemView.context, "Toast", Toast.LENGTH_LONG).show()
        }
        radioButtonSecond.setOnClickListener {
            Snackbar.make(itemView, "Snackbar", Snackbar.LENGTH_LONG).show()
        }
    }
}