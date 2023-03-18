package com.hacybeyker.pokeinfo.data.model.remote.response

import com.google.gson.annotations.SerializedName
import com.hacybeyker.pokeinfo.domain.entity.PokemonEntity

data class PokemonResponseModel(
    @SerializedName("abilities")
    val abilities: List<AbilitiesResponseModel>,
    @SerializedName("base_experience")
    val baseExperience: Int,
    @SerializedName("height")
    val height: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("order")
    val order: Int,
    @SerializedName("sprites")
    val sprites: SpriteResponseModel,
    @SerializedName("stats")
    val stats: List<StatsResponseModel>,
    @SerializedName("types")
    val types: List<TypesResponseModel>,
    @SerializedName("weight")
    val weight: Int
)

fun PokemonResponseModel.toPokemonEntity(): PokemonEntity {
    return PokemonEntity(
        id = id,
        name = name,
        // image = sprites.imageFront
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"
    )
}
