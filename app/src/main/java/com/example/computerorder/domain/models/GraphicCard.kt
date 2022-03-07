package com.example.computerorder.domain.models

import com.google.gson.annotations.SerializedName

data class GraphicCard(
    @SerializedName("graphicCard")
    val graphicCardTitle: String
)