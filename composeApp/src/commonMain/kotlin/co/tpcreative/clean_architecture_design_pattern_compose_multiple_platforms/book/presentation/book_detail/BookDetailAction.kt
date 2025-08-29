package co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.book.presentation.book_detail

import co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.book.domain.Book


sealed interface BookDetailAction {
    data object OnBackClick: BookDetailAction
    data object OnFavoriteClick: BookDetailAction
    data class OnSelectedBookChange(val book: Book): BookDetailAction
}