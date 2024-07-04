package me.oikvpqya.playground.di

import android.content.Context
import coil3.ImageLoader
import coil3.util.DebugLogger
import me.tatarka.inject.annotations.Provides

interface CoilImageLoaderComponent {

    @ApplicationScope
    @Provides
    fun provideImageLoader(
        context: Context,
    ): ImageLoader {
        return ImageLoader
            .Builder(context)
            .logger(DebugLogger())
            .build()
    }
}
