package com.dxn.mlkitapp.helpers

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.common.InputImage
import java.lang.Exception

class BarcodeScanner(
    val onSuccessListener : (String) -> Unit,
    val onErrorListener : (Exception) -> Unit
) : ImageAnalysis.Analyzer {
    var scanner = BarcodeScanning.getClient()

    @SuppressLint("UnsafeExperimentalUsageError", "UnsafeOptInUsageError")
    override fun analyze(imageProxy: ImageProxy) {
        imageProxy.image?.let {
            val inputImage = InputImage.fromMediaImage(
                it,
                imageProxy.imageInfo.rotationDegrees
            )

            scanner.process(inputImage)
                .addOnSuccessListener { codes ->
                    codes.forEach { barcode ->
//                        val bAnalyzer= Bundle()
//                        bAnalyzer.putString("Analyzer_key","Format = ${barcode.format}  Value = ${barcode.rawValue}")
                        onSuccessListener(barcode?.rawValue+"")
                    }
                }
                .addOnFailureListener { ex ->
                    onErrorListener(ex)
                }
                .addOnCompleteListener {
                    imageProxy.close()
                }

        } ?: imageProxy.close()
    }
}