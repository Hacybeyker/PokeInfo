package com.hacybeyker.pokeinfo.domain.repository

import com.hacybeyker.pokeinfo.domain.entity.PokemonEntity

interface PokemonRepository {
    suspend fun getListPokemon(limit: Int, offset: Int): List<PokemonEntity>
    suspend fun getPokemonById(id: Int): PokemonEntity
}
