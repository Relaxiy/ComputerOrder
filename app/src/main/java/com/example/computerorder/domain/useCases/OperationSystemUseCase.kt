package com.example.computerorder.domain.useCases

import com.example.computerorder.domain.models.OperationSystem

interface OperationSystemUseCase {
    fun getOperationSystems(): List<OperationSystem>
}