package com.example.recycler.domain.repositoryes

import com.example.recycler.data.models.DescriptionAndTodoData

interface DescriptionAndTodoRepository {

    suspend fun getDescriptionAndTodo(): List<DescriptionAndTodoData>
}