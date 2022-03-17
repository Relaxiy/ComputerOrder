package com.example.recycler.reycler.viewHolders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler.R
import com.example.recycler.models.Assign
import com.example.recycler.models.GeneralItem
import com.example.recycler.reycler.BaseViewHolder
import com.example.recycler.reycler.assignRecycler.AssignAdapter
import com.example.recycler.viewModel.AssignViewModel

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

    private fun addImage(assign: Assign) {
        initRecycler(adapter, assign)
    }

    private val recycler by lazy {
        itemView.findViewById<RecyclerView>(R.id.assign_recycler)
    }

    private val adapter by lazy {
        AssignAdapter {
            addImage(it)
        }
    }

    override fun bindItem(generalItem: GeneralItem) {
        recycler.adapter = adapter
        (generalItem as Assign).apply {
            addImage(this)
        }
    }
}