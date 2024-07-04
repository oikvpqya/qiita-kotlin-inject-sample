package me.oikvpqya.playground.di

import me.oikvpqya.playground.ui.AppContent
import me.oikvpqya.playground.ui.AppContentImpl
import me.oikvpqya.playground.ui.AppNavigationFactory
import me.oikvpqya.playground.ui.AppNavigationFactoryImpl
import me.tatarka.inject.annotations.Provides

interface UiComponent : AppContentComponent, AppNavigationFactoryComponent

interface AppContentComponent {

    val appContent: AppContent

    @MainActivityScope
    @Provides
    fun bindAppContent(bind: AppContentImpl): AppContent = bind
}

interface AppNavigationFactoryComponent {

    @MainActivityScope
    @Provides
    fun bindNavigationFactory(bind: AppNavigationFactoryImpl): AppNavigationFactory = bind
}
