package com.mu54omd.sup

import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.mu54omd.sup.di.initKoin
import com.mu54omd.sup.ui.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Sup",
        state = rememberWindowState(
            size = DpSize(600.dp, 1000.dp)
        )
    ) {
        initKoin()
        App()
    }
}