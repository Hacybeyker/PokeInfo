package com.hacybeyker.pokeinfo.data.model.remote.response

import com.google.gson.annotations.SerializedName

data class SpriteResponseModel(
    @SerializedName("back_default")
    val imageBack: String,
    @SerializedName("front_default")
    val imageFront: String
)
