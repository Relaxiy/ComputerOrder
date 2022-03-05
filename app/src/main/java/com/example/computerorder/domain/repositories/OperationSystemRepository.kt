package com.example.computerorder.domain.repositories

import com.example.computerorder.domain.models.OperationSystemData

interface OperationSystemRepository {
    fun getOperationSystems() : List<OperationSystemData>
}