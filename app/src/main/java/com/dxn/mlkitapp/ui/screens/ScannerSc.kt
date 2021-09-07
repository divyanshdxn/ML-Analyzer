package com.dxn.mlkitapp.ui.screens

import androidx.camera.core.ImageAnalysis
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dxn.mlkitapp.AnalyzerType
import com.dxn.mlkitapp.helpers.BarcodeScanner
import com.dxn.mlkitapp.helpers.FaceDetector
import com.dxn.mlkitapp.helpers.ObjectAnalyzer
import com.dxn.mlkitapp.helpers.TextAnalyzer
import com.dxn.mlkitapp.ui.components.CameraPreview
import com.dxn.mlkitapp.ui.components.TopBar

@Composable
fun ScannerSc(
    navController: NavController,
    analyzerType: Int,
) {
    var text by remember { mutableStateOf("") }
    val analyzer = getAnalyzer(
        analyzerType = analyzerType,
        onSuccess = {
            text = it
        },
        onError = {

        }
    )
    Box(
        Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
    ) {
        CameraPreview(analyzer.first)
        Text(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .fillMaxSize()
                .align(Alignment.Center)
                .background(Color.Black.copy(0.5f))
                .padding(0.dp)
                .padding(48.dp),
            textAlign = TextAlign.Center,
            color = Color.White,
            text = text
        )
        TopBar(title = analyzer.second, onBackClicked = { navController.popBackStack() }) {}
        Text(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .clickable {

                }
                .align(Alignment.BottomCenter)
                .clip(CircleShape)
                .background(Color.Black.copy(0.4f))
                .padding(16.dp),
            text = "Copy Text",
            textAlign = TextAlign.Center,
            color = Color.White
        )
    }
}


fun getAnalyzer(
    analyzerType: Int,
    onSuccess: (String) -> Unit,
    onError: (Exception) -> Unit
): Pair<ImageAnalysis.Analyzer, String> {
    return when (analyzerType) {
        AnalyzerType.FACE -> {
            Pair(FaceDetector(onSuccess, onError), "Face Detector")
        }
        AnalyzerType.BARCODE -> {
            Pair(BarcodeScanner(onSuccess, onError), "Barcode Scanner")
        }
        AnalyzerType.OBJECT -> {
            Pair(ObjectAnalyzer(onSuccess, onError), "Object Detector")
        }
        else -> {
            Pair(TextAnalyzer(onSuccess, onError), "Text Analyzer")
        }
    }
}