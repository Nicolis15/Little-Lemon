package com.example.littlelemon.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemon.R
import com.example.littlelemon.ui.theme.LittleLemonColors

@Composable
@Preview(showBackground = true)
fun Onboarding(){
    var firstName by remember { mutableStateOf("") }
    var lasttName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Image(
            modifier = Modifier
                .padding(40.dp)
                .width(250.dp),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "LittleLemonLogo",
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = LittleLemonColors.Prymary)
                .padding(50.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                text = "Let's get to know you",
                fontSize = 24.sp,
                color = LittleLemonColors.Blanco)
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp, start = 30.dp, bottom = 50.dp),
        ) {
            Text(
                text = "Let's get to know you",
                fontSize = 18.sp,
                color = LittleLemonColors.Black)
        }
        Column (Modifier.padding(start = 30.dp, end = 30.dp, bottom = 30.dp)){
            Text( modifier = Modifier.padding(4.dp), text = "First Name")
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        1.dp, LittleLemonColors.Black,
                        RoundedCornerShape(10.dp)
                    ),
                value = firstName,
                onValueChange = {firstName = it},
                label = { Text( color = Color.Gray , text = "First Name")},
                colors = OutlinedTextFieldDefaults.colors()
            )
        }
        Column (Modifier.padding(start = 30.dp, end = 30.dp, bottom = 30.dp)){
            Text( modifier = Modifier.padding(4.dp), text = "Last Name")
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        1.dp, LittleLemonColors.Black,
                        RoundedCornerShape(10.dp)
                    ),
                value = lasttName,
                onValueChange = {lasttName = it},
                label = { Text( color = Color.Gray , text = "Last Name")},
                colors = OutlinedTextFieldDefaults.colors()
            )
        }
        Column (Modifier.padding(start = 30.dp, end = 30.dp, bottom = 30.dp)){
            Text( modifier = Modifier.padding(4.dp), text = "Email")
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        1.dp, LittleLemonColors.Black,
                        RoundedCornerShape(10.dp)
                    ),
                value = email,
                onValueChange = {email = it},
                label = { Text( color = Color.Gray , text = "Email")},
                colors = OutlinedTextFieldDefaults.colors()
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 30.dp, start = 30.dp, bottom = 70.dp),
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(LittleLemonColors.Secundary)
        ) {
            Text(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                text = "Regster")
        }



    }
}


