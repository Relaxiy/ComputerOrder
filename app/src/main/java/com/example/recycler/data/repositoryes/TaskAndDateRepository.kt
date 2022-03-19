package com.example.recycler.data.repositoryes

import com.example.recycler.data.models.TaskAndDateData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object TaskAndDateRepository {

    private val items = listOf(
        TaskAndDateData(
            task = "hello? hello! I see you? I see you!",
            day = "Today",
            hours = "12:05"
        ),
        TaskAndDateData(
            task = "hello? hello! I see you? I see you!",
            day = "Today",
            hours = "12:05"
        )
    )

    suspend fun getTitleAndDate(): List<TaskAndDateData> {
        return withContext(Dispatchers.IO) {
            return@withContext items
        }
    }
}