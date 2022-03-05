package com.example.computerorder.domain.repositories

import com.example.computerorder.domain.models.GraphicCardData

interface GraphicCardRepository {
    fun getGraphicCards(): List<GraphicCardData>
}