package com.tapmobile.merchandsetest.entities

import com.squareup.moshi.Json

data class MerchandiseList(
    @field:Json(name = "merchandises")
    val merchandises: List<Merchandise>,
)

data class Merchandise(
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "price")
    val price: String,
    @field:Json(name = "photos")
    val photos: List<String>
)
