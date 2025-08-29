package co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.book.data.repository

import androidx.sqlite.SQLiteException
import co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.book.data.database.FavoriteBookDao
import co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.book.data.mappers.toBook
import co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.book.data.mappers.toBookEntity
import co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.book.data.network.RemoteBookDataSource
import co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.book.domain.Book
import co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.book.domain.BookRepository
import co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.core.domain.DataError
import co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.core.domain.EmptyResult
import co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.core.domain.Result
import co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.core.domain.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DefaultBookRepository(
    private val remoteBookDataSource: RemoteBookDataSource,
    private val favoriteBookDao: FavoriteBookDao
): BookRepository {
    override suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote> {
        return remoteBookDataSource
            .searchBooks(query)
            .map { dto ->
                dto.results.map { it.toBook() }
            }
    }

    override suspend fun getBookDescription(bookId: String): Result<String?, DataError> {
        val localResult = favoriteBookDao.getFavoriteBook(bookId)

        return if(localResult == null) {
            remoteBookDataSource
                .getBookDetails(bookId)
                .map { it.description }
        } else {
            Result.Success(localResult.description)
        }
    }

    override fun getFavoriteBooks(): Flow<List<Book>> {
        return favoriteBookDao
            .getFavoriteBooks()
            .map { bookEntities ->
                bookEntities.map { it.toBook() }
            }
    }

    override fun isBookFavorite(id: String): Flow<Boolean> {
        return favoriteBookDao
            .getFavoriteBooks()
            .map { bookEntities ->
                bookEntities.any { it.id == id }
            }
    }

    override suspend fun markAsFavorite(book: Book): EmptyResult<DataError.Local> {
        return try {
            favoriteBookDao.upsert(book.toBookEntity())
            Result.Success(Unit)
        } catch(e: SQLiteException) {
            Result.Error(DataError.Local.DISK_FULL)
        }
    }

    override suspend fun deleteFromFavorites(id: String) {
        favoriteBookDao.deleteFavoriteBook(id)
    }
}