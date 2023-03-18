package com.hacybeyker.pokeinfo.data.api

import com.hacybeyker.pokeinfo.data.model.remote.response.BaseResponseModel
import com.hacybeyker.pokeinfo.data.model.remote.response.PokemonResponseModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {

    @GET("pokemon")
    suspend fun getListPokemon(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): BaseResponseModel

    @GET("pokemon/{id}")
    suspend fun getPokemonById(
        @Path(value = "id") id: Int
    ): PokemonResponseModel
}
