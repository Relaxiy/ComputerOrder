package com.example.computerorder.domain

import com.example.computerorder.domain.models.GraphicCard
import com.example.computerorder.domain.models.Monitor
import com.example.computerorder.domain.models.OperationSystem

interface GeneralInteractor {
    suspend fun getGraphicCards(): List<GraphicCard>
    suspend fun getMonitors(): List<Monitor>
    suspend fun getOperationSystems(): List<OperationSystem>
}