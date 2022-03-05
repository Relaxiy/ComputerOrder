package com.example.computerorder.domain.useCases

import com.example.computerorder.domain.models.GraphicCard

interface GraphicCardUseCase {
    fun getGraphicCards(): List<GraphicCard>
}