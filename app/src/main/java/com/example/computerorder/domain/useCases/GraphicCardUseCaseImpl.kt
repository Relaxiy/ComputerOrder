package com.example.computerorder.domain.useCases

import com.example.computerorder.data.api.GraphicCardApi
import com.example.computerorder.domain.models.GraphicCard

class GraphicCardUseCaseImpl(private val graphicCardApi: GraphicCardApi) : GraphicCardUseCase {
    override suspend fun getGraphicCards(): List<GraphicCard> {
        return graphicCardApi.getGraphicCards().blockingGet().map { graphicCard ->
            GraphicCard(
                graphicCardTitle = graphicCard.graphicCardTitle
            )
        }
    }
}