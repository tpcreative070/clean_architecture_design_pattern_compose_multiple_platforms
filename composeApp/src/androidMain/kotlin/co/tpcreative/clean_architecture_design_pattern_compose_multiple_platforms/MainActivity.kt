package co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.app.App


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App()
        }
    }
}