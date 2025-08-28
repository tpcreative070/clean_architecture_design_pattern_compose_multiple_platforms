package co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.book.data.database

import androidx.room.RoomDatabase

expect class DatabaseFactory {
    fun create(): RoomDatabase.Builder<FavoriteBookDatabase>
}