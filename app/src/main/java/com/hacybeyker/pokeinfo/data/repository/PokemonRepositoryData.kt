package com.hacybeyker.pokeinfo.data.repository

import com.hacybeyker.pokeinfo.data.datasource.PokemonDataSource
import com.hacybeyker.pokeinfo.domain.entity.PokemonEntity
import com.hacybeyker.pokeinfo.domain.repository.PokemonRepository
import javax.inject.Inject

class PokemonRepositoryData @Inject constructor(
    private val dataSource: PokemonDataSource
) : PokemonRepository {
    override suspend fun getListPokemon(limit: Int, offset: Int): List<PokemonEntity> {
        return dataSource.getListPokemon(limit = limit, offset = offset)
    }

    override suspend fun getPokemonById(id: Int): PokemonEntity {
        return dataSource.getPokemonById(id = id)
    }
}
