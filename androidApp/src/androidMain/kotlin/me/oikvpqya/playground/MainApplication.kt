package me.oikvpqya.playground

import android.app.Application
import me.oikvpqya.playground.di.AndroidApplicationComponent
import me.oikvpqya.playground.di.ApplicationComponentProvider
import me.oikvpqya.playground.di.create

class MainApplication : Application(), ApplicationComponentProvider {

    override val component by lazy(LazyThreadSafetyMode.NONE) {
        AndroidApplicationComponent::class.create(this)
    }
}
