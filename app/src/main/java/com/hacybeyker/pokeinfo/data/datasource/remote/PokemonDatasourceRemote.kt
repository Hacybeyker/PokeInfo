package com.hacybeyker.pokeinfo.data.datasource.remote

import com.hacybeyker.pokeinfo.data.api.PokemonApi
import com.hacybeyker.pokeinfo.data.datasource.PokemonDataSource
import com.hacybeyker.pokeinfo.data.model.remote.response.toPokemonEntity
import com.hacybeyker.pokeinfo.domain.entity.PokemonEntity
import javax.inject.Inject

class PokemonDatasourceRemote @Inject constructor(
    private val api: PokemonApi
) : PokemonDataSource {

    override suspend fun getListPokemon(limit: Int, offset: Int): List<PokemonEntity> {
//        return api.getListPokemon(limit = limit, offset = offset)
//            .results.map { result -> getPokemonById(result.url.obtainIdByUrl()) }

        val result = api.getListPokemon(limit = limit, offset = offset)
        return result.results.map { pokemon -> pokemon.toPokemonEntity() }

//        coroutineScope {
//            val deferreds = listOf(     // fetch two docs at the same time
//                async { fetchDoc(1) },  // async returns a result for the first doc
//                async { fetchDoc(2) }   // async returns a result for the second doc
//            )
//            deferreds.awaitAll()        // use awaitAll to wait for both network requests
//        }
    }

    override suspend fun getPokemonById(id: Int): PokemonEntity {
        return api.getPokemonById(id = id).toPokemonEntity()
    }
}
