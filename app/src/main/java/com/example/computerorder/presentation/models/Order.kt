package com.example.computerorder.presentation.models

data class Order(
    val userName: String,
    val phoneNumber: String?,
    val operationSystem: String,
    val graphicCard: String,
    val monitor: String,
    val mouse: String?,
    val keyBoard: String?,
    val webCum: String?
)
