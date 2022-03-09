package com.example.computerorder.data.api

import com.example.computerorder.domain.models.GraphicCard
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface GraphicCardApi {

    @GET("./getGraphicCards")
    @Headers("Content-Type: application/json")
    suspend fun getGraphicCards(): Single<List<GraphicCard>>
}