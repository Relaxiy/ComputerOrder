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
            items.add(taskAndDateUseCase.getTasks()[index])
            items.add(taskAndDateUseCase.getDates()[index])
            items.add(descriptionAndTodoUseCase.getDescriptions()[index])
            items.add(descriptionAndTodoUseCase.getTodoItems()[index])
            items.add(assignAndAttachmentsUseCase.getAssigns()[index])
            items.add(assignAndAttachmentsUseCase.getAttachments()[index])
        }
        return items.toList()
    }
}