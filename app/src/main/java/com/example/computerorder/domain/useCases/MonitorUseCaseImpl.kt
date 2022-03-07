package com.example.computerorder.domain.useCases

import com.example.computerorder.data.api.MonitorApi
import com.example.computerorder.domain.models.Monitor

class MonitorUseCaseImpl(private val monitorApi: MonitorApi) : MonitorUseCase{
    override suspend fun getMonitors(): List<Monitor> {
        return monitorApi.getMonitors().blockingGet().map { monitor ->
            Monitor(
                monitorTitle = monitor.monitorTitle
            )
        }
    }
}