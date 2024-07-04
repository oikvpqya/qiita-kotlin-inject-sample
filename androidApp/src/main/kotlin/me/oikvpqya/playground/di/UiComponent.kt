package me.oikvpqya.playground.di

import me.oikvpqya.playground.ui.AppContent
import me.oikvpqya.playground.ui.AppContentImpl
import me.oikvpqya.playground.ui.AppNavigation
import me.oikvpqya.playground.ui.AppNavigationImpl
import me.tatarka.inject.annotations.Provides

interface UiComponent : AppContentComponent, AppNavigationComponent

interface AppContentComponent {

    val appContent: AppContent

    @MainActivityScope
    @Provides
    fun bindAppContent(bind: AppContentImpl): AppContent = bind
}

interface AppNavigationComponent {

    @MainActivityScope
    @Provides
    fun bindAppNavigation(bind: AppNavigationImpl): AppNavigation = bind
}
