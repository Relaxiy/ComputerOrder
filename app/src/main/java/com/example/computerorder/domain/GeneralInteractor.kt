package com.example.computerorder.domain

import com.example.computerorder.domain.models.GraphicCard
import com.example.computerorder.domain.models.Monitor
import com.example.computerorder.domain.models.OperationSystem

interface GeneralInteractor {
    fun getGraphicCards(): List<GraphicCard>
    fun getMonitors(): List<Monitor>
    fun getOperationSystems(): List<OperationSystem>
}