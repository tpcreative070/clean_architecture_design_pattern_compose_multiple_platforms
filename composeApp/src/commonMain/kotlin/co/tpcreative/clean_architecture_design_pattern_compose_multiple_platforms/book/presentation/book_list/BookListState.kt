package co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.book.presentation.book_list

import co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.book.domain.Book
import co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.core.presentation.UiText


data class BookListState(
    val searchQuery: String = "Kotlin",
    val searchResults: List<Book> = emptyList(),
    val favoriteBooks: List<Book> = emptyList(),
    val isLoading: Boolean = true,
    val selectedTabIndex: Int = 0,
    val errorMessage: UiText? = null
)