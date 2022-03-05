package com.example.computerorder.domain.useCases

import com.example.computerorder.domain.models.Monitor

interface MonitorUseCase {
    fun getMonitors(): List<Monitor>
}