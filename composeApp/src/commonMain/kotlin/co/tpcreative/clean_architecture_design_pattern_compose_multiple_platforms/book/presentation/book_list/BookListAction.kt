package co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.book.presentation.book_list

import co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.book.domain.Book


sealed interface BookListAction {
    data class OnSearchQueryChange(val query: String): BookListAction
    data class OnBookClick(val book: Book): BookListAction
    data class OnTabSelected(val index: Int): BookListAction
}