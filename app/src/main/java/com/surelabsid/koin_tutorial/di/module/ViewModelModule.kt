package com.surelabsid.koin_tutorial.di.module

import com.surelabsid.koin_tutorial.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MainViewModel(get(), get())
    }
}
