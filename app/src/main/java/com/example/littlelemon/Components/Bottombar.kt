package com.example.littlelemon.Components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavController
import com.example.littlelemon.Graphs.Destinations
import com.example.littlelemon.Graphs.Home
import com.example.littlelemon.Graphs.Profile
import com.example.littlelemon.ui.theme.LittleLemonColors

@Composable
fun Bottombar(navController: NavController){
    val destinationsList = listOf<Destinations>(Home, Profile)
    val SelectedIndex = rememberSaveable{ mutableStateOf(0) }

    BottomNavigation(
        backgroundColor = LittleLemonColors.Prymary
    ) {
        destinationsList.forEachIndexed { index, destinations ->
            BottomNavigationItem(
                label = { Text(text = destinations.title) },
                selected = index == SelectedIndex.value,
                onClick = {
                    SelectedIndex.value == index
                    navController.navigate(destinationsList[index].route){
                        popUpTo(Home.route)
                        launchSingleTop = true
                    }

                },
                icon = { Icon(imageVector = destinations.icon, contentDescription = destinations.title , tint = LittleLemonColors.Blanco) }
            )
        }
    }
}
