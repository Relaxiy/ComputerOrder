package com.example.recycler.domain.useCases

import com.example.recycler.domain.models.Date
import com.example.recycler.domain.models.Task
import com.example.recycler.domain.repositoryes.TaskAndDateRepository

class TaskAndDateUseCaseImpl(
    private val titleAndDateRepository: TaskAndDateRepository
) : TaskAndDateUseCase {
    override suspend fun getTasks(): List<Task> {
        TODO("Not yet implemented")
    }

    override suspend fun getDates(): List<Date> {
        TODO("Not yet implemented")
    }


}