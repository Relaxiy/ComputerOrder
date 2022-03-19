package com.example.recycler.domain.useCases

import com.example.recycler.domain.models.Description
import com.example.recycler.domain.models.TodoItem
import com.example.recycler.domain.repositoryes.DescriptionAndTodoRepository

class DescriptionAndTodoUseCaseImpl(
    private val descriptionAndTodoRepository: DescriptionAndTodoRepository
) : DescriptionAndTodoUseCase {

    override suspend fun getDescriptions(): List<Description> {
        return descriptionAndTodoRepository.getDescriptionAndTodo().map { descriptionAndTodoData ->
            Description(
                description = descriptionAndTodoData.description
            )
        }
    }

    override suspend fun getTodoItems(): List<TodoItem> {
        return descriptionAndTodoRepository.getDescriptionAndTodo().map { descriptionAndTodoData ->
            TodoItem(
                radioButtonFirstText = descriptionAndTodoData.radioButtonFirstText,
                radioButtonSecondText = descriptionAndTodoData.radioButtonSecondText
            )
        }
    }

}