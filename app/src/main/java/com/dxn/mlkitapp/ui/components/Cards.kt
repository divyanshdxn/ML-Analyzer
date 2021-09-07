package com.dxn.mlkitapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dxn.mlkitapp.Screen

@Composable
fun ScannerCard(
    scanner: Screen,
    onCLick: () -> Unit
) {
    Card(modifier = Modifier
        .padding(vertical = 8.dp)
        .fillMaxWidth()
        .clickable {
            onCLick()
        },
        shape = RoundedCornerShape(8.dp),
        elevation = 2.dp,
    ) {

        Column(Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier
                    .background(Color(0x66A403D1))
                    .fillMaxWidth()
                    .height(180.dp),
                painter = painterResource(id = scanner.imageRes!!),
                contentScale = ContentScale.Crop,
                contentDescription = ""
            )
            Text(modifier = Modifier.padding(8.dp),text = scanner.title,textAlign = TextAlign.Center)
        }
    }
}