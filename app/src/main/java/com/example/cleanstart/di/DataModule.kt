package com.example.cleanstart.di

import android.content.Context
import com.example.cleanstart.domain.repository.UserRepository
import com.example.data.data.repository.UserRepositoryImpl
import com.example.data.data.storage.SharedPrefUserStorage
import com.example.data.data.storage.UserStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage)
    }

    @Provides
    @Singleton
    fun provideUserStorage(@ApplicationContext context: Context) : UserStorage {
        return SharedPrefUserStorage(context)
    }

}