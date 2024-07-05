package me.oikvpqya.playground.di

import coil3.PlatformContext
import me.tatarka.inject.annotations.Provides

actual interface CoilImageLoaderPlatformComponent {

    @ApplicationScope
    @Provides
    fun providePlatformContext(): PlatformContext {
        return PlatformContext.INSTANCE
    }
}
