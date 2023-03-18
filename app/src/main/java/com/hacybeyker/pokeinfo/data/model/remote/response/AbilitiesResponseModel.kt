package com.hacybeyker.pokeinfo.data.model.remote.response

import com.google.gson.annotations.SerializedName

data class AbilitiesResponseModel(
    val ability: AbilityResponseModel,
    @SerializedName("is_hidden")
    val isHidden: Boolean,
    val slot: Int
)

data class AbilityResponseModel(
    val name: String,
    val url: String
)
