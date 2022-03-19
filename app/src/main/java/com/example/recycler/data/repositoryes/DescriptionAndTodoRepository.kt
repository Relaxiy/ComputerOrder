package com.example.recycler.data.repositoryes

import com.example.recycler.data.models.DescriptionAndTodoData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object DescriptionAndTodoRepository {

    private val items = listOf(
        DescriptionAndTodoData(
            description = "I find you in my repository on GitHub. Why you see that?",
            radioButtonFirstText = "Toast",
            radioButtonSecondText = "SnackBar"
        )
    )

    suspend fun getDescriptionAndTodo(): List<DescriptionAndTodoData> {
        return withContext(Dispatchers.IO) {
            return@withContext items
        }
    }
}