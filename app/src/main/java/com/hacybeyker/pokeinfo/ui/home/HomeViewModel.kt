package com.hacybeyker.pokeinfo.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hacybeyker.pokeinfo.di.Constants.Api.DEFAULT
import com.hacybeyker.pokeinfo.di.Constants.Api.LIMIT
import com.hacybeyker.pokeinfo.domain.entity.PokemonEntity
import com.hacybeyker.pokeinfo.domain.usecase.PokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: PokemonUseCase
) : ViewModel() {

    private val _search: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val search: LiveData<String> get() = _search

    private val _listPokemon: MutableLiveData<List<PokemonEntity>> by lazy { MutableLiveData<List<PokemonEntity>>() }
    val listPokemon: LiveData<List<PokemonEntity>> get() = _listPokemon

    init {
        getListPokemon()
    }

    fun getListPokemon() {
        viewModelScope.launch(Dispatchers.IO) {
            val data = useCase.getListPokemon(LIMIT, DEFAULT)
            val pokemonAsync = data.map { pokemon ->
                async { useCase.getPokemonById(pokemon.id) }
            }
            _listPokemon.postValue(pokemonAsync.awaitAll())
        }
    }

    fun updateSearch(search: String) {
        _search.postValue(search)
    }

    fun clearSearch() {
        _search.postValue("")
    }
}
