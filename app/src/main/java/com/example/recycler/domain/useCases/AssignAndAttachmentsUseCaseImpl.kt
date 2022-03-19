package com.example.recycler.domain.useCases

import com.example.recycler.domain.models.Assign
import com.example.recycler.domain.models.Attachment
import com.example.recycler.domain.repositoryes.AssignAndAttachmentsRepository

class AssignAndAttachmentsUseCaseImpl(
    private val assignAndAttachmentsRepository: AssignAndAttachmentsRepository
) : AssignAndAttachmentsUseCase {
    override suspend fun getAssigns(): List<Assign> {
        TODO("Not yet implemented")
    }

    override suspend fun getAttachments(): List<Attachment> {
        TODO("Not yet implemented")
    }


}