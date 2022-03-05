package com.example.computerorder.domain.useCases

import com.example.computerorder.domain.models.Monitor
import com.example.computerorder.domain.repositories.MonitorsRepository

class MonitorUseCaseImpl(private val monitorsRepository: MonitorsRepository) : MonitorUseCase{
    override fun getMonitors(): List<Monitor> {
        return monitorsRepository.getMonitors().map { monitorData ->
            Monitor(
                monitorTitle = monitorData.monitorTitle
            )
        }
    }
}