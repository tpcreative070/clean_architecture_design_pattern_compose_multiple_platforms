package co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms

class JVMPlatform: Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
}

actual fun getPlatform(): Platform = JVMPlatform()