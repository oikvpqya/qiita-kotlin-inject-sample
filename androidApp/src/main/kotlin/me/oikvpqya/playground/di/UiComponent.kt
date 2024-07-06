package me.oikvpqya.playground.di

import me.oikvpqya.playground.ui.AppContent
import me.oikvpqya.playground.ui.AppContentImpl
import me.oikvpqya.playground.ui.AppRouteFactory
import me.oikvpqya.playground.ui.HomeRouteFactory
import me.oikvpqya.playground.ui.ImageRouteFactory
import me.tatarka.inject.annotations.IntoSet
import me.tatarka.inject.annotations.Provides

interface UiComponent : AppContentComponent, AppRouteFactoryComponent

interface AppContentComponent {

    val appContent: AppContent

    @MainActivityScope
    @Provides
    fun bindAppContent(bind: AppContentImpl): AppContent = bind
}

interface AppRouteFactoryComponent {

    @IntoSet
    @MainActivityScope
    @Provides
    fun bindHomeRouteFactory(bind: HomeRouteFactory): AppRouteFactory = bind

    @IntoSet
    @MainActivityScope
    @Provides
    fun bindImageRouteFactory(bind: ImageRouteFactory): AppRouteFactory = bind
}
