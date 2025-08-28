package co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.book.domain

import kotlinx.coroutines.flow.Flow
import co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.core.domain.DataError
import co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.core.domain.EmptyResult
import co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.core.domain.Result

interface BookRepository {
    suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote>
    suspend fun getBookDescription(bookId: String): Result<String?, DataError>

    fun getFavoriteBooks(): Flow<List<Book>>
    fun isBookFavorite(id: String): Flow<Boolean>
    suspend fun markAsFavorite(book: Book): EmptyResult<DataError.Local>
    suspend fun deleteFromFavorites(id: String)
}