package com.example.recycler.domain.useCases

import com.example.recycler.domain.models.Description
import com.example.recycler.domain.models.TodoItem
import com.example.recycler.domain.repositoryes.DescriptionAndTodoRepository

class DescriptionAndTodoUseCaseImpl(
    private val descriptionAndTodoRepository: DescriptionAndTodoRepository
) : DescriptionAndTodoUseCase {
    override suspend fun getDescriptions(): List<Description> {
        TODO("Not yet implemented")
    }

    override suspend fun getTodoItems(): List<TodoItem> {
        TODO("Not yet implemented")
    }

}