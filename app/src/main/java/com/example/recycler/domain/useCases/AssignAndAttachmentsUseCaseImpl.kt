package com.example.recycler.domain.useCases

import com.example.recycler.data.repositoryes.AssignAndAttachmentsRepository
import com.example.recycler.domain.models.Assign
import com.example.recycler.domain.models.Attachment

class AssignAndAttachmentsUseCaseImpl(
    private val assignAndAttachmentsRepository: AssignAndAttachmentsRepository
) : AssignAndAttachmentsUseCase {

    override suspend fun getAssigns(): List<Assign> {
        return assignAndAttachmentsRepository.getAssignAndAttachment()
            .map { assignAndAttachmentsData ->
                Assign(
                    image = assignAndAttachmentsData.assignImage
                )
            }
    }

    override suspend fun getAttachments(): List<Attachment> {
        return assignAndAttachmentsRepository.getAssignAndAttachment()
            .map { assignAndAttachmentsData ->
                Attachment(
                    imageId = assignAndAttachmentsData.attachmentImage,
                    imageName = assignAndAttachmentsData.imageName
                )
            }
    }


}