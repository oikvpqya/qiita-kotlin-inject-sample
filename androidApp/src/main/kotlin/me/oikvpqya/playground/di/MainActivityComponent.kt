package me.oikvpqya.playground.di

import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Scope

@Scope
annotation class MainActivityScope

@MainActivityScope
@Component
abstract class MainActivityComponent(
    @Component val applicationComponent: ApplicationComponent,
) : UiComponent
