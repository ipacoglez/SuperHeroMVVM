package com.pacoglez.superheroapp.model

import com.google.gson.annotations.SerializedName

data class HeroModel (
    val id: Int,
    val name: String,
    val slug: String,
    val images: Images,
    @SerializedName("powerstats")
    val powerStats: PowerStats,
    val biography: Biography,
    val appearance: Appearance,
    val work: Work,
    val connections: Connections
)

data class Images(
    val xs: String,
    val sm: String,
    val md: String,
    val lg: String
)

data class PowerStats(
    val intelligence: Int,
    val strength: Int,
    val speed: Int,
    val durability: Int,
    val power: Int,
    val combat: Int
)

data class Biography(
    val fullName: String,
    val alterEgos: String,
    val aliases: List<String>,
    val placeOfBirth: String,
    val firstAppearance: String,
    val publisher: String,
    val alignment: String
)

data class Appearance(
    val gender: String,
    val race: String,
    val height: List<String>,
    val weight: List<String>,
    val eyeColor: String,
    val hairColor: String
)

data class Work(
    val occupation: String,
    val base: String
)

data class Connections(
    val groupAffiliation: String,
    val relatives: String
)
