package com.example.littlelemon.Graphs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector



interface  Destinations{
    val route :String
    val icon : ImageVector
    val title : String
}

object Home: Destinations{
    override val route =  "Home"
    override val icon = Icons.Filled.Home
    override val title = "home"
}

object Profile: Destinations{
    override val route =  "Profile"
    override val icon = Icons.Filled.AccountCircle
    override val title = "profile"
}