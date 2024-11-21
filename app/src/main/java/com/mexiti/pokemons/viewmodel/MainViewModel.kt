package com.mexiti.pokemons.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.mexiti.pokemons.model.Pokemon
import com.mexiti.pokemons.sealed.DataState


class MainViewModel: ViewModel() {
    private val db = Firebase.firestore //singleton de firebase
    val response: MutableState<DataState> = mutableStateOf(DataState.Empty)

    init {
        fetchDataFromFirebase()
    }

    private fun fetchDataFromFirebase() {
        val tempList = mutableListOf<Pokemon>()
        response.value = DataState.Loading
        db.collection("Pokemons")
            .get()
            .addOnSuccessListener { document ->

                for (dataSnap in document) {

                    val movieItem = dataSnap.toObject(Pokemon::class.java)
                    Log.d("getFirebase", movieItem.Imagen.toString()) //en consola
                    Log.d("getFirebase", movieItem.Nombre.toString())
                    Log.d("getFirebase", movieItem.Tipo.toString())
                    Log.d("getFirebase", movieItem.NumerodePoquedex?.toInt().toString())
                    tempList.add(movieItem)
                }
                response.value = DataState.Success(tempList)


            }.addOnCanceledListener {
                response.value = DataState.Failure(error("Error"))
            }

    }
}

