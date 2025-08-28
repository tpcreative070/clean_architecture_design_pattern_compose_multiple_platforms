package co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.app

import kotlinx.serialization.Serializable

sealed interface Route {

    @Serializable
    data object BookGraph: Route

    @Serializable
    data object BookList: Route

    @Serializable
    data class BookDetail(val id: String): Route
}