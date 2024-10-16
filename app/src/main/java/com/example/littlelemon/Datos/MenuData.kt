package com.example.littlelemon.Datos


import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    val menu: List<MenuItemNetwork>
)

@Serializable
data class MenuItemNetwork(
    val title: String,
    val description: String,
    val price: String,
    val image: String,
)

