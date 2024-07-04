package me.oikvpqya.playground.di

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import me.oikvpqya.playground.data.AppDatabase
import me.oikvpqya.playground.data.DatabaseRepository
import me.oikvpqya.playground.data.DatabaseRepositoryImpl
import me.tatarka.inject.annotations.Provides

interface RoomDatabaseComponent {

    @ApplicationScope
    @Provides
    fun provideDatabase(
        context: Context,
    ): AppDatabase {
        val path = context.getDatabasePath("app.db").absolutePath
        return Room
            .databaseBuilder<AppDatabase>(
                context = context,
                name = path,
            )
            .setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
    }

    @ApplicationScope
    @Provides
    fun bindDatabaseRepository(bind: DatabaseRepositoryImpl): DatabaseRepository = bind
}
