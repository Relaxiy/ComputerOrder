package com.example.recycler.domain.repositoryes

import com.example.recycler.data.models.AssignAndAttachmentsData

interface AssignAndAttachmentsRepository {
    suspend fun getAssignAndAttachment(): List<AssignAndAttachmentsData>
}