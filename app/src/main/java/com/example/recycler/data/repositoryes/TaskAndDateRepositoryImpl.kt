package com.example.recycler.data.repositoryes

import com.example.recycler.data.models.TaskAndDateData
import com.example.recycler.domain.repositoryes.TaskAndDateRepository

object TaskAndDateRepositoryImpl : TaskAndDateRepository {

    private val items = listOf(
        TaskAndDateData(
            task = "hello? hello! I see you? I see you!",
            day = "Today",
            hours = "12:05"
        )
    )

    override suspend fun getTitleAndDate(): List<TaskAndDateData> {
        return items
    }
}