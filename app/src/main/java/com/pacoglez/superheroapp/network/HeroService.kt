package com.pacoglez.superheroapp.network

import com.pacoglez.superheroapp.model.HeroModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://akabab.github.io/superhero-api/api/"

 val heroServices: HeroServices = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(HeroServices::class.java)

interface HeroServices {
    @GET("all.json")
    suspend fun getAllHeroes(): List<HeroModel>
}