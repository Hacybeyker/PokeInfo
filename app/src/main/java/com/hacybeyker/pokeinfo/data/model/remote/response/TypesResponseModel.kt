package com.hacybeyker.pokeinfo.data.model.remote.response

data class TypesResponseModel(
    val slot: Int,
    val type: TypeResponseModel
)

data class TypeResponseModel(
    val name: String,
    val url: String
)
