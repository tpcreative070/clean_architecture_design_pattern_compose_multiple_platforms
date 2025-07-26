package co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms

class WasmPlatform: Platform {
    override val name: String = "Web with Kotlin/Wasm"
}

actual fun getPlatform(): Platform = WasmPlatform()