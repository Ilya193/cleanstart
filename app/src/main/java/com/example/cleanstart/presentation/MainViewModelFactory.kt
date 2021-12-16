package com.example.cleanstart.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanstart.domain.usecase.GetUserNameUseCase
import com.example.cleanstart.domain.usecase.SaveUserNameUseCase
import com.example.data.data.repository.UserRepositoryImpl
import com.example.data.data.storage.SharedPrefUserStorage

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {
    private val userRepository by lazy { UserRepositoryImpl(SharedPrefUserStorage(context)) }
    private val getUserNameUseCase by lazy { GetUserNameUseCase(userRepository) }
    private val saveUserNameUseCase by lazy { SaveUserNameUseCase(userRepository) }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getUserNameUseCase, saveUserNameUseCase) as T
    }
}