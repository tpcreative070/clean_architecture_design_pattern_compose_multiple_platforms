package co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform