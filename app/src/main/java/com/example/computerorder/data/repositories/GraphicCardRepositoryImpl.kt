package com.example.computerorder.data.repositories

import com.example.computerorder.data.RetrofitInstance
import com.example.computerorder.data.api.GraphicCardApi
import com.example.computerorder.domain.models.GraphicCard
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class GraphicCardRepositoryImpl : GraphicCardApi {
    override suspend fun getGraphicCards(): Single<List<GraphicCard>> {
        return RetrofitInstance.graphicCardApi.getGraphicCards()
            .subscribeOn(Schedulers.io())
    }


}