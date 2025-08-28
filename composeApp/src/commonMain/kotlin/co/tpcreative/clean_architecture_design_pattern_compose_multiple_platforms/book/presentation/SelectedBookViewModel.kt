package co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.book.presentation

import androidx.lifecycle.ViewModel
import co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.book.domain.Book
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SelectedBookViewModel: ViewModel() {

    private val _selectedBook = MutableStateFlow<Book?>(null)
    val selectedBook = _selectedBook.asStateFlow()

    fun onSelectBook(book: Book?) {
        _selectedBook.value = book
    }
}