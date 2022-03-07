package com.example.computerorder.domain.useCases

import com.example.computerorder.domain.models.GraphicCard

interface GraphicCardUseCase {
    suspend fun getGraphicCards(): List<GraphicCard>
}