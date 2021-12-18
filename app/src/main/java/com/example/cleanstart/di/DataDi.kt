package com.example.cleanstart.di

import com.example.cleanstart.domain.repository.UserRepository
import com.example.data.data.repository.UserRepositoryImpl
import com.example.data.data.storage.SharedPrefUserStorage
import com.example.data.data.storage.UserStorage
import org.koin.dsl.module

val dataModule = module {
    single<UserStorage> {
        SharedPrefUserStorage(get())
    }

    single<UserRepository> {
        UserRepositoryImpl(get())
    }
}