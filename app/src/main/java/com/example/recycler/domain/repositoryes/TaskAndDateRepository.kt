package com.example.recycler.domain.repositoryes

import com.example.recycler.data.models.TaskAndDateData

interface TaskAndDateRepository {

    suspend fun getTitleAndDate(): List<TaskAndDateData>
}