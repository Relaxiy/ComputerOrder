package com.example.computerorder.data.api

import com.example.computerorder.domain.models.Monitor
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface MonitorApi {

    @GET("./getMonitors")
    @Headers("Content-Type: application/json")
    fun getMonitors(): Single<List<Monitor>>
}