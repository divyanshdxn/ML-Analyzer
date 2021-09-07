package com.dxn.mlkitapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import com.dxn.mlkitapp.Screen
import com.dxn.mlkitapp.ui.components.ScannerCard

@Composable
fun HomeSc(
    scanners: List<Screen>,
    navController: NavController
) {
    Column(
        Modifier
            .padding(0.dp)
            .padding(8.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            text = "MLKit Scanner",
            style = MaterialTheme.typography.h5,
            textAlign = TextAlign.Center
        )
        LazyColumn() {
            items(scanners) { scanner ->
                ScannerCard(scanner) {
                    navController.navigate(scanner.route)
                }
            }
        }
    }

}