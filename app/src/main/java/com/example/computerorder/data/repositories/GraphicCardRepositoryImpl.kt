package com.example.computerorder.data.repositories

import com.example.computerorder.domain.models.GraphicCardData
import com.example.computerorder.domain.repositories.GraphicCardRepository

class GraphicCardRepositoryImpl : GraphicCardRepository {

    private val graphicCards: List<GraphicCardData> = GraphicCardData.values().asList()
    override fun getGraphicCards(): List<GraphicCardData> {
        return graphicCards
    }
}