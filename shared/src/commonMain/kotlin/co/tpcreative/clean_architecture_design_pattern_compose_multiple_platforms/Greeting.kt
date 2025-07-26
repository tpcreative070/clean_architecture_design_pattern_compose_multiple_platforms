package co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}