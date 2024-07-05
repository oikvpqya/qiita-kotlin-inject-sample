package me.oikvpqya.playground.di

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import me.oikvpqya.playground.data.AppDatabase
import me.oikvpqya.playground.data.AppDatabase.Companion.DATABASE_NAME
import me.tatarka.inject.annotations.Provides

actual interface RoomDatabasePlatformComponent {

    @ApplicationScope
    @Provides
    fun provideDatabase(): AppDatabase {
        return Room
            .databaseBuilder<AppDatabase>(
                name = DATABASE_NAME,
            )
            .setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
    }
}
