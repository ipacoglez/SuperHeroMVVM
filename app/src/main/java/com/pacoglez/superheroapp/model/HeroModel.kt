package com.pacoglez.superheroapp.model

data class HeroModel (
    val id: Int,
    val name: String,
    val slug: String,
    val images: Images
)

data class Images(
    val xs: String,
    val sm: String,
    val md: String,
    val lg: String
)