package com.example.recycler.domain.useCases

import com.example.recycler.domain.models.Date
import com.example.recycler.domain.models.Task
import com.example.recycler.domain.repositoryes.TaskAndDateRepository

class TaskAndDateUseCaseImpl(
    private val titleAndDateRepository: TaskAndDateRepository
) : TaskAndDateUseCase {

    override suspend fun getTasks(): List<Task> {
        return titleAndDateRepository.getTitleAndDate().map { taskAndDateData ->
            Task(
                task = taskAndDateData.task
            )
        }
    }

    override suspend fun getDates(): List<Date> {
        return titleAndDateRepository.getTitleAndDate().map { taskAndDateData ->
            Date(
                day = taskAndDateData.day,
                hours = taskAndDateData.hours
            )
        }
    }


}