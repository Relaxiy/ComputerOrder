package com.example.computerorder.presentation.amountRecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.computerorder.R

class AmountViewHolder(itemView: View, private val openBottom: (editText: EditText) -> Unit) : RecyclerView.ViewHolder(itemView) {
    companion object {
        fun newInstance(
            parent: ViewGroup,
            openBottom: (editText: EditText) -> Unit
        ) = AmountViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.amount_item,
                    parent,
                    false
                ),
            openBottom
        )
    }

    private val editText by lazy {
        itemView.findViewById<EditText>(R.id.edit)
    }
    fun bindItem() {
        editText.setOnClickListener{
            if (editText.text.isEmpty()) {
                openBottom(editText)
            }
        }
    }
}