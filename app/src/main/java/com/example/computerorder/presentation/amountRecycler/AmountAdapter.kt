package com.example.computerorder.presentation.amountRecycler

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView

class AmountAdapter(private val openBottom: (editText: EditText) -> Unit) : RecyclerView.Adapter<AmountViewHolder>() {
    private var amount: Int = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AmountViewHolder {
        return AmountViewHolder.newInstance(parent, openBottom)
    }

    override fun onBindViewHolder(holder: AmountViewHolder, position: Int) {
        holder.bindItem()
    }

    override fun getItemCount() = amount
    fun setAmount(itemsAmount: Int){
        amount = itemsAmount
    }
}