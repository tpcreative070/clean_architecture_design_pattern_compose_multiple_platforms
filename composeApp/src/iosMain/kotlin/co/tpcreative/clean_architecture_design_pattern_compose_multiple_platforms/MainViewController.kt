package co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms
import co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.app.App
import androidx.compose.ui.window.ComposeUIViewController
import co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin ()
    }
) { App() }