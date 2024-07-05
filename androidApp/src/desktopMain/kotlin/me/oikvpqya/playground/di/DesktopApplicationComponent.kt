package me.oikvpqya.playground.di

import me.tatarka.inject.annotations.Component

@ApplicationScope
@Component
abstract class DesktopApplicationComponent : SharedApplicationComponent {
    companion object
}
