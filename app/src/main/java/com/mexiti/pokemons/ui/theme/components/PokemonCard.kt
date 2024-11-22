package com.mexiti.pokemons.ui.theme.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.mexiti.pokemons.model.Pokemon


@Composable
fun PokemonCards(pokemon: Pokemon) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(15.dp))
            TextPokemon(label = "Nombre", title = pokemon.Nombre)
            Spacer(modifier = Modifier.height(15.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = pokemon.Imagen,
                    contentDescription = pokemon.Nombre,
                    modifier = Modifier.size(300.dp)
                )
            }
            Spacer(modifier = Modifier.height(22.dp))
            TextPokemon(label = "Tipo", title = pokemon.Tipo)
            Spacer(modifier = Modifier.height(22.dp))
            TextPokemon(label = "Número Pokédex", title = pokemon.NumerodePoquedex?.toString())
        }
    }
}
