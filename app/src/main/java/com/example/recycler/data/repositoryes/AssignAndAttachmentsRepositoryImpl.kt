package com.example.recycler.data.repositoryes

import com.example.recycler.R
import com.example.recycler.data.models.AssignAndAttachmentsData
import com.example.recycler.domain.repositoryes.AssignAndAttachmentsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object AssignAndAttachmentsRepositoryImpl : AssignAndAttachmentsRepository {

    private val items = listOf(
        AssignAndAttachmentsData(
            assignImage = R.drawable.ic_add_image,
            attachmentImage = R.drawable.ic_wallet,
            imageName = "image"
        )
    )

    override suspend fun getAssignAndAttachment(): List<AssignAndAttachmentsData> {
        return withContext(Dispatchers.IO){
            return@withContext items
        }
    }
}