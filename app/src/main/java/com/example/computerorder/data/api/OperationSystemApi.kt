package com.example.computerorder.data.api

import com.example.computerorder.domain.models.OperationSystem
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface OperationSystemApi {
    @GET("./getOperationSystems")
    @Headers("Content-Type: application/json")
    suspend fun getOperationSystems(): Single<List<OperationSystem>>
}