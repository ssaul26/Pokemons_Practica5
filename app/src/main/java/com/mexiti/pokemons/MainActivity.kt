    package com.mexiti.pokemons

    import android.os.Bundle
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.activity.viewModels
    import androidx.compose.foundation.background
    import androidx.compose.foundation.layout.Column
    import androidx.compose.material3.ExperimentalMaterial3Api
    import androidx.compose.material3.Text
    import androidx.compose.material3.TopAppBar
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.graphics.Color
    import com.mexiti.pokemons.ui.theme.components.SetData
    import com.mexiti.pokemons.ui.theme.theme.PokemonsTheme
    import com.mexiti.pokemons.viewmodel.MainViewModel

    class MainActivity : ComponentActivity() {
        private val ViewModel: MainViewModel by viewModels()
        @OptIn(ExperimentalMaterial3Api::class)
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                PokemonsTheme() {
                    // A surface container using the 'background' color from the theme
                    Column {
                        TopAppBar(title = {
                            Text(text = "Pokemons")
                        },
                            Modifier.background(Color.Cyan))
                        SetData(viewModel = ViewModel)
                    }
                }
            }
        }
    }
