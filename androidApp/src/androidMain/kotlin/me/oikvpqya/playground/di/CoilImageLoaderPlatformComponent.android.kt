package me.oikvpqya.playground.di

import android.content.Context
import coil3.PlatformContext
import me.tatarka.inject.annotations.Provides

actual interface CoilImageLoaderPlatformComponent {

    @ApplicationScope
    @Provides
    fun providePlatformContext(
        context: Context
    ): PlatformContext {
        return context
    }
}
