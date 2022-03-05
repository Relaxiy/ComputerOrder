package com.example.computerorder.domain.repositories

import com.example.computerorder.domain.models.MonitorData

interface MonitorsRepository {
    fun getMonitors(): List<MonitorData>
}