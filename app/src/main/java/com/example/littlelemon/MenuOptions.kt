package com.example.littlelemon

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.Components.Bottombar
import com.example.littlelemon.Graphs.Home
import com.example.littlelemon.Graphs.Profile
import com.example.littlelemon.Screens.HomeScreen
import com.example.littlelemon.Screens.ProfileScreen
import com.example.littlelemon.ui.theme.LittleLemonTheme
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


class MenuOptions : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val intent = getIntent()
        val firsName = intent.getStringExtra("firsName")
        val lastName = intent.getStringExtra("lastName")
        val email = intent.getStringExtra("email")




        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = { Bottombar(navController = navController)}
                ) {
                    Box(modifier = Modifier.padding(it)){
                        NavHost(navController = navController, startDestination = Home.route){
                            composable(Home.route){
                                HomeScreen()
                            }
                            composable(Profile.route){
                                ProfileScreen( firsName, lastName, email) { logOutIntent() }
                            }
                        }
                    }
                }

            }
        }
    }
    private fun logOutIntent(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}





