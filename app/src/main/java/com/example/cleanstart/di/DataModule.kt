package com.example.cleanstart.di

import android.content.Context
import com.example.cleanstart.domain.repository.UserRepository
import com.example.cleanstart.domain.usecase.GetUserNameUseCase
import com.example.cleanstart.domain.usecase.SaveUserNameUseCase
import com.example.data.data.repository.UserRepositoryImpl
import com.example.data.data.storage.SharedPrefUserStorage
import com.example.data.data.storage.UserStorage
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideUserStorage(context: Context): UserStorage {
        return SharedPrefUserStorage(context)
    }

    @Provides
    fun provideUserRepositoryImpl(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage)
    }
}