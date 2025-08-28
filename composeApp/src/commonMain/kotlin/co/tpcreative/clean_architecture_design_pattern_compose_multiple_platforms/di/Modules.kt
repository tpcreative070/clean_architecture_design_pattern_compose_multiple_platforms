package co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.book.data.database.DatabaseFactory
import co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.book.data.database.FavoriteBookDatabase
import co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.book.data.network.KtorRemoteBookDataSource
import co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.book.data.network.RemoteBookDataSource
import co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.book.data.repository.DefaultBookRepository
import co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.book.domain.BookRepository
import co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.book.presentation.SelectedBookViewModel
import co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.book.presentation.book_detail.BookDetailViewModel
import co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.book.presentation.book_list.BookListViewModel
import co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.core.data.HttpClientFactory

import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }
    singleOf(::KtorRemoteBookDataSource).bind<RemoteBookDataSource>()
    singleOf(::DefaultBookRepository).bind<BookRepository>()

    single {
        get<DatabaseFactory>().create()
            .setDriver(BundledSQLiteDriver())
            .build()
    }
    single { get<FavoriteBookDatabase>().favoriteBookDao }

    viewModelOf(::BookListViewModel)
    viewModelOf(::BookDetailViewModel)
    viewModelOf(::SelectedBookViewModel)
}