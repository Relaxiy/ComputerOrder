package com.example.recycler.domain.useCases

import com.example.recycler.domain.models.Assign
import com.example.recycler.domain.models.Attachment

interface AssignAndAttachmentsUseCase {

    suspend fun getAssigns(): List<Assign>
    suspend fun getAttachments(): List<Attachment>
}