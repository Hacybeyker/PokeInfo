package com.hacybeyker.pokeinfo.domain.usecase

import com.hacybeyker.pokeinfo.domain.entity.PokemonEntity
import com.hacybeyker.pokeinfo.domain.repository.PokemonRepository
import javax.inject.Inject

class PokemonUseCase @Inject constructor(
    private val repository: PokemonRepository
) {

    suspend fun getListPokemon(limit: Int, offset: Int): List<PokemonEntity> {
        return repository.getListPokemon(limit = limit, offset = offset)
    }

    suspend fun getPokemonById(id: Int): PokemonEntity {
        return repository.getPokemonById(id = id)
    }
}
