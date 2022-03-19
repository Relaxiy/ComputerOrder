package com.example.recycler.data.repositoryes

import com.example.recycler.R
import com.example.recycler.data.models.AssignAndAttachmentsData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object AssignAndAttachmentsRepository {

    private val items = listOf(
        AssignAndAttachmentsData(
            assignImage = R.drawable.ic_add_image,
            attachmentImage = R.drawable.ic_wallet,
            imageName = "image"
        )
    )

    suspend fun getAssignAndAttachment(): List<AssignAndAttachmentsData> {
        return withContext(Dispatchers.IO) {
            return@withContext items
        }
    }
}