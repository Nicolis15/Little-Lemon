package com.example.littlelemon.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.littlelemon.R
import com.example.littlelemon.ui.theme.LittleLemonColors

@Composable
fun Cardmenu(title: String, description: String, price: String, image: String) {
    Column(Modifier.fillMaxWidth()) {
        Divider(
            Modifier
                .fillMaxWidth()
                .padding(10.dp),
            thickness = 4.dp,
            color = LittleLemonColors.Gray
        )
        Text(
            modifier = Modifier.padding(5.dp),
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp)
        Row{
            Column(modifier = Modifier.fillMaxWidth(0.70f)) {
                Text(
                    text = description,
                    modifier = Modifier.padding(5.dp))
                Text(
                    text = price.toString(),
                    modifier = Modifier.padding(5.dp))
            }
            Image(
                modifier = Modifier
                    .height(80.dp)
                    .padding(10.dp),
                painter = rememberImagePainter(data = image),
                contentDescription = "bucheta",
                contentScale = ContentScale.Crop
            )
        }
    }
}