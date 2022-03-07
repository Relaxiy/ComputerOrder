package com.example.computerorder.domain.useCases

import com.example.computerorder.domain.models.Monitor

interface MonitorUseCase {
    suspend fun getMonitors(): List<Monitor>
}