package com.hacybeyker.pokeinfo.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _listPokemon: MutableList<Pokemon> by lazy { arrayListOf() }
    val listPokemon: MutableList<Pokemon> get() = _listPokemon

    fun getListPokemon() {
        viewModelScope.launch(Dispatchers.IO) {
            _listPokemon.addAll(
                arrayListOf(
                    Pokemon(1, "Pikachu", "Electrico"),
                    Pokemon(2, "Charmander", "Fuego"),
                    Pokemon(3, "bulbasur", "Hierva")
                )
            )
        }
    }
}

data class Pokemon(
    val id: Int,
    val name: String,
    val type: String
)
