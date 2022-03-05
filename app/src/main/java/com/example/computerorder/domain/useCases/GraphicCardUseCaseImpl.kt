package com.example.computerorder.domain.useCases

import com.example.computerorder.domain.models.GraphicCard
import com.example.computerorder.domain.repositories.GraphicCardRepository

class GraphicCardUseCaseImpl(private val graphicCardRepository: GraphicCardRepository) : GraphicCardUseCase {
    override fun getGraphicCards(): List<GraphicCard> {
        return graphicCardRepository.getGraphicCards().map { graphicCardData ->
            GraphicCard(
                graphicCardTitle = graphicCardData.graphicCardTitle
            )
        }
    }
}