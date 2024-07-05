package me.oikvpqya.playground.di

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import me.oikvpqya.playground.data.AppDatabase
import me.oikvpqya.playground.data.AppDatabase.Companion.DATABASE_NAME
import me.tatarka.inject.annotations.Provides

actual interface RoomDatabasePlatformComponent {

    @ApplicationScope
    @Provides
    fun provideDatabase(
        context: Context,
    ): AppDatabase {
        val path = context.getDatabasePath(DATABASE_NAME).absolutePath
        return Room
            .databaseBuilder<AppDatabase>(
                context = context,
                name = path,
            )
            .setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
    }
}
