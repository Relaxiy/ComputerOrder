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
        taskAndDateUseCase.getTasks().forEachIndexed { index, _ ->
            items.addAll(index, assignAndAttachmentsUseCase.getAttachments())
            items.addAll(index, assignAndAttachmentsUseCase.getAssigns())
            items.addAll(index, descriptionAndTodoUseCase.getTodoItems())
            items.addAll(index, descriptionAndTodoUseCase.getDescriptions())
            items.addAll(index, taskAndDateUseCase.getDates())
            items.addAll(index, taskAndDateUseCase.getTasks())
        }
        return items.toList()
    }
}