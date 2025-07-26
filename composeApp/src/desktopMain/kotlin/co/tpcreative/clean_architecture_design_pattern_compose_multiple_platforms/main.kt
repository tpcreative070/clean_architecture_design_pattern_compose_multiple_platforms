package co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Clean_architecture_design_pattern_compose_multiple_platforms",
    ) {
        App()
    }
}