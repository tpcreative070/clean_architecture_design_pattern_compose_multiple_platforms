package co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.book.presentation.book_detail

import co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.book.domain.Book


data class BookDetailState(
    val isLoading: Boolean = true,
    val isFavorite: Boolean = false,
    val book: Book? = null
)
