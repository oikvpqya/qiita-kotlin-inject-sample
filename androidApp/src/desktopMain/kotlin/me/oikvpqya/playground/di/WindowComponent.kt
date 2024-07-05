package me.oikvpqya.playground.di

import me.tatarka.inject.annotations.Component

@UiScope
@Component
abstract class WindowComponent(
    @Component val applicationComponent: DesktopApplicationComponent,
) : UiComponent
