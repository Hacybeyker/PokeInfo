package com.hacybeyker.pokeinfo.data.datasource

import com.hacybeyker.pokeinfo.domain.entity.PokemonEntity

interface PokemonDataSource {
    suspend fun getListPokemon(limit: Int, offset: Int): List<PokemonEntity>
    suspend fun getPokemonById(id: Int): PokemonEntity
}
