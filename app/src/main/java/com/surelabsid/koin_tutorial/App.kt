package com.surelabsid.koin_tutorial

import android.app.Application
import com.surelabsid.koin_tutorial.di.module.appModule
import com.surelabsid.koin_tutorial.di.module.repoModule
import com.surelabsid.koin_tutorial.di.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(appModule, viewModelModule, repoModule))
        }
    }
}