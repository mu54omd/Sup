package com.mu54omd.sup

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.mu54omd.sup.di.initKoin
import com.mu54omd.sup.ui.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Sup",
    ) {
        initKoin()
        App()
    }
}