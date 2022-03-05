package com.example.computerorder.data.repositories

import com.example.computerorder.domain.models.OperationSystemData
import com.example.computerorder.domain.repositories.OperationSystemRepository

class OperationSystemRepositoryImpl : OperationSystemRepository {

    private val operationSystems: List<OperationSystemData> = OperationSystemData.values().asList()
    override fun getOperationSystems(): List<OperationSystemData> {
        return operationSystems
    }
}