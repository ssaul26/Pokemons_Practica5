package com.mexiti.pokemons.model

data class Pokemon(
    var Imagen: String? = null,  // URL de la imagen del Pokémon
    var Nombre: String? = null,  // Nombre del Pokémon
    var Tipo: String? = null,    // Tipo del Pokémon (ej. Fuego, Agua)
    var NumerodePoquedex: Int? = null   // Número en la Pokédex
)