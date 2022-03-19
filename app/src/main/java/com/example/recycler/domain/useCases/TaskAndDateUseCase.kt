package com.example.recycler.domain.useCases

import com.example.recycler.domain.models.Date
import com.example.recycler.domain.models.Task

interface TaskAndDateUseCase {

    suspend fun getTasks(): List<Task>
    suspend fun getDates(): List<Date>
}