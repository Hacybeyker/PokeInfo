package com.hacybeyker.pokeinfo.data.model.remote.response

import com.google.gson.annotations.SerializedName

data class StatsResponseModel(
    @SerializedName("base_stat")
    val baseStat: Int,
    @SerializedName("effort")
    val effort: Int,
    @SerializedName("stat")
    val stat: StatResponseModel
)

data class StatResponseModel(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)
