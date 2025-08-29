package co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.book.data.network

import co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.book.data.dto.BookWorkDto
import co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.book.data.dto.SearchResponseDto
import co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.core.domain.DataError
import co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.core.domain.Result


interface RemoteBookDataSource {
    suspend fun searchBooks(
        query: String,
        resultLimit: Int? = null
    ): Result<SearchResponseDto, DataError.Remote>

    suspend fun getBookDetails(bookWorkId: String): Result<BookWorkDto, DataError.Remote>
}