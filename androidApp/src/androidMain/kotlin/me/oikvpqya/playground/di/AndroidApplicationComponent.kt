package me.oikvpqya.playground.di

import android.content.Context
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides

@ApplicationScope
@Component
abstract class AndroidApplicationComponent(
    @get:Provides val context: Context,
) : SharedApplicationComponent

interface ApplicationComponentProvider {
    val component: AndroidApplicationComponent
}

val Context.applicationComponent get() = (applicationContext as ApplicationComponentProvider).component
