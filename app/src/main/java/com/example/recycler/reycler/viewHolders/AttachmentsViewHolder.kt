package com.example.recycler.reycler.viewHolders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.recycler.R
import com.example.recycler.models.Attachment
import com.example.recycler.models.GeneralItem
import com.example.recycler.reycler.BaseViewHolder

class AttachmentsViewHolder(itemView: View) : BaseViewHolder(itemView) {

    companion object {
        const val VIEW_TYPE = 2
        fun newInstance(parent: ViewGroup) = AttachmentsViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(
                R.layout.attachment_item,
                parent,
                false
            )
        )
    }

    private val attachmentImage by lazy {
        itemView.findViewById<ImageView>(R.id.attachment_image)
    }

    private val attachmentText by lazy {
        itemView.findViewById<TextView>(R.id.image_text)
    }
    override fun bindItem(generalItem: GeneralItem) {
        (generalItem as Attachment).apply {
            attachmentImage.setImageResource(imageId)
            attachmentText.text = imageName
        }
    }
}