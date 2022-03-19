package com.example.recycler.data.repositoryes

import com.example.recycler.data.models.DescriptionAndTodoData
import com.example.recycler.domain.repositoryes.DescriptionAndTodoRepository

object DescriptionAndTodoRepositoryImpl : DescriptionAndTodoRepository {

    private val items = listOf(
        DescriptionAndTodoData(
            description = "I find you in my repository on GitHub. Why you see that?",
            radioButtonFirstText = "Toast",
            radioButtonSecondText = "SnackBar"
        )
    )

    override suspend fun getDescriptionAndTodo(): List<DescriptionAndTodoData> {
        return items
    }
}