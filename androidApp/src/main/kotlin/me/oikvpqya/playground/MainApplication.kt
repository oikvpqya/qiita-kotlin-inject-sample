package me.oikvpqya.playground

import android.app.Application
import me.oikvpqya.playground.di.ApplicationComponent
import me.oikvpqya.playground.di.ApplicationComponentProvider
import me.oikvpqya.playground.di.create

class MainApplication : Application(), ApplicationComponentProvider {

    override val component by lazy(LazyThreadSafetyMode.NONE) {
        ApplicationComponent::class.create(this)
    }
}
