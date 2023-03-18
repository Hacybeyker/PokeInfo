package com.hacybeyker.pokeinfo.di.module.app

import com.hacybeyker.pokeinfo.data.api.PokemonApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {
    @Singleton
    @Provides
    fun providePokemonServices(retrofit: Retrofit): PokemonApi {
        return retrofit.create(PokemonApi::class.java)
    }
}
