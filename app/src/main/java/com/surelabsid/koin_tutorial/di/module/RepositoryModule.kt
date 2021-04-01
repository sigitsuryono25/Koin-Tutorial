package com.surelabsid.koin_tutorial.di.module

import com.surelabsid.koin_tutorial.data.api.ApiHelper
import com.surelabsid.koin_tutorial.data.api.ApiHelperImpl
import com.surelabsid.koin_tutorial.data.repository.MainRepository
import org.koin.dsl.module

val repoModule = module {
    single { MainRepository(get()) }
    single<ApiHelper> {
        return@single ApiHelperImpl(get())
    }
}