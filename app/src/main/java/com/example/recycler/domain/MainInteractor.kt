package com.example.recycler.domain

import com.example.recycler.domain.models.GeneralItem

interface MainInteractor {

    suspend fun getItems(): List<GeneralItem>
}