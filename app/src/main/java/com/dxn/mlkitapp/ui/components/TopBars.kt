package com.dxn.mlkitapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dxn.mlkitapp.R

@Composable
fun TopBar(
    title: String,
    onBackClicked: () -> Unit,
    onLayoutIconClicked: () -> Unit,
) {
    Row(
        modifier = Modifier
            .background(Color.Transparent)
            .fillMaxWidth()
            .height(48.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(onClick = {
            onBackClicked()
        }) {
            Icon(
                painter = painterResource(id = R.drawable.arrow_back),
                contentDescription = "back buttom",
                tint = Color.White
            )
        }
        Text(
            modifier = Modifier,
            text = title,
            color = Color.White,
            style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold)
        )
        IconButton(onClick = {
            onLayoutIconClicked()
        }) {

        }
    }
}