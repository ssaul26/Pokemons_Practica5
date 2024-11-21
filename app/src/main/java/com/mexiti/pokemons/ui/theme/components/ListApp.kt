package com.mexiti.pokemons.ui.theme.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.mexiti.pokemons.model.Pokemon
import com.mexiti.pokemons.sealed.DataState
import com.mexiti.pokemons.viewmodel.MainViewModel

@Composable
fun SetData(viewModel: MainViewModel){
    when( val result = viewModel.response.value){
        is DataState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                CircularProgressIndicator()
            }
        }
        is DataState.Success -> {
            ShowLazyList(pokemons = result.data)
        }
        is DataState.Failure -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = result.message,
                    fontSize = 34.sp
                )

            }
        }
        else ->{
            Box(
                modifier =  Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "Error Fetching Data",
                    fontSize = 34.sp
                )
            }
        }


    }
}

@Composable
fun ShowLazyList(pokemons: MutableList<Pokemon>) {
    LazyColumn {
        items(pokemons) { pokemon ->
            PokemonCard(pokemon = pokemon)
        }
    }
}
