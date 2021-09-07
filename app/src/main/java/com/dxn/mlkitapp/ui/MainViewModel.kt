package com.dxn.mlkitapp.ui

import androidx.lifecycle.ViewModel
import com.dxn.mlkitapp.Screen

class MainViewModel : ViewModel() {

    private val scanners = listOf(
        Screen.FaceSc,
        Screen.TextSc,
        Screen.BarcodeSc,
        Screen.ObjectSc
    )

    fun getScanners() = scanners
}
