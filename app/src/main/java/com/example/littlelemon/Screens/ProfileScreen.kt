package com.example.littlelemon.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemon.R
import com.example.littlelemon.ui.theme.LittleLemonColors

@Composable
fun ProfileScreen(firsName: String?, lastName: String?, email: String?, logOutIntent: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .padding(40.dp)
                .width(200.dp),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "LittleLemonLogo",
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp, start = 30.dp, bottom = 50.dp),
        ) {
            Text(
                text = "Personal Information",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = LittleLemonColors.Black)
        }
        Column (Modifier.padding(start = 30.dp, end = 30.dp, bottom = 30.dp)){
            Text( modifier = Modifier.padding(4.dp), text = "First Name")
            if (firsName != null) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(2.dp, color = Color.Black, RoundedCornerShape(10.dp)),
                ) {
                    Text(
                        modifier = Modifier.padding(10.dp),
                        text = firsName,

                        )
                }
            }
        }
        Column (Modifier.padding(start = 30.dp, end = 30.dp, bottom = 30.dp)){
            Text( modifier = Modifier.padding(4.dp), text = "Last Name")
            if (lastName != null) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(2.dp, color = Color.Black, RoundedCornerShape(10.dp)),
                ) {
                    Text(
                        modifier = Modifier.padding(10.dp),
                        text = lastName,
                        )
                }
            }
        }
        Column (Modifier.padding(start = 30.dp, end = 30.dp, bottom = 30.dp)){
            Text( modifier = Modifier.padding(4.dp), text = "Email")
            if (email != null) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(2.dp, color = Color.Black, RoundedCornerShape(10.dp)),
                ) {
                    Text(
                        modifier = Modifier.padding(10.dp),
                        text = email,
                        )
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 30.dp, start = 30.dp, bottom = 40.dp),
            onClick = { logOutIntent() },
            colors = ButtonDefaults.buttonColors(LittleLemonColors.Secundary)
        ) {
            Text(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                text = "Log Out")
        }



    }
}