package com.example.littlelemon.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemon.Components.Cardmenu
import com.example.littlelemon.Datos.ApiResponse
import com.example.littlelemon.Datos.MenuItemNetwork
import com.example.littlelemon.R
import com.example.littlelemon.ui.theme.LittleLemonColors
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun HomeScreen(){
    var buqueda by remember { mutableStateOf("") }
    val categorys = listOf("Starters", "Mains", "Desserts", "Drinks")
    var datos by remember { mutableStateOf<List<MenuItemNetwork>>(emptyList()) }

    CoroutineScope(Dispatchers.IO).launch { 
        datos = obtenerDatos()
    }


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .padding(20.dp)
                .width(200.dp),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "LittleLemonLogo",
            contentScale = ContentScale.Crop
        )
        Column(
            Modifier
                .background(LittleLemonColors.Prymary)
                .padding(20.dp)
                .fillMaxWidth()

        ) {
            Text(
                text = "Little Lemon",
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                color = LittleLemonColors.Secundary)
            Row {
                Column(modifier = Modifier.fillMaxWidth(0.6f)) {
                    Text(
                        modifier = Modifier.padding(bottom = 10.dp),
                        text = "Chicago",
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        color = LittleLemonColors.Blanco
                    )
                    Text(
                        text = "We are a family owned Mediterranean restaurant, focused on traditional recipes served with a modern twist.",
                        color = LittleLemonColors.Blanco
                    )
                }
                Image(
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .height(150.dp)
                        .width(150.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    painter = painterResource(id = R.drawable.heroimage),
                    contentDescription = "heroImage",
                    contentScale = ContentScale.Crop
                    )

            }
            TextField(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .border(
                        1.dp, LittleLemonColors.Gray,
                        RoundedCornerShape(10.dp)
                    )
                    .height(50.dp)
                    .background(LittleLemonColors.Gray),
                value = buqueda,
                onValueChange = { buqueda = it},
                leadingIcon = {
                    Box{
                        Icon(imageVector = Icons.Filled.Search, contentDescription = "Buscar")
                    }
                },
                label = { Text(text = "Enter Search phrase", textAlign = TextAlign.Center)}
            )
        }
        Text(
            modifier = Modifier
                .padding(top = 25.dp, start = 20.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Left,
            text = "ORDER FOR DELIVERY!",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,

            )
        Row(
            Modifier
                .padding(top = 10.dp, bottom = 10.dp)
                .horizontalScroll(rememberScrollState())
        ) {
            categorys.forEach{ category ->
                Button(
                    onClick = { /* Acción cuando se hace clic */ },
                    shape = RoundedCornerShape(50),
                    modifier = Modifier.padding(horizontal = 10.dp),
                    colors = ButtonDefaults.buttonColors(LittleLemonColors.Gray)
                ) {
                    Text(text = category, color = LittleLemonColors.Prymary)
                }
            }
        }
        LazyColumn {
            items(datos){index ->
                Cardmenu( index.title,index.description,index.price, index.image)
            }
        }
    }
}

private suspend fun obtenerDatos(): List<MenuItemNetwork> {
    return NetworkUtils.httpClient.get("https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json").body<ApiResponse>().menu
}

object NetworkUtils {
    val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(json = Json { ignoreUnknownKeys = true }, contentType = ContentType.Any)
        }
    }
}


