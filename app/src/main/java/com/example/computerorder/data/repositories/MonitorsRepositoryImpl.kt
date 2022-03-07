package com.example.computerorder.data.repositories

import com.example.computerorder.data.RetrofitInstance
import com.example.computerorder.data.api.MonitorApi
import com.example.computerorder.domain.models.Monitor
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class MonitorsRepositoryImpl : MonitorApi {
    override fun getMonitors(): Single<List<Monitor>> {
        return RetrofitInstance.monitorApi.getMonitors()
            .subscribeOn(Schedulers.io())
    }

}