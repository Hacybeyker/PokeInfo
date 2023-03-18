package com.hacybeyker.pokeinfo.di.module.business

import com.hacybeyker.pokeinfo.data.datasource.PokemonDataSource
import com.hacybeyker.pokeinfo.data.datasource.remote.PokemonDatasourceRemote
import com.hacybeyker.pokeinfo.data.repository.PokemonRepositoryData
import com.hacybeyker.pokeinfo.domain.repository.PokemonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class PokemonModule {
    @Binds
    abstract fun bindPokemonDataSource(pokemonDatasourceRemote: PokemonDatasourceRemote): PokemonDataSource

    @Binds
    abstract fun bindPokemonRepository(pokemonRepositoryData: PokemonRepositoryData): PokemonRepository
}
