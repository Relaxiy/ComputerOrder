package com.example.computerorder.domain.useCases

import com.example.computerorder.domain.models.OperationSystem
import com.example.computerorder.domain.repositories.OperationSystemRepository

class OperationSystemUseCaseImpl(private val operationSystemRepository: OperationSystemRepository) : OperationSystemUseCase{
    override fun getOperationSystems(): List<OperationSystem> {
        return operationSystemRepository.getOperationSystems().map { operationSystemData ->
            OperationSystem(
                operationSystemTitle = operationSystemData.operationSystemTitle
            )
        }
    }
}