package com.example.computerorder.domain.useCases

import com.example.computerorder.data.api.OperationSystemApi
import com.example.computerorder.domain.models.OperationSystem

class OperationSystemUseCaseImpl(private val operationSystemApi: OperationSystemApi) : OperationSystemUseCase{
    override suspend fun getOperationSystems(): List<OperationSystem> {
        return operationSystemApi.getOperationSystems().blockingGet().map { operationSystem ->
            OperationSystem(
                operationSystemTitle = operationSystem.operationSystemTitle
            )
        }
    }
}