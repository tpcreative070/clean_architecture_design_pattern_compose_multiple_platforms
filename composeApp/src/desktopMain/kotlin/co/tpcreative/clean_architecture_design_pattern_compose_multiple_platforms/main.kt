package co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.di.initKoin
import co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.app.App

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "CMP-Bookpedia",
        ) {
            App()
        }
    }
}