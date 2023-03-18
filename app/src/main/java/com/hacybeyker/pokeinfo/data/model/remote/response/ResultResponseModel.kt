package com.hacybeyker.pokeinfo.data.model.remote.response

import com.google.gson.annotations.SerializedName
import com.hacybeyker.pokeinfo.domain.entity.PokemonEntity
import com.hacybeyker.pokeinfo.utils.obtainIdByUrl

data class ResultResponseModel(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)

fun ResultResponseModel.toPokemonEntity(): PokemonEntity {
    return PokemonEntity(
        id = url.obtainIdByUrl(),
        name = name,
        image = url
    )
}
