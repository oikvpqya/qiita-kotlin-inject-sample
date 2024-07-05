package me.oikvpqya.playground.di

import android.app.Activity
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides

@UiScope
@Component
abstract class MainActivityComponent(
    @get:Provides val activity: Activity,
    @Component val applicationComponent: AndroidApplicationComponent,
) : UiComponent
