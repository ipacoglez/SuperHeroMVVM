package com.pacoglez.superheroapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pacoglez.superheroapp.model.HeroModel
import com.pacoglez.superheroapp.network.heroServices
import kotlinx.coroutines.launch
import java.lang.Exception

class HeroViewModel : ViewModel() {

    val heroes = MutableLiveData<List<HeroModel>>()
    val message = MutableLiveData<String?>()

    init {
        viewModelScope.launch {
            try {
                message.postValue("Loading...")

                val data = heroServices.getAllHeroes()

                heroes.postValue(data)
                message.postValue(null)


            }catch (e: Exception){
                message.postValue("Error de servidor")
            }
        }
    }
}