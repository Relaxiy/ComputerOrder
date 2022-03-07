package com.example.computerorder.domain.models

import com.google.gson.annotations.SerializedName

data class Monitor(
    @SerializedName("monitor")
    val monitorTitle: String
)