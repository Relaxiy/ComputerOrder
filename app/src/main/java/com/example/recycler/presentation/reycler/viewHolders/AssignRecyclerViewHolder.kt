package com.example.recycler.presentation.reycler.viewHolders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler.R
import com.example.recycler.domain.models.Assign
import com.example.recycler.domain.models.GeneralItem
import com.example.recycler.presentation.reycler.BaseViewHolder
import com.example.recycler.presentation.reycler.assignRecycler.AssignAdapter

class AssignRecyclerViewHolder(
    itemView: View,
    private val initRecycler: (assignAdapter: AssignAdapter, assign: Assign) -> Unit
) : BaseViewHolder(itemView) {

    companion object {
        const val VIEW_TYPE = 1
        fun newInstance(
            parent: ViewGroup,
            initRecycler: (assignAdapter: AssignAdapter, assign: Assign) -> Unit
        ) = AssignRecyclerViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(
                R.layout.assign_recycler,
                parent,
                false
            ),
            initRecycler
        )
    }

    private val recycler by lazy {
        itemView.findViewById<RecyclerView>(R.id.assign_recycler)
    }

    private val adapter by lazy {
        AssignAdapter {
            addImage(it)
        }
    }

    private fun addImage(assign: Assign) {
        initRecycler(adapter, assign)
    }


    override fun bindItem(generalItem: GeneralItem) {
        recycler.adapter = adapter
        (generalItem as Assign).apply {
            addImage(this)
        }
    }
}