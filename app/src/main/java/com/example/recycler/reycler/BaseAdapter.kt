package com.example.recycler.reycler

import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler.models.*
import com.example.recycler.reycler.viewHolders.*
import java.lang.IllegalStateException

class BaseAdapter(private val activity: FragmentActivity) : RecyclerView.Adapter<BaseViewHolder>() {
    private var items = listOf<GeneralItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            TaskViewHolder.VIEW_TYPE -> TaskViewHolder.newInstance(parent)
            DateViewHolder.VIEW_TYPE -> DateViewHolder.newInstance(parent)
            DescriptionViewHolder.VIEW_TYPE -> DescriptionViewHolder.newInstance(parent)
            RadioButtonViewHolder.VIEW_TYPE -> RadioButtonViewHolder.newInstance(parent)
            AssignRecyclerViewHolder.VIEW_TYPE -> AssignRecyclerViewHolder.newInstance(parent, activity)
            AttachmentsViewHolder.VIEW_TYPE -> AttachmentsViewHolder.newInstance(parent)
            else -> throw IllegalStateException("Wrong ViewHolder type")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is Task -> TaskViewHolder.VIEW_TYPE
            is Date -> DateViewHolder.VIEW_TYPE
            is Description -> DescriptionViewHolder.VIEW_TYPE
            is TodoItem -> RadioButtonViewHolder.VIEW_TYPE
            is Assign -> AssignRecyclerViewHolder.VIEW_TYPE
            is Attachment -> AttachmentsViewHolder.VIEW_TYPE
            else -> 0
        }
    }

    fun setItems(data: List<GeneralItem>) {
        items = data
        notifyDataSetChanged()
    }
}