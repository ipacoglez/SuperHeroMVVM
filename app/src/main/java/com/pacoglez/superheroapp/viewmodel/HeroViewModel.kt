package com.pacoglez.superheroapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pacoglez.superheroapp.model.HeroModel
import com.pacoglez.superheroapp.network.heroServices
import kotlinx.coroutines.launch
import java.lang.Exception

class HeroViewModel : ViewModel() {

    val heroes = MutableLiveData<List<HeroModel>>()
    val message = MutableLiveData<String?>()

    private val _itemSelected = MutableLiveData<HeroModel>()
    var itemDataSelected: HeroModel? = null

    lateinit var observerOnCategorySelected: Observer<HeroModel>

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

        initObserver()
    }

    private fun initObserver(){
        observerOnCategorySelected = Observer {
            it.let {
                _itemSelected.value = it
            }
        }
    }

    fun setItemSelection(item: HeroModel){
        itemDataSelected = item
    }
}