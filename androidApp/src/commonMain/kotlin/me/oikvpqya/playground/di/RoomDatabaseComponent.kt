package me.oikvpqya.playground.di

import me.oikvpqya.playground.data.DatabaseRepository
import me.oikvpqya.playground.data.DatabaseRepositoryImpl
import me.tatarka.inject.annotations.Provides

interface RoomDatabaseComponent : RoomDatabasePlatformComponent {

    @ApplicationScope
    @Provides
    fun bindDatabaseRepository(bind: DatabaseRepositoryImpl): DatabaseRepository = bind
}
