package me.oikvpqya.playground.di

import android.content.Context
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides
import me.tatarka.inject.annotations.Scope

@Scope
annotation class ApplicationScope

@ApplicationScope
@Component
abstract class ApplicationComponent(
    @get:Provides val context: Context,
) : CoilImageLoaderComponent, RoomDatabaseComponent

interface ApplicationComponentProvider {
    val component: ApplicationComponent
}

val Context.applicationComponent get() = (applicationContext as ApplicationComponentProvider).component
