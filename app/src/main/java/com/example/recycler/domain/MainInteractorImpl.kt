package com.example.recycler.domain

import com.example.recycler.domain.models.GeneralItem
import com.example.recycler.domain.useCases.AssignAndAttachmentsUseCase
import com.example.recycler.domain.useCases.DescriptionAndTodoUseCase
import com.example.recycler.domain.useCases.TaskAndDateUseCase

class MainInteractorImpl(
    private val assignAndAttachmentsUseCase: AssignAndAttachmentsUseCase,
    private val descriptionAndTodoUseCase: DescriptionAndTodoUseCase,
    private val taskAndDateUseCase: TaskAndDateUseCase
) : MainInteractor {

    override suspend fun getItems(): List<GeneralItem> {
        val items: MutableList<GeneralItem> = mutableListOf()
        items.addAll(taskAndDateUseCase.getTasks())
        items.addAll(taskAndDateUseCase.getDates())
        items.addAll(descriptionAndTodoUseCase.getDescriptions())
        items.addAll(descriptionAndTodoUseCase.getTodoItems())
        items.addAll(assignAndAttachmentsUseCase.getAssigns())
        items.addAll(assignAndAttachmentsUseCase.getAttachments())
        return items.toList()
    }
}