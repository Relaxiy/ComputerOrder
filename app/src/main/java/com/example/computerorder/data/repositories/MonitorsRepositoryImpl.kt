package com.example.computerorder.data.repositories

import com.example.computerorder.domain.models.MonitorData
import com.example.computerorder.domain.repositories.MonitorsRepository

class MonitorsRepositoryImpl : MonitorsRepository {

    private val monitors: List<MonitorData> = MonitorData.values().asList()
    override fun getMonitors(): List<MonitorData> {
        return monitors
    }
}