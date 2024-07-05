package me.oikvpqya.playground.di

import coil3.ImageLoader
import coil3.PlatformContext
import coil3.util.DebugLogger
import me.tatarka.inject.annotations.Provides

interface CoilImageLoaderComponent : CoilImageLoaderPlatformComponent {

    @ApplicationScope
    @Provides
    fun provideImageLoader(
        context: PlatformContext,
    ): ImageLoader {
        return ImageLoader
            .Builder(context)
            .logger(DebugLogger())
            .build()
    }
}
