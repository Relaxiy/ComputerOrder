package com.example.computerorder.domain.models

import com.google.gson.annotations.SerializedName

data class OperationSystem(
    @SerializedName("operationSystem")
    val operationSystemTitle: String
)