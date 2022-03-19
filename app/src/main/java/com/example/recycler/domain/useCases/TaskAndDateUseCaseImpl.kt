package com.example.recycler.domain.useCases

import com.example.recycler.data.repositoryes.TaskAndDateRepository
import com.example.recycler.domain.models.Date
import com.example.recycler.domain.models.Task

class TaskAndDateUseCaseImpl(
    private val taskAndDateRepository: TaskAndDateRepository
) : TaskAndDateUseCase {

    override suspend fun getTasks(): List<Task> {
        return taskAndDateRepository.getTitleAndDate().map { taskAndDateData ->
            Task(
                task = taskAndDateData.task
            )
        }
    }

    override suspend fun getDates(): List<Date> {
        return taskAndDateRepository.getTitleAndDate().map { taskAndDateData ->
            Date(
                day = taskAndDateData.day,
                hours = taskAndDateData.hours
            )
        }
    }


}