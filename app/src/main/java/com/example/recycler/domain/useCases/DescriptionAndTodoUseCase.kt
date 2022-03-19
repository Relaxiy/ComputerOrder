package com.example.recycler.domain.useCases

import com.example.recycler.domain.models.Description
import com.example.recycler.domain.models.TodoItem

interface DescriptionAndTodoUseCase {

    suspend fun getDescriptions(): List<Description>
    suspend fun getTodoItems(): List<TodoItem>
}