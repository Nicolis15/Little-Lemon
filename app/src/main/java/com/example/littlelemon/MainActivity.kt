package com.example.littlelemon

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import com.example.littlelemon.Screens.Onboarding
import com.example.littlelemon.ui.theme.LittleLemonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LittleLemonTheme {
                InitUI()
            }
        }
    }

    @Composable
    fun InitUI() {
        Onboarding(this::intentHomeScreen)
    }

    private fun intentHomeScreen(firstName : String, lastName : String, email : String ){
        val intent = Intent(this, MenuOptions::class.java)
        intent.putExtra("firsName", firstName)
        intent.putExtra("lastName", lastName)
        intent.putExtra("email", email)
        startActivity(intent)
    }
}

