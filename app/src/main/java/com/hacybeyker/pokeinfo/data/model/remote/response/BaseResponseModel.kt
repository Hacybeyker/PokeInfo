package com.hacybeyker.pokeinfo.data.model.remote.response

import com.google.gson.annotations.SerializedName

data class BaseResponseModel(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: String? = null,
    @SerializedName("results")
    val results: List<ResultResponseModel>
)
