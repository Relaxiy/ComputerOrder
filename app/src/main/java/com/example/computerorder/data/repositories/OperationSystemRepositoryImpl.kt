package com.example.computerorder.data.repositories

import com.example.computerorder.data.RetrofitInstance
import com.example.computerorder.data.api.OperationSystemApi
import com.example.computerorder.domain.models.OperationSystem
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class OperationSystemRepositoryImpl : OperationSystemApi {
    override suspend fun getOperationSystems(): Single<List<OperationSystem>> {
        return RetrofitInstance.operationSystemApi.getOperationSystems()
            .subscribeOn(Schedulers.io())
    }

}