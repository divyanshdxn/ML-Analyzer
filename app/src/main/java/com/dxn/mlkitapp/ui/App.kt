package com.dxn.mlkitapp.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dxn.mlkitapp.AnalyzerType
import com.dxn.mlkitapp.Screen
import com.dxn.mlkitapp.ui.screens.*

@Composable
fun App() {

    val viewModel: MainViewModel = viewModel()
    val scanners = viewModel.getScanners()

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.HomeSc.route) {
        composable(Screen.HomeSc.route) {
            HomeSc(scanners = scanners, navController = navController)
        }
        composable(Screen.FaceSc.route) {
            ScannerSc(navController = navController, AnalyzerType.FACE)
        }
        composable(Screen.TextSc.route) {
            ScannerSc(navController = navController, AnalyzerType.TEXT)
        }
        composable(Screen.BarcodeSc.route) {
            ScannerSc(navController = navController, AnalyzerType.BARCODE)
        }
        composable(Screen.ObjectSc.route) {
            ScannerSc(navController = navController, AnalyzerType.OBJECT)
        }
    }
}