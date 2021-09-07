package com.dxn.mlkitapp

import androidx.annotation.DrawableRes


sealed class Screen(val route: String, val title: String,@DrawableRes val imageRes : Int?) {
    object HomeSc : Screen("HOME_SCREEN_ROUTE", "Home",null)
    object FaceSc : Screen("FACE_SCANNER_ROUTE", "Face Detector",R.drawable.face_detection)
    object TextSc : Screen("TEXT_SCANNER_ROUTE", "Text Analyzer",R.drawable.text_detection)
    object BarcodeSc : Screen("BARCODE_SCANNER_ROUTE", "Barcode Scanner",R.drawable.barcode_scanning)
    object ObjectSc : Screen("OBJECT_SCANNER_ROUTE", "Object Detector",R.drawable.object_detection)
}

object AnalyzerType {
    const val FACE = 0
    const val TEXT = 1
    const val BARCODE = 2
    const val OBJECT = 3
}