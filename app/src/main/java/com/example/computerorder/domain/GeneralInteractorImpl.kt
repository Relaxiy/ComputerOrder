package com.example.computerorder.domain

import com.example.computerorder.domain.models.GraphicCard
import com.example.computerorder.domain.models.Monitor
import com.example.computerorder.domain.models.OperationSystem
import com.example.computerorder.domain.useCases.GraphicCardUseCase
import com.example.computerorder.domain.useCases.MonitorUseCase
import com.example.computerorder.domain.useCases.OperationSystemUseCase

class GeneralInteractorImpl(
    private val graphicCardUseCase: GraphicCardUseCase,
    private val monitorUseCase: MonitorUseCase,
    private val operationSystemUseCase: OperationSystemUseCase
) : GeneralInteractor {
    override suspend fun getGraphicCards(): List<GraphicCard> {
        return graphicCardUseCase.getGraphicCards()
    }

    override suspend fun getMonitors(): List<Monitor> {
        return monitorUseCase.getMonitors()
    }

    override suspend fun getOperationSystems(): List<OperationSystem> {
        return operationSystemUseCase.getOperationSystems()
    }
}