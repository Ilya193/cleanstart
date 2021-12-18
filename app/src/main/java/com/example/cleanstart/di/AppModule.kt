package com.example.cleanstart.di

import com.example.cleanstart.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<MainViewModel> {
        MainViewModel(
            get(),
            get()
        )
    }
}