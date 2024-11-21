package com.mexiti.pokemons.sealed

import com.mexiti.pokemons.model.Pokemon

sealed class DataState {
    class Success(val data: MutableList<Pokemon>) : DataState()
    class Failure(val message: String) : DataState()
    data object Loading : DataState()
    data object Empty : DataState()
}