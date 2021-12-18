package com.example.cleanstart.di

import com.example.cleanstart.domain.usecase.GetUserNameUseCase
import com.example.cleanstart.domain.usecase.SaveUserNameUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetUserNameUseCase> {
        GetUserNameUseCase(get())
    }

    factory<SaveUserNameUseCase> {
        SaveUserNameUseCase(get())
    }
}