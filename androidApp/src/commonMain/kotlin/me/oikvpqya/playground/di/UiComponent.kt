package me.oikvpqya.playground.di

import me.oikvpqya.playground.ui.AppContent
import me.oikvpqya.playground.ui.AppContentImpl
import me.oikvpqya.playground.ui.AppNavigationFactory
import me.oikvpqya.playground.ui.AppNavigationFactoryImpl
import me.tatarka.inject.annotations.Provides
import me.tatarka.inject.annotations.Scope

interface UiComponent : AppContentComponent, AppNavigationFactoryComponent

interface AppContentComponent {

    val appContent: AppContent

    @Provides
    @UiScope
    fun bindAppContent(bind: AppContentImpl): AppContent = bind
}

interface AppNavigationFactoryComponent {

    @Provides
    @UiScope
    fun bindNavigationFactory(bind: AppNavigationFactoryImpl): AppNavigationFactory = bind
}
