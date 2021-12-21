package com.example.cleanstart.di

import android.content.Context
import com.example.cleanstart.domain.usecase.GetUserNameUseCase
import com.example.cleanstart.domain.usecase.SaveUserNameUseCase
import com.example.cleanstart.presentation.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context;
    }

    @Provides
    fun provideMainViewModelFactory(
        getUserNameUseCase: GetUserNameUseCase,
        saveUserNameUseCase: SaveUserNameUseCase
    ): MainViewModelFactory {
        return MainViewModelFactory(getUserNameUseCase, saveUserNameUseCase)
    }
}