package com.example.tze100

import android.app.Application
import com.example.tze100.di.appComponent
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

open class App : Application() {

    override fun onCreate() {
        super.onCreate()
        configureDi()
    }

    private fun configureDi() =
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appComponent)
        }

}